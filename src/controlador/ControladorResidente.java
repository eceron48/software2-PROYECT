package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.DAOResidente;
import modelo.Persona;
import modelo.builder.FabricaBuilder;
import modelo.builder.PersonaBuilder;
import modelo.builder.ResidenteBuilder;
import vista.VistaResidentes;

public class ControladorResidente implements ActionListener  {
	
	private final VistaResidentes vr;
	
	public ControladorResidente(VistaResidentes vr) {
		this.vr=vr;
	}
	

	@Override
	public void actionPerformed(ActionEvent llamar) {
		switch (llamar.getActionCommand()) {
		
		case "guardar":
			FabricaBuilder fabricabuilder=new FabricaBuilder();
			PersonaBuilder residentebuilder = new ResidenteBuilder();
			fabricabuilder.setpersonabuilder(residentebuilder);
			fabricabuilder.construirPersona();
			
			Persona persona=fabricabuilder.getpersona();
					System.out.println("telefono "+persona.getTelefono());
				DAOResidente dr=new DAOResidente();
			try {
				dr.insertar(persona);
				
				vr.txtCedula.setText("");
				vr.txtNombre.setText("");
				vr.txtTelefono.setText(null);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			
			break;
			
		case"buscar":
			
			
			break;
			
		case"buscar todos":
			
			break;
		case"eliminar":
			
			break;
		case"modificar":
			
			break;
		case"limpiar":
			
			
			break;
		default :
			JOptionPane.showMessageDialog(null, "error de sistema contacte a un tecnico " ,null, 3);
			break;
			
			
		}
		
	}
	
	

}
