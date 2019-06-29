package br.com.calcard.enums;

public enum EstadoCivilEnum {
	
	SOLTEIRO{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Solteiro(a)";
		}
	},
	
	CASADO {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Casado(a)";
		}
	},
	
	DIVORCIADO {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Divorciado(a)";
		}
	},
	
	VIUVO {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Viúvo(a)";
		}
	}

}
