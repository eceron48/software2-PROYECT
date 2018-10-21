package modelo.adapter;

public class CreditoAdaptee {
	
private boolean pagado = false;
	
	public CreditoAdaptee() {
		System.out.println("Creando medio de pago credito");
		this.pagado = false;
	}
	
	public void pagar() {
		System.out.println("Pago realizado con credito");
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
