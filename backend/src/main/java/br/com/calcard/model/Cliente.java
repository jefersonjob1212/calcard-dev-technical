package br.com.calcard.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.calcard.enums.EstadoCivilEnum;
import br.com.calcard.enums.SexoEnum;

@Entity
public class Cliente {

	@Id
	@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq")
	@GeneratedValue(generator = "cliente_seq", strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private Integer idade;
	
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	
	@Enumerated(EnumType.STRING)
	private EstadoCivilEnum estadoCivil;
	
	private String estado;
	
	private Integer dependentes;
	
	private BigDecimal renda;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
}
