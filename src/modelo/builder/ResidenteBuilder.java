package modelo.builder;

import modelo.Persona;
import vista.VistaResidentes;

public class ResidenteBuilder extends PersonaBuilder {
	 VistaResidentes v=new VistaResidentes();
	
	public ResidenteBuilder(){
		super.persona=new Persona();
	
	}



	@Override
	public void construirNombre() {
			persona.setNombre(v.txtNombre.getText().toString());
	
	}
	@Override
	public void construirDireccion() {
	
		
	}

	@Override
	public void construirTelefono() {
		persona.setTelefono(Integer.parseInt(v.txtTelefono.getText()));
		
	}

	@Override
	public void construirCedula() {
		persona.setCedula(v.txtCedula.getText().toString());
		
	}

	@Override
	public void construirFechaEntrada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void construirFechaSalida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void construirapartamento() {
	
	
	}
	@Override
	public void construirparqueadero() {
		// TODO Auto-generated method stub
		
	}
	
	

}
