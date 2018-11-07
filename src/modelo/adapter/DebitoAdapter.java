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
		this.debitoAdapter.pagar();
		this.debitoAdapter.realizarTransaccion();
		
	}



}
