package modelo.residente.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.DAOResidente;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Residente;
import modelo.Vivienda;
import vista.VistaResidentes;

public class ResidenteBuilder extends PersonaBuilder{
	private final VistaResidentes v;
	Vivienda vi=new Vivienda();
	Parqueadero p=new Parqueadero();
	public ResidenteBuilder(VistaResidentes v) {
		this.v=v;
		super.persona = new Residente();
	

	}	


	@Override
	public void construirNombre() {
		
	
	
		persona.setNombre(v.txtNombre.getText().toString());
	
	}


	@Override
	public void construirTelefono() {

		persona.setTelefono(v.txtTelefono.getText().toString());
		

	}

	@Override
	public void construirCedula() {

		persona.setCedula(v.txtCedula.getText().toString());
	

	}

	

	@Override
	public void construirapartamento() {
		
		
		
		
		if ((this.v.apartamento.getSelectedRow())==-1) {
			
			//-----------------------------------------------------------construyo casa que solo tiene una id --------------------------------------------------------------//
		 String id=v.comboBoxvivienda.getSelectedItem().toString();
		 	vi.setIdvivienda(id);
		 
		 System.out.println("combocasa "+id);			
        }
        else {
        	//------------------------------------------------------construyo apartamento-------------------------------------------------------------------------------------------//
        	int fila = this.v.apartamento.getSelectedRow();
			System.out.println("fila appto " + fila);

			if (fila >= 0) {
			int ide = (int) this.v.tbapartamento.getValueAt(fila, 0);
				
			String dato=Integer.toString(ide);
				System.out.println("fila " + dato);
				vi.setIdvivienda(dato);
			} 
        	
        	
             JOptionPane.showMessageDialog(null,"No ha seleccionado nigun dato");
        }
			
	}

	@Override
	public void construirparqueadero() {
		 String id=v.comboBoxparqueadero.getSelectedItem().toString();
		p.setCodigo(id);
		vi.setParqueadero(p);
		persona.setVivienda(vi);
		
		 System.out.println("combo "+id);	
		 
	}
	
	






}
