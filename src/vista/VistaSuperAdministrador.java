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

import controlador.ControladorSuperAdministrador;

import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaSuperAdministrador extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JPasswordField passContrasena;
	public JButton btnModificar;
	public JButton btnmostrar;
	public JPasswordField passUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSuperAdministrador frame = new VistaSuperAdministrador();
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
	public VistaSuperAdministrador() {
		setTitle("GESTIONAR SUPERADMINISTRADOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear Super Administrador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
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
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(241, 25, 69, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setBounds(241, 53, 82, 14);
		panel.add(lblNewLabel_3);
		
		btnModificar = new JButton("modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setIcon(new ImageIcon(VistaSuperAdministrador.class.getResource("/iconos/Modificar32.png")));
		btnModificar.addActionListener(new ControladorSuperAdministrador(this));
		btnModificar.setBounds(30, 122, 124, 40);
		panel.add(btnModificar);
		
		passContrasena = new JPasswordField();
		passContrasena.setBounds(333, 50, 122, 20);
		panel.add(passContrasena);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VistaSuperAdministrador.class.getResource("/iconos/Hombre64.png")));
		label.setBounds(492, 22, 64, 76);
		panel.add(label);
		
		btnmostrar = new JButton("mostrar");
		btnmostrar.setBounds(177, 125, 121, 34);
		panel.add(btnmostrar);
		btnmostrar.addActionListener(new ControladorSuperAdministrador(this));
		btnmostrar.setBackground(Color.LIGHT_GRAY);
		btnmostrar.setIcon(new ImageIcon(VistaSuperAdministrador.class.getResource("/iconos/Buscar32.png")));
		
		
		passUser = new JPasswordField();
		passUser.setBounds(333, 22, 122, 20);
		panel.add(passUser);
	}

}
