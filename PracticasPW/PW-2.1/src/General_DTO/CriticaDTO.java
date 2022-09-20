package General_DTO;
import java.util.ArrayList;

public class CriticaDTO {

	//VARIABLES
	
	private String Titulo; 
	
	private float Puntuacion; 
	
	private int Id;
	
	private String Resena; 
	
	private int Like; 
	
	private int Dislike;

	private String Correo; 
	
	private ArrayList<VotanteDTO> Votantes; 

	private int IdEspectaculo; 


	
	//CONSTRUCTOR VACIO
	
	public CriticaDTO() {}
	
	
	//CONSTRUCTORES PARAMETRIZADOS
	
	public CriticaDTO(String Titulo, float Puntuacion, String Resena,String Correo, int IdEspectaculo){
		
		this.Titulo = Titulo; 
		this.Correo = Correo;
		this.Puntuacion = Puntuacion; 
		this.Resena=Resena; 
		this.Id = 0;
		this.Like = 0; 
		this.Dislike = 0;
		this.IdEspectaculo = IdEspectaculo;
		this.Votantes= new ArrayList<VotanteDTO>(); 
	}
	
	public CriticaDTO(String Titulo, float Puntuacion, String Resena, int Id, String Correo, int Like, int Dislike, int IdEspectaculo){
		
		this.Titulo = Titulo; 
		this.Correo = Correo;
		this.Puntuacion = Puntuacion; 
		this.Resena=Resena; 
		this.Id = Id;
		this.Like = Like; 
		this.Dislike = Dislike;
		this.IdEspectaculo = IdEspectaculo;
		this.Votantes= new ArrayList<VotanteDTO>(); 
	}

	
	//OBSERVADORES
	
	public String getTitulo(){
		
		return this.Titulo; 
	}

	
	public String getCorreo(){
		
		return this.Correo;
	}


	public float getPuntuacion(){
		
		return this.Puntuacion; 
	}

	
	public String getResena(){
		
		return this.Resena; 
	}
	

	public int getLike(){
		
		return this.Like; 
	}


	public int getDislike(){
		
		return this.Dislike; 
	}

	
	public int getId(){
		
		return this.Id; 
	}

	
	public ArrayList<VotanteDTO> getVotantes(){
		
		return this.Votantes; 
	}
	
	public int getIdEspectaculo(){
		
		return this.IdEspectaculo; 
	}
	
	
	//MODIFICADORES	 

	public void setTitulo(String Titulo){
		
		this.Titulo = Titulo; 
	}

	
	public void setCorreo(String Correo){
		
		this.Correo=Correo;
	}

	
	public void setPuntuacion(float Puntuacion){
			
		this.Puntuacion=Puntuacion; 
	}

	
	public void setResena(String Resena){
		
		this.Resena=Resena; 
	}

	
	public void setLike(int Like){
		
		this.Like = Like; 
	}

	
	public void setDislike(int Dislike){
		
		this.Dislike = Dislike; 
	}
	
	
	public void SumarLike(){
		
		this.Like ++; 
	}
	
	
	public void SumarDislike(){
		
		this.Dislike ++; 
	}
	
	
	public void RestarLike(){
		
		this.Like--;
	}
	
	
	public void RestarDislike(){
		
		this.Dislike--;
	}
	
	
	public void setId(int Id){
		
		this.Id=Id; 
	}
	

	public void setVotantes(ArrayList<VotanteDTO> Votantes){
		
		this.Votantes = Votantes; 
	}
	
	
	public void setIdEspectaculo(int IdEspectaculo){
		
		this.IdEspectaculo = IdEspectaculo; 
	}
	
}
