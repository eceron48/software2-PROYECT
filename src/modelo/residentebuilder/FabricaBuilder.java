package modelo.residentebuilder;

import modelo.Persona;
import modelo.Residente;

public class FabricaBuilder {
	  private PersonaBuilder personabuilder;
	  
	    public void setpersonabuilder(PersonaBuilder pb) { 
	    	personabuilder = pb; }
	    
	    
	    public Residente getpersona() {
	    return personabuilder.obtenerPersona(); }
	 
	    public void construirPersona() {
	    	personabuilder.construirParqueadero();
	    	personabuilder.construirPersona();
	    	personabuilder.construirCuota();
	    	personabuilder.construirVivienda();
	      }

}
