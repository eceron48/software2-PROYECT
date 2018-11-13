package modelo.cifrado;

public class sha1 implements cifrador {

	@Override
	public String cifrar(String cadena) {
		System.out.println("sha1");

		return utils.getSHA1(cadena);
	}

}
