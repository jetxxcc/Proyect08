package PF;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ParteRL_2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParteRL_2 window = new ParteRL_2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParteRL_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\carrito-de-compra-anadir.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 846, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 830, 56);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Productos");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel.setBounds(68, 11, 188, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\carrito-de-compra-anadir.png"));
		lblNewLabel_1.setBounds(22, 11, 82, 37);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 77, 181, 266);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Código");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 25, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(66, 25, 94, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 53, 65, 14);
		panel_1.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 53, 94, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Cantidad");
		lblNewLabel_2_3.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(10, 96, 65, 14);
		panel_1.add(lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(74, 96, 86, 20);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Provedor");
		lblNewLabel_2_1_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 124, 58, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(74, 124, 86, 20);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Categoria");
		lblNewLabel_2_2_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(10, 152, 65, 14);
		panel_1.add(lblNewLabel_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(74, 152, 86, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Compra");
		lblNewLabel_2_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 201, 58, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(74, 201, 86, 20);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Venta");
		lblNewLabel_2_2_1_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_2_1_1.setBounds(10, 229, 65, 14);
		panel_1.add(lblNewLabel_2_2_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(74, 229, 86, 20);
		panel_1.add(textField_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 83, 161, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 188, 161, 2);
		panel_1.add(separator_1);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(201, 77, 479, 266);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 479, 266);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Compra ", "Categoria", "Provedor", "Cantidad", "Nombre", "C\u00F3digo", "Venta"
			}
		));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(690, 77, 130, 265);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\agregar-documento (1).png"));
		btnAgregar.setBounds(10, 20, 110, 38);
		panel_3.add(btnAgregar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\buscar-alt.png"));
		btnBuscar.setBounds(10, 69, 110, 38);
		panel_3.add(btnBuscar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\capas.png"));
		btnEditar.setBounds(10, 118, 110, 38);
		panel_3.add(btnEditar);
		
		JButton btnNewButton_1_1 = new JButton("Borrar");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\eliminar-documento.png"));
		btnNewButton_1_1.setBounds(10, 167, 110, 38);
		panel_3.add(btnNewButton_1_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\deshacer.png"));
		btnVolver.setBounds(10, 216, 110, 38);
		panel_3.add(btnVolver);
	}
}
