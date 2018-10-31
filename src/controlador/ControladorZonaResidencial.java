package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelo.ZonaResidencialSingleton;
import modelo.DAO.DAOZonaResidencial;
import vista.VistaZonaR;

public class ControladorZonaResidencial implements ActionListener {
	
	private final VistaZonaR zonar;
	
	public ControladorZonaResidencial (VistaZonaR zonar) {
		this.zonar = zonar;		
	}

	@Override
	public void actionPerformed(ActionEvent llamar) {
		
		if(llamar.getSource() == zonar.btnMostrar){
		
			DAOZonaResidencial c=new DAOZonaResidencial();
			try {
				c.mostrarZona();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ZonaResidencialSingleton zr = ZonaResidencialSingleton.getInstance();
			zonar.txtNombreZona.setText(zr.getNombre());
			zonar.txtDireccionZona.setText(zr.getDireccion());
		}
		
		
		
	}
	
	
	

}
