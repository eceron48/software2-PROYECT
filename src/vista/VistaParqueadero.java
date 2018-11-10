package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorParqueadero;

import javax.swing.ImageIcon;

public class VistaParqueadero extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombrePark;
	public JTable tbPark;
	public JButton btnModificarPark;
	public JButton btnMostrarPark;
	public JButton btnRegistrarPark;
	public DefaultTableModel parqueadero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaParqueadero frame = new VistaParqueadero();
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
	public VistaParqueadero() {
		setTitle("PARQUEADERO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 299);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreParqueadero = new JLabel("N\u00FAmero Parqueadero:");
		lblNombreParqueadero.setBounds(90, 24, 148, 14);
		contentPane.add(lblNombreParqueadero);
		
		txtNombrePark = new JTextField();
		txtNombrePark.setBounds(227, 21, 106, 20);
		contentPane.add(txtNombrePark);
		txtNombrePark.setColumns(10);
		
		btnRegistrarPark = new JButton("registrar");
		btnRegistrarPark.setIcon(new ImageIcon(VistaParqueadero.class.getResource("/iconos/Guardar32.png")));
		btnRegistrarPark.setBounds(464, 11, 135, 41);
		btnRegistrarPark.addActionListener(new ControladorParqueadero(this));
		contentPane.add(btnRegistrarPark);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 69, 574, 107);
		contentPane.add(scrollPane);
		
		tbPark = new JTable();
		parqueadero=new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID Parqueadero", "Nombre Parqueadero"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbPark.setModel(parqueadero);
		scrollPane.setViewportView(tbPark);
		
		btnModificarPark = new JButton("modificar");
		btnModificarPark.setIcon(new ImageIcon(VistaParqueadero.class.getResource("/iconos/Modificar32.png")));
		btnModificarPark.setBounds(257, 187, 142, 41);
		btnModificarPark.addActionListener(new ControladorParqueadero(this));
		contentPane.add(btnModificarPark);
		
		btnMostrarPark = new JButton("mostrar todos");
		btnMostrarPark.setIcon(new ImageIcon(VistaParqueadero.class.getResource("/iconos/BuscarTodo.png")));
		btnMostrarPark.setBounds(431, 187, 168, 41);
		btnMostrarPark.addActionListener(new ControladorParqueadero(this));
		contentPane.add(btnMostrarPark);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaParqueadero.class.getResource("/iconos/Carro.png")));
		lblNewLabel.setBounds(25, 11, 55, 44);
		contentPane.add(lblNewLabel);
	}
	

}
