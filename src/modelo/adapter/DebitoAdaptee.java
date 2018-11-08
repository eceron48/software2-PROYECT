package modelo.adapter;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.CuotaAdministracion;
import modelo.Residente;
import vista.VistaPagoAdministracion;


public class DebitoAdaptee {
	

	private final VistaPagoAdministracion vistapagoadm;
	
	public DebitoAdaptee(VistaPagoAdministracion vistapagoadm) {
	
		
		this.vistapagoadm=vistapagoadm;
	}
	private boolean aprobar=false;
	private Residente persona1 = new Residente();
	
	public void realizarTransaccion() {
		//debito.setVisible(true);
		this.aprobar=true;
		JOptionPane.showMessageDialog(null, "solicitud debito aprobada",null, 1);
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
