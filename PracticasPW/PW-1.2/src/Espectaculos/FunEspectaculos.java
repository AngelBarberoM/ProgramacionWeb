package Espectaculos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import General.EspectaculoPaseMultiple;
import General.EspectaculoPuntual;
import General.EspectaculoTemporada;


public class FunEspectaculos {

	public void EspectaculoPuntualToFich(String Nombre, String Categoria, String Contenido, int LocalidadesTotales, int LocalidadesVendidas, LocalDateTime Fecha, ArrayList<Integer> identificador){		
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Espectaculos.txt";
		FileWriter Archivo = null;
		PrintWriter PW = null;
		
	    try{	
	    	
	    	Archivo= new FileWriter(RutaFich, true); 
	    	PW = new PrintWriter(Archivo); 
	    	
	    	PW.print("1//"+Nombre+"//"+Categoria+"//" +Contenido+"//"+LocalidadesTotales+ "//" +LocalidadesVendidas+ "//" +DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(Fecha)+ "//");
	    	
	    	if(identificador != null){
	    		
	    		for(int s : identificador){
		    		
	    			PW.print(s+"::");
		    	}
		    	
	    		PW.print("//");
	    	}
	    	else{
	    		
	    		PW.print("void//");
	    	}
	    	
	    	PW.println("");
	    	
	    }catch (Exception Excep){
	    	
	    	Excep.printStackTrace();
	    	
	    } finally{
	    	
	    	try{
	    		if (Archivo != null) {
	    			
	    			Archivo.close();
	    		}
	    		
    		} catch (Exception Excep2) {
              
           		Excep2.printStackTrace();
           }
        }	
    }
	
	
	
