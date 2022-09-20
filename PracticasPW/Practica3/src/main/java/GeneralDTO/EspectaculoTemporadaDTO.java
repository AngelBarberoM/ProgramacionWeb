package GeneralDTO;
import java.util.ArrayList;

public class EspectaculoTemporadaDTO extends EspectaculoDTO{

	//VARIABLE
	
		private ArrayList<PaseDTO> Pase;
		
		
		//CONSTRUCTOR VACIO
		
		public EspectaculoTemporadaDTO(){}
		

		//CONSTRUCTORES PARAMETRIZADO
		
		public EspectaculoTemporadaDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas,ArrayList<PaseDTO> pase ){
			
			super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendidas); 
			
			this.Pase = pase; 
		}
		
		
		public EspectaculoTemporadaDTO(int id, String titulo, String categoria,String descripcion, int localidades_venta, int localidades_vendidas){
			
			super(id,titulo,categoria,descripcion, localidades_venta, localidades_vendidas); 
		}

		
		//OBSERVADORES

		public ArrayList<PaseDTO> getPase() {
			
			return this.Pase;
		}
		
		
		//MODIFICADORES
		public void setPase(ArrayList<PaseDTO> Pase) {
			
			this.Pase = Pase;
		}
}
