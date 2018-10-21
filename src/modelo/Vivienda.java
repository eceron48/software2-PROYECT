package modelo;

public class Vivienda {
	private String vrol;
	private String  idvivienda;
	private Parqueadero parqueadero;
	
	
	public String getIdvivienda() {
		return idvivienda;
	}
	public void setIdvivienda(String idvivienda) {
		this.idvivienda = idvivienda;
	}
	public Vivienda () {
		
	}
	public String getVrol() {
		return vrol;
	}
	public void setVrol(String vrol) {
		this.vrol = vrol;
	}
	public Parqueadero getParqueadero() {
		return parqueadero;
	}
	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	

}
