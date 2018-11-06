package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Persona;
import modelo.Residente;
import vista.VistaPagoAdministracion;
import vista.VistaResidentes;

public class ControladorPago implements ActionListener {
	
	private final VistaPagoAdministracion vistaPago;

	public ControladorPago(VistaPagoAdministracion vistaPago) {
		this.vistaPago = vistaPago;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	switch(e.getActionCommand()) {
	
	case"buscar":
		Double suma = 0.0;
	
		if(!vistaPago.txtCedula.getText().isEmpty()) {
			Residente p = new Residente();	
			Administrador adminiBuscar = new Administrador();
			

		try {
			
			p = adminiBuscar.registrarPagos().buscarPersona(vistaPago.txtCedula.getText().toString());
			
			
			vistaPago.txtNombre.setText(p.getNombre());
			vistaPago.txtCedula.setText(p.getCedula());
		
		
	
			for (int i = this.vistaPago.tbpersonas.getRowCount(); i > 0; i--) {
				this.vistaPago.tbpersonas.removeRow(i - 1);
			}

			this.vistaPago.tbpersonas
					.addRow(new Object[] { p.getCedula(), p.getNombre(),p.getCuota().getTotal() ,p.getCuota().getUltimoPago(),p.getCuota().getObservacion() });
			suma=suma+p.getCuota().getTotal();
			
		}
		
			catch (Exception ex) {
				
			JOptionPane.showMessageDialog(null, "el documento ingresado no fue encontrado intente de nuevo ",null, 3);
		}
		vistaPago.txtTotal.setText(suma.toString());
		}else {
			JOptionPane.showMessageDialog(null, "por favor ingrese una cedula para comenzar la busqueda ", null, 2);
		}
		
		break;
		
		//--------------------------------------------------end--------------------------------------end-------------------------------------------------------------------------------------//
	case"mostrar pagos"	:
		
			ArrayList<Residente>listado=new ArrayList<Residente>();	
			Administrador adminiBuscar = new Administrador();

		try {
			
			listado = adminiBuscar.registrarPagos().mostrarTodos();
			
			
			
						//borrar tabla//
			for (int i = this.vistaPago.tbpersonas.getRowCount(); i > 0; i--) {
				this.vistaPago.tbpersonas.removeRow(i - 1);
			}
						//crear tabla//
			for(Residente p:listado) {

			this.vistaPago.tbpersonas
					.addRow(new Object[] { p.getCedula(), p.getNombre(),p.getCuota().getTotal() ,p.getCuota().getUltimoPago(),p.getCuota().getObservacion() });

			}
		}
			catch (Exception ex) {
				
			JOptionPane.showMessageDialog(null, "no se ha encontrado archivos",null, 3);
		}
	
		
		
		break;
	
	case"registrar":
		
		
		
		
		
		
		break;
		
	default :
		JOptionPane.showMessageDialog(null, "error de logica contacte a un tecnico",null, 3);
		break;
	
	
	
	
	
	
	
	
	
	/* switch*/	}
	
	
	

	
/* evento */	}
	
	

}
