package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
	public VistaPrincipal() {
		setTitle("ZONAS RESIDENCIALES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 479);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 153), null, null, null));
		setJMenuBar(menuBar);
		
		JMenu Administracion = new JMenu("Administracion");
		Administracion.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Candado1.png")));
		menuBar.add(Administracion);
		
		JButton btnGestionarSuperadmin = new JButton("  Gestionar  SuperAdmin");
		btnGestionarSuperadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionarSuperadmin.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/SuperAdmin.png")));
		Administracion.add(btnGestionarSuperadmin);
		
		JButton btnGestionarAdmin = new JButton("Gestionar Administrador");
		btnGestionarAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAdministrador vistaAdmin = new VistaAdministrador();
				vistaAdmin.setVisible(true);			
				
			}
		});
		btnGestionarAdmin.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Admin.png")));
		Administracion.add(btnGestionarAdmin);
		
		JMenu Pagos = new JMenu("Pagos");
		Pagos.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Moneda (2).png")));
		menuBar.add(Pagos);
		
		JButton btnRegistrarCuota = new JButton("      Registrar  Cuota");
		btnRegistrarCuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRegistrarCuota registrarCuota = new VistaRegistrarCuota();
				registrarCuota.setVisible(true);
			}
		});
		btnRegistrarCuota.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Registrar.png")));
		Pagos.add(btnRegistrarCuota);
		
		JButton btnPagoAdministracion = new JButton("Pago Administracion");
		btnPagoAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaPagoAdministracion pagoAdministracion = new VistaPagoAdministracion();
				pagoAdministracion.setVisible(true);
			}
		});
		btnPagoAdministracion.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Pago.png")));
		Pagos.add(btnPagoAdministracion);
		
		JMenu GestionarPersonas = new JMenu("Gestionar Personas");
		GestionarPersonas.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Personas.png")));
		menuBar.add(GestionarPersonas);		
		
		JButton btnResidentes = new JButton("Residentes");		
		btnResidentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaResidentes residente = new VistaResidentes();
				residente.setVisible(true);				
			}
		});
		btnResidentes.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Casa.png")));
		GestionarPersonas.add(btnResidentes);
		
		JButton btnVisitantes = new JButton("  Visitantes");
		btnVisitantes.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Visitantes.png")));
		GestionarPersonas.add(btnVisitantes);
		
		JButton btnEmpleados = new JButton(" Empleados");
		btnEmpleados.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Empleado.png")));
		GestionarPersonas.add(btnEmpleados);
		
		JMenu Parqueadero = new JMenu("Parqueadero");
		Parqueadero.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Parqueadero.png")));
		menuBar.add(Parqueadero);
		
		JButton btnGestionarParqueadero = new JButton("Gestionar Parqueadero");
		btnGestionarParqueadero.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Carro.png")));
		Parqueadero.add(btnGestionarParqueadero);
		
		JMenu ZonasResidenciales = new JMenu("Zonas Residenciales");
		ZonasResidenciales.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Vivienda.png")));
		menuBar.add(ZonasResidenciales);
		
		JButton btnCrearVivienda = new JButton("Crear Zona Residencial");
		btnCrearVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaZonaR crearZona = new VistaZonaR();
				crearZona.setVisible(true);
			}
		}); 
		btnCrearVivienda.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Home.png")));
		ZonasResidenciales.add(btnCrearVivienda);
		
		JButton btnModificarVivienda = new JButton("Modificar Vivienda");
		btnModificarVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaModificarVivienda modificarVivienda = new VistaModificarVivienda();
				modificarVivienda.setVisible(true);
			}
		});
		btnModificarVivienda.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Herramienta.png")));
		ZonasResidenciales.add(btnModificarVivienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel ImageApto = new JLabel("");
		ImageApto.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/iconos/Apartamentos.jpg")));
		ImageApto.setBounds(0, 0, 738, 379);
		panel.add(ImageApto);
	}

}
