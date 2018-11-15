package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.SAdministrador;
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

			boolean res = true;

			if (!vlogin.txtUsuario.getText().toString().isEmpty() && !vlogin.txtPassword.getText().toString().isEmpty()
					|| vlogin.cbxLogin.getSelectedItem().toString() != "ingresar como") {

				if (vlogin.cbxLogin.getSelectedItem().toString() == "SAdmin") {

					Administrador sadmin = new Administrador();
					sadmin.setUsuario(vlogin.txtUsuario.getText().toString());
					sadmin.setPass(vlogin.txtPassword.getPassword().toString());

					DAOSuperAdministrador daoSuper = new DAOSuperAdministrador();

					try {
						sadmin = daoSuper.mostrarAdministrador();

						if (sadmin.getUsuario().equals(vlogin.txtUsuario.getText().toString())
								&& sadmin.getPass().equals(vlogin.txtPassword.getText().toString())) {

							JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Zonas Residenciales", null,
									1);

							VistaPrincipal principal = new VistaPrincipal();
							principal.setVisible(true);
							vlogin.dispose();

						} else {

							JOptionPane.showMessageDialog(null, " Usuario y/o Contraseña incorrectos", null, 0);

						}

					} catch (Exception e1) {

						e1.printStackTrace();

					}

				}

				if (vlogin.cbxLogin.getSelectedItem().toString() == "Administrador") {

					List<Administrador> listaAdmin = new ArrayList<>();
					SAdministrador admin = new SAdministrador();

					try {
						listaAdmin = admin.gestionarAdministrador().mostrarTodos();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					for (Administrador adm : listaAdmin) {

						if (adm.getUsuario().equals(vlogin.txtUsuario.getText().toString())
								&& adm.getPass().equals(vlogin.txtPassword.getText().toString())) {

							JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Zonas Residenciales", null,
									1);

							VistaPrincipal principal = new VistaPrincipal();
							principal.setVisible(true);
							principal.Administracion.setEnabled(false);
							res = false;
							vlogin.dispose();

						}

					}

					if (res == true) {
						JOptionPane.showMessageDialog(null, " Usuario y/o Contraseña incorrectos", null, 0);
					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar los datos completos", null, 2);

			}
		}

	}

}