	public void EspectaculoPaseMultipleToFich(String Nombre, String Categoria, String Contenido, int LocalidadesTotales, int LocalidadesVendidas, ArrayList<LocalDateTime> Pase, ArrayList<Integer> identificador){		
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Espectaculos.txt";
		FileWriter Archivo = null;
	    PrintWriter PW = null; 
	    
	    try{	
	    	
	    	Archivo= new FileWriter(RutaFich, true); 
	    	PW = new PrintWriter(Archivo); 
	    	
	    	PW.print("2//"+Nombre+"//"+Categoria+"//" +Contenido+"//"+LocalidadesTotales+ "//" +LocalidadesVendidas+ "//");
	    	
	    	if(Pase != null){
	    		
	    		for(LocalDateTime fecha : Pase) {
		    		
	    			PW.print(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(fecha)+",,");
		    	}
		    	
	    		PW.print("//");
	    	}
	    	
	    	if(identificador != null){
	    		
	    		for(int s : identificador){
		    		
	    			PW.print(s+"::");
		    	}
		    	
	    		PW.print("//");
	    	}
	    	else{
	    		
	    		PW.print("void//");
	    	}
	    	
	    	PW.println("");
	  
	    }catch (Exception Excep) {
	    	
	    	Excep.printStackTrace();
	       
	    } finally{
	    	
	    	try {
	        	   
	    		if (Archivo != null) {
	    			
	    			Archivo.close();
	    		}
	    		
	       	} catch (Exception Excep2) {
	       		
	       		Excep2.printStackTrace();
	       }
	    }	
	}
	
	
	
	
	public void EspectaculoTemporadaToFich(String Nombre, String Categoria, String Contenido, int LocalidadesTotales, int LocalidadesVendidas, LocalDateTime inicio, LocalDateTime fin, ArrayList<LocalDateTime>fechas, ArrayList<Integer> identificador){		
	
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Espectaculos.txt";
		FileWriter Archivo = null;
	    PrintWriter PW = null; 
	  
	    try{	
	    	
	    	Archivo= new FileWriter(RutaFich, true); 
	    	PW = new PrintWriter(Archivo); 
	    	PW.print("3//"+Nombre+"//"+Categoria+"//" +Contenido+"//"+LocalidadesTotales+ "//" +LocalidadesVendidas+ "//" +DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(inicio)+ "//" +DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(fin)+ "//");
	    	
	    	if(fechas != null){
	    		
	    		for(LocalDateTime f : fechas){
		    		
	    			PW.print(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(f)+",,");
		    	}
		    	
	    		PW.print("//");
	    	}
	    	
	    	if(identificador != null){
	    		
	    		for(int s : identificador){
	    			
		    		PW.print(s+"::");
		    	}
		    	
	    		PW.print("//");
	    	}
	    	else{
	    		
	    		PW.print("void//");
	    	}
	    	
	    	PW.println("");
	    	
	    }catch (Exception Excep){
	    	
	    	Excep.printStackTrace();
	       
	    } finally{
	    	
	    	try{
	    		if (Archivo != null) {
	    			
	    			Archivo.close();
	    		}
	    		
    		} catch (Exception Excep2){
    			
    			Excep2.printStackTrace();
           }
	    }	
	}
	
	
	
	
	public ArrayList<EspectaculoPuntual> EspectaculoPuntualToVector(ArrayList<EspectaculoPuntual> vector){
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Espectaculos.txt";
		FileReader FR = null;
		BufferedReader BR = null;
		EspectaculoPuntual especPuntual = new EspectaculoPuntual(); 
				
		try{

	        FR = new FileReader (RutaFich);
	        BR = new BufferedReader(FR);
	        String Fila; 
        	
	        while ((Fila = BR.readLine()) != null) {
        		
	        	if(Fila.substring(0, 1).equals("1")){
	        	    
	        		String[] data = Fila.split("//");
			    	especPuntual.setNombre(data[1]);
			    	especPuntual.setTipo(data[2]);
			    	especPuntual.setContenido(data[3]);
			    	especPuntual.setLocalidadesTotales(Integer.parseInt(data[4]));
			    	especPuntual.setLocalidadesVendidas(Integer.parseInt(data[5]));
			    	
			    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	        		LocalDateTime dateTime0 = LocalDateTime.parse(data[6], formato);
			    	especPuntual.setFecha(dateTime0);
			    	
			    	vector.add(especPuntual); 
			    	especPuntual = new EspectaculoPuntual();
			    	
        		}
        	}
	        
		}catch(Exception Excep){
			
			Excep.printStackTrace();
	     
		}finally{

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

	
	
	
	public ArrayList<EspectaculoPaseMultiple> EspectaculoPaseMultipleToVector(ArrayList<EspectaculoPaseMultiple> vector){
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Espectaculos.txt";
		FileReader FR = null;
		BufferedReader BR = null;
		EspectaculoPaseMultiple especPaseMultiple = new EspectaculoPaseMultiple(); 
				
		try {

	        FR = new FileReader (RutaFich);
	        BR = new BufferedReader(FR);
	       
	        String Fila; 
	        ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
        	
	        while ((Fila = BR.readLine()) != null){
        		
        		if(Fila.substring(0, 1).equals("2")){
        			
	        	    String[] data = Fila.split("//");
			    	especPaseMultiple.setNombre(data[1]);
			    	especPaseMultiple.setTipo(data[2]);
			    	especPaseMultiple.setContenido(data[3]);
			    	especPaseMultiple.setLocalidadesTotales(Integer.parseInt(data[4]));
			    	especPaseMultiple.setLocalidadesVendidas(Integer.parseInt(data[5]));		    	
			    	
			    	String[] data2 = data[6].split(",,");
				    
			    	for(int i=0; i<data2.length; i++){
					   
			    		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			        	LocalDateTime dateTime0 = LocalDateTime.parse(data2[i], formato);
					    dates.add(dateTime0);
				    } 
				    
			    	especPaseMultiple.setPase(dates);
			    	
        		}
		    	vector.add(especPaseMultiple); 
		    	especPaseMultiple = new EspectaculoPaseMultiple();

		    	dates = new ArrayList<LocalDateTime>();
    		}
    	}
	        
		catch(Exception Excep){
			
			Excep.printStackTrace();
	     
		}finally{

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
	
	public ArrayList<EspectaculoTemporada> EspectaculoTemporadaToVector(ArrayList<EspectaculoTemporada> vector){
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Espectaculos.txt";
		FileReader FR = null;
		BufferedReader BR = null;
		EspectaculoTemporada especTemporada = new EspectaculoTemporada(); 
				
		try {

	        FR = new FileReader (RutaFich);
	        BR = new BufferedReader(FR);
	       
	        String Fila; 

	        ArrayList<LocalDateTime> dates = new ArrayList<LocalDateTime>();
        	
	        while ((Fila = BR.readLine()) != null ){
	        	
        		if(Fila.substring(0, 1).equals("2")){
        			
        			String[] data = Fila.split("//");
			    	especTemporada.setNombre(data[1]);
			    	especTemporada.setTipo(data[2]);
			    	especTemporada.setContenido(data[3]);
			    	especTemporada.setLocalidadesTotales(Integer.parseInt(data[4]));
			    	especTemporada.setLocalidadesVendidas(Integer.parseInt(data[5]));	
			    	
			    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	        		LocalDateTime dateTime0 = LocalDateTime.parse(data[6], formato);
			    	especTemporada.setInicioFecha(dateTime0);
			    	
			    	DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	        		LocalDateTime dateTime1 = LocalDateTime.parse(data[7], formato1);
			    	especTemporada.setFinalFecha(dateTime1);
		
		    		String[] data2 = data[8].split(",,");
			    	
		    		for(int i=0; i<data2.length; i++){
				    	
		    			DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		        		LocalDateTime dateTime2 = LocalDateTime.parse(data2[i], formato2);
				    	dates.add(dateTime2);
			    	} 
			    	
			    	especTemporada.setFecha(dates);

			    	vector.add(especTemporada); 
			    	especTemporada = new EspectaculoTemporada();

			    	dates = new ArrayList<LocalDateTime>();
        		}
        	}
        		
		}catch(Exception Excep){
			
			Excep.printStackTrace();
			
    	}finally{

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
	
	
	
	
	public boolean comprobarExisteEspectaculoPuntual(String Nombre){
		
		ArrayList<EspectaculoPuntual> vector = new ArrayList<EspectaculoPuntual>();
		EspectaculoPuntualToVector(vector);
		
		for(EspectaculoPuntual especPuntual : vector){
			
			if(especPuntual.getNombre().equals(Nombre)){
				
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	public boolean comprobarExisteEspectaculoPaseMultiple(String Nombre){
		
		ArrayList<EspectaculoPaseMultiple> vector = new ArrayList<EspectaculoPaseMultiple>();
		EspectaculoPaseMultipleToVector(vector);
		
		for(EspectaculoPaseMultiple especPaseMultiple : vector){
			
			if(especPaseMultiple.getNombre().equals(Nombre)){
				
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public boolean comprobarExisteEspectaculoTemporada(String Nombre){
		
		ArrayList<EspectaculoTemporada> vector = new ArrayList<EspectaculoTemporada>();
		EspectaculoTemporadaToVector(vector);
		
		for(EspectaculoTemporada especTemporada : vector){
			
			if(especTemporada.getNombre().equals(Nombre)){
				
				return true;
			}
		}
		return false;
	}
	
	
	

	public void borrarEspectaculoPuntual(String Nombre) {
		
		ArrayList<EspectaculoPuntual> vector = new ArrayList<EspectaculoPuntual>();

		vector = this.EspectaculoPuntualToVector(vector);
		
		ArrayList<EspectaculoPaseMultiple> aux = new ArrayList<EspectaculoPaseMultiple>();
		ArrayList<EspectaculoTemporada> aux2 = new ArrayList<EspectaculoTemporada>();

		aux = this.EspectaculoPaseMultipleToVector(aux);
		aux2 = this.EspectaculoTemporadaToVector(aux2);
		
		for(EspectaculoPuntual especPuntual : vector){
			
			if(especPuntual.getNombre().equals(Nombre)){
		
				vector.remove(especPuntual);
			}
		}
		
		BufferedWriter BW;
		
		try{
			
			BW = new BufferedWriter(new FileWriter("Espectaculos.txt"));
			BW.write("");
			BW.close();
		
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}
		
		if(vector.isEmpty()) {
			
			for(EspectaculoPuntual especPuntual : vector){
					
				especPuntual.EspectaculoPuntualToFich(especPuntual.getNombre(), especPuntual.getTipo(), especPuntual.getContenido(), especPuntual.getLocalidadesTotales(), especPuntual.getLocalidadesVendidas(), especPuntual.getFecha(),especPuntual.getCritica());
			}
		}
		
		if(!aux.isEmpty()){
			
			for(EspectaculoPaseMultiple especPaseMultiple : aux){
				
				especPaseMultiple.EspectaculoPaseMultipleToFich(especPaseMultiple.getNombre(), especPaseMultiple.getTipo(), especPaseMultiple.getContenido(), especPaseMultiple.getLocalidadesTotales(), especPaseMultiple.getLocalidadesVendidas(), especPaseMultiple.getPase(), especPaseMultiple.getCritica());
			}
		}
		
		
		if(!aux2.isEmpty()){
			
			for(EspectaculoTemporada especTemporada : aux2){
				
				especTemporada.EspectaculoTemporadaToFich(especTemporada.getNombre(), especTemporada.getTipo(), especTemporada.getContenido(), especTemporada.getLocalidadesTotales(), especTemporada.getLocalidadesVendidas(), especTemporada.getInicioFecha(), especTemporada.getFinalFecha(), especTemporada.getFecha() ,especTemporada.getCritica());
			}
		}
		/*
		ArrayList<EspectaculoPuntual> vector = new ArrayList<EspectaculoPuntual>();
		vector = EspectaculoPuntualToVector(vector);
		
		ArrayList<EspectaculoPuntual> aux = new ArrayList<EspectaculoPuntual>();
		ArrayList<EspectaculoPaseMultiple> aux1 = new ArrayList<EspectaculoPaseMultiple>();
		ArrayList<EspectaculoTemporada> aux2 = new ArrayList<EspectaculoTemporada>();
		
		aux1 = EspectaculoPaseMultipleToVector(aux1);
		aux2 = EspectaculoTemporadaToVector(aux2);
		
		for(EspectaculoPuntual especPuntual : vector){
			
			if(!(especPuntual.getNombre().equals(Nombre))){
				
				aux.add(especPuntual);
			}
		}
		
		BufferedWriter BW;
		
		try{
			
			BW = new BufferedWriter(new FileWriter("Espectaculos.txt"));
			BW.write("");
			BW.close();
			
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}
		
		
		for(EspectaculoPuntual especPuntual : aux){
			
			especPuntual.EspectaculoPuntualToFich(especPuntual.getNombre(), especPuntual.getTipo(), especPuntual.getContenido(), especPuntual.getLocalidadesTotales(), especPuntual.getLocalidadesVendidas(), especPuntual.getFecha(),especPuntual.getCritica());
		}
		

		for(EspectaculoPaseMultiple especPaseMultiple : aux1){
			
			especPaseMultiple.EspectaculoPaseMultipleToFich(especPaseMultiple.getNombre(), especPaseMultiple.getTipo(), especPaseMultiple.getContenido(), especPaseMultiple.getLocalidadesTotales(), especPaseMultiple.getLocalidadesVendidas(), especPaseMultiple.getPase(), especPaseMultiple.getCritica());
		}
		

		for(EspectaculoTemporada especTemporada : aux2){
			
			especTemporada.EspectaculoTemporadaToFich(especTemporada.getNombre(), especTemporada.getTipo(), especTemporada.getContenido(), especTemporada.getLocalidadesTotales(), especTemporada.getLocalidadesVendidas(), especTemporada.getInicioFecha(), especTemporada.getFinalFecha(), especTemporada.getFecha() ,especTemporada.getCritica());
		}
		*/
	}
	
	
	
	
	public void borrarEspectaculoPaseMultiple(String Nombre) {
		
		ArrayList<EspectaculoPaseMultiple> vector = new ArrayList<EspectaculoPaseMultiple>();
		
		vector = EspectaculoPaseMultipleToVector(vector);
		
		ArrayList<EspectaculoPuntual> aux = new ArrayList<EspectaculoPuntual>();
		ArrayList<EspectaculoTemporada> aux2 = new ArrayList<EspectaculoTemporada>();
		
		aux = EspectaculoPuntualToVector(aux);
		aux2 = EspectaculoTemporadaToVector(aux2);
		
		for(EspectaculoPaseMultiple especPaseMultiple : vector){
			
			if(Nombre.equals(especPaseMultiple.getNombre())){
		
				vector.remove(especPaseMultiple);
			}
		}
		
		BufferedWriter BW;
		
		try{
			
			BW = new BufferedWriter(new FileWriter("Espectaculos.txt"));
			BW.write("");
			BW.close();
		
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}
		
		if(vector.isEmpty()) {
			
			for(EspectaculoPaseMultiple especPaseMultiple : vector){
			
				especPaseMultiple.EspectaculoPaseMultipleToFich(especPaseMultiple.getNombre(), especPaseMultiple.getTipo(), especPaseMultiple.getContenido(), especPaseMultiple.getLocalidadesTotales(), especPaseMultiple.getLocalidadesVendidas(), especPaseMultiple.getPase(), especPaseMultiple.getCritica());
			}
		}
		
		if(!aux.isEmpty()){
			
			for(EspectaculoPuntual especPuntual : aux){
				
				especPuntual.EspectaculoPuntualToFich(especPuntual.getNombre(), especPuntual.getTipo(), especPuntual.getContenido(), especPuntual.getLocalidadesTotales(), especPuntual.getLocalidadesVendidas(), especPuntual.getFecha(),especPuntual.getCritica());
			}
		}
		
		if(!aux2.isEmpty()){
			
			for(EspectaculoTemporada especTemporada : aux2){
				
				especTemporada.EspectaculoTemporadaToFich(especTemporada.getNombre(), especTemporada.getTipo(), especTemporada.getContenido(), especTemporada.getLocalidadesTotales(), especTemporada.getLocalidadesVendidas(), especTemporada.getInicioFecha(), especTemporada.getFinalFecha(), especTemporada.getFecha() ,especTemporada.getCritica());
			}
		}
	}
	
	
	
	public void borrarEspectaculoTemporada(String Nombre) {
		
		ArrayList<EspectaculoTemporada> vector = new ArrayList<EspectaculoTemporada>();
		
		vector = EspectaculoTemporadaToVector(vector);
		
		ArrayList<EspectaculoPuntual> aux = new ArrayList<EspectaculoPuntual>();
		ArrayList<EspectaculoPaseMultiple> aux2 = new ArrayList<EspectaculoPaseMultiple>();
		
		aux = EspectaculoPuntualToVector(aux);
		aux2 = EspectaculoPaseMultipleToVector(aux2);
		
		for(EspectaculoTemporada especTemporada : vector){
		
			if(Nombre.equals(especTemporada.getNombre())){
		
				vector.remove(especTemporada);
			}
		}
		
		BufferedWriter BW;
		
		try{
			
			BW = new BufferedWriter(new FileWriter("Espectaculos.txt"));
			BW.write("");
			BW.close();
		
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}
		
		if(vector.isEmpty()) {
			
			for(EspectaculoTemporada especTemporada : vector){
				
				especTemporada.EspectaculoTemporadaToFich(especTemporada.getNombre(), especTemporada.getTipo(), especTemporada.getContenido(), especTemporada.getLocalidadesTotales(), especTemporada.getLocalidadesVendidas(), especTemporada.getInicioFecha(), especTemporada.getFinalFecha(), especTemporada.getFecha() ,especTemporada.getCritica());
			}
		}
		
		if(!aux.isEmpty()) {
			
			for(EspectaculoPuntual especPuntual : aux){
				
				especPuntual.EspectaculoPuntualToFich(especPuntual.getNombre(), especPuntual.getTipo(), especPuntual.getContenido(), especPuntual.getLocalidadesTotales(), especPuntual.getLocalidadesVendidas(), especPuntual.getFecha(),especPuntual.getCritica());
			}
		}
		
		if(!aux2.isEmpty()) {
			
			for(EspectaculoPaseMultiple especPaseMultiple : aux2){
				
				especPaseMultiple.EspectaculoPaseMultipleToFich(especPaseMultiple.getNombre(), especPaseMultiple.getTipo(), especPaseMultiple.getContenido(), especPaseMultiple.getLocalidadesTotales(), especPaseMultiple.getLocalidadesVendidas(), especPaseMultiple.getPase(), especPaseMultiple.getCritica());
			}
		}	
	}
	
	
	
	
	public void imprimirEspectaculoPuntual() {
		ArrayList<EspectaculoPuntual> espectaculo = new ArrayList<EspectaculoPuntual>(); 
		
		espectaculo = EspectaculoPuntualToVector(espectaculo);
		
		int aux = 1;
		
		for(EspectaculoPuntual especPuntual : espectaculo){
			
			System.out.println("ESPECTACULO PUNTUAL "+ aux);
			System.out.println("-----------------------");
			System.out.println("Nombre: " + especPuntual.getNombre());
			System.out.println("Fecha: " + DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(especPuntual.getFecha()));
			System.out.println("Localidades disponibles: " + ((especPuntual.getLocalidadesTotales())-(especPuntual.getLocalidadesVendidas())) ); 
			System.out.println("Contenido: " + especPuntual.getContenido());
			System.out.println("-----------------------");
			System.out.println("");
			
			aux++;
		}
		
		if(espectaculo.isEmpty()){
			
			System.err.println("No hay ningun Espectaculo Puntual registrado en el sistema");
		}
	}
	
	
	
	
	public void imprimirEspectaculoPaseMultiple() {
		
		ArrayList<EspectaculoPaseMultiple> espectaculo = new ArrayList<EspectaculoPaseMultiple>(); 
		
		espectaculo = EspectaculoPaseMultipleToVector(espectaculo);
		
		int aux = 1;
		
		for(EspectaculoPaseMultiple especPaseMultiple : espectaculo){
			
			System.out.println("ESPECTACULO PASE MULTIPLE "+ aux);
			System.out.println("-----------------------------");
			System.out.println("Nombre: " + especPaseMultiple.getNombre());
			
			if(especPaseMultiple.getPase() != null){
				
				for(int i = 0; i < especPaseMultiple.getPase().size(); i++){
					
					System.out.println("Fecha "+ (i+1) + "� :"  + DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(especPaseMultiple.getPase().get(i)));
				}
			}
			System.out.println("Localidades disponibles: " + ((especPaseMultiple.getLocalidadesTotales())-(especPaseMultiple.getLocalidadesVendidas())) );
			System.out.println("Contenido: " + especPaseMultiple.getContenido());
			System.out.println("-----------------------------");
			System.out.println("");
			aux++;
		}
		
		if(espectaculo.isEmpty()){
			
			System.err.println("No hay ningun Espectaculo de Pase Multiple registrado en el sistema");
		}
	}
	
	
	
	
	public void imprimirEspectaculoTemporada(){
		
		ArrayList<EspectaculoTemporada> espectaculo = new ArrayList<EspectaculoTemporada>(); 
		espectaculo = EspectaculoTemporadaToVector(espectaculo);
	
		int aux = 1;
		
		for(EspectaculoTemporada especTemporada: espectaculo){
			
			System.out.println("ESPECTACULO DE TEMPORADA "+ aux);
			System.out.println("----------------------------");
			System.out.println("Nombre: " + especTemporada.getNombre());
			System.out.println("Fecha de Inicio: " + DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(especTemporada.getInicioFecha()));

			for(int i = 0; i < especTemporada.getFecha().size(); i++){
				
				System.out.println("Fecha "+ (i+1) + "� :"  + DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(especTemporada.getFecha().get(i)));
			}
			
			System.out.println("Fecha de Fin: " + DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(especTemporada.getFinalFecha()));			
			System.out.println("Localidades disponibles: " + ((especTemporada.getLocalidadesTotales())-(especTemporada.getLocalidadesVendidas())) ); 
			System.out.println("Contenido: " + especTemporada.getContenido());
			System.out.println("----------------------------");
			System.out.println("");
			
			aux++;
		}
		
		if(espectaculo.isEmpty()){
			
			System.err.println("No hay ningun Espectaculo de Temporada registrado en el sistema");
		}
	}
	
	
	
	
	public boolean existeEspectaculoPuntual(String Nombre){
		
		ArrayList<EspectaculoPuntual> vector = new ArrayList<EspectaculoPuntual>();
		EspectaculoPuntualToVector(vector);
		
		for(EspectaculoPuntual especPuntual : vector) {
			
			if(especPuntual.getNombre().equals(Nombre)){
				
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public boolean existeEspectaculoTemporada(String Nombre){
		
		ArrayList<EspectaculoTemporada> vector = new ArrayList<EspectaculoTemporada>();
		EspectaculoTemporadaToVector(vector);
		
		for(EspectaculoTemporada especTemporada : vector) {
			
			if(especTemporada.getNombre().equals(Nombre)) {;
				
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public boolean existeEspectaculoPaseMultiple(String Nombre){
		
		ArrayList<EspectaculoPaseMultiple> vector = new ArrayList<EspectaculoPaseMultiple>();
		vector = EspectaculoPaseMultipleToVector(vector);
		
		for(EspectaculoPaseMultiple especPaseMultiple : vector) {
			
			if(especPaseMultiple.getNombre().equals(Nombre)) {;
				
				return true;
			}
		}
		return false;
	}
	
	
	public void buscarEspectaculoPuntual(String Nombre){
		
		ArrayList<EspectaculoPuntual> espectaculo = new ArrayList<EspectaculoPuntual>(); 
		espectaculo = EspectaculoPuntualToVector(espectaculo);

		if(existeEspectaculoPuntual(Nombre)==true){
		
			for(int i=0; i<espectaculo.size(); i++){
			
				if(espectaculo.get(i).getNombre().equals(Nombre)){
					
					System.out.println("ESPECTACULO PUNTUAL "+ (i+1));
					System.out.println("---------------------------");
					System.out.println("Nombre: " + espectaculo.get(i).getNombre());
					System.out.println("Fecha: " + espectaculo.get(i).getFecha());
					System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("---------------------------");
					System.out.println("");
				}
			}
		}
		else{
			
			System.err.println("El espectaculo no esta registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	
	
	
	public void buscarEspectaculoPaseMultiple(String Nombre){
		
		ArrayList<EspectaculoPaseMultiple> espectaculo = new ArrayList<EspectaculoPaseMultiple>(); 
		espectaculo = EspectaculoPaseMultipleToVector(espectaculo);

		if(existeEspectaculoPaseMultiple(Nombre)==true){
			
			for(int i=0; i<espectaculo.size(); i++){
				
				if(espectaculo.get(i).getNombre().equals(Nombre)){
					
					System.out.println("ESPECTACULO PASE MULTIPLE "+ (i+1));
					System.out.println("---------------------------------");
					System.out.println("Nombre: " + espectaculo.get(i).getNombre());
				
					for(int j = 0; j < espectaculo.get(i).getPase().size(); j++) {
					
						System.out.println("Fecha "+ (j+1) + "� :"  + espectaculo.get(j).getPase());
					}
					
					System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) );
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("---------------------------------");
					System.out.println("");  

				}
			}
		}
		else{
		
			System.err.println("El espectaculo no esta registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	
	
	
	public void buscarEspectaculoTemporada(String Nombre){
		
		ArrayList<EspectaculoTemporada> espectaculo = new ArrayList<EspectaculoTemporada>(); 
		espectaculo = EspectaculoTemporadaToVector(espectaculo);

		if(existeEspectaculoTemporada(Nombre)==true){
			
			for(int i=0; i<espectaculo.size(); i++){
				
				if(espectaculo.get(i).getNombre().equals(Nombre)){
					
					System.out.println("ESPECTACULO DE TEMPORADA "+ (i+1));
					System.out.println("--------------------------------");
					System.out.println("Nombre: " + espectaculo.get(i).getNombre());
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("Fecha de Inicio: " + espectaculo.get(i).getInicioFecha());

					for(int j = 0; j < espectaculo.get(i).getFecha().size(); j++){
						
						System.out.println("Fecha "+ (j+1) + "� :"  + espectaculo.get(j).getFecha());
					}
					
					System.out.println("Fecha de Final: " + espectaculo.get(i).getFinalFecha());
					System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) );
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("--------------------------------");
					System.out.println("");
				}
			}
		}
		else{
			
			System.err.println("El espectaculo no esta registrado en nuestro sistema."); 
			System.exit(-1); 
		}
	}
	
	
	
	
	public void localidadesDisponiblesEspectaculoPuntual(){
		
		ArrayList<EspectaculoPuntual> espectaculo = new ArrayList<EspectaculoPuntual>(); 
		espectaculo = EspectaculoPuntualToVector(espectaculo);
		
		for(int i=0; i<espectaculo.size(); i++){
			
			if((espectaculo.get(i).getLocalidadesTotales()) > (espectaculo.get(i).getLocalidadesVendidas())){
				
				System.out.println("ESPECTACULO PUNTUAL " + (i+1));
				System.out.println("----------------------------");
				System.out.println("Nombre: " + espectaculo.get(i).getNombre());
				System.out.println("Fecha: " + espectaculo.get(i).getFecha());
				System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
				System.out.println("Contenido: " + espectaculo.get(i).getContenido());
				System.out.println("----------------------------");
				System.out.println("");
			}
		}
	}
	
	
	
	
	public void localidadesDisponiblesEspectaculoPaseMultiple(){
		
		ArrayList<EspectaculoPaseMultiple> espectaculo = new ArrayList<EspectaculoPaseMultiple>(); 
		espectaculo = EspectaculoPaseMultipleToVector(espectaculo);
		
		for(int i=0; i<espectaculo.size(); i++){
			
			if((espectaculo.get(i).getLocalidadesTotales()) > (espectaculo.get(i).getLocalidadesVendidas())){
				
				System.out.println("ESPECTACULO PASE MULTIPLE "+ (i+1));
				System.out.println("---------------------------------");
				System.out.println("Nombre: " + espectaculo.get(i).getNombre());
				
				for(int j = 0; j < espectaculo.get(i).getPase().size(); j++){
				
					System.out.println("Fecha "+ (j+1) + "� :"  + espectaculo.get(j).getPase());
				}
				
				System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
				System.out.println("Contenido: " + espectaculo.get(i).getContenido());
				System.out.println("---------------------------------");
				System.out.println("");

			}
		}
	}
	
	public void localidadesDisponiblesEspectaculoTemporada(){
		
		ArrayList<EspectaculoTemporada> espectaculo = new ArrayList<EspectaculoTemporada>(); 
		espectaculo = EspectaculoTemporadaToVector(espectaculo);
		
		for(int i=0; i<espectaculo.size(); i++){
			
			if((espectaculo.get(i).getLocalidadesTotales()) > (espectaculo.get(i).getLocalidadesVendidas())){
				
				System.out.println("ESPECTACULO DE TEMPORADA "+ (i+1));
				System.out.println("--------------------------------");
				System.out.println("Nombre: " + espectaculo.get(i).getNombre());
				System.out.println("Fecha de Inicio: " + espectaculo.get(i).getInicioFecha());

				for(int j = 0; j < espectaculo.get(i).getFecha().size(); j++){
					
					System.out.println("Fecha "+ (j+1) + "� :"  + espectaculo.get(j).getFecha());
				}
			
				System.out.println("Fecha de Fin: " + espectaculo.get(i).getFinalFecha());
				System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
				System.out.println("Contenido: " + espectaculo.get(i).getContenido());
				System.out.println("--------------------------------");
				System.out.println("");

			}
		}
	}
	
	
	
	
	public boolean existeCategoriaEspectaculoPuntual(String Categoria){
		
		ArrayList<EspectaculoPuntual> vector = new ArrayList<EspectaculoPuntual>();
		vector =EspectaculoPuntualToVector(vector);
		
		for(EspectaculoPuntual especPuntual : vector){
			
			if(vector == null){
				
				return false;
			}
			else if(especPuntual.getTipo().equals(Categoria)){
				
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public boolean existeCategoriaEspectaculoTemporada(String Categoria){
		
		ArrayList<EspectaculoTemporada> vector = new ArrayList<EspectaculoTemporada>();
		vector =EspectaculoTemporadaToVector(vector);
		
		for(EspectaculoTemporada especTemporada : vector){
			
			if(vector == null){
				
				return false;
			}
			else if(especTemporada.getTipo().equals(Categoria)){
				
				return true;
			}
		}
		return false;
	}
	
	public boolean existeCategoriaEspectaculoPaseMultiple(String Categoria){
		
		ArrayList<EspectaculoPaseMultiple> vector = new ArrayList<EspectaculoPaseMultiple>();
		vector = EspectaculoPaseMultipleToVector(vector);
		
		for(EspectaculoPaseMultiple especPaseMultiple : vector){
			
			if(vector == null){
				
				return false;
			}
			else if(especPaseMultiple.getTipo().equals(Categoria)){
				
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public void buscarCategoriaEspectaculoPuntual(String Categoria){
		
		ArrayList<EspectaculoPuntual> espectaculo = new ArrayList<EspectaculoPuntual>(); 
		espectaculo = EspectaculoPuntualToVector(espectaculo);

		if(existeCategoriaEspectaculoPuntual(Categoria)==true){
			
			for(int i=0; i<espectaculo.size(); i++){
				
				if(espectaculo.get(i).getTipo().equals(Categoria)){
					
					System.out.println("ESPECTACULO PUNTUAL " + (i+1));
					System.out.println("----------------------------");
					System.out.println("Nombre: " + espectaculo.get(i).getNombre());
					System.out.println("Fecha: " + espectaculo.get(i).getFecha());
					System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("----------------------------");
					System.out.println("");
				}
			}
		}
		else{
			
			System.err.println("No hay ningun espectaculo "); 
		}
	}
	
	public void buscarCategoriaEspectaculoPaseMultiple(String Categoria){
	
		ArrayList<EspectaculoPaseMultiple> espectaculo = new ArrayList<EspectaculoPaseMultiple>(); 
		espectaculo = EspectaculoPaseMultipleToVector(espectaculo);

		if(existeCategoriaEspectaculoPaseMultiple(Categoria)==true){
		
			for(int i=0; i<espectaculo.size(); i++){
		
				if(espectaculo.get(i).getTipo().equals(Categoria)){
					
					System.out.println("ESPECTACULO PASEMULTIPLE " + (i+1));
					System.out.println("---------------------------------");
					System.out.println("Nombre: " + espectaculo.get(i).getNombre());
					
					for(int j = 0; j < espectaculo.get(i).getPase().size(); j++){
						
						System.out.println("Fecha "+ (j+1) + "� :"  + espectaculo.get(j).getPase());
					}
					
					System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("---------------------------------");
					System.out.println("");
				}
			}
		}
		else{
		
			System.err.println("No hay ningun espectaculo"); 
		}
	}
	
	public void buscarCategoriaEspectaculoTemporada(String Categoria){
		
		ArrayList<EspectaculoTemporada> espectaculo = new ArrayList<EspectaculoTemporada>(); 
		espectaculo = EspectaculoTemporadaToVector(espectaculo);

		if(existeCategoriaEspectaculoTemporada(Categoria)==true){
			
			for(int i=0; i<espectaculo.size(); i++){
				
				if(espectaculo.get(i).getTipo().equals(Categoria)){
					
					System.out.println("ESPECTACULO DE TEMPORADA "+ (i+1));
					System.out.println("--------------------------------");
					System.out.println("Nombre: " + espectaculo.get(i).getNombre());
					System.out.println("Fecha de Inicio: " + espectaculo.get(i).getInicioFecha());

					for(int j = 0; j < espectaculo.get(i).getFecha().size(); j++){
						
						System.out.println("Fecha "+ (j+1) + "� :"  + espectaculo.get(j).getFecha());
					}
					
					System.out.println("Fecha de Fin: " + espectaculo.get(i).getFinalFecha());
					System.out.println("Localidades disponibles :" + ((espectaculo.get(i).getLocalidadesTotales())-(espectaculo.get(i).getLocalidadesVendidas())) ); 
					System.out.println("Contenido: " + espectaculo.get(i).getContenido());
					System.out.println("--------------------------------");
					System.out.println("");
				}
			}
		}
		else{
		
			System.err.println("No hay ningun espectaculo con esa Categoria almacenado en el sistema"); 
		}
	}
	
	
	
	
	public void actualizarEspectaculoPuntual(String Nombre) {
		
		ArrayList<Integer> identificador = new ArrayList<Integer>();
		Scanner Teclado = new Scanner(System.in);
		
		
		System.out.println("Introduzca la categoria del espectaculo:");
		String Categoria = Teclado.nextLine();
		
		
		System.out.println("Introduca la contenido del espectaculo:");
		String Contenido = Teclado.nextLine();
		
		
		System.out.println("Introduca el numero de localidades disponibles para el espectaculo:");
		int localidadesTotales = Integer.parseInt(Teclado.nextLine());
		
		
		System.out.println("Introduzca el numero de localidades ya vendidas");
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
    	
		System.out.println("Introduzca la fecha y hora del espectaculo");
		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
		String fecha = Teclado.nextLine();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime Fecha = LocalDateTime.parse(fecha, formato);

		borrarEspectaculoPuntual(Nombre);
		EspectaculoPuntualToFich(Nombre, Categoria, Contenido, localidadesTotales, localidadesVendidas, Fecha, identificador);
		Teclado.close();
	}
	
	public void actualizarEspectaculoPaseMultiple(String Nombre) {
		
		ArrayList<Integer> identificador = new ArrayList<Integer>();
		ArrayList<LocalDateTime> Pase = new ArrayList<LocalDateTime>();

		Scanner Teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la Categoria del espectaculo:");
		String Categoria = Teclado.nextLine();
		
		
		System.out.println("Introduca la Contenido del espectaculo:");
		String Contenido = Teclado.nextLine();
		
		
		System.out.println("Introduca el numero de localidades disponibles para el espectaculo:");
		int localidadesTotales = Integer.parseInt(Teclado.nextLine());
		
		
		System.out.println("Introduzca el numero de localidades ya vendidas");
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
    	
		System.out.println("Indique cuantos pases habra para el espectaculo");
		
		int numeroPases = Integer.parseInt(Teclado.nextLine());
		
		for(int i = 0; i < numeroPases; i++){
			
    		System.out.println("Introduzca la fecha y hora del" + (i+1) + "� pase del espectaculo");
    		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
    		String fecha = Teclado.nextLine();
    		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    		LocalDateTime Fecha = LocalDateTime.parse(fecha, formato);
    		Pase.add(Fecha);
		}

		borrarEspectaculoPaseMultiple(Nombre);
		EspectaculoPaseMultipleToFich(Nombre, Categoria, Contenido, localidadesVendidas, numeroPases, Pase, identificador);
		Teclado.close();
	}

	public void actualizarEspectaculoTemporada(String Nombre) {
	
		ArrayList<Integer> identificador = new ArrayList<Integer>();
		ArrayList<LocalDateTime> Pase = new ArrayList<LocalDateTime>();
		Scanner Teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la Categoria del espectaculo:");
		String Categoria = Teclado.nextLine();
		
		
		System.out.println("Introduca la Contenido del espectaculo:");
		String Contenido = Teclado.nextLine();
		
		
		System.out.println("Introduca el numero de localidades disponibles para el espectaculo:");
		int localidadesTotales = Integer.parseInt(Teclado.nextLine());
		
		
		System.out.println("Introduzca el numero de localidades ya vendidas");
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
		
		System.out.println("Introduzca la fecha de Inicio");
		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
		String date1 = Teclado.nextLine();
		DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime Date1 = LocalDateTime.parse(date1, formato1);
		
		System.out.println("Introduzca la fecha de Fin");
		System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
		String date2 = Teclado.nextLine();
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime Date2 = LocalDateTime.parse(date2, formato2);
		
		System.out.println("Indique cuantas veces se repetira el espectaculo");
		int numeroPases = Integer.parseInt(Teclado.nextLine());
		
		for(int i = 0; i < numeroPases; i++){
			
			System.out.println("Introduzca la fecha y hora del" + (i+1) + "� pase del espectaculo");
			System.out.println("Formato de fecha : DD-MM-AAAA HH:MM");
			String fecha = Teclado.nextLine();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			LocalDateTime Fecha = LocalDateTime.parse(fecha, formato);
			Pase.add(Fecha);
		}
	
		borrarEspectaculoTemporada(Nombre);
		EspectaculoTemporadaToFich(Nombre, Categoria, Contenido, localidadesTotales, localidadesVendidas, Date1, Date2, Pase, identificador);
		Teclado.close();
	}
	
}
