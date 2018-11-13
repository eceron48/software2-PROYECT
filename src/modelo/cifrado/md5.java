package modelo.cifrado;

public class md5 implements cifrador {

	@Override
	public String cifrar(String cadena) {
		System.out.println("md5");

		return utils.getMD5(cadena);
	}

}