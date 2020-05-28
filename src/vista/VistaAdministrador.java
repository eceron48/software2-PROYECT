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

import controlador.ControladorAdministrador;

import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ScrollPaneConstants;

public class VistaAdministrador extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JTextField txtUsuario;
	public JTextField txtBuscar;
	public JTable tbGestionarAdmin;
	public JPasswordField passContrasena;
	public JButton btnGuardar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnBuscarAdmin;
	public JButton btnMostrarTodos;
	public JRadioButton rbNombre;
	public JRadioButton rbCedula;
	public DefaultTableModel tbadmin;
	public final ButtonGroup buttonGroup = new ButtonGroup();

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
		setBounds(100, 100, 634, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear Administrador",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
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
		txtTelefono.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9')
					e.consume();

			}
		});
		panel.add(txtTelefono);

		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(242, 25, 82, 14);
		panel.add(lblNewLabel_2);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(331, 22, 122, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(242, 53, 69, 14);
		panel.add(lblNewLabel_3);

		btnGuardar = new JButton("guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.addActionListener(new ControladorAdministrador(this));
		btnGuardar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Guardar32.png")));
		btnGuardar.setBounds(10, 122, 130, 41);
		panel.add(btnGuardar);

		btnModificar = new JButton("modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.addActionListener(new ControladorAdministrador(this));
		btnModificar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Modificar32.png")));
		btnModificar.setBounds(200, 122, 124, 40);
		panel.add(btnModificar);

		btnEliminar = new JButton("eliminar");
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.addActionListener(new ControladorAdministrador(this));
		btnEliminar.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Eliminar32.png")));
		btnEliminar.setBounds(369, 124, 122, 37);
		panel.add(btnEliminar);

		passContrasena = new JPasswordField();
		passContrasena.setBounds(331, 50, 122, 20);
		panel.add(passContrasena);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Hombre64.png")));
		label.setBounds(492, 22, 64, 76);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Buscar por:", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 51, 255)));
		panel_1.setBounds(10, 195, 601, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		rbCedula = new JRadioButton("Cedula");
		rbCedula.addActionListener(new ControladorAdministrador(this));
		buttonGroup.add(rbCedula);
		rbCedula.setBounds(17, 18, 69, 23);
		panel_1.add(rbCedula);

		rbNombre = new JRadioButton("Nombre");
		rbNombre.addActionListener(new ControladorAdministrador(this));
		buttonGroup.add(rbNombre);
		rbNombre.setBounds(100, 18, 94, 23);
		panel_1.add(rbNombre);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(17, 48, 187, 20);
		panel_1.add(txtBuscar);
		txtBuscar.setColumns(10);

		btnBuscarAdmin = new JButton("buscar");
		btnBuscarAdmin.setBackground(Color.LIGHT_GRAY);
		btnBuscarAdmin.addActionListener(new ControladorAdministrador(this));
		btnBuscarAdmin.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/Buscar32.png")));
		btnBuscarAdmin.setBounds(290, 35, 121, 34);
		panel_1.add(btnBuscarAdmin);

		btnMostrarTodos = new JButton("mostrar todos");
		btnMostrarTodos.setBackground(Color.LIGHT_GRAY);
		btnMostrarTodos.addActionListener(new ControladorAdministrador(this));
		btnMostrarTodos.setIcon(new ImageIcon(VistaAdministrador.class.getResource("/iconos/BuscarTodo.png")));
		btnMostrarTodos.setBounds(421, 35, 159, 34);
		panel_1.add(btnMostrarTodos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 282, 601, 108);
		contentPane.add(scrollPane);

		tbGestionarAdmin = new JTable();
		tbadmin = new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "IDResidente", "Cedula", "nombre", "Telefono", "Usuario", "Contrase\u00F1a" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbGestionarAdmin.setModel(tbadmin);
		scrollPane.setViewportView(tbGestionarAdmin);
	}

}