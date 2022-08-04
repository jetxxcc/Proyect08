package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class op extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt1;
		
	JButton btnLimpiar, btnAceptar;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					op frame = new op();
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
	public op() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\login.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		panel.setBounds(5, 5, 424, 28);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(209, 44, 13, 206);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(59, 154, 96, 96);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\login-arrow-symbol-entering-back-into-a-square_icon-icons.com_73221.png"));
		
		 btnLimpiar = new JButton("Limpiar");
		 btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnLimpiar.setBounds(298, 141, 107, 49);
		contentPane.add(btnLimpiar);
		
		 btnAceptar = new JButton("Aceptar");
		 btnAceptar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\flecha-alt-circulo-derecha.png"));
		btnAceptar.setBounds(298, 201, 107, 49);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\logo.png"));
		lblNewLabel_4.setBounds(39, 44, 128, 96);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "Registrese", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		panel_1.setBounds(220, 44, 204, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 55, 107, 23);
		panel_1.add(passwordField);
		
		txt1 = new JTextField();
		txt1.setBounds(87, 21, 107, 23);
		panel_1.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(10, 58, 72, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(10, 20, 46, 14);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLimpiar) {
			
		}else if(e.getSource()==btnAceptar) {
			
		}
	}
}
