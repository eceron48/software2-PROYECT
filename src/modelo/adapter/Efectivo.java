package modelo.adapter;

import java.awt.event.ActionListener;

import modelo.Administrador;
import modelo.CuotaAdministracion;
import modelo.Persona;
import modelo.Residente;
import vista.VistaPagoAdministracion;

public class Efectivo extends MedioDePago {
	private final VistaPagoAdministracion vistapagoadm;
	
	public Efectivo(VistaPagoAdministracion vistapagoadm) {
		super();
		this.vistapagoadm=vistapagoadm;
	}

	@Override
	public void pagar() {
		
		vistapagoadm.txtCedula.getText().toString();
		int fila1 = this.vistapagoadm.table.getSelectedRow();
		if (fila1 >= 0) {
			int id = (int) this.vistapagoadm.tbpersonas.getValueAt(fila1, 0);
			String cedula = (String) this.vistapagoadm.tbpersonas.getValueAt(fila1, 1);
			String nombre1 = (String) this.vistapagoadm.tbpersonas.getValueAt(fila1, 2);
			String observacion = (String) this.vistapagoadm.tbpersonas.getValueAt(fila1, 5);
			
			CuotaAdministracion cuota =new CuotaAdministracion();
			Residente persona1 = new Residente();
	
			Administrador adminModificar = new Administrador();
			persona1.setId(id);
			persona1.setCedula(cedula);
			persona1.setNombre(nombre1);
			cuota.setObservacion(observacion);
			
			persona1.setCuota(cuota);
		
			
			
			adminModificar.registrarPagos().registrarPagoEfectivo(persona1);
			/*
			for (int i = this.vistapagoadm.tbpersonas.getRowCount(); i > 0; i--) {
				this.vistapagoadm.tbpersonas.removeRow(i - 1);
			}
			*/

		}
		
		
		
	}
	
	

}
