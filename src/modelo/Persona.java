package modelo;

public class Persona {
	private String nombre;
	private String cedula;
	private String telefono;
	private String rol;
	
	
	
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	

	
	public Persona(String nombre, String cedula, String telefono, String vrol, String prol,
		String rol) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.rol = prol;
	}
	public Persona(String nombre,String cedula,String telefono) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.telefono=telefono;
		
	}
	public Persona(Persona persona) {
		
	}

	public Persona() {
		// TODO Auto-generated constructor stub
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


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
