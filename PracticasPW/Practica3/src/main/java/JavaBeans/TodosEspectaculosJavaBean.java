package JavaBeans;
import java.util.ArrayList;
import GeneralDTO.EspectaculoPaseMultipleDTO;
import GeneralDTO.EspectaculoPuntualDTO;
import GeneralDTO.EspectaculoTemporadaDTO;

public class TodosEspectaculosJavaBean implements java.io.Serializable{

private static final long serialVersionUID = -6420015779777493994L;
	
	private ArrayList <EspectaculoPuntualDTO> espPunts;
	private ArrayList <EspectaculoPaseMultipleDTO> espMults;
	private ArrayList <EspectaculoTemporadaDTO> espTemps;
	private int numPunt;
	private int numMult;
	private int numTemp;
	
	public ArrayList <EspectaculoPuntualDTO> getAllPunt()
	{
		return espPunts;
	}
	
	public ArrayList <EspectaculoPaseMultipleDTO> getAllMult()
	{
		return espMults;
	}
	
	public ArrayList <EspectaculoTemporadaDTO> getAllTemp()
	{
		return espTemps;
	}
	public void setAllPunt(ArrayList<EspectaculoPuntualDTO> punts)
	{
		this.espPunts = punts;
	}
	
	public void setAllMult(ArrayList<EspectaculoPaseMultipleDTO> mults)
	{
		this.espMults = mults;
	}
	
	public void setAllTemp(ArrayList<EspectaculoTemporadaDTO> temps)
	{
		this.espTemps = temps;
	}
	
	public int getNumPunt()
	{
		return numPunt;
	}
	
	public int getNumMult()
	{
		return numMult;
	}
	
	public int getNumTemp()
	{
		return numTemp;
	}
	
	public void setNumPunt(int num)
	{
		this.numPunt = num;
	}
	
	public void setNumMult(int num)
	{
		this.numMult = num;
	}
	
	public void setNumTemp(int num)
	{
		this.numTemp = num;
	}
}
