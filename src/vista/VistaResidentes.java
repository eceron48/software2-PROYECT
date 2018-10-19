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

import controlador.ControladorResidente;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaResidentes extends JFrame {

	public JPanel contentPane;
	public JTextField txtBuscarResidente;
	public JTable tbResidentes;
	public JTextField txtNombre;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JButton btnGuardar;

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
		setBounds(100, 100, 674, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Por:", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(37, 11, 573, 79);
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
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(new ControladorResidente(this));
		btnBuscar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Buscar.png")));
		btnBuscar.setBounds(249, 21, 124, 46);
		panel.add(btnBuscar);
		
		JButton btnBuscarTodos = new JButton("buscar todos");
		btnBuscarTodos.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/BuscarTodo.png")));
		btnBuscarTodos.setBounds(399, 21, 152, 46);
		panel.add(btnBuscarTodos);
		
		JScrollPane scrollPaneResidentes = new JScrollPane();
		scrollPaneResidentes.setBounds(37, 101, 573, 107);
		contentPane.add(scrollPaneResidentes);
		
		tbResidentes = new JTable();
		tbResidentes.setModel(new DefaultTableModel(
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
		));
		scrollPaneResidentes.setViewportView(tbResidentes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Crear Residente", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(37, 219, 573, 182);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Casa");
		rdbtnNewRadioButton.setBounds(16, 18, 56, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnApto = new JRadioButton("Apto");
		rdbtnApto.setBounds(74, 18, 56, 23);
		panel_2.add(rdbtnApto);
		
		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setBounds(26, 51, 60, 14);
		panel_2.add(Nombre);
		
		JLabel Cedula = new JLabel("Cedula:");
		Cedula.setBounds(26, 76, 60, 14);
		panel_2.add(Cedula);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(106, 48, 130, 20);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel Telefono = new JLabel("Telefono:");
		Telefono.setBounds(26, 101, 60, 14);
		panel_2.add(Telefono);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(106, 73, 130, 20);
		panel_2.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(106, 98, 130, 20);
		panel_2.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel Vivienda = new JLabel("Vivienda:");
		Vivienda.setBounds(26, 126, 70, 14);
		panel_2.add(Vivienda);
		
		JComboBox comboBoxvivienda = new JComboBox();
		comboBoxvivienda.setBounds(104, 123, 132, 20);
		panel_2.add(comboBoxvivienda);
		comboBoxvivienda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una:"}));
		
		JLabel lblParqueadero = new JLabel("Parqueadero:");
		lblParqueadero.setBounds(26, 151, 79, 14);
		panel_2.add(lblParqueadero);
		
		JComboBox comboBoxparqueadero = new JComboBox();
		comboBoxparqueadero.setBounds(104, 151, 132, 20);
		panel_2.add(comboBoxparqueadero);
		comboBoxparqueadero.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una:"}));
		
		JButton btnModificar = new JButton("");
		btnModificar.setBounds(259, 108, 70, 57);
		panel_2.add(btnModificar);
		btnModificar.setToolTipText("Modificar");
		btnModificar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Modificar (2).png")));
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setBounds(419, 108, 70, 57);
		panel_2.add(btnEliminar);
		btnEliminar.setToolTipText("Eliminar");
		btnEliminar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Eliminar.png")));
		
		btnGuardar = new JButton("guardar");
		btnGuardar.setBounds(339, 108, 56, 57);
		panel_2.add(btnGuardar);
		btnGuardar.setToolTipText("");
		btnGuardar.addActionListener(new ControladorResidente(this));
		btnGuardar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Guardar.png")));
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setBounds(493, 108, 70, 57);
		panel_2.add(btnLimpiar);
		btnLimpiar.setToolTipText("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Limpiar.png")));
	}
	
}
