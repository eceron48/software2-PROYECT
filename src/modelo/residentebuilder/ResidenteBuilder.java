package modelo.residentebuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Apartamento;
import modelo.CuotaAdministracion;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Residente;
import vista.VistaAsignar;
import vista.VistaResidentes;

public class ResidenteBuilder extends PersonaBuilder {
	private final VistaAsignar v;
	Apartamento apto = new Apartamento();
	public ResidenteBuilder(VistaAsignar v) {
		this.v = v;
		super.persona = new Residente();

	}

	@Override
	public void construirPersona() {
		int fila1 = this.v.tbAsignarPersonas.getSelectedRow();
		if (fila1 >= 0) {
			int id = (int) this.v.tablaAsignarPersonas.getValueAt(fila1, 0);
			String cedula = (String) this.v.tablaAsignarPersonas.getValueAt(fila1, 1);
			String nombre= (String) this.v.tablaAsignarPersonas.getValueAt(fila1, 2);
			String telefono = (String) this.v.tablaAsignarPersonas.getValueAt(fila1, 3);

			persona.setId(id);
			persona.setCedula(cedula);
			persona.setNombre(nombre);
			persona.setTelefono(telefono);
			
		}
		
	}

	@Override
	public void construirCuota() {
		CuotaAdministracion modificar=new CuotaAdministracion ();
		modificar.setCuota(Double.valueOf(v.txtValorCuota.getText()));
		modificar.setPorcentaje(Double.valueOf(v.textporcentaje.getText()));
		persona.setCuota(modificar);
		
	}

	@Override
	public void construirVivienda() {
		int fila1 = this.v.tbAsignarViviendas.getSelectedRow();
		if (fila1 >= 0) {
			int id = (int) this.v.tablaAsignarViviendas.getValueAt(fila1, 0);

		
				apto.setId(id);
				
				
				
		}
	

		
	}

	@Override
	public void construirParqueadero() {
		
	
		Parqueadero parqu=new Parqueadero();
		
		int fila1 = this.v.tbAsignarParqueaderos.getSelectedRow();
		
		if (fila1 >= 0) {
			int id = (int) this.v.tablaAsignarPark.getValueAt(fila1, 0);
			String nombre = (String) this.v.tablaAsignarPark.getValueAt(fila1, 1);
		
			parqu.setId(id);
			parqu.setCodigo(nombre);
			apto.setParqueadero(parqu);
			persona.setVivienda(apto);
	}

	}

}
