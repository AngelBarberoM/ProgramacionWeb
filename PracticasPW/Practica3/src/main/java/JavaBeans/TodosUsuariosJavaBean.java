package JavaBeans;
import java.util.ArrayList;
import GeneralDTO.UsuarioDTO;

public class TodosUsuariosJavaBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList <UsuarioDTO> usuarios;
	private int numUsers;
	
	public ArrayList <UsuarioDTO> getAllUsers()
	{
		return usuarios;
	}
	
	public void setAllUsers(ArrayList<UsuarioDTO> users)
	{
		this.usuarios = users;
	}
	
	public int getNumUsers()
	{
		return numUsers;
	}
	
	public void setNumUsers(int num)
	{
		this.numUsers = num;
	}
}
