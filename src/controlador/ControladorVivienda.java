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
import modelo.Apartamento;
import modelo.Casa;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Vivienda;
import modelo.DAO.DAOApartamento;
import modelo.DAO.DAOCasa;
import vista.VistaCrearVivienda;

public class ControladorVivienda implements ActionListener {
	private final VistaCrearVivienda vv;

	public ControladorVivienda(VistaCrearVivienda vv) {
		this.vv = vv;
	}

	@Override
	public void actionPerformed(ActionEvent use) {
		/*
		 * vv.txtApto.setEditable(false); vv.txtBloque.setEditable(false);
		 * vv.txtCasa.setEditable(false); vv.txtPiso.setEditable(false);
		 */
		if (use.getSource() == vv.btnCrear) {

			if (vv.txtApto.getText().isEmpty() && vv.txtBloque.getText().isEmpty() && vv.txtCasa.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Recuerde llenar todos los campos ", null, 2);

			} else {

				String dato;
				dato = vv.cbVivienda.getSelectedItem().toString();
				String c = "casa";
				String aptmto = "apartamento";
				Apartamento vivienda = new Apartamento();
				if (dato.equals(aptmto)) {

					vv.txtCasa.setText("");

					vivienda.setBloque(vv.txtBloque.getText().toString());
					vivienda.setPiso(Integer.parseInt(vv.txtPiso.getText()));
					vivienda.setIdApartamento(vv.txtApto.getText().toString());
					vivienda.setVrol(aptmto);

					Administrador adm = new Administrador();

					try {
						adm.registrarVivienda().RegistrarApartamento(vivienda);

					} catch (SQLException e) {

						e.printStackTrace();
					}
					vv.txtApto.setText("");
					vv.txtBloque.setText("");
					vv.txtPiso.setText("");
				}

				else {
					if (dato.equals(c)) {

						vv.txtCasa.setEnabled(true);
						vv.txtApto.setText("");
						vv.txtBloque.setText("");
						vv.txtPiso.setText("");
						Casa casa = new Casa();
						casa.setIdvivienda(vv.txtCasa.getText().toString());
						vv.txtCasa.setText("");
						Administrador adm = new Administrador();
						try {
							adm.DAORegistrarCasa().RegistrarCasa(casa);

						} catch (SQLException e) {

							e.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(null, "debe seleccionar un tipo de vivienda", aptmto, 2);
					}
				}
			}

		}

		switch (use.getActionCommand()) {

		case "mostrar viviendas":

			List<Apartamento> lista = new ArrayList<>();

			Administrador admini = new Administrador();

			try {

				lista = admini.DAOMostrarVivienda().mostrarTodoViviendas();
				for (int i = this.vv.tablaVivienda.getRowCount(); i > 0; i--) {
					this.vv.tablaVivienda.removeRow(i - 1);
				}

				for (Apartamento vi : lista) {

					this.vv.tablaVivienda.addRow(new Object[] { vi.getId(), vi.getVrol(), vi.getBloque(),
							vi.getIdApartamento(), vi.getPiso() });
				}

			} catch (SQLException ex) {
				Logger.getLogger(ControladorResidente.class.getName()).log(Level.SEVERE, null, ex);
			}

			break;

		case "modificar":

			int fila1 = this.vv.tbVivienda.getSelectedRow();
			if (fila1 >= 0) {
				int id = (int) this.vv.tbVivienda.getValueAt(fila1, 0);
				String rol = (String) this.vv.tbVivienda.getValueAt(fila1, 1);
				String bloque = (String) this.vv.tbVivienda.getValueAt(fila1, 2);
				String numeroVivienda = (String) this.vv.tbVivienda.getValueAt(fila1, 3);
				int piso = (int) this.vv.tbVivienda.getValueAt(fila1, 4);

				Apartamento apto = new Apartamento();
				Administrador adminModificar = new Administrador();
			

				if (rol.equals("casa")) {
					
					apto.setId(id);
					apto.setVrol(rol);
					apto.setBloque(null);
					apto.setPiso(0);
					apto.setIdvivienda(numeroVivienda);

					try {
						adminModificar.DAOMostrarVivienda().modificarVivienda(apto);
						for (int i = this.vv.tbVivienda.getRowCount(); i > 0; i--) {
							this.vv.tablaVivienda.removeRow(i - 1);
						}
						vv.btnMostrarViviendas.doClick();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {if(rol=="apartamento") {
					
					apto.setId(id);
					apto.setVrol(rol);
					apto.setBloque(bloque);
					apto.setIdvivienda(numeroVivienda);
					apto.setPiso(piso);
					
					try {
						adminModificar.DAOMostrarVivienda().modificarVivienda(apto);
						for (int i = this.vv.tbVivienda.getRowCount(); i > 0; i--) {
							this.vv.tablaVivienda.removeRow(i - 1);
						}
						vv.btnMostrarViviendas.doClick();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}}
			}

			break;

		}

	}

}
