package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class VistaRegistrarCuota extends JFrame {

	public JPanel contentPane;
	public JTextField txtValorCuota;
	public JTextField txtPorcentaje;
	public JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistrarCuota frame = new VistaRegistrarCuota();
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
	public VistaRegistrarCuota() {
		setTitle("REGISTRAR CUOTA DE ADMINISTRACION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 382, 228);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValorCuota = new JLabel("Valor Cuota:");
		lblValorCuota.setBounds(32, 26, 75, 14);
		contentPane.add(lblValorCuota);
		
		txtValorCuota = new JTextField();
		txtValorCuota.setBounds(108, 23, 86, 20);
		contentPane.add(txtValorCuota);
		txtValorCuota.setColumns(10);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setBounds(32, 54, 75, 14);
		contentPane.add(lblPorcentaje);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setColumns(10);
		txtPorcentaje.setBounds(108, 51, 86, 20);
		contentPane.add(txtPorcentaje);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setBounds(32, 85, 46, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(108, 82, 86, 21);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Crear.png")));
		btnAgregar.setBounds(32, 121, 67, 57);
		contentPane.add(btnAgregar);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Guardar.png")));
		btnGuardar.setBounds(108, 121, 67, 57);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Modificar (2).png")));
		btnModificar.setBounds(185, 121, 67, 57);
		contentPane.add(btnModificar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/mostrar.png")));
		btnNewButton.setBounds(262, 121, 61, 57);
		contentPane.add(btnNewButton);
	}
}
