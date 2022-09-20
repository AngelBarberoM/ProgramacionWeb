package Usuarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import General.Persona;

/**
 * Clase que llama a todas 
 * las funciones  de criticas.
 */	
public class Usuarios {
	
	/** 
 	* Instancia de criticas
 	*/
	private static Usuarios Instancia = null;
	/**
	 * Clase FunUsuario para llamar a las funciones.
	 */
	private FunUsuario Usuario = new FunUsuario();
	
	/**
	 * Correo del usuario
	 */
	private String Correo;
	
	/**
	 * Constructor privado
	 * @param Correo Correo del usuario
	 */
	private Usuarios(String Correo) {
		
		this.Correo = Correo; 
	}
	
	/**
	 * Funcion para inicializar las criticas. 
	 * Escribe en el fichero PropiedadesDatos la ruta del fichero de Criticas
	 * @param Correo del usuario
	 * @return instancia
	 */
	public static Usuarios getInstancia(String Correo){
		
		if(Instancia == null){
			
			Instancia = new Usuarios(Correo);
			try {
				String Path = new File("").getAbsolutePath();
				Path = Path + "/PropiedadesDatos";
				File Archivo = new File(Path);
				Properties Tabla = new Properties();
				FileInputStream in = new FileInputStream(Archivo);
				Tabla.load(in);
				in.close();
				String RutaTotal = new File("").getAbsolutePath();
				String RutaFich = RutaTotal + "/Usuarios.txt";
				Tabla.setProperty("UsuariosFilePath", RutaFich);
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
	 * Funcion la cual crea una persona o usuario
	 * @param Persona1 Objeto de la clase Persona
	 */		
	public void DarAltaUsuario(Persona Persona1){
		
		if(Instancia!=null){
			
			this.Usuario.RegistrarUsuarioFichMismoCorreo(Persona1.getNombre(), Persona1.getApellidos(), Persona1.getNombreUsuario(), Persona1.getCorreo(), Persona1.getContrasena());
		}
	}
	
	/**
	 * Funcion la cual elimina una persona o usuario
	 */	
	public void DarBajaUsuario(){
		
		if(Instancia!=null){
			
			this.Usuario.BorrarUsuario(this.Correo);
			System.exit(1);
		}
	}	
	/**
	 * Funcion la cual imprime los datos una persona o usuario
	 */	
	public void VerDatosUsuario(){
		
		if(Instancia!=null){
			
			Usuario.ImprimirDatosUsuario(this.Correo);
		}
	}
	
	/**
	 * Funcion la cual actualiza los datos de una persona o usuario
	 */	
	public void ActualizarUsuario(){
		
		if(Instancia!=null){
			
			Usuario.ActualizarUsuario(this.Correo);
			System.exit(1);
		}	
	}	
}