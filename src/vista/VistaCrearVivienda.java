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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class VistaCrearVivienda extends JFrame {

	public JPanel contentPane;
	public JTextField txtBloque;
	public JTextField txtApto;
	public JTextField txtPiso;
	public JTextField txtCasa;
	public JButton btnCrear;
	public JScrollPane scrollPane;
	public JTable tbVivienda;
	public JButton btnModificarVivienda;
	public JButton btnMostrarViviendas;
	public JComboBox cbVivienda;
	public DefaultTableModel tablaVivienda;

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
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBorder(new TitledBorder(null, "Crear Vivienda", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 255)));
		panel.setBounds(10, 11, 670, 166);
		contentPane.add(panel);
		panel.setLayout(null);

		cbVivienda = new JComboBox();
		cbVivienda.setModel(
				new DefaultComboBoxModel(new String[] { "seleccione tipo de vivienda", "casa", "apartamento" }));
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
		btnCrear.setBounds(488, 28, 127, 57);
		panel.add(btnCrear);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(152, 251, 152));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Vivienda",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 188, 670, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(33, 42, 588, 102);
		panel_1.add(scrollPane);

		tbVivienda = new JTable();
		tablaVivienda = new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "ID", "Rol", "Bloque", "Numero Vivienda", "Piso" }) {
			boolean[] columnEditables = new boolean[] { false, false, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		tbVivienda.setModel(tablaVivienda);
		scrollPane.setViewportView(tbVivienda);

		btnMostrarViviendas = new JButton("mostrar viviendas");
		btnMostrarViviendas.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Home.png")));
		btnMostrarViviendas.addActionListener(new ControladorVivienda (this));
		btnMostrarViviendas.setBounds(416, 155, 205, 55);

		panel_1.add(btnMostrarViviendas);

		btnModificarVivienda = new JButton("modificar");
		btnModificarVivienda.setIcon(new ImageIcon(VistaCrearVivienda.class.getResource("/iconos/Modificar32.png")));
		btnModificarVivienda.setBounds(272, 155, 124, 55);
		btnModificarVivienda.addActionListener(new ControladorVivienda (this));
		panel_1.add(btnModificarVivienda);
	}
}
