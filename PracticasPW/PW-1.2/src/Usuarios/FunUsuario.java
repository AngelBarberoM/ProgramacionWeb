package Usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Criticas.FunCriticas;
import General.*;


/**
 * Clase que implementa funcionalidades de
 * lectura y escritura de personas o usuarios
 */
public class FunUsuario{
	
	/**
	 * Funcion que anadela critica al fichero Usuarios.txt,
	 * @param Nombre Nombre del usuario
	 * @param NombreUsuario Nombre de usuario de la persona
	 * @param Correo Correo del usuario
	 * @param Contrasena Contrasena del usuario
	 */
	public void RegistrarUsuarioFich(String Nombre, String Apellidos,String NombreUsuario, String Correo, String Contrasena){
		
		if(ComprobarExisteUsuario(Correo)==true){
			
			System.err.println("El correo ya esta registrado en nuestro sistema");
			System.exit(1);
		}
		else{
			
			String RutaTotal = new File("").getAbsolutePath();
			String RutaFich = RutaTotal + "/Usuarios.txt";
			FileWriter Archivo = null;
		    PrintWriter PW = null; 
		    
		    try{
		    	
		    	Archivo= new FileWriter(RutaFich, true); 
		    	PW = new PrintWriter(Archivo); 
		    	PW.println(Nombre+"//"+Apellidos+"//"+NombreUsuario+"//"+Correo+"//"+Contrasena);
		    	
		    } catch (Exception Excep){
		       
		    	Excep.printStackTrace();
		    
		    } finally{
		           try{
		        	 
		        	   if (Archivo != null) {
			             
		        		  Archivo.close();
			           }
		           } 
		           catch (Exception Excep2) {
		              
		        	   Excep2.printStackTrace();
		           	}
		    	}
	      }	
	}
	
	/**
	 * Funcion que registra una persona e introduce los datos en el fichero Usuarios.txt
	 * @param Nombre Nombre del usuario
	 * @param NombreUsuario Nombre de usuario de la persona
	 * @param Correo Correo del usuario
	 * @param Contrasena Contrasena del usuario
	 */
	public void RegistrarUsuarioFichMismoCorreo(String Nombre, String Apellidos, String NombreUsuario, String Correo, String Contrasena){
			
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Usuarios.txt";
		FileWriter Archivo = null;
	    PrintWriter PW = null; 
	    
	    try{
	    	
	    	Archivo= new FileWriter(RutaFich, true); 
	    	PW = new PrintWriter(Archivo); 
	    	PW.println(Nombre+"//"+Apellidos+"//"+NombreUsuario+"//"+Correo+"//"+Contrasena);
	    
	    } catch (Exception Excep){
	    	
	       Excep.printStackTrace();
	       
	    } finally{
	    	
	           try 
	           {
		           if (Archivo != null){
		        	   
		              Archivo.close();
		           }
	           } catch (Exception Excep2) {
	             
	        	   Excep2.printStackTrace();
           }
      }	
    }
	
	/**
	 * Metodo que lleva a un vector el contenido del fichero Usuarios.txt
	 * @param vector Vector de personas o usuarios
	 * @return Vector con todos los datos del fichero
	 */
	public ArrayList<Persona> fichToVec(ArrayList<Persona> vector){
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Usuarios.txt";
		FileReader FR = null;
		BufferedReader BR = null;
		Persona Persona1 = new Persona();
		
		try{
	        FR = new FileReader (RutaFich);
	        BR = new BufferedReader(FR);
	        String linea=""; 
	        while((linea=BR.readLine())!=null) {
			String[] data = linea.split("//");
			Persona1.setNombre(data[0]);
			Persona1.setApellidos(data[1]);
			Persona1.setNombreUsuario(data[2]);
        	Persona1.setCorreo(data[3]);
        	Persona1.setContrasena(data[4]); 
        	vector.add(Persona1); 
        	Persona1 = new Persona(); 
    	  
	    }
	        
		} catch(Exception Excep){
			
	         Excep.printStackTrace();
	         
	      } finally{
	         
	    	  try{                    
	            
	    		  if( null != FR ){   
	              
	    			  FR.close();     
	            }                  
	         }catch (Exception Excep2){ 
	           
	        	 Excep2.printStackTrace();
	         }
	       }
		
		return vector; 
	
	}
	
