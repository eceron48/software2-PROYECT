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
import java.awt.Font;

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
		setBounds(100, 100, 483, 261);
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
		panel.setBounds(32, 21, 413, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblValorCuota = new JLabel("Valor Cuota:");
		lblValorCuota.setBounds(10, 11, 75, 14);
		panel.add(lblValorCuota);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setBounds(10, 51, 75, 14);
		panel.add(lblPorcentaje);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setBounds(95, 48, 117, 20);
		panel.add(txtPorcentaje);
		txtPorcentaje.setColumns(10);
		
		txtValorCuota = new JTextField();
		txtValorCuota.setBounds(95, 8, 117, 20);
		panel.add(txtValorCuota);
		txtValorCuota.setColumns(10);
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregar.setToolTipText("");
		btnAgregar.setBounds(252, 8, 130, 57);
		panel.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Crear.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 141, 413, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnGuardar = new JButton("guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setToolTipText("");
		btnGuardar.setBounds(283, 11, 116, 41);
		panel_1.add(btnGuardar);
		btnGuardar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Guardar32.png")));
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setToolTipText("");
		btnModificar.setBounds(157, 11, 116, 41);
		panel_1.add(btnModificar);
		btnModificar.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Modificar32.png")));
		
		JButton btnNewButton = new JButton("ver cuotas");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(10, 11, 130, 41);
		panel_1.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(VistaRegistrarCuota.class.getResource("/iconos/Ver32.png")));
	}
}
