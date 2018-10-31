package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ZonaResidencialSingleton;
import vista.VistaZonaR;

public class ControladorZonaResidencial implements ActionListener {
	
	private final VistaZonaR zonar;
	
	public ControladorZonaResidencial (VistaZonaR zonar) {
		this.zonar = zonar;		
	}

	@Override
	public void actionPerformed(ActionEvent llamar) {
		
		if(llamar.getSource() == zonar.btnMostrar){
			
			ZonaResidencialSingleton zr = ZonaResidencialSingleton.getInstance();
			
		
			
		}
		
		
		
	}
	
	
	

}
