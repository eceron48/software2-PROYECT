package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			PersonaBuilder residentebuilder = new ResidenteBuilder(vr);
			fabricabuilder.setpersonabuilder(residentebuilder);
			fabricabuilder.construirPersona();
			
			Persona persona=fabricabuilder.getpersona();
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
			 List<Persona> lista= new ArrayList<>();
            Persona p;
             
             
            for(int i=this.vr.tbResidentes.getRowCount(); i>0; i--){
                this.vr.tbResidentes.removeRow(i-1);
            }
             DAOResidente dao = new DAOResidente();

             {
                 try {
                     lista=dao.mostrarTodoResidente();
                 } catch (SQLException ex) {
                     Logger.getLogger( ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }


             Iterator<Persona> itr = lista.iterator();
             while(itr.hasNext()){
                 p=(Persona) itr.next();
                 this.vr.tbResidentes.addRow( new Object[]{p.getNombre(),p.getCedula(),p.getTelefono(),p.getVivienda().getVrol(),p.getVivienda().getIdvivienda(),p.getVivienda().getParqueadero().getCodigo()});
             }
            
			
			
			
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
