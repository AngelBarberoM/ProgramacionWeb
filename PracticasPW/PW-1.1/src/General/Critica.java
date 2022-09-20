package General;
import java.util.ArrayList;

import Criticas.FunCriticas;


public class Critica extends FunCriticas{
	
	/**
	 * Titulo del espectaculo
	*/
	private String Titulo; 

	/**
	 * Puntuacion del espectaculo
	*/
	private float Puntuacion; 

	/**
	 * Identificador del espectaculo
	*/
	private int Id;

	/**
	 * Resena del espectaculo
	*/
	private String Resena; 

	/**
	 * Numero de votos positivos 
	 * del espectaculo
	*/
	private int Like; 

	/**
	 * Numero de votos positivos 
	 * del espectaculo
	*/
	private int Dislike;
	
	/**
	 * Correo del usuario 
	 * que ha creado la critica
	*/
	private String Correo; 
	/**
	 * Vector de cadenas de texto 
	 * de los votantes
	*/
	private ArrayList<String> Votantes; 
	
	/**
	 * Objeto de la clase FunCriticas para llamar funciones
	*/
	private FunCriticas funcri = new FunCriticas(); 
	
	////CONSTRUCTOR PARAMETRIZADO
	
	/**
	 * Constructor parametrizado
	 * @param Titulo Titulo de la critica
	 * @param Puntuacion Puntuacion de la critica
	 * @param Resena Resena de la critica
	 * @param Like Like de la critica
	 * @param Dislike Like de la critica
	 * @param Id Identificador de la critica
	 * @param Votantes Votantes de la critica
	*/
	public Critica(String Titulo, float Puntuacion, String Resena){
		
		this.Titulo = Titulo; 
		this.Puntuacion = Puntuacion; 
		this.Resena=Resena; 
		this.Like = 0; 
		this.Dislike =0;
		this.Id = funcri.GenerarId();  
		this.Votantes= new ArrayList<String>(); 
	}
	
	/**
	 * Constructor sin parametros.
	*/
	public Critica() {}

	
	//OBSERVADORES
	
	/**
	 * Get del Titulo.
	 * @return Titulo 
	 */
	public String getTitulo(){
		
		return this.Titulo; 
	}

	/**
	 * Get del Correo.
	 * @return Correo 
	 */
	public String getCorreo(){
		
		return this.Correo;
	}

	/**
	 * Get de la Puntuacio.
	 * @return Puntuacion 
	 */
	public float getPuntuacion(){
		
		return this.Puntuacion; 
	}

	/**
	 * Get de la Resena.
	 * @return Resena 
	 */
	public String getResena(){
		
		return this.Resena; 
	}

	/**
	 * Get del Like.
	 * @return Like 
	 */
	public int getLike(){
		
		return this.Like; 
	}

	/**
	 * Get del Dislike.
	 * @return Dislike 
	 */
	public int getDislike(){
		
		return this.Dislike; 
	}

	/**
	 * Get del Identificador.
	 * @return Id 
	 */
	public int getId(){
		
		return this.Id; 
	}

	/**
	 * Get de los votantes.
	 * @return Votantes 
	 */
	public ArrayList<String> getVotantes(){
		
		return this.Votantes; 
	}
	
	//MODIFICADORES	 

	/**
	 * Set del Titulo.
	 * @param Titulo 
	 */
	public void setTitulo(String Titulo){
		
		this.Titulo = Titulo; 
	}

	/**
	 * Set del Correo.
	 * @param Correo 
	 */
	public void setCorreo(String Correo){
		
		this.Correo=Correo;
	}

	/**
	 * Set de la Puntuacion.
	 * @param Puntuacion 
	 */
	public void setPuntuacion(float Puntuacion){
			
		this.Puntuacion=Puntuacion; 
	}

	/**
	 * Set de la Resena.
	 * @param Resena 
	 */
	public void setResena(String Resena){
		
		this.Resena=Resena; 
	}

	/**
	 * Set del Like.
	 * @param Like 
	 */
	public void setLike(int Like){
		
		this.Like = Like; 
	}

	/**
	 * Set del Disike.
	 * @param Dislike 
	 */
	public void setDislike(int Dislike){
		
		this.Dislike = Dislike; 
	}
	
	//INCREMENTAR Likes
	/**
	 * Metodo para incrementar likes
	 */
	public void addLike(){
		
		this.Like ++; 
	}
	
	//DECREMENTAR Likes
	/**
	 * Metodo para incrementar dislikes
	 */
	public void addDislike(){
		
		this.Dislike ++; 
	}
	
	/**
	 * Set del Id.
	 * @param Id 
	 */
	public void setId(int Id){
		
		this.Id=Id; 
	}
	
	/**
	 * Set de los Votantes.
	 * @param Votantes 
	 */
	public void setVotantes(ArrayList<String> Votantes){
		
		this.Votantes = Votantes; 
	}
	
}