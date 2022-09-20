package MenuPrincipal;
import java.io.IOException;
import java.util.Scanner;
import MenusSecundarios.*;


public class MainMenu {
	
	public static void main(String args[]) throws IOException{
	
		MenuSesion login = new MenuSesion();
		String correo = login.inicioSesionMenu();
		String Opcion="0";
	   	Scanner lector = new Scanner(System.in);
		
	   	if(!correo.equals("")){
			
			while(Opcion.equals("1") || Opcion.equals("2") || Opcion.equals("3") || Opcion.equals("0") && (!correo.equals(""))){
			
				System.out.println("Bienvenido a nuestro sistema.");
			   	System.out.println("Para ir a gestion de usuario, pulse 1.");
			   	System.out.println("Para ir a gestion de criticas, pulse 2.");
			   	System.out.println("Para ir a gestion de espectaculos, pulse 3.");
			   	System.out.println("Para salir del menu, pulse cualquier otra tecla."); 
			   	
			   	if(lector.hasNextLine()){
			   		
			   		Opcion = lector.nextLine();
			   	}

				if("1".equals(Opcion)){ 
					
					MenuUsuario MenuUsuario = new MenuUsuario(correo);
					MenuUsuario.usuarioMenu();
				}
				else if("2".equals(Opcion)){ 
					
					MenuCritica MenuCritica = new MenuCritica(correo);
					MenuCritica.CriticasMenu();
				}
				else if("3".equals(Opcion)){ 
					
					MenuEspectaculo MenuEspectaculo = new MenuEspectaculo(correo);
					MenuEspectaculo.EspectaculoMenu();
				}
				else{
					
					System.out.println("Gracias por usar nuestro sistema.");
					System.out.println("Saliendo. . .");
					break;
				}
			}
		
			lector.close(); 
		}
	}
}