	/**
	 * Funcion que comprueba que existe un usuario
	 * @param Correo Correo de la persona o usuario
	 * @return true si exisite, false si no existe
	 */	
	public boolean ComprobarExisteUsuario(String Correo){
		
		ArrayList<Persona> vector = new ArrayList<Persona>();
		fichToVec(vector);
		
		for(Persona i : vector) {
			
			if(i.getCorreo().equals(Correo)){
				
				return true;
			}
		}
		return false;
	}


	/**
	 * Funcion que comprueba que la contrasena sea correcta
	 * @param Correo Correo de la persona o usuario
	 * @param Contrasena Contrasena de la persona o usuario
	 * @return true si es correcta, false si no es correcta
	 */	
	public boolean comprobarPassword(String Correo, String Contrasena){
		
		ArrayList<Persona> vector = new ArrayList<Persona>();
		vector = fichToVec(vector);
		for(Persona i : vector){
			
			if(i.getCorreo().equals(Correo)){
				
				if(i.getContrasena().equals(Contrasena)) {
					
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Funcion que comprueba que hay en el fichero Usuarios.txt 
	 * una persona o usuario con un correo determinado
	 * @param Correo Correo de la persona o usuario
	 * @return i Usuario que se busca y null si no se encuentra
	 */
	public Persona BuscarPorCorreo(String Correo){
		
		ArrayList<Persona> vector = new ArrayList<Persona>();
		vector = fichToVec(vector);
		
		for(Persona i : vector) {
			
			if(i.getCorreo().equals(Correo)) {
				
				return i;
			}
		}
		return null;
	}

	/**
	 * Funcion que imprime los datos del usuario del fichero Usuarios.txt
	 */
	public void ImprimirDatosUsuario(String Correo){
		
		Persona Persona1= new Persona(); 
		Persona1 = BuscarPorCorreo(Correo); 
		System.out.println("DATOS DE USUARIO SON: "); 
		System.out.println("----------------------");
		System.out.println("Nombre: " + Persona1.getNombre()); 
		System.out.println("Apellidos: " + Persona1.getApellidos()); 
		System.out.println("Usuario: " + Persona1.getNombreUsuario()); 
		System.out.println("Correo electronico: " + Persona1.getCorreo()); 
		
	}
	
	/**
	 * Funcion que borra del fichero Usuarios.txt una persona o usuario 
	 * a traves del correo
	 * @param Correo Correo de la persona o usuario
	 */
	public void BorrarUsuario(String Correo){
		
		ArrayList<Persona> vector = new ArrayList<Persona>();
		vector = fichToVec(vector);
		ArrayList<Persona> v2 = new ArrayList<Persona>();
		
		for(Persona i : vector) {
			
			if(!(i.getCorreo().equals(Correo))) {
				
				v2.add(i);
			}
		}
		BufferedWriter BW;
		try {
			
			BW = new BufferedWriter(new FileWriter("Usuarios.txt"));
			BW.write("");
			BW.close();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}		
		
		for(Persona i : v2) {
			
			i.RegistrarUsuarioFich(i.getNombre(), i.getApellidos(), i.getNombreUsuario(), i.getCorreo(), i.getContrasena());
		}
	}

	/**
	 * Funcion que guarda los datos de una persona o usuario 
	 * en un nuevo objeto de la clase Persona
	 * @return Persona1 objeto de la clase Persona
	 */
	public Persona ProveerDatos() {
		
		String Correo = null, Contrasena=null, Nombre=null, Apellidos=null, NombreUsuario=null;
		System.out.println("INTRODUZCA SUS DATOS: ");
		System.out.println("----------------------");
		System.out.println("INTRODUZCA SU CORREO:");
		BufferedReader Registrar = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			Correo = Registrar.readLine();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}
		
		System.out.println("INTRODUZCA SU CONTRASE�A:");
		BufferedReader Registrar1 = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			Contrasena = Registrar1.readLine();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}
		
		System.out.println("INTRODUZCA SU NOMBRE:");
		BufferedReader Registrar2 = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			Nombre = Registrar2.readLine();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}
		
		System.out.println("INTRODUZCA SUS APELLIDOS:");
		BufferedReader Registrar3 = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			Apellidos = Registrar3.readLine();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}
		
		System.out.println("INTRODUZCA SU USUARIO:");
		BufferedReader Registrar4 = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			NombreUsuario = Registrar4.readLine();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}
		Persona Persona1 = new Persona(Nombre, Apellidos, Correo, NombreUsuario, Contrasena);
		
