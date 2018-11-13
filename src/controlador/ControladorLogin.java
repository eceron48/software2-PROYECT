package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.DAO.DAOIniciarSesion;
import modelo.DAO.DAOSuperAdministrador;
import vista.VistaIniciarSesion;
import vista.VistaPrincipal;

public class ControladorLogin implements ActionListener {
	private final VistaIniciarSesion vlogin;

	public ControladorLogin(VistaIniciarSesion vlogin) {
		this.vlogin = vlogin;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vlogin.btnAceptar) {

			if (vlogin.cbxLogin.getSelectedItem().toString() == "SAdmin") {

				Administrador sadmin = new Administrador();
				sadmin.setUsuario(vlogin.txtUsuario.getText().toString());
				sadmin.setPass(vlogin.txtPassword.getPassword().toString());

				DAOSuperAdministrador daoSuper = new DAOSuperAdministrador();

				try {
					sadmin = daoSuper.mostrarAdministrador();
					

					if (sadmin.getUsuario().equals(vlogin.txtUsuario.getText().toString())
							&& sadmin.getPass().equals(vlogin.txtPassword.getText().toString())) {

						JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Zonas Residenciales", null, 1);
						
						VistaPrincipal principal = new VistaPrincipal ();
						principal.setVisible(true);
					
					} else {

						JOptionPane.showMessageDialog(null, " Usuario y/o Contraseña incorrectos", null, 0);

					}

				} catch (Exception e1) {

					e1.printStackTrace();				

				}			

			}

		}	
		

	}
	
	
		
	

}
