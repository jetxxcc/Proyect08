package POO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	
	private static Connection con=null;
	private static String base = "usuarios";
	private static String user = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/" + base; 
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			
			}catch(ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
			
					}
		return con;
	}
	
	
}
