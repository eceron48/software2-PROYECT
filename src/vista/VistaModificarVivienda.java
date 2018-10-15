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

public class VistaModificarVivienda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBloque;
	private JTextField txtApto;
	private JTextField txtPiso;
	private JTextField txtCasa;
	private JTable tbModificarVivienda;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(20, 11, 534, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbModificarVivienda = new JComboBox();
		cbModificarVivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Apartamentos", "Casas"}));
		cbModificarVivienda.setBounds(25, 11, 153, 20);
		panel.add(cbModificarVivienda);
		
		JLabel Bloque = new JLabel("Bloque:");
		Bloque.setBounds(198, 25, 46, 14);
		panel.add(Bloque);
		
		JLabel Apto = new JLabel("N\u00B0 Apto:");
		Apto.setBounds(198, 50, 46, 14);
		panel.add(Apto);
		
		JLabel Piso = new JLabel("Piso:");
		Piso.setBounds(198, 75, 46, 14);
		panel.add(Piso);
		
		JLabel Casa = new JLabel("N\u00B0 Casa:");
		Casa.setBounds(198, 100, 58, 14);
		panel.add(Casa);
		
		txtBloque = new JTextField();
		txtBloque.setBounds(254, 23, 86, 20);
		panel.add(txtBloque);
		txtBloque.setColumns(10);
		
		txtApto = new JTextField();
		txtApto.setBounds(254, 47, 86, 20);
		panel.add(txtApto);
		txtApto.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(254, 72, 86, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtCasa = new JTextField();
		txtCasa.setBounds(254, 97, 86, 20);
		panel.add(txtCasa);
		txtCasa.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Search.png")));
		btnBuscar.setBounds(365, 25, 65, 64);
		panel.add(btnBuscar);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Cancelar.png")));
		btnCancelar.setBounds(445, 25, 65, 64);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Casa2.png")));
		lblNewLabel.setBounds(33, 43, 145, 82);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 158, 534, 107);
		contentPane.add(scrollPane);
		
		tbModificarVivienda = new JTable();
		tbModificarVivienda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Bloque", "nApartamento", "Piso", "nCasa"
			}
		));
		scrollPane.setViewportView(tbModificarVivienda);
		
		JPanel PanelModificarApto = new JPanel();
		PanelModificarApto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		PanelModificarApto.setBounds(123, 281, 308, 136);
		contentPane.add(PanelModificarApto);
		PanelModificarApto.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Modificar Vivienda");
		lblNewLabel_1.setBounds(105, 2, 113, 14);
		PanelModificarApto.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Bloque:");
		label.setBounds(39, 29, 46, 14);
		PanelModificarApto.add(label);
		
		txtModificarBloque = new JTextField();
		txtModificarBloque.setColumns(10);
		txtModificarBloque.setBounds(95, 27, 86, 20);
		PanelModificarApto.add(txtModificarBloque);
		
		JLabel label_1 = new JLabel("N\u00B0 Apto:");
		label_1.setBounds(39, 54, 46, 14);
		PanelModificarApto.add(label_1);
		
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
		
		JLabel label_3 = new JLabel("N\u00B0 Casa:");
		label_3.setBounds(39, 104, 46, 14);
		PanelModificarApto.add(label_3);
		
		txtModificarCasa = new JTextField();
		txtModificarCasa.setColumns(10);
		txtModificarCasa.setBounds(95, 101, 86, 20);
		PanelModificarApto.add(txtModificarCasa);
		
		JButton btnModificar = new JButton("");
		btnModificar.setToolTipText("Modificar");
		btnModificar.setIcon(new ImageIcon(VistaModificarVivienda.class.getResource("/iconos/Modificar (2).png")));
		btnModificar.setBounds(208, 39, 75, 54);
		PanelModificarApto.add(btnModificar);
	}
}
