package modelo.residente.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.DAOResidente;
import modelo.Persona;
import modelo.Residente;
import modelo.Vivienda;
import vista.VistaResidentes;

public class ResidenteBuilder extends PersonaBuilder{
	private final VistaResidentes v;
	
	
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
		
		
		
		Vivienda vivienda=new Vivienda();
		if ((this.v.apartamento.getSelectedRow())==-1) {
		 
        }
        else {
        	
        	int fila = this.v.apartamento.getSelectedRow();
			System.out.println("fila " + fila);

			if (fila >= 0) {
				int ide = (int) this.v.tbResidentes.getValueAt(fila, 0);
				vivienda.setId(ide);
				System.out.println("fila " + ide);
			} 
        	
        	
             JOptionPane.showMessageDialog(null,"No ha seleccionado nigun dato");
        }
			persona.setVivienda(vivienda);
	}

	@Override
	public void construirparqueadero() {
		// TODO Auto-generated method stub

	}


	

	






}
