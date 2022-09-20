package ProgramaPrincipal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Usuarios.FunUsuario;
import Menu.MenuCriticas;
import Menu.MenuUsuario;

/** 
* Programa principal el cual enlaza los dos diferentes menus, 
* tanto el de criticas como el de usuario
* @param Correo Correo de la persona.
*/
public class ProgramaPrincipal {
	
	public static void main(String[] args) throws IOException{

        String  Nombre = null, Apellidos = null, NombreUsuario = null, Correo = null, Contrasena = null, Opcion = null;
        
        FunUsuario io = new FunUsuario();
        
        System.out.println("Bienvenido a nuestro sistema.");
        System.out.println("-----------------------------");
        System.out.println("Para iniciar sesion pulse 1.");
        System.out.println("Para registrarse pulse 2.");
        System.out.println("Para salir pulse cualquier otra tecla.");
        System.out.println("-----------------------------");
        
        BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
        
        try{
        	
			Opcion = login.readLine();
			
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}
        
        if("1".equals(Opcion)){
        	
        	System.out.println("Por favor, introduzca sus datos.");
            System.out.println("Correo:");
	        
            BufferedReader readUser = new BufferedReader(new InputStreamReader(System.in));
	        
	        try{
				Correo = readUser.readLine();
				
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
            System.out.println("Contrasena:");
            
	        BufferedReader readPassword = new BufferedReader(new InputStreamReader(System.in));
	        
	        try{
				Contrasena = readPassword.readLine();
				
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
	        
	        System.out.println("-----------------");
           
            if(io.ComprobarExisteUsuario(Correo)==false){
                
            	System.out.println("Correo no registrado.");
                System.out.println("Para registrarse pulse 1. Para salir pulse cualquier otra tecla.");
                BufferedReader readRegister = new BufferedReader(new InputStreamReader(System.in));
    	      
                try{
    	        	
    				Opcion = readRegister.readLine();
    				
    			} catch (IOException Excep){
    				
    				Excep.printStackTrace();
    			}
    	        if("1".equals(Opcion)){
    	        	
    	        	System.out.println("Introduzca su Correo:");
    				BufferedReader Register = new BufferedReader(new InputStreamReader(System.in));
    				try {
    					
    					Correo = Register.readLine();
    					
    					while(Correo.equals("") || Correo.trim().isEmpty()){
    						
    						System.err.println("Introduce el correo.");
    						Correo = Register.readLine();
    					}
    				} catch (IOException Excep){
    					
    					Excep.printStackTrace();
    				}
    				
    				System.out.println("Introduzca su Contrasena:");
    				BufferedReader Register1 = new BufferedReader(new InputStreamReader(System.in));
    				
    				try {
    					Contrasena = Register1.readLine();
    					
    					while(Contrasena.equals("") || Contrasena.trim().isEmpty()){
    						
    						System.err.println("Introduce la contraseña.");
    						Contrasena = Register.readLine();
    					}
    					
    				} catch (IOException Excep){
    					
    					Excep.printStackTrace();
    				}
    				
    				System.out.println("Introduzca su nombre:");
    				BufferedReader Register2 = new BufferedReader(new InputStreamReader(System.in));
    				
    				try{
    					Nombre = Register2.readLine();
    					
    					while(Nombre.equals("") || Nombre.trim().isEmpty()){
    						
    						System.err.println("Introduzca el nombre.");
    						Nombre = Register2.readLine();
    					}
    				} catch (IOException Excep){
    					
    					Excep.printStackTrace();
    				}
    				
    				System.out.println("Introduzca sus apellidos:");
    				BufferedReader Register3 = new BufferedReader(new InputStreamReader(System.in));
    				
    				try{
    					Apellidos = Register3.readLine();
    					
    					while(Apellidos.equals("") || Apellidos.trim().isEmpty()){
    						
    						System.err.println("Introduzca los apellidos.");
    						Apellidos = Register3.readLine();
    					}
    				} catch (IOException Excep){
    					
    					Excep.printStackTrace();
    				}
    				
    				System.out.println("Introduzca su nombre de usuario:");
    				BufferedReader Register4 = new BufferedReader(new InputStreamReader(System.in));
    				
    				try{
    					
    					NombreUsuario = Register4.readLine();
    					
    					while(NombreUsuario.equals("") || NombreUsuario.trim().isEmpty()){
    						
    						System.err.println("Introduzca el nombre de usuario.");
    						NombreUsuario = Register4.readLine();
    					}
    				} catch (IOException Excep){
    					
    					Excep.printStackTrace();
    				}

    		        FunUsuario nuevoUsuario = new FunUsuario();
    		        nuevoUsuario.RegistrarUsuarioFich(Nombre,Apellidos,NombreUsuario,Correo, Contrasena);
    		        System.out.println("El registro se ha completado correctamente.");
    		        System.out.println("Bienvenido " + NombreUsuario + ".");
            		
    		        while(Opcion!="1" || Opcion!= "2" || Opcion!="3"){

            	        System.out.println("");
            	        System.out.println("-----------------");
            			System.out.println("¿Que desea hacer?");
            	        System.out.println("-----------------");
    	            	System.out.println("Acceder al menu de usuarios, pulse 1");
    	            	System.out.println("Acceder al menu de criticas, pulse 2");
            	        System.out.println("-----------------");
    	            	System.out.println("Salir, pulse 3");
            	        System.out.println("-----------------");

    	            	BufferedReader readGestores = new BufferedReader(new InputStreamReader(System.in));
    	            	
    	    			try{
    	    				
    	    				Opcion = readGestores.readLine();
    	    			
    	    			} catch (IOException Excep){
    	    				
    	    				Excep.printStackTrace();
    	    			}
    	    			if("1".equals(Opcion)){
    	    				
    	    				MenuUsuario menu = new MenuUsuario();
    	    				menu.usuarioMenu(Correo);
    	    				Opcion=null;
    	    			}
    	    			else if("2".equals(Opcion)){
    	    				
    	    				MenuCriticas menu = new MenuCriticas();
    	    				menu.criticasMenu(Correo);
    	    				Opcion=null;
    	    			}	
    	    			else if("3".equals(Opcion)){
    			           
    	    				System.out.println("Hasta la proxima.");
    			            return;
    	    			}
    	    			else{
    			           
    	    				System.out.println("Opcion no permitida.");
    	    			}
            		}
    	        }
                else{
    	        	
                	System.out.println("Gracias por usar nuestro sistema");
    	            return;
                }
            }
            if(io.comprobarPassword(Correo, Contrasena)==false){
            	
            	int intentos = 1;
    	        String Opcion1 = null;
    	        Boolean timeout = true;
                System.out.println("Contrasena incorrecta. Pulse 1 para volver a intentarlo. Para salir pulse cualquier otra tecla. ");
                BufferedReader readWrongPassword = new BufferedReader(new InputStreamReader(System.in));
                
    			try{
    				
    				Opcion1 = readWrongPassword.readLine();
    				
    			} catch (IOException Excep){
    				
    				Excep.printStackTrace();
    			}
    	        if(!("1".equals(Opcion1))){
    	            
    	        	System.out.println("Gracias por usar nuestro sistema");
    	            return;
    	        }
    	        else{
    	        	while(!(io.comprobarPassword(Correo, Contrasena)) && timeout){
    	            	
    	        		System.out.println("Contrasena:");
    		 	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    		 	        
    		 	        try {
    		 				
    		 	        	Contrasena = reader.readLine();
    		 	        	
    		 			} catch (IOException Excep){
    		 				
    		 				Excep.printStackTrace();
    		 			}
    		 	        
    		 	        intentos++;
    		 	        if(intentos>3) {
    		 	        	timeout = false;
    		 	        }
    	            }
    	        	if(!timeout){
    	            	
    	        		System.out.println("Numero de intentos permitidos superado.");
    		            System.out.println("Gracias por usar nuestro sistema");
    		            return;
    	        	}
    	        	else{
						
            			System.out.println("Bienvenido a nuestro sistema, " + io.BuscarPorCorreo(Correo).getNombreUsuario() + ".");
    	        		while(Opcion1!="1" || Opcion1!= "2" || Opcion1!="3"){
    	        			
                	        System.out.println("-----------------");
    	        			System.out.println("¿Que desea hacer?");
                	        System.out.println("-----------------");
        	            	System.out.println("Acceder al menu de usuarios, pulse 1");
        	            	System.out.println("Acceder al menu de criticas, pulse 2");
                	        System.out.println("-----------------");
        	            	System.out.println("Salir, pulse 3");
                	        System.out.println("-----------------");

    		            	BufferedReader readGestores = new BufferedReader(new InputStreamReader(System.in));
    		            	
    		    			try {
    		    				
    		    				Opcion1 = readGestores.readLine();

    		    				
    		    			} catch (IOException Excep){
    		    				
    		    				Excep.printStackTrace();
    		    			}
    		    			if("1".equals(Opcion1)) {
        	    				
    		    				MenuUsuario menu = new MenuUsuario();
        	    				menu.usuarioMenu(Correo);
    		    				Opcion1=null;
    		    			}
    		    			else if("2".equals(Opcion1)){
    		    				
    		    				MenuCriticas menu = new MenuCriticas();
        	    				menu.criticasMenu(Correo);
    		    				Opcion1=null;
    		    			}	
    		    			else if("3".equals(Opcion1)){
    				            
    		    				System.out.println("Hasta la proxima.");
    				            return;
    		    			}
    		    			else{
    				            
    		    				System.out.println("Opcion no permitida.");
    		    			}
    	        		}
    	        	}
    	        }     
            }
	        System.out.println("Bienvenido a nuestro sistema " + io.BuscarPorCorreo(Correo).getNombreUsuario() + ".");
    		
			while(Opcion !="1" || Opcion!= "2" || Opcion!="3") {
            	
    	        System.out.println("-----------------");
				System.out.println("¿Que desea hacer?");
    	        System.out.println("-----------------");
            	System.out.println("Acceder al menu de usuarios, pulse 1");
            	System.out.println("Acceder al menu de criticas, pulse 2");
    	        System.out.println("-----------------");
            	System.out.println("Salir, pulse 3");
    	        System.out.println("-----------------");

            	BufferedReader readGestores = new BufferedReader(new InputStreamReader(System.in));
            	
    			try{
    				
    				Opcion = readGestores.readLine();
    				
    			} catch (IOException Excep){
    				
    				Excep.printStackTrace();
    			}
    			if("1".equals(Opcion)){
    				
    				MenuUsuario menu = new MenuUsuario();
    				menu.usuarioMenu(Correo);
    				Opcion=null;
    			}
    			else if("2".equals(Opcion)){
    				
    				MenuCriticas menu = new MenuCriticas();
    				menu.criticasMenu(Correo);
    				Opcion=null;
    			}	
    			else if("3".equals(Opcion)){
		            
    				System.out.println("Hasta la proxima.");
		            return;
    			}
    			else{
		           
    				System.out.println("Opcion no permitida.");
    			}
    		}
        }
        else if("2".equals(Opcion)){
        	
        	Contrasena = null;
        	
        	System.out.println("Introduzca su nombre:");
			BufferedReader Register = new BufferedReader(new InputStreamReader(System.in));
			
			try{
				Nombre = Register.readLine();
				while(Nombre.equals("") || Nombre.trim().isEmpty()){
					
					System.err.println("Introduzca el nombre.");
					Nombre = Register.readLine();
				}
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
			
			System.out.println("Introduzca sus apellidos:");
			BufferedReader Register1 = new BufferedReader(new InputStreamReader(System.in));
			
			try{
				Apellidos = Register1.readLine();
				while(Apellidos.equals("") || Apellidos.trim().isEmpty()){
					
					System.err.println("Introduzca los apellidos.");
					Apellidos = Register1.readLine();
				}
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
			
			System.out.println("Introduzca su nombre de usuario:");
			BufferedReader Register2 = new BufferedReader(new InputStreamReader(System.in));
			
			try{
				
				NombreUsuario = Register2.readLine();
				while(NombreUsuario.equals("") || NombreUsuario.trim().isEmpty()){
					System.err.println("Introduzca el nombre de usuario");
					NombreUsuario = Register2.readLine();
				}
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
			
			System.out.println("Introduzca su correo:");
			BufferedReader Register3 = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				Correo = Register3.readLine();
				while(Correo.equals("") || Correo.trim().isEmpty()){
					
					System.err.println("Introduzca el correo.");
					Correo = Register3.readLine();
				}
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
			
			System.out.println("Introduzca su contrasena:");
			BufferedReader Register4 = new BufferedReader(new InputStreamReader(System.in));
			
			try{
				Contrasena = Register4.readLine();
				while(Contrasena.equals("") || Contrasena.trim().isEmpty()){
					System.err.println("Introduzca la contrasena.");
					Contrasena = Register4.readLine();
				}
				
			} catch (IOException Excep){
				
				Excep.printStackTrace();
			}
			
			FunUsuario nuevoUsuario = new FunUsuario();
			nuevoUsuario.RegistrarUsuarioFich(Nombre,Apellidos,NombreUsuario,Correo, Contrasena);
			
	        System.out.println("Ha sido registrado correctamente.");
	        System.out.println("Bienvenido a nuestro sistema " + io.BuscarPorCorreo(Correo).getNombreUsuario() + ".");
    		
			while(Opcion !="1" || Opcion!= "2" || Opcion!="3"){
				
    	        System.out.println("-----------------");
				System.out.println("¿Que desea hacer?");
    	        System.out.println("-----------------");
            	System.out.println("Acceder al menu de usuarios, pulse 1");
            	System.out.println("Acceder al menu de criticas, pulse 2");
    	        System.out.println("-----------------");
            	System.out.println("Salir, pulse 3");
    	        System.out.println("-----------------");

            	BufferedReader readGestores = new BufferedReader(new InputStreamReader(System.in));
    			try{
    				
    				Opcion = readGestores.readLine();
    				
    			} catch (IOException Excep){
    				
    				Excep.printStackTrace();
    			}
    			if("1".equals(Opcion)){
    				
    				MenuUsuario menu = new MenuUsuario();
    				menu.usuarioMenu(Correo);
    				Opcion=null;
    			}
    			else if("2".equals(Opcion)){
    				
    				MenuCriticas menu = new MenuCriticas();
    				menu.criticasMenu(Correo);
    				Opcion=null;
    			}	
    			else if("3".equals(Opcion)){
		            
    				System.out.println("Hasta la proxima.");
		            return;
    			}
    			else{
    				
		            System.out.println("Opcion no permitida.");
    			}
    		}
        }
        else {
        	
        	System.out.println("Gracias por usar nuestro sistema");
            return;
        }
	}
}