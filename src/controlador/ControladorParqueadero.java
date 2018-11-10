package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Parqueadero;
import modelo.Persona;
import vista.VistaParqueadero;

public class ControladorParqueadero implements ActionListener {
	private final VistaParqueadero parqueadero;

	public ControladorParqueadero(VistaParqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ev) {

		switch (ev.getActionCommand()) {

		case "registrar":
			Parqueadero park = new Parqueadero();

			park.setCodigo(parqueadero.txtNombrePark.getText().toString());

			if (!parqueadero.txtNombrePark.getText().toString().isEmpty()) {
				Administrador admin = new Administrador();
				try {

					admin.DAOGestionarParqueadero().registrarParqueadero(park);
					parqueadero.txtNombrePark.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "error al insertar datos", null, 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "nada que registrar", null, 2);
			}
			
			parqueadero.btnMostrarPark.doClick();

			break;
		// ------------------------------------indexar-------------------------------------------------------------------------------------------------------------------------------//
		case "modificar":
			Parqueadero parqu = new Parqueadero();

			int fila1 = this.parqueadero.tbPark.getSelectedRow();

			if (fila1 >= 0) {
				int id = (int) this.parqueadero.tbPark.getValueAt(fila1, 0);
				String nombre = (String) this.parqueadero.tbPark.getValueAt(fila1, 1);

				parqu.setId(id);
				parqu.setCodigo(nombre);
				Administrador administrador = new Administrador();
				try {
					administrador.DAOGestionarParqueadero().modificarParqueadero(parqu);
					parqueadero.btnMostrarPark.doClick();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			break;
		case "mostrar todos":

			List<Parqueadero> lista = new ArrayList<>();

			Administrador admini = new Administrador();

			try {

				lista = admini.DAOGestionarParqueadero().mostrarParqueaderos();
				for (int i = this.parqueadero.tbPark.getRowCount(); i > 0; i--) {
					this.parqueadero.parqueadero.removeRow(i - 1);
				}

				for (Parqueadero pe : lista) {

					this.parqueadero.parqueadero.addRow(new Object[] { pe.getId(), pe.getCodigo() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}	
			

			break;

		default:

			JOptionPane.showMessageDialog(null, "error de seleccion contacte a un tecnico ", null, 0);
			break;

		}

	}

}