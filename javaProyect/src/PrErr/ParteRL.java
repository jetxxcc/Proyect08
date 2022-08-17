package PrErr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

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

import PrErr.ParteRL_2.Conexion;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenuItem;

public class ParteRL {

	private JFrame frame;
	private JTable table;
	private JTextField textf_codigo;
	private JTextField textField_Nombre;
	private JTextField textField_Ced;
	private JTextField textF_Tel;
	private JTextField textF_Est;
	private JTextField textField_Dic;
	
	public class Conexion {
	    
	    private final String base = "profin";
	    private final String user = "root";
	    private final String password = "";
	    private final String url = "jdbc:mysql://localhost:3306/" + base;
	    private Connection con = null;
	    
	    public Connection getConexion()
	    {
	        
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
	            
	        } catch(SQLException e)
	        {
	            System.err.println(e);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
	      return con;  
	    }

	}
	
	private void limpiar() {
		textField_Nombre.setText("");
		textf_codigo.setText("");
		textField_Ced.setText("");
		textF_Tel.setText("");
		textField_Dic.setText("");
		textF_Est.setText("");
        
    }
	

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
	DefaultTableModel modelo = new DefaultTableModel();

	public ParteRL() {
		initialize();
		
		try {
            table.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT id,Código, Nombre, Cédula, Teléfono,Dirección,Estado,Ingreso FROM r_cliente";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cédula");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Dirección");
            modelo.addColumn("Estado");
            modelo.addColumn("Ingreso");

            
            

            int[] anchos = {25,50,50,50,50,70,50,50};
            for (int i = 0; i < table.getColumnCount(); i++) {
            	table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\usuarios-alt (1).png"));
		frame.setBounds(100, 100, 920, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro de Empleados");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmRegistroDeClientes = new JMenuItem("Registro de Clientes");
		menuBar.add(mntmRegistroDeClientes);
		
		JMenuItem mntmRegistroDeProductos = new JMenuItem("Registro de Productos");
		menuBar.add(mntmRegistroDeProductos);
		
		JMenuItem mntmRegistroDeVentas = new JMenuItem("Registro de Ventas");
		menuBar.add(mntmRegistroDeVentas);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		menuBar.add(mntmAyuda);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 904, 49);
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\usuarios-alt.png"));
		lblNewLabel.setBounds(0, 74, 309, -63);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Registro de Clientes");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(396, 11, 145, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\usuarios-alt (1).png"));
		lblNewLabel_3_1.setBounds(362, 13, 24, 24);
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
		lblNewLabel_1_2.setBounds(10, 96, 124, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_Tel = new JLabel("Teléfono");
		lblNewLabel_Tel.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_Tel.setBounds(10, 126, 124, 14);
		panel_1.add(lblNewLabel_Tel);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Dirección ");
		lblNewLabel_1_2_2.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_2_2.setBounds(10, 164, 124, 14);
		panel_1.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_Es = new JLabel("Estado");
		lblNewLabel_Es.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_Es.setBounds(10, 195, 124, 14);
		panel_1.add(lblNewLabel_Es);
		
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
		textField_Ced.setBounds(85, 96, 132, 20);
		panel_1.add(textField_Ced);
		
		textF_Tel = new JTextField();
		textF_Tel.setColumns(10);
		textF_Tel.setBounds(85, 124, 132, 20);
		panel_1.add(textF_Tel);
		
		textF_Est = new JTextField();
		textF_Est.setColumns(10);
		textF_Est.setBounds(85, 195, 132, 20);
		panel_1.add(textF_Est);
		
		textField_Dic = new JTextField();
		textField_Dic.setColumns(10);
		textField_Dic.setBounds(85, 164, 132, 20);
		panel_1.add(textField_Dic);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(247, 60, 502, 239);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 502, 239);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PreparedStatement ps = null;
	            ResultSet rs = null;
				
