package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Persona;
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
		Persona p = new Persona();
		Administrador adminiBuscar = new Administrador();
		

		try {
			p = adminiBuscar.gestionarPersona().buscarPersona(vistaPago.txtCedula.getText().toString());
			for (int i = this.vistaPago.tbpersonas.getRowCount(); i > 0; i--) {
				this.vistaPago.tbpersonas.removeRow(i - 1);
			}

			this.vistaPago.tbpersonas
					.addRow(new Object[] { p.getCedula(), p.getNombre(), 315,"no avaible yet", "estado","observaciones" });

		} catch (SQLException ex) {
			Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
		}
		
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
