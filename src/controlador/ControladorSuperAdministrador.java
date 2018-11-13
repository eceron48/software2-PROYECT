package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.DAO.DAOSuperAdministrador;
import vista.VistaSuperAdministrador;

public class ControladorSuperAdministrador implements ActionListener {
	private final VistaSuperAdministrador sadmin;

	public ControladorSuperAdministrador(VistaSuperAdministrador vistaSuperAdministrador) {
		this.sadmin = vistaSuperAdministrador;
	}

	@Override
	public void actionPerformed(ActionEvent bus) {

		switch (bus.getActionCommand()) {
		
		case "mostrar":
			
			Administrador admin = new Administrador();

			try {
				DAOSuperAdministrador admin1 = new DAOSuperAdministrador();

				admin = admin1.mostrarAdministrador();

				sadmin.txtCedula.setText(admin.getCedula());
				sadmin.txtNombre.setText(admin.getNombre());
				sadmin.passUser.setText(admin.getUsuario());
				sadmin.passContrasena.setText(admin.getPass());
				sadmin.txtTelefono.setText(admin.getTelefono());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "modificar":
			
			Administrador ad = new Administrador();
			ad.setCedula(sadmin.txtCedula.getText().toString());
			ad.setNombre(sadmin.txtNombre.getText().toString());
			ad.setTelefono(sadmin.txtTelefono.getText().toString());
			ad.setPass(sadmin.passContrasena.getText().toString());
			ad.setUsuario(sadmin.passUser.getText().toString());

			DAOSuperAdministrador daosuper = new DAOSuperAdministrador();
			daosuper.modificarSAdministrador(ad);

			sadmin.btnmostrar.doClick();
			break;
		default:
			JOptionPane.showMessageDialog(null, "error de sistema contacte a un tecnico", null, 0);
		}

	}

}