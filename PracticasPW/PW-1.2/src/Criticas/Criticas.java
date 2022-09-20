package Criticas;

import General.Critica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Clase que llama a todas 
 * las funciones  de criticas.
 */	
public class Criticas {

	/** 
 	* Instancia de criticas
 	*/
	private static Criticas Instancia = null;
	
	/**
	 * Correo del usuario
	 */
	private String correo = null;
	
	/**
	 * Clase FunCriticas para llamar a las funciones.
	 */
	private FunCriticas critica = new FunCriticas(); 

	/**
	 * Constructor privado
	 * @param Correo Correo del usuario
	 */
	private Criticas(String correo){
		
		this.correo=correo; 
	}

	/**
	 * Funcion para inicializar las criticas. 
	 * Escribe en el fichero PropiedadesDatos la ruta del fichero de Criticas
	 * @param Correo del usuario
	 * @return Instancia
	 */
	public static Criticas getInstancia(String correo){
		
		if(Instancia == null){
	
			Instancia = new Criticas(correo);
			
			try {
				
				String Path = new File("").getAbsolutePath();
				Path = Path + "/PropiedadesDatos";
				File Archivo = new File(Path);
				Properties Tabla = new Properties();
				FileInputStream in = new FileInputStream(Archivo);
				Tabla.load(in);
				in.close();
				String RutaTotal = new File("").getAbsolutePath();
				String RutaFich = RutaTotal + "/Criticas.txt";
				Tabla.setProperty("CriticasFilePath", RutaFich);		
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
	 * Funcion la cual crea una critica
	 * @param critica Objeto de la clase critica
	 */	
	public void crearCritica(Critica critica){
		
		if(Instancia!=null){
		
			this.critica.CriticaAFich(critica.getTitulo(),critica.getPuntuacion(), critica.getResena(), critica.getCorreo(), critica.getLike(), critica.getDislike(), critica.getId(), critica.getVotantes());
		}
	}	
	
	/**
	 * Funcion que imprime todas
	 * las criticas
	 */	
	public void imprimirCriticas(){
		
		if(Instancia!=null){
			
			this.critica.ImprimirTodo();
		}
	}
	
	/**
	 * Funcion que busca criticas
	 * @param correo Correo del autor de la critica
	 */
	public void buscarCriticas(String correo){
		
		if(Instancia!=null){
			
			this.critica.buscarCriticas(correo);
		}
	}
	
	/**
	 * Funcion que borra una critica concreta
	 * @param critica Objeto de la clase critica
	 */
	public void BorrarCritica(Critica critica){
		
		if(Instancia!=null) {
			
			this.critica.borrarCritica(critica.getId(), this.correo);
		}
	}
	
	/**
	 * Funcion que vota positivamente una ctitica
	 * @param id Identificador critica
	 */
	
	public void votarCriticasPos(int id){
		
		if(Instancia!=null) {
			
			this.critica.votarCriticaPositiva(this.correo, id);
		}
	}
	
	/**
	 * Funcion que vota negativamente una ctitica
	 * @param id Identificador critica
	 */
	public void votarCriticasNeg(int id){
		
		if(Instancia!=null) {
			
			this.critica.votarCriticaNegativa(this.correo, id);
		}
	}
}
			