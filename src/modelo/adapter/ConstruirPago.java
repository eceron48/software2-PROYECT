package modelo.adapter;

import vista.VistaPagoAdministracion;

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
		
	}
	
	public void pagarCredito() {
		
	}

}
