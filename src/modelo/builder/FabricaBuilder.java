package modelo.builder;

import modelo.Persona;
import modelo.Residente;

public class FabricaBuilder {
	  private PersonaBuilder personabuilder;
	  
	    public void setpersonabuilder(PersonaBuilder pb) { 
	    	personabuilder = pb; }
	    
	    
	    public Persona getpersona() {
	    return personabuilder.obtenerPersona(); }
	 
	    public void construirPersona() {
	    	personabuilder.construirCedula();
	    	personabuilder.construirNombre();
	    	personabuilder.construirTelefono();
	      }

}
