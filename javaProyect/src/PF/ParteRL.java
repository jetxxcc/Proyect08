package PF;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ParteRL {

	private JFrame frame;
	private JTable table;
	private JTextField textf_codigo;
	private JTextField textField_Nombre;
	private JTextField textField_Ced;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_Dic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParteRL window = new ParteRL();
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
	public ParteRL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\usuarios-alt (1).png"));
		frame.setBounds(100, 100, 822, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 806, 49);
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\usuarios-alt.png"));
		lblNewLabel.setBounds(0, 74, 309, -63);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Registro de Clientes");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(347, 11, 145, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\usuarios-alt (1).png"));
		lblNewLabel_3_1.setBounds(313, 13, 24, 24);
		panel.add(lblNewLabel_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 60, 227, 239);
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Código");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 30, 124, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 55, 124, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cédula");
		lblNewLabel_1_2.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 90, 124, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_Tel = new JLabel("Teléfono");
		lblNewLabel_Tel.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_Tel.setBounds(10, 120, 124, 14);
		panel_1.add(lblNewLabel_Tel);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Dirección ");
		lblNewLabel_1_2_2.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(10, 145, 124, 14);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_Es = new JLabel("Estado");
		lblNewLabel_Es.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_Es.setBounds(10, 176, 124, 14);
		panel_1.add(lblNewLabel_Es);
		
		JLabel lblNewLabel_Ing = new JLabel("Ingreso");
		lblNewLabel_Ing.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_Ing.setBounds(10, 201, 124, 14);
		panel_1.add(lblNewLabel_Ing);
		
		textf_codigo = new JTextField();
		textf_codigo.setBounds(85, 28, 132, 20);
		panel_1.add(textf_codigo);
		textf_codigo.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(85, 55, 132, 20);
		panel_1.add(textField_Nombre);
		
		textField_Ced = new JTextField();
		textField_Ced.setColumns(10);
		textField_Ced.setBounds(85, 90, 132, 20);
		panel_1.add(textField_Ced);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 118, 132, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(85, 176, 132, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(85, 203, 132, 20);
		panel_1.add(textField_4);
		
		textField_Dic = new JTextField();
		textField_Dic.setColumns(10);
		textField_Dic.setBounds(85, 145, 132, 20);
		panel_1.add(textField_Dic);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(247, 60, 402, 239);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 402, 239);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "C\u00E9dula", "T\u00E9lefono", "Direcci\u00F3n", "Estado", "Ingreso"
			}
		));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(659, 60, 135, 239);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setBounds(10, 23, 115, 33);
		panel_3.add(btnGuardar);
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\agregar-documento (1).png"));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\buscar-alt.png"));
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setBounds(10, 67, 115, 33);
		panel_3.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\eliminar-documento.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setBounds(10, 155, 115, 33);
		panel_3.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\capas.png"));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setBounds(10, 111, 115, 33);
		panel_3.add(btnEditar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\deshacer.png"));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setBounds(10, 195, 115, 33);
		panel_3.add(btnVolver);
	}
}
