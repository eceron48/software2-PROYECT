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
	public DefaultTableModel tbpersonas;
	public JTextField txtTotal;
	public JButton btnBuscar;
	public JButton btnRegistrar;
	public JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton rbtdebito;
	public JRadioButton rdbcredito;
	public JRadioButton rdbtnEfectivo;
	public JButton btnmostrarTodo;

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
		setBounds(100, 100, 1021, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Residente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 0)));
		panel.setBounds(10, 11, 965, 178);
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
		btnBuscar.setBounds(235, 51, 136, 50);
		btnBuscar.addActionListener(new ControladorPago(this));
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
		btnRegistrar.setBounds(232, 117, 139, 50);
		panel.add(btnRegistrar);
		btnRegistrar.addActionListener(new ControladorPago(this));
		btnRegistrar.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Registrar.png")));
		
		rbtdebito = new JRadioButton("credito");
		buttonGroup.add(rbtdebito);
		rbtdebito.setBounds(235, 22, 79, 23);
		panel.add(rbtdebito);
		
		rdbcredito = new JRadioButton("debito");
		buttonGroup.add(rdbcredito);
		rdbcredito.setBounds(316, 22, 69, 23);
		panel.add(rdbcredito);
		
		rdbtnEfectivo = new JRadioButton("efectivo");
		buttonGroup.add(rdbtnEfectivo);
		rdbtnEfectivo.setBounds(387, 22, 80, 23);
		panel.add(rdbtnEfectivo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Pagos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(10, 200, 965, 203);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 29, 709, 163);
		panel_1.add(scrollPane);
		
		table = new JTable();
		tbpersonas=new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
			},
			new String[] {
				"Cedula", "Nombre", "Total", "       ultimo pago      ", "       observaciones   "
			}
		);
		table.setModel(tbpersonas);
		scrollPane.setViewportView(table);
		
		btnmostrarTodo = new JButton("mostrar pagos");
		btnmostrarTodo.setIcon(new ImageIcon(VistaPagoAdministracion.class.getResource("/iconos/Pago.png")));
		btnmostrarTodo.addActionListener(new ControladorPago(this));
		btnmostrarTodo.setBounds(729, 29, 185, 57);
		
		panel_1.add(btnmostrarTodo);
	}
	
	
	
}