package windows.jesus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import POO.sqlUsuarios;
import hash.jesus.hash;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class op extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt1;
		
	JButton btnLimpiar, btnAceptar, btnRegistrarse;
	private JPasswordField txt2;
	JLabel ver, ocultar;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public op() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				app.frmLogin = null;// sirve para cuando uno cierre la ventana, y le des al boton de nuevo aparezca, por default se pone null y no habre
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\login.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(this);
		
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
		separator.setBounds(171, 44, 13, 206);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(35, 154, 96, 96);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\login-arrow-symbol-entering-back-into-a-square_icon-icons.com_73221.png"));
		
		 btnLimpiar = new JButton("Limpiar");
		 btnLimpiar.setForeground(Color.LIGHT_GRAY);
		 btnLimpiar.setBackground(Color.DARK_GRAY);
		 btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnLimpiar.setBounds(311, 201, 113, 49);
		contentPane.add(btnLimpiar);
		
		 btnAceptar = new JButton("Aceptar");
		 btnAceptar.setForeground(Color.LIGHT_GRAY);
		 btnAceptar.setBackground(Color.DARK_GRAY);
		 btnAceptar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\flecha-alt-circulo-derecha.png"));
		btnAceptar.setBounds(311, 141, 113, 49);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\logo.png"));
		lblNewLabel_4.setBounds(15, 44, 128, 96);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "sing", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_1.setBounds(179, 44, 245, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txt2 = new JPasswordField();
		txt2.setBounds(87, 55, 107, 23);
		panel_1.add(txt2);
		
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
		
		 ver = new JLabel("");
		ver.setBounds(204, 64, 31, 14);
		ver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ver.setVisible(false);
				ocultar.setVisible(true);
				txt2.setEchoChar((char)0);
			}
		});
		panel_1.add(ver);
		ver.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojo.png"));
		
		 ocultar = new JLabel("");
		ocultar.setBounds(204, 64, 31, 14);
		 ocultar.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		ver.setVisible(true);
					ocultar.setVisible(false);
					txt2.setEchoChar('*');
			 	}
			 });
		this.ocultar.setVisible(false);
		panel_1.add(ocultar);
		ocultar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojos-cruzados.png"));
		
		 btnRegistrarse = new JButton("Registrate");
		
		btnRegistrarse.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ingresar.png"));
		btnRegistrarse.setForeground(Color.LIGHT_GRAY);
		btnRegistrarse.setBackground(Color.DARK_GRAY);
		btnRegistrarse.setBounds(179, 215, 122, 35);
		contentPane.add(btnRegistrarse);
		
		btnLimpiar.addActionListener(this);
		btnAceptar.addActionListener(this);
		btnRegistrarse.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLimpiar) {
			txt1.setText("");
			txt2.setText("");
		}else if(e.getSource()==btnAceptar) {
			String eeuser = txt1.getText();
			String eecontra = String.valueOf(txt2.getPassword());
			
			sqlUsuarios modSql = new sqlUsuarios();
			opPOO obj = new opPOO();
			
			Date date = new Date();
			DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(!eeuser.equals("") && !eecontra.equals("")) {
				
				String passCifrado = hash.sha1(eecontra);
				
				obj.setUser(eeuser);
				obj.setContra(passCifrado);
				obj.setLast_session(fechaHora.format(date));
				
					
						if(modSql.Login(obj)) {
							app.frmLogin = null;// para que no se habra muchas veces en el boton del login
							this.dispose();
							
							ap abrir = new ap(obj);//aqui se habre el registro de empleado
							abrir.setVisible(true);
							
						}else {
							JOptionPane.showMessageDialog(null,"contaseña incorrecta o usuario");
							txt2.setText("");
						}

			}else {
				JOptionPane.showMessageDialog(null,"debe ingresar sus datos");
			}
		}else if(e.getSource()==btnRegistrarse) {
			
			opregistro abrir = new opregistro();
			abrir.setVisible(true);
			this.dispose();
		}
	}
}
