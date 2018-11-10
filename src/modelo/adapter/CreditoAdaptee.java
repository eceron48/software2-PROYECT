package modelo.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.CuotaAdministracion;
import modelo.Residente;
import vista.VistaPagoAdministracion;


public class CreditoAdaptee {
	private final VistaPagoAdministracion vistapagoadm;
	
	public  CreditoAdaptee(VistaPagoAdministracion vistapagoadm) {
		this.vistapagoadm=vistapagoadm;
	}
	
	private Residente persona1 = new Residente();

	private boolean aprobar=false;
	

	public void realizarTransaccion () {
	this.aprobar=true;
		//credito.setVisible(true);
	JOptionPane.showMessageDialog(null, "solicitud credito aprobada",null, 1);
		}
	
	public void pagar() {
		vistapagoadm.txtCedula.getText().toString();
		int fila1 = this.vistapagoadm.table.getSelectedRow();
		if (fila1 >= 0) {
			int id = (int) this.vistapagoadm.tbpersonas.getValueAt(fila1, 0);
			String cedula = (String) this.vistapagoadm.tbpersonas.getValueAt(fila1, 1);
			String nombre1 = (String) this.vistapagoadm.tbpersonas.getValueAt(fila1, 2);
			String observacion = (String) this.vistapagoadm.tbpersonas.getValueAt(fila1, 5);
			
			CuotaAdministracion cuota =new CuotaAdministracion();
			
	
			
			persona1.setId(id);
			persona1.setCedula(cedula);
			persona1.setNombre(nombre1);
			cuota.setObservacion(observacion);
			persona1.setCuota(cuota);
			Administrador adminModificar = new Administrador();
			adminModificar.registrarPagos().registrarPagoEfectivo(persona1);
	}

	}
	
		
	

}
