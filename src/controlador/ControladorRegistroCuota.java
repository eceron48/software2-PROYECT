package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.CuotaAdministracion;
import modelo.DAO.DAORegistrarCuota;
import vista.VistaRegistrarCuota;



public class ControladorRegistroCuota implements ActionListener {
	
private final VistaRegistrarCuota vr;
	
	public ControladorRegistroCuota(VistaRegistrarCuota vr) {
		this.vr=vr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
	
		case"agregar":
			vr.txtTotal.setText("");
			vr.txtTotal.setEditable(false);
			if(!vr.txtValorCuota.getText().isEmpty() &&!vr.txtValorCuota.getText().isEmpty()) {
			CuotaAdministracion cuota=new CuotaAdministracion ();
			
			
			cuota.setCuota(Double.valueOf(vr.txtValorCuota.getText().toString()));
			cuota.setPorcentaje(Double.valueOf(vr.txtPorcentaje.getText().toString()));
			cuota.setTotal(cuota.calcularCuota(cuota.getCuota(), cuota.getPorcentaje()));
			vr.txtTotal.setText(cuota.getTotal().toString());
			
			DAORegistrarCuota registrar=new DAORegistrarCuota();
			try {
				registrar.RegistrarCuota(cuota);
				vr.txtPorcentaje.setText("");
				vr.txtValorCuota.setText("");
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			}
			else{
				JOptionPane.showMessageDialog(null, "debe ingresar un porcentaje y una cuota valida", null, 2);
			}
			break;
		case"ver cuota":
			vr.txtTotal.setEditable(false);
			vr.txtTotal.setText("");
			vr.txtPorcentaje.setText("");
			vr.txtValorCuota.setText("");
			CuotaAdministracion cuota;
			DAORegistrarCuota mostrar=new DAORegistrarCuota();
			try {
				
			cuota=mostrar.mostrarCuota();
			vr.textidcuota.setText(Integer.toString(cuota.getIdcuota()));
			vr.txtPorcentaje.setText(cuota.getPorcentaje().toString());
			vr.txtValorCuota.setText(cuota.getCuota().toString());
			cuota.setTotal(cuota.calcularCuota(cuota.getCuota(),cuota.getPorcentaje()));
			vr.txtTotal.setText(cuota.getTotal().toString());
			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case"modificar":
			vr.txtTotal.setEditable(false);
			vr.txtTotal.setText("");
			
		
			
			if(!vr.txtValorCuota.getText().isEmpty() &&!vr.txtValorCuota.getText().isEmpty()) {
				
			CuotaAdministracion modificar=new CuotaAdministracion ();
			DAORegistrarCuota registrar=new DAORegistrarCuota();
			
			modificar.setCuota(Double.valueOf(vr.txtValorCuota.getText()));
			modificar.setPorcentaje(Double.valueOf(vr.txtPorcentaje.getText()));
			modificar.setIdcuota(Integer.parseInt(vr.textidcuota.getText()));
			
			
		
			try {registrar.modificarCuota( modificar);	
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			}
			else{
		
				JOptionPane.showMessageDialog(null, "nada que modificar", null, 1);
			}
			
			
			
			vr.txtPorcentaje.setText("");
			vr.txtValorCuota.setText("");
			break;
		case"guardar":
			vr.txtTotal.setEditable(false);
			vr.txtTotal.setText("");
			vr.txtPorcentaje.setText("");
			vr.txtValorCuota.setText("");
			break;
			
			
		
		}
	}
	

}
