package Criticas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import General.Critica;
import Usuarios.FunUsuario;

/**
 * Clase que implementa funcionalidades de
 * lectura y escritura de criticas
 */
public class FunCriticas extends FunUsuario {

	
	public FunCriticas() {}
	
	/**
	 * Funcion que anadela critica al fichero Criticas.txt,
	 * @param Titulo Titulo de la critica
	 * @param Puntuacion Puntuacion de la critica
	 * @param Resena Resena de la critica
	 * @param Correo Correo del autor
	 * @param Likes Likes de la critica
	 * @param Dislike Dislike de la critica
	 */
	public void CriticaAFich(String Titulo, float Puntuacion, String Resena, String Correo, int Like, int Dislike, int Id, ArrayList<String> Votantes){		
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Criticas.txt";
		FileWriter fich = null;
	    PrintWriter PW = null; 
	   
	    try{	
	    	
	    	fich= new FileWriter(RutaFich, true); 
	    	PW = new PrintWriter(fich); 
	    	PW.print(Titulo+"//"+Puntuacion +"//" + Resena+"//"+ Correo + "//" + Like +"//" + Dislike +"//"+ Id + "//");
	    	
	    	if(!Votantes.isEmpty()) {
	    		
	    		for(String i : Votantes){
		    		
	    			PW.print(i+"::");
		    	}
		    	
	    		PW.print("//");
	    	}
	    	else {
	    		
	    		PW.print("void//");
	    	}
	    	
	    	PW.println("");
	    	
	    }catch (Exception Excep) {
	    	
	       Excep.printStackTrace();
	       
	    } finally{
	    	
	           try {
	        	   
		           if (fich != null) {
		        	   
		              fich.close();
		           }
	           } catch (Exception Excep2) {
	        	   
	              Excep2.printStackTrace();
	           }
	        }	
	    }
	
