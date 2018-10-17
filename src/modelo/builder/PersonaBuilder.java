package modelo.builder;

import modelo.Persona;

public abstract class PersonaBuilder {
	
protected Persona persona;
	
	public Persona obtenerPersona() {
		return persona;
	}
	public abstract void contruirNombre();
	public abstract void contruirDireccion();
	public abstract void contruirTelefono();
	public abstract void contruirCedula();
	public abstract void contruirFechaEntrada();
	public abstract void contruirFechaSalida();
	public abstract void contruirapartamento();
	

}
