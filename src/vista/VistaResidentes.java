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
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaResidentes extends JFrame {

	public JPanel contentPane;
	public JTextField txtGuardarNombre;
	public DefaultTableModel tbResidentes;
	public JTable residente;
	public JScrollPane scrollPaneResidentes;
	public Object[][] datos;
	private JTable tbApartamentos;
	public JComboBox comboRol;
	public JTextField txtGuardarCedula;
	public JTextField txtGuardarTelefono;
	public JButton btnGuardar;
	public JButton btnBuscar;
	public JButton btnModificar;
	public JButton btnMostrarTodos;

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
		setBounds(100, 100, 811, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Por:", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 11, 779, 205);
		contentPane.add(panel);
		panel.setLayout(null);

		txtGuardarNombre = new JTextField();
		txtGuardarNombre.setBounds(92, 47, 139, 20);
		panel.add(txtGuardarNombre);
		txtGuardarNombre.setColumns(10);

		btnGuardar = new JButton("guardar");
		btnGuardar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Guardar32.png")));
		btnGuardar.addActionListener(new ControladorResidente(this));
		btnGuardar.setBounds(66, 148, 129, 46);
		panel.add(btnGuardar);

		btnMostrarTodos = new JButton("mostrar todos");
		btnMostrarTodos.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/BuscarTodo.png")));
		btnMostrarTodos.setBounds(606, 148, 152, 46);
		btnMostrarTodos.addActionListener(new ControladorResidente(this));
		panel.add(btnMostrarTodos);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Persona48.png")));
		lblNewLabel.setBounds(692, 16, 64, 83);
		panel.add(lblNewLabel);

		comboRol = new JComboBox();
		comboRol.setModel(
				new DefaultComboBoxModel(new String[] { "seleccione rol:", "residente", "empleado", "visitante" }));
		comboRol.setBounds(19, 16, 157, 20);
		panel.add(comboRol);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(19, 50, 63, 14);
		panel.add(lblNombre);

		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(19, 80, 63, 14);
		panel.add(lblCedula);

		txtGuardarCedula = new JTextField();
		txtGuardarCedula.setColumns(10);
		txtGuardarCedula.setBounds(92, 78, 139, 20);
		panel.add(txtGuardarCedula);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(19, 112, 63, 14);
		panel.add(lblTelefono);

		txtGuardarTelefono = new JTextField();
		txtGuardarTelefono.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9')
					e.consume();

			}
		});
		txtGuardarTelefono.setColumns(10);
		txtGuardarTelefono.setBounds(92, 109, 139, 20);
		panel.add(txtGuardarTelefono);

		scrollPaneResidentes = new JScrollPane();
		scrollPaneResidentes.setBounds(256, 29, 426, 108);
		panel.add(scrollPaneResidentes);
		scrollPaneResidentes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneResidentes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneResidentes.setViewportBorder(new LineBorder(new Color(0, 0, 0)));

		residente = new JTable();
		residente.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		tbResidentes = (new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "IDPersona", "Nombre", "Cedula", "Telefono", "Rol" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		residente.setModel(tbResidentes);
		scrollPaneResidentes.setViewportView(residente);

		btnBuscar = new JButton("buscar");
		btnBuscar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Buscar32.png")));
		btnBuscar.setBounds(242, 148, 129, 46);
		btnBuscar.addActionListener(new ControladorResidente(this));
		panel.add(btnBuscar);

		btnModificar = new JButton("modificar");
		btnModificar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Modificar32.png")));
		btnModificar.setBounds(407, 151, 129, 40);
		btnModificar.addActionListener(new ControladorResidente(this));
		panel.add(btnModificar);

	}

	
}
