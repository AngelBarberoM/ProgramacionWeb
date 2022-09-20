package MenusSecundarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import CEU_MG.EspectaculoMG;
import CEU_MG.UsuarioMG;
import General_DTO.EspectaculoPaseMultipleDTO;
import General_DTO.EspectaculoPuntualDTO;
import General_DTO.EspectaculoTemporadaDTO;
import General_DTO.FechaDTO;
import General_DTO.PaseDTO;

/**
 * La clase se utiliza para la gestion de los espectaculos
 */
public class MenuEspectaculo {

	
private String correo;
	
	public String getCorreo() {
		
		return correo;
	}
	
	public MenuEspectaculo(String correo) {
		
		this.correo = correo;
	}
	
	public static boolean FechaValida(String inDate) {
        
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:S");
        formatoFecha.setLenient(false);

        try{
        	
			formatoFecha.parse(inDate.trim());
		} 
        catch (ParseException Excep) {

        	Excep.printStackTrace();
			return false;
		}
        
        
        return true;
    }

	public boolean EsNumerico(String string){
		
		boolean aux = false; 
	   	 
		for (int i = 0; i < string.length(); i++){
	   		 
		     if (Character.isDigit(string.charAt(i))){
		    	 
		       aux = true; 
		     }
	    }
	    return aux;
	}
	
	public void EspectaculoMenu(){
		
		
		String Opcion = "1";
		Scanner lector = new Scanner(System.in);
		while(Opcion.equals("1") || Opcion.equals("2") || Opcion.equals("3") || Opcion.equals("4") || Opcion.equals("5")){
			
			System.out.println("Bienvenido al menu de Espectaculos");
			System.out.println("Para ver los espectaculos registrados, pulse 1");
			System.out.println("Para ver los espectaculos con entradas disponibles, pulse 2");
			System.out.println("Para buscar un espectaculo por tipo, pulse 3");
			System.out.println("Para ver la informacion de un espectaculo concreto, pulse 4");
			System.out.println("Para acceder al menu de administracion, pulse 5");
			System.out.println("Para salir del menu, pulse cualquier otra tecla");

			Opcion = lector.nextLine();

		        if("1".equals(Opcion)){
		        	
		        	System.out.println("ESPECTACULOS REGISTRADOS: ");
		        	EspectaculoMG espectaculo = new EspectaculoMG();
	        		int contadorFechas =1; 
		        	
	        		for(int i=0; i<espectaculo.SolicitarEspectaculoPuntualInfo().size(); i++ ){
		        		
		        		System.out.println("------------------------------------------------------------------------------------");
		        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getNombre());
		        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getContenido());
		        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getTipo());
		        		System.out.println("FECHA " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getFechaToString());
		        		System.out.println("------------------------------------------------------------------------------------");
		        	}
		        	
