package windows;

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

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ap extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtNom;
	JButton btnBuscar, btnVolver, btnLimpiar, btnEliminar, btnEditar;
	JMenu mnRegistroEmple,mnRegistroCliente,mnRegistroProducto,mnVentas,mnAyuda;
	
	opPOO obj;
	private JLabel lblNom;
	private JLabel lblRol;
	JPanel panel_2;
	

	/**
	 * Launch the application.
	 */
	 static void AddRow(Object[] dataRow) {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			table.setModel(model);
			model.addRow(dataRow);
			
			/*PreparedStatement ps = null;
			ResultSet rs = null;
			Conexion conn = new Conexion();
			Connection conn = conn.getc*/
		}
	
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
			JOptionPane.showMessageDialog(null, "ese es el problema");
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
		
		 btnBuscar = new JButton("Buscar");
		 btnBuscar.setForeground(Color.LIGHT_GRAY);
		btnBuscar.setBackground(Color.DARK_GRAY);
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\buscar-alt.png"));
		btnBuscar.setBounds(571, 95, 131, 49);
		panel_1.add(btnBuscar);
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.setForeground(Color.LIGHT_GRAY);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\eliminar-documento.png"));
		btnEliminar.setBounds(571, 155, 131, 49);
		panel_1.add(btnEliminar);
		
		 btnEditar = new JButton("Editar");
		 btnEditar.setForeground(Color.LIGHT_GRAY);
		btnEditar.setBackground(Color.DARK_GRAY);
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\capas.png"));
		btnEditar.setBounds(571, 215, 131, 49);
		panel_1.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 77, 542, 251);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Fecha de ingreso", "Correo", "User", "Password", "ID_TIPO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}
			
				);
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.getColumnModel().getColumn(5).setPreferredWidth(72);
		table.getColumnModel().getColumn(5).setMinWidth(24);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
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
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\tiempo-pasado.png"));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(412, 18, 131, 49);
		panel_1.add(btnNewButton);
		
		 panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(561, 18, 152, 315);
		panel_1.add(panel_2);
		
		btnLimpiar.addActionListener(this);
		btnEditar.addActionListener(this);
		btnVolver.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnBuscar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLimpiar) {
			txtNom.setText("");
		}else if(e.getSource()==btnEditar) {
			
		}else if(e.getSource()==btnVolver) {
			op abrir = new op();
			abrir.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnEliminar) {
			
		}else if(e.getSource()==btnBuscar) {
			
		}
		
	}
}
