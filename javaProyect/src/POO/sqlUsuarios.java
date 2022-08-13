package POO;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import windows.jesus.opPOO;


public class sqlUsuarios extends Conexion {
	public boolean registrar(opPOO usr) {
		PreparedStatement ps = null;
		Connection con = (Connection) getConexion();
		
		String sql = "insert into usuarios(usuarios,password,nombre,correo,id_tipo) values(?,?,?,?,?)";
	try {	
		ps = (PreparedStatement) con.prepareStatement(sql);
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
	
	public int verificarUsuarioExistente(String user) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = (Connection) getConexion();
		
		String sql = "select count(id) from usuarios where usuarios = ?";
	try {	
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, user);
		rs = (ResultSet) ps.executeQuery();
		
				if(rs.next()) {
						return rs.getInt(1);
					}
					return 1;
					
							}catch(SQLException ex) {
								Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
									return 1;
								}
		
	}
	
	public int verificarGmailExistente(String gmail) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = (Connection) getConexion();
		
		String sql = "select count(id) from usuarios where correo = ?";
	try {	
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, gmail);
		rs = (ResultSet) ps.executeQuery();
		
				if(rs.next()) {
						return rs.getInt(1);
					}
					return 1;
					
							}catch(SQLException ex) {
								Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
									return 1;
								}
		
	}

	
	public boolean Login(opPOO usr) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = (Connection) getConexion();
		
		String sql = "SELECT u.id, u.usuarios, u.password, u.nombre, u.id_tipo, t.nombre FROM usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo = t.id WHERE usuarios = ?";// aqui esta las pocisiones, 1)ID, 2)USUARIOS, 3)PASSWORD
	//tambien se agregara query y inner join para relacionar la tabla tipo y usuarios para indentificar si es admin o usuario
		try {	
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, usr.getUser());
		rs = (ResultSet) ps.executeQuery();
		
				if(rs.next()) {//aqui va validacion de contaseña en el login
					if(usr.getContra().equals(rs.getString(3))) { //depende de la posicion que este los campos, estos pueden cambiar, el password esta en la posicion 4
						
						String sqlUpdate = "update usuarios set last_session = ? where id = ?";
						
						ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
						
						ps.setString(1, usr.getLast_session());
						ps.setInt(2, rs.getInt(1));
						ps.execute();
						
						usr.setId(rs.getInt(1));//posicion 1 en el query
						usr.setNombre(rs.getString(4));//posicion 4 en el query
						usr.setId_tipo(rs.getInt(5));//posicion 5 en el query
						usr.setNombre_tipo(rs.getString(6));//posicion 6 en el query
						
						return true;
								}else {
									return false;
								}
					}
					return false;
					
							}catch(SQLException ex) {
								Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
									return false;
								}
		
	}

	public boolean registrarModi(opPOO usr) {
		PreparedStatement ps = null;
		Connection con = (Connection) getConexion();
		
		String sql = "insert into usuarios(id,usuarios,password,nombre,correo,id_tipo) values(?,?,?,?,?,?)";
	try {	
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setLong(1, usr.getId());
		ps.setString(2, usr.getUser());
		ps.setString(3, usr.getContra());
		ps.setString(4, usr.getNombre());
		ps.setString(5, usr.getGmail());
		ps.setInt(6, usr.getId_tipo());
		ps.execute();
		return true;
				}catch(SQLException ex) {
					Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
						return false;
				}
		
	}
	
 	public boolean esEmail(String correo) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+´)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);
        return mather.find();

    }
}
