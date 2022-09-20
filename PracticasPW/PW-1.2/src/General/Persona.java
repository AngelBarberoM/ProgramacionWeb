package General;

import Usuarios.FunUsuario;

/**
 * Clase que implementa una persona con las variables privadas
 * y algunos metodos
 */
public class Persona extends FunUsuario{

	/**
	 * Nombre de la persona
	*/
	private String Nombre; 
	
	/**
	 * Apellidos de la persona
	*/
	private String Apellidos; 
	
	/**
	 * Correo de la persona
	*/
	private String Correo;
	
	/**
	 * Nombre de usuario de la persona
	*/
	private String NombreUsuario;
	
	/**
	 * Contrasena de la persona
	*/
	private String Contrasena;
	
	/**
	 * Constructor sin parametros.
	*/
	public Persona(){}
	
	//CONSTRUCTOR PARAMETRIZADO
	/**
	 * Constructor parametrizado
	 * @param Nombre Nombre de la persona
	 * @param Apellidos Apellidos de la persona
	 * @param Correo Correo de la persona
	 * @param NombreUsuario Nombre de usuario de la persona
	 * @param Contrasena Contrasena de la persona
	*/
	public Persona(String Nombre, String Apellidos, String Correo, String NombreUsuario, String Contrasena){
		this.Nombre=Nombre;
		this.Apellidos=Apellidos;
		this.Correo=Correo;
		this.NombreUsuario = NombreUsuario;
		this.Contrasena = Contrasena;
	}
	
	//OBSERVADORES
	
	/**
	 * Get del Nombre.
	 * @return Nombre 
	 */
	public String getNombre(){
		
		return this.Nombre; 
	}

	/**
	 * Get de los Apellidos.
	 * @return Apellidos 
	 */
	public String getApellidos(){
		
		return this.Apellidos; 
	}

	/**
	 * Get del Nombre de Usuario.
	 * @return NombreUsuario 
	 */
	public String getNombreUsuario(){
		
		return this.NombreUsuario; 
	}

	/**
	 * Get del Correo.
	 * @return Correo 
	 */
	public String getCorreo(){
		
		return this.Correo; 
	}

	/**
	 * Get de la Contrasena.
	 * @return Contrasena 
	 */
	public String getContrasena(){
		
		return this.Contrasena;
	}
	
	//MODIFICADORES

	/**
	 * Set del Nombre.
	 * @param Nombre 
	 */
	public void setNombre(String Nombre){
		
		this.Nombre = Nombre; 
	}

	/**
	 * Set de los Apellidos.
	 * @param Apellidos 
	 */
	public void setApellidos(String Apellidos){
	
		this.Apellidos = Apellidos; 
	}

	/**
	 * Set del Nombre de Usuario.
	 * @param NombreUsuario 
	 */
	public void setNombreUsuario(String NombreUsuario){
		
		this.NombreUsuario = NombreUsuario; 
	}

	/**
	 * Set del Correo.
	 * @param Correo 
	 */
	public void setCorreo(String Correo){
		
		this.Correo = Correo; 
	}

	/**
	 * Set de la Contrasena.
	 * @param Contrasena 
	 */
	public void setContrasena(String Contrasena){
		
		this.Contrasena = Contrasena;
	}
}