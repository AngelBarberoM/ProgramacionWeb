package MenusSecundarios;
import java.util.ArrayList;
import java.util.Scanner;

import CEU_MG.CriticaMG;
import General_DTO.CriticaDTO;
import General_DTO.EspectaculoDTO;

/**
 * La clase se utiliza para la gestion de las criticas
 */
public class MenuCritica {

	
private String Correo;
	
	private String getCorreo() {
		
		return Correo;
	}
	
	public MenuCritica(String Correo) {
		
		this.Correo = Correo;
	}
	
	public void CriticasMenu(){
		
    	String Opcion = "1";
    	Scanner lector = new Scanner(System.in);
		
    	while(Opcion.equals("1") || Opcion.equals("2") || Opcion.equals("3") || Opcion.equals("4") || Opcion.equals("5") || Opcion.equals("6") || Opcion.equals("7")) {
			
    		System.out.println("Para crear una critica, pulse 1.");
    	    System.out.println("Para consultar criticas, pulse 2");
    	    System.out.println("Para borrar una critica, pulse 3.");
    	    System.out.println("Para votar positivamente una critica, pulse 4.");
    	    System.out.println("Para votar negativamente, pulse 5.");
    	    System.out.println("Para buscar sus criticas, pulse 6.");
    	    System.out.println("Para ver las criticas de un usuario concreto, pulse 7.");
    	    System.out.println("Para salir del menu, pulse cualquier otra tecla.");
	        
			Opcion = lector.nextLine();

	        
	        if("1".equals(Opcion)){ 
	        	
	        	String EleccionEspectaculo = "1";
	     
	        	System.out.println("CREAR CRITICA");
	        	System.out.println("Desea escribir una critica de un espectaculo:");
	        	System.out.println("1. Puntual");
	        	System.out.println("2. Temporada");
	        	System.out.println("3. Multiple");
	        	
	        	EleccionEspectaculo = lector.nextLine();
	        	
	        	if(EleccionEspectaculo.equals("1")) {
	        		
	        		CriticaMG CriticaEspPuntual = new CriticaMG(this.getCorreo());
	        		ArrayList<EspectaculoDTO> espectaculos = CriticaEspPuntual.SolicitudEspectaculoPuntualCritica();
	        		int cont = 0;
	        		for(EspectaculoDTO Excep : espectaculos) {
	        			cont++;
	        			System.out.println(cont + ". " + Excep.getNombre());
	        			System.out.println("TIPO: " + Excep.getTipo());
	        			System.out.println("CONTENIDO:" + Excep.getContenido()); 
	        		}
	        		
	        		System.out.println("Introduzca el numero del espectaculo a criticar");

	            	String CriticarEspectaculos = lector.nextLine();
	            	while(!esNumerico(CriticarEspectaculos)){
	            		
	            		System.out.println("Introduzca el numero del espectaculo a criticar");
	            		CriticarEspectaculos = lector.nextLine();
	            	}
	            	if(Integer.parseInt(CriticarEspectaculos) > 0 && Integer.parseInt(CriticarEspectaculos) <= cont ) {
	            		
	            		int id = espectaculos.get(Integer.parseInt(CriticarEspectaculos)-1).getId();
	            		String titulo = null;
	    	        	String puntuacion=null;
	    	        	String resena = null;
	    	        	System.out.println("Critica a: " + espectaculos.get(Integer.parseInt(CriticarEspectaculos)-1).getNombre());
	    	        	System.out.println("Introduzca el titulo de la critica");
	    	        	titulo = lector.nextLine();	
	    	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	    	        	puntuacion = (lector.nextLine());
	    	        	 
	    	        	while(!esNumerico(puntuacion) || Float.parseFloat(puntuacion)<0 || Float.parseFloat(puntuacion)>10){
	    	        		
	                        	if(!esNumerico(puntuacion)){
	                        		
				                     System.err.println("La puntuacion tiene que ser numerica. Intentelo de nuevo.");
				                     puntuacion = lector.nextLine(); 
	                        	}
	                        	else{
	                        		
			                        System.err.println("La puntuacion debe ser un numero entre 1 y 10. Intentelo de nuevo.");
			                    	
			                    	puntuacion = lector.nextLine();
			                    	
			                    	if(!esNumerico(puntuacion)){
			                    		
			                    		System.err.println("La puntuacion tiene que ser numerica. Intentelo de nuevo.");
				                     
			                    		puntuacion = lector.nextLine(); 
			                		}
	                        	}
	                        }
	    	        	System.out.println("Escriba la resena del mismo");
	    	        	resena = lector.nextLine(); 
	    	        	CriticaEspPuntual.CrearCritica(titulo, Float.parseFloat(puntuacion) , resena, id); 
	            	}
	            	else {
	            		
	            		System.out.println("Espectaculo no valido");
	            	}
	        	}
	        	else if (EleccionEspectaculo.equals("2")) {
	        		
	        		CriticaMG CriticaEspTemp = new CriticaMG(this.getCorreo());
	        		ArrayList<EspectaculoDTO> espectaculos = CriticaEspTemp.SolicitudEspectaculoTemporadaCritica();
	        		int cont = 0;
	        		
	        		for(EspectaculoDTO Excep : espectaculos) {
	        			
	        			cont++;
	        			System.out.println(cont + ". " + Excep.getNombre());
	        			System.out.println(Excep.getTipo());
	        			System.out.println(Excep.getContenido());
	        		}
	        		System.out.println("Introduzca el numero del espectaculo a criticar");
	            	String CriticarEspectaculos = lector.nextLine();
	            	
	            	while(!esNumerico(CriticarEspectaculos)){
	            		
	            		System.out.println("Introduzca el numero del espectaculo a criticar (�DEBE SER UN NUMERO!)");
	            		CriticarEspectaculos = lector.nextLine();
	            	}
	            	
	            	if(Integer.parseInt(CriticarEspectaculos) > 0 && Integer.parseInt(CriticarEspectaculos) <= cont ) {
	            		
	            		int id = espectaculos.get(Integer.parseInt(CriticarEspectaculos)-1).getId();
	            		String titulo = null;
	    	        	String puntuacion = null;
	    	        	String resena = null;
	    	        	System.out.println("Va a criticar: " + espectaculos.get(Integer.parseInt(CriticarEspectaculos)-1).getNombre());
	    	        	System.out.println("Introduzca el titulo de la critica");
	    	        	titulo = lector.nextLine();	
	    	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	    	        	puntuacion = (lector.nextLine());
	    	        	
	    	        	while(!esNumerico(puntuacion) || Float.parseFloat(puntuacion)<0 || Float.parseFloat(puntuacion)>10){
	    	        		 
	                        	if(!esNumerico(puntuacion)){
	                        		
				                     System.err.println("La puntuacion tiene que ser numerica. Intentelo de nuevo.");
				                     
				                     puntuacion = lector.nextLine(); 
	                        	}
	                        	else{
	                        		
			                        System.err.println("La puntuacion debe ser un numero entre 1 y 10. Intentelo de nuevo.");
			                    	
			                    	puntuacion = lector.nextLine();
			                    	
			                    	if(!esNumerico(puntuacion)){
			                    		
			                    		System.err.println("La puntuacion tiene que ser numerica. Intentelo de nuevo.");
				                     
			                    		puntuacion = lector.nextLine(); 
			                		}
	                        	}
	                        }
	    	        	System.out.println("Escriba la resena del mismo");
	    	        	resena = lector.nextLine(); 
	    	        	CriticaEspTemp.CrearCritica(titulo, Float.parseFloat(puntuacion) , resena, id); 
	            	}
	            	else {
	            		
	            		System.out.println("Espectaculo no valido");
	            	}
	        		
	        	}
	        	else if (EleccionEspectaculo.equals("3")) {
	        		
	        		CriticaMG CriticaEspPaseMultiple = new CriticaMG(this.getCorreo());
	        		ArrayList<EspectaculoDTO> espectaculos = CriticaEspPaseMultiple.SolicitudEspectaculoPaseMultipleCritica();
	        		int cont = 0;
	        		
	        		for(EspectaculoDTO Excep : espectaculos) {
	        		
	        			cont++;
	        			System.out.println(cont + ". " + Excep.getNombre());
	        			System.out.println(Excep.getTipo());
	        			System.out.println(Excep.getContenido());
	        		}
	        		System.out.println("Introduzca el numero del espectaculo a criticar");
	            	String CriticarEspectaculos = lector.nextLine();
	            	
	            	while(!esNumerico(CriticarEspectaculos)){
	            		
	            		System.out.println("Introduzca el numero del espectaculo a criticar (�DEBE SER UN NUMERO!)");
	            		CriticarEspectaculos = lector.nextLine();
	            	}
	            	
	            	if(Integer.parseInt(CriticarEspectaculos) > 0 && Integer.parseInt(CriticarEspectaculos) <= cont ) {
	            		
	            		int id = espectaculos.get(Integer.parseInt(CriticarEspectaculos)-1).getId();
	            		String titulo = null;
	    	        	String puntuacion = null;
	    	        	String resena = null;
	    	        	System.out.println("Va a criticar: " + espectaculos.get(Integer.parseInt(CriticarEspectaculos)-1).getNombre());
	    	        	System.out.println("Introduzca el titulo de la critica");
	    	        	titulo = lector.nextLine();	
	    	        	System.out.println("Introduzca la puntuacion que da al espectaculo");
	    	        	puntuacion = (lector.nextLine());
	    	        	
	    	        	while(!esNumerico(puntuacion) || Float.parseFloat(puntuacion)<0 || Float.parseFloat(puntuacion)>10){
	    	        		
	                        	if(!esNumerico(puntuacion)){
	                        		
				                     System.err.println("La puntuacion tiene que ser numerica. Intentelo de nuevo.");
				                     
				                     puntuacion = lector.nextLine(); 
	                        	}
	                        	else{
	                        		
			                        System.err.println("La puntuacion debe ser un numero entre 1 y 10. Intentelo de nuevo.");
			                    	
			                    	puntuacion = lector.nextLine();
			                    	if(!esNumerico(puntuacion)){
			                    		
			                    		System.err.println("La puntuacion tiene que ser numerica. Intentelo de nuevo.");
				                     
			                    		puntuacion = lector.nextLine(); 
			                		}
	                        	}
	                        }
	    	        	System.out.println("Escriba la resena");
	    	        	resena = lector.nextLine(); 
	    	        	CriticaEspPaseMultiple.CrearCritica(titulo, Float.parseFloat(puntuacion) , resena, id);
	            	}
	            	else {
	            		System.out.println("Espectaculo no valido");
	            	}
	        	}
			}
		        else if("2".equals(Opcion)){ 
		        	
		        	System.out.println("CONSULTAR TODAS LAS CRITICAS");
		        	CriticaMG CriticaLeerTodas = new CriticaMG(this.getCorreo());
		        	ArrayList<CriticaDTO> criticas = CriticaLeerTodas.SolicitarCriticasInfo();
		        	
		        	for(CriticaDTO critica : criticas) {
		        		
		        		System.out.println("------------------------------------------------");
		        		System.out.println("Titulo : " + critica.getTitulo());
			        	System.out.println("Autor : " + critica.getCorreo());
		        		System.out.println("Espectaculo : " + CriticaLeerTodas.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
			        	System.out.println("Puntuacion : " + critica.getPuntuacion());
			        	System.out.println("Resena : " + critica.getResena());
			        	System.out.println("Likes : " + critica.getLike());
			        	System.out.println("Dislikes : " + critica.getDislike());
		        		System.out.println("------------------------------------------------");
		        	}
		        }
		        else if("3".equals(Opcion)) {
		        	
			        	System.out.println("ELMINACION DE CRITICA");
			        	System.out.println("Estas son todas sus criticas");
			        	CriticaMG CriticaDeUsuario = new CriticaMG(this.getCorreo());
		        		ArrayList<CriticaDTO> criticasUser = CriticaDeUsuario.SolicitudTodasCriticasUsuario(this.getCorreo());
		        		int cont = 0;
		        		
		        		for(CriticaDTO critica : criticasUser) {
		        		
		        			cont++;
	        				System.out.println("------------------------------------------------");
	    	        		System.out.println(cont + " Titulo : " + critica.getTitulo());
	    	        		System.out.println("Espectaculo : " + CriticaDeUsuario.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
	    		        	System.out.println("Puntuacion : " + critica.getPuntuacion());
	    		        	System.out.println("Resena : " + critica.getResena());
	    		        	System.out.println("Likes : " + critica.getLike());
	    		        	System.out.println("Dislikes : " + critica.getDislike());
	    	        		System.out.println("------------------------------------------------");
		        		}

		        		System.out.println("Introduzca el numero de la critica que desea borrar");
			        	String delete = lector.nextLine();
			        	
			        	while(!esNumerico(delete)){
			        		
		            		System.out.println("Introduzca el numero del la critica que desea borrar. (�DEBE SER UN NUMERO!)");
		            		delete = lector.nextLine();
		            	}
			        	
			        	if(Integer.parseInt(delete) > 0 && Integer.parseInt(delete) <= cont ) {
			        		
			        		System.out.println("Esta accion es permanente. �Desea borrar la critica " + delete + " ? Si/No.");
				        	String deleteOpc = lector.nextLine();
				        	
				        	if(deleteOpc.equals("Si")) {
				        		
				        		CriticaMG elimCriticas = new CriticaMG(this.getCorreo());
				        		int id = criticasUser.get(Integer.parseInt(delete)-1).getId();
				        		elimCriticas.EliminarCritica(id);
				        		System.out.println("La critica ha sido borrada.");
					    	}
				        	else {
				        		
				        		System.out.println("La critica no ha sido borrada.");	
				        	}
			        	}
		        }
		        else if("4".equals(Opcion)){
		        	
		        	System.out.println("Estas son todas las criticas que puede valorar");
		        	CriticaMG LikeCriticas = new CriticaMG(this.getCorreo());
		        	ArrayList<CriticaDTO> criticasValorables = LikeCriticas.SolicitarCriticasMenosUsuario();
		        	int cont = 0;
		        	
		        	for(CriticaDTO critica : criticasValorables) {
		        	
		        		cont++; 
		        		System.out.println("------------------------------------------------");
		        		System.out.println(cont + " Titulo : " + critica.getTitulo());
			        	System.out.println("Autor : " + critica.getCorreo());
		        		System.out.println("Espectaculo : " + LikeCriticas.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
			        	System.out.println("Puntuacion : " + critica.getPuntuacion());
			        	System.out.println("Resena : " + critica.getResena());
			        	System.out.println("Likes : " + critica.getLike());
			        	System.out.println("Dislikes : " + critica.getDislike());
		        		System.out.println("------------------------------------------------");
		        	}
		        	System.out.println("Introduzca el numero de la critica a la que desea dar like");
		        	String like = lector.nextLine();
		        	
		        	while(!esNumerico(like)){
		        		
	            		System.out.println("Introduzca el numero del la critica a la que quiere dar like (�DEBE SER UN NUMERO!)");
	            		like = lector.nextLine();
	            	}
		        	
		        	if(Integer.parseInt(like) > 0 && Integer.parseInt(like) <= cont ) {
			        	
		        		if(LikeCriticas.sumarLike(criticasValorables.get(Integer.parseInt(like)-1).getId())) {
			        		
		        			System.out.println("Ha dado like a la critica:");
			        		CriticaDTO critica = criticasValorables.get(Integer.parseInt(like)-1);
			        		System.out.println("Titulo : " + critica.getTitulo());
				        	System.out.println("Autor : " + critica.getCorreo());
			        		System.out.println("Espectaculo : " + LikeCriticas.SeleccionarTituloEspectaculo(critica.getId()));
				        	System.out.println("Puntuacion : " + critica.getPuntuacion());
				        	System.out.println("Resena : " + critica.getResena());		
			        	}
			        	else {
			        		
			        		System.out.println("No ha podido dar like");
			        	}
		        	}
		        	else {
		        		
		        		System.out.println("Numero de critica no valido");
		        	}

		        }
		        else if("5".equals(Opcion)){
		        	
		        	System.out.println("Estas son todas las criticas que puede valorar");
		        	CriticaMG LikeCriticas = new CriticaMG(this.getCorreo());
		        	ArrayList<CriticaDTO> criticasValorables = LikeCriticas.SolicitarCriticasMenosUsuario();
		        	int cont = 0;
		        	
		        	for(CriticaDTO critica : criticasValorables) {
		        		
		        		cont++; 
		        		System.out.println("------------------------------------------------");
		        		System.out.println(cont + " Titulo : " + critica.getTitulo());
			        	System.out.println("Autor : " + critica.getCorreo());
		        		System.out.println("Espectaculo : " + LikeCriticas.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
			        	System.out.println("Puntuacion : " + critica.getPuntuacion());
			        	System.out.println("Resena : " + critica.getResena());
			        	System.out.println("Likes : " + critica.getLike());
			        	System.out.println("Dislikes : " + critica.getDislike());
		        		System.out.println("------------------------------------------------");
		        	}
		        	
		        	System.out.println("Introduzca el numero de la critica a la que desea dar dislike");
		        	String dislike = lector.nextLine();
		        	
		        	while(!esNumerico(dislike)){
		        		
	            		System.out.println("Introduzca el numero del la critica a la que quiere dar dislike (�DEBE SER UN NUMERO!)");
	            		dislike = lector.nextLine();
	            	}
		        	
		        	if(Integer.parseInt(dislike) > 0 && Integer.parseInt(dislike) <= cont ) {
			        	
		        		if(LikeCriticas.sumarDislike(criticasValorables.get(Integer.parseInt(dislike)-1).getId())) {
			        		
		        			System.out.println("Ha dado dislike a la critica:");
			        		CriticaDTO critica = criticasValorables.get(Integer.parseInt(dislike)-1);
			        		System.out.println("Titulo : " + critica.getTitulo());
				        	System.out.println("Autor : " + critica.getCorreo());
			        		System.out.println("Espectaculo : " + LikeCriticas.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
				        	System.out.println("Puntuacion : " + critica.getPuntuacion());
				        	System.out.println("Resena : " + critica.getResena());		
			        	}
			        	else {
			        		System.out.println("No ha podido dar dislike");
			        	}
		        	}
		        	else {
		        		System.out.println("Numero de critica no valido");
		        	}
		        }
		        else if("6".equals(Opcion)) { 
		        	
		        	System.out.println("Estas son todas sus criticas");
		        	CriticaMG CriticaDeUsuario = new CriticaMG(this.getCorreo());
	        		ArrayList<CriticaDTO> criticasUser = CriticaDeUsuario.SolicitarCriticasInfo();
	        		
	        		for(CriticaDTO critica : criticasUser) {
	        			
	        			if(critica.getCorreo().equals(this.getCorreo())) {
	        			
	        				System.out.println("------------------------------------------------");
	        				System.out.println("Titulo : " + critica.getTitulo());
	    	        		System.out.println("Espectaculo : " + CriticaDeUsuario.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
	    		        	System.out.println("Puntuacion : " + critica.getPuntuacion());
	    		        	System.out.println("Resena : " + critica.getResena());
	    		        	System.out.println("Likes : " + critica.getLike());
	    		        	System.out.println("Dislikes : " + critica.getDislike());
	    	        		System.out.println("------------------------------------------------");
	        			}
	        		}
		        }
		        else if("7".equals(Opcion)){
		        	
		        	System.out.println("MOSTRAR CRITICAS DE UN USUARIO");
		        	System.out.println("Estos son los usuarios que han escrito criticas");
		        	CriticaMG CriticaDeEscritor = new CriticaMG(this.getCorreo());
		        	ArrayList<String> writers = CriticaDeEscritor.SolicitarAutores();
		        	int cont = 0;
		        	
		        	for(String s : writers) {
	        			
		        		cont++; 
		        		System.out.println(cont + ". " + s);
		        	}
		        	
		        	System.out.println("Introduzca el numero del autor del que quiere ver todas sus criticas");
		        	String s = lector.nextLine();
		        	
		        	while(!esNumerico(s) || (Integer.parseInt(s) > writers.size()) || (Integer.parseInt(s) < 0)){
		        		
		        		if(!esNumerico(s)){
		        			
		            		System.out.println("Introduzca el numero del autor del que quiere ver todas sus criticas (�DEBE SER UN NUMERO!)");
		            		s = lector.nextLine();
		        		}
		        		else if(Integer.parseInt(s) > writers.size() || Integer.parseInt(s) < 0){
		        			
		        			System.out.println("Numero no valido. Introduzca un numero v�lido por favor");
		        			s = lector.nextLine();
		        		}
	            	}
		        	String writer = writers.get(Integer.parseInt(s)-1);
		        	ArrayList<CriticaDTO> criticasUser = CriticaDeEscritor.SolicitudTodasCriticasUsuario(this.getCorreo()); ;
		        	
		        	for (CriticaDTO critica : criticasUser) {
		        		
		        		if(critica.getCorreo().equals(writer)) {
		        			
		        			System.out.println("------------------------------------------------");
	    	        		System.out.println("Titulo : " + critica.getTitulo());
	    	        		System.out.println("Espectaculo : " + CriticaDeEscritor.SeleccionarTituloEspectaculo(critica.getIdEspectaculo()));
	    		        	System.out.println("Puntuacion : " + critica.getPuntuacion());
	    		        	System.out.println("Resena : " + critica.getResena());
	    		        	System.out.println("Likes : " + critica.getLike());
	    		        	System.out.println("Dislikes : " + critica.getDislike());
	    	        		System.out.println("------------------------------------------------");
		        		}
		        	}
		        }
		        else{ 
		        	
		        	System.out.println("Saliendo...\n\n");
		        }

			lector.close(); 
			}
		}
	
		public boolean esNumerico(String string){
			
			boolean aux = false; 
		   	
			for (int i = 0; i < string.length(); i++) {
		   		 
			     if (Character.isDigit(string.charAt(i))){
			    	 
			       aux = true; 
			     }
		    }
		    return aux;
		}
}