				try {
		            
		            Conexion conn = new Conexion();
		            java.sql.Connection con = conn.getConexion();
		            
		            int Fila = table.getSelectedRow();
		            String Código = table.getValueAt(Fila,1).toString();

		                        
		            ps = con.prepareStatement("SELECT Código, Nombre, Cédula, Teléfono,Dirección,Estado from r_cliente WHERE Código = ?");
		            ps.setString(1, Código);
		            rs = ps.executeQuery();
		            
		            
		            while (rs.next()) {
		            	
		            	textf_codigo.setText(rs.getString("Código"));
		            	textField_Nombre.setText(rs.getString("Nombre"));
		            	textField_Ced.setText(rs.getString("Cédula"));
		            	textF_Tel.setText(rs.getString("Teléfono"));
		            	textField_Dic.setText(rs.getString("Dirección"));
		            	textF_Est.setText(rs.getString("Estado"));

		            }
          
			} catch (SQLException ex) {
	            System.out.println(ex.toString());
	        }
				
			}
		});
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
		panel_3.setBounds(759, 60, 135, 239);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		
		JButton btnGuardar = new JButton("Guardar\r\n");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PreparedStatement ps = null;
		        try {
		            Conexion objCon = new Conexion();
		            Connection conn = objCon.getConexion();
		            ps = conn.prepareStatement("INSERT INTO r_cliente (Código, Nombre, Cédula, Teléfono,Dirección,Estado) VALUES (?,?,?,?,?,?)");
		            ps.setString(1, textf_codigo.getText());
		            ps.setString(2, textField_Nombre.getText());
		            ps.setString(3, textField_Ced.getText());
		            ps.setString(4, textF_Tel.getText());
		            ps.setString(5, textField_Dic.getText());
		            ps.setString(6, textF_Est.getText());

		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Producto Guardado");
		            Object[] fila = new Object[7];
		            fila[1] = textf_codigo.getText();
		            fila[2] = textField_Nombre.getText();
		            fila[3] = textField_Ced.getText();
		            fila[4] = textF_Tel.getText();
		            fila[5] = textField_Dic.getText();
		            fila[6] = textF_Est.getText();
		            modelo.addRow(fila);

		            limpiar();

		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
		            System.out.println(ex);
		        }
				
			}
			
			
		});
		
		
		
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setBounds(10, 23, 115, 33);
		panel_3.add(btnGuardar);
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\agregar-documento (1).png"));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String código = textf_codigo.getText();
		        
		        try {
		            DefaultTableModel modelo = new DefaultTableModel();
		            table.setModel(modelo);

		            PreparedStatement ps = null;
		            ResultSet rs = null;
		            Conexion conn = new Conexion();
		            Connection con = conn.getConexion();

		            String sql = "SELECT Id, Código, Nombre, Cédula, Teléfono, Dirección, Estado from r_cliente WHERE Código = '"+código+"'";
		            System.out.println(sql);
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();

		            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
		            int cantidadColumnas = rsMd.getColumnCount();

		            modelo.addColumn("Id");
		            modelo.addColumn("Código");
		            modelo.addColumn("Nombre");
		            modelo.addColumn("Cédula");
		            modelo.addColumn("Teléfono");
		            modelo.addColumn("Dirección");
		            modelo.addColumn("Estado");
		            modelo.addColumn("Ingreso");
        
		            int[] anchos = {25,50,50,50,50,70,50,50};
		            for (int i = 0; i < table.getColumnCount(); i++) {
		            	table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		            }

		            while (rs.next()) {
		                Object[] filas = new Object[cantidadColumnas];
		                for (int i = 0; i < cantidadColumnas; i++) {
		                    filas[i] = rs.getObject(i + 1);
		                }
		                modelo.addRow(filas);
		            }

		        } catch (Exception ex) {
		            System.err.println(ex.toString());
		        
				}
				
			}
		});
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\buscar-alt.png"));
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setBounds(10, 67, 115, 33);
		panel_3.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\eliminar-documento.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps = null;
				
				try {
					Conexion objCon = new Conexion();
		            Connection conn = objCon.getConexion();
		            
		            int Fila = table.getSelectedRow();
					String Código = table.getValueAt(Fila,1).toString();
					String Nombre = table.getValueAt(Fila,2).toString();

					
		            ps = conn.prepareStatement("Delete from r_cliente where Código= ? or Nombre= ?");
		            ps.setString(1,Código);
		            ps.setString(2,Nombre);
		            ps.execute();
		            limpiar();
					
		            modelo.removeRow(Fila);
		            JOptionPane.showMessageDialog(null, "Producto Eliminado");

				
				} catch (SQLException L) {
					JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
		            System.out.println(L);
				}
			}
		});
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setBounds(10, 155, 115, 33);
		panel_3.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int Fila = table.getSelectedRow();

				PreparedStatement ps = null;
		        try {
		            Conexion objCon = new Conexion();
		            Connection conn = objCon.getConexion();
		            ps = conn.prepareStatement("Update r_cliente set Nombre= ?, Cédula= ?, Teléfono= ?, Dirección= ?, Estado= ? where Código= ?");
		            
		            ps.setString(6, textf_codigo.getText());
		            ps.setString(1, textField_Nombre.getText());
		            ps.setString(2, textField_Ced.getText());
		            ps.setString(3, textF_Tel.getText());
		            ps.setString(4, textField_Dic.getText());
		            ps.setString(5, textF_Est.getText());
		            

		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Producto Modificado");
		            
		            table.setValueAt(textf_codigo.getText(), Fila, 1);
		            table.setValueAt(textField_Nombre.getText(), Fila, 2);
		            table.setValueAt(textField_Ced.getText(), Fila, 3);
		            table.setValueAt(textF_Tel.getText(), Fila, 4);
		            table.setValueAt(textField_Dic.getText(), Fila, 5);
		            table.setValueAt(textF_Est.getText(), Fila, 6);
		            
		            limpiar();

		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
		            System.out.println(ex);
		        }
				
			}
			
				

		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\capas.png"));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setBounds(10, 111, 115, 33);
		panel_3.add(btnEditar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        
		        try {
		            DefaultTableModel modelo = new DefaultTableModel();
		            table.setModel(modelo);

		            PreparedStatement ps = null;
		            ResultSet rs = null;
		            Conexion conn = new Conexion();
		            Connection con = conn.getConexion();

		            String sql = "SELECT * from r_cliente ";
		            System.out.println(sql);
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();

		            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
		            int cantidadColumnas = rsMd.getColumnCount();

		            modelo.addColumn("Id");
		            modelo.addColumn("Código");
		            modelo.addColumn("Nombre");
		            modelo.addColumn("Cédula");
		            modelo.addColumn("Teléfono");
		            modelo.addColumn("Dirección");
		            modelo.addColumn("Estado");
		            modelo.addColumn("Ingreso");
        
		            int[] anchos = {25,50,50,50,50,70,50,50};
		            for (int i = 0; i < table.getColumnCount(); i++) {
		            	table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		            }

		            while (rs.next()) {
		                Object[] filas = new Object[cantidadColumnas];
		                for (int i = 0; i < cantidadColumnas; i++) {
		                    filas[i] = rs.getObject(i + 1);
		                }
		                modelo.addRow(filas);
		            }

		        } catch (Exception ex) {
		            System.err.println(ex.toString());
		        
				}
			}
		});
		btnVolver.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\deshacer.png"));
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.setBounds(10, 195, 115, 33);
		panel_3.add(btnVolver);
	}
}