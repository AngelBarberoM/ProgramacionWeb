package Menu;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Criticas.*;
import General.Critica;

/**
 * La clase MenuCriticas se utiliza para imprimir un menu 
 * correspondiente a las criticas
 *
 */
public class MenuCriticas {

	public boolean isNumeric(String string){
		
		boolean aux = false; 
	   	
		for (int i = 0; i < string.length(); i++){
		  
	   		 if (Character.isDigit(string.charAt(i))){
		      
		    	 aux = true; 
		     }
	    }
	    return aux;
	}
	
	/** 
	* Menu el cual realiza lo necesario para las criticas
	* @param Correo Correo de la persona.
	*/
	public void criticasMenu(String Correo){

		String Opcion = null;
		Critica crit = new Critica();
        Criticas nuevoGestor = Criticas.getInstancia(Correo);
        FunCriticas nuevoFunCriticas = new FunCriticas();
        	
        while(true){
        	
    		System.out.println(""); 
    		System.out.println("-------------------------------");
    		System.out.println("Bienvenido al menu de criticas.");
    		System.out.println("-------------------------------"); 
    	    System.out.println("Crear una critica, pulse 1.");
    	    System.out.println("Consultar criticas, pulse 2.");
    	    System.out.println("Borrar una critica, pulse 3.");
    		System.out.println("-------------------------------"); 
    	    System.out.println("Votar positivamente una critica, pulse 4.");
    	    System.out.println("Votar negativamente, pulse 5.");
    		System.out.println("-------------------------------"); 
    	    System.out.println("Buscar tus criticas, pulse 6.");
    	    System.out.println("Ver las criticas de un usuario concreto, pulse 7.");
    		System.out.println("-------------------------------"); 
    	    System.out.println("Salir del menu, pulse cualquier otra tecla.");
            System.out.println("-----------------------------");
    	    
            BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
            
            try{
            	
    			Opcion = login.readLine();
    			
    		} catch (IOException Excep) {
    			
    			Excep.printStackTrace();
    		}
            
            switch(Opcion){
            	
            	case "1":
            		
                    Scanner teclado1 = new Scanner(System.in);              
                    
                    ArrayList<String> votantes = new ArrayList<String>();
                    
            		System.out.println("CREACION DE CRITICAS");
            		System.out.println("Introduzca el nombre de la critica.");
            		
            		String titulo;
            		titulo = teclado1.nextLine();
            		
            		while(true){
            			if(titulo.equals("") || titulo.trim().isEmpty()){
                			
            				System.err.println("No puede dejar vacio este campo. Intentelo de nuevo"); 
                			titulo = teclado1.nextLine();
            			}
            			else{
                           
            				break; 
            			}
            		}
                    crit.setTitulo(titulo);
                    

            		System.out.println("Puntua la critica del 0 al 10:");
            		
            		String puntuacion; 
            		puntuacion = teclado1.nextLine(); 
          		
                        while(!isNumeric(puntuacion) || Float.parseFloat(puntuacion)<0 || Float.parseFloat(puntuacion)>10){
                        	
                        	if(!isNumeric(puntuacion)){
			                    
                        		System.err.println("La puntuación tiene que ser numerica. Intentelo de nuevo.");
			                    System.out.println("(Ejemplo: 6.5)");
			                    puntuacion = teclado1.nextLine(); 
                        	}
                        	else{
		                       
                        		System.err.println("La puntuacion debe ser un numero entre 1 y 10. Intentelo de nuevo.");
		                    	System.out.println("(Ejemplo: 6.5)");
		                    	puntuacion = teclado1.nextLine();
		                    	
		                    	if(!isNumeric(puntuacion)){
				                    
		                    		System.err.println("La puntuación tiene que ser numerica. Intentelo de nuevo.");
				                    System.out.println("(Ejemplo: 6.5)");
				                    puntuacion = teclado1.nextLine(); 
		                		}
                        	}
                        }
                    crit.setPuntuacion(Float.parseFloat(puntuacion));       		
            		System.out.println("Escriba su resena");
            		
            		String resena;
            		resena = teclado1.nextLine();
            		
            		while(true){
            			
            			if(resena.equals("") || resena.trim().isEmpty()){
                			
            				System.err.println("No puede dejar vacio este campo. Intentelo de nuevo"); 
                			resena = teclado1.nextLine();
            			}
            			else{
            				
                            break; 
            			}
            		}
                    crit.setId(nuevoFunCriticas.GenerarId()); 
                    crit.setResena(resena);
                    crit.setCorreo(Correo);
                    crit.setVotantes(votantes);
            		nuevoGestor.crearCritica(crit);
            		break;
            	
            	case "2":
            		
            		String RutaTota = new File("").getAbsolutePath();
            		String RutaFich = RutaTota + "/Criticas.txt";
            		
            		FileReader FR = null;
            		BufferedReader BR = null;
            		try{
            	        FR = new FileReader (RutaFich);
            	        BR = new BufferedReader(FR);	
            	        nuevoGestor.imprimirCriticas();
            	        
                		if (( BR.readLine()) == null){
                			
                			System.out.println("No hay ninguna critica registrada en el sistema !");
                			System.out.println("");
                		}
            		}
            		
            		catch(Exception Excep){
            			
            			Excep.printStackTrace();
            		}
            		finally{
            			
            			try{                    
            				if( null != FR ){   
            					
            					FR.close();     
            				}                  
            			}
            			catch (Exception Excep2){ 
            				
            				Excep2.printStackTrace();
            			}
            		}
            		break;
            		                	
            	case "3":
            		            		
            		Scanner teclado3 = new Scanner(System.in);  
            		String id;
            		
            		System.out.println("ELIMINACION DE CRITICAS");
            		nuevoGestor.buscarCriticas(Correo);
            		
            		System.out.println("Introduzca el id de la critica que desea borrar");
                   
                    id = (teclado3.nextLine());
                    
                    while(!isNumeric(id)){
        				
                    	System.err.println("El ID de la critica debe ser numérico. Intentelo de nuevo.");
        				id = (teclado3.nextLine());
        			}
                    if(nuevoFunCriticas.ExisteId(Integer.parseInt(id)) == true){
                    	
                    	nuevoFunCriticas.borrarCritica(Integer.parseInt(id), Correo);
                    	System.out.println("Critica borrada correctamente."); 
                    }
                    else{
                    	
                    	System.err.println("El ID indicado no existe. Intentelo de nuevo.");	
                    }
                    
            		break;
            		
            	case "4":
            
            		String iden1;
            		
            		System.out.println("Se mostraran por pantalla las diferentes criticas para que selecciona el ID de la critica que desea puntuar:");
            		System.out.println("");
            		String RutaTota1 = new File("").getAbsolutePath();
            		String RutaFich1 = RutaTota1 + "/Criticas.txt";
            		
            		FileReader FR1 = null;
            		BufferedReader BR1 = null;
            		try{
            			
            	        FR1 = new FileReader (RutaFich1);
            	        BR1 = new BufferedReader(FR1);	
            	        nuevoGestor.imprimirCriticas();
            	        
                		if (( BR1.readLine()) == null){
                			
                			System.out.println("No hay ninguna critica registrada en el sistema !");
                			System.out.println("");
                		}
                		else{
                    		
                			System.out.println("Indique el ID de la critica que desea puntuar");
                    		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                    		
                			iden1 = reader1.readLine();
                			
                			while(!isNumeric(iden1)){
                				
                				System.err.println("El ID de la critica debe ser numérico.Intentelo de nuevo.");
                				iden1 = reader1.readLine();
                			}
                				
                			if(nuevoFunCriticas.ExisteId(Integer.parseInt(iden1))){
                				
                				nuevoGestor.votarCriticasPos(Integer.parseInt(iden1));
                			}
                            else{
                           
                            	System.err.println("El ID indicado no existe. Intentelo de nuevo.");	
                            }
                            
                		}
            		}
            		
            		catch(Exception Excep){
            			
            			Excep.printStackTrace();
            		}
            		finally{
            			
            			try{                    
            				
            				if( null != FR1 ){   
            					
            					FR1.close();     
            				}                  
            			}
            			catch (Exception e2){ 
            				
            				e2.printStackTrace();
            			}
            		}                		
            		
            		break;
            	
            	case "5":
            		
            		System.out.println("Se mostraran por pantalla las diferentes criticas para que selecciona el ID de la critica que desea puntuar:");
            		System.out.println("");
            		String RutaTotal2 = new File("").getAbsolutePath();
            		String RutaFich2 = RutaTotal2 + "/Criticas.txt";
            		
            		FileReader FR2 = null;
            		BufferedReader BR2 = null;
            		
            		try{
            	        
            			FR2 = new FileReader (RutaFich2);
            	        BR2 = new BufferedReader(FR2);	
            	        nuevoGestor.imprimirCriticas();
            	        
                		if (( BR2.readLine()) == null){
                			
                			System.out.println("No hay ninguna critica registrada en el sistema !");
                			System.out.println("");
                		}
                		else{
                    		
                			System.out.println("Indique el ID de la critica que desea puntuar");
                    		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                    		
                			iden1 = reader1.readLine();
                			
                			while(!isNumeric(iden1)){
                				
                				System.out.println("El ID de la critica debe ser numérico. Intentelo de nuevo.");
                				iden1 = reader1.readLine();
                			}
                				
                			if(nuevoFunCriticas.ExisteId(Integer.parseInt(iden1))){
                				
                				nuevoGestor.votarCriticasNeg(Integer.parseInt(iden1));
                			}
                            else{
                            	
                            	System.out.println("El ID indicado no existe. Intentelo de nuevo.");	
                            }
                		}
            		}
            		
            		catch(Exception Excep){
            			
            			Excep.printStackTrace();
            		}
            		finally{
            			
            			try{                    
            				
            				if( null != FR2 ){   
            					
            					FR2.close();     
            				}                  
            			}
            			catch (Exception Excep2){ 
            				
            				Excep2.printStackTrace();
            			}
            		}
            		break;

            	case "6":
            	
            		String RutaTotal3 = new File("").getAbsolutePath();
            		String RutaFich3 = RutaTotal3 + "/Criticas.txt";
            		
            		FileReader FR3 = null;
            		BufferedReader BR3 = null;
            		
            		try{
            	        
            			FR3 = new FileReader (RutaFich3);
            	        BR3 = new BufferedReader(FR3);	
            	        nuevoGestor.buscarCriticas(Correo);
            	        
                		if (( BR3.readLine()) == null){
                			
                			System.out.println("No hay ninguna critica registrada en el sistema !");
                			System.out.println("");
                		}
            		}
            		
            		catch(Exception Excep){
            			
            			Excep.printStackTrace();
            		}
            		finally{
            			
            			try{                    
            				if( null != FR3 ){   
            					
            					FR3.close();     
            				}                  
            			}
            			catch (Exception Excep2){ 
            				
            				Excep2.printStackTrace();
            			}
            		}
            		break;                		

            	case "7":
            		
            		String correo = null;
            		Scanner teclado4 = new Scanner(System.in);  

            		System.out.println("Introduzca el correo del usuario cuyas criticas quiere ver");
                   
                    correo = (teclado4.nextLine());
        	        nuevoGestor.buscarCriticas(correo);
            		break;
            		
            	default:
            		
            		System.out.println("Saliendo...\n\n");
                	return;
                
                }
        	}
	}
}