	/**
	 * Metodo que lleva a un vector el contenido del fichero Criticas.txt
	 * @param vector Vector de criticas
	 * @return Vector con todos los datos del fichero
	 */
	public ArrayList<Critica> fichCriticaToVec(ArrayList<Critica> vector){
		
		String RutaTotal = new File("").getAbsolutePath();
		String RutaFich = RutaTotal + "/Criticas.txt";
		FileReader FR = null;
		BufferedReader BR = null;
		Critica critica1 = new Critica(); 
				
		try {
			
	        FR = new FileReader (RutaFich);
	        BR = new BufferedReader(FR);
	        String linea; 
	        ArrayList<String> Votantes = new ArrayList<String>(); 
        	
	        while ((linea = BR.readLine()) != null){
        	    
        		String[] data = linea.split("//");
		    	critica1.setTitulo(data[0]);
		    	critica1.setPuntuacion(Float.parseFloat(data[1]));
		    	critica1.setResena(data[2]);
		    	critica1.setCorreo(data[3]);
		    	critica1.setLike(Integer.parseInt(data[4]));
		    	critica1.setDislike(Integer.parseInt(data[5]));
		    	critica1.setId(Integer.parseInt(data[6]));
		    	
		    	if(!("void".equals(data[7]))){
		    		
		    		String[] data2 = data[7].split("::");
		    		
			    	for(int i=0; i<data2.length; i++){
			    		
			    		Votantes.add(data2[i]);
			    	} 
			    	
			    	critica1.setVotantes(Votantes);
		    	}
		    	else {
		    		
		    		critica1.setVotantes(new ArrayList<String>());
		    	}
		    	vector.add(critica1); 
		    	critica1 = new Critica();
		    	Votantes = new ArrayList<String>(); 
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
	
	/**
	 * Funcion que borra del fichero Criticas.txt una critica
	 * @param Id Identificador de la critica
	 */
	public void borrarCriticaParaUpdates(int Id) {
		
		ArrayList<Critica> vector = new ArrayList<Critica>();
		vector = fichCriticaToVec(vector);
		ArrayList<Critica> aux = new ArrayList<Critica>();
		
		for(Critica i : vector) {
			
			if(!(i.getId() == Id )){
				
				aux.add(i);
			}
		}
		BufferedWriter BW;
		
		try {
			
			BW = new BufferedWriter(new FileWriter("Criticas.txt"));
			BW.write("");
			BW.close();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}		
		
		for(Critica i : aux) {
			
			i.CriticaAFich(i.getTitulo(), i.getPuntuacion(), i.getResena(), i.getCorreo(), i.getLike(), i.getDislike(), i.getId(), i.getVotantes());
		}
	}
	
	/**
	 * Funcion que borra del fichero Criticas.txt una critica 
	 * a traves del correo de su autor y el id
	 * @param Correo Correo del autor
	 * @param Id Identificador de la critica
	 */
	public void borrarCritica(int Id, String Correo) {
		
		ArrayList<Critica> vector = new ArrayList<Critica>();
		vector = this.fichCriticaToVec(vector);
		ArrayList<Critica> aux = new ArrayList<Critica>(); 
		
		for(Critica i : vector) {
			
			if(!(i.getCorreo().equals(Correo) && i.getId() == Id )) {
				
				aux.add(i);
			}
		}
		BufferedWriter BW;
		try {
			
			BW = new BufferedWriter(new FileWriter("Criticas.txt"));
			BW.write("");
			BW.close();
			
		} catch (IOException Excep) {
			
			Excep.printStackTrace();
		}		
		for(Critica i : aux) {
			
			i.CriticaAFich(i.getTitulo(), i.getPuntuacion(), i.getResena(), i.getCorreo(), i.getLike(), i.getDislike(), i.getId(), i.getVotantes());
		}
	}

	/**
	 * Funcion que genera un identificador para las criticas, unico
	 * @return Id Identificador de la critica
	 */
	public int GenerarId(){
		
		Random R = new Random();
		int Id = R.nextInt(99999)+1; 
		
		if (ExisteId(Id) == true){
			
			GenerarId();
		}
		return Id;
	}
	
	/**
	 * Funcion que comprueba que existe un Id de una critica
	 * @param Id Identificador de la critica que se desea
	 * @return true si exisite, false si no existe
	 */	
	public boolean ExisteId(int Id){
		
		ArrayList<Critica> vector = new ArrayList<Critica>();
		fichCriticaToVec(vector);
		
		for(Critica i : vector) {
			
			if(i.getId()==Id) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Funcion que imprime las criticas del fichero Criticas.txt
	 */
	public void ImprimirTodo(){
		
		ArrayList<Critica> critica = new ArrayList<Critica>(); 
		critica = fichCriticaToVec(critica);
		int aux = 1;
		
		for(Critica i : critica){
			
			System.out.println("Critica "+ aux);
			System.out.println("-------------------");
			System.out.println("Titulo: " + i.getTitulo());
			System.out.println("Resena: " + i.getResena());
			System.out.println("Id: "+ i.getId());
			System.out.println("Likes: " + i.getLike()); 
			System.out.println("Dislikes: " + i.getDislike()); 
			System.out.println("-------------------");
			aux++;
		}
	}
	
	/**
	 * Funcion que busca y muestra las criticas 
	 * de un usuario en concreto
	 * @param mail Direccion de email del usuario
	 */
	public void buscarCriticas(String Correo){
		
		ArrayList<Critica> critica = new ArrayList<Critica>(); 
		critica = fichCriticaToVec(critica);
		int count = 1; 
		
		if(ComprobarExisteUsuario(Correo)==true){
			
			if(!critica.isEmpty()){
				
				for(int i=0; i<critica.size(); i++){
					
					if(critica.get(i).getCorreo().equals(Correo)){
						
						System.out.println("CRITICA/S DEL USUARIO CON CORREO: "+ Correo);
						System.out.println("-------------------");
						System.out.println("CRITICA "+ count);
						System.out.println("Titulo: " + critica.get(i).getTitulo());
						System.out.println("Resena: " + critica.get(i).getResena());
						System.out.println("Id: "+ critica.get(i).getId()); 
						System.out.println("Likes: " + critica.get(i).getLike()); 
						System.out.println("Dislikes: " + critica.get(i).getDislike()); 
						System.out.println("-------------------");
	
						count++; 
					}
					else{
						
						System.err.println("Ninguna critica asociada");
					}
				}
			}
		}
		else{
			
			System.err.println("Usuario no registrado en nuestro sistema.");
		}
	}
	
	
	/**
	 * Funcion que busca una critica por su Id
	 * @param Id Identificador de la critica
	 * @return critic critica la cual se busca
	 */
	public Critica buscarCritica(int Id){
		
		Critica critica = new Critica();
		ArrayList<Critica> vector = new ArrayList<Critica>();
		vector = this.fichCriticaToVec(vector);
		
		for(Critica critic : vector) {
			
			if(critic.getId() == Id) {
				
				return critic;
			}
		}
		return critica;
	}
	
	/**
	 * Funcion que vota positivamente una critica, aumenta en uno los Likes
	 * @param Correo Correo del autor de la critica
	 * @param Id Identificador a de la critica
	 */
	public void votarCriticaPositiva(String Correo, int Id){
		Critica critica = new Critica();
		critica = critica.buscarCritica(Id);
		ArrayList<String> Votantes = new ArrayList<String>(); 
		
		if(critica.getCorreo().equals(Correo)){
			
			System.err.println("No puede valorar sus propias criticas");
			return;
		}
		else{
			
			for(String correos : critica.getVotantes()){
				
				if(correos.equals(Correo)) {
					
					System.err.println("Ya ha valorado esta critica");
					return;
				}
			}	
			Critica cAux = critica;
			cAux.addLike();
			Votantes = critica.getVotantes(); 
			Votantes.add(Correo); 
			cAux.setVotantes(Votantes);
			this.borrarCriticaParaUpdates(Id);
			this.CriticaAFich(cAux.getTitulo(), cAux.getPuntuacion(), cAux.getResena(), cAux.getCorreo(), cAux.getLike(), cAux.getDislike(), cAux.getId(), cAux.getVotantes());
			System.out.println("La critica ha sido valorada.");
		}
	}
	
	/**
	 * Funcion que vota negativamente una critica, aumenta en uno los Dislikes
	 * @param Correo Correo del autor de la critica
	 * @param Id Identificador a de la critica
	 */
	public void votarCriticaNegativa(String Correo, int Id){
		
		Critica critica = new Critica();
		critica = critica.buscarCritica(Id);
		ArrayList<String> Votantes = new ArrayList<String>(); 
		
		if(critica.getCorreo().equals(Correo)){
			
			System.err.println("No puede valorar sus propias criticas");
			return;
		}
		else{
			
			for(String correos : critica.getVotantes()){
				
				if(correos.equals(Correo)){
					
					System.err.println("Ya ha valorado esta critica");
					return;
				}
			}
			Critica cAux = critica;
			cAux.addDislike();
			Votantes = critica.getVotantes(); 
			Votantes.add(Correo); 
			cAux.setVotantes(Votantes);
			this.borrarCriticaParaUpdates(Id);
			this.CriticaAFich(cAux.getTitulo(), cAux.getPuntuacion(), cAux.getResena(), cAux.getCorreo(), cAux.getLike(), cAux.getDislike(), cAux.getId(), cAux.getVotantes());
			System.out.println("La critica ha sido valorada.");
		}
	}
	
	/**
	 * Funcion que actualiza las criticas
	 * @param Correo Correo antiguo del usuario 
	 * @param nuevoCorreo Correo nuevo del usuario
	 */
	public void ActualizarCriticasUsuario(String Correo, String nuevoCorreo){
		
		ArrayList<Critica> vector = new ArrayList<Critica>(); 
		vector = fichCriticaToVec(vector); 
		
		for (Critica critica : vector){
			
			if(critica.getCorreo().equals(Correo)){
				
				critica.setCorreo(Correo.replaceAll(Correo, nuevoCorreo));
			}
			
			for(int i = 0; i<critica.getVotantes().size(); i++){
				
				if(critica.getVotantes().get(i).equals(Correo)){
					
					critica.getVotantes().set(i,critica.getVotantes().get(i).replaceAll(Correo, nuevoCorreo) );
				}
			}
		}
		BufferedWriter BW;
		
		try{
			BW = new BufferedWriter(new FileWriter("Criticas.txt"));
			BW.write("");
			BW.close();
			
		} catch (IOException Excep){
			
			Excep.printStackTrace();
		}		
		
		for(Critica critica : vector){
			
			critica.CriticaAFich(critica.getTitulo(), critica.getPuntuacion(), critica.getResena(), critica.getCorreo(), critica.getLike(), critica.getDislike(), critica.getId(), critica.getVotantes());
		}
	}
}