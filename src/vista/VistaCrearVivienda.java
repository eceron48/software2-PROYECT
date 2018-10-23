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

import controlador.ControladorVivienda;

public class VistaCrearVivienda extends JFrame {

	private JPanel contentPane;
	public JTextField txtBloque;
	public  JTextField txtApto;
	public  JTextField txtPiso;
	public JTextField txtCasa;
	public  JComboBox cbVivienda;
	public JButton btnCrear;
	public JButton btnCancelar;

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
		setBounds(100, 100, 445, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 204));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 409, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Vivienda");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(139, 23, 119, 14);
		panel.add(lblNewLabel);
		
		cbVivienda = new JComboBox();
		cbVivienda.setModel(new DefaultComboBoxModel(new String[] {"seleccione tipo de vivienda", "casa", "apartamento"}));
		cbVivienda.setBackground(Color.WHITE);
		cbVivienda.setBounds(10, 85, 156, 20);
		panel.add(cbVivienda);
		
		JLabel Bloque = new JLabel("Bloque:");
		Bloque.setBounds(201, 88, 46, 14);
		panel.add(Bloque);
		
		txtBloque = new JTextField();
		txtBloque.setBounds(288, 85, 107, 20);
		panel.add(txtBloque);
		txtBloque.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Casa1.png")));
		lblNewLabel_1.setBounds(22, 0, 78, 74);
		panel.add(lblNewLabel_1);
		
		JLabel Apto = new JLabel("N\u00B0 Apto:");
		Apto.setBounds(201, 113, 59, 14);
		panel.add(Apto);
		
		txtApto = new JTextField();
		txtApto.setColumns(10);
		txtApto.setBounds(288, 110, 107, 20);
		panel.add(txtApto);
		
		JLabel Piso = new JLabel("Piso:");
		Piso.setBounds(201, 138, 46, 14);
		panel.add(Piso);
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(288, 135, 107, 20);
		panel.add(txtPiso);
		
		JLabel Casa = new JLabel("N\u00B0 Casa:");
		Casa.setBounds(201, 165, 66, 14);
		panel.add(Casa);
		
		txtCasa = new JTextField();
		txtCasa.setColumns(10);
		txtCasa.setBounds(288, 162, 107, 20);
		panel.add(txtCasa);
		
		btnCrear = new JButton("crear");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setToolTipText("");
		btnCrear.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Crear.png")));
		btnCrear.addActionListener(new ControladorVivienda(this));
		btnCrear.setBounds(92, 208, 127, 57);
		panel.add(btnCrear);
		
		btnCancelar = new JButton("cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setToolTipText("");
		btnCancelar.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Cancelar.png")));
		btnCancelar.setBounds(240, 209, 127, 57);
		panel.add(btnCancelar);
	}
	

	
}
