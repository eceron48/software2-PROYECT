package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VistaParqueadero;

public class ControladorParqueadero implements ActionListener {
private final VistaParqueadero parqueadero;
public ControladorParqueadero( VistaParqueadero parqueadero){
	this.parqueadero=parqueadero;
}
@Override
public void actionPerformed(ActionEvent ev) {
	
	switch(ev.getActionCommand()) {
	
	case"registrar":
		
		break;
	case"modificar":
		
		break;
	case"mostrar todos":
		
		break;
	
	
	default :
		
		JOptionPane.showMessageDialog(null, "error de seleccion contacte a un tecnico ", null, 0);
		break;
	
	
	}
	
	
}
	
}
