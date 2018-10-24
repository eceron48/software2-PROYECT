package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Apartamento;
import modelo.Casa;
import modelo.DAO.DAOApartamento;
import modelo.DAO.DAOCasa;
import vista.VistaCrearVivienda;




public class ControladorVivienda implements ActionListener {
	private static VistaCrearVivienda vv;
	public ControladorVivienda(VistaCrearVivienda vv) {
		this.vv=vv;
	}

	@Override
	public void actionPerformed(ActionEvent use) {
	/*vv.txtApto.setEditable(false);
	vv.txtBloque.setEditable(false);
	vv.txtCasa.setEditable(false);
	vv.txtPiso.setEditable(false);
		*/
	if(use.getSource()==vv.btnCrear) {
		
		if(vv.txtApto.getText().isEmpty() && vv.txtBloque.getText().isEmpty() && vv.txtCasa.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "debe llenar los 3 campos de apartamento o el de  casa ", null, 2);
			
		}
		else {
		
		String dato;
		dato=vv.cbVivienda.getSelectedItem().toString();
		 String c="casa";
		String aptmto="apartamento";
		Apartamento vivienda=new Apartamento();
		if(dato.equals(aptmto)) {
			vv.txtApto.setEnabled(true);
			vv.txtBloque.setEnabled(true);
			vv.txtPiso.setEnabled(true);
			vv.txtCasa.setEnabled(true);
			vv.txtCasa.setText("");
			
		
			vivienda.setBloque(vv.txtBloque.getText().toString());
			vivienda.setPiso(Integer.parseInt(vv.txtPiso.getText()));
			vivienda.setIdApartamento(vv.txtApto.getText().toString());	
			vivienda.setVrol(aptmto);
			
			Administrador adm =new Administrador();
			DAOApartamento dao=new DAOApartamento();
		
		
		
			try {
				adm.DaoApartamento().RegistrarApartamento(vivienda);
				//apartamento.RegistrarApartamento(vivienda);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vv.txtApto.setText("");
			vv.txtBloque.setText("");
			vv.txtPiso.setText("");
		}
		
		else 
		{if(dato.equals(c)) {
			vv.txtCasa.setEnabled(true);
			vv.txtApto.setText("");
			vv.txtBloque.setText("");
			vv.txtPiso.setText("");
			Casa casa=new Casa();
			casa.setIdvivienda(vv.txtCasa.getText().toString());
			DAOCasa dao=new DAOCasa();
			vv.txtCasa.setText("");
			try {
				dao.RegistrarCasa(casa);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			
			
		}else {
			JOptionPane.showMessageDialog(null, "debe seleccionar un tipo de vivienda", aptmto, 2);
		}	
		}
		}
		
	}
	

}
}