		return Persona1;
	}
	
	/**
	 * Funcion que actualiza los datos de una persona o usuario.
	 * @param Correo Correo de la persona o usuario
	 */
	public void ActualizarUsuario(String Correo){
		
		FunCriticas ioc = new FunCriticas(); 
		String correo = null; 
		Scanner correo_scan = new Scanner(System.in);
		String nombre = null; 
		Scanner nombre_scan = new Scanner(System.in); 
		String apellidos = null; 
		Scanner apellidos_scan = new Scanner(System.in); 
		String contrasena = null; 
		Scanner contrasena_scan = new Scanner(System.in);
		String nombreusuario = null; 
		Scanner nombreusuario_scan = new Scanner(System.in);
		this.ImprimirDatosUsuario(Correo);
		Persona Persona1 = this.ProveerDatos();
		correo= Persona1.getCorreo(); 
    			
		while(correo.equals("") || correo.trim().isEmpty() || ComprobarExisteUsuario(correo)==true){
			
			if(ComprobarExisteUsuario(Persona1.getCorreo())==true){
				
				if(correo.equals(Correo)){
					
					break; 
				}
				else{
					
					System.err.println("Correo electronico existente. Indique otro correo electronico.");
					correo = correo_scan.nextLine();
				}
			}
			else if(correo.trim().isEmpty() || ComprobarExisteUsuario(Persona1.getCorreo())==true){
				
				System.err.println("No se puede dejar vacio el campo correo electronico."); 
    			correo = correo_scan.nextLine();
			}
			else{
				
				break; 
			}
		}
    	
    	nombre = Persona1.getNombre(); 
		
    	while(nombre.equals("") || nombre.trim().isEmpty()){
    				
			if(nombre.equals("") || nombre.trim().isEmpty()){
				
				System.err.println("No se puede dejar vacio el campo nombre.");
				nombre=nombre_scan.nextLine(); 
			}
			else{
				
				break; 
			}
		}
    	
    	apellidos = Persona1.getApellidos(); 
		
    	while(apellidos.equals("") || apellidos.trim().isEmpty()){
    				
			if(apellidos.equals("") || apellidos.trim().isEmpty()){
				
				System.err.println("No se puede dejar vacio el campo apellidos.");
				apellidos=apellidos_scan.nextLine(); 
			}
			else{
				
				break; 
			}
		}
    	
    	nombreusuario= Persona1.getNombreUsuario(); 
    	
		while(nombreusuario.equals("") || nombreusuario.trim().isEmpty()){
			
			if(nombreusuario.equals("") || nombreusuario.trim().isEmpty()){
				
				System.err.println("No se puede dejar vacio el campo nombreusuario.");
				nombreusuario=nombreusuario_scan.nextLine(); 
			}
			else{
				
				break; 
			}
		}
		
    	contrasena = Persona1.getContrasena(); 
		
    	while(contrasena.equals("") || contrasena.trim().isEmpty()){
			
    		if( contrasena.equals("") || contrasena.trim().isEmpty()){
				
    			System.err.println("No se puede dejar vacio el campo password.");
				contrasena=contrasena_scan.nextLine(); 
			}
			else{
			
				break; 
			}
		}
    	Persona1.setNombre(nombre);
    	Persona1.setApellidos(apellidos);
    	Persona1.setNombreUsuario(nombreusuario);
    	Persona1.setCorreo(correo);
    	Persona1.setContrasena(contrasena);
		
    	this.BorrarUsuario(Correo);
		
		if(correo.equals(Correo)){
			
			this.RegistrarUsuarioFichMismoCorreo(Persona1.getNombre(), Persona1.getApellidos(), Persona1.getNombreUsuario(), Persona1.getCorreo(), Persona1.getContrasena());
		}	
		else{
			
			this.RegistrarUsuarioFichMismoCorreo(Persona1.getNombre(), Persona1.getApellidos(), Persona1.getNombreUsuario(), Persona1.getCorreo(), Persona1.getContrasena());
		}
		System.out.println("Sus credenciales han sido actualizadas. Por favor, acceda al sistema con sus nuevas credenciales.");
		ioc.ActualizarCriticasUsuario(Correo, Persona1.getCorreo());
		
		nombre_scan.close(); 
		apellidos_scan.close();
		nombreusuario_scan.close(); 
		correo_scan.close();
		contrasena_scan.close();
	}
}