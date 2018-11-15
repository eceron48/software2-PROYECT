package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import controlador.ControladorResidente;
import modelo.Administrador;
import modelo.Apartamento;
import modelo.CuotaAdministracion;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Residente;
import modelo.SAdministrador;
import modelo.DAO.DAORegistrarCuota;
import modelo.residentebuilder.FabricaBuilder;
import modelo.residentebuilder.PersonaBuilder;
import modelo.residentebuilder.ResidenteBuilder;
import vista.VistaAsignar;

public class ControladorAsignarVivienda implements ActionListener{
	
	
	private final VistaAsignar vistaasignar;
	
	public ControladorAsignarVivienda(VistaAsignar vistaasignar){
		 this.vistaasignar=vistaasignar;
	 }

	@Override
	public void actionPerformed(ActionEvent bus) {
		
		
		switch(bus.getActionCommand()) {
		
		case"mostrar":
			CuotaAdministracion cuota;
			DAORegistrarCuota mostrar=new DAORegistrarCuota();
			try {
				
			cuota=mostrar.mostrarCuota();
			vistaasignar.txtValorCuota.setText(cuota.getCuota().toString());
			vistaasignar.textporcentaje.setText(cuota.getPorcentaje().toString());
			
			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			break;
			
		case"mostrar personas":
			List<Persona> lista = new ArrayList<>();

			Administrador admini = new Administrador();

			try {

				lista = admini.asignarTodoAResidente().mostrarTodoPersonas();
				for (int i = this.vistaasignar.tbAsignarPersonas.getRowCount(); i > 0; i--) {
					this.vistaasignar.tablaAsignarPersonas.removeRow(i - 1);
				}

				for (Persona pe : lista) {

					this.vistaasignar.tablaAsignarPersonas.addRow(
							new Object[] { pe.getId(),pe.getCedula(),  pe.getNombre(), pe.getTelefono() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}

		break;
		
		
		case"mostrar viviendas":
			List<Apartamento> listado = new ArrayList<>();

			Administrador administrador = new Administrador();

			try {

				listado = administrador.asignarTodoAResidente().mostrarTodoViviendas();
				for (int i = vistaasignar.tablaAsignarViviendas.getRowCount(); i > 0; i--) {
					this.vistaasignar.tablaAsignarViviendas.removeRow(i - 1);
				}

				for (Apartamento vi : listado) {

					this.vistaasignar.tablaAsignarViviendas.addRow(new Object[] { vi.getId(), vi.getVrol(), vi.getBloque(),
							vi.getIdApartamento(), vi.getPiso() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}

			

			
			
			break;
		case"mostrar parqueaderos":
			List<Parqueadero> listap = new ArrayList<>();

			Administrador admin = new Administrador();

			try {

				listap = admin.asignarTodoAResidente().mostrarParqueaderos();
				for (int i = this.vistaasignar.tablaAsignarPark.getRowCount(); i > 0; i--) {
					this.vistaasignar.tablaAsignarPark.removeRow(i - 1);
				}

				for (Parqueadero pe : listap) {

					this.vistaasignar.tablaAsignarPark.addRow(
							new Object[] { pe.getId(), pe.getCodigo() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			break;
		case"asignar":
			FabricaBuilder fabrica=new FabricaBuilder();
			PersonaBuilder residente=new ResidenteBuilder(vistaasignar);
			fabrica.setpersonabuilder(residente);
			fabrica.construirPersona();
			Residente res;
			res=fabrica.getpersona();
			
			System.out.println("id residente "+res.getId());
			System.out.println("id vivienda "+res.getVivienda().getId());
			System.out.println("id parqueadero"+res.getVivienda().getParqueadero().getId());
			System.out.println("id precio  "+res.getCuota().getCuota());
			System.out.println("id porcentaje "+res.getCuota().getPorcentaje());
			
			Administrador administrador1=new Administrador();
			
			try {
				administrador1.asignarTodoAResidente().agregarCuotaResidencial(res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				administrador1.asignarTodoAResidente().asignarVivienda(res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				administrador1.asignarTodoAResidente().cambiarEstadoDeResidente(res.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				administrador1.asignarTodoAResidente().cambiarEstadoParqueadero(res.getVivienda().getParqueadero().getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			vistaasignar.btnMostrarParqueaderos.doClick();
			vistaasignar.btnMostrarPersonas.doClick();
			vistaasignar. btnMostrarViviendas.doClick();
			
			
			break;

		default:

			JOptionPane.showMessageDialog(null, "error de seleccion contacte a un tecnico ", null, 0);
			
			break;
		
		
		
		}
	}

}
