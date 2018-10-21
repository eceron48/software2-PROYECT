package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class VistaModificarVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField txtApto;
	private JTextField txtCasa;
	private JTextField txtModificarBloque;
	private JTextField txtModificarApto;
	private JTextField txtModificarPiso;
	private JTextField txtModificarCasa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaModificarVivienda frame = new VistaModificarVivienda();
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
	public VistaModificarVivienda() {
		setTitle("MODIFICAR VIVIENDA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(20, 11, 482, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbModificarVivienda = new JComboBox();
		cbModificarVivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Apartamentos", "Casas"}));
		cbModificarVivienda.setBounds(25, 11, 153, 20);
		panel.add(cbModificarVivienda);
		
		JLabel Apto = new JLabel("N\u00B0 Apto:");
		Apto.setBounds(188, 14, 46, 14);
		panel.add(Apto);
		
		JLabel Casa = new JLabel("N\u00B0 Casa:");
		Casa.setBounds(188, 39, 58, 14);
		panel.add(Casa);
		
		txtApto = new JTextField();
		txtApto.setBounds(244, 11, 86, 20);
		panel.add(txtApto);
		txtApto.setColumns(10);
		
		txtCasa = new JTextField();
		txtCasa.setBounds(244, 36, 86, 20);
		panel.add(txtCasa);
		txtCasa.setColumns(10);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.setToolTipText("");
		btnBuscar.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Buscar32.png")));
		btnBuscar.setBounds(214, 71, 116, 41);
		panel.add(btnBuscar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setToolTipText("");
		btnCancelar.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Cancelar32.png")));
		btnCancelar.setBounds(340, 71, 132, 41);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Casa2.png")));
		lblNewLabel.setBounds(33, 43, 145, 82);
		panel.add(lblNewLabel);
		
		JPanel PanelModificarApto = new JPanel();
		PanelModificarApto.setBorder(new TitledBorder(null, "Modificar Vivienda", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		PanelModificarApto.setBounds(91, 158, 337, 136);
		contentPane.add(PanelModificarApto);
		PanelModificarApto.setLayout(null);
		
		JLabel label = new JLabel("Bloque:");
		label.setBounds(39, 29, 46, 14);
		PanelModificarApto.add(label);
		
		txtModificarBloque = new JTextField();
		txtModificarBloque.setColumns(10);
		txtModificarBloque.setBounds(95, 27, 86, 20);
		PanelModificarApto.add(txtModificarBloque);
		
		JLabel lblNApto = new JLabel("N Apto:");
		lblNApto.setBounds(39, 54, 46, 14);
		PanelModificarApto.add(lblNApto);
		
		txtModificarApto = new JTextField();
		txtModificarApto.setColumns(10);
		txtModificarApto.setBounds(95, 51, 86, 20);
		PanelModificarApto.add(txtModificarApto);
		
		JLabel label_2 = new JLabel("Piso:");
		label_2.setBounds(39, 79, 46, 14);
		PanelModificarApto.add(label_2);
		
		txtModificarPiso = new JTextField();
		txtModificarPiso.setColumns(10);
		txtModificarPiso.setBounds(95, 76, 86, 20);
		PanelModificarApto.add(txtModificarPiso);
		
		JLabel lblNCasa = new JLabel("N Casa:");
		lblNCasa.setBounds(39, 104, 46, 14);
		PanelModificarApto.add(lblNCasa);
		
		txtModificarCasa = new JTextField();
		txtModificarCasa.setColumns(10);
		txtModificarCasa.setBounds(95, 101, 86, 20);
		PanelModificarApto.add(txtModificarCasa);
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.setToolTipText("");
		btnModificar.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Modificar32.png")));
		btnModificar.setBounds(191, 52, 136, 41);
		PanelModificarApto.add(btnModificar);
	}
}
