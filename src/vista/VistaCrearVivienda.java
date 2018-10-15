package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class VistaCrearVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBloque;
	private JTextField txtApto;
	private JTextField txtPiso;
	private JTextField txtCasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCrearVivienda frame = new VistaCrearVivienda();
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
	public VistaCrearVivienda() {
		setTitle("VIVIENDAS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 204));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 390, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Vivienda");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(139, 23, 119, 14);
		panel.add(lblNewLabel);
		
		JComboBox cbVivienda = new JComboBox();
		cbVivienda.setBackground(Color.WHITE);
		cbVivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Vivienda:", "Apartamentos", "Casas"}));
		cbVivienda.setBounds(10, 85, 144, 20);
		panel.add(cbVivienda);
		
		JLabel Bloque = new JLabel("Bloque:");
		Bloque.setBounds(173, 88, 46, 14);
		panel.add(Bloque);
		
		txtBloque = new JTextField();
		txtBloque.setBounds(260, 85, 107, 20);
		panel.add(txtBloque);
		txtBloque.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Casa1.png")));
		lblNewLabel_1.setBounds(22, 0, 78, 74);
		panel.add(lblNewLabel_1);
		
		JLabel Apto = new JLabel("N\u00B0 Apto:");
		Apto.setBounds(173, 113, 59, 14);
		panel.add(Apto);
		
		txtApto = new JTextField();
		txtApto.setColumns(10);
		txtApto.setBounds(260, 110, 107, 20);
		panel.add(txtApto);
		
		JLabel Piso = new JLabel("Piso:");
		Piso.setBounds(173, 138, 46, 14);
		panel.add(Piso);
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(260, 135, 107, 20);
		panel.add(txtPiso);
		
		JLabel Casa = new JLabel("N\u00B0 Casa:");
		Casa.setBounds(173, 165, 66, 14);
		panel.add(Casa);
		
		txtCasa = new JTextField();
		txtCasa.setColumns(10);
		txtCasa.setBounds(260, 162, 107, 20);
		panel.add(txtCasa);
		
		JButton btnCrear = new JButton("");
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setToolTipText("Crear");
		btnCrear.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Crear.png")));
		btnCrear.setBounds(92, 208, 66, 57);
		panel.add(btnCrear);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Cancelar.png")));
		btnCancelar.setBounds(207, 208, 66, 57);
		panel.add(btnCancelar);
	}
}
