package modelo.adapter;

public class CreditoAdapter extends MedioDePago {
	
private CreditoAdapter creditoAdapter = new CreditoAdapter();
	
	public CreditoAdapter() {
		super();
		this.creditoAdapter = new CreditoAdapter();
		System.out.println("Creando con tarjeta credito adapter");	
	}

	@Override
	public void pagar() {
		// TODO Auto-generated method stub
		
	}
	

}
