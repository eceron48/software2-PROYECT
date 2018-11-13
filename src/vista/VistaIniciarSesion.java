package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorLogin;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaIniciarSesion extends JFrame {

	public JPanel contentPane;
	public JTextField txtUsuario;
	public JPasswordField txtPassword;
	public JButton btnAceptar;
	public JButton btnCancelar;
	public JComboBox cbxLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaIniciarSesion frame = new VistaIniciarSesion();
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
	public VistaIniciarSesion() {
		setTitle("INICIAR SESION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaIniciarSesion.class.getResource("/iconos/InciarSesion64.png")));
		lblNewLabel.setBounds(41, 21, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(126, 36, 71, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(213, 33, 113, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(115, 78, 82, 14);
		contentPane.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(213, 75, 113, 20);
		contentPane.add(txtPassword);
		
		btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(new ControladorLogin(this));
		btnAceptar.setIcon(new ImageIcon(VistaIniciarSesion.class.getResource("/iconos/Aceptar32.png")));
		btnAceptar.setBounds(66, 122, 141, 41);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("cancelar");
		btnCancelar.addActionListener(new ControladorLogin(this));
		btnCancelar.setIcon(new ImageIcon(VistaIniciarSesion.class.getResource("/iconos/Cancel32.png")));
		btnCancelar.setBounds(259, 122, 157, 41);
		contentPane.add(btnCancelar);
		
		cbxLogin = new JComboBox();
		cbxLogin.setModel(new DefaultComboBoxModel(new String[] {"ingresar como", "SAdmin", "Administrador"}));
		cbxLogin.setBounds(343, 21, 113, 22);
		contentPane.add(cbxLogin);
	}
	
}
