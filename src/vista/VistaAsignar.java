package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorAsignarVivienda;
import modelo.residente.implementar.AsignarViviendaResidente;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class VistaAsignar extends JFrame {

	public JPanel contentPane;
	public JTextField txtValorCuota;
	public JTable tbAsignarPersonas;
	public JTable tbAsignarViviendas;
	public JTable tbAsignarParqueaderos;
	public JButton btnMostrarValor;
	public JButton btnMostrarPersonas;
	public JButton btnMostrarViviendas;
	public JButton btnMostrarParqueaderos;
	public JButton btnAsignarPersonas;
	public DefaultTableModel tablaAsignarPersonas;
	public DefaultTableModel tablaAsignarViviendas;
	public DefaultTableModel tablaAsignarPark;
	public JTextField textporcentaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAsignar frame = new VistaAsignar();
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
	public VistaAsignar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValorCuota = new JLabel("Valor Cuota:");
		lblValorCuota.setBounds(20, 32, 84, 14);
		contentPane.add(lblValorCuota);
		
		txtValorCuota = new JTextField();
		txtValorCuota.setEditable(false);
		txtValorCuota.setBounds(114, 29, 153, 20);
		contentPane.add(txtValorCuota);
		txtValorCuota.setColumns(10);
		
		btnMostrarValor = new JButton("mostrar");
		btnMostrarValor.setIcon(new ImageIcon(VistaAsignar.class.getResource("/iconos/Ver32.png")));
		btnMostrarValor.setBounds(431, 11, 124, 40);
		btnMostrarValor.addActionListener(new ControladorAsignarVivienda(this));
		contentPane.add(btnMostrarValor);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 191, 216));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 57, 733, 133);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 469, 93);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		tbAsignarPersonas = new JTable();
		tablaAsignarPersonas = new DefaultTableModel(new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "C\u00E9dula", "Nombre", "Tel\u00E9fono"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbAsignarPersonas.setModel(tablaAsignarPersonas);
		scrollPane.setViewportView(tbAsignarPersonas);
		
		btnMostrarPersonas = new JButton("mostrar personas");
		btnMostrarPersonas.setIcon(new ImageIcon(VistaAsignar.class.getResource("/iconos/Personas.png")));
		btnMostrarPersonas.addActionListener(new ControladorAsignarVivienda(this));
		btnMostrarPersonas.setBounds(534, 72, 189, 50);
		panel.add(btnMostrarPersonas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 191, 216));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Viviendas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 201, 733, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 20, 514, 88);
		panel_1.add(scrollPane_1);
		
		tbAsignarViviendas = new JTable();
		tablaAsignarViviendas = new DefaultTableModel(new Object[][] {{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			}, 	new String[] { "ID", "Rol", "Bloque", "N\u00FAmero Vivienda", "Piso" }) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		
		tbAsignarViviendas.setModel(tablaAsignarViviendas);
		scrollPane_1.setViewportView(tbAsignarViviendas);
		
		btnMostrarViviendas = new JButton("mostrar viviendas");
		btnMostrarViviendas.setIcon(new ImageIcon(VistaAsignar.class.getResource("/iconos/Vivienda.png")));
		btnMostrarViviendas.addActionListener(new ControladorAsignarVivienda(this));
		btnMostrarViviendas.setBounds(534, 35, 195, 57);
		panel_1.add(btnMostrarViviendas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 191, 216));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Parqueaderos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(20, 345, 726, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(10, 26, 350, 93);
		panel_2.add(scrollPane_2);
		
		tbAsignarParqueaderos = new JTable();
		tablaAsignarPark = new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "N\u00FAmero"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		tbAsignarParqueaderos.setModel(tablaAsignarPark);
		scrollPane_2.setViewportView(tbAsignarParqueaderos);
		
		btnMostrarParqueaderos = new JButton("mostrar parqueaderos");
		btnMostrarParqueaderos.setIcon(new ImageIcon(VistaAsignar.class.getResource("/iconos/Parqueadero.png")));
		btnMostrarParqueaderos.addActionListener(new ControladorAsignarVivienda(this));
		btnMostrarParqueaderos.setBounds(481, 42, 235, 57);
		panel_2.add(btnMostrarParqueaderos);
		
		btnAsignarPersonas = new JButton("asignar");
		btnAsignarPersonas.setIcon(new ImageIcon(VistaAsignar.class.getResource("/iconos/Registrar.png")));
		btnAsignarPersonas.addActionListener(new ControladorAsignarVivienda(this));
		btnAsignarPersonas.setBounds(322, 489, 145, 49);
		contentPane.add(btnAsignarPersonas);
		
		JLabel lblNewLabel = new JLabel("porcentaje");
		lblNewLabel.setBounds(277, 32, 70, 14);
		contentPane.add(lblNewLabel);
		
		textporcentaje = new JTextField();
		textporcentaje.setEditable(false);
		textporcentaje.setBounds(347, 29, 37, 20);
		contentPane.add(textporcentaje);
		textporcentaje.setColumns(10);
	}


}

