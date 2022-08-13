package windows.jesus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import POO.Conexion;
import POO.sqlUsuarios;
import hash.jesus.hash;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class apbtneditar extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txt1;
	private JPasswordField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	JButton btnRegresar, btnLimpiar, btnBorrar, btnEditar, btnGuardar;
	 JLabel lblNom2, lblRol2, ocultar, ver;
	opPOO obj;
	private JButton btnBuscar;
	private JTextField txtIndice;
	private JTextField txtID;
	
	public static ap abrirRegistro;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apbtneditar frame = new apbtneditar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public apbtneditar() {
		inicializar();
		
	
	}
	
	public apbtneditar(opPOO obj) {
		inicializar();
		setLocationRelativeTo(null);
		this.obj=obj;
		
		
	
		if(obj.getId_tipo()==1) {
			try {
				lblNom2.setText("'"+obj.getNombre()+"'");
				lblRol2.setText("["+obj.getNombre_tipo()+"]");
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "problema con los admis");
				}
		}//  para indentificar es admin y nombre
		
		try {
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			table.setModel(model);
			
				PreparedStatement ps = null;
				ResultSet rs = null;
				Conexion conn = new Conexion();
				Connection con = (Connection) conn.getConexion();
				
				String sql = "SELECT id, usuarios, password, nombre, correo, id_tipo FROM usuarios";//busqueda de campos en general al guardar
				
				ps = (PreparedStatement) con.prepareStatement(sql);
				rs = (ResultSet) ps.executeQuery();
				
				ResultSetMetaData rsMD = rs.getMetaData();
				int cantidadColumnas = rsMD.getColumnCount();//para poder manejar el limite de datos que hay en la tabla de mysql
		
				while(rs.next()) {
					
					Object[] filas = new Object[cantidadColumnas];//agregamo objecto para validar la fila
					
					
					for(int i=0; i<cantidadColumnas; i++ ) {
						filas[i] = rs.getObject(i+1);//recorre toda la base de datos agregadolo en el campo de la tabla
					}
					model.addRow(filas);
				}
				
				}catch(SQLException ex) {
					ex.printStackTrace();
					Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
					JOptionPane.showMessageDialog(null, "error a conexion a la base de datos");
				}//rellenar tabla

	}

	/**
	 * Create the frame.
	 */
	private void inicializar() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ap.abrirEditar = null;// sirve para cuando uno cierre la ventana, y le des al boton de nuevo aparezca, por default se pone null y no habre
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\editar.png"));
		setBackground(Color.DARK_GRAY);
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Editar/Agregar Registro de Empleados o Administradores");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\editar (2).png"));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel);
		
		 lblNom2 = new JLabel("");
		lblNom2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		lblNom2.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNom2);
		
		 lblRol2 = new JLabel("");
		lblRol2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		lblRol2.setForeground(Color.LIGHT_GRAY);
		panel.add(lblRol2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 19, 371, 260);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {	
				
				Conexion conn = new Conexion();
				Connection con = (Connection) conn.getConexion();
				
				int fila = table.getSelectedRow();
				String id = table.getValueAt(fila, 0).toString();
				String sql = "SELECT id, usuarios, password, nombre, correo, id_tipo FROM usuarios WHERE id=?";	
				
			
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, id);
				rs = (ResultSet) ps.executeQuery();
				
				while(rs.next()) {
					txtID.setText(rs.getString("id"));
					txt1.setText(rs.getString("usuarios"));
					txt2.setText(rs.getString("password"));
					txt3.setText(rs.getString("nombre"));
					txt4.setText(rs.getString("correo"));
					txt5.setText(rs.getString("id_tipo"));
				}
				
						}catch(SQLException ex) {
							Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
								
						}
				
		
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Usuario", "Password", "Nombre", "Correo", "Rol"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(122);
		table.getColumnModel().getColumn(5).setPreferredWidth(33);
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(646, 11, 125, 231);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		 btnGuardar = new JButton("<html>Guardar Cuenta</html>");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\flecha-alt-circulo-derecha.png"));
		btnGuardar.setBounds(10, 15, 105, 43);
		panel_2.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setForeground(Color.LIGHT_GRAY);
		
		 btnEditar = new JButton("<html>Editar Cuenta</html>");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\capas.png"));
		btnEditar.setBounds(10, 69, 105, 43);
		panel_2.add(btnEditar);
		btnEditar.setForeground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEditar.setBackground(Color.DARK_GRAY);
		
		 btnBorrar = new JButton("<html>Borrar Cuenta</html>");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\eliminar-documento.png"));
		btnBorrar.setBounds(10, 123, 105, 43);
		panel_2.add(btnBorrar);
		btnBorrar.setForeground(Color.LIGHT_GRAY);
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBorrar.setBackground(Color.DARK_GRAY);
		
		 btnRegresar = new JButton("<html>Regresar a registro</html>");
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\deshacer.png"));
		btnRegresar.setBounds(10, 177, 105, 43);
		panel_2.add(btnRegresar);
		btnRegresar.setForeground(Color.LIGHT_GRAY);
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRegresar.setBackground(Color.DARK_GRAY);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Valores", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(402, 11, 234, 174);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(10, 27, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		txt1.setBounds(62, 24, 162, 20);
		panel_3.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pass");
		lblNewLabel_2.setBounds(10, 52, 46, 14);
		panel_3.add(lblNewLabel_2);
		
		txt2 = new JPasswordField();
		txt2.setEchoChar('*');
		txt2.setBounds(62, 49, 133, 20);
		panel_3.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(62, 74, 162, 20);
		panel_3.add(txt3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(10, 77, 46, 14);
		panel_3.add(lblNewLabel_1_1);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(62, 99, 162, 20);
		panel_3.add(txt4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo");
		lblNewLabel_1_2.setBounds(10, 102, 46, 14);
		panel_3.add(lblNewLabel_1_2);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(62, 130, 37, 20);
		panel_3.add(txt5);
		
		JLabel lblNewLabel_1_3 = new JLabel("<html>Rol de empresa</html>");
		lblNewLabel_1_3.setBounds(10, 123, 52, 27);
		panel_3.add(lblNewLabel_1_3);
		
		 ver = new JLabel("");
			ver.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					ver.setVisible(false);
					ocultar.setVisible(true);
					txt2.setEchoChar((char)0);
				}
			});
		ver.setBounds(199, 55, 25, 14);
		panel_3.add(ver);
		ver.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojo.png"));
		
		 ocultar = new JLabel("");
		 ocultar.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		ver.setVisible(true);
					ocultar.setVisible(false);
					txt2.setEchoChar('*');
			 	}
			 });
		ocultar.setBounds(199, 55, 25, 14);
		this.ocultar.setVisible(false);
		panel_3.add(ocultar);
		ocultar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojos-cruzados.png"));
		
		JLabel lblNewLabel_4 = new JLabel("<html>''''colocar 1=administrador, el 2=usuario''''</html>");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_4.setBounds(109, 122, 115, 41);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione cuenta.");
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setBounds(10, 4, 158, 14);
		panel_1.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(391, 11, 2, 268);
		panel_1.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("<html>'''Borrar cidrado del password para editar y ponerle uno nuevo'''</html>");
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_5.setBounds(412, 196, 109, 46);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Buscar/Limpiar", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(527, 196, 109, 83);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		 btnLimpiar = new JButton("");
		 btnLimpiar.setBounds(54, 40, 55, 43);
		 panel_4.add(btnLimpiar);
		 btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		 btnLimpiar.setBackground(Color.DARK_GRAY);
		 btnLimpiar.setForeground(Color.LIGHT_GRAY);
		 btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		 
		 btnBuscar = new JButton("");
		 btnBuscar.setBackground(Color.DARK_GRAY);
		 btnBuscar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\tiempo-pasado.png"));
		 btnBuscar.setBounds(0, 40, 55, 43);
		 panel_4.add(btnBuscar);
		 
		 txtIndice = new JTextField();
		 txtIndice.setBounds(0, 21, 109, 20);
		 panel_4.add(txtIndice);
		 txtIndice.setColumns(10);
		 
		 txtID = new JTextField();
		 txtID.setEnabled(false);
		 txtID.setBounds(422, 253, 86, 20);
		 txtID.setVisible(false);
		 panel_1.add(txtID);
		 txtID.setColumns(10);
		 
		
		btnLimpiar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnEditar.addActionListener(this);
		btnRegresar.addActionListener(this);
		btnBuscar.addActionListener(this);
		
		
	}
	
	private void limpiarRegistro() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLimpiar) {
			limpiarRegistro();
		}else if(e.getSource()==btnBuscar){
			String campo = txtIndice.getText();
			String where = "";//opcion para cuando usemos el indice
			
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			table.setModel(model);
			
			if(!"".equals(campo)) {//aqui se valida el indice, dependiendo
				
				int Recorrefila = model.getRowCount();
				for(int i=0; i<Recorrefila; i++) {
					model.removeRow(0);//se limpia y se aguega un query where para buscar el campo
				}
				
				where = "WHERE nombre = '"+ campo +"'";
			}
			
			try {
				
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				Conexion conn = new Conexion();
				Connection con = (Connection) conn.getConexion();
				
				String sql = "SELECT id, usuarios, password, nombre, correo, id_tipo FROM usuarios "+ where;//busqueda de campos en general al guardar
				
				ps = (PreparedStatement) con.prepareStatement(sql);
				rs = (ResultSet) ps.executeQuery();
				
				ResultSetMetaData rsMD = rs.getMetaData();
				int cantidadColumnas = rsMD.getColumnCount();//para poder manejar el limite de datos que hay en la tabla de mysql
		
				while(rs.next()) {
					
					Object[] filas = new Object[cantidadColumnas];//agregamo objecto para validar la fila
					
					
					for(int i=0; i<cantidadColumnas; i++ ) {
						filas[i] = rs.getObject(i+1);//recorre toda la base de datos agregadolo en el campo de la tabla
					}
					model.addRow(filas);
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
				JOptionPane.showMessageDialog(null, "error a conexion a la base de datos");
			}
		}else if(e.getSource()==btnGuardar) {
			String eeuser = txt1.getText();		
			String eecontra = String.valueOf(txt2.getPassword());
			String eenombre = txt3.getText();
			String eeGmail = txt4.getText();
			String tipoidString = txt5.getText();
			int tipoidnew = Integer.parseInt(tipoidString);
			int IDD = Integer.parseInt(txtID.getText());
			
			
			if(eeGmail.equals("") || eecontra.equals("") || eeuser.equals("") || eenombre.equals("")) {
				
	 			JOptionPane.showMessageDialog(null, "hay celdas vacias, complete las celdas!");
	 			
			}else {
				
			if(eeGmail == null || eeGmail.equals(eecontra) || eeGmail.equals(eeuser) || eeGmail.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 			
	 		}else if(eeuser == null || eeuser.equals(eecontra) || eeuser.equals(eeGmail) || eeuser.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}else if(eenombre == null || eenombre.equals(eecontra) || eenombre.equals(eeuser) || eenombre.equals(eeGmail)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}else if(eecontra == null || eecontra.equals(eeGmail) || eecontra.equals(eeuser) || eecontra.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}
			
			opPOO obj = new opPOO();

			//conexion a base de datos de registro
			
			sqlUsuarios modSql = new sqlUsuarios();
				
			
				
				if(modSql.verificarUsuarioExistente(eeuser)==0) {
					
					if(modSql.verificarGmailExistente(eeGmail)==0) {
					
						if(modSql.esEmail(eeGmail)) {
						
					
					String newpass = hash.sha1(eecontra);
					
								obj.setId(IDD);
								obj.setGmail(eeGmail);
								obj.setNombre(eenombre);
								obj.setUser(eeuser);
								obj.setContra(newpass);
								obj.setId_tipo(tipoidnew);
					
																			if(modSql.registrarModi(obj)) {
																				JOptionPane.showMessageDialog(null, "Se agrego usuario correctamente!");
																				limpiarRegistro();
																			
																			}else {
																//por si da error la conexion de la base de dato u otra cosa, esto no indentifica para eso
																				JOptionPane.showMessageDialog(null, "No se puedo guardar, hubo un error.");
																			}
																	}else {
																		
																		JOptionPane.showMessageDialog(null, "Error en el gmail");
																	}//cierre del if verificacion de gmail esta bien puesto @gmail o @hotmail
													}else {
														
														JOptionPane.showMessageDialog(null, "Esta siendo usado este gmail");
													}
										}else{
											
											JOptionPane.showMessageDialog(null, "Esta siendo usado este usuario");
										}//cierre del if verificacion de user
				
				
				
						}
		
			
			
		}else if(e.getSource()==btnBorrar) {
			int resp = JOptionPane.showConfirmDialog(null, "¿seguro que quieres borrar este registro?");
		    if (JOptionPane.OK_OPTION == resp){
		    	JOptionPane.showMessageDialog(null, "Registro borrado correctamente");
		    	
		    	PreparedStatement ps = null;
				try {	
				
				Conexion conn = new Conexion();
				Connection con = (Connection) conn.getConexion();
				
				int fila = table.getSelectedRow();
				String id = table.getValueAt(fila, 0).toString();
				String sql = "DELETE FROM usuarios WHERE id = ?";	
				
			
				ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, id);
				ps.execute();
				limpiarRegistro();
				
						}catch(SQLException ex) {
							Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
								
						}
		    	 }
		    	      else{
		    	    JOptionPane.showMessageDialog(null, "No a podido borrar registro");
		    	   }
			
		
		}else if(e.getSource()==btnEditar) {
			String eeuser = txt1.getText();		
			String eecontra = String.valueOf(txt2.getPassword());
			String eenombre = txt3.getText();
			String eeGmail = txt4.getText();
			int tipoidnew = Integer.parseInt(txt5.getText());
			int IDD = Integer.parseInt(txtID.getText());
			int fila = table.getSelectedRow();
			
			if(eeGmail.equals("") || eecontra.equals("") || eeuser.equals("") || eenombre.equals("")) {
				
	 			JOptionPane.showMessageDialog(null, "hay celdas vacias, complete las celdas!");
	 			
			}else {
				
			if(eeGmail == null || eeGmail.equals(eecontra) || eeGmail.equals(eeuser) || eeGmail.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 			
	 		}else if(eeuser == null || eeuser.equals(eecontra) || eeuser.equals(eeGmail) || eeuser.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}else if(eenombre == null || eenombre.equals(eecontra) || eenombre.equals(eeuser) || eenombre.equals(eeGmail)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}else if(eecontra == null || eecontra.equals(eeGmail) || eecontra.equals(eeuser) || eecontra.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}
			
			

			//conexion a base de datos de registro
			
			sqlUsuarios modSql = new sqlUsuarios();

						if(modSql.esEmail(eeGmail)) {
						
					
					String newpass = hash.sha1(eecontra);
					
					PreparedStatement ps = null;
					try {	
					
					Conexion conn = new Conexion();
					Connection con = (Connection) conn.getConexion();
					
					String sql = "UPDATE usuarios SET usuarios=?,password=?,nombre=?,correo=?,id_tipo=? WHERE id=?";
					
						ps = (PreparedStatement) con.prepareStatement(sql);
						ps.setString(1, eeuser);
						ps.setString(2, newpass);
						ps.setString(3, eenombre);
						ps.setString(4, eeGmail);
						ps.setInt(5, tipoidnew);//arreglar la parte de actualizar, esta bien, pero no se guarda la actualizacion
						ps.setInt(6, IDD);
						//ps.setString(6, );
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Se agrego actualizo correctamente!");
						table.setValueAt(eeuser, fila, 1);
						table.setValueAt(newpass, fila, 2);
						table.setValueAt(eenombre, fila,3);
						table.setValueAt(eeGmail, fila, 4);
						table.setValueAt(tipoidnew, fila, 5);
						limpiarRegistro();
					
								}catch(SQLException ex) {
									Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
										
								}
					
																			
												
																			
																			
																	}else {
																		
																		JOptionPane.showMessageDialog(null, "Error en el gmail");
																	}//cierre del if verificacion de gmail esta bien puesto @gmail o @hotmail
													
				
				
				
						}
		}else if(e.getSource()==btnRegresar) {
			abrirRegistro = new ap(obj);
			abrirRegistro.setVisible(true);
			this.dispose();
		}
		
	}
}
