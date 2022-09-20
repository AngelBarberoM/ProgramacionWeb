package GeneralDAO;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import ConexDB.DBConexion;
import General_DTO.CriticaDTO;
import General_DTO.EspectaculoDTO;
import General_DTO.VotanteDTO;


/*
 * Clase con funciones de las criticas y BD
 */

public class CriticaDAO {
	
	String RutaSQL = "./src/sql.properties";
	
	/*
	 * Funcion que busca y devuleve el titulo almacenado en la BD de un espectaculo
	 * @param Id 
	 * @return Titulo
	 */
	public String SeleccionarTituloEspectaculo(int Id) {
	
		String Titulo=null;
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
		
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("seleccionarTituloEspectaculo");
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			if(resultado.next()){
				
				Titulo = resultado.getString("Titulo");
			}
			if (declaracion != null){ 
				
				declaracion.close(); 
			}
			
			DBConexion.closeConnection();
		
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return Titulo;
	}
	
	/*
	 * Funcion que busca y comprueba que exista una critica por ID
	 * @param Id 
	 * @return true / false
	 */
	private boolean ExisteIdCritica(int Id){
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("existeIdCriticas");
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()){
				
				if(Integer.parseInt(resultado.getString("Id"))==Id){
					
					return true; 
				}
			}
			
