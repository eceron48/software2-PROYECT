package modelo;

import java.util.List;

public class ZonaResidencialSingleton {
private int estrato;
private String direccion;
private String nombre;
private SAdministrador sadministrador;
private List<Vivienda>vivienda;

private static ZonaResidencialSingleton singleton;


public int getEstrato() {
	return estrato;
}


public void setEstrato(int estrato) {
	this.estrato = estrato;
}


public String getDireccion() {
	return direccion;
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


public void createInstance() {

	
}
/*public  ZonaResidencial getInstance() {
	return  ZonaResidencial;
}*/
}
