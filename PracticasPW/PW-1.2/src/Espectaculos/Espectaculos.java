package Espectaculos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import General.EspectaculoPaseMultiple;
import General.EspectaculoPuntual;
import General.EspectaculoTemporada;

public class Espectaculos {
	

	private static Espectaculos Instancia = null;
	
	private FunEspectaculos critica = new FunEspectaculos(); 
	
	private String correo = null;
	
	
	private Espectaculos(String correo){
		
		this.setCorreo(correo);
	}

	/**
	 * Funcion para inicializar las criticas. 
	 * Escribe en el fichero PropiedadesDatos la ruta del fichero de Criticas
	 * @param Correo del usuario
	 * @return Instancia
	 */
	public static Espectaculos getInstancia(String correo) {
		
		if(Instancia == null){
			
			Instancia = new Espectaculos(correo);
			
			try {
				
				String Path = new File("").getAbsolutePath();
				Path = Path + "/PropiedadesDatos";
				File Archivo = new File(Path);
				Properties Tabla = new Properties();
				FileInputStream in = new FileInputStream(Archivo);
				Tabla.load(in);
				in.close();
				String RutaTotal = new File("").getAbsolutePath();
				String RutaFich = RutaTotal + "/Espectaculos.txt";
				Tabla.setProperty("EspectaculosFilePath", RutaFich);		
				FileOutputStream FR = new FileOutputStream(Archivo);
		        Tabla.store(FR, "Propiedades");
		        FR.close();
			
			} catch (Exception Excep) {
				
				Excep.printStackTrace();
			}
		}
		return Instancia;
	}
	
	/**
	 * Funciones que crean un espectaculo
	 * 
	 * @param critica Objeto de la clase critica
	 */	
	
	public void CrearEspectaculoPuntual(EspectaculoPuntual especPuntual){
		
		if(Instancia!=null){
			
			this.critica.EspectaculoPuntualToFich(especPuntual.getNombre(),especPuntual.getTipo(), especPuntual.getContenido(), especPuntual.getLocalidadesTotales(), especPuntual.getLocalidadesVendidas(), especPuntual.getFecha(), especPuntual.getCritica());
		}
	}
	
	public void CrearEspectaculoPaseMultiple(EspectaculoPaseMultiple especPaseMultiple){
		
		if(Instancia!=null){
		
			this.critica.EspectaculoPaseMultipleToFich(especPaseMultiple.getNombre(),especPaseMultiple.getTipo(), especPaseMultiple.getContenido(), especPaseMultiple.getLocalidadesTotales(), especPaseMultiple.getLocalidadesVendidas(), especPaseMultiple.getPase(), especPaseMultiple.getCritica());
		}
	}
	
	public void CrearEspectaculoTemporada(EspectaculoTemporada especTemporada){
		
		if(Instancia!=null){
		
			this.critica.EspectaculoTemporadaToFich(especTemporada.getNombre(),especTemporada.getTipo(), especTemporada.getContenido(), especTemporada.getLocalidadesTotales(), especTemporada.getLocalidadesVendidas(), especTemporada.getInicioFecha(), especTemporada.getFinalFecha(), especTemporada.getFecha(), especTemporada.getCritica());
		}
	}
	
	
	
	/**
	 * Funciones que imprimen por 
	 * pantalla todos los espectaculos
	 * 
	 */	
	
	public void consultarEspectaculoPuntual(){
		
		if(Instancia!=null){
			
			this.critica.imprimirEspectaculoPuntual();
		}
	}
	
	public void consultarEspectaculoPaseMultiple(){
		
		if(Instancia!=null){
		
			this.critica.imprimirEspectaculoPaseMultiple();
		}
	}
	
	public void consultarEspectaculoTemporada(){
		
		if(Instancia!=null){
		
			this.critica.imprimirEspectaculoTemporada();
		}
	}
	
	
	/**
	 * Funciones que busca un espectaculo
	 * 
	 * @param critica Objeto de la clase critica
	 */	
	
	public void buscarEspectaculoPuntual(String nombre){
		
		if(Instancia!=null){
			
			this.critica.comprobarExisteEspectaculoPuntual(nombre);
		}
	}
	
	public void buscarEspectaculoPaseMultiple(String nombre){
		
		if(Instancia!=null){
			
			this.critica.comprobarExisteEspectaculoPaseMultiple(nombre);
		}
	}
	
	public void buscarEspectaculoTemporada(String nombre){
		
		if(Instancia!=null){
			
			this.critica.comprobarExisteEspectaculoTemporada(nombre);
		}
	}
	
	/**
	 * Funciones que borra un espectaculo
	 * 
	 * @param critica Objeto de la clase critica
	 */
	
	public void BorrarEspectaculoPuntual(String nombre){
	
		if(Instancia!=null){
			
			this.critica.borrarEspectaculoPuntual(nombre);
		}
	}
	
	public void BorrarEspectaculoPaseMultiple(String nombre){
	
		if(Instancia!=null) {
			
			this.critica.borrarEspectaculoPaseMultiple(nombre);
		}
	}
	public void BorrarEspectaculoTemporada(String nombre){
		
		if(Instancia!=null) {
			
			this.critica.borrarEspectaculoTemporada(nombre);
		}
	}
	
	/**
	 * Funciones que muestra las localidades 
	 * disponibles de un espectaculo
	 * 
	 * @param critica Objeto de la clase critica
	 */
	
	public void localidadesDisponiblesEspectaculoPuntual(){
	
		if(Instancia!=null){
		
			this.critica.localidadesDisponiblesEspectaculoPuntual();
		}
	}
	
	public void localidadesDisponiblesEspectaculoPaseMultiple(){
	
		if(Instancia!=null){
			
			this.critica.localidadesDisponiblesEspectaculoPaseMultiple();
		}
	}
	
	public void localidadesDisponiblesEspectaculoTemporada(){
	
		if(Instancia!=null){
			
			this.critica.localidadesDisponiblesEspectaculoTemporada();
		}
	}
	
	/**
	 * Funciones que busca 
	 * la categoria de un espectaculo
	 * 
	 * @param critica Objeto de la clase critica
	 */
	
	public void buscarCategoriaEspectaculoPuntual(String categoria){
		
		if(Instancia!=null){
			
			this.critica.buscarCategoriaEspectaculoPuntual(categoria);
		}
	}
	
	public void buscarCategoriaEspectaculoPaseMultiple(String categoria){
		
		if(Instancia!=null){
			
			this.critica.buscarCategoriaEspectaculoPaseMultiple(categoria);
		}
	}
	
	public void buscarCategoriaEspectaculoTemporada(String categoria){
	
		if(Instancia!=null){
			
			this.critica.buscarCategoriaEspectaculoTemporada(categoria);
		}
	}
	
	/**
	 * Funciones que actualiza un espectaculo
	 * 
	 * @param critica Objeto de la clase critica
	 */
	
	public void actualizarEspectaculoPuntual(String nombre){
		
		if(Instancia!=null){
			
			this.critica.actualizarEspectaculoPuntual(nombre);
		}
	}
	
	public void actualizarEspectaculoPaseMultiple(String nombre){
		
		if(Instancia!=null){
			
			this.critica.actualizarEspectaculoPaseMultiple(nombre);
		}
	}
	
	public void actualizarEspectaculoTemporada(String nombre){
		
		if(Instancia!=null){
			
			this.critica.actualizarEspectaculoTemporada(nombre);
		}
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}