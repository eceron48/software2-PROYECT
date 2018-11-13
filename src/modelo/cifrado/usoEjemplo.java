package modelo.cifrado;


public class usoEjemplo {
	 public static void main(String[] args) {
	        usador[] cifrados = new usador[2];
	        cifrados[0] = new usadorGeneral(new md5());
	        cifrados[1] = new usadorGeneral(new sha1());
	        for(usador usadores:cifrados)
	            System.out.println(usadores.cifrar("12345678999"));
	    }
}
