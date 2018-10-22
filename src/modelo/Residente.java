package modelo;

public class Residente extends Persona {
	private Vivienda vivienda;
	private CuotaAdministracion cuota;
	
	public Residente() {
		
	}

	

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public CuotaAdministracion getCuota() {
		return cuota;
	}

	public void setCuota(CuotaAdministracion cuota) {
		this.cuota = cuota;
	}
	
	
}
