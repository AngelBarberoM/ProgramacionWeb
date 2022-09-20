package Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import General.EspectaculoPaseMultiple;
import General.EspectaculoPuntual;
import General.EspectaculoTemporada;
import Espectaculos.Espectaculos;

/**
 * La clase MenuUserAdmin se utiliza para imprimir un menu 
 * correspondiente al usuario administrador
 *
 */

public class MenuUserAdmin {
	
	public void UserAdminMenu(String Correo){
		
		String Opcion = null;
        Espectaculos nuevoGestor = Espectaculos.getInstancia(Correo);
        EspectaculoPuntual especPuntual = new EspectaculoPuntual();
        EspectaculoPaseMultiple especPaseMultiple = new EspectaculoPaseMultiple();
        EspectaculoTemporada especTemporada = new EspectaculoTemporada();
		
		while(true){
			System.out.println("");
			System.out.println("----------------------------------------------");
			System.out.println("MENU DE ADMINISTRADOR: Gestion de Espectaculos");
			System.out.println("----------------------------------------------");
			System.out.println("Crear un espectaculo, pulse 1");
			System.out.println("Eliminar un espectaculo, pulse 2"); 
			System.out.println("Para actualizar la información sobre un espectaculo, pulse 3");
			System.out.println("----------------------------------------------");
			System.out.println("Para salir del menu, pulse cualquier otra tecla");
			System.out.println("----------------------------------------------");
						 
            BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
           
            try{
    			
            	Opcion = login.readLine();
    		} 
            catch (IOException Excep){
            	
    			Excep.printStackTrace();
    		}
            
            switch(Opcion){
            
            	case "1":
            	
	            	Scanner Teclado = new Scanner(System.in); 
	            	int Opcion1 = 0;

	    			System.out.println("");
	    			System.out.println("-----------------------------");
	            	System.out.println("CREACION DE ESPECTACULOS:");
	    			System.out.println("-----------------------------");
	            	System.out.println("Seleccione el tipo de espectaculo");
	    			System.out.println("-----------------------------");
	            	System.out.println("Espectaculo Puntual, pulse 1");
	            	System.out.println("Espectaculo Pase Multiple, pulse 2");
	            	System.out.println("Espectaculo Temporada, pulse 3");
	    			System.out.println("-----------------------------");
	    			System.out.println("Salir, pulse cualquier otra tecla");
	    			System.out.println("-----------------------------");
	            	
	            	Opcion1 = Integer.parseInt(Teclado.nextLine());
	            	
	            	switch(Opcion1){
	            	
	            	case 1:
	            		
	            		ArrayList<Integer> ids = new ArrayList<Integer>();
	            		System.out.println("Introduzca el nombre:");
	            		String Nombre = Teclado.nextLine();
	            		especPuntual.setNombre(Nombre);
	            		
	
	            		System.out.println("Introduzca la categoria:");
	            		String Categoria = Teclado.nextLine();
	            		especPuntual.setTipo(Categoria);
	            		
	            		System.out.println("Introduca el contenido:");
	            		String Contenido = Teclado.nextLine();
	            		especPuntual.setContenido(Contenido);
	            		
	            		System.out.println("Introduca el numero de localidades disponibles:");
	            		int localidadesTotales = Integer.parseInt(Teclado.nextLine());
	            		especPuntual.setLocalidadesTotales(localidadesTotales);
	            		
	            		System.out.println("Introduzca el numero de localidades vendidas:");
	            		int localidadesVendidas = Integer.parseInt(Teclado.nextLine());
	            		
	            		while(true){
	            			
		            		if((localidadesVendidas) > (localidadesTotales)){
		            			
		            			System.err.println("No puede haber mas localidades vendidas de las que hay");
		            			localidadesVendidas = Integer.parseInt(Teclado.nextLine());
		            		}
		            		else{
		            			
		            			break;
		            		}
	            		}
		            	
	            		especPuntual.setLocalidadesVendidas(localidadesVendidas);
	            		
	            		System.out.println("Introdu2"
	            				+ " espectaculo");
	            		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
	            		
	            		String date = Teclado.nextLine();
	            		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	            		LocalDateTime Date = LocalDateTime.parse(date, formato);
	            		
	            		especPuntual.setFecha(Date);
	            		especPuntual.setCritica(ids);
	            		nuevoGestor.CrearEspectaculoPuntual(especPuntual);
	            		
	            		break;
	            		
	            	case 2:
	            		ArrayList<Integer> iden1 = new ArrayList<Integer>();
	            		ArrayList<LocalDateTime> Pase = new ArrayList<LocalDateTime>();
	            		
	            		System.out.println("Introduzca el nombre:");
	            		String Nombre1 = Teclado.nextLine();
	            		especPaseMultiple.setNombre(Nombre1);
	            		
	
	            		System.out.println("Introduzca la categoria:");
	            		String Categoria1 = Teclado.nextLine();
	            		especPaseMultiple.setTipo(Categoria1);
	            		
	            		System.out.println("Introduca el Contenido:");
	            		String Contenido1 = Teclado.nextLine();
	            		especPaseMultiple.setContenido(Contenido1);
	            		
	            		System.out.println("Introduca el numero de localidades disponibles:");
	            		int localidadesTotales1 = Integer.parseInt(Teclado.nextLine());
	            		especPaseMultiple.setLocalidadesTotales(localidadesTotales1);
	            		
	            		System.out.println("Introduzca el numero de localidades vendidas:");
	            		int localidadesVendidas1 = Integer.parseInt(Teclado.nextLine());
	            		
	            		while(true){
	            			
		            		if((localidadesVendidas1) > (localidadesTotales1)){
		            			
		            			System.err.println("No puede haber mas localidades vendidas de las que hay");
		            			localidadesVendidas1 = Integer.parseInt(Teclado.nextLine());
		            		}
		            		else{
		            			
		            			break;
		            		}
	            		}
	            		
	            		especPaseMultiple.setLocalidadesVendidas(localidadesVendidas1);
	            		
	            		System.out.println("Indique cuantos Pase habra para el espectaculo");
	            		int NumeroPases = Integer.parseInt(Teclado.nextLine());
	            		
	            		for(int i = 0; i < NumeroPases; i++){
	            			
	                		System.out.println("Introduzca la fecha y hora del " + (i+1) + "º pase del espectaculo");
	                		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
	                		
	                		String date1 = Teclado.nextLine();
	                		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	                		LocalDateTime Date1 = LocalDateTime.parse(date1, formato1);
	                		Pase.add(Date1);
	            		}
	            		
	            		especPaseMultiple.setPase(Pase);
	            		especPaseMultiple.setCritica(iden1);
	            		nuevoGestor.CrearEspectaculoPaseMultiple(especPaseMultiple);
	            		
	            		break;
	            	
	            	case 3:
	            		
	            		ArrayList<Integer> iden2 = new ArrayList<Integer>();
	            		ArrayList<LocalDateTime> Fecha = new ArrayList<LocalDateTime>();
	            		System.out.println("Introduzca el nombre:");
	            		String Nombre2 = Teclado.nextLine();
	            		especTemporada.setNombre(Nombre2);
	            		
	
	            		System.out.println("Introduzca la categoria:");
	            		String Categoria2 = Teclado.nextLine();
	            		especTemporada.setTipo(Categoria2);
	            		
	            		System.out.println("Introduca el contenido:");
	            		String Contenido2 = Teclado.nextLine();
	            		especTemporada.setContenido(Contenido2);
	            		
	            		System.out.println("Introduca el numero de localidades disponibles:");
	            		int localidadesTotales2 = Integer.parseInt(Teclado.nextLine());
	            		especTemporada.setLocalidadesTotales(localidadesTotales2);
	            		
	            		System.out.println("Introduzca el numero de localidades vendidas:");
	            		int localidadesVendidas2 = Integer.parseInt(Teclado.nextLine());
	            		
	            		while(true){
	            			
		            		if((localidadesVendidas2) > (localidadesTotales2)){
		            			
		            			System.err.println("No puede haber mas localidades vendidas de las que hay");
		            			localidadesVendidas = Integer.parseInt(Teclado.nextLine());
		            		}
		            		else{
		            			
		            			break;
		            		}
	            		}
	            		
	            		especTemporada.setLocalidadesVendidas(localidadesVendidas2);
	            		
	            		System.out.println("Introduzca la fecha de Inicio");
	            		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
	            		
	            		String date2 = Teclado.nextLine();
	            		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	            		LocalDateTime Date2 = LocalDateTime.parse(date2, formato2);
	            		especTemporada.setInicioFecha(Date2);
	            		
	            		System.out.println("Introduzca la fecha de Fin");
	            		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
	            		String date3 = Teclado.nextLine();
	            		DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	            		LocalDateTime Date3 = LocalDateTime.parse(date3, formato3);
	            		especTemporada.setFinalFecha(Date3);
	            		
	            		System.out.println("Indique cuantas veces se va a repetir el espectaculo");
	            		
	            		int NumeroPases2 = Integer.parseInt(Teclado.nextLine());
	            		
	            		for(int i = 0; i < NumeroPases2; i++){
	            			
	                		System.out.println("Introduzca la fecha y hora del " + (i+1)+ "º pase del espectaculo");
	                		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
	                		
	                		String date4 = Teclado.nextLine();
	                		DateTimeFormatter formato4 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	                		LocalDateTime Date4 = LocalDateTime.parse(date4, formato4);
	                		Fecha.add(Date4);
	            		}
	            		
	            		especTemporada.setFecha(Fecha);
	            		especTemporada.setCritica(iden2);
	            		nuevoGestor.CrearEspectaculoTemporada(especTemporada);
	            		
	            		break;
	            	
	            	default:
	                    
	                	System.out.println("Saliendo del menu . . . ");
	                return;
	            	}
	            	
	            break;
            
            case "2":
            	
            	Scanner Teclado4 = new Scanner(System.in);
            	System.out.println("");
    			System.out.println("-----------------------------");
            	System.out.println("ELIMINACION DE ESPECTACULOS:");
    			System.out.println("-----------------------------");
            	System.out.println("Seleccione el tipo de espectaculo");
    			System.out.println("-----------------------------");
            	System.out.println("Espectaculo Puntual, pulse 1");
            	System.out.println("Espectaculo Pase Multiple, pulse 2");
            	System.out.println("Espectaculo Temporada, pulse 3");
    			System.out.println("-----------------------------");
    			System.out.println("Salir, pulse cualquier otra tecla");
    			System.out.println("-----------------------------");
            	int Opcion2 = Integer.parseInt(Teclado4.nextLine());
            	
            	System.out.println("Introduzca el titulo del espectaculo a eliminar");
            	String nombre = Teclado4.nextLine();
            	
            	switch(Opcion2)
            	{
            		case 1:
            			nuevoGestor.BorrarEspectaculoPuntual(nombre);
            			break;
            			
            		case 2:
            			nuevoGestor.BorrarEspectaculoPaseMultiple(nombre);
            			break;
            			
            		case 3:
            			nuevoGestor.BorrarEspectaculoTemporada(nombre);     			
            			break;
            	}
            
            case "3":
            	
            	Scanner Teclado5 = new Scanner(System.in); 
            	
            	System.out.println("");
            	System.out.println("-----------------------------------------");
            	System.out.println("ESPECTACULOS CONCRETO:");
            	System.out.println("-----------------------------------------");
            	System.out.println("Indique la clase de espectaculo que desea visualizar");
            	System.out.println("-----------------------------------------");
            	System.out.println("Espectaculo Puntual, pulse 1");
            	System.out.println("Espectaculo Pase Multiple, pulse 2");
            	System.out.println("Espectaculo Temporada, pulse 3");
            	System.out.println("-----------------------------------------");
            	System.out.println("Salir, pulse cualquier otra tecla");
            	System.out.println("-----------------------------------------");

            	int Opcion4 = Integer.parseInt(Teclado5.nextLine());
            	
            	System.out.println("Introduzca el titulo del espectaculo a eliminar");
            	String Nombre4 = Teclado5.nextLine();
            	
            	switch(Opcion4)
            	{
            		case 1:
            			nuevoGestor.actualizarEspectaculoPuntual(Nombre4);
            			break;
            			
            		case 2:
            			nuevoGestor.actualizarEspectaculoPaseMultiple(Nombre4);
            			break;
            			
            		case 3:
            			nuevoGestor.actualizarEspectaculoTemporada(Nombre4);     			
            			break;
            	}
            break;
            
            
            default:
            
            	System.out.println("Saliendo del menu . . . ");
            return;
            
            }
		}
	}	

}

