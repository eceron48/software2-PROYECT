package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorResidente;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaResidentes extends JFrame {

	public JPanel contentPane;
	public JTextField txtBuscarResidente;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JButton btnGuardar;
	public DefaultTableModel tbResidentes;
	public JTable  residente;
	public JTable apartamento;
	public JScrollPane scrollPaneResidentes;
	  public Object[][] datos;
	  private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaResidentes frame = new VistaResidentes();
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
	public VistaResidentes() {
		setTitle("Gestionar Residentes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Por:", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(37, 11, 752, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rbCedula = new JRadioButton("Cedula");
		rbCedula.setBounds(19, 7, 75, 23);
		panel.add(rbCedula);
		
		JRadioButton rbNombre = new JRadioButton("Nombre");
		rbNombre.setBounds(115, 7, 109, 23);
		panel.add(rbNombre);
		
		txtBuscarResidente = new JTextField();
		txtBuscarResidente.setBounds(19, 47, 299, 20);
		panel.add(txtBuscarResidente);
		txtBuscarResidente.setColumns(10);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(new ControladorResidente(this));
		btnBuscar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Buscar32.png")));
		btnBuscar.setBounds(401, 21, 124, 46);
		panel.add(btnBuscar);
		
		JButton btnBuscarTodos = new JButton("buscar todos");
		btnBuscarTodos.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/BuscarTodo.png")));
		btnBuscarTodos.setBounds(549, 21, 152, 46);
		btnBuscarTodos.addActionListener(new ControladorResidente(this));
		panel.add(btnBuscarTodos);
		
		scrollPaneResidentes = new JScrollPane();
		scrollPaneResidentes.setBounds(37, 101, 752, 107);
		contentPane.add(scrollPaneResidentes);
		
		  residente= new JTable();
		tbResidentes = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Cedula", "Telefono", "Casa / Apto", "Num Vivienda", "ID Parqueadero"
			}
		);
		residente.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		residente.setModel(tbResidentes);
		residente.getColumnModel().getColumn(0).setPreferredWidth(64);
		residente.getColumnModel().getColumn(2).setResizable(false);
		scrollPaneResidentes.setViewportView(residente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Crear Residente", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(37, 219, 752, 196);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setBounds(10, 27, 60, 14);
		panel_2.add(Nombre);
		
		JLabel Cedula = new JLabel("Cedula:");
		Cedula.setBounds(10, 58, 60, 14);
		panel_2.add(Cedula);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(86, 24, 130, 20);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel Telefono = new JLabel("Telefono:");
		Telefono.setBounds(10, 86, 60, 14);
		panel_2.add(Telefono);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(86, 55, 130, 20);
		panel_2.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(86, 83, 130, 20);
		panel_2.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel Vivienda = new JLabel("Casa:");
		Vivienda.setBounds(10, 117, 70, 14);
		panel_2.add(Vivienda);
		
		JComboBox comboBoxvivienda = new JComboBox();
		comboBoxvivienda.setBounds(86, 114, 132, 20);
		panel_2.add(comboBoxvivienda);
		comboBoxvivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una:"}));
		
		JLabel lblParqueadero = new JLabel("Parqueadero:");
		lblParqueadero.setBounds(10, 148, 79, 14);
		panel_2.add(lblParqueadero);
		
		JComboBox comboBoxparqueadero = new JComboBox();
		comboBoxparqueadero.setBounds(86, 145, 132, 20);
		panel_2.add(comboBoxparqueadero);
		comboBoxparqueadero.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una:"}));
		
		JButton btnModificar = new JButton("modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setBounds(237, 135, 130, 41);
		panel_2.add(btnModificar);
		btnModificar.setToolTipText("");
		btnModificar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Modificar32.png")));
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBounds(501, 135, 119, 41);
		panel_2.add(btnEliminar);
		btnEliminar.setToolTipText("");
		btnEliminar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Eliminar32.png")));
		
		btnGuardar = new JButton("guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(377, 135, 119, 41);
		panel_2.add(btnGuardar);
		btnGuardar.setToolTipText("");
		btnGuardar.addActionListener(new ControladorResidente(this));
		btnGuardar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Guardar32.png")));
		
		JButton btnLimpiar = new JButton("limpiar");
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.setBounds(630, 135, 112, 40);
		panel_2.add(btnLimpiar);
		btnLimpiar.setToolTipText("");
		btnLimpiar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Limpiar32.png")));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(null, "apartamento", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		scrollPane.setToolTipText("tabla1");
		scrollPane.setBounds(237, 20, 480, 104);
		panel_2.add(scrollPane);
		
		
	}
	
}
