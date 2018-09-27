package principal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import utils.Ficheros;

public class Inicio {

	public static void main(String[] args) throws SQLException, IOException {
		Inicio app = new Inicio();
		app.start();
	}

	private void start() throws IOException {
		List<String> cfg = Ficheros.cargarFicheroCFG();
		dbm.DBsqlserver.crearCadenaConexion(cfg.get(0), cfg.get(1),cfg.get(2),cfg.get(3),cfg.get(4));
		if (dbm.DBsqlserver.testConexion()) {
			controller.CtrlApp.iniciarAplicacion();
		} else {
			JOptionPane.showMessageDialog(null,
					"No se puede establecer conexión con el servidor.",
				    "ERROR DE CONEXION",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

}