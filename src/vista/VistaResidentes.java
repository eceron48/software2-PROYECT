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

public class VistaResidentes extends JFrame {

	public JPanel contentPane;
	public JTextField txtBuscarResidente;
	public JButton btnGuardar;
	public DefaultTableModel tbResidentes;
	public DefaultTableModel tbapartamento;
	public JTable  residente;
	public JScrollPane scrollPaneResidentes;
	  public Object[][] datos;
	  private JTable tbApartamentos;
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
		setBounds(100, 100, 815, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Por:", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(37, 11, 752, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rbCedula = new JRadioButton("Cedula");
		rbCedula.setBounds(23, 17, 75, 23);
		panel.add(rbCedula);
		
		JRadioButton rbNombre = new JRadioButton("Nombre");
		rbNombre.setBounds(115, 17, 109, 23);
		panel.add(rbNombre);
		
		txtBuscarResidente = new JTextField();
		txtBuscarResidente.setBounds(19, 47, 299, 20);
		panel.add(txtBuscarResidente);
		txtBuscarResidente.setColumns(10);
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(new ControladorResidente(this));
		btnBuscar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Buscar32.png")));
		btnBuscar.setBounds(353, 34, 124, 46);
		panel.add(btnBuscar);
		
		JButton btnBuscarTodos = new JButton("buscar todos");
		btnBuscarTodos.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/BuscarTodo.png")));
		btnBuscarTodos.setBounds(487, 34, 152, 46);
		btnBuscarTodos.addActionListener(new ControladorResidente(this));
		panel.add(btnBuscarTodos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Persona48.png")));
		lblNewLabel.setBounds(661, 11, 64, 83);
		panel.add(lblNewLabel);
		
		scrollPaneResidentes = new JScrollPane();
		scrollPaneResidentes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneResidentes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneResidentes.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneResidentes.setBounds(37, 127, 752, 268);
		contentPane.add(scrollPaneResidentes);
		
		residente= new JTable();
		tbResidentes = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				
			},
			new String[] {
				"IDResidente","Nombre", "Cedula", "Telefono", "Casa / Apto", "Num Vivienda", "ID Parqueadero"
			}
		);
		residente.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		residente.setModel(tbResidentes);
		scrollPaneResidentes.setViewportView(residente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Crear Residente", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		panel_2.setBounds(37, 427, 752, 78);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		btnGuardar = new JButton("modificar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(152, 21, 133, 41);
		panel_2.add(btnGuardar);
		btnGuardar.setToolTipText("");
		btnGuardar.addActionListener(new ControladorResidente(this));
		btnGuardar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Guardar32.png")));
		
		JButton btnLimpiar = new JButton("limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.setBounds(472, 21, 112, 40);
		panel_2.add(btnLimpiar);
		btnLimpiar.setToolTipText("");
		btnLimpiar.setIcon(new ImageIcon(VistaResidentes.class.getResource("/iconos/Limpiar32.png")));
		tbapartamento = new DefaultTableModel(
			new Object[][] {
				{"", "", "", null},
			
			},
			new String[] {
				"IDApartamento", "Apartamento", "Bloque", "Piso"
			}
		);
		
		
	}
	
	
}
