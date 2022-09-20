package MenusSecundarios;
import java.util.Scanner;

import CEU_MG.UsuarioMG;
import General_DTO.UsuarioDTO;
/**
 * La clase lleva la gestion de usuarios
 */
public class MenuUsuario {

	
	private String correo;
	
	private String getCorreo() {
		return correo;
	}
	
	public MenuUsuario(String correo) {
		this.correo = correo;
	}
	
	public void usuarioMenu() {
		String Opcion = "0";
		Scanner lector = new Scanner(System.in);

		while(Opcion.equals("1") || Opcion.equals("2") || Opcion.equals("3") || Opcion.equals("0")){
			
			System.out.println("Bienvenido a nuestro Menu de gestion de usuarios.");
		    System.out.println("Para ver los datos de su perfil, pulse 1.");
		    System.out.println("Para actualizar sus datos de usuario, pulse 2.");
		    System.out.println("Para dar de baja su usuario, pulse 3.");	    
		    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
		    
	        if(lector.hasNext()){
	        	
			    Opcion = lector.nextLine();
		        if("1".equals(Opcion)){ 
		        	
		        	System.out.println("DATOS DE USUARIO");
		        	UsuarioMG managerUserRead = new UsuarioMG();
		        	UsuarioDTO user = managerUserRead.SolicitarUsuario(this.getCorreo());
		        	System.out.println("Correo : " + user.getCorreo());
		        	System.out.println("Nombre : " + user.getNombre());
		        	System.out.println("NombreUsuario : " + user.getNombreUsuario());  
		        	System.out.println("TipoUsuario : " + user.getTipoUsuario());
		        }
		        else if("2".equals(Opcion)){ 
		        	
		        	System.out.println("ACTUALIZACION DE USUARIO");
		        	System.out.println("Datos actuales:");
		        	UsuarioMG managerUser = new UsuarioMG();
		        	UsuarioDTO user = managerUser.SolicitarUsuario(this.getCorreo());
		        	System.out.println("Correo : " + user.getCorreo());
		        	System.out.println("Nombre : " + user.getNombre());
		        	System.out.println("NombreUsuario : " + user.getNombreUsuario());  
		
		        	String username = null;
		        	
		        	String name = null;
		        	
		        	String password = null;
		        	
		        	System.out.println("Nuevo nombre de usuario");
		        	username = lector.nextLine();
		        	
		        	System.out.println("Nuevo nombre");
		        	name = lector.nextLine();
		        	
		        	System.out.println("Nueva contrasena");
		        	password = lector.nextLine();
	
		        	UsuarioMG managerUserUpdate = new UsuarioMG();
		        	managerUserUpdate.ActualizarUsuario(this.getCorreo(), username, name, password);

		        }
		        else if("3".equals(Opcion)){
		        	
		        	System.out.println("ELMINACION DE USUARIO");
		        	System.out.println("Desea borrar su usuario? Si / No.");
		        	
		        	String delete = lector.nextLine();
		        	if(delete.equals("Si")) {
			        	
		        		UsuarioMG managerUserDelete = new UsuarioMG();
			        	managerUserDelete.EliminarUsuario(this.getCorreo());
			       		System.out.println("Su usuario ha sido borrado.");
			       		System.out.println("Gracias por usar nuestro sistema.");
			       		System.exit(0);
			    	}
		        	else {
		        	
		        		System.out.println("Su usuario no ha sido borrado.");	
		        	}
		        }
		        else{ 
		        	
		        	System.out.println("Saliendo...\n\n");
		        }
	        }
	        
		}
		lector.close(); 
	}
}
