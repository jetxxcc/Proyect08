package POO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection con;
	private static String user = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/";
	
	public Conexion() {
		con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			
			}catch(ClassNotFoundException | SQLException e) {
			System.out.print("error al conectar" + e);
			
					}
				
			}	
	public Connection getConnection() {
		return  con;
	}
	
}
