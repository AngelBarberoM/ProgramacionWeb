package JavaBeans;
import java.util.ArrayList;
import GeneralDTO.CriticaDTO;

public class TodasCriticasJavaBean implements java.io.Serializable{

	private static final long serialVersionUID = 6739558918861115241L;
	
	private ArrayList <CriticaDTO> criticas;
	private int numCrit;
	
	public ArrayList <CriticaDTO> getAllCrit()
	{
		return criticas;
	}
	
	public void setAllCrit(ArrayList<CriticaDTO> crit)
	{
		this.criticas = crit;
	}
	
	public int getNumCrit()
	{
		return numCrit;
	}
	
	public void setNumCrit(int num)
	{
		this.numCrit = num;
	}
}
