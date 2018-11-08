package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.ControladorPagoDebito;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VistaPagoDebito extends JFrame {

	private JPanel contentPane;
	public JTextField txtTarjetaDebito;
	public JPasswordField passClaveDebito;
	public JButton btnPagarDebito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPagoDebito frame = new VistaPagoDebito();
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
	public VistaPagoDebito() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 206);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBorder(new TitledBorder(null, "Pago Debito", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 539, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumeroTarjeta = new JLabel("Numero Tarjeta:");
		lblNumeroTarjeta.setBounds(31, 33, 111, 14);
		panel.add(lblNumeroTarjeta);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(31, 74, 82, 14);
		panel.add(lblClave);
		
		txtTarjetaDebito = new JTextField();
		txtTarjetaDebito.setBounds(130, 30, 168, 20);
		panel.add(txtTarjetaDebito);
		txtTarjetaDebito.setColumns(10);
		
		passClaveDebito = new JPasswordField();
		passClaveDebito.setBounds(130, 71, 168, 20);
		panel.add(passClaveDebito);
		
		btnPagarDebito = new JButton("pagar");
		btnPagarDebito.setIcon(new ImageIcon(VistaPagoDebito.class.getResource("/iconos/Pago.png")));
		btnPagarDebito.setBounds(356, 74, 151, 52);
		btnPagarDebito.addActionListener(new ControladorPagoDebito(this));
		panel.add(btnPagarDebito);
	}
	
}
