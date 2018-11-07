package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorPagoCredito;
import modelo.adapter.CreditoAdaptee;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPagoCredito extends JFrame {

	public JPanel contentPane;
	public JTextField txtTarjetaCredito;
	public JPasswordField passClaveCredito;
	public JButton btnPagarCredito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPagoCredito frame = new VistaPagoCredito();
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
	public VistaPagoCredito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 198);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBorder(new TitledBorder(null, "Pago Credito", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 11, 548, 134);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumeroDeTarjeta = new JLabel("Numero de Tarjeta:");
		lblNumeroDeTarjeta.setBounds(25, 27, 117, 14);
		panel.add(lblNumeroDeTarjeta);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(36, 72, 68, 14);
		panel.add(lblClave);
		
		txtTarjetaCredito = new JTextField();
		txtTarjetaCredito.setBounds(146, 24, 153, 20);
		panel.add(txtTarjetaCredito);
		txtTarjetaCredito.setColumns(10);
		
		passClaveCredito = new JPasswordField();
		passClaveCredito.setBounds(146, 69, 153, 20);
		panel.add(passClaveCredito);
		
		btnPagarCredito = new JButton("pagar");
		btnPagarCredito.setIcon(new ImageIcon(VistaPagoCredito.class.getResource("/iconos/Moneda (2).png")));
		btnPagarCredito.setBounds(365, 72, 153, 41);
		btnPagarCredito.addActionListener(new ControladorPagoCredito(this));
		panel.add(btnPagarCredito);
	}

	

	
	
}
