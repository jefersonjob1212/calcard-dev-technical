package br.com.calcard.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.calcard.dto.AnaliseDTO;
import br.com.calcard.dto.ClienteDTO;
import br.com.calcard.model.Analise;
import br.com.calcard.repository.AnaliseRepository;
import br.com.calcard.service.AnaliseService;

@Service
public class AnaliseServiceImpl implements AnaliseService {

	@Autowired
	private AnaliseRepository repository;

	private Analise model;

	private AnaliseDTO modelDTO;

	private ModelMapper mapper;

	public AnaliseServiceImpl() {
		// TODO Auto-generated constructor stub
		this.mapper = new ModelMapper();
	}

	@Override
	public AnaliseDTO findByClienteCpf(String cpf) {
		// TODO Auto-generated method stub
		modelDTO = mapper.map(repository.findByClienteCpf(cpf.replaceAll("[^0-9]", "")), AnaliseDTO.class);
		return modelDTO;
	}

	@Override
	public AnaliseDTO analisarCreditoCliente(ClienteDTO clienteDTO) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("R$ #,##0.00");
		clienteDTO.setCpf(clienteDTO.getCpf().replaceAll("[^0-9]", ""));
		modelDTO = new AnaliseDTO();
		modelDTO.setCliente(clienteDTO);
		BigDecimal taxaComprometimento = new BigDecimal(0.3);
		BigDecimal taxaCalculada = clienteDTO.getRenda().multiply(taxaComprometimento).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal limiteLiberado = new BigDecimal(0);

		if(clienteDTO.getRenda().compareTo(new BigDecimal(1000)) < 0) {
			modelDTO.setResultado(false);
			modelDTO.setLimite(df.format(0));
			modelDTO.setMotivo("Renda baixa");
		} 

		else {
			if(clienteDTO.getRenda().doubleValue() >= 1000 
					&& clienteDTO.getRenda().doubleValue() < 5000 
					&& clienteDTO.getIdade() >= 45 
					&& clienteDTO.getDependentes() > 0) {
				modelDTO.setResultado(false);
				modelDTO.setLimite(df.format(0));
				modelDTO.setMotivo("Reprovado pelas Políticas de Crédito");
			}

			else {
				modelDTO.setResultado(true);
				switch (clienteDTO.getDependentes()) {
				case 0:
					limiteLiberado = taxaCalculada;
					break;

				case 1:
					if(clienteDTO.getRenda().doubleValue() >= 1000 && clienteDTO.getRenda().doubleValue() < 2000) {	
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.6));		
					} else if(clienteDTO.getRenda().doubleValue() >= 2000 && clienteDTO.getRenda().doubleValue() < 5000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.8));					
					} else if(clienteDTO.getRenda().doubleValue() >= 5000 && clienteDTO.getRenda().doubleValue() < 8000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(1.2));		
					}
					else
						limiteLiberado = taxaCalculada;
					break;

				case 2:
					if(clienteDTO.getRenda().doubleValue() >= 1000 && clienteDTO.getRenda().doubleValue() < 2000) {	
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.5));		
					} else if(clienteDTO.getRenda().doubleValue() >= 2000 && clienteDTO.getRenda().doubleValue() < 5000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.6));					
					}
					else
						limiteLiberado = taxaCalculada;
					break;	

				case 3:
					if(clienteDTO.getRenda().doubleValue() >= 1000 && clienteDTO.getRenda().doubleValue() < 2000) {	
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.3));		
					} else if(clienteDTO.getRenda().doubleValue() >= 2000 && clienteDTO.getRenda().doubleValue() < 5000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.4));					
					} else if(clienteDTO.getRenda().doubleValue() >= 5000 && clienteDTO.getRenda().doubleValue() < 8000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.8));		
					}
					else
						limiteLiberado = taxaCalculada;
					break;

				default:
					if(clienteDTO.getRenda().doubleValue() >= 1000 && clienteDTO.getRenda().doubleValue() < 2000) {	
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.1));		
					} else if(clienteDTO.getRenda().doubleValue() >= 2000 && clienteDTO.getRenda().doubleValue() < 5000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.2));					
					} else if(clienteDTO.getRenda().doubleValue() >= 5000 && clienteDTO.getRenda().doubleValue() <= 8000) {
						limiteLiberado = taxaCalculada.multiply(new BigDecimal(0.5));		
					}
					else
						limiteLiberado = taxaCalculada;
					break;
				}
				
				if(limiteLiberado.doubleValue() >= 100 && limiteLiberado.doubleValue() < 500)
					modelDTO.setMotivo("Entre 100 - 500");
				
				else if(limiteLiberado.doubleValue() >= 500 && limiteLiberado.doubleValue() < 1000)
					modelDTO.setMotivo("Entre 500 - 1000");
				
				else if(limiteLiberado.doubleValue() >= 1000 && limiteLiberado.doubleValue() < 1500)
					modelDTO.setMotivo("Entre 1000 - 1500");
				
				else if(limiteLiberado.doubleValue() >= 1500 && limiteLiberado.doubleValue() < 2000)
					modelDTO.setMotivo("Entre 1500 - 2000");
				else
					modelDTO.setMotivo("Superior a 2000");
				
				modelDTO.setLimite(df.format(limiteLiberado));
			}
		}
		model = mapper.map(modelDTO, Analise.class);
		Analise modelResponse = repository.save(model);
		return mapper.map(modelResponse, AnaliseDTO.class);
	}

	@Override
	public List<AnaliseDTO> findAll() {
		// TODO Auto-generated method stub
		return repository
					.findAll(Sort.by(Sort.Direction.ASC, "cliente.nome"))
					.stream()
					.map(entity -> mapper.map(entity, AnaliseDTO.class))
					.collect(Collectors.toList());
	}
}