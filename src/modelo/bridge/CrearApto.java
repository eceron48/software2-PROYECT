package modelo.bridge;

public class CrearApto extends CrearVivienda {
	
	public CrearApto(ICrearVivienda icrearVivienda) {
		super(icrearVivienda);
	}

	@Override
	public void crearVivienda() {
		System.out.println("Creando apartamento...");		
	}
	
	
}
