package GeneralDTO;
import java.util.ArrayList;

public class EspectaculoDTO {

	//VARIABLES
	
		private int Id;
		
		private String Tipo; 
		
		private String Nombre;  
		
		private String Contenido; 
		
		private int LocalidadesTotales; 
		
		private int LocalidadesVendidas; 
		
		private ArrayList<Integer> Critica;
		
		//CONSTRUCTOR VACIO
		
		public EspectaculoDTO(){};

		
		////CONSTRUCTOR PARAMETRIZADO
		

		public EspectaculoDTO(int Id, String Nombre, String Tipo, String Contenido, int LocalidadesTotales, int LocalidadesVendidas){
			
			this.Id = Id;
			this.Tipo=Tipo; 
			this.Nombre = Nombre; 
			this.Contenido = Contenido;
			this.LocalidadesTotales = LocalidadesTotales;
			this.LocalidadesVendidas = LocalidadesVendidas;
			this.Critica= new ArrayList<Integer>();
		}
		
		//OBSERVADORES
		
		public int getId(){
			
			return this.Id; 
		}
		
		
		public String getTipo(){
			
			return this.Tipo; 
		}
		
		
		public String getNombre(){
			
			return this.Nombre; 
		}
		
		
		public String getContenido(){
			
			return Contenido; 
		}
		
		
		
		public int getLocalidadesTotales(){
			
			return this.LocalidadesTotales; 
		}
		
		
		public int getLocalidadesVendidas(){
			
			return this.LocalidadesVendidas; 
		}
		
		public ArrayList<Integer> getCritica() {
			return this.Critica;
		}
		
		
		//MODIFICADORES
		
		
		public void setId(int Id){
			
			this.Id=Id; 
		}
		
		
		public void setTipo(String Tipo){
			
			this.Tipo=Tipo; 
		}
		
		
		public void setNombre(String Nombre){
			
			this.Nombre = Nombre; 
		}
		
		public void setContenido(String Contenido){
			
			this.Contenido=Contenido; 
		}
		

		public void setLocalidadesTotales(int LocalidadesTotales){
			
			this.LocalidadesTotales=LocalidadesTotales;
		}
		
		
		public void setLocalidadesVendidas(int LocalidadesVendidas){
			
			this.LocalidadesVendidas=LocalidadesVendidas; 
		}
		
		public void setCritica(ArrayList<Integer> Critica) {
			
			this.Critica = Critica;
		}
}
