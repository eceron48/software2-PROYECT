package modelo.cifrado;

public class usadorGeneral implements usador{
	private cifrador cifrador;
 
	
	public usadorGeneral(cifrador cifrador){
        this.cifrador = cifrador;
    }
	@Override
	public String cifrar(String cadena) {
		// TODO Auto-generated method stub
		return this.cifrador.cifrar(cadena);
	}

}