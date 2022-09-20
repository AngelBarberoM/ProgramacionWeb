package CEU_MG;
import java.util.ArrayList;

import GeneralDAO.CriticaDAO;
import General_DTO.CriticaDTO;
import General_DTO.EspectaculoDTO;
import General_DTO.VotanteDTO;
	
/*
 * Llamadas a CriticasDAO para poder utilizarlo
 */
public class CriticaMG {
	
	
	private String Correo;
	
	//MODIFICADORES
	
	public CriticaMG(String Correo) {
		
		this.Correo = Correo;
	}
	
	private String getCorreo() {
		
		return this.Correo;
	}
	
	
	/* Mostrar los espectaculos del DAO
	 * @return espectaculo
	 */
	public ArrayList<EspectaculoDTO> SolicitudEspectaculoPuntualCritica(){
		
		ArrayList<EspectaculoDTO> espectaculo = new ArrayList<EspectaculoDTO>();
		CriticaDAO SolicitudEspectaculo = new CriticaDAO();
		espectaculo = SolicitudEspectaculo.SolicitudEspectaculoPuntualCritica();
		
		return espectaculo;
	}
	
	
	/* Mostrar los espectaculos del DAO
	 * @return espectaculo Vector
	 */
	public ArrayList<EspectaculoDTO> SolicitudEspectaculoPaseMultipleCritica(){
		
		ArrayList<EspectaculoDTO> espectaculo = new ArrayList<EspectaculoDTO>();
		CriticaDAO SolicitudEspectaculo = new CriticaDAO();
		espectaculo = SolicitudEspectaculo.SolicitudEspectaculoPaseMultipleCritica();
		
		return espectaculo;
	}
	
	
	/* Mostrar los espectaculos del DAO
	 * @return espectaculo Vector
	 */
	public ArrayList<EspectaculoDTO> SolicitudEspectaculoTemporadaCritica(){
	
		ArrayList<EspectaculoDTO> espectaculo = new ArrayList<EspectaculoDTO>();
		CriticaDAO SolicitudEspectaculo = new CriticaDAO();
		espectaculo = SolicitudEspectaculo.SolicitudEspectaculoTemporadaCritica();
		
		return espectaculo;
	}
	
	
	/*Funcion que crea una critica y pasa los datos al DAO
	 * @param Titulo Titulo de la critica
	 * @param Puntuacion Puntuacion otorgada al espectaculo
	 * @param Resena Resena del espectaculo
	 * @param IdEspectaculo ID del espectaculo
	 * @return true
	 */
	public Boolean CrearCritica(String Titulo, float Puntuacion, String Resena,int IdEspectaculo) {
		
		CriticaDAO CriticaNueva = new CriticaDAO();
		
		CriticaDTO CriticaNuevaDTO = new CriticaDTO(Titulo,Puntuacion,Resena,this.getCorreo(), IdEspectaculo);  
		CriticaNueva.CrearCritica(CriticaNuevaDTO);	
	
		return true;
	}
	
	
	/* Funcion que pasa el ID de una critica al DAO para eliminarla
	 * @param Id Identificador de la critica
	 * @return true / false
	 */
	public Boolean EliminarCritica(int Id) {
		
		if(this.ExisteCritica(Id)) {
			
			CriticaDTO critica = this.SolicitarCritica(Id);
			
			if(critica.getCorreo().equals(this.getCorreo())) {
			
				CriticaDAO EliminarCritica = new CriticaDAO();
				EliminarCritica.EliminarCritica(Id);
				EliminarCritica.EliminarVotantesCritica(Id);
				
				return true;				
			}
		}	
		return false;
	}
	
	
	/* Funcion que pasa el ID de una critica al DAO para mostrar informacion
	 * @param Id Identificador de la critica
	 * @return CriticaSolicitada critica solicitada
	 */
	public CriticaDTO SolicitarCritica(int Id) {
		
		CriticaDAO SolicitarCritica = new CriticaDAO();
		CriticaDTO CriticaSolicitada = new CriticaDTO();
		CriticaSolicitada = SolicitarCritica.SolicitarCritica(Id);
		
		return CriticaSolicitada;
	}
	
	
	/* Funcion que pide todas las criticas
	 * @return CriticasSolicitadas
	 */
	public ArrayList<CriticaDTO> SolicitarCriticasInfo(){
		
		CriticaDAO SolicitarCritica = new CriticaDAO();
		ArrayList<CriticaDTO> CriticasSolicitadas = new ArrayList<CriticaDTO>();
		CriticasSolicitadas = SolicitarCritica.SolicitarCriticasInfo();
		
		return CriticasSolicitadas;
	}
	
