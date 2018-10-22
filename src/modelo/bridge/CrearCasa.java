package modelo.bridge;

public class CrearCasa extends CrearVivienda {
	
	public CrearCasa(ICrearVivienda icrearVivienda) {
		super(icrearVivienda);
	}

	@Override
	public void crearVivienda() {
		System.out.println("Creando casa...");
	
		
	}
		
	

}
	