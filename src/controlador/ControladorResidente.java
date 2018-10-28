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
import javax.swing.table.DefaultTableModel;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Parqueadero;
import modelo.Residente;
import modelo.Vivienda;
import modelo.DAO.DAOResidente;
import modelo.residente.builder.FabricaBuilder;
import modelo.residente.builder.PersonaBuilder;
import modelo.residente.builder.ResidenteBuilder;
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
			
			Residente persona=fabricabuilder.getpersona();
		System.out.println("vivenda "+	persona.getVivienda().getId());
		System.out.println("casa "+	persona.getVivienda().getIdvivienda());
		System.out.println("parqueadero "+	persona.getVivienda().getParqueadero().getCodigo());
			
				DAOResidente dr=new DAOResidente();
			try {
				dr.insertar(persona);
				
				
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			break;
			
		case"buscar":
			
			
			break;
			
		case"buscar todos":
			

			ArrayList<Casa>casa=new ArrayList<>();
			ArrayList<Apartamento>apartamento=new ArrayList<>();
			List<Residente> lista= new ArrayList<>();
			ArrayList<Parqueadero>parqueadero=new ArrayList<>();
            DAOResidente  dao = new DAOResidente();
         
            parqueadero=dao.llenarComboParqueadero();
            apartamento=dao.tablaApartamento();
               
                 try {
 
                	 casa=dao.llenarComboCasa();  
                	
                	 lista=dao.mostrarTodoResidente();
                	 for(int i=this.vr.tbResidentes.getRowCount(); i>0; i--){
                         this.vr.tbResidentes.removeRow(i-1);
                     }
                     
                     for(int i=this.vr.tbapartamento.getRowCount(); i>0; i--){
                         this.vr.tbapartamento.removeRow(i-1);
                     }
                     /*
                	   for(int i=0;i<parqueadero.size();i++) {
                  	 	// vr.comboBoxparqueadero.addItem(parqueadero.get(i));
              	 
                 	  }
                	  
                     	   for(int i=0;i<casa.size();i++) {
                      	 	 vr.comboBoxvivienda.addItem(casa.get(i));
                     	   }
                     	 */
              
                 	 for(Residente pe : lista){
                 		 
                 		System.out.println("ide "+pe.getId()); 
                 		System.out.println("nombre "+pe.getNombre()); 
                 		
                 	  this.vr.tbResidentes.addRow(new Object[]{pe.getId(),pe.getNombre(),pe.getCedula(),pe.getTelefono()});
                 	 }
                 	  
                 	 for(Apartamento ap : apartamento){
                 		System.out.println("idev "+ap.getId()); 
                 		System.out.println("nombrve "+ap.getIdvivienda()); 
                    	  this.vr.tbapartamento.addRow(new Object[]{ap.getId(),ap.getIdvivienda(),ap.getBloque(),ap.getPiso()});
                    	 }
                   
                    
                 } catch (SQLException ex) {
                     Logger.getLogger( ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
                 }
             
          

           	
           	 
			break;
		case"eliminar":
		//------------------------------------------------------------------------eliminar--------------------------------------------------------------------------------------------------------------	
			 int fila=this.vr.residente.getSelectedRow();
		     System.out.println("fila "+fila);
             
            if(fila>=0){
                DAOResidente daor= new DAOResidente();
                 String ide=(String) this.vr.tbResidentes.getValueAt(fila, 0);
                 System.out.println("fila "+ide);
                daor.delete(ide);
                
            }
            else
                 JOptionPane.showMessageDialog(null,"No ha seleccionado nigun dato");      
			
			break;
		case"modificar":
			
			 int fila1=this.vr.residente.getSelectedRow();
             if(fila1>=0){
            	 int id=(int) this.vr.tbResidentes.getValueAt(fila1, 0);
                 String nombre=(String) this.vr.tbResidentes.getValueAt(fila1, 1);
                 String cedula= (String) this.vr.tbResidentes.getValueAt(fila1, 2);
                 String telefono= (String) this.vr.tbResidentes.getValueAt(fila1, 3);
                 String vivienda=(String) this.vr.tbResidentes.getValueAt(fila1, 4);
                 String idvivienda=(String) this.vr.tbResidentes.getValueAt(fila1, 5);
                 String parqueaderoU =(String) this.vr.tbResidentes.getValueAt(fila1, 6);
                 
                 
                 Vivienda v=new Vivienda();
                 Parqueadero estacionamiento=new Parqueadero();
                 v.setVrol(vivienda);
                 v.setIdvivienda(idvivienda);
                 estacionamiento.setCodigo(parqueaderoU);
                 v.setParqueadero(estacionamiento);
                 
                 Residente r= new Residente();
                DAOResidente daor= new DAOResidente();
                r.setCedula(cedula);
                r.setNombre(nombre);
                r.setTelefono(telefono);
                r.setVivienda(v);                
                 daor.modificarResidente(r);
                 for(int i=this.vr.tbResidentes.getRowCount(); i>0; i--){
                     this.vr.tbResidentes.removeRow(i-1);
                 }
                 
             }
			
			break;
			
		case"limpiar":
			
			
			break;
		default :
			JOptionPane.showMessageDialog(null, "error de sistema contacte a un tecnico " ,null, 3);
			break;
			
			
		}
		
	}
	
	

}
