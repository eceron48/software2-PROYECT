package modelo.bridge;

public abstract class CrearVivienda {
	
	private ICrearVivienda icrearVivienda;
	
	public CrearVivienda(ICrearVivienda icrearVivienda) {
		this.icrearVivienda = icrearVivienda;
	}
	
	public abstract void crearVivienda();
	

}
