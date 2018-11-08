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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class VistaCrearVivienda extends JFrame {

	private JPanel contentPane;
	public JTextField txtBloque;
	public  JTextField txtApto;
	public  JTextField txtPiso;
	public JTextField txtCasa;
	public  JComboBox cbVivienda;
	public JButton btnCrear;
	public JButton btnCancelar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 708, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 204));
		panel.setBorder(new TitledBorder(null, "Crear Vivienda", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 11, 670, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cbVivienda = new JComboBox();
		cbVivienda.setModel(new DefaultComboBoxModel(new String[] {"seleccione tipo de vivienda", "casa", "apartamento"}));
		cbVivienda.setBackground(Color.WHITE);
		cbVivienda.setBounds(110, 28, 156, 20);
		panel.add(cbVivienda);
		
		JLabel Bloque = new JLabel("Bloque:");
		Bloque.setBounds(276, 31, 46, 14);
		panel.add(Bloque);
		
		txtBloque = new JTextField();
		txtBloque.setBounds(363, 28, 107, 20);
		panel.add(txtBloque);
		txtBloque.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Casa1.png")));
		lblNewLabel_1.setBounds(22, 0, 78, 74);
		panel.add(lblNewLabel_1);
		
		JLabel Apto = new JLabel("ID Apto:");
		Apto.setBounds(276, 59, 59, 14);
		panel.add(Apto);
		
		txtApto = new JTextField();
		txtApto.setColumns(10);
		txtApto.setBounds(363, 56, 107, 20);
		panel.add(txtApto);
		
		JLabel Piso = new JLabel("Piso:");
		Piso.setBounds(276, 84, 46, 14);
		panel.add(Piso);
		
		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(363, 81, 107, 20);
		panel.add(txtPiso);
		
		JLabel Casa = new JLabel("ID Casa:");
		Casa.setBounds(276, 111, 66, 14);
		panel.add(Casa);
		
		txtCasa = new JTextField();
		txtCasa.setColumns(10);
		txtCasa.setBounds(363, 108, 107, 20);
		panel.add(txtCasa);
		
		btnCrear = new JButton("crear");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setToolTipText("");
		btnCrear.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Crear.png")));
		btnCrear.addActionListener(new ControladorVivienda(this));
		btnCrear.setBounds(486, 17, 127, 57);
		panel.add(btnCrear);
		
		btnCancelar = new JButton("cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setToolTipText("");
		btnCancelar.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Cancelar.png")));
		btnCancelar.setBounds(486, 84, 127, 57);
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Asignar Vivienda a Personas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 188, 670, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(37, 38, 46, 14);
		panel_1.add(lblCedula);
		
		textField = new JTextField();
		textField.setBounds(105, 35, 105, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(37, 70, 46, 14);
		panel_1.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 67, 105, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(237, 34, 89, 23);
		panel_1.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("ID Vivienda:");
		lblNewLabel.setBounds(37, 103, 73, 14);
		panel_1.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 98, 105, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
	}
}
