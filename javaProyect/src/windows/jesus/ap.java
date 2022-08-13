package windows.jesus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import POO.Conexion;
import POO.sqlUsuarios;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ap extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTable table;
	private  JTextField txtNom;
	JButton btnVolver, btnLimpiar, btnEliminar, btnEditar, btnCargar;
	JMenu mnRegistroEmple,mnRegistroCliente,mnRegistroProducto,mnVentas,mnAyuda;
	
	opPOO obj;
	private JLabel lblNom;
	private JLabel lblRol;
	JPanel panel_2;
	
	public static apbtneditar abrirEditar;


	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ap frame = new ap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ap() {
		inicializar();
	}
		
	public ap(opPOO obj) {
		
		inicializar();
		setLocationRelativeTo(null);
		this.obj=obj;
		
		
		try {
		lblNom.setText("'"+obj.getNombre()+"'");
		lblRol.setText("["+obj.getNombre_tipo()+"]");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "problema con los admis y usuarios");
		}
		if(obj.getId_tipo()==1) {
			
		}else if(obj.getId_tipo()==2) {
			btnEditar.setVisible(false);
			btnEliminar.setVisible(false);
			mnRegistroCliente.setVisible(false);
			btnVolver.setBounds(569, 155, 133, 49);
			panel_2.setBounds(561, 18, 152, 197);
			
		}
	}
	/**
	 * Create the frame.
	 */
	private void inicializar() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				app.frmLogin = null;// sirve para cuando uno cierre la ventana, y le des al boton de nuevo aparezca, por default se pone null y no habre
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\usuarios-alt.png"));
		setTitle("Registro de Empleados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 489);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		 mnRegistroEmple = new JMenu("Registro de Empleados");
		mnRegistroEmple.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\usuarios-alt33.png"));
		menuBar.add(mnRegistroEmple);
		
		 mnRegistroCliente = new JMenu("Registro de Clientes");
		menuBar.add(mnRegistroCliente);
		
		 mnRegistroProducto = new JMenu("Registro de Productos");
		menuBar.add(mnRegistroProducto);
		
		 mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		 mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Registro de Empleados");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\usuarios-alt22.png"));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel);
		
		lblNom = new JLabel("");
		lblNom.setFont(new Font("Segoe UI Historic", Font.PLAIN, 12));
		lblNom.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNom);
		
		lblRol = new JLabel("");
		lblRol.setFont(new Font("Segoe UI Historic", Font.PLAIN, 12));
		lblRol.setForeground(Color.LIGHT_GRAY);
		panel.add(lblRol);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setForeground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Ultimos empleados logeados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		 btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnLimpiar.setForeground(Color.LIGHT_GRAY);
		btnLimpiar.setBackground(Color.DARK_GRAY);
		btnLimpiar.setBounds(571, 35, 131, 49);
		panel_1.add(btnLimpiar);
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.setForeground(Color.LIGHT_GRAY);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\eliminar-documento.png"));
		btnEliminar.setBounds(571, 155, 131, 49);
		panel_1.add(btnEliminar);
		
		 btnEditar = new JButton("<html>Editar/Guardar</html>");
		 btnEditar.setForeground(Color.LIGHT_GRAY);
		btnEditar.setBackground(Color.DARK_GRAY);
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\editar (1).png"));
		btnEditar.setBounds(571, 215, 131, 49);
		panel_1.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 77, 542, 251);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Usuario", "Password", "Nombre", "Correo", "Ultimo acceso"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		}
			
				);
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		table.getColumnModel().getColumn(5).setPreferredWidth(142);
		table.getColumnModel().getColumn(5).setMinWidth(24);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del empleado");
		lblNewLabel_1.setBounds(10, 35, 137, 14);
		panel_1.add(lblNewLabel_1);
		
		txtNom = new JTextField();
		txtNom.setBounds(140, 30, 150, 23);
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		 btnVolver = new JButton("back login");
		 btnVolver.setForeground(Color.LIGHT_GRAY);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\deshacer.png"));
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(569, 271, 133, 49);
		panel_1.add(btnVolver);
		
		 panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(561, 18, 152, 315);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		 btnCargar = new JButton("<html>Cargar/Buscar</html>");
		 btnCargar.setBounds(10, 78, 131, 49);
		 panel_2.add(btnCargar);
		 btnCargar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\tiempo-pasado.png"));
		 btnCargar.setBackground(Color.DARK_GRAY);
		 btnCargar.setForeground(Color.LIGHT_GRAY);
		 
		 
		 
		 btnCargar.addActionListener(this);
		
		btnLimpiar.addActionListener(this);
		btnEditar.addActionListener(this);
		btnVolver.addActionListener(this);
		btnEliminar.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLimpiar) {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			table.setModel(model);
			
			txtNom.setText("");
			
			int fila = model.getRowCount();
			for(int i=0; i<fila; i++) {
				model.removeRow(0);//recorre todos los rows, campos de la tabla para limpiarlo
			}
			
		}else if(e.getSource()==btnEditar) {
		
			if(abrirEditar==null) {
				abrirEditar = new apbtneditar(obj);
				abrirEditar.setVisible(true);
				this.dispose();
			}
		}else if(e.getSource()==btnVolver) {
			op abrir = new op();
			abrir.setVisible(true);
			this.dispose();
			
		}else if(e.getSource()==btnEliminar) {
			
			
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
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				table.setModel(model);
				model.removeRow(fila);
				
						}catch(SQLException ex) {
							Logger.getLogger(sqlUsuarios.class.getName()).log(Level.SEVERE,null, ex);
								
						}
		    	 }
		    	      else{
		    	    JOptionPane.showMessageDialog(null, "No a podido borrar registro");
		    	   }
			
		}else if(e.getSource()==btnCargar) {
			
			String campo = txtNom.getText();
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
			
			String sql = "SELECT id, usuarios, password, nombre, correo, last_session FROM usuarios "+ where;//busqueda de campos en general al guardar
			
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
			
		}//termina el btncargar
		
		
		
	}
}
