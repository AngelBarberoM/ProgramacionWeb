package Menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Espectaculos.Espectaculos;

/**
 * La clase MenuEspectaculos se utiliza para imprimir un menu 
 * correspondiente a los espectaculos
 *
 */

public class MenuEspectaculos {
	
	public void EspectaculoMenu(String Correo){
		
		String Opcion = null;
        Espectaculos nuevoGestor = Espectaculos.getInstancia(Correo);

		while(true){
			
			System.out.println("");
			System.out.println("----------------------------------");
			System.out.println("Bienvenido al menu de Espectaculos");
			System.out.println("----------------------------------");
			System.out.println("Ver los espectaculos registrados, pulse 1.");
			System.out.println("Ver los espectaculos con entradas disponibles, pulse 2.");
			System.out.println("----------------------------------");
			System.out.println("Buscar un espectaculo por categoria, pulse 3.");
			System.out.println("Ver la informacion de un espectaculo concreto, pulse 4.");
			System.out.println("----------------------------------");
			System.out.println("Salir del menu, pulse cualquier otra tecla.");
			System.out.println("----------------------------------");
            
			BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
            try{
    			
            	Opcion = login.readLine();
    		} 
            catch (IOException Excep){
            	
            	Excep.printStackTrace();
    		}
            
            switch(Opcion)
            {
            
            case "1":
            	
            	String RutaTota = new File("").getAbsolutePath();
        		String RutaFich = RutaTota + "/Espectaculos.txt";
        		
        		FileReader FR = null;
        		BufferedReader BR = null;
        		try{
        			
        	        FR = new FileReader (RutaFich);
        	        BR = new BufferedReader(FR);	
        	        
        	        nuevoGestor.consultarEspectaculoPuntual();
        	        nuevoGestor.consultarEspectaculoPaseMultiple();
        	        nuevoGestor.consultarEspectaculoTemporada();
        	        
            		if (( BR.readLine()) == null){
            			
            			System.out.println("No hay ningun espectaculo registrado en el sistema !");
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
            
            case "2":
            	System.out.println("");
            	System.out.println("-----------------------------------------");
            	System.out.println("ESPECTACULOS CON LOCALIDADES DISPONIBLES:");
            	System.out.println("-----------------------------------------");
            	System.out.println("Indique la clase de espectaculo que desea visualizar");
            	System.out.println("-----------------------------------------");
            	System.out.println("Espectaculo Puntual, pulse 1");
            	System.out.println("Espectaculo Pase Multiple, pulse 2");
            	System.out.println("Espectaculo Temporada, pulse 3");
            	System.out.println("-----------------------------------------");
            	System.out.println("Salir, pulse cualquier otra tecla");
            	System.out.println("-----------------------------------------");

            	Scanner Teclado = new Scanner(System.in); 
            	int Opcion2 = Integer.parseInt(Teclado.nextLine());
            	
            	switch(Opcion2){
            		case 1:
            			
            			nuevoGestor.localidadesDisponiblesEspectaculoPuntual(); //SI FUNCIONA!!!!
            			break;
            			
            		case 2:
            			
            			nuevoGestor.localidadesDisponiblesEspectaculoPaseMultiple();
            			break;
            			
            		case 3:
            			
            			nuevoGestor.localidadesDisponiblesEspectaculoTemporada();     			
            			break;
            		
            		default:
                       
            			System.out.println("Saliendo del menu . . . ");
                        return;
            	}
            break;
            
            case "3":

            	System.out.println("BUSQUEDA DE ESPECTACULOS POR CATEGORIA:");
                Scanner Teclado3 = new Scanner(System.in);              
                System.out.println("Indique que categoria de espectaculos desea buscar:");
                String Categoria = Teclado3.nextLine();
                
                String RutaTotal3 = new File("").getAbsolutePath();
        		String RutaFich3 = RutaTotal3 + "/Espectaculos.txt";
        		
                FileReader FR3 = null;
        		BufferedReader BR3 = null;
        		
                try{
        	        
        			FR3 = new FileReader (RutaFich3);
        	        BR3 = new BufferedReader(FR3);	
        	        nuevoGestor.buscarCategoriaEspectaculoPuntual(Categoria);
                    nuevoGestor.buscarCategoriaEspectaculoPaseMultiple(Categoria);
                    nuevoGestor.buscarCategoriaEspectaculoTemporada(Categoria);

            		if (( BR3.readLine()) == null){
            			
            			System.out.println("No hay ningun espectaculo registrado!");
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
            
            case "4":
            	            	
            	Scanner Teclado4 = new Scanner(System.in); 
            	
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

            	int Opcion4 = Integer.parseInt(Teclado4.nextLine());
            	
            	System.out.println("Introduzca el titulo del espectaculo a visualizar");
            	String Nombre4 = Teclado4.nextLine();
            	
            	switch(Opcion4)
            	{
            		case 1:
            			nuevoGestor.buscarEspectaculoPuntual(Nombre4); //SI FUNCIONA!!!!
            			break;
            			
            		case 2:
            			nuevoGestor.buscarEspectaculoPaseMultiple(Nombre4);
            			break;
            			
            		case 3:
            			nuevoGestor.buscarEspectaculoTemporada(Nombre4);     			
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