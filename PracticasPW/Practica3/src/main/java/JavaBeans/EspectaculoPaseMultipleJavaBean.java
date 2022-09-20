package JavaBeans;
import java.util.ArrayList;
import GeneralDTO.EspectaculoPaseMultipleDTO;
import GeneralDTO.FechaDTO;

public class EspectaculoPaseMultipleJavaBean implements java.io.Serializable{

private static final long serialVersionUID = -6967728930973189348L;
	
	private int id = 0;
	private String categoria = ""; 
	private String titulo ="";  
	private String descripcion = ""; 
	private int localidades_venta = 0; 
	private int localidades_vendidas = 0; 
	private ArrayList<FechaDTO> fechas;
	private ArrayList<Integer> criticas;
	private ArrayList<EspectaculoPaseMultipleDTO> espsMult;

	public int getId()
	{
		return id;
	}
	
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
	
	public ArrayList<FechaDTO> getFechas()
	{
		return this.fechas;
	}
	
	public ArrayList<Integer> getCriticas()
	{
		return this.criticas;
	}
	
	public ArrayList<EspectaculoPaseMultipleDTO> getEspectaculosMult()
	{
		return this.espsMult;
	}
	
	public void setId(int id)
	{
		this.id = id;
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
	
	public void setFechas(ArrayList<FechaDTO> fechas)
	{
		this.fechas = fechas;
	}
	
	public void setCritica(ArrayList<Integer> c)
	{
		this.criticas = c;
	}
	
	public void setEspectaculosMult(ArrayList<EspectaculoPaseMultipleDTO> espsMult)
	{
		this.espsMult = espsMult;
	}
}
