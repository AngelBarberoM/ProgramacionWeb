package GeneralDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaseDTO {

	//VARIABLES
	
		private int  Id; 
		
		private LocalDateTime InicioFecha;
		
		private String Dia;
		
		private LocalDateTime FinalFecha;
		
		//CONSTRUCTOR VACIO

		public PaseDTO(){}
		
		//CONSTRUCTOR PARAMETRIZADO
		
		public PaseDTO(int Id, LocalDateTime InicioFecha, String Dia, LocalDateTime FinalFecha){
			
			this.Id=Id; 
			this.InicioFecha = InicioFecha;
			this.Dia = Dia;
			this.FinalFecha = FinalFecha;
		}
		
		
		//OBSERVADORES
		
		public int getId(){
			
			return this.Id; 
		}
		
		
		public LocalDateTime getInicioFecha(){
			
			return this.InicioFecha; 
		}
		
		
		public String getInicioFechaToString(){
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); 
			String formattedDateTime = this.getInicioFecha().format(formatter);
			
			return formattedDateTime; 
		}
		
		
		public LocalDateTime getFinalFecha(){
			
			return this.FinalFecha; 
		}
		
		public String getFinalFechaToString(){
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); 
			String formattedDateTime = this.getFinalFecha().format(formatter);
			
			return formattedDateTime; 
		}

		
		public String getDiaSemana(){
			
			return this.Dia; 
		}
		

		//MODIFICADORES
		
		public void setId(int Id){
		
			this.Id = Id; 
		}
		
		
		public void setInicioFecha(LocalDateTime InicioFecha){
			
			this.InicioFecha = InicioFecha; 
		}
		

		public void setDia(String dia){
			
			this.Dia = dia; 
		}
		
		
		public void setFinalFecha(LocalDateTime FinalFecha){
			
			this.FinalFecha = FinalFecha; 
		}
}
