package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import java.awt.Label;

public class VistaAdministrador extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JTextField txtDireccion;
	public JTextField txtUsuario;
	public JTextField textField_6;
	public JTable tbGestionarAdmin;
	public JPasswordField passContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdministrador frame = new VistaAdministrador();
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
	public VistaAdministrador() {
		setTitle("GESTIONAR ADMINISTRADOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear Administrador", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 601, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 25, 69, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(76, 22, 122, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 53, 46, 14);
		panel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(76, 50, 122, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefono:");
		lblNewLabel.setBounds(10, 84, 69, 14);
		panel.add(lblNewLabel);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(76, 81, 122, 20);
		panel.add(txtTelefono);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setBounds(239, 25, 69, 14);
		panel.add(lblNewLabel_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(331, 22, 122, 20);
		panel.add(txtDireccion);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(239, 53, 82, 14);
		panel.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(331, 50, 122, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(239, 84, 69, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnGuardar = new JButton("guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Guardar32.png")));
		btnGuardar.setBounds(10, 122, 130, 41);
		panel.add(btnGuardar);
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Modificar32.png")));
		btnModificar.setBounds(161, 122, 124, 40);
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Eliminar32.png")));
		btnEliminar.setBounds(313, 124, 122, 37);
		panel.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("limpiar");
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Limpiar32.png")));
		btnLimpiar.setBounds(459, 124, 114, 37);
		panel.add(btnLimpiar);
		
		passContrasena = new JPasswordField();
		passContrasena.setBounds(331, 81, 122, 20);
		panel.add(passContrasena);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Hombre64.png")));
		label.setBounds(492, 22, 64, 76);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Buscar por:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 255)));
		panel_1.setBounds(10, 195, 601, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rbCedula = new JRadioButton("Cedula");
		rbCedula.setBounds(17, 18, 69, 23);
		panel_1.add(rbCedula);
		
		JRadioButton rbNombre = new JRadioButton("Nombre");
		rbNombre.setBounds(97, 18, 94, 23);
		panel_1.add(rbNombre);
		
		textField_6 = new JTextField();
		textField_6.setBounds(17, 48, 187, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnBuscarAdmin = new JButton("buscar");
		btnBuscarAdmin.setBackground(Color.LIGHT_GRAY);
		btnBuscarAdmin.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Buscar32.png")));
		btnBuscarAdmin.setBounds(290, 35, 121, 34);
		panel_1.add(btnBuscarAdmin);
		
		JButton btnMostrarTodos = new JButton("mostrar todos");
		btnMostrarTodos.setBackground(Color.LIGHT_GRAY);
		btnMostrarTodos.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/BuscarTodo.png")));
		btnMostrarTodos.setBounds(421, 35, 159, 34);
		panel_1.add(btnMostrarTodos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 601, 80);
		contentPane.add(scrollPane);
		
		tbGestionarAdmin = new JTable();
		tbGestionarAdmin.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Cedula", "Telefono", "Direccion", "Usuario", "Contrase\u00F1a"
			}
		));
		scrollPane.setViewportView(tbGestionarAdmin);
	}
}