	        		for(int i=0; i<espectaculo.SolicitarEspectaculoPaseMultipleInfo().size(); i++ ){
	        			
		        		contadorFechas=1;
		        		System.out.println("------------------------------------------------------------------------------------");
		        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getNombre());
		        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getContenido());
		        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getTipo());
		        		System.out.println("FECHAS: ");
		        		
		        		for(int j=0; j<espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().size(); j++){
		        			
		        			System.out.println("Fecha " + Integer.toString(contadorFechas) + ": " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().get(j).getFechaString() );
		        			contadorFechas++; 
		        		}
		        		
		        		System.out.println("------------------------------------------------------------------------------------");
		        	}
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoTemporadaInfo().size(); i++ ){
		        		
		        		contadorFechas=1;
		        		System.out.println("------------------------------------------------------------------------------------");
		        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getNombre());
		        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getContenido());
		        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getTipo());
		        		System.out.println("FECHAS: ");
		        		
		        		for(int j=0; j<espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().size(); j++){
		        			
		        			System.out.println(); 
		        			System.out.println("FECHA " + Integer.toString(contadorFechas) + ": ");
		        			System.out.println("DIA: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getDiaSemana());
		        			System.out.println("INICIO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getInicioFechaToString());
		        			System.out.println("FINAL: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getFinalFechaToString());
		        			contadorFechas++; 
		        		}
		        		System.out.println("------------------------------------------------------------------------------------");
		        	}
		        }
		        
		        else if("2".equals(Opcion)){
		        	
		        	System.out.println("ESPECTACULOS CON ENTRADAS DISPONIBLES: ");
		        	EspectaculoMG espectaculo = new EspectaculoMG();
	        		int contadorFechas =1; 
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoPuntualInfo().size(); i++ ){
		        		
		        		if((espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getLocalidadesTotales()) > (espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getLocalidadesVendidas())){
		        			
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getTipo());
			        		System.out.println("FECHA " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getFechaToString());
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoPaseMultipleInfo().size(); i++ ){
		        		
		        		contadorFechas=1;
		        		if((espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getLocalidadesTotales()) > (espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getLocalidadesVendidas())){
		        			
		        			System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getTipo());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().size(); j++){
			        			
			        			System.out.println("Fecha " + Integer.toString(contadorFechas) + ":" + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().get(j).getFechaString() );
			        			contadorFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoTemporadaInfo().size(); i++ ){
		        		
		        		contadorFechas=1;
		        		if((espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getLocalidadesTotales()) > (espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getLocalidadesVendidas()) ){
		        			
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getTipo());
			        		System.out.println("FECHAS: ");
			        		
			        		for(int j=0; j<espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().size(); j++){
			        			
			        			System.out.println(); 
			        			System.out.println("FECHA " + Integer.toString(contadorFechas) + ":");
			        			System.out.println("DIA: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getInicioFechaToString());
			        			System.out.println("FINAL: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getFinalFechaToString());
			        			contadorFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}

		        	}
		        }
		        else if("3".equals(Opcion)) {
		        	
		        	String tipo = null;  
		        	System.out.println("Introduzca tipo: ");
		        		
		        	tipo= lector.nextLine();
		
				    
		        	EspectaculoMG espectaculo = new EspectaculoMG();
	        		int contadorFechas =1; 
		        	
	        		for(int i=0; i<espectaculo.SolicitarEspectaculoPuntualInfo().size(); i++ ){
	        			
		        		if(espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getTipo().equals(tipo)){
		        			
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getTipo());
			        		System.out.println("FECHA " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getFechaToString());
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoPaseMultipleInfo().size(); i++ ){
		        		
		        		contadorFechas=1;
		        		
		        		if(espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getTipo().equals(tipo)){
		        			
		        			System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getTipo());
			        		System.out.println("FECHAS: ");
			        		
			        		for(int j=0; j<espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().size(); j++){
			        			
			        			System.out.println("Fecha " + Integer.toString(contadorFechas) + ":" + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().get(j).getFechaString() );
			        			contadorFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoTemporadaInfo().size(); i++ )
		        	{
		        		contadorFechas=1;
		        		if(espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getTipo().equals(tipo))
		        		{
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getTipo());
			        		System.out.println("LOCALIDADES TOTALES: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getLocalidadesTotales());
			        		System.out.println("FECHAS: ");
			        		
			        		for(int j=0; j<espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().size(); j++){
			        			
			        			System.out.println(); 
			        			System.out.println("FECHA " + Integer.toString(contadorFechas) + ":");
			        			System.out.println("DIA: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getInicioFechaToString());
			        			System.out.println("FINAL: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getFinalFechaToString());
			        			contadorFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        }
		        else if("4".equals(Opcion)){
		        	
		        	String nombre = null;  
		        	System.out.println("Introduzca nombre del espectaculo: ");

	        		nombre= lector.nextLine();

		        	EspectaculoMG espectaculo = new EspectaculoMG();
	        		int contadorFechas =1; 
		        	
	        		for(int i=0; i<espectaculo.SolicitarEspectaculoPuntualInfo().size(); i++ ){
		        		
		        		if(espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getNombre().equals(nombre)){
		        			
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getTipo());
			        		System.out.println("FECHA " + espectaculo.SolicitarEspectaculoPuntualInfo().get(i).getFechaToString());
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoPaseMultipleInfo().size(); i++ ){
		        		
		        		contadorFechas=1;
		        		
		        		if(espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getNombre().equals(nombre)){
		        			
		        			System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getTipo());
			        		System.out.println("FECHAS: ");
			        		for(int j=0; j<espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().size(); j++)
			        		{
			        			System.out.println("Fecha " + Integer.toString(contadorFechas) + ":" + espectaculo.SolicitarEspectaculoPaseMultipleInfo().get(i).getFecha().get(j).getFechaString() );
			        			contadorFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}
		        	}
		        	
		        	for(int i=0; i<espectaculo.SolicitarEspectaculoTemporadaInfo().size(); i++ ){
		        		
		        		contadorFechas=1;
		        		
		        		if(espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getNombre().equals(nombre)){
		        			
			        		System.out.println("------------------------------------------------------------------------------------");
			        		System.out.println("NOMBRE: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getNombre());
			        		System.out.println("CONTENIDO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getContenido());
			        		System.out.println("TIPO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getTipo());
			        		System.out.println("LOCALIDADES TOTALES: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getLocalidadesTotales());
			        		System.out.println("FECHAS: ");
			        		
			        		for(int j=0; j<espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().size(); j++){
			        			
			        			System.out.println(); 
			        			System.out.println("FECHA " + Integer.toString(contadorFechas) + ":");
			        			System.out.println("DIA: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getDiaSemana());
			        			System.out.println("INICIO: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getInicioFechaToString());
			        			System.out.println("FINAL: " + espectaculo.SolicitarEspectaculoTemporadaInfo().get(i).getPase().get(j).getFinalFechaToString());
			        			contadorFechas++; 
			        		}
			        		System.out.println("------------------------------------------------------------------------------------");
		        		}

		        	}
		        }
		        else if(Opcion.equals("5"))
		        {
		        	EspectaculoMenuAdmin(correo);
		        }

				lector.close(); 
		}

	}
	
	public void EspectaculoMenuAdmin(String correo){
		
		Scanner lector = new Scanner(System.in);
		EspectaculoMG espectaculo = new EspectaculoMG(); 
		UsuarioMG usuario = new UsuarioMG(); 
		
		for(int i =0; i < usuario.SolicitarUsuarioPorTipo("admin").size(); i++){
			
			if(usuario.SolicitarUsuarioPorTipo("admin").get(i).getCorreo().equals(correo)){
				
				String Opcion = "1";
				
				while(Opcion.equals("1") || Opcion.equals("2") || Opcion.equals("3")){
					
					System.out.println("MENU DE ADMINISTRADOR: Gestion de Espectaculos");
					System.out.println("Para dar de Alta un espectaculo, pulse 1");
					System.out.println("Para dar de baja de un espectaculo, pulse 2");
					System.out.println("Para actualizar la informacion sobre un espectaculo, pulse 3");
					System.out.println("Para salir del menu, pulse cualquier otra tecla");

					Opcion = lector.nextLine();
				        
					if("1".equals(Opcion)){
						
						String opcionEspec = "1";
						while(EsNumerico(opcionEspec)||!opcionEspec.equals("1") || opcionEspec.equals("2") || opcionEspec.equals("3")){
							
							System.out.println("DAR DE ALTA ESPECTACULO");
							System.out.println("Si quiere crear un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere crear un espectaculo puntual, pulse 2");
							System.out.println("Si quiere crear un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcionEspec = lector.nextLine(); 
							
							if("1".equals(opcionEspec)){
								
								String nombre, contenido, tipo, diaSemana; 
								LocalDateTime fechaInicio, fechaFinal;
								int localidadesTotales, localidadesVendidas;  
								Boolean pasesSiNo = true;
								ArrayList<PaseDTO> pasesLista = new ArrayList<PaseDTO>();
								
								EspectaculoMG especpuntual = new EspectaculoMG();
								int id = especpuntual.GenerarIdEspectaculoPuntual();
								System.out.println("Introduce el nombre.");
								nombre = lector.nextLine(); 
								System.out.println("Introduce la tipo.");
								tipo = lector.nextLine(); 
								
								System.out.println("Introduce la contenido.");
								contenido = lector.nextLine(); 
								
								do{
									
									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm:ss.0)");
									String aux = lector.nextLine();

									
									DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
									fechaInicio = LocalDateTime.parse(aux, formato);
									
									int idespecpuntual = especpuntual.generarIDPases();
									System.out.println("Introduce fecha de finalizacion. (Formato: yyyy-MM-dd HH:mm:ss.0)");								
									aux = lector.nextLine();
									
									
									fechaFinal = LocalDateTime.parse(aux, formato);
									System.out.println("Introduce dia de la Semana.");
									diaSemana = lector.nextLine(); 
									System.out.println("Desea introducir mas pases? (Si/No)");
									aux = lector.nextLine(); 
									
									while(true){
										
										if(aux.equals("no") || aux.equals("No")){
											
											pasesSiNo = false; 
											break; 
										}
										else if (aux.equals("si") || aux.equals("Si")){
											
											pasesSiNo = true; 
											break; 
										}
										else{
											
											System.out.println("Desea introducir mas pases? (Si/No)");
											aux = lector.nextLine(); 
										}
									}
									espectaculo.CrearPase(idespecpuntual,fechaInicio, diaSemana, fechaFinal, id); 

									pasesLista.add(especpuntual.SolicitarPase(id)); 
									
								}while(pasesSiNo==true); 
								
								System.out.println("Introduce el numero de localidades a la venta.");
								String AuxiliarLocal = lector.nextLine();
								
								while(!EsNumerico(AuxiliarLocal)){
									
									System.out.println("Error. Introduzca un numero");
									AuxiliarLocal = lector.nextLine();
								}
								
								localidadesTotales = Integer.parseInt(AuxiliarLocal);
								System.out.println("Introduce el numero de localidades vendidas.");
								AuxiliarLocal = lector.nextLine();
								
								while(!EsNumerico(AuxiliarLocal)){
									
									System.out.println("Error. Introduzca un numero para las localidades vendidas");
									AuxiliarLocal = lector.nextLine();
								}			
								
								localidadesVendidas = Integer.parseInt(AuxiliarLocal);
								espectaculo.CrearEspectaculoTemporada(id, nombre, tipo, contenido, localidadesTotales, localidadesVendidas, pasesLista);
							}
							if("2".equals(opcionEspec)){
								
								String nombre, contenido, tipo; 
								LocalDateTime fecha;
								int localidadesTotales, localidadesVendidas; 
								
								EspectaculoMG especpuntual = new EspectaculoMG();
								int id = especpuntual.GenerarIdEspectaculoPuntual();
								
								System.out.println("Introduce el nombre.");
								nombre = lector.nextLine(); 
								System.out.println("Introduce la tipo.");
								tipo = lector.nextLine(); 
								System.out.println("Introduce la contenido.");
								contenido = lector.nextLine(); 
								
								System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm:ss.0)");
								String aux = lector.nextLine();
								
								DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
								fecha = LocalDateTime.parse(aux, formato);	
								
								System.out.println("Introduce el numero de localidades a la venta.");
								String AuxiliarLocal = lector.nextLine();
							
								while(!EsNumerico(AuxiliarLocal)){
									
									System.out.println("Error. Introduzca un numero");
									AuxiliarLocal = lector.nextLine();
								}
								
								localidadesTotales = Integer.parseInt(AuxiliarLocal);
								System.out.println("Introduce el numero de localidades vendidas.");
								AuxiliarLocal = lector.nextLine();
								
								while(!EsNumerico(AuxiliarLocal)){
									
									System.out.println("Error. Introduzca un numero");
									AuxiliarLocal = lector.nextLine();
								}
								localidadesVendidas = Integer.parseInt(AuxiliarLocal);
								
								espectaculo.CrearEspectaculoPuntual(id, nombre, tipo, contenido, localidadesTotales, localidadesVendidas, fecha);
								
							}
							if("3".equals(opcionEspec)){
								
								String nombre, contenido, tipo;
								LocalDateTime fecha;
								int localidadesTotales, localidadesVendidas;  
								Boolean pasesSiNo = true;
								ArrayList<FechaDTO> fechaslis = new ArrayList<FechaDTO>();

								EspectaculoMG espectaculopasemultiple = new EspectaculoMG();
								int id = espectaculopasemultiple.GenerarIdEspectaculoPaseMultiple();
								System.out.println("Introduce el nombre.");
								nombre = lector.nextLine(); 
								System.out.println("Introduce la tipo.");
								tipo = lector.nextLine(); 
								System.out.println("Introduce la contenido.");
								contenido = lector.nextLine(); 							
								int idFecha = espectaculopasemultiple.GenerarIdFecha();
								
								do
								{
									System.out.println("Introduce fecha. (Formato: yyyy-MM-dd HH:mm:ss.0)");
									String aux = lector.nextLine();
									DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
									fecha = LocalDateTime.parse(aux, formato);

									System.out.println("Desea introducir mas fechas? (Si/No)");
									aux = lector.nextLine(); 
									
									while(true){
										
										if(aux.equals("no") || aux.equals("No")){
											
											pasesSiNo = false; 
											break; 
										}
										else if (aux.equals("si") || aux.equals("Si")){
											
											pasesSiNo = true; 
											break; 
										}
										else{
											
											System.out.println("Desea introducir mas fechas? (Si/No)");
											aux = lector.nextLine(); 
										}
									}
									
									espectaculo.CrearFecha(idFecha,fecha, id); 
									fechaslis.add(espectaculopasemultiple.SolicitarFecha(id)); 
									
								}while(pasesSiNo==true); 

								System.out.println("Introduce el numero de localidades a la venta.");
								String AuxiliarLocal = lector.nextLine();
								
								while(!EsNumerico(AuxiliarLocal)){
									
									System.out.println("Error. Introduzca un numero");
									AuxiliarLocal = lector.nextLine();
								}
								localidadesTotales = Integer.parseInt(AuxiliarLocal);
								System.out.println("Introduce el numero de localidades vendidas.");
								AuxiliarLocal = lector.nextLine();
								
								while(!EsNumerico(AuxiliarLocal)){
									
									System.out.println("Error. Introduzca un numero");
									AuxiliarLocal = lector.nextLine();
								}
								localidadesVendidas = Integer.parseInt(AuxiliarLocal);	
								
								espectaculopasemultiple.CrearEspectaculoPaseMultiple(id, nombre, tipo, contenido, localidadesTotales, localidadesVendidas,fechaslis);

							}
						}
					}
					else if("2".equals(Opcion)){
						
						String opcionEspec = "1"; 
						
						while(opcionEspec.equals("1") || opcionEspec.equals("2") || opcionEspec.equals("3")){
							
							System.out.println("DAR DE BAJA ESPECTACULO");
							System.out.println("Si quiere eliminar un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere eliminar un espectaculo puntual, pulse 2");
							System.out.println("Si quiere eliminar un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcionEspec = lector.nextLine(); 
							
							if("1".equals(opcionEspec)){
								
								EspectaculoMG eliminarTemp = new EspectaculoMG();
				        		ArrayList<EspectaculoTemporadaDTO> espectaculos = eliminarTemp.SolicitarEspectaculoTemporadaInfo();
				        		int cont = 0;
				        		
				        		for(EspectaculoTemporadaDTO Excep : espectaculos){
				        			
				        			cont++;
				        			System.out.println(cont + ". " + Excep.getNombre());
				        			System.out.println(Excep.getTipo());
				        			System.out.println(Excep.getContenido());
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
					        	String Esp = lector.nextLine();
					        	
					        	if(Integer.parseInt(Esp) > 0 && (Integer.parseInt(Esp)-1) <= cont ){
					        		
					        		int id = espectaculos.get(Integer.parseInt(Esp)-1).getId();
					        		eliminarTemp.EliminarEspectaculoTemporada(id);
					        		System.out.println("Espectaculo eliminado.");
					        	}
					        	else{
					        		
					        		System.out.println("Espectaculo no valido");
					        	}
							}
							else if("2".equals(opcionEspec)){
								
								EspectaculoMG eliminarPunt = new EspectaculoMG();
				        		ArrayList<EspectaculoPuntualDTO> espectaculos = eliminarPunt.SolicitarEspectaculoPuntualInfo();
				        		int cont = 0;
				        		for(EspectaculoPuntualDTO Excep : espectaculos) 
				        		{
				        			cont++;
				        			System.out.println(cont + ". " + Excep.getNombre());
				        			System.out.println(Excep.getTipo());
				        			System.out.println(Excep.getContenido());
				        			
				        		}
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
					        	String Esp = lector.nextLine();
					        	if(Integer.parseInt(Esp) > 0 && (Integer.parseInt(Esp)) <= cont ){
					        		
					        		int id = espectaculos.get(Integer.parseInt(Esp)-1).getId();
					        		eliminarPunt.EliminarEspectaculoPuntual(id);
					        		System.out.println("Espectaculo eliminado.");
					        	}
					        	else{
					        		
					        		System.out.println("Espectaculo no valido");
					        	}
							}
							
							else if("3".equals(opcionEspec)){
								
								EspectaculoMG eliminarMult = new EspectaculoMG();
				        		ArrayList<EspectaculoPaseMultipleDTO> espectaculos = eliminarMult.SolicitarEspectaculoPaseMultipleInfo();
				        		int cont = 0;
				        	
				        		for(EspectaculoPaseMultipleDTO Excep : espectaculos){
				        			
				        			cont++;
				        			System.out.println(cont + ". " + Excep.getNombre());
				        			System.out.println(Excep.getTipo());
				        			System.out.println(Excep.getContenido());
				        			
				        		}
				        		
				        		System.out.println("Introduzca el numero del espectaculo a eliminar");
					        	String Esp = lector.nextLine();
					        	
					        	if(Integer.parseInt(Esp) > 0 && (Integer.parseInt(Esp)-1) <=cont ){
					        		
					        		int id = espectaculos.get(Integer.parseInt(Esp)-1).getId();
					        		eliminarMult.EliminarEspectaculoPaseMultiple(id);
					        		System.out.println("Espectaculo eliminado.");
					        	}
					        	else{
					        		
					        		System.out.println("Espectaculo no valido");
					        	}
							}
						}
					}
					else if("3".equals(Opcion)){
						
						String opcionEspec = "1"; 
					
						while(opcionEspec.equals("1") || opcionEspec.equals("2") || opcionEspec.equals("3")){
							
							System.out.println("ACTUALIZAR INFORMACION DE ESPECTACULO");
							System.out.println("Si quiere actualizar un espectaculo de temporada, pulse 1");
							System.out.println("Si quiere actualizar un espectaculo puntual, pulse 2");
							System.out.println("Si quiere actualizar un espectaculo multiple, pulse 3");
							System.out.println("Para volver, pulse cualquier otra tecla");
							opcionEspec = lector.nextLine(); 
							
							if("1".equals(opcionEspec)){
								
								System.out.println("ACTUALIZACION DE DATOS");
					        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
					        	
					        	EspectaculoMG actualizarTemp = new EspectaculoMG();
				        		ArrayList<EspectaculoTemporadaDTO> espectaculos = actualizarTemp.SolicitarEspectaculoTemporadaInfo();
				        		int cont = 0;
				        	
				        		for(EspectaculoTemporadaDTO Excep : espectaculos) {
				        			
				        			cont++;
				        			System.out.println(cont + ". " + Excep.getNombre());
				        			System.out.println(Excep.getTipo());
				        			System.out.println(Excep.getContenido());
				        		}
				        		
				        		System.out.println("Introduzca el numero del espectaculo a actualizar");
					        	String Esp = lector.nextLine();
					        	
					        	if(Integer.parseInt(Esp) > 0 && (Integer.parseInt(Esp)) <=cont ){
					        		
									String nombre, contenido, tipo, diaSemana; 
									LocalDateTime fechaInicio, fechaFinal;
									int localidadesTotales, localidadesVendidas;  
									Boolean pasesSiNo = true;
									ArrayList<PaseDTO> pasesLista = new ArrayList<PaseDTO>();
									
					        		int id = espectaculos.get(Integer.parseInt(Esp)-1).getId();
									System.out.println("Introduce el nombre.");
									nombre = lector.nextLine(); 
									System.out.println("Introduce la tipo.");
									tipo = lector.nextLine(); 
									System.out.println("Introduce la contenido.");
									contenido = lector.nextLine(); 
									
									pasesLista = espectaculos.get(Integer.parseInt(Esp)-1).getPase();
					        		ArrayList<PaseDTO> pases = actualizarTemp.SolicitarPases();
					        		int conta = 0;
					        		
					        		for(PaseDTO pas : pases) {
					        			
					        			conta++;
					        			System.out.println(conta + ". " + pas.getId());
					        			System.out.println(pas.getInicioFecha());
					        			System.out.println(pas.getDiaSemana());
					        			System.out.println(pas.getFinalFecha());
					        		}
									System.out.println("Introduzca el numero del pase a actualizar");
						        	String Pase = lector.nextLine();
						        	
									if(Integer.parseInt(Pase) > 0 && (Integer.parseInt(Esp)) <=cont ) {
										
										do{
											
											System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm:ss.0)");
											String aux = lector.nextLine();

											int idespecpuntual = pases.get(Integer.parseInt(Pase)-1).getId();
											
											DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
											fechaInicio = LocalDateTime.parse(aux, formato);
											System.out.println("Introduce fecha de finalizacion. (Formato: yyyy-MM-dd HH:mm:ss.0)");
											aux = lector.nextLine();

											fechaFinal = LocalDateTime.parse(aux, formato);
											System.out.println("Introduce dia de la Semana.");
											diaSemana = lector.nextLine(); 
											System.out.println("Desea actualizar otro pase? (Si/No)");
											aux = lector.nextLine(); 
											while(true)
											{
												if(aux.equals("no") || aux.equals("No")){
													
													pasesSiNo = false; 
													break; 
												}
												else if (aux.equals("si") || aux.equals("Si")){
													
													pasesSiNo = true; 
													break; 
												}
												else{
													
													System.out.println("Desea introducir mas pases? (Si/No)");
												}
											}
											espectaculo.ActualizarPases(idespecpuntual,fechaInicio, diaSemana, fechaFinal, id);  
									
										}while(pasesSiNo==true); 
									
										pasesLista = espectaculos.get(Integer.parseInt(Esp)-1).getPase();
						        	}

									System.out.println("Introduce el numero de localidades a la venta.");
									String AuxiliarLocal = lector.nextLine();
									
									while(!EsNumerico(AuxiliarLocal)){
										
										System.out.println("Error. Introduzca un numero");
										AuxiliarLocal = lector.nextLine();
									}
									
									localidadesTotales = Integer.parseInt(AuxiliarLocal);
									System.out.println("Introduce el numero de localidades vendidas.");
									AuxiliarLocal = lector.nextLine();
									
									while(!EsNumerico(AuxiliarLocal)){
										
										System.out.println("Error. Introduzca un numero");
										AuxiliarLocal = lector.nextLine();
									}
									
									localidadesVendidas = Integer.parseInt(AuxiliarLocal);
									
									espectaculo.ActualizarEspectaculoTemporada(id, nombre, tipo, contenido, localidadesTotales, localidadesVendidas, pasesLista);
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else {
					        		
					        		System.out.println("Espectaculo no valido");
					        	}
							}
							else if("2".equals(opcionEspec)){
								
								
								System.out.println("ACTUALIZACION DE DATOS");
					        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
					        	
					        	EspectaculoMG actualizarPunt = new EspectaculoMG();
				        		ArrayList<EspectaculoPuntualDTO> espectaculos = actualizarPunt.SolicitarEspectaculoPuntualInfo();
				        		int cont = 0;
				        		
				        		for(EspectaculoPuntualDTO Excep : espectaculos) {	
				        			
				        			cont++;
				        			System.out.println(cont + ". " + Excep.getNombre());
				        			System.out.println(Excep.getTipo());
				        			System.out.println(Excep.getContenido());
				        		}
				        		
				        		System.out.println("Introduzca el numero del espectaculo a actualizar");
					        	String Esp = lector.nextLine();
					        	
					        	if(Integer.parseInt(Esp) > 0 && (Integer.parseInt(Esp)) <=cont ) {
					        		
									String nombre, contenido, tipo; 
									LocalDateTime fecha;
									int localidadesTotales, localidadesVendidas;  

									
					        		int id = espectaculos.get(Integer.parseInt(Esp)-1).getId();
									System.out.println("Introduce el nombre.");
									nombre = lector.nextLine(); 
									System.out.println("Introduce la tipo.");
									tipo = lector.nextLine(); 
									System.out.println("Introduce la contenido.");
									contenido = lector.nextLine(); 
		
									System.out.println("Introduce fecha de Inicio. (Formato: yyyy-MM-dd HH:mm:ss.0)");
									String aux = lector.nextLine();
									DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
									fecha = LocalDateTime.parse(aux, formato);

									System.out.println("Introduce el numero de localidades a la venta.");
									String AuxiliarLocal = lector.nextLine();
									
									while(!EsNumerico(AuxiliarLocal)){
										
										System.out.println("Error. Introduzca un numero");
										AuxiliarLocal = lector.nextLine();
									}
									
									localidadesTotales = Integer.parseInt(AuxiliarLocal);
									System.out.println("Introduce el numero de localidades vendidas.");
									AuxiliarLocal = lector.nextLine();
									
									while(!EsNumerico(AuxiliarLocal)){
										
										System.out.println("Error. Introduzca un numero");
										AuxiliarLocal = lector.nextLine();
									}
									
									localidadesVendidas = Integer.parseInt(AuxiliarLocal);	
									espectaculo.ActualizarEspectaculoPuntual(id, nombre, tipo, contenido, localidadesTotales, localidadesVendidas, fecha);
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else {
					        		
					        		System.out.println("Espectaculo no valido");
					        	}

							}
							else if("3".equals(opcionEspec))
							{
								
								System.out.println("ACTUALIZACION DE DATOS");
					        	System.out.println("IMPORTANTE: Si hay un valor que NO desee actualizar, escriba su valor actual");
					        	
					        	EspectaculoMG actualizarMult = new EspectaculoMG();
				        		ArrayList<EspectaculoPaseMultipleDTO> espectaculos = actualizarMult.SolicitarEspectaculoPaseMultipleInfo();
				        		int cont = 0;
				        		
				        		for(EspectaculoPaseMultipleDTO Excep : espectaculos) {
				        			
				        			cont++;
				        			System.out.println(cont + ". " + Excep.getNombre());
				        			System.out.println(Excep.getTipo());
				        			System.out.println(Excep.getContenido());
				        		}
				        		
				        		System.out.println("Introduzca el numero del espectaculo a actualizar");
					        	String Esp = lector.nextLine();
					        	
					        	if(Integer.parseInt(Esp) > 0 && (Integer.parseInt(Esp)) <=cont ) {
					        		
									String nombre, contenido, tipo; 
									LocalDateTime fecha;
									int localidadesTotales, localidadesVendidas;  
									Boolean decisionFechas = true;
									ArrayList<FechaDTO> fechaslis= new ArrayList<FechaDTO>();
									
					        		int id = espectaculos.get(Integer.parseInt(Esp)-1).getId();
									System.out.println("Introduce el nombre.");
									nombre = lector.nextLine(); 
									System.out.println("Introduce la tipo.");
									tipo = lector.nextLine(); 
									System.out.println("Introduce la contenido.");
									contenido = lector.nextLine();
						        	
									ArrayList<FechaDTO> fechas = actualizarMult.SolicitarFechas();
					        		int conta = 0;
					        		
					        		for(FechaDTO fech : fechas) {
					        			
					        			conta++;
					        			System.out.println(conta + ". " + fech.getId());
					        			System.out.println(fech.getFecha());
					        		}
					        		
					        		System.out.println("Introduzca el numero de la fecha a actualizar");
						        	String Fecha = lector.nextLine();
						        	
									if(Integer.parseInt(Fecha) > 0 && (Integer.parseInt(Esp)) <=cont ){
										
										fechaslis = espectaculos.get(Integer.parseInt(Esp)-1).getFecha();
										do{
											
							        		for(FechaDTO fech : fechas){
							        			
							        			System.out.println(conta + ". " + fech.getId());
							        			System.out.println(fech.getFecha());
							        		}
							        		
							        		System.out.println("Confirme  el numero de la fecha a actualizar");
							        		Fecha = lector.nextLine();
								        	
											System.out.println("Introduce fecha. (Formato: yyyy-MM-dd HH:mm:ss.0)");
											String aux = lector.nextLine();
											
											
											DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
											fecha = LocalDateTime.parse(aux, formato);
											
											int idespecpuntual = fechas.get(Integer.parseInt(Fecha)-1).getId();
											
											System.out.println("Desea actualizar otra fecha? (Si/No)");
											aux = lector.nextLine(); 
											
											while(true){
												
												if(aux.equals("no") || aux.equals("No")){
													
													decisionFechas = false; 
													break; 
												}
												else if (aux.equals("si") || aux.equals("Si")){
													
													decisionFechas = true; 
													break; 
												}
												else{
													
													System.out.println("Desea actualizar mas fechas? (Si/No)");
													aux = lector.nextLine(); 
												}
											}
											espectaculo.ActualizarFechas(idespecpuntual,fecha, id);  
											
										}while(decisionFechas==true); 
										
										fechaslis = espectaculos.get(Integer.parseInt(Esp)-1).getFecha();
						        	}
									fechaslis = espectaculos.get(Integer.parseInt(Esp)-1).getFecha();
									 
									System.out.println("Introduce el numero de localidades a la venta.");
									String AuxiliarLocal = lector.nextLine();
									
									while(!EsNumerico(AuxiliarLocal)){
										
										System.out.println("Error. Introduzca un numero");
										AuxiliarLocal = lector.nextLine();
									}
									localidadesTotales = Integer.parseInt(AuxiliarLocal);
									System.out.println("Introduce el numero de localidades vendidas.");
									AuxiliarLocal = lector.nextLine();
									
									while(!EsNumerico(AuxiliarLocal)){
										
										System.out.println("Error. Introduzca un numero");
										AuxiliarLocal = lector.nextLine();
									}
									localidadesVendidas = Integer.parseInt(AuxiliarLocal);
									espectaculo.ActualizarEspectaculoPaseMultiple(id, nombre, tipo, contenido, localidadesTotales, localidadesVendidas, fechaslis);
									

									
					        		System.out.println("Espectaculo actualizado.");
					        	}
					        	else {
					        		
					        		System.out.println("Espectaculo no valido");
					        	}

							}
						}
					}
				}
		
			}
				else if(i == (usuario.SolicitarUsuarioPorTipo("admin").size()-1))
				{
					System.out.println("No tiene permiso para acceder al menu de Administracion");
				}

			lector.close(); 
			}
		}
}
