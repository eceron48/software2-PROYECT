package modelo.residente.builder;

import modelo.Persona;
import modelo.Residente;

public class FabricaBuilder {
	  private PersonaBuilder personabuilder;
	  
	    public void setpersonabuilder(PersonaBuilder pb) { 
	    	personabuilder = pb; }
	    
	    
	    public Residente getpersona() {
	    return personabuilder.obtenerPersona(); }
	 
	    public void construirPersona() {
	    	personabuilder.construirCedula();
	    	personabuilder.construirNombre();
	    	personabuilder.construirTelefono();
	    	personabuilder.construirapartamento();
	    	personabuilder.construirparqueadero();
	      }

}
