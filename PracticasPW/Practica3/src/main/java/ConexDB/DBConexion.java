package ConexDB;
import java.sql.*;

public class DBConexion {

	/* 
	 * Acceso a la base de datos
	*/
	
	protected Connection connection = null;
	
	protected String url;
	protected String usuario;
	protected String contrasena;
	
	public DBConexion(String url, String usuario, String passw){
	
		this.url = url;
		this.usuario = usuario;
		this.contrasena = passw;
	}
	
	public Connection getConnection(){
		
		try {
	      
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, usuario, contrasena);
			System.out.println("Database connection successfully opened!");
		} 
		catch (SQLException Excep) {
	    	
			System.err.println("Connection to MySQL has failed!");
			Excep.printStackTrace();
		} 
		catch (ClassNotFoundException Excep) {
		     
			System.err.println("JDBC Driver not found.");
			Excep.printStackTrace();
		}
		return this.connection;
	}

	public void closeConnection() {
		
		try {
		
			if(this.connection != null && !this.connection.isClosed()) {
				
				this.connection.close();
			}
		} 
		catch (SQLException Excep) {
			
			System.err.println("Error while trying to close the connection.");
			Excep.printStackTrace();
		}
	}
}
