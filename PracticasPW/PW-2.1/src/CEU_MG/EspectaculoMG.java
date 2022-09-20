package CEU_MG;
import java.time.LocalDateTime;
import java.util.ArrayList;

import GeneralDAO.EspectaculoDAO;
import General_DTO.EspectaculoPaseMultipleDTO;
import General_DTO.EspectaculoPuntualDTO;
import General_DTO.EspectaculoTemporadaDTO;
import General_DTO.FechaDTO;
import General_DTO.PaseDTO;

/*
 * Llamadas a EspectaculoDAO para poder utilizarlo
 */
public class EspectaculoMG {

	/* Funcion que existe el ID de un espectaculo puntual
	 * @param Id Identificador del espectaculo
	 * @return true / false
	 */
	public Boolean ExisteEspectaculoPuntual(int Id) {
		ArrayList<EspectaculoPuntualDTO> espectaculoPuntual = this.SolicitarEspectaculoPuntualInfo();
		
		for(EspectaculoPuntualDTO i : espectaculoPuntual) {
			
			if(i.getId() == Id) {
				
				return true;
			}
		}
		return false;	
	}
	
	
	/* Funcion que existe el ID de un espectaculo pase multiple
	 * @param Id Identificador del espectaculo
	 * @return true / false
	 */
	public Boolean ExisteEspectaculoPaseMultiple(int Id) {
		
		ArrayList<EspectaculoPaseMultipleDTO> espectaculoPaseMultiple = this.SolicitarEspectaculoPaseMultipleInfo();
		
		for(EspectaculoPaseMultipleDTO i : espectaculoPaseMultiple) {
			
			if(i.getId() == Id) {
				
				return true;
			}
		}
		return false;	
	}
	
	
	/* Funcion que existe el ID de un espectaculo temporada
	 * @param Id Identificador del espectaculo
	 * @return true / false
	 */
	public Boolean ExisteEspectaculoTemporada(int Id) {
		
		ArrayList<EspectaculoTemporadaDTO> Criticas = this.SolicitarEspectaculoTemporadaInfo();
		
		for(EspectaculoTemporadaDTO i : Criticas) {
		
			if(i.getId() == Id){
				
				return true;
			}
		}
		return false;	
	}
	
	
	/* Funcion que comprueba si existe un ID de un pase
	 * @param Id Identificador
	 * @return true / false
	 */
	public Boolean ExistePase(int Id) {
		
		ArrayList<PaseDTO> Pases = this.SolicitarPases();
	
		for(PaseDTO i : Pases) {

			if(i.getId() == Id){
				
				return true;
			}
		}
		return false;	
	}
	
	
	/* Funcion que comprueba si existe un ID de una Fecha
	 * @param Id Identificador
	 * @return true / false
	 */	
	public Boolean ExisteFecha(int Id) {
		
		ArrayList<FechaDTO> Fechas = this.SolicitarFechas();
		
		for(FechaDTO i : Fechas) {
		
			if(i.getId() == Id){
				
				return true;
			}
		}
		return false;	
	}
	
	
	/* Funcion que genera un ID para espectaculo puntual
	 * @return Id 
	 */
	public int GenerarIdEspectaculoPuntual(){
		
		EspectaculoDAO EspecPunt = new EspectaculoDAO();
		int Id = EspecPunt.GenerarIdEspectaculoPuntual();
		
		return Id;
	}
	
	
	/* Funcion que genera un ID para espectaculo pase multiple
	 * @return Id 
	 */
	public int GenerarIdEspectaculoPaseMultiple(){
		
		EspectaculoDAO EspecPunt = new EspectaculoDAO();
		int Id = EspecPunt.GenerarIdEspectaculoPaseMultiple();
		
		return Id;
	}
	
	
	/* Funcion que genera un ID para espectaculo temporada
	 * @return Id 
	 */
	public int GenerarIdEspectaculoTemporada(){
		
		EspectaculoDAO EspecPunt = new EspectaculoDAO();
		int Id = EspecPunt.GenerarIdEspectaculoTemporada();
		
		return Id;
	}
	
	
	/* Funcion que genera un ID para una Fecha
	 * @return Id 
	 */
	public int GenerarIdFecha(){
		
		EspectaculoDAO EspecPunt = new EspectaculoDAO();
		int Id = EspecPunt.GenerarIdFechas();
		
		return Id;
	}
	
	
	/* Funcion que genera un ID para un pase
	 * @return Id 
	 */
	public int generarIDPases(){
		
		EspectaculoDAO EspecPunt = new EspectaculoDAO();
		int Id = EspecPunt.generarIdPases();
		
		return Id;
	}
	
	
	/* Funcion que crea un nuevo Espectaculo Puntual
	 * @param Id ID 
	 * @param Titulo Titulo 
	 * @param Categoria Categoria 
	 * @param LocalidadesTotales 
	 * @param LocalidadesVendidas 
	 * @param Fecha 
	 * @return true / false
	 */
	public Boolean CrearEspectaculoPuntual(int Id, String Titulo, String Tipo,String Contenido, int LocalidadesTotales, int LocalidadesVendidas,LocalDateTime Fecha) {
		
		EspectaculoDAO nuevoPunteroDAO = new EspectaculoDAO();
		
		if(!this.ExisteEspectaculoPuntual(Id)){
			
			EspectaculoPuntualDTO nuevoPunteroDTO = new EspectaculoPuntualDTO(Id, Titulo, Tipo, Contenido, LocalidadesTotales, LocalidadesVendidas, Fecha);
			nuevoPunteroDAO.CrearEspectaculoPuntual(nuevoPunteroDTO);
			
			return true;
		}
		return false;
	}
	
	
	/* Funcion que actualiza un Espectaculo Puntual
	 * @param Id ID 
	 * @param Titulo Titulo 
	 * @param Categoria Categoria 
	 * @param LocalidadesTotales 
	 * @param LocalidadesVendidas 
	 * @param Fecha 
	 * @return true / false
	 */
	public Boolean ActualizarEspectaculoPuntual(int Id, String Titulo, String Tipo,String Contenido, int LocalidadesTotales, int LocalidadesVendidas,LocalDateTime Fecha) {
			
		if(this.ExisteEspectaculoPuntual(Id)){
			
			EspectaculoDAO nuevoEspectaculo = new EspectaculoDAO();			
			EspectaculoPuntualDTO nuevoPunteroDTO = new EspectaculoPuntualDTO(Id, Titulo, Tipo, Contenido, LocalidadesTotales, LocalidadesVendidas, Fecha);  
			nuevoEspectaculo.ActualizarEspectaculoPuntual(nuevoPunteroDTO);
			
			return true;		
		}
		return false;
	}
	
	
	/* Funcion  que elimina un Espectualo Puntual por ID
	 * @param Id 
	 * @return true / false
	 */
	public Boolean EliminarEspectaculoPuntual(int Id) {
		
		if(this.ExisteEspectaculoPuntual(Id)) {
			
			EspectaculoDAO PunteroEliminar = new EspectaculoDAO();
			PunteroEliminar.EliminarEspectaculoPuntual(Id);
			
			return true;				
		}	
		return false;
	}
	
	
	/* Funcion que devuelve un Espectaculo Puntual por ID
	 * @param Id 
	 * @return PunteroSolicitado datos del espectaculo
	 */
	public EspectaculoPuntualDTO SolicitarEspectaculoPuntual(int Id){
		
		EspectaculoDAO PunteroSolicitar = new EspectaculoDAO();
		EspectaculoPuntualDTO PunteroSolicitado = new EspectaculoPuntualDTO();
		PunteroSolicitado = PunteroSolicitar.SolicitarEspectaculoPuntual(Id);
		
		return PunteroSolicitado;
	}
	
	
	/* Funcion que devuelve todos los Espectaculos puntuales
	 * @return PunteroSolicitado Vector con informacion
	 */
	public ArrayList<EspectaculoPuntualDTO> SolicitarEspectaculoPuntualInfo(){
		
		EspectaculoDAO PunteroSolicitar = new EspectaculoDAO();
		ArrayList<EspectaculoPuntualDTO> PunteroSolicitado = new ArrayList<EspectaculoPuntualDTO>();
		PunteroSolicitado = PunteroSolicitar.SolicitarEspectaculoPuntualInfo();
		
		return PunteroSolicitado;
	}
	
	
	/* Funcion que crea un nuevo Espectaculo Pase Multiple
	 * @param Id ID 
	 * @param Titulo Titulo 
	 * @param Categoria Categoria 
	 * @param LocalidadesTotales 
	 * @param LocalidadesVendidas 
	 * @param Fecha 
	 * @return true / false
	 */
	public Boolean CrearEspectaculoPaseMultiple(int Id, String Titulo, String Tipo,String Contenido, int LocalidadesTotales, int LocalidadesVendidas, ArrayList<FechaDTO> Fechas) {
		
		EspectaculoDAO nuevoPunteroDAO = new EspectaculoDAO();
		
		if(!this.ExisteEspectaculoPaseMultiple(Id)){
			
			EspectaculoPaseMultipleDTO nuevoPunteroDTO = new EspectaculoPaseMultipleDTO(Id, Titulo, Tipo, Contenido, LocalidadesTotales, LocalidadesVendidas, Fechas);  
			nuevoPunteroDAO.CrearEspectaculoPaseMultiple(nuevoPunteroDTO);	
		
			return true;
		}
		return false;
	}
	
	
	/* Funcion que actualiza un Espectaculo Pase Multiple
	 * @param Id ID 
	 * @param Titulo Titulo 
	 * @param Categoria Categoria 
	 * @param LocalidadesTotales 
	 * @param LocalidadesVendidas 
	 * @param Fecha 
	 * @return true / false
	 */	
	public Boolean ActualizarEspectaculoPaseMultiple(int Id, String Titulo, String Tipo,String Contenido, int LocalidadesTotales, int LocalidadesVendidas,ArrayList<FechaDTO> Fechas) {
			
		if(this.ExisteEspectaculoPaseMultiple(Id)){
				
				EspectaculoDAO nuevoEspectaculo = new EspectaculoDAO();			
				EspectaculoPaseMultipleDTO nuevoPunteroDTO = new EspectaculoPaseMultipleDTO(Id, Titulo, Tipo, Contenido, LocalidadesTotales, LocalidadesVendidas, Fechas);  
				nuevoEspectaculo.ActualizarEspectaculoPaseMultiple(nuevoPunteroDTO);
				
				return true;		
		}
		return false;
	}
	
	
	/* Funcion  que elimina un Espectualo Pase Multiple por ID
	 * @param Id 
	 * @return true / false
	 */
	public Boolean EliminarEspectaculoPaseMultiple(int Id) {
	
		if(this.ExisteEspectaculoPaseMultiple(Id)) {
			EspectaculoDAO PunteroEliminar = new EspectaculoDAO();
			PunteroEliminar.EliminarEspectaculoPaseMultiple(Id);
			
			return true;				
		}	
		return false;
	}
	
	
	/* Funcion que devuelve un Espectaculo Pase Multiple por ID
	 * @param Id 
	 * @return PunteroSolicitado datos del espectaculo
	 */
	public EspectaculoPaseMultipleDTO SolicitarEspectaculoPaseMultiple(int Id){
		
		EspectaculoDAO PunteroSolicitar = new EspectaculoDAO();
		EspectaculoPaseMultipleDTO PunteroSolicitado = new EspectaculoPaseMultipleDTO();
		PunteroSolicitado = PunteroSolicitar.SolicitarEspectaculoPaseMultiple(Id);
		
		return PunteroSolicitado;
	}
	
	
	/* Funcion que devuelve todos los Espectaculos puntuales
	 * @return PunteroSolicitado Vector con informacion
	 */
	public ArrayList<EspectaculoPaseMultipleDTO> SolicitarEspectaculoPaseMultipleInfo(){
		
		EspectaculoDAO PunteroSolicitar = new EspectaculoDAO();
		ArrayList<EspectaculoPaseMultipleDTO> PunteroSolicitado = new ArrayList<EspectaculoPaseMultipleDTO>();
		PunteroSolicitado = PunteroSolicitar.SolicitarEspectaculoPaseMultipleInfo();
		
		return PunteroSolicitado;
	}
	
	
	/* Funcion que devuelve todas las Fechas
	 * @return FechasSolicitadas Vector con informacion de fechas
	 */
	public ArrayList<FechaDTO> SolicitarFechas(){
		
		EspectaculoDAO SolicitarFechas = new EspectaculoDAO();
		ArrayList<FechaDTO> FechasSolicitadas = new ArrayList<FechaDTO>();
		FechasSolicitadas = SolicitarFechas.SolicitarFechas();
		
		return FechasSolicitadas;
	}
	
	
	/* Funcion que devuelve todos los pases
	 * @return PasesSolicitados Vector con informacion de pases
	 */
	public ArrayList<PaseDTO> SolicitarPases(){
		
		EspectaculoDAO SolicitarPases = new EspectaculoDAO();
		ArrayList<PaseDTO> PasesSolicitados = new ArrayList<PaseDTO>();
		PasesSolicitados = SolicitarPases.SolicitarPases();
		
		return PasesSolicitados;
	}
	
	
	/* Funcion que crea un nuevo Espectaculo Pase Multiple
	 * @param Id ID 
	 * @param Titulo Titulo 
	 * @param Categoria Categoria 
	 * @param LocalidadesTotales 
	 * @param LocalidadesVendidas 
	 * @param Fecha 
	 * @return true / false
	 */
	public Boolean CrearEspectaculoTemporada(int Id, String Titulo, String Tipo,String Contenido, int LocalidadesTotales, int LocalidadesVendidas,ArrayList<PaseDTO> Pases) {
		
		EspectaculoDAO nuevoPunteroDAO = new EspectaculoDAO();
		EspectaculoTemporadaDTO nuevoPunteroDTO = new EspectaculoTemporadaDTO(Id, Titulo, Tipo, Contenido, LocalidadesTotales, LocalidadesVendidas,Pases);  
		nuevoPunteroDAO.CrearEspectaculoTemporada(nuevoPunteroDTO);	
		
		return true;
	}
	
