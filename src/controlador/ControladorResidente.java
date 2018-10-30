package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Administrador;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Residente;
import modelo.Vivienda;
import modelo.builder.FabricaBuilder;
import modelo.builder.PersonaBuilder;
import modelo.builder.ResidenteBuilder;
import vista.VistaResidentes;

public class ControladorResidente implements ActionListener {

	private final VistaResidentes vr;

	public ControladorResidente(VistaResidentes vr) {
		this.vr = vr;
	}

	@Override
	public void actionPerformed(ActionEvent llamar) {
		switch (llamar.getActionCommand()) {

		case "guardar":
			
			
			FabricaBuilder fabricabuilder = new FabricaBuilder();
			PersonaBuilder residentebuilder = new ResidenteBuilder(vr);
			fabricabuilder.setpersonabuilder(residentebuilder);
			fabricabuilder.construirPersona();

			Persona persona = fabricabuilder.getpersona();
			if(vr.comboRol.getSelectedIndex()==0 ||persona.getCedula().isEmpty()|| persona.getNombre().isEmpty() ||persona.getTelefono().isEmpty() ){
				JOptionPane.showMessageDialog(null, "los datos rol cedula nombre telefono son de caracter obligatorio", null, 0);
				
			}else {
			
			Administrador admin = new Administrador();

			try {
				admin.gestionarPersona().insertar(persona);
				vr.txtGuardarCedula.setText("");
				vr.txtGuardarNombre.setText("");
				vr.txtGuardarTelefono.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			break;

		case "buscar":

			List<Persona> listaBuscar = new ArrayList<>();

			Administrador adminiBuscar = new Administrador();

			try {

				listaBuscar = adminiBuscar.gestionarPersona().mostrarTodoPersonas();
				for (int i = this.vr.tbResidentes.getRowCount(); i > 0; i--) {
					this.vr.tbResidentes.removeRow(i - 1);
				}

				for (Persona pe : listaBuscar) {

					this.vr.tbResidentes.addRow(
							new Object[] { pe.getId(), pe.getNombre(), pe.getCedula(), pe.getTelefono(), pe.getRol() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}

			break;

		case "mostrar todos":

			List<Persona> lista = new ArrayList<>();

			Administrador admini = new Administrador();

			try {

				lista = admini.gestionarPersona().mostrarTodoPersonas();
				for (int i = this.vr.tbResidentes.getRowCount(); i > 0; i--) {
					this.vr.tbResidentes.removeRow(i - 1);
				}

				for (Persona pe : lista) {


					this.vr.tbResidentes.addRow(
							new Object[] { pe.getId(), pe.getNombre(), pe.getCedula(), pe.getTelefono(), pe.getRol() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}

			break;
		case "eliminar":
			// ------------------------------------------------------------------------eliminar--------------------------------------------------------------------------------------------------------------
			int fila = this.vr.residente.getSelectedRow();
			int nombre = (int) this.vr.tbResidentes.getValueAt(fila, 0);
			System.out.println("fila " + fila);

			if (fila >= 0) {
				Administrador adminEliminar = new Administrador();

				adminEliminar.gestionarPersona().eliminarPersona(nombre);

			} else
				JOptionPane.showMessageDialog(null, "No ha seleccionado nigun dato");

			break;
		case "modificar":

			int fila1 = this.vr.residente.getSelectedRow();
			if (fila1 >= 0) {
				int id = (int) this.vr.tbResidentes.getValueAt(fila1, 0);
				String nombre1 = (String) this.vr.tbResidentes.getValueAt(fila1, 1);
				String cedula = (String) this.vr.tbResidentes.getValueAt(fila1, 2);
				String telefono = (String) this.vr.tbResidentes.getValueAt(fila1, 3);
				String rol = (String) this.vr.tbResidentes.getValueAt(fila1, 4);

				Persona persona1 = new Persona();
				Administrador adminModificar = new Administrador();

				persona1.setCedula(cedula);
				persona1.setNombre(nombre1);
				persona1.setTelefono(telefono);
				persona1.setRol(rol);
				adminModificar.gestionarPersona().modificarPersona(persona1);
				for (int i = this.vr.tbResidentes.getRowCount(); i > 0; i--) {
					this.vr.tbResidentes.removeRow(i - 1);
				}

			}

			break;

		case "limpiar":

			break;
		default:
			JOptionPane.showMessageDialog(null, "error de sistema contacte a un tecnico ", null, 3);
			break;

		}

	}

}
