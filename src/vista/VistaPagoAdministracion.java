package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class VistaPagoAdministracion extends JFrame {

	public JPanel contentPane;
	public JTextField txtCedula;
	public JTextField txtNombre;
	public JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPagoAdministracion frame = new VistaPagoAdministracion();
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
	public VistaPagoAdministracion() {
		setTitle("PAGO DE CUOTA ADMINISTRACION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Residente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 0)));
		panel.setBounds(10, 11, 472, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Cedula = new JLabel("Cedula:");
		Cedula.setBounds(10, 26, 80, 14);
		panel.add(Cedula);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setBounds(10, 51, 80, 14);
		panel.add(Nombre);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(67, 23, 136, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(67, 48, 136, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 116, 454, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel MedioDePago = new JLabel("Medio de Pago:");
		MedioDePago.setBounds(10, 11, 99, 14);
		panel_1.add(MedioDePago);
		
		JRadioButton rbEfectivo = new JRadioButton("Efectivo");
		rbEfectivo.setBounds(125, 7, 83, 23);
		panel_1.add(rbEfectivo);
		
		JRadioButton rbDebito = new JRadioButton("Tarjeta Debito");
		rbDebito.setBounds(216, 7, 109, 23);
		panel_1.add(rbDebito);
		
		JRadioButton rbCredito = new JRadioButton("Tarjeta Credito");
		rbCredito.setBounds(327, 7, 109, 23);
		panel_1.add(rbCredito);
		
		JButton btnGuardar = new JButton("buscar");
		btnGuardar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Buscar32.png")));
		btnGuardar.setBounds(253, 38, 117, 45);
		panel.add(btnGuardar);
		
		JLabel Total = new JLabel("Total:");
		Total.setBounds(10, 76, 80, 14);
		panel.add(Total);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(67, 76, 136, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnRegistrar = new JButton("registrar");
		btnRegistrar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Registrar.png")));
		btnRegistrar.setBounds(164, 184, 139, 50);
		contentPane.add(btnRegistrar);
	}
}