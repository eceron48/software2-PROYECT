package modelo.adapter;

import vista.VistaPagoAdministracion;

public class DebitoAdapter extends MedioDePago {

	private final VistaPagoAdministracion vistapagoadm;
	private DebitoAdaptee debitoAdapter;
	

	public DebitoAdapter(VistaPagoAdministracion vistapagoadm) {
		super();
		this.debitoAdapter = new DebitoAdaptee(vistapagoadm);
		this.vistapagoadm=vistapagoadm;
	}


	@Override
	public void pagar() {
		
		try {this.debitoAdapter.realizarTransaccion();
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.debitoAdapter.pagar();

		
	}



}
