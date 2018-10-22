package modelo;

public class Vivienda {
	private String vrol;
	private String  idvivienda;
	private int      id;
	private Parqueadero parqueadero;
	

	public Vivienda(String vrol, String idvivienda, int id, Parqueadero parqueadero) {
		super();
		this.vrol = vrol;
		this.idvivienda = idvivienda;
		this.id = id;
		this.parqueadero = parqueadero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "Vivienda # " + idvivienda + "";
	}
	
	

}
