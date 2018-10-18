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
		setBounds(100, 100, 371, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotal = new JLabel("TOTAL A PAGAR:");
		lblTotal.setBounds(32, 112, 101, 14);
		contentPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(137, 109, 186, 21);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 21, 291, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblValorCuota = new JLabel("Valor Cuota:");
		lblValorCuota.setBounds(10, 11, 75, 14);
		panel.add(lblValorCuota);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setBounds(10, 51, 75, 14);
		panel.add(lblPorcentaje);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setBounds(95, 48, 86, 20);
		panel.add(txtPorcentaje);
		txtPorcentaje.setColumns(10);
		
		txtValorCuota = new JTextField();
		txtValorCuota.setBounds(95, 8, 86, 20);
		panel.add(txtValorCuota);
		txtValorCuota.setColumns(10);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setToolTipText("Agregar");
		btnAgregar.setBounds(212, 11, 67, 57);
		panel.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Crear.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 141, 295, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setBounds(218, 11, 67, 57);
		panel_1.add(btnGuardar);
		btnGuardar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Guardar.png")));
		
		JButton btnModificar = new JButton("");
		btnModificar.setToolTipText("Modificar");
		btnModificar.setBounds(116, 11, 67, 57);
		panel_1.add(btnModificar);
		btnModificar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Modificar (2).png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Ver Cuotas");
		btnNewButton.setBounds(10, 11, 61, 57);
		panel_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/mostrar.png")));
	}
}
