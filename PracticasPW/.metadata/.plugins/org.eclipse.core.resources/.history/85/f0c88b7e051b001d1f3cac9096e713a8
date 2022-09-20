package MenusSecundarios;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import CEU_MG.UsuarioMG;

/**
 * La clase se utiliza para la gestion del inicio de sesion
 */
public class MenuSesion {
	
public String inicioSesionMenu() {
		
		String Opcion="1";
		Scanner lector = new Scanner(System.in);
    	String Correo = null;
		while(Opcion.equals("1") || Opcion.equals("2")){
			
			System.out.println("Bienvenido a nuestro sistema.");
		    System.out.println("Para iniciar sesion, pulse 1.");
		    System.out.println("Para registrarse, pulse 2.");	    
		    System.out.println("Para salir del menu, pulse cualquier otra tecla.");			
	        
		    Opcion = "0";
		    if(lector.hasNext()){
		    	
			    Opcion = lector.nextLine();
			  
		        if("1".equals(Opcion)) { 
		        	
		        	System.out.println("LOGIN");
		        	UsuarioMG inicioSesionMG = new UsuarioMG();
		        	String contrasena = null;
		        	
		        	System.out.println("Introduzca su Correo");
		        	Correo = lector.nextLine();
		     
		        	System.out.println("Introduzca su contrasena");
		        	contrasena = lector.nextLine();
		        	
		        	if(inicioSesionMG.InicioSesion(Correo,contrasena)) {
		        		
		        		System.out.println("Bienvenido");
		        		return Correo;
		        	}
		        	else {
		        		
		        		System.out.println("Login incorrecto");
		        		System.out.println("Saliendo...\n\n");
		        		System.exit(0);
		        	}
		        }
		        else if("2".equals(Opcion)){ 
		        	
		        	System.out.println("REGISTRO");
		        	String nombreUsuario = null;
		        	String nombre = null;
		        	String contrasena = null;
		        	String tipoUsuario = "0";
		     
		        	System.out.println("Introduzca su Correo:");
		        	Correo = lector.nextLine();
		        	System.out.println("Introduzca su Nombre de Usuario:");
		        	nombreUsuario = lector.nextLine();
		        	System.out.println("Introduzca su nombre:");
		        	nombre = lector.nextLine();
		        	System.out.println("Introduzca su contrasena:");
		        	contrasena = lector.nextLine();	
		        	System.out.println("Introduzca 1 si es Admin, 2 si es usuario");
		        	tipoUsuario = lector.nextLine();
		        	
		        	if(tipoUsuario.equals("1")) {
		        		
		        		tipoUsuario = "admin";
		        	}
		        	else if(tipoUsuario.equals("2")){
		        		
		        		tipoUsuario = "user";	
		        	}
		        	else{
		        		
		        		while(!tipoUsuario.equals("1") && !tipoUsuario.equals("2")){
		        			
			        		System.out.println("Introduzca 1 si es Admin, 2 si es usuario");
			        		tipoUsuario = lector.nextLine();
		        		}
		        	}
					
		        	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
					LocalDateTime ahora = LocalDateTime.now();
					String auxiliar = ahora.format(formato);
					
					LocalDateTime fecha = LocalDateTime.parse(auxiliar, formato);
					
		        	UsuarioMG usuarioMG = new UsuarioMG();
		        	
		        	if(!usuarioMG.ExisteUsuario(Correo)) {
		        	
		        		usuarioMG.CrearUsuario(Correo, nombreUsuario, nombre, contrasena, tipoUsuario, fecha, fecha);
		        	}
		        	else {
		        		
		        		System.out.println("El Correo que desea usar ya existe");
		        		System.out.println("Saliendo...\n\n");
		        		System.exit(0);
		        	}
		        	Opcion = "0";
		        }
		        else{ 
		        	
		        	System.out.println("Saliendo...\n\n");
		        }
		    }    
			lector.close(); 
		}
		return Correo; 
	}
}
