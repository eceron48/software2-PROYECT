package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorZonaResidencial;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VistaZonaR extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombreZona;
	public JTextField txtDireccionZona;
	public JButton btnMostrar;
	public JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaZonaR frame = new VistaZonaR();
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
	public VistaZonaR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		panel.setBorder(new TitledBorder(null, "Zona Residencial", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 435, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 41, 62, 14);
		panel.add(lblNombre);
		
		txtNombreZona = new JTextField();
		txtNombreZona.setBounds(100, 38, 129, 20);
		panel.add(txtNombreZona);
		txtNombreZona.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 79, 64, 14);
		panel.add(lblDireccion);
		
		txtDireccionZona = new JTextField();
		txtDireccionZona.setBounds(100, 76, 129, 20);
		panel.add(txtDireccionZona);
		txtDireccionZona.setColumns(10);
		
		btnModificar = new JButton("modificar");
		btnModificar.setIcon(new ImageIcon(VistaZonaR.class.getResource("/iconos/Registrar.png")));
		btnModificar.setBounds(220, 131, 143, 50);
		panel.add(btnModificar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaZonaR.class.getResource("/iconos/Casa2.png")));
		lblNewLabel.setBounds(250, 22, 129, 90);
		panel.add(lblNewLabel);
		
		btnMostrar = new JButton("mostrar");
		btnMostrar.addActionListener(new ControladorZonaResidencial (this));
		btnMostrar.setIcon(new ImageIcon(VistaZonaR.class.getResource("/iconos/Ver32.png")));
		btnMostrar.setBounds(62, 131, 129, 50);
		panel.add(btnMostrar);
	}
	

}
