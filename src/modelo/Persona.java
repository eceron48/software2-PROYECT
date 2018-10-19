package modelo;

public class Persona {
	private String nombre;
	private String cedula;
	private int    telefono;
	private Parqueadero parqueadero;
	
	public Persona() {
		
	}
	public Persona(String nombre,String cedula,int telefono) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.telefono=telefono;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
