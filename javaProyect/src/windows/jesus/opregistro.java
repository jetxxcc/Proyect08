package windows.jesus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POO.sqlUsuarios;
import hash.jesus.hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class opregistro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JPasswordField txt4;
	JButton btnRegistro, btnLog, btnLimpiar;
	private JTextField txt3;
	JLabel ver, ocultar, Advertencia, ocultar1, ver1;
	private JPasswordField txt5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opregistro frame = new opregistro();
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
	public opregistro() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				app.frmRegis = null;
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ingresar.png"));
		setTitle("Registrandose");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(this);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 27);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gmail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(13, 56, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(13, 90, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(41, 157, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		txt1 = new JTextField();
		txt1.setBounds(77, 53, 138, 23);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(77, 87, 138, 23);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt4 = new JPasswordField();
		txt4.setEchoChar('*');
		txt4.setBounds(118, 154, 97, 23);
		contentPane.add(txt4);
		
		 btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.DARK_GRAY);
		btnLimpiar.setForeground(Color.LIGHT_GRAY);
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\escoba.png"));
		btnLimpiar.setBounds(286, 132, 138, 40);
		contentPane.add(btnLimpiar);
		
		 btnRegistro = new JButton("Registrase");
		btnRegistro.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\controlar.png"));
		btnRegistro.setBackground(Color.DARK_GRAY);
		btnRegistro.setForeground(Color.LIGHT_GRAY);
		btnRegistro.setBounds(286, 82, 138, 40);
		contentPane.add(btnRegistro);
		
		 btnLog = new JButton("Logearme");
		btnLog.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ingresar44.png"));
		btnLog.setForeground(Color.LIGHT_GRAY);
		btnLog.setBackground(Color.DARK_GRAY);
		btnLog.setBounds(286, 183, 138, 40);
		contentPane.add(btnLog);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(270, 43, 10, 207);
		contentPane.add(separator);
		
		 ver = new JLabel("");
		ver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ver.setVisible(false);
				ocultar.setVisible(true);
				txt4.setEchoChar((char)0);
			}
		});
		ver.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojo.png"));
		ver.setBounds(225, 163, 27, 14);
		contentPane.add(ver);
		
		 ocultar = new JLabel("");
		 ocultar.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		ver.setVisible(true);
				ocultar.setVisible(false);
				txt4.setEchoChar('*');
		 	}
		 });
		ocultar.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojos-cruzados.png"));
		ocultar.setBounds(225, 163, 27, 14);
		this.ocultar.setVisible(false);
		contentPane.add(ocultar);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(13, 124, 57, 14);
		contentPane.add(lblNewLabel_6);
		
		txt3 = new JTextField();
		txt3.setBounds(77, 121, 138, 23);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		 Advertencia = new JLabel("<html>...</html>");
		Advertencia.setBounds(15, 223, 245, 38);
		contentPane.add(Advertencia);
		
		JLabel lblNewLabel_4 = new JLabel("<html>Confirmar contraseña</html>");
		lblNewLabel_4.setBounds(41, 182, 67, 36);
		contentPane.add(lblNewLabel_4);
		
		txt5 = new JPasswordField();
		txt5.setEchoChar('*');
		txt5.setBounds(118, 193, 97, 23);
		contentPane.add(txt5);
		
		 ver1 = new JLabel("");
		 ver1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					ver1.setVisible(false);
					ocultar1.setVisible(true);
					txt5.setEchoChar((char)0);
				}
			});
		ver1.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojo.png"));
		ver1.setBounds(225, 204, 27, 14);
		contentPane.add(ver1);
		
		ocultar1 = new JLabel("");
		ocultar1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		ver1.setVisible(true);
				ocultar1.setVisible(false);
				txt5.setEchoChar('*');
		 	}
		 });
		ocultar1.setIcon(new ImageIcon("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ojos-cruzados.png"));
		ocultar1.setBounds(225, 204, 27, 14);
		this.ocultar1.setVisible(false);
		contentPane.add(ocultar1);
		
		btnLimpiar.addActionListener(this);
		btnLog.addActionListener(this);
		btnRegistro.addActionListener(this);
	}
	
	private void limpiarRegistro() {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==btnLimpiar) {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		txt5.setText("");
		}else if(e.getSource()==btnRegistro) {
			String eeGmail = txt1.getText();		
			String eeuser = txt2.getText();
			String eenombre = txt3.getText();
			String eecontra = String.valueOf(txt4.getPassword());
			String eecontraConfirm = String.valueOf(txt5.getPassword());
			
			
			if(eeGmail.equals("") || eecontra.equals("") || eeuser.equals("") || eenombre.equals("") || eecontraConfirm.equals("")) {
				
	 			JOptionPane.showMessageDialog(null, "hay celdas vacias, complete las celdas!");
	 			
			}else {
				
			if(eeGmail == null || eeGmail.equals(eecontra) || eeGmail.equals(eeuser) || eeGmail.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 			
	 		}else if(eeuser == null || eeuser.equals(eecontra) || eeuser.equals(eeGmail) || eeuser.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}else if(eenombre == null || eenombre.equals(eecontra) || eenombre.equals(eeuser) || eenombre.equals(eeGmail)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}else if(eecontra == null || eecontra.equals(eeGmail) || eecontra.equals(eeuser) || eecontra.equals(eenombre)) {
	 			JOptionPane.showMessageDialog(null, "incorrecto");
	 		}
			
			opPOO obj = new opPOO();

			//conexion a base de datos de registro
			
			sqlUsuarios modSql = new sqlUsuarios();
				
			if(eecontra.equals(eecontraConfirm)) {
				
				if(modSql.verificarUsuarioExistente(eeuser)==0) {
					
					if(modSql.verificarGmailExistente(eeGmail)==0) {
					
						if(modSql.esEmail(eeGmail)) {
						
					
					String newpass = hash.sha1(eecontra);
					
					
								obj.setGmail(eeGmail);
								obj.setNombre(eenombre);
								obj.setUser(eeuser);
								obj.setContra(newpass);
								obj.setId_tipo(1);
					
																			if(modSql.registrar(obj)) {
																				JOptionPane.showMessageDialog(null, "Se agrego usuario correctamente!");
																				limpiarRegistro();
																				Advertencia.setText("");
																			}else {
																//por si da error la conexion de la base de dato u otra cosa, esto no indentifica para eso
																				JOptionPane.showMessageDialog(null, "No se puedo guardar, hubo un error.");
																			}
																	}else {
																		Advertencia.setText("<html>[la celda de gmail no esta bien, posiblemente no colocaste bien el email, verifica...]</html>");
																		Advertencia.setForeground(Color.RED);
																		JOptionPane.showMessageDialog(null, "Error en el gmail");
																	}//cierre del if verificacion de gmail esta bien puesto @gmail o @hotmail
													}else {
														Advertencia.setText("<html>[no se aceptan mismo gmail, verifica si esta bien puesto...]</html>");
														Advertencia.setForeground(Color.RED);
														JOptionPane.showMessageDialog(null, "Esta siendo usado este gmail");
													}
										}else{
											Advertencia.setText("<html>[no se aceptan mismo usuario, verifica uno si esta bien puesto...]</html>");
											Advertencia.setForeground(Color.RED);
											JOptionPane.showMessageDialog(null, "Esta siendo usado este usuario");
										}//cierre del if verificacion de user
				
				
				
						}else {
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
							}//cierre de if de validacion de contraseñas
		
			}//cierre de if validacion si hay celdas
			
			
			
		}else if(e.getSource()==btnLog) {
			
			op abrir = new op();
			abrir.setVisible(true);
			this.dispose();
			
			
		}

	}
}
