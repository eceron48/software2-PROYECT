package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaResidentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarResidente;
	private JTable tbResidentes;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtVivienda;
	private JTextField txtNVivienda;

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
		setBounds(100, 100, 901, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(37, 11, 70, 14);
		contentPane.add(lblBuscarPor);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(37, 36, 573, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rbCedula = new JRadioButton("Cedula");
		rbCedula.setBounds(19, 7, 75, 23);
		panel.add(rbCedula);
		
		JRadioButton rbNombre = new JRadioButton("Nombre");
		rbNombre.setBounds(115, 7, 109, 23);
		panel.add(rbNombre);
		
		txtBuscarResidente = new JTextField();
		txtBuscarResidente.setBounds(19, 47, 186, 20);
		panel.add(txtBuscarResidente);
		txtBuscarResidente.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Buscar.png")));
		btnBuscar.setBounds(249, 21, 124, 46);
		panel.add(btnBuscar);
		
		JButton btnBuscarTodos = new JButton("BUSCAR TODOS");
		btnBuscarTodos.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/BuscarTodo.png")));
		btnBuscarTodos.setBounds(399, 21, 152, 46);
		panel.add(btnBuscarTodos);
		
		JScrollPane scrollPaneResidentes = new JScrollPane();
		scrollPaneResidentes.setBounds(37, 131, 576, 107);
		contentPane.add(scrollPaneResidentes);
		
		tbResidentes = new JTable();
		tbResidentes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"NOMBRE", "CEDULA", "TELEFONO", "VIVIENDA", "nVIVIENDA"
			}
		));
		scrollPaneResidentes.setViewportView(tbResidentes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(635, 95, 240, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setBounds(30, 11, 60, 14);
		panel_1.add(Nombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(100, 8, 130, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel Cedula = new JLabel("Cedula:");
		Cedula.setBounds(30, 36, 60, 14);
		panel_1.add(Cedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(100, 33, 130, 20);
		panel_1.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(100, 58, 130, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel Telefono = new JLabel("Telefono:");
		Telefono.setBounds(30, 61, 60, 14);
		panel_1.add(Telefono);
		
		JLabel Vivienda = new JLabel("Vivienda:");
		Vivienda.setBounds(30, 86, 60, 14);
		panel_1.add(Vivienda);
		
		txtVivienda = new JTextField();
		txtVivienda.setBounds(100, 83, 130, 20);
		panel_1.add(txtVivienda);
		txtVivienda.setColumns(10);
		
		JLabel NVivienda = new JLabel("N Vivienda:");
		NVivienda.setBounds(20, 111, 80, 21);
		panel_1.add(NVivienda);
		
		txtNVivienda = new JTextField();
		txtNVivienda.setBounds(100, 111, 130, 20);
		panel_1.add(txtNVivienda);
		txtNVivienda.setColumns(10);
		
		JButton btnModificar = new JButton("");
		btnModificar.setToolTipText("Modificar");
		btnModificar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Modificar (2).png")));
		btnModificar.setBounds(50, 266, 70, 57);
		contentPane.add(btnModificar);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Guardar.png")));
		btnGuardar.setBounds(143, 266, 70, 57);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Eliminar.png")));
		btnEliminar.setBounds(234, 266, 70, 57);
		contentPane.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setToolTipText("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Limpiar.png")));
		btnLimpiar.setBounds(326, 266, 70, 57);
		contentPane.add(btnLimpiar);
	}
}
