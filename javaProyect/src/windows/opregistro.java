package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class opregistro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JPasswordField txt4;
	JButton btnRegistro, btnLog, btnLimpiar;
	private JTextField txt3;
	JLabel ver, ocultar, Advertencia;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jesus\\Desktop\\cuatrimestre 3\\program 1\\img proyecto fina\\ingresar.png"));
		setTitle("Registrandose");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNewLabel_1.setBounds(15, 82, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(15, 116, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(43, 183, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		txt1 = new JTextField();
		txt1.setBounds(79, 79, 138, 23);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(79, 113, 138, 23);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt4 = new JPasswordField();
		txt4.setEchoChar('*');
		txt4.setBounds(120, 180, 97, 23);
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
		ver.setBounds(227, 189, 27, 14);
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
		ocultar.setBounds(227, 189, 27, 14);
		this.ocultar.setVisible(false);
		contentPane.add(ocultar);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(15, 150, 57, 14);
		contentPane.add(lblNewLabel_6);
		
		txt3 = new JTextField();
		txt3.setBounds(79, 147, 138, 23);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		 Advertencia = new JLabel("...");
		Advertencia.setBounds(15, 236, 245, 14);
		contentPane.add(Advertencia);
		
		btnLimpiar.addActionListener(this);
		btnLog.addActionListener(this);
		btnRegistro.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==btnLimpiar) {
		txt1.setText("");
		txt2.setText("");
		txt3.setText("");
		txt4.setText("");
		}else if(e.getSource()==btnRegistro) {
			String eeGmail = txt1.getText();		
			String eeuser = txt2.getText();
			String eenombre = txt3.getText();
			String eecontra = String.valueOf(txt4.getPassword());
			
			try {
		 		if(eeGmail == null || eeGmail.equals(eecontra) || eeGmail.equals(eeuser) || eeGmail.equals(eenombre)) {
		 			JOptionPane.showMessageDialog(null, "incorrecto");
		 			
		 		}else if(eeuser == null || eeuser.equals(eecontra) || eeuser.equals(eeGmail) || eeuser.equals(eenombre)) {
		 			JOptionPane.showMessageDialog(null, "incorrecto");
		 		}else if(eenombre == null || eenombre.equals(eecontra) || eenombre.equals(eeuser) || eenombre.equals(eeGmail)) {
		 			JOptionPane.showMessageDialog(null, "incorrecto");
		 		}else if(eecontra == null || eecontra.equals(eeGmail) || eecontra.equals(eeuser) || eecontra.equals(eenombre)) {
		 			JOptionPane.showMessageDialog(null, "incorrecto");
		 		}
		 			}catch(Exception a){
		 				a.printStackTrace();
		 				JOptionPane.showMessageDialog(null, "Error en el formulario.");
		 			}
			
			opPOO obj = new opPOO();
			
			if(opPOO.verificarUsuarioNuevo(eeuser)==-1) {
				obj.setGmail(eeGmail);
				obj.setNombre(eenombre);
				obj.setUser(eeuser);
				obj.setContra(eecontra);
				opList.agregar(obj);
				JOptionPane.showMessageDialog(null, "Se agrego usuario correctamente");
			}else {
				Advertencia.setText("[no se aceptan mismo user]");
				Advertencia.setForeground(Color.RED);
				JOptionPane.showMessageDialog(null, "Esta siendo usado este usuario");
			}
			
			
			
		}else if(e.getSource()==btnLog) {
			
			op abrir = new op();
			abrir.setVisible(true);
			
		}
	}
}