	/* Funcion que actualiza un Espectaculo Pase Multiple
	 * @param Id ID 
	 * @param Titulo Titulo 
	 * @param Categoria Categoria 
	 * @param LocalidadesTotales 
	 * @param LocalidadesVendidas 
	 * @param Fecha 
	 * @return true / false
	 */	
	public Boolean ActualizarEspectaculoTemporada(int Id, String Titulo, String Tipo,String Contenido, int LocalidadesTotales, int LocalidadesVendidas,ArrayList<PaseDTO> Pases) {
		
		if(this.ExisteEspectaculoTemporada(Id)) {
			
			EspectaculoDAO nuevoEspectaculo = new EspectaculoDAO();			
			EspectaculoTemporadaDTO nuevoPunteroDTO = new EspectaculoTemporadaDTO(Id, Titulo, Tipo, Contenido, LocalidadesTotales, LocalidadesVendidas, Pases);  
			nuevoEspectaculo.ActualizarEspectaculoTemporada(nuevoPunteroDTO);
		
			return true;		
		}
		return false;
	}
	
	/* Funcion  que elimina un Espectualo Temporada por ID
	 * @param Id 
	 * @return true / false
	 */
	public Boolean EliminarEspectaculoTemporada(int Id) {
		
		if(this.ExisteEspectaculoTemporada(Id)){
			
			EspectaculoDAO PunteroEliminar = new EspectaculoDAO();
			PunteroEliminar.EliminarEspectaculoTemporada(Id);
			
			return true;				
		}	
		return false;
	}
	
	
	/* Funcion que devuelve un Espectaculo Pase Multiple por ID
	 * @param Id 
	 * @return PunteroSolicitado datos del espectaculo
	 */
	public EspectaculoTemporadaDTO SolicitarEspectaculoTemporada(int Id){
		
		EspectaculoDAO PunteroSolicitar = new EspectaculoDAO();
		EspectaculoTemporadaDTO PunteroSolicitado = new EspectaculoTemporadaDTO();
		PunteroSolicitado = PunteroSolicitar.SolicitarEspectaculoTemporada(Id);
		
		return PunteroSolicitado;
	}
	