	/* Funcion que pide todas las criticas por un usuario
	 * @param Correo Correo del usuario
	 * @return CriticasSolicitadas Vector de criticas solicitadas
	 */
	public ArrayList<CriticaDTO> SolicitudTodasCriticasUsuario(String Correo){
		
		CriticaDAO SolicitarCritica = new CriticaDAO();
		ArrayList<CriticaDTO> CriticasSolicitadas = new ArrayList<CriticaDTO>();
		CriticasSolicitadas = SolicitarCritica.SolicitudTodasCriticasUsuario(Correo); 
		
		return CriticasSolicitadas;
	}
	
	/* Funcion que pide todas las criticas almacenadas menos las que ha hecho un usuario
	 * @return CriticasSolicitadas Vector de criticas solicitadas
	 */
	public ArrayList<CriticaDTO> SolicitarCriticasMenosUsuario(){
		
		CriticaDAO SolicitarCritica = new CriticaDAO();
		ArrayList<CriticaDTO> CriticasSolicitadas = new ArrayList<CriticaDTO>();
		CriticasSolicitadas = SolicitarCritica.SolicitarCriticasMenosUsuario(this.getCorreo());
	
		return CriticasSolicitadas;
	}
	
	/* Funcion que comprueba si existe una critica con Id
	 * @param Id Identificador de la critica
	 * @return true / false
	 */
	
	public Boolean ExisteCritica(int Id) {
		
		ArrayList<CriticaDTO> Criticas = this.SolicitarCriticasInfo();
		
		for(CriticaDTO i : Criticas) {
			
			if(i.getId() == Id) {
				
				return true;
			}
		}
		return false;	
	}
	
	/* Funcion que aumenta los Likes
	 * @param Id ID de la critica
	 * @return true / false
	 */
	
	public Boolean sumarLike(int Id) {
		
		if(this.ExisteCritica(Id)) {
			
			CriticaDTO critica = this.SolicitarCritica(Id);
			CriticaDAO Like = new CriticaDAO();
			
			if(!this.getCorreo().equals(critica.getCorreo())) {
				
				for(VotanteDTO i : critica.getVotantes()) {
					
					if(i.getPersonaVota().equals(this.getCorreo())) {
						
						if(i.getVotoPersona().equals("like")) {
							
							return false;
						}
						else {
							
							critica.RestarDislike();
							critica.SumarLike();
							Like.ActualizarCritica(critica);
							Like.EliminarVotanteCritica(this.getCorreo(), Id);
							Like.AnadirVotanteVotoCritica(this.getCorreo(), Id, "like");
							
							return true;	
						}
					}
				}
				critica.SumarLike();
				Like.ActualizarCritica(critica);
				Like.EliminarVotanteCritica(this.getCorreo(), Id);
				Like.AnadirVotanteVotoCritica(this.getCorreo(), Id, "like");
				
				return true;
			}				
		}	
		return false;
	}
	
	
	/* Funcion que aumenta los dislikes
	 * @param Id ID de la critica
	 * @return true / false
	 */
	public Boolean sumarDislike(int Id) {
		
		if(this.ExisteCritica(Id)) {
			
			CriticaDAO Dislike = new CriticaDAO();
			CriticaDTO critica = this.SolicitarCritica(Id);
			
			if(!this.getCorreo().equals(critica.getCorreo())) {
			
				for(VotanteDTO i : critica.getVotantes()) {
				
					if(i.getPersonaVota().equals(this.getCorreo())) {
						
						if(i.getVotoPersona().equals("dislike")) {
							
							return false;
					}
					else {
					
						critica.RestarLike();
						critica.SumarDislike();
						Dislike.ActualizarCritica(critica);
						Dislike.EliminarVotanteCritica(this.getCorreo(), Id);
						Dislike.AnadirVotanteVotoCritica(this.getCorreo(), Id, "dislike");
					
						return true; 
							
					}
				}

				critica.SumarDislike();}
				Dislike.ActualizarCritica(critica);
				Dislike.EliminarVotanteCritica(this.getCorreo(), Id);
				Dislike.AnadirVotanteVotoCritica(this.getCorreo(), Id, "dislike");
				
				return true;	
			}				
		}	
		return false;	
	}
	
	/* Funcion que selecciona el Titulo a partir Id
	 * @param Id ID del espectaculo
	 * @return Titulo
	 */
	public String SeleccionarTituloEspectaculo(int Id) {
		
		CriticaDAO seleccionarTituloEspectaculo = new CriticaDAO();
		String Titulo = seleccionarTituloEspectaculo.SeleccionarTituloEspectaculo(Id);
		
		return Titulo;
	}
	
	
	/* Funcion que solicita los correos de los usuarios que tienen una critica
	 * @return AutoresSolicitados Vector con los mails de los usuarios
	 */
	public ArrayList<String> SolicitarAutores(){
		CriticaDAO solicitudC = new CriticaDAO();
		ArrayList<String> AutoresSolicitados = new ArrayList<String>();
		AutoresSolicitados = solicitudC.SolicitarAutores();
		
		return AutoresSolicitados;
	}
}
