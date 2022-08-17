package PF;

import java.awt.EventQueue;
import javax.swing.JFrame;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import PrErr.ParteRL.Conexion;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ParteRL_2 {

	private JFrame frame;
	private JTextField textF_Código;
	private JTextField textF_Nombre;
	private JTextField textF_Cantidad;
	private JTextField textF_Prov;
	private JTextField textF_Cat;
	private JTextField textF_Compra;
	private JTextField textF_Venta;
	private JTable table;
	
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

		public PreparedStatement PrepareStatement(String string) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	private void limpiar() {
		textF_Nombre.setText("");
		textF_Código.setText("");
		textF_Cantidad.setText("");
		textF_Prov.setText("");
		textF_Cat.setText("");
		textF_Compra.setText("");
		textF_Venta.setText("");
        
    }

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
	
	DefaultTableModel modelo = new DefaultTableModel();

	
	public ParteRL_2() {
		initialize();
		
		try {
            table.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "select Id, Código, Nombre, Cantidad, Proveedor, Categoría, Compra, Venta from r_producto";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Categoría");
            modelo.addColumn("Compra");
            modelo.addColumn("Venta");

            
            

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\carrito-de-compra-anadir.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 846, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmRegEmp = new JMenuItem("Registro de Empleados");
		menuBar.add(mntmRegEmp);
		
		JMenuItem mntmRegistroDeClientes = new JMenuItem("Registro de Clientes");
		menuBar.add(mntmRegistroDeClientes);
		
		JMenuItem mntmRegistroDeProductos = new JMenuItem("Registro de Productos");
		menuBar.add(mntmRegistroDeProductos);
		
		JMenuItem mntmVenta = new JMenuItem("Registro de Ventas");
		menuBar.add(mntmVenta);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		menuBar.add(mntmAyuda);
		
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
		panel_1.setBounds(10, 67, 181, 266);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Código");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 25, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textF_Código = new JTextField();
		textF_Código.setBounds(66, 25, 94, 20);
		panel_1.add(textF_Código);
		textF_Código.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre");
		lblNewLabel_2_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 53, 65, 14);
		panel_1.add(lblNewLabel_2_1);
		
		textF_Nombre = new JTextField();
		textF_Nombre.setColumns(10);
		textF_Nombre.setBounds(66, 53, 94, 20);
		panel_1.add(textF_Nombre);
		
		JLabel lblNewLabel_2_3 = new JLabel("Cantidad");
		lblNewLabel_2_3.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(10, 96, 65, 14);
		panel_1.add(lblNewLabel_2_3);
		
		textF_Cantidad = new JTextField();
		textF_Cantidad.setColumns(10);
		textF_Cantidad.setBounds(74, 96, 86, 20);
		panel_1.add(textF_Cantidad);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Proveedor");
		lblNewLabel_2_1_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 124, 71, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		textF_Prov = new JTextField();
		textF_Prov.setColumns(10);
		textF_Prov.setBounds(74, 124, 86, 20);
		panel_1.add(textF_Prov);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Categoría");
		lblNewLabel_2_2_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(10, 152, 65, 14);
		panel_1.add(lblNewLabel_2_2_1);
		
		textF_Cat = new JTextField();
		textF_Cat.setColumns(10);
		textF_Cat.setBounds(74, 152, 86, 20);
		panel_1.add(textF_Cat);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Compra");
		lblNewLabel_2_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 201, 58, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		textF_Compra = new JTextField();
		textF_Compra.setColumns(10);
		textF_Compra.setBounds(74, 201, 86, 20);
		panel_1.add(textF_Compra);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Venta");
		lblNewLabel_2_2_1_1.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblNewLabel_2_2_1_1.setBounds(10, 229, 65, 14);
		panel_1.add(lblNewLabel_2_2_1_1);
		
		textF_Venta = new JTextField();
		textF_Venta.setColumns(10);
		textF_Venta.setBounds(74, 229, 86, 20);
		panel_1.add(textF_Venta);
		
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
		panel_2.setBounds(201, 67, 479, 266);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 479, 266);
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

		                        
		            ps = con.prepareStatement("SELECT Código, Nombre, Cantidad, Proveedor, Categoría, Compra, Venta from r_producto WHERE Código = ?");
		            ps.setString(1, Código);
		            rs = ps.executeQuery();
		            
		            
		            while (rs.next()) {
		            	
			            textF_Código.setText(rs.getString("Código"));
			            textF_Nombre.setText(rs.getString("Nombre"));
			            textF_Cantidad.setText(rs.getString("Cantidad"));
			            textF_Prov.setText(rs.getString("Proveedor"));
			            textF_Cat.setText(rs.getString("Categoría"));
			            textF_Compra.setText(rs.getString("Compra"));
			            textF_Venta.setText(rs.getString("Venta"));

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
				"C\u00F3digo", "Nombre", "Proveedor", "Cantidad", "Categor\u00EDa", "Compra", "Venta"
			}
		));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(690, 67, 130, 265);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps = null;
		        try {
		            Conexion objCon = new Conexion();
		            Connection conn = objCon.getConexion();
		            ps = conn.prepareStatement("INSERT INTO r_producto ( Código, Nombre, Cantidad, Proveedor, Categoría, Compra, Venta) VALUES (?,?,?,?,?,?,?)");
		            ps.setString(1, textF_Código.getText());
		            ps.setString(2, textF_Nombre.getText());
		            ps.setString(3, textF_Cantidad.getText());
		            ps.setString(4, textF_Prov.getText());
		            ps.setString(5, textF_Cat.getText());
		            ps.setString(6, textF_Compra.getText());
		            ps.setString(7, textF_Venta.getText());

		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Producto Guardado");
		            Object[] fila = new Object[8];
		            fila[1] = textF_Código.getText();
		            fila[2] = textF_Nombre.getText();
		            fila[3] = textF_Cantidad.getText();
		            fila[4] = textF_Prov.getText();
		            fila[5] = textF_Cat.getText();
		            fila[6] = textF_Compra.getText();
		            fila[7] = textF_Venta.getText();
		             
		            modelo.addRow(fila);

		            limpiar();

		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
		            System.out.println(ex);
		        }
				
			}
		});
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\agregar-documento (1).png"));
		btnAgregar.setBounds(10, 20, 110, 38);
		panel_3.add(btnAgregar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String código = textF_Código.getText();
		        
		        try {
		            DefaultTableModel modelo = new DefaultTableModel();
		            table.setModel(modelo);

		            PreparedStatement ps = null;
		            ResultSet rs = null;
		            Conexion conn = new Conexion();
		            Connection con = conn.getConexion();

		            String sql = "SELECT Id, Código, Nombre, Cantidad, Proveedor, Categoría, Compra, Venta from r_producto WHERE Código = '"+código+"'";
		            System.out.println(sql);
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();

		            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
		            int cantidadColumnas = rsMd.getColumnCount();

		            modelo.addColumn("ID");
		            modelo.addColumn("Código");
		            modelo.addColumn("Nombre");
		            modelo.addColumn("Cantidad");
		            modelo.addColumn("Proveedor");
		            modelo.addColumn("Categoría");
		            modelo.addColumn("Compra");
		            modelo.addColumn("Venta");
        
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
		btnBuscar.setBounds(10, 69, 110, 38);
		panel_3.add(btnBuscar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int Fila = table.getSelectedRow();

				PreparedStatement ps = null;
		        try {
		            Conexion objCon = new Conexion();
		            Connection conn = objCon.getConexion();
		            ps = conn.prepareStatement("Update r_producto set Nombre=?, Cantidad=?, Proveedor=?, Categoría=?, Compra=?, Venta=? where Código= ?");
		            
		            ps.setString(7, textF_Código.getText());
		            ps.setString(1, textF_Nombre.getText());
		            ps.setString(2, textF_Cantidad.getText());
		            ps.setString(3, textF_Prov.getText());
		            ps.setString(4, textF_Cat.getText());
		            ps.setString(5, textF_Compra.getText());
		            ps.setString(6, textF_Venta.getText());		            
		            

		            ps.execute();

		            JOptionPane.showMessageDialog(null, "Producto Modificado");
		            
		            table.setValueAt(textF_Código.getText(), Fila, 1);
		            table.setValueAt(textF_Nombre.getText(), Fila, 2);
		            table.setValueAt(textF_Cantidad.getText(), Fila, 3);
		            table.setValueAt(textF_Prov.getText(), Fila, 4);
		            table.setValueAt(textF_Cat.getText(), Fila, 5);
		            table.setValueAt(textF_Compra.getText(), Fila, 6);
		            table.setValueAt(textF_Venta.getText(), Fila, 7);
		            
		            limpiar();

		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
		            System.out.println(ex);
		        }
			}
		});
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\capas.png"));
		btnEditar.setBounds(10, 118, 110, 38);
		panel_3.add(btnEditar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps = null;
				
				try {
					Conexion objCon = new Conexion();
		            Connection conn = objCon.getConexion();
		            
		            int Fila = table.getSelectedRow();
					String Código = table.getValueAt(Fila,1).toString();
					String Nombre = table.getValueAt(Fila,2).toString();

					
		            ps = conn.prepareStatement("Delete from r_producto where Código= ? or Nombre= ?");
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
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\eliminar-documento.png"));
		btnBorrar.setBounds(10, 167, 110, 38);
		panel_3.add(btnBorrar);
		
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

		            String sql = "SELECT * from r_producto ";
		            System.out.println(sql);
		            ps = con.prepareStatement(sql);
		            rs = ps.executeQuery();

		            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
		            int cantidadColumnas = rsMd.getColumnCount();

		            modelo.addColumn("ID");
		            modelo.addColumn("Código");
		            modelo.addColumn("Nombre");
		            modelo.addColumn("Cantidad");
		            modelo.addColumn("Proveedor");
		            modelo.addColumn("Categoría");
		            modelo.addColumn("Compra");
		            modelo.addColumn("Venta");
        
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
		btnVolver.setBounds(10, 216, 110, 38);
		panel_3.add(btnVolver);
	}
}