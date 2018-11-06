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

import controlador.ControladorPago;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;

public class VistaPagoAdministracion extends JFrame {

	public JPanel contentPane;
	public JTextField txtCedula;
	public JTextField txtNombre;
	public JTextField txtTotal;
	public DefaultTableModel tbpersonas;
	public JButton btnBuscar;
	public JButton btnRegistrar;
	public JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton rbtCredito;
	public JRadioButton rdbDebito;
	public JRadioButton rdbEfectivo;

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
		setBounds(100, 100, 924, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Residente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 0)));
		panel.setBounds(10, 11, 891, 178);
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
		txtNombre.setEditable(false);
		txtNombre.setBounds(67, 66, 136, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnBuscar = new JButton("buscar");
		btnBuscar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Buscar32.png")));
		btnBuscar.addActionListener(new ControladorPago(this));
		btnBuscar.setBounds(222, 111, 136, 50);
		panel.add(btnBuscar);
		
		JLabel Total = new JLabel("Total:");
		Total.setBounds(10, 111, 80, 14);
		panel.add(Total);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(67, 108, 136, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnRegistrar = new JButton("registrar");
		btnRegistrar.setBounds(368, 111, 139, 50);
		panel.add(btnRegistrar);
		btnRegistrar.addActionListener(new ControladorPago(this));
		btnRegistrar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Registrar.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Hombre64.png")));
		lblNewLabel.setBounds(629, 19, 72, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/pagos.png")));
		lblNewLabel_1.setBounds(711, 26, 65, 57);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Persona48.png")));
		lblNewLabel_2.setBounds(791, 26, 65, 60);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Seleccione medio de pago:", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(222, 19, 285, 50);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		rdbEfectivo = new JRadioButton("efectivo");
		rdbEfectivo.setBounds(19, 21, 82, 23);
		panel_2.add(rdbEfectivo);
		buttonGroup.add(rdbEfectivo);
		
		rdbDebito = new JRadioButton("debito");
		rdbDebito.setBounds(118, 21, 83, 23);
		panel_2.add(rdbDebito);
		buttonGroup.add(rdbDebito);
		
		rbtCredito = new JRadioButton("credito");
		rbtCredito.setBounds(203, 21, 76, 23);
		panel_2.add(rbtCredito);
		buttonGroup.add(rbtCredito);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Pagos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 200, 891, 203);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 29, 651, 163);
		panel_1.add(scrollPane);
		
		table = new JTable();
		tbpersonas=new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
			},
			new String[] {
				"Cedula", "Nombre", "Total", "ultimo pago", "observaciones"
			}
		);
	
		table.setModel(tbpersonas);
		scrollPane.setViewportView(table);
		
		JButton btnmostrartodo = new JButton("mostrar pagos");
		btnmostrartodo .setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Pago.png")));
		btnmostrartodo .addActionListener(new ControladorPago(this));
		btnmostrartodo .setBounds(673, 135, 185, 57);
		
		panel_1.add(btnmostrartodo );
	}
	
}