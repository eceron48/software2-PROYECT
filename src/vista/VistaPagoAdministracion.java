package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class VistaPagoAdministracion extends JFrame {

	public JPanel contentPane;
	public JTextField txtCedula;
	public JTextField txtNombre;
	public JTextField txtTotal;
	public JComboBox comboBox;
	public JButton btnGuardar;
	public JButton btnRegistrar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPagoAdministracion frame = new VistaPagoAdministracion();
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
	public VistaPagoAdministracion() {
		setTitle("PAGO DE CUOTA ADMINISTRACION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Residente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 0)));
		panel.setBounds(10, 11, 667, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Cedula = new JLabel("Cedula:");
		Cedula.setBounds(10, 26, 80, 14);
		panel.add(Cedula);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setBounds(10, 69, 80, 14);
		panel.add(Nombre);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(67, 23, 136, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(67, 66, 136, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnGuardar = new JButton("buscar");
		btnGuardar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Buscar32.png")));
		btnGuardar.setBounds(365, 107, 136, 50);
		panel.add(btnGuardar);
		
		JLabel Total = new JLabel("Total:");
		Total.setBounds(10, 111, 80, 14);
		panel.add(Total);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(67, 108, 136, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Medio De Pago:", "Efectivo", "Debito", "Credito"}));
		comboBox.setBounds(235, 23, 157, 20);
		panel.add(comboBox);
		
		btnRegistrar = new JButton("registrar");
		btnRegistrar.setBounds(518, 107, 139, 50);
		panel.add(btnRegistrar);
		btnRegistrar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Registrar.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Pagos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 200, 667, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(23, 29, 426, 118);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Cedula", "Nombre", "Total", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("mostrar pagos");
		btnNewButton.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Pago.png")));
		btnNewButton.setBounds(459, 90, 188, 57);
		panel_1.add(btnNewButton);
	}
}