package General;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EspectaculoPaseMultiple extends Espectaculo {
	
	private ArrayList<LocalDateTime> Pase;

	private String Tipo; 
	
	//CONSTRUCTOR VACIO
	
	public EspectaculoPaseMultiple(){}
	
	//OBSERVADOR
	
	public ArrayList<LocalDateTime> getPase() {
		
		return this.Pase;
	}

	
	//MODIFICADOR
	
	public void setPase(ArrayList<LocalDateTime> pase) {
		
		this.Pase = pase;
	}
	
	public String getTipo(){
		
		return this.Tipo; 
	}
	public void setTipo(String Tipo){
		
		this.Tipo=Tipo; 
	}
}

