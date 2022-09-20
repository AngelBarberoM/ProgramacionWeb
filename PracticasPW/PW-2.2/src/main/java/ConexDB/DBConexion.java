package ConexDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para conexion con MySQL
 */
public class DBConexion {
	
	/* 
	 * Acceso a la base de datos
	 */
	protected Connection conexion = null;
	protected String url;
	protected String user;
	protected String password;
	
	public DBConexion(String url, String user, String password){
	
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public Connection getConnection(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database conexion successfully opened!");
		} 
		catch (SQLException Excep) {
			
			System.err.println("Connection to MySQL has failed!");
			Excep.printStackTrace();
			
		} catch (ClassNotFoundException Excep) {
			
			System.err.println("JDBC Driver not found.");
			Excep.printStackTrace();
		}
		return this.conexion;
	}

	public void closeConnection() {
		
		try {
		
			if(this.conexion != null && !this.conexion.isClosed()) {
			
				this.conexion.close();
				System.out.println("Database conexion successfully closed!");
			}
		} 
		catch (SQLException Excep) {
			
			System.err.println("Error while trying to close the conexion.");
			Excep.printStackTrace();
		}
	}
}
