package General;
import java.time.LocalDateTime;

public class EspectaculoPuntual extends Espectaculo {

	private LocalDateTime Fecha;

	//CONSTRUCTOR VACIO
	
	public EspectaculoPuntual() {}
	
	//OBSERVADOR
	
	public LocalDateTime getFecha() {
		
		return this.Fecha;
	}
	
	//MODIFICADOR
	
	public void setFecha(LocalDateTime fecha) {
		
		this.Fecha = fecha;
	}
	
}
