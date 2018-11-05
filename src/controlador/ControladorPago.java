package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		
		break;
	case"mostrar pagos"	:
		
		
		
		break;
	
	case"registrar":
		
		
		
		break;
		
	default :
		JOptionPane.showMessageDialog(null, "error de logica contacte a un tecnico",null, 3);
		break;
	
	
	
	
	
	
	
	
	
	/* switch*/	}
	
	
	

	
/* evento */	}
	
	

}
