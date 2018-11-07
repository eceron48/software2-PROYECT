package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VistaPagoAdministracion;
import vista.VistaPagoCredito;
import vista.VistaPagoDebito;

public class ControladorPagoDebito implements ActionListener{
	private final VistaPagoDebito vd;
	private	VistaPagoAdministracion vistapagoadm;
	 public ControladorPagoDebito( VistaPagoDebito vd){
		this.vd=vd;
		
	}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource()==vd.btnPagarDebito) {
				
			
			if (!vd.txtTarjetaDebito.getText().toString().isEmpty() && !vd.passClaveDebito.getPassword().toString().isEmpty()) {
				

				
				
				vd.txtTarjetaDebito.setText("");
				vd.passClaveDebito.setText(" ");

			
				vd.setVisible(false);
				

			}else{
				JOptionPane.showMessageDialog(null, "ingrese numero de la targeta y la clave",null, 0);
			}
		}
		}
}