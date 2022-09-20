package Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Usuarios.Usuarios;

/**
 * La clase MenuUsuario cse utiliza para imprimir un menu 
 * correspondiente a las criticas
 *
 */
public class MenuUsuario {

	/** 
	* Menu el cual realiza lo necesario para las personas o usuarios
	* @param Correo Correo de la persona.
	*/
	public void usuarioMenu(String correo){

		String Opcion = null;
        Usuarios nuevoGestor = Usuarios.getInstancia(correo);

		System.out.println("");
		System.out.println("-------------------------------");
	    System.out.println("Bienvenido al menu de usuarios.");
		System.out.println("-------------------------------");
	    System.out.println("Ver los datos de su perfil, pulse 1.");
	    System.out.println("Actualizar sus datos de usuario, pulse 2.");
	    System.out.println("Darse de baja su usuario, pulse 3.");	  
		System.out.println("-------------------------------");   
	    System.out.println("Salir del menu, pulse cualquier otra tecla.");
        System.out.println("-----------------------------");
	    
        BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
        try {
			
        	Opcion = login.readLine();
        	
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}
        
        if("1".equals(Opcion)){ 
        	
        	nuevoGestor.VerDatosUsuario();
        }
        else if("2".equals(Opcion)){ 
			
        	nuevoGestor.ActualizarUsuario();
        	
        }
        else if("3".equals(Opcion)){ 
        	
        	System.out.println("Usuario eliminado del sistema."); 
        	nuevoGestor.DarBajaUsuario();
        }
        else{ 
        	
        	System.out.println("Saliendo...\n\n");
        }
	}
}