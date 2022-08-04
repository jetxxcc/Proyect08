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
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ap extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNom;

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

	/**
	 * Create the frame.
	 */
	public ap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\usuarios-alt.png"));
		setTitle("Registro de Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 461);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registro de Empleados");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\usuarios-alt33.png"));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Registro de Clientes");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Registro de Productos");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Ultimos empleados logeados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnLimpiar.setForeground(Color.BLACK);
		btnLimpiar.setBackground(Color.DARK_GRAY);
		btnLimpiar.setBounds(475, 11, 106, 49);
		panel_1.add(btnLimpiar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.DARK_GRAY);
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\buscar-alt.png"));
		btnBuscar.setBounds(475, 71, 106, 49);
		panel_1.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\eliminar-documento.png"));
		btnEliminar.setBounds(475, 131, 106, 49);
		panel_1.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.DARK_GRAY);
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\capas.png"));
		btnEditar.setBounds(475, 191, 106, 49);
		panel_1.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 455, 232);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Fecha de ingreso", "Correo"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(24);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del empleado");
		lblNewLabel_1.setBounds(10, 35, 111, 14);
		panel_1.add(lblNewLabel_1);
		
		txtNom = new JTextField();
		txtNom.setBounds(115, 30, 150, 23);
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		JButton btnVolver = new JButton("Volver al login");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\deshacer.png"));
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(473, 247, 110, 49);
		panel_1.add(btnVolver);
	}
}
