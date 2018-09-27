package controller;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.DiaTrabajadorNuevo;

public class CtrlTrabajadores {
	public static String idPrimaryKey;
	public static String dni;
	public static String nombre;
	public static String apellidos;
	public static String genero;
	
	/**
	 * Empieza nuestra aplicación, llamando a la vista para mostrar la ventana de trabajador y
	 * actualizamos la tabla
	 */
	public static void inicio() {
		try {
			new view.FrmTrabajador();
			actualizarJTableTrabajador();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR EN CONEXION");
		}
	}
	
	/**
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param genero
	 * damos de alta al nuevo trabajador
	 */
	public static void guardarTrabajadorNuevo(String dni, String nombre, String apellidos, String genero) {
		try {
			logic.LgTrabajador.guardarTrabajadorNuevo(dni, nombre, apellidos, genero);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR A GUARDAR TRABAJADOR");
		}
	}
	
	/**
	 * 
	 * @param idPrimaryKey
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param genero
	 * guardamos los datos que hayamos modificado
	 */
	public static void guardarTrabajadorExistente(String idPrimaryKey, String dni, String nombre, String apellidos,
			String genero) {
		try {
			logic.LgTrabajador.guardarTrabajadorExistente(idPrimaryKey, dni, nombre, apellidos, genero);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR A MODIFICAR TRABAJADOR");
		}
	}
	
	/**
	 * Lanzamos el dialogo para dar de alta a un trabajador y actualizamos la tabla de trabajador
	 */
	public static void mostrarNuevo() {
		new DiaTrabajadorNuevo();
		actualizarJTableTrabajador();
	}
	
	/**
	 * Seleccionamos la fila que queremos borrar y los pasamos a logic para borrar el trabajdor
	 * seleccionado
	 */
	public static void borrarTrabajador() {
		// conocer de la fila seleccionada en el JTable, la primera columna (contiene la
		// PK del proyecto que quiero borrar
		int filaActiva = view.FrmTrabajador.table.getSelectedRow();
		String idPrimaryKey = view.FrmTrabajador.table.getValueAt(filaActiva, 0).toString();

		try {
			logic.LgTrabajador.borrarTrabajador(idPrimaryKey);
			actualizarJTableTrabajador();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR A BORRAR");
		}
	}
	
	/**
	 * Lee de la base de datos de trabajador y refresca la tabla y la mostramos en la vista
	 * de trabajador
	 */
	public static void actualizarJTableTrabajador() {
		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LgTrabajador.leerTrabajador();
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			// Pintar el JTable
			view.FrmTrabajador.table.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR DE LECTURA");
		}
	}
	
	/**
	 * mostramos la tabla de trabajadores y seleccionamos la fila que queremos modificar 
	 * mostramos en la vista de modificar trabajadores los datos de éstos y los modificamos
	 */
	public static void editarTrabajador() {
		// conocer de la fila seleccionada en el JTable..
		int filaActiva = view.FrmTrabajador.table.getSelectedRow();

		// preguntamos si hay alguna fila seleccionada
		if (filaActiva >= 0) {
			idPrimaryKey = view.FrmTrabajador.table.getValueAt(filaActiva, 0).toString();
			try {
				CachedRowSet datos = logic.LgTrabajador.leerTrabajador();
				datos.next();
				dni = view.FrmTrabajador.table.getValueAt(filaActiva, 1).toString();
				nombre = view.FrmTrabajador.table.getValueAt(filaActiva, 2).toString();
				apellidos = view.FrmTrabajador.table.getValueAt(filaActiva, 3).toString();
				genero = view.FrmTrabajador.table.getValueAt(filaActiva, 4).toString();

				// creamos un objeto
				view.DiaTrabajadorEditar dia = new view.DiaTrabajadorEditar();
				dia.txtDni.setText(dni);
				dia.txtNombre.setText(nombre);
				dia.txtApellidos.setText(apellidos);
				dia.txtGenero.setText(genero);
				dia.setModal(true);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR AL EDITAR");
			}
		} else {
			JOptionPane.showMessageDialog(null, "NO TIENE SELECCIONADA NINGUNA LINEA");
		}

	}
	
	/**
	 * obtenemos los datos de la vista de modificar trabajador y la guardamos en nuestra BD
	 * y refrescamos la tabla
	 */
	public static void opcGuardarExsitente() {
		String dni = view.DiaTrabajadorEditar.txtDni.getText();
		String nombre = view.DiaTrabajadorEditar.txtNombre.getText();
		String apellidos = view.DiaTrabajadorEditar.txtApellidos.getText();
		String genero = view.DiaTrabajadorEditar.txtGenero.getText();
		System.out.println("La PK es : " + idPrimaryKey);

		// leemos desde los textField y lo pasamos para guardar en la BD...
		guardarTrabajadorExistente(idPrimaryKey, dni, nombre, apellidos, genero);
		actualizarJTableTrabajador();
	}
	
	/**
	 * obtenemos la vista para dar de alta a un nuevo trabajador y la guardamos en la BD
	 * y refrescamos la tabla
	 */
	public static void opcGuardarNuevo() {
		String dni = view.DiaTrabajadorNuevo.txtDni.getText();
		String nombre = view.DiaTrabajadorNuevo.txtNombre.getText();
		String apellidos = view.DiaTrabajadorNuevo.txtApellidos.getText();
		String genero = view.DiaTrabajadorNuevo.txtGenero.getText();
		// cogemos los datos del trabajador nuevo y lo guardamos en la BD..
		guardarTrabajadorNuevo(dni, nombre, apellidos, genero);
		actualizarJTableTrabajador();
	}
	
	/**
	 * Seleccionamos la fila de la tabla trabajador que queremos obtener información
	 * sólo muestra información, no se escribe ni se modifica
	 */
	public static void editarTrabajadorInfo() {

		// conocer de la fila seleccionada en el JTable..
		int filaActiva = view.FrmTrabajador.table.getSelectedRow();

		// preguntamos si hay alguna fila seleccionada
		if (filaActiva >= 0) {
			idPrimaryKey = view.FrmTrabajador.table.getValueAt(filaActiva, 0).toString();
			try {
				CachedRowSet datos = logic.LgTrabajador.leerTrabajador();
				datos.next();
				dni = view.FrmTrabajador.table.getValueAt(filaActiva, 1).toString();
				nombre = view.FrmTrabajador.table.getValueAt(filaActiva, 2).toString();
				apellidos = view.FrmTrabajador.table.getValueAt(filaActiva, 3).toString();
				genero = view.FrmTrabajador.table.getValueAt(filaActiva, 4).toString();

				// creamos un objeto
				view.DiaTrabajadorInformar dia = new view.DiaTrabajadorInformar();
				dia.txtDni.setText(dni);
				dia.txtDni.setEnabled(false);
				dia.txtNombre.setText(nombre);
				dia.txtNombre.setEnabled(false);
				dia.txtApellidos.setText(apellidos);
				dia.txtApellidos.setEnabled(false);
				dia.txtGenero.setText(genero);
				dia.txtGenero.setEnabled(false);
				dia.setModal(true);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR DE LECTURA");
			}
		} else {
			JOptionPane.showMessageDialog(null, "NO TIENE SELECCIONADA NINGUNA LINEA");
		}
	}

}
