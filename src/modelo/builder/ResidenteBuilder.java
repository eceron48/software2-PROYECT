package modelo.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Persona;
import vista.VistaResidentes;

public class ResidenteBuilder extends PersonaBuilder{
	VistaResidentes v = new VistaResidentes();

	public ResidenteBuilder() {
		super.persona = new Persona();

	}
	


	@Override
	public void construirNombre() {
		
	//	persona.setNombre("carlos");
	
		persona.setNombre(v.txtNombre.getText().toString());
		System.out.println("nombre "+persona.getNombre());
	}

	@Override
	public void construirDireccion() {

	}

	@Override
	public void construirTelefono() {
	//	persona.setTelefono(123155);
		persona.setTelefono(Integer.parseInt(v.txtTelefono.getText()));
		System.out.println(persona.getTelefono());

	}

	@Override
	public void construirCedula() {
	//	persona.setCedula("cedula123");
		persona.setCedula(v.txtCedula.getText().toString());
		System.out.println("cc "+persona.getCedula());

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
