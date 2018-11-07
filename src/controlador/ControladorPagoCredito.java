package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.adapter.CreditoAdaptee;
import vista.VistaPagoAdministracion;
import vista.VistaPagoCredito;

public class ControladorPagoCredito implements ActionListener {
private final VistaPagoCredito vc;
private	VistaPagoAdministracion vistapagoadm;
 public ControladorPagoCredito( VistaPagoCredito vc){
	this.vc=vc;
	
}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==vc.btnPagarCredito) {
			
		
		if (!vc.txtTarjetaCredito.getText().toString().isEmpty() && !vc.passClaveCredito.getPassword().toString().isEmpty()) {
			

			
			
			vc.txtTarjetaCredito.setText("");
			vc.passClaveCredito.setText(" ");

		
		vc.setVisible(false);
			

		}else{
			JOptionPane.showMessageDialog(null, "ingrese numero de la targeta y la clave",null, 0);
		}
	}
	}
	
	}
	


