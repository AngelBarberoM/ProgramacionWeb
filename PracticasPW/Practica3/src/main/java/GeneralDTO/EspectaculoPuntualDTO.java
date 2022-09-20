package GeneralDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EspectaculoPuntualDTO extends EspectaculoDTO{

	//VARIABLE
	
		private LocalDateTime Fecha;
		
		
		//CONSTRUCTOR VACIO
		
		public EspectaculoPuntualDTO(){}
		
		
		//CONSTRUCTOR PARAMETRIZADO

		public EspectaculoPuntualDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,LocalDateTime fecha) {
			
			super(id, titulo, categoria,descripcion, localidades_venta, localidades_vendidas);
			
			this.Fecha = fecha; 
		}

		
		//OBSERVADORES
		
		public LocalDateTime getFecha() {
		
			return this.Fecha;
		}
		
		
		public String getFechaToString(){
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); 
			String formattedDateTime = this.getFecha().format(formatter);
			
			return formattedDateTime; 
		}
		
		
		//MODIFICADOR
		
		public void setFecha(LocalDateTime Fecha) {
			
			this.Fecha = Fecha;
		}
}