	/* Funcion que devuelve todos los Espectaculos puntuales
	 * @return PunteroSolicitado Vector con informacion
	 */
	public ArrayList<EspectaculoTemporadaDTO> SolicitarEspectaculoTemporadaInfo(){
		
		EspectaculoDAO PunteroSolicitar = new EspectaculoDAO();
		ArrayList<EspectaculoTemporadaDTO> PunteroSolicitado = new ArrayList<EspectaculoTemporadaDTO>();
		PunteroSolicitado = PunteroSolicitar.SolicitarEspectaculoTemporadaInfo();
		
		return PunteroSolicitado;
	}
	
	
	/* Funcion que comprueba si un Espectaculo Pase Multiple tiene fecha
	 * @param EPM espectaculo a comprobar
	 * @return true / false
	 */
	public boolean sesionTerminadaMult(EspectaculoPaseMultipleDTO EPM){
		
		for(int i=0; i<EPM.getFecha().size(); i++){
			
			if(EPM.getFecha().get(i).getFecha().isBefore(LocalDateTime.now())){
				
				return true; 
			}
		}
		return false; 
	}
	

	
	/* Funcion que comprueba si un Espectaculo Temporada tiene pase
	 * @param ET espectaculo a comprobar
	 * @return true / false
	 */
	public boolean sesionTerminadaTemp(EspectaculoTemporadaDTO ET){
		
		for(int i=0; i<ET.getPase().size(); i++){
			
			if(ET.getPase().get(i).getInicioFecha().isBefore(LocalDateTime.now())){
				
				return true; 
			}
		}
		return false; 
	}
	
