package General_DTO;
import java.util.ArrayList;

public class EspectaculoPaseMultipleDTO extends EspectaculoDTO{
	//VARIABLE
	
	private ArrayList<FechaDTO> Fecha;
	
	
	//CONSTRUCTOR VACIO
	
	public EspectaculoPaseMultipleDTO() {}
	
	
	//CONSTRUCTOR PARAMETRIZADO
	
	public EspectaculoPaseMultipleDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendida, ArrayList<FechaDTO> fecha) {
		
		super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendida); 
		
		this.Fecha = fecha;
	}
	
	
	//CONSTRUCTOR PARAMETRIZADO
	 
	public EspectaculoPaseMultipleDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas) {
		
		super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendidas); 
	}
	
	
	//OBSERVADOR
	
	public ArrayList<FechaDTO> getFecha() {
		
		return this.Fecha;
	}
	
	
	//MODIFICADOR
	
	public void setFecha(ArrayList<FechaDTO> fecha) {
		
		this.Fecha = fecha;
	}
}
