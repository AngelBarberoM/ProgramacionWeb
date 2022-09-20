package JavaBeans;
import java.time.LocalDateTime;

public class CustomerJavaBean implements java.io.Serializable{
	
	//VARIABLES
	private static final long serialVersionUID = 1L;
	
	private String correo = "";
	private String nombreUsuario = "";
	private LocalDateTime horaRegistro;
	private String tipoUsuario = "";
	private LocalDateTime ultimaConexion;

	//OBSERVADORES
	public String getCorreo() {
		
		return correo;
	}

	public String getNombreUsuario() {
		
		return nombreUsuario;
	}

	public LocalDateTime getHoraRegistro() {
		return horaRegistro;
	}

	public String getTipoUsuario() {
		
		return tipoUsuario;
	}

	public LocalDateTime getUltimaConexion() {
		
		return ultimaConexion;
	}

	//MODIFICADORES
	
	public void setCorreo(String correo) {
		
		this.correo = correo;
	}

	public void setNombreUsuario(String username) {
		
		this.nombreUsuario = username;
	}

	public void setTipoUsuario(String tipoUsuario) {
		
		this.tipoUsuario = tipoUsuario;
	}

	public void setHoraRegistro(LocalDateTime horaRegistro) {
		
		this.horaRegistro = horaRegistro;
	}

	public void setUltimaConexion(LocalDateTime ultimaConexion) {
		
		this.ultimaConexion = ultimaConexion;
	}

	
}
