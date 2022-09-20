package GeneralDTO;

public class VotanteDTO {

	//VARIABLES
	
		private String PersonaVota;
		
		private int Id;
		
		private String VotoPersona;
		

		//CONSTRUCTOR VACIO
		
		public VotanteDTO(){}
		
		
		//CONSTRUCTOR PARAMETRIZADO
		
		public VotanteDTO(String PersonaVota, int Id, String VotoPersona){
			
			this.PersonaVota=PersonaVota; 
			this.Id=Id;
			this.VotoPersona = VotoPersona;
		}
		
		//OBSERVADORES

		public String getPersonaVota() {
			
			return PersonaVota;
		}

		
		public int getId() {
			
			return Id;
		}
		
		
		public String getVotoPersona() {
			
			return VotoPersona;
		}
		
		
		//MODIFICADORES
			
		public void setPersonaVota(String PersonaVota) {
			
			this.PersonaVota = PersonaVota;
		}
		
		
		public void setId(int Id) {
			
			this.Id = Id;
		}
		
		
		public void setVotoPersona(String VotoPersona) {
			
			this.VotoPersona = VotoPersona;
		}
}
