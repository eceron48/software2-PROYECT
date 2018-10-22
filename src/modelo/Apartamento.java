package modelo;

public class Apartamento extends Vivienda{
	private  String idApartamento;
	private  int piso;
	private  String bloque;

	public Apartamento(String idApartamento,int piso,String bloque,int idap) {
		this.bloque=bloque;
		this.idApartamento=idApartamento;
	
	}
	
	
	Apartamento(){
		
	}
	
	
	



	public Apartamento(String vrol, String idvivienda, int id, Parqueadero parqueadero,int piso) {
		super(vrol, idvivienda, id, parqueadero);
		this.piso=piso;
		
	}


	public String getIdApartamento() {
		return idApartamento;
	}
	public void setIdApartamento(String idApartamento) {
		this.idApartamento = idApartamento;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getBloque() {
		return bloque;
	}
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}
	

}
