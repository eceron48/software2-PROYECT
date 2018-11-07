package modelo.adapter;

import vista.VistaPagoAdministracion;
import vista.VistaPagoCredito;

public class CreditoAdapter extends MedioDePago {
	
	private final VistaPagoAdministracion vistapagoadm;
private CreditoAdaptee creditoAdapter;
	
	
	public CreditoAdapter(VistaPagoAdministracion vistapagoadm) {
		super();
	this.vistapagoadm=vistapagoadm;
	this.creditoAdapter=new CreditoAdaptee(vistapagoadm);

	}

	@Override
	public void pagar() {
		this.creditoAdapter.realizarTransaccion();
		this.creditoAdapter.pagar();
	
	}
	

}
