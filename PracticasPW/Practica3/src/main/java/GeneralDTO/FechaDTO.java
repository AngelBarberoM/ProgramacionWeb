package GeneralDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaDTO {

	//VARIABLES
		private int  Id; 
		
		private LocalDateTime Fecha;

		
		//CONSTRUCTOR VACIO
		
		public FechaDTO(){}
		
		////CONSTRUCTOR PARAMETRIZADO

		public FechaDTO(int id, LocalDateTime fecha){
			
			this.Id=id; 
			
			this.Fecha=fecha;
		}
		
		//OBSERVADORES
		
		public int getId(){
			
			return this.Id; 
		}
		
		
		public LocalDateTime getFecha(){
			
			return this.Fecha; 
		}
		
		public String getFechaString(){
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); 
			String formattedDateTime = this.getFecha().format(formatter);
			
			return formattedDateTime; 
		}
		
		
		//MODIFICADORES
		
		public void setId(int Id){
			
			this.Id = Id; 
		}
		
		public void setFecha(LocalDateTime Fecha){
			
			this.Fecha = Fecha; 
		}
}
