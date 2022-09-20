package CEU_MG;
import java.time.LocalDateTime;
import java.util.ArrayList;

import GeneralDAO.UsuarioDAO;
import General_DTO.UsuarioDTO;


/*
 * Llamadas a UsuarioDAO para poder utilizarlo
 */
public class UsuarioMG {

	/* Funcion que comprueba que inicio de sesion
	 * @param Correo Correo del usuario
	 * @param Contrasena Contrasena del usuario
	 * @return true / false
	 */
	
	public Boolean InicioSesion(String Correo, String Contrasena) {
		
		if(this.ExisteUsuario(Correo)) {
			
			UsuarioDAO inicioSesion = new UsuarioDAO();
			String contrasena = inicioSesion.SolicitarDatosSesion(Correo);
			
			if(Contrasena.equals(contrasena)) {
				
				return true;
			}
		}
		return false;
	}
	
	/* Funcion que crea un nuevo usuario 
	 * @param Correo 
	 * @param NombreUsuario
	 * @param Nombre
	 * @param Contrasena 
	 * @param TipoUsuario 
	 * @param HoraRegistro 
	 * @param UltimaConex 
	 * @return true / false
	 */
	
	public Boolean CrearUsuario(String Correo, String NombreUsuario, String Nombre, String Contrasena, String TipoUsuario, LocalDateTime HoraRegistro, LocalDateTime UltimaConex) {	
		
		if(!this.ExisteUsuario(Correo)) {
		
			UsuarioDAO NuevoUsuario = new UsuarioDAO();
			UsuarioDTO NuevoUsuarioDTO = new UsuarioDTO(Nombre,Correo,NombreUsuario,Contrasena, TipoUsuario, HoraRegistro, UltimaConex);  
			NuevoUsuario.CrearUsuario(NuevoUsuarioDTO);
			
			return true;
		}
		return false;
	}
	
	/* Funcion que actualiza los datos de un usuario
	 * @param Correo
	 * @param NombreUsuario 
	 * @param Nombre 
	 * @param Contrasena 
	 * @return true/ false
	 */
	
	public Boolean ActualizarUsuario(String Correo, String NombreUsuario, String Nombre, String Contrasena) {
		
		if(this.ExisteUsuario(Correo)) {
			
			UsuarioDAO NuevoUsuario = new UsuarioDAO();
			UsuarioDTO NuevoUsuarioDTO = new UsuarioDTO(Nombre,Correo,NombreUsuario);
			NuevoUsuarioDTO.setContrasena(Contrasena);
			NuevoUsuario.ActualizarUsuario(NuevoUsuarioDTO);
			
			return true;
		}
		return false;
	}
	
	/* Funcion que borra usuario por correo
	 * @param Correo
	 * @return true / false
	 */
	
	public Boolean EliminarUsuario(String Correo) {
		
		if(this.ExisteUsuario(Correo)) {
			
			UsuarioDAO eliminarUsuario = new UsuarioDAO();
			eliminarUsuario.EliminarUsuario(Correo);
			
			return true;
		}	
		return false;
	}

	/* Funcion que devuelve los datos de un usuario por correo introducido
	 * @param Correo 
	 * @return UsuarioSolicitado 
	 */
	
	public UsuarioDTO SolicitarUsuario(String Correo) {
	
		UsuarioDAO SolicitarUsuario = new UsuarioDAO();
		UsuarioDTO UsuarioSolicitado = new UsuarioDTO();
	
		if(this.ExisteUsuario(Correo)) {
		
			UsuarioSolicitado = SolicitarUsuario.SolicitarUsuario(Correo);	
		}
		return UsuarioSolicitado;
	}
	
	/* Funcion que devuelve los datos de un usuario por nombre de usuario introducido
	 * @param NombreUsuario 
	 * @return UsuarioSolicitado
	 */
	
	public UsuarioDTO SolicitarUsuarioPorNombreUsuario(String NombreUsuario) {
	
		UsuarioDAO SolicitarUsuario = new UsuarioDAO();
		UsuarioDTO UsuarioSolicitado = new UsuarioDTO();
		
		if(this.ExisteUsuarioPorNombreUsuario(NombreUsuario)) {
			
			UsuarioSolicitado = SolicitarUsuario.SolicitarUsuarioPorNombreUsuario(NombreUsuario);	
		}
		return UsuarioSolicitado;
	}
	
	/* Funcion que devuelve todos los usuarios
	 * @return UsuariosSolicitados
	 * @author Developers
	 */
	
	public ArrayList<UsuarioDTO> SolicitarTodosUsuarios(){
		
		UsuarioDAO SolicitarUsuario = new UsuarioDAO();
		ArrayList<UsuarioDTO> UsuariosSolicitados = new ArrayList<UsuarioDTO>();
		UsuariosSolicitados = SolicitarUsuario.SolicitarTodosUsuarios();
		
		return UsuariosSolicitados;
	}
	
	/* Funcion que comprueba correo de usuario
	 * @return true / false
	 */
	
	public Boolean ExisteUsuario(String Correo) {
	
		ArrayList<UsuarioDTO> usuarios = this.SolicitarTodosUsuarios();
		
		for(UsuarioDTO i : usuarios) {
		
			if(i.getCorreo().equals(Correo)) {
				
				return true;
			}
		}
		return false;	
	}
	
	/* Funcion que comprueba nombre de usuario de un usuario
	 * @return true / false
	 */
	
	public Boolean ExisteUsuarioPorNombreUsuario(String NombreUsuario) {
		ArrayList<UsuarioDTO> usuarios = this.SolicitarTodosUsuarios();
		
		for(UsuarioDTO i : usuarios) {
			
			if(i.getNombreUsuario().equals(NombreUsuario)) {
			
				return true;
			}
		}
		return false;	
	}
	
	/* Funcion que devuelve los datos de un usuario por correo introducido
	 * @param Correo
	 * @return usuario informacion de usuario
	 */
	
	public ArrayList<String> InformacionUsuario(String Correo){
		
		ArrayList<String> usuario =  new ArrayList<String>();
		
		if(this.ExisteUsuario(Correo)) {
			
			UsuarioDTO user = this.SolicitarUsuario(Correo);
			usuario.add(user.getCorreo());
			usuario.add(user.getNombre());
			usuario.add(user.getNombreUsuario());	
		}
		return usuario;
	}
	
	/* Funcion que devuelve los usuarios con un tipo de usuario igual al introducido
	 * @param TipoUsuario 
	 * @return usuarios usuarios que coincide con el tipo de usuario 
	 */
	
	public ArrayList<UsuarioDTO> SolicitarUsuarioPorTipo(String TipoUsuario){
		
		ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		UsuarioDAO SolicitarUsuarioPorTipo = new UsuarioDAO();
		usuarios = SolicitarUsuarioPorTipo.SolicitarUsuarioPorTipo(TipoUsuario);		
		
		return usuarios;
	}
	
	/* Funcion que comprueba si un usuario es Admin
	 * @param Correo 
	 * @return true / false
	 */
	
	public Boolean ComprobarUsuarioAdministrador(String Correo) {
	
		ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		usuarios = this.SolicitarUsuarioPorTipo("admin");
		
		for(UsuarioDTO i : usuarios) {
			
			if(i.getCorreo().equals(Correo))
				
				return true;
		}
		return false;
	}
}
