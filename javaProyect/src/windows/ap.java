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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class ap extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtNom;
	JButton btnBuscar, btnVolver, btnLimpiar, btnEliminar, btnEditar;
	/**
	 * Launch the application.
	 */
	 static void AddRow(Object[] dataRow) {
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			model.addRow(dataRow);
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

	/**
	 * Create the frame.
	 */
	public ap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\usuarios-alt.png"));
		setTitle("Registro de Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 461);
		
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
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setForeground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Ultimos empleados logeados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		 btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnLimpiar.setForeground(Color.LIGHT_GRAY);
		btnLimpiar.setBackground(Color.DARK_GRAY);
		btnLimpiar.setBounds(475, 11, 131, 49);
		panel_1.add(btnLimpiar);
		
		 btnBuscar = new JButton("Buscar");
		 btnBuscar.setForeground(Color.LIGHT_GRAY);
		btnBuscar.setBackground(Color.DARK_GRAY);
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\buscar-alt.png"));
		btnBuscar.setBounds(475, 71, 131, 49);
		panel_1.add(btnBuscar);
		
		 btnEliminar = new JButton("Eliminar");
		 btnEliminar.setForeground(Color.LIGHT_GRAY);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\eliminar-documento.png"));
		btnEliminar.setBounds(475, 131, 131, 49);
		panel_1.add(btnEliminar);
		
		 btnEditar = new JButton("Editar");
		 btnEditar.setForeground(Color.LIGHT_GRAY);
		btnEditar.setBackground(Color.DARK_GRAY);
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\capas.png"));
		btnEditar.setBounds(475, 191, 131, 49);
		panel_1.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 455, 232);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Fecha de ingreso", "Correo"
			}
		)	{	
				boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			};
			Class[] columnTypes = new Class[] {
					//carbiar valores dependiendo del tipo de valores
					Object.class, String.class, Object.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		}
			
				);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(24);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
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
		btnVolver.setBounds(473, 247, 133, 49);
		panel_1.add(btnVolver);
		
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