	/* Funcion que crea una nueva Fecha de un Espectaculo Pase Multiple
	 * @param Id 
	 * @param Fecha 
	 * @para IdEspectaculo 
	 * @return true / false
	 */
	public Boolean CrearFecha(int Id, LocalDateTime Fecha, int IdEspectaculo){
		
		EspectaculoDAO nuevoPunteroDAO = new EspectaculoDAO();
		
		if(!this.ExisteEspectaculoPaseMultiple(IdEspectaculo)){
			
			FechaDTO NuevaFecha = new FechaDTO(Id, Fecha);
			nuevoPunteroDAO.CrearFecha(NuevaFecha, IdEspectaculo);
			
			return true;
		}
		return false;
	}
	
	
	/* Funcion que crea un nuevo pase de un Espectaculo Temporada
	 * @param Id
	 * @param InicioFecha 
	 * @param Dia 
	 * @param FinalFecha
	 * @para IdEspectaculo 
	 * @return true / false
	 */
	public Boolean CrearPase(int Id, LocalDateTime InicioFecha, String Dia, LocalDateTime FinalFecha, int IdEspectaculo){
		
		EspectaculoDAO nuevoPunteroDAO = new EspectaculoDAO();
		
		if(!this.ExisteEspectaculoTemporada(IdEspectaculo)){
			
			PaseDTO NuevoPase = new PaseDTO(Id, InicioFecha, Dia, FinalFecha);
			nuevoPunteroDAO.CrearPase(NuevoPase, IdEspectaculo);
			return true;
		}
		return false;
	}
	
	
	/* Funcion que obtiene fecha por ID
	 * @param Id
	 * @return FechaSolicitada 
	 */
	public FechaDTO SolicitarFecha(int Id){
		
		EspectaculoDAO SolicitarFecha = new EspectaculoDAO();
		FechaDTO FechaSolicitada = new FechaDTO();
		FechaSolicitada = SolicitarFecha.SolicitarFecha(Id);
		
		return FechaSolicitada;
	}
	
	
	/* Funcion que obtiene un pase por ID
	 * @param Id 
	 * @return PaseSolicitado
	 */
	public PaseDTO SolicitarPase(int Id){
		
		EspectaculoDAO SolicitarPase = new EspectaculoDAO();
		PaseDTO PaseSolicitado = new PaseDTO();
		PaseSolicitado = SolicitarPase.SolicitarPase(Id);
	
		return PaseSolicitado;
	}
	
	
	/* Funcion que actualiza una Fecha
	 * @param Id 
	 * @param Fecha
	 * @param IdEspectaculo 
	 * @return true / false
	 */
	public Boolean ActualizarFechas(int Id, LocalDateTime Fechas, int IdEspectaculo) {
		
		if(this.ExisteFecha(Id)){
			
			EspectaculoDAO nuevoEspectaculo = new EspectaculoDAO();			
			FechaDTO NuevasFechasDTO = new FechaDTO(Id, Fechas);  
			nuevoEspectaculo.ActualizarFecha(NuevasFechasDTO, IdEspectaculo);
			
			return true;		
		}
		return false;
	}
	
	
	/* Funcion que actualiza un pase
	 * @param Id 
	 * @param InicioFecha 
	 * @param Dia 
	 * @param FinalFecha 
	 * @param IdEspectaculo
	 * @return true / false
	 */
	public Boolean ActualizarPases(int Id, LocalDateTime InicioFecha, String Dia, LocalDateTime FinalFecha, int IdEspectaculo) {
		
		if(this.ExisteFecha(Id)){
			
			EspectaculoDAO nuevoEspectaculo = new EspectaculoDAO();			
			PaseDTO NuevosPasesDTO = new PaseDTO(Id, InicioFecha, Dia, FinalFecha);  
			nuevoEspectaculo.ActualizarPase(NuevosPasesDTO, IdEspectaculo);
			
			return true;		
		}
		return false;
	}
}