			DBConexion.closeConnection();
		
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return false; 
	}
	
	/*
	 * Funcion que genera un ID para una critica que no exista
	 * @return Id 
	 */
	public int GenerarIdCritica(){

		Random num = new Random();
		int Id = num.nextInt(99999)+1; 
		
		if (ExisteIdCritica(Id) == true){
			
			GenerarIdCritica();
		}
		
		return Id;
	}
	
	/*
	 * Funcion que comprueba si existe un ID de una votacion
	 * @param Id 
	 * @return true / false
	 */

	private boolean ExisteIdVotacion(int Id)
	{
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("existeIdVotantes");
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()){
				
				if(Integer.parseInt(resultado.getString("IdVotantes"))==Id){
					
					return true; 
				}
			}
			
			DBConexion.closeConnection();
		
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return false; 
	}
	
	/*
	 * Funcion que genera un ID para un voto que no exista
	 * @return Id 
	 */
	
	public int GenerarIdVoto(){
		
		Random num = new Random();
		int Id = num.nextInt(99999)+1; 
		
		if (ExisteIdVotacion(Id) == true){
			
			GenerarIdCritica();
		}
		
		return Id;
	}
	
	/*
	 * Funcion que crea una critica 
	 * @param NuevaCritica 
	 */
	
	public void CrearCritica(CriticaDTO NuevaCritica){
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
	
		try(InputStream InSt = new FileInputStream(RutaSQL)){
		
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("crearCritica");
			cuestion=cuestion.replaceAll("varid", Integer.toString(GenerarIdCritica()));
			cuestion=cuestion.replaceAll("vartitulo", NuevaCritica.getTitulo());
			cuestion=cuestion.replaceAll("varresena", NuevaCritica.getResena()); 
			cuestion=cuestion.replaceAll("varcorreo", NuevaCritica.getCorreo());
			cuestion=cuestion.replaceAll("varpuntuacion", Float.toString(NuevaCritica.getPuntuacion()));
			cuestion=cuestion.replaceAll("varidespectaculo", Integer.toString(NuevaCritica.getIdEspectaculo()));
			Statement declaracion = conexion.createStatement();
			declaracion.executeUpdate(cuestion);
			
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
		
			System.err.println(Excep);
			Excep.printStackTrace();
		}
	}
	
	/*
	 * Funcion que a�ade un voto y la persona que lo realiza
	 * @param Correo
	 * @param Id 
	 * @param voto
	 */
	
	public void AnadirVotanteVotoCritica(String Correo, int Id, String voto) {
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("crearVotantes");
			cuestion=cuestion.replaceAll("varcorreo", Correo);
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			cuestion=cuestion.replaceAll("varvoto", voto);
			cuestion = cuestion.replaceAll("varidvotantes", Integer.toString(GenerarIdVoto())); 
			Statement declaracion = conexion.createStatement();
			declaracion.executeUpdate(cuestion);
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
		
			System.err.println(Excep);
			Excep.printStackTrace();
		}
	}
	
	/*
	 * Funcion que elimina los votos de una critica 
	 * @param Id 
	 */
	
	public void EliminarVotantesCritica(int Id) {
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("eliminarVotantes");
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			Statement declaracion = conexion.createStatement();
			declaracion.executeUpdate(cuestion);
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
		
			System.err.println(Excep);
			Excep.printStackTrace();
		}
	}
	
	/*
	 * Funcion que elimina un voto de una critica por correo e ID 
	 * @param Correo 
	 * @param Id 
	 */
	
	public void EliminarVotanteCritica(String Correo, int Id) {
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("eliminarUsuarioVotantes");
			cuestion=cuestion.replaceAll("varcorreo", Correo);
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			Statement declaracion = conexion.createStatement();
			declaracion.executeUpdate(cuestion);
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
	}
	
	/*
	 * Funcion que solicita los votos de una critca
	 * @param Id 
	 * @return Votante 
	 */
	
	public ArrayList<VotanteDTO> SolicitarVotantes(int Id){
	
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		ArrayList<VotanteDTO> Votante = new ArrayList<VotanteDTO>();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
		
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarInfoVotantes");
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while(resultado.next()) {
				
				VotanteDTO votCri = new VotanteDTO();
				String votante = resultado.getString("Correo");
				String voto = resultado.getString("voto");
				votCri.setId(Id);
				votCri.setPersonaVota(votante);
				votCri.setVotoPersona(voto);
				Votante.add(votCri);
			}
			
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
		
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return Votante;
	}
	
	/*
	 * Funcion que actuliza  una critica a partir de datos
	 * @param critica DTO de Critica con la informacion actualizada
	 * @author Developers
	 */
	
	public void ActualizarCritica(CriticaDTO critica){
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("critica");
			cuestion=cuestion.replaceAll("vartitulo", critica.getTitulo());
			cuestion=cuestion.replaceAll("varresena", critica.getResena());
			cuestion=cuestion.replaceAll("varresena", critica.getResena());
			cuestion=cuestion.replaceAll("varlike", Integer.toString(critica.getLike()));
			cuestion=cuestion.replaceAll("vardislike", Integer.toString(critica.getDislike()));
			cuestion=cuestion.replaceAll("varid", Integer.toString(critica.getId()));
			Statement declaracion = conexion.createStatement();
			declaracion.executeUpdate(cuestion);
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
	}
	
	/*
	 * Funcion que elimina una critica por ID
	 * @param Id 
	 */
	
	public void EliminarCritica(int Id) {
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("eliminarCritica");
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			Statement declaracion = conexion.createStatement();
			declaracion.executeUpdate(cuestion);
			
			String cuestion2 = propiedades.getProperty("eliminarVotantes");
			cuestion2=cuestion2.replaceAll("varid", Integer.toString(Id));
			Statement declaracion2 = conexion.createStatement();
			declaracion2.executeUpdate(cuestion2);
			
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
	}
	
	/*
	 * Funcion que solicita una critica por ID
	 * @param Id
	 * @return CriticaSolicitada
	 */
	
	public CriticaDTO SolicitarCritica(int Id)
	{
		CriticaDTO CriticaSolicitada = new CriticaDTO();
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarInfoCritica");
			cuestion=cuestion.replaceAll("varid", Integer.toString(Id));
			
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			if(resultado.next()){
				
				int iduser = Integer.parseInt(resultado.getString("Id"));
				float Puntuacion = Float.parseFloat(resultado.getString("Puntuacion"));
				String Titulo = resultado.getString("Titulo");
				String Resena= resultado.getString("Resena");
				String Correo = resultado.getString("Correo");
				int Like = resultado.getInt("Like");
				int Dislike =resultado.getInt("Dislike");
				ArrayList<VotanteDTO> Votante = this.SolicitarVotantes(Id);
				int IdEspectaculo = Integer.parseInt(resultado.getString("IdEspectaculo")); 
				CriticaSolicitada.setCorreo(Correo);
				CriticaSolicitada.setId(iduser);
				CriticaSolicitada.setTitulo(Titulo);
				CriticaSolicitada.setResena(Resena);
				CriticaSolicitada.setPuntuacion(Puntuacion); 
				CriticaSolicitada.setLike(Like);
				CriticaSolicitada.setDislike(Dislike);
				CriticaSolicitada.setVotantes(Votante);
				CriticaSolicitada.setIdEspectaculo(IdEspectaculo);
			}
			if (declaracion != null){ 
			
				declaracion.close(); 
			}
			
			DBConexion.closeConnection();
		}
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		
		return CriticaSolicitada;
	}
	
	/*
	 * Funcion solicita a las criticas informacion de todas 
	 * @return todasCriticas 
	 */
	
	public ArrayList<CriticaDTO> SolicitarCriticasInfo(){
		
		ArrayList<CriticaDTO> todasCriticas = new ArrayList<CriticaDTO>();
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarTodasCriticas");
			
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()) {
				
				String Titulo = resultado.getString("Titulo");
				float Puntuacion = resultado.getFloat("Puntuacion");
				String Resena = resultado.getString("Resena");
				int Id = resultado.getInt("Id");
				String Correo = resultado.getString("Correo");
				int Like = resultado.getInt("Like");
				int Dislike = resultado.getInt("Dislike");
				ArrayList<VotanteDTO> Votante = this.SolicitarVotantes(Id);
				int IdEspectaculo = Integer.parseInt(resultado.getString("IdEspectaculo"));
				
				CriticaDTO Critica = new CriticaDTO(Titulo,Puntuacion,Resena,Id,Correo,Like,Dislike, IdEspectaculo);
				Critica.setVotantes(Votante);
				todasCriticas.add(Critica);
			}

			if (declaracion != null){ 
			
				declaracion.close(); 
			}

			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return todasCriticas;
	}
	
	/*
	 * Funcion que solicita informacion de las criticas de un usuario
	 * @param Correo 
	 * @return todasCriticas 
	 */
	
	public ArrayList<CriticaDTO> SolicitudTodasCriticasUsuario(String Correo){
	
		ArrayList<CriticaDTO> todasCriticas = new ArrayList<CriticaDTO>();
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
		
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarTodasCriticasUsuario");
			cuestion=cuestion.replaceAll("varcorreo", Correo);
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()) {
				
				String Titulo = resultado.getString("Titulo");
				float Puntuacion = resultado.getFloat("Puntuacion");
				String Resena = resultado.getString("Resena");
				int Id = resultado.getInt("Id");
				int Like = resultado.getInt("Like");
				int Dislike = resultado.getInt("Dislike");
				ArrayList<VotanteDTO> Votante = this.SolicitarVotantes(Id);
				int IdEspectaculo = Integer.parseInt(resultado.getString("IdEspectaculo"));
				
				CriticaDTO Critica = new CriticaDTO(Titulo,Puntuacion,Resena,Id,Correo,Like,Dislike, IdEspectaculo);
				Critica.setVotantes(Votante);
				todasCriticas.add(Critica);
			}

			if (declaracion != null){ 
				
				declaracion.close(); 
			}

			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return todasCriticas;
	}
	
	/*
	 * Funcion que solicita informacion de las critica menos las de un usuario introducido por correo
	 * @param Correo 
	 * @return todasCriticas 
	 */
	
	public ArrayList<CriticaDTO> SolicitarCriticasMenosUsuario(String Correo){
		
		ArrayList<CriticaDTO> todasCriticas = new ArrayList<CriticaDTO>();
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarTodasCriticasP"); 
			cuestion = cuestion.replace("varcorreo", Correo);
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
		
			while (resultado.next()) {
			
				String Titulo = resultado.getString("Titulo");
				float Puntuacion = resultado.getFloat("Puntuacion");
				String Resena = resultado.getString("Resena");
				int Id = resultado.getInt("Id");
				String CorreoA = resultado.getString("Correo");
				int Like = resultado.getInt("Like");
				int Dislike = resultado.getInt("Dislike");
				ArrayList<VotanteDTO> Votante = this.SolicitarVotantes(Id);
				int IdEspectaculo = Integer.parseInt(resultado.getString("IdEspectaculo"));
				CriticaDTO Critica = new CriticaDTO(Titulo,Puntuacion,Resena,Id,CorreoA,Like,Dislike, IdEspectaculo);
				Critica.setVotantes(Votante);
				todasCriticas.add(Critica);
			}
			if (declaracion != null){ 
			
				declaracion.close(); 
			}
			
			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return todasCriticas;
	}

	/*
	 * Funcion que solicita correos de usuarios que hayan escrito algo
	 * @return todosAutores
	 */
	
	public ArrayList<String> SolicitarAutores(){
		
		ArrayList<String> todosAutores = new ArrayList<String>();
		
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
	
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarAutores");
			
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()) {
				
				String autor = resultado.getString("Correo");
				todosAutores.add(autor);
			}
			if (declaracion != null){ 
				
				declaracion.close(); 
			}

			DBConexion.closeConnection();
		
		} catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		return todosAutores;
	}
	
	/*
	 * Funcion que solicita EspectaculosPuntuales acabados	
	 * @return esp
	 */
	
	public ArrayList<EspectaculoDTO> SolicitudEspectaculoPuntualCritica(){
		
		ArrayList<EspectaculoDTO> esp = new ArrayList<EspectaculoDTO>();
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarInfoEspectaculoPuntualP");
			cuestion = cuestion.replace("varfechahoy", LocalDateTime.now().toString());
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()) {
			
				int Id = resultado.getInt("Id");
				String Tipo = resultado.getString("Tipo");
				String Titulo = resultado.getString("Titulo");
				String Contenido = resultado.getString("Contenido");
				String LocTotales = resultado.getString("LocalidadesTotales");
				String LocVendidas = resultado.getString("LocalidadesVendidas");
				int LocalidadesTotales = Integer.parseInt(LocTotales);
				int LocalidadesVendidas = Integer.parseInt(LocVendidas);
				
				EspectaculoDTO EspectaculoPuntual = new EspectaculoDTO(Id,Titulo,Tipo,Contenido,LocalidadesTotales,LocalidadesVendidas);
				esp.add(EspectaculoPuntual);
			}

			if (declaracion != null){ 
			
				declaracion.close(); 
			}

			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		
		return esp;
	}

	/*
	 * Funcion que solicita EspectaculosPaseMultiple coc una fecha realizada como minimo
	 * @return esp 
	 */
	
	public ArrayList<EspectaculoDTO> SolicitudEspectaculoPaseMultipleCritica(){
		
		ArrayList<EspectaculoDTO> esp = new ArrayList<EspectaculoDTO>();
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
	
		try(InputStream InSt = new FileInputStream(RutaSQL)){
		
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarInfoEspectaculoPaseMultipleP");
			cuestion = cuestion.replace("varfechahoy", LocalDateTime.now().toString());
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()) {
				
				int Id = resultado.getInt("Id");
				String Tipo = resultado.getString("Tipo");
				String Titulo = resultado.getString("Titulo");
				String Contenido = resultado.getString("Contenido");
				String LocTotales = resultado.getString("LocalidadesTotales");
				String LocVendidas = resultado.getString("LocalidadesVendidas");
				int LocalidadesTotales = Integer.parseInt(LocTotales);
				int LocalidadesVendidas = Integer.parseInt(LocVendidas);
				
				EspectaculoDTO EspectaculoPaseMultiple = new EspectaculoDTO(Id,Titulo,Tipo,Contenido,LocalidadesTotales, LocalidadesVendidas);
				esp.add(EspectaculoPaseMultiple);
			}

			if (declaracion != null){ 
				declaracion.close(); 
			}

			DBConexion.closeConnection();
		} catch (Exception Excep){
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		
		return esp;
	}
	
	/*
	 * Funcion que devuelve los espectaculos Puntuales con al menos una fecha pasada
	 * @return esp Vector de Espectaculos 
	 * @author Developers
	 */
	
	public ArrayList<EspectaculoDTO> SolicitudEspectaculoTemporadaCritica(){
		ArrayList<EspectaculoDTO> esp = new ArrayList<EspectaculoDTO>();
		DBConexion DBConexion = new DBConexion();
		Connection conexion = DBConexion.getConnection();
		try(InputStream InSt = new FileInputStream(RutaSQL)){
			Properties propiedades = new Properties();
			propiedades.load(InSt);
			String cuestion = propiedades.getProperty("solicitarInfoEspectaculoTemporadaP");
			cuestion = cuestion.replace("varfechahoy", LocalDateTime.now().toString());
			Statement declaracion = conexion.createStatement();
			ResultSet resultado = (ResultSet) declaracion.executeQuery(cuestion);
			
			while (resultado.next()) {
				int Id = resultado.getInt("Id");
				String Tipo = resultado.getString("Tipo");
				String Titulo = resultado.getString("Titulo");
				String Contenido = resultado.getString("Contenido");
				String LocTotales = resultado.getString("LocalidadesTotales");
				String LocVendidas = resultado.getString("LocalidadesVendidas");
				int LocalidadesTotales = Integer.parseInt(LocTotales);
				int LocalidadesVendidas = Integer.parseInt(LocVendidas);
				
				EspectaculoDTO EspectaculoTemporada = new EspectaculoDTO(Id,Titulo,Tipo,Contenido,LocalidadesTotales, LocalidadesVendidas);
				esp.add(EspectaculoTemporada);
			}

			if (declaracion != null){ 
				
				declaracion.close(); 
			}

			DBConexion.closeConnection();
		} 
		catch (Exception Excep){
			
			System.err.println(Excep);
			Excep.printStackTrace();
		}
		
		return esp;
	}
}
