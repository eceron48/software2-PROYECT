package modelo;

public class Persona {
	private String nombre;
	private String cedula;
	private int    telefono;
	private Vivienda vivienda;
	private CuotaAdministracion cuota;
	private String rol;
	
	
	
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
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

	
	public Persona(String nombre, String cedula, int telefono, String string, String string2,
			String rol) {
		
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
	
		this.rol = rol;
	}
	public Persona(String nombre,String cedula,int telefono) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.telefono=telefono;
		
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


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
