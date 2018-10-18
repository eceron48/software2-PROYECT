package modelo.builder;

import modelo.Persona;

public class FabricaBuilder {
	  private PersonaBuilder personabuilder;
	  
	    public void setpersonabuilder(PersonaBuilder pb) { 
	    	personabuilder = pb; }
	    
	    
	    public Persona getpersona() {
	    return personabuilder.obtenerPersona(); }
	 
	    public void construirPersona() {
	    	personabuilder.construirNombre();
	    	personabuilder.construirCedula();
	    	personabuilder.construirTelefono();
	    }

}
