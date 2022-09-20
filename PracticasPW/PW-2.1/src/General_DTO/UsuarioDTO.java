package General_DTO;
import java.time.LocalDateTime;

public class UsuarioDTO {

	
	//VARIABLES
	
	private String Nombre; 
	
	private String Correo;
	
	private String NombreUsuario;
	
	private String Contrasena;

	private String TipoUsuario;
	
	private LocalDateTime HoraRegistro;
	
	private LocalDateTime UltimaConex;

	//CONSTRUCTOR VACIO
	
	public UsuarioDTO() {}
	
	
	//CONSTRUCTORES PARAMETRIZADOS
	
	public UsuarioDTO(String Nombre, String Correo, String NombreUsuario, String Contrasena, String TipoUsuario){
		
		this.Nombre=Nombre; 
		this.Correo=Correo;
		this.NombreUsuario = NombreUsuario;
		this.Contrasena = Contrasena;
		this.TipoUsuario = TipoUsuario;
	}
	
	public UsuarioDTO(String Nombre, String Correo, String NombreUsuario, String Contrasena, String TipoUsuario, LocalDateTime HoraRegistro, LocalDateTime UltimaConex){
		
		this.Nombre=Nombre; 
		this.Correo=Correo;
		this.NombreUsuario = NombreUsuario;
		this.Contrasena = Contrasena;
		this.TipoUsuario = TipoUsuario;
		this.HoraRegistro = HoraRegistro;
		this.UltimaConex = UltimaConex;
	}
	
	public UsuarioDTO(String Nombre, String Correo, String NombreUsuario, String TipoUsuario){
		
		this.Nombre=Nombre; 
		this.Correo=Correo;
		this.NombreUsuario = NombreUsuario;
		this.TipoUsuario = TipoUsuario;
	}
	
	public UsuarioDTO(String Nombre, String Correo, String NombreUsuario){
		
		this.Nombre=Nombre; 
		this.Correo=Correo;
		this.NombreUsuario = NombreUsuario;
	}
	
	
	//OBSERVADORES
	
	public String getNombre(){
		
		return this.Nombre; 
	}
	
	
	public String getCorreo(){
		
		return this.Correo; 
	}
	
	
	public String getNombreUsuario(){
		
		return this.NombreUsuario; 
	}
	
	
	public String getContrasena() {
	
		return this.Contrasena;
	}

	
	public LocalDateTime getHoraRegistro() {
		
		return this.HoraRegistro;
	}
	
	
	public LocalDateTime getUltimaConex() {
		
		return this.UltimaConex;
	}
	

	public String getTipoUsuario() {
		
		return this.TipoUsuario;
	}
	
	//MODIFICADORES
	
	public void setNombre(String Nombre){
		
		this.Nombre = Nombre; 
	}
	
	public void setCorreo(String Correo){
		
		this.Correo = Correo; 
	}

	
	public void setNombreUsuario(String NombreUsuario){
		
		this.NombreUsuario = NombreUsuario; 
	}	
	

	public void setContrasena(String Contrasena) {
		
		this.Contrasena = Contrasena;
	}
	
	
	public void setHoraRegistro(LocalDateTime HorayFecha) {
		
		this.HoraRegistro = HorayFecha;
	}
	

	public void setUltimaConex(LocalDateTime HorayFecha) {
		
		this.UltimaConex = HorayFecha;
	}

	

	public void setTipoUsuario(String TipoUsuario) {
		
		this.TipoUsuario = TipoUsuario;
	}
}
