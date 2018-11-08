package modelo.adapter;

import vista.VistaPagoAdministracion;


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
	
		try {this.creditoAdapter.realizarTransaccion();
			Thread.sleep(800);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.creditoAdapter.pagar();
		
	}
}
