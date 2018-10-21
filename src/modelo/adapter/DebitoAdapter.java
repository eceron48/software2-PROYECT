package modelo.adapter;

public class DebitoAdapter extends MedioDePago {
	
	private DebitoAdapter debitoAdapter = new DebitoAdapter();
	
	public DebitoAdapter() {
		super();
		this.debitoAdapter = new DebitoAdapter();
		System.out.println("Creando con tarjeta debito adapter");	
	}

	@Override
	public void pagar() {
		// TODO Auto-generated method stub
		
	}
	

}
