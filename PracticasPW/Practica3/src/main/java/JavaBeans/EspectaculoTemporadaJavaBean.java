package JavaBeans;
import java.util.ArrayList;
import GeneralDTO.EspectaculoTemporadaDTO;
import GeneralDTO.PaseDTO;

public class EspectaculoTemporadaJavaBean implements java.io.Serializable{

	private static final long serialVersionUID = 7590868581323155534L;

	private String categoria = ""; 
	private String titulo ="";  
	private String descripcion = ""; 
	private int localidades_venta = 0; 
	private int localidades_vendidas = 0; 
	private ArrayList<PaseDTO> pases;
	private ArrayList<Integer> criticas;
	private ArrayList<EspectaculoTemporadaDTO> espsTemp;

	
	public String getCategoria()
	{
		return categoria;
	}
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}

	public int getLocalidadesVenta()
	{
		return localidades_venta;
	}
	
	public int getLocalidadesVendidas()
	{
		return localidades_vendidas;
	}
	
	public ArrayList<PaseDTO> getPases()
	{
		return this.pases;
	}
	
	public ArrayList<Integer> getCriticas()
	{
		return this.criticas;
	}
	
	public ArrayList<EspectaculoTemporadaDTO> getEspectaculosTemp()
	{
		return this.espsTemp;
	}
	
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public void setLocalidadesVenta(int localidadesVenta)
	{
		this.localidades_venta = localidadesVenta;
	}
	
	public void setLocalidadesVendidas(int localidadesVendidas)
	{
		this.localidades_vendidas = localidadesVendidas;
	}
	
	public void setPases(ArrayList<PaseDTO> pases)
	{
		this.pases = pases;
	}
	
	public void setCritica(ArrayList<Integer> c)
	{
		this.criticas = c;
	}
	
	public void setEspectaculosTemp(ArrayList<EspectaculoTemporadaDTO> esps)
	{
		this.espsTemp = esps;
	}
}
