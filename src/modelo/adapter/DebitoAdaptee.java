package modelo.adapter;

public class DebitoAdaptee {
	
	private boolean pagado = false;
	
	public DebitoAdaptee() {
		System.out.println("Creando medio de pago debito");
		this.pagado = false;
	}
	
	public void pagar() {
		System.out.println("Pago realizado con debito");
		this.pagado = true;
	}
	
	public void realizarTransaccion () {
		if (!this.pagado) {
			System.out.println("No se puede realizar la transaccion"
					+"por que no tiene saldo");			
		}else {
			System.out.println("Transaccion realizada"
					+ "con exito");
		}
		
	}

}
