package General;
import java.util.ArrayList;

import Espectaculos.FunEspectaculos;


public class Espectaculo extends FunEspectaculos{


	private String Tipo; 
	
	private String Nombre;  
	
	private String Contenido; 
	
	private int LocalidadesTotales; 
	
	private int LocalidadesVendidas; 
	
	private ArrayList<Integer> Critica;
	

	//CONSTRUCTOR VACIO
	
	public Espectaculo(){};
	

	////CONSTRUCTOR PARAMETRIZADO
	
	public Espectaculo(String Nombre, String Tipo, String Contenido){

		this.Tipo=Tipo; 
		this.Nombre = Nombre; 
		this.Contenido = Contenido;
		this.LocalidadesTotales=0; 
		this.LocalidadesVendidas=0;
		this.Critica= new ArrayList<Integer>();
	}
	
	//OBSERVADORES
	
	
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
	
	
	public void setCritica(ArrayList<Integer> critica){
		
		this.Critica = critica;
	}
			
}
