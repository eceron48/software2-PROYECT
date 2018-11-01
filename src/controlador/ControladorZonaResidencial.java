package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
			ZonaResidencialSingleton z=ZonaResidencialSingleton.getInstance();
			DAOZonaResidencial c=new DAOZonaResidencial();
			try {
				c.mostrarZona();
				zonar.txtNombreZona.setText(z.getNombre());
				zonar.txtDireccionZona.setText(z.getDireccion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}else {
		
		
		if(llamar.getSource()==zonar.btnModificar){
			String nombre =zonar.txtNombreZona.getText().toString();
			String direccion=zonar.txtDireccionZona.getText().toString();
			DAOZonaResidencial c=new DAOZonaResidencial();
			if(!zonar.txtNombreZona.getText().isEmpty() && !zonar.txtDireccionZona.getText().isEmpty()) {
			try {
				c.modificarZona(nombre, direccion);
				JOptionPane.showMessageDialog(null, "las modificaciones seran efectivas despues de reiniciar el sistema", direccion, 1);
				
				zonar.txtDireccionZona.setText("");
				zonar.txtNombreZona.setText("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				JOptionPane.showMessageDialog(null, "los campos nombre y direccion son de caracter obligatorio", direccion, 2);
			}
		
	}
	
		}
	
	}
}
