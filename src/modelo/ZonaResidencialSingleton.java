package modelo;

import java.util.List;
import java.util.Properties;

import modelo.DAO.DAOZonaResidencial;



public class ZonaResidencialSingleton {
	private int id;
	private String direccion;
	private String nombre;
	private SAdministrador sadministrador;
	private List<Vivienda> vivienda;

	private static ZonaResidencialSingleton singleton;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	private ZonaResidencialSingleton(String direccion, String nombre) {
		DAOZonaResidencial zona = new DAOZonaResidencial();
		this.direccion = direccion;
		this.nombre = nombre;
		
	}

	private static synchronized void createInstance() {
		if (singleton == null) {
			singleton = new ZonaResidencialSingleton();
		}
	}

	public static ZonaResidencialSingleton getInstance() {
		if (singleton == null) {
			createInstance();
		}
		return singleton;
	}

	public static ZonaResidencialSingleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(ZonaResidencialSingleton singleton) {
		ZonaResidencialSingleton.singleton = singleton;
	}
	

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SAdministrador getSadministrador() {
		return sadministrador;
	}

	public void setSadministrador(SAdministrador sadministrador) {
		this.sadministrador = sadministrador;
	}

	public List<Vivienda> getVivienda() {
		return vivienda;
	}

	public void setVivienda(List<Vivienda> vivienda) {
		this.vivienda = vivienda;
	}

}
