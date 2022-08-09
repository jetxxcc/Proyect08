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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class apbtneditar extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txt1;
	private JPasswordField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	 JLabel lblNom2, lblRol2, ocultar, ver;
	opPOO obj;

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
				
				String sql = "SELECT usuarios, password, nombre, correo, id_tipo FROM usuarios";//busqueda de campos en general al guardar
				
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
		setBounds(100, 100, 807, 352);
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
		scrollPane.setBounds(10, 19, 371, 231);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = table.getSelectedRow();
				
				if(fila == 1) {
					JOptionPane.showMessageDialog(null, "no selecciono fila");
				}else {
				
				String eeuser= (String)table.getValueAt(fila, 0);		
				String eecontra= (String)table.getValueAt(fila, 1);
				String eenombre = (String)table.getValueAt(fila, 2);
				String eecorreo = (String)table.getValueAt(fila, 3);
				int idtipo = Integer.parseInt((String)table.getValueAt(fila, 4).toString());
				
				txt1.setText(eeuser);
				txt2.setText(eecontra);
				txt3.setText(eenombre);
				txt4.setText(eecorreo);
				txt5.setText(""+idtipo);
				
				}
		
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Password", "Nombre", "Correo", "Rol"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(122);
		table.getColumnModel().getColumn(4).setPreferredWidth(33);
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(646, 11, 125, 231);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnGuardar = new JButton("<html>Guardar Cuenta</html>");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\flecha-alt-circulo-derecha.png"));
		btnGuardar.setBounds(10, 15, 105, 43);
		panel_2.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setForeground(Color.LIGHT_GRAY);
		
		JButton btnEditar = new JButton("<html>Editar Cuenta</html>");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\capas.png"));
		btnEditar.setBounds(10, 69, 105, 43);
		panel_2.add(btnEditar);
		btnEditar.setForeground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEditar.setBackground(Color.DARK_GRAY);
		
		JButton btnBorrar = new JButton("<html>Borrar Cuenta</html>");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\eliminar-documento.png"));
		btnBorrar.setBounds(10, 123, 105, 43);
		panel_2.add(btnBorrar);
		btnBorrar.setForeground(Color.LIGHT_GRAY);
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBorrar.setBackground(Color.DARK_GRAY);
		
		JButton btnRegresar = new JButton("<html>Regresar a registro</html>");
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
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(531, 196, 105, 43);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione cuenta.");
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setBounds(10, 4, 158, 14);
		panel_1.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(391, 11, 2, 239);
		panel_1.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("<html>'''Borrar cidrado del password para editar y ponerle uno nuevo'''</html>");
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_5.setBounds(412, 196, 109, 46);
		panel_1.add(lblNewLabel_5);
	}
}
