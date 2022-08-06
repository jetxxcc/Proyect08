package POO;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import windows.opPOO;
import windows.opList;

public class sqlUsuarios extends Conexion {
	public boolean registrar(opPOO usr) {
		PreparedStatement ps = null;
		Connection con = (Connection) getConexion();
		
		String sql = "insert into usuarios(usuarios,password,nombre,correo,id_tipo) values(?,?,?,?,?)";
	try {	
		ps = (PreparedStatement) con.prepareStatement(sql);
		//depende si cambiarlo, por si no acepta vector, el vector ya recoge los objectos de por si, si hay que quitarlo quitamos el vector y agregamos nadamas los metodos
		ps.setString(1, usr.getUser());
		ps.setString(2, usr.getContra());
		ps.setString(3, usr.getNombre());
		ps.setString(4, usr.getGmail());
		ps.setInt(5, usr.getId_tipo());
		ps.execute();
		return true;
	}catch(SQLException ex) {
		Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
		return false;
	}
		
	}
}
