package ConexDB;
import java.sql.*;

/**
 * Clase para conexion con MySQL
 */
public class DBConexion {
	
	/* 
	 * Acceso a la base de datos
	*/
	
	protected Connection connection = null;
	
	protected String url = "jdbc:mysql://oraclepr.uco.es:3306/i82gocam";

	protected String user = "i82gocam";

	protected String password = "pw1234";

	public Connection getConnection(){
		
		try {
	      
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(url, user, password);
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

