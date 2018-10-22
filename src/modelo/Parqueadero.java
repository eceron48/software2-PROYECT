package modelo;

public class Parqueadero {
	private String codigo;
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Parqueadero() {

	}

	public Parqueadero(String codigo) {
		this.codigo=codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return ""+ codigo +"";
	}
	
	

}
