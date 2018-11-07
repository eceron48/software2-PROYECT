package modelo.adapter;

import vista.VistaPagoAdministracion;
import vista.VistaPagoCredito;

public class ConstruirPago {
	
	private final VistaPagoAdministracion vistaPago;


	public ConstruirPago (VistaPagoAdministracion vistaPago) {
		this.vistaPago = vistaPago;
	
	}
	
	public void pagarEfectivo() {
		MedioDePago efectivo=new Efectivo(vistaPago);
				efectivo.pagar();
		
			}
	
	public void pagarDebito() {
		MedioDePago debito=new DebitoAdapter(vistaPago);
		debito.pagar();
	}
	
	public void pagarCredito() {
		MedioDePago credito=new CreditoAdapter(vistaPago);
		credito.pagar();
	}

}
