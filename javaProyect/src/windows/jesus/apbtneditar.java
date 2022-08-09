package windows.jesus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class apbtneditar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt1;
	private JPasswordField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;

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

	/**
	 * Create the frame.
	 */
	public apbtneditar() {
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
		setBounds(100, 100, 791, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Editar Registro de Empleados");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\editar (2).png"));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 371, 231);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Password", "Nombre", "Correo", "Rol"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(122);
		table.getColumnModel().getColumn(4).setPreferredWidth(33);
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(630, 11, 125, 231);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\flecha-alt-circulo-derecha.png"));
		btnGuardar.setBounds(10, 15, 105, 43);
		panel_2.add(btnGuardar);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setForeground(Color.LIGHT_GRAY);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\capas.png"));
		btnEditar.setBounds(10, 69, 105, 43);
		panel_2.add(btnEditar);
		btnEditar.setForeground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEditar.setBackground(Color.DARK_GRAY);
		
		JButton btnBorrar = new JButton("Borrar");
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
		panel_3.setBounds(391, 11, 234, 174);
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
		txt2.setBounds(62, 49, 133, 20);
		panel_3.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(62, 77, 162, 20);
		panel_3.add(txt3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(10, 80, 46, 14);
		panel_3.add(lblNewLabel_1_1);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(62, 108, 162, 20);
		panel_3.add(txt4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo");
		lblNewLabel_1_2.setBounds(10, 111, 46, 14);
		panel_3.add(lblNewLabel_1_2);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(62, 139, 37, 20);
		panel_3.add(txt5);
		
		JLabel lblNewLabel_1_3 = new JLabel("Usuario");
		lblNewLabel_1_3.setBounds(10, 142, 89, 14);
		panel_3.add(lblNewLabel_1_3);
		
		JLabel ver = new JLabel("");
		ver.setBounds(199, 55, 25, 14);
		panel_3.add(ver);
		ver.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojo.png"));
		
		JLabel ocultar = new JLabel("");
		ocultar.setBounds(199, 55, 25, 14);
		panel_3.add(ocultar);
		ocultar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojos-cruzados.png"));
	}
}
