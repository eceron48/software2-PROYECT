package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaResidentes;

public class ControladorResidente implements ActionListener {
	
	private final VistaResidentes vr;
	
	public ControladorResidente(VistaResidentes vr) {
		this.vr=vr;
	}
	

	@Override
	public void actionPerformed(ActionEvent llamar) {
		switch (llamar.getActionCommand()) {
		
		case "guardar":
			
			
			break;
			
		case""	
		}
		
	}
	
	

}
