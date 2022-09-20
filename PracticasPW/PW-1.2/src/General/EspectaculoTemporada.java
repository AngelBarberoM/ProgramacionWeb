package General;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoTemporada extends Espectaculo{
	
	private LocalDateTime InicioFecha;
	
	private LocalDateTime FinalFecha;
	
	private ArrayList<LocalDateTime> Fecha;
	
	
	//CONSTRUCTOR VACIO
	
	public EspectaculoTemporada(){}
	
	
	//OBSERVADORES
	public LocalDateTime getInicioFecha(){
		
		return this.InicioFecha;
	}
	
	public LocalDateTime getFinalFecha(){
		
		return this.FinalFecha;
	}

	public ArrayList<LocalDateTime> getFecha(){
		
		return this.Fecha;
	}
	
	
	//MODIFICACORES
	
	public void setInicioFecha(LocalDateTime iniciofecha){
		
		this.InicioFecha = iniciofecha;
	}
	
	public void setFinalFecha(LocalDateTime finfecha){
		
		this.FinalFecha = finfecha;
	}
	
	public void setFecha(ArrayList<LocalDateTime> fecha){
		
		this.Fecha = fecha;
	}
}
