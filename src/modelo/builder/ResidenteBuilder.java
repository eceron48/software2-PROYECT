package modelo.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Persona;
import modelo.Residente;
import vista.VistaResidentes;

public class ResidenteBuilder extends PersonaBuilder {
	private final VistaResidentes v;

	public ResidenteBuilder(VistaResidentes v) {
		this.v = v;
		super.persona = new Persona();

	}

	@Override
	public void construirNombre() {
		persona.setNombre(v.txtGuardarNombre.getText().toString());

	}

	@Override
	public void construirTelefono() {
		persona.setTelefono(v.txtGuardarTelefono.getText().toString());
	}

	@Override
	public void construirCedula() {
		persona.setCedula(v.txtGuardarCedula.getText().toString());

	}

	@Override
	public void construirFechaEntrada() {

	}

	@Override
	public void construirFechaSalida() {

	}

	@Override
	public void construirRol() {
		
		int id = v.comboRol.getSelectedIndex();
		if (id == -1) {			
			JOptionPane.showMessageDialog(null, "No ha seleccionado nigun dato");
		}else {
			
			String rol = v.comboRol.getSelectedItem().toString();
			persona.setRol(rol);
			
			}
	
		}	

}
