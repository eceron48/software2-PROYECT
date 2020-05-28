package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import modelo.Administrador;
import modelo.Persona;
import modelo.SAdministrador;
import vista.VistaAdministrador;

public class ControladorAdministrador implements ActionListener {
	private final VistaAdministrador vadmin;
	public ControladorAdministrador(VistaAdministrador vadmin){
		this.vadmin=vadmin;
	}
	@Override
	public void actionPerformed(ActionEvent bus) {
	
	
		switch(bus.getActionCommand()) {
		
		case "buscar":
			
			
			if(!vadmin.txtBuscar.getText().isEmpty() && (vadmin.rbCedula.isSelected()||vadmin.rbNombre.isSelected())) {
				
			Administrador p = new Administrador();
			SAdministrador adminiBuscar = new SAdministrador();
			if (vadmin.rbCedula.isSelected()) {
				vadmin.txtBuscar.getText().toString();

				if (!vadmin.txtBuscar.getText().isEmpty()) {

					try {
						p = adminiBuscar.gestionarAdministrador()
								.buscarAdminPorCedula(vadmin.txtBuscar.getText().toString());
						for (int i = this.vadmin.tbadmin.getRowCount(); i > 0; i--) {
							this.vadmin.tbadmin.removeRow(i - 1);
						}

						this.vadmin.tbadmin.addRow(new Object[] { p.getId(), p.getCedula(), p.getNombre(),
								p.getTelefono(), p.getUsuario(), p.getPass() });
						vadmin.txtBuscar.setText("");
						vadmin.buttonGroup.clearSelection();

					} catch (NullPointerException | SQLException ex) {
						JOptionPane.showMessageDialog(null, "la cedula N° \" "+vadmin.txtBuscar.getText().toString()+" \" no se ha encontrado", null, 3);
						vadmin.txtBuscar.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "debe ingresar una cedula para realizar la busqueda", null, 2);
				}
						/*fragmento de codigo que controla   el modo de busqueda 
						 * 
						 * 
						 * 
						 * */
			} else {
				if (vadmin.rbNombre.isSelected()) {

					vadmin.txtBuscar.getText().toString();
					if (!vadmin.txtBuscar.getText().isEmpty()) {

						try {
							p = adminiBuscar.gestionarAdministrador()
							.buscarAdminPorNombre(vadmin.txtBuscar.getText().toString());
							
							for (int i = this.vadmin.tbadmin.getRowCount(); i > 0; i--) {
								this.vadmin.tbadmin.removeRow(i - 1);
							}

							this.vadmin.tbadmin.addRow(new Object[] { p.getId(), p.getCedula(), p.getNombre(),
									p.getTelefono(), p.getUsuario(), p.getPass() });
								vadmin.txtBuscar.setText("");
								vadmin.buttonGroup.clearSelection();
						} catch (NullPointerException|SQLException ex) {
							JOptionPane.showMessageDialog(null,"el nombre \" "+vadmin.txtBuscar.getText().toString()+" \"  no se ha encontrado", null, 3);
							vadmin.txtBuscar.setText("");
							}
					} else {
						JOptionPane.showMessageDialog(null, "debe ingresar un nombre para realizar la busqueda", null,2);
					}
				}
			}
			}else {
				JOptionPane.showMessageDialog(null, "debe ingresar una cc o un nombre  y seleccionar un tipo de busqueda", null, 2);
			}
			break;

		case "guardar":
				Administrador administrador=new Administrador();
				administrador.setNombre(vadmin.txtNombre.getText().toString());
				administrador.setCedula(vadmin.txtCedula.getText().toString());
				administrador.setTelefono(vadmin.txtTelefono.getText().toString());
				administrador.setRol("administrador");
				administrador.setUsuario(vadmin.txtUsuario.getText().toString());
				administrador.setPass(vadmin.passContrasena.getText().toString());
			
			if (vadmin.txtCedula.getText().isEmpty() || vadmin.txtNombre.getText().isEmpty()  || vadmin.passContrasena.getText().isEmpty()||vadmin.txtUsuario.getText().isEmpty())  {
				
				JOptionPane.showMessageDialog(null, "los datos usuario,cedula, usuario y contraseña son obligatorios ",null, 0);
			

			} else {

				SAdministrador admin = new SAdministrador();
				try {
					admin.gestionarAdministrador().insertarAdministrador(administrador);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				vadmin.txtCedula.setText("");
				vadmin.txtBuscar.setText("");
				vadmin.txtNombre.setText("");
				vadmin.txtUsuario.setText("");
				vadmin.passContrasena.setText("");
				vadmin.txtTelefono.setText("");
				vadmin.btnMostrarTodos.doClick();
			}
			
			break;
		case"mostrar todos":
				
			List<Administrador> lista = new ArrayList<>();

			SAdministrador admini = new SAdministrador();

			try {

				lista = admini.gestionarAdministrador().mostrarTodos();
				for (int i = this.vadmin.tbadmin.getRowCount(); i > 0; i--) {
					this.vadmin.tbadmin.removeRow(i - 1);
				}

				for (Administrador admin0 : lista) {

					this.vadmin.tbadmin.addRow(
							new Object[] { admin0.getId(), admin0.getCedula(),admin0.getNombre(), admin0.getTelefono(),admin0.getUsuario(),admin0.getPass() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
			}

			
				
			
			break;
			
		case"modificar":
		
			int fila1 = this.vadmin.tbGestionarAdmin.getSelectedRow();
			if (fila1 >= 0) {
				int id = (int) this.vadmin.tbadmin.getValueAt(fila1, 0);
				String cedula = (String) this.vadmin.tbadmin.getValueAt(fila1, 1);
				String nombre1 = (String) this.vadmin.tbadmin.getValueAt(fila1, 2);
				String telefono = (String) this.vadmin.tbadmin.getValueAt(fila1, 3);
			
				String usuario = (String) this.vadmin.tbadmin.getValueAt(fila1, 4);
				String pass = (String) this.vadmin.tbadmin.getValueAt(fila1, 5);
				

				Administrador administrador1 = new Administrador();
				SAdministrador sadminModificar = new SAdministrador();
				administrador1.setId(id);
				administrador1.setCedula(cedula);
				administrador1.setNombre(nombre1);
				administrador1.setTelefono(telefono);
				administrador1.setPass(pass);
				administrador1.setUsuario(usuario);
				
				sadminModificar.gestionarAdministrador().modificarAdministrador(administrador1);
				for (int i = this.vadmin.tbadmin.getRowCount(); i > 0; i--) {
					this.vadmin.tbadmin.removeRow(i - 1);
				}
				vadmin.btnMostrarTodos.doClick();
			}
		
			break;
			
		case"eliminar":
			

			int fila = this.vadmin.tbGestionarAdmin.getSelectedRow();
			if (fila >= 0) {
				int id = (int) this.vadmin.tbadmin.getValueAt(fila, 0);
				
				SAdministrador sadminModificar = new SAdministrador();
		
			
				
				sadminModificar.gestionarAdministrador().eliminarAdministrador(id);
				for (int i = this.vadmin.tbadmin.getRowCount(); i > 0; i--) {
					this.vadmin.tbadmin.removeRow(i - 1);
				}
				vadmin.btnMostrarTodos.doClick();
			}
			
			break;
			
		
		
		}
		
			
			
			
		
	}

}
