package modelo;

public class CuotaAdministracion {
	private Double cuota;
	private Double total;
	private Double porcentaje;
	private int idcuota;
	
	
	

	public int getIdcuota() {
		return idcuota;
	}

	public void setIdcuota(int idcuota) {
		this.idcuota = idcuota;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Double getCuota() {
		return cuota;
	}

	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public CuotaAdministracion() {

	}

	public Double calcularCuota(Double cuota, Double estratoiva) {
		this.total = cuota * estratoiva;
		this.total = this.total + cuota;
		return this.total;
	}

}
