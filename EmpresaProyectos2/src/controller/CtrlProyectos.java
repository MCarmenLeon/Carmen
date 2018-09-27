package controller;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.DiaProyectoInformar;
import view.DiaProyectoNuevo;

public class CtrlProyectos {

	public static String idPrimaryKey;
	public static String nombre;
	public static String presupuesto;
	public static String fechaIni;
	public static String fechaFin;

	/**
	 * desde aqui arranca la aplicacion llamando a la vista de Proyecto y actualizamos la tabla
	 */
	public static void inicio() {
		try {
			new view.FrmProyecto();
			actualizarJTableProyectos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @category guardamos en proyecto los datos recogidos en los textfield
	 * @param nombre, presupuesto, fecha inicio del proyecto y fecha final del proyecto..
	 */
	public static void guardarProyectoNuevo(String nombre, String presupuesto, String fechaIni, String fechaFin) {
		try {
			logic.LgProyectos.guardarProyectoNuevo(nombre, presupuesto, fechaIni, fechaFin);
		} catch (SQLException e) {
			System.out.println("ERROR AL GUARDAR PROYECTO");
		}
	}
	/**
	 * guardamos los datos modificados en los textFields de la vista proyecto y los enviamos
	 * a logic para guardarlos en la BD de la tabla proyecto
	 * @param que pasamos son el identificador, nombre, presupuesto, fecha inicio y fecha final
	 */ 
	public static void guardarProyectoExistente(String idPrimaryKey, String nombre, String presupuesto, 
												String fechaIni, String fechaFin) {
		try {
			logic.LgProyectos.guardarProyectoExistente(idPrimaryKey, nombre, presupuesto, fechaIni, fechaFin);
		} catch (SQLException e) {
			System.out.println("ERROR AL GUARDAR PROYECTO YA EXISTENTE");
		}
	}
	/**
	 * al seleccionar dar de alta a proyecto, mostramos en la vista el cuadro dialogo
	 * para editar un nuevo proyecto y refrescamos la tabla de proyectos
	 */
	public static void mostrarNuevo() {
		new DiaProyectoNuevo();
		actualizarJTableProyectos();
	}
	
	/**
	 * Seleccionamos de la tabla el proyecto que vamos a borrar y
	 * mandamos el index del proyecto seleccionado
	 */
	public static void borrarProyecto() {
		// conocer de la fila seleccionada en el JTable, la primera columna (contiene la
		// PK del proyecto que quiero borrar
		int filaActiva = view.FrmProyecto.table.getSelectedRow();
		String idPrimaryKey = view.FrmProyecto.table.getValueAt(filaActiva, 0).toString();
		try {
			logic.LgProyectos.borrarProyecto(idPrimaryKey);
			actualizarJTableProyectos();
		} catch (Exception e) {
			System.out.println("ERROR AL BORRAR");
		}
	}
	
	/**
	 * Leemos de la BD Proyecto y lo cargamos en la tabla y la mostramos
	 */
	public static void actualizarJTableProyectos() {
		try {
			// obtener Datos de la BD
			CachedRowSet datos = logic.LgProyectos.leerProyectos();
			// con los datos obtenidos generar un Modelo de JTable
			DefaultTableModel modelo = utils.Gui.generarModeloJTable(datos);
			// Pintar el JTable
			view.FrmProyecto.table.setModel(modelo);
		} catch (Exception e) {
		}
	}
	
	/**
	 *Seleccionamos de la tabla el elemento que queremos editar
	 *recogemos esos valores de la tabla y lo mostramos en los textfields 
	 *llamando a la vista que nos muestra el cuadro dialogo de edicion de proyecto
	 */
	public static void editarProyecto() {
		// conocer de la fila seleccionada en el JTable..
		int filaActiva = view.FrmProyecto.table.getSelectedRow();

		// preguntamos si hay alguna fila seleccionada
		if (filaActiva >= 0) {
			idPrimaryKey = view.FrmProyecto.table.getValueAt(filaActiva, 0).toString();
			try {
				CachedRowSet datos = logic.LgProyectos.leerProyectos();
				datos.next();
				nombre = view.FrmProyecto.table.getValueAt(filaActiva, 1).toString();
				presupuesto = view.FrmProyecto.table.getValueAt(filaActiva, 2).toString();
				fechaIni = view.FrmProyecto.table.getValueAt(filaActiva, 3).toString();
				fechaFin = view.FrmProyecto.table.getValueAt(filaActiva, 4).toString();

				// creamos un objeto
				view.DiaProyectoEditar dia = new view.DiaProyectoEditar();
				dia.txtNombre.setText(nombre);
				dia.txtPresupuesto.setText(presupuesto);
				dia.txtFechaIni.setText(fechaIni);
				dia.txtFechaFin.setText(fechaFin);
				dia.setModal(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "NO TIENE SELECCIONADA NINGUNA LINEA");
		}
	}
	
	/**
	 * Guardamos los datos modificados en los textfields de la vista
	 * del cuadro de dialogo, editar proyecto y los guardamos
	 * en Proyecto de la BD y refrescamos la tabla 
	 */
	public static void opcGuardarExsitente() {

		String nombre = view.DiaProyectoEditar.txtNombre.getText();
		String presupuesto = view.DiaProyectoEditar.txtPresupuesto.getText();
		String fechaIni = view.DiaProyectoEditar.txtFechaIni.getText();
		String fechaFin = view.DiaProyectoEditar.txtFechaFin.getText();
		System.out.println("La PK es : " + idPrimaryKey);
		// recogemos los valores de los textos y lo guardamo en proyecto..
		guardarProyectoExistente(idPrimaryKey, nombre, presupuesto, fechaIni, fechaFin);
		actualizarJTableProyectos();
	}
	
	/**
	 * guardamos los textFieds que hemos dado de alta en la
	 * vista de crear proyecto nuevo
	 */
	public static void opcGuardarNuevo() {
		String nombre = view.DiaProyectoNuevo.txtNombre.getText();
		String presupuesto = view.DiaProyectoNuevo.txtPresupuesto.getText();
		String fechaIni = view.DiaProyectoNuevo.txtFechaIni.getText();
		String fechaFin = view.DiaProyectoNuevo.txtFechaFin.getText();

		guardarProyectoNuevo(nombre, presupuesto, fechaIni, fechaFin);
		actualizarJTableProyectos();
	}
	
	/**
	 * Seleccionamos de la tabla el elemento que queremos ver para obtener informacion
	 * y no se puede escribir en ellos 
	 */
	public static void editarProyectoInfo() {
		// conocer de la fila seleccionada en el JTable..
		int filaActiva = view.FrmProyecto.table.getSelectedRow();
		// preguntamos si hay alguna fila seleccionada
		if (filaActiva >= 0) {
			idPrimaryKey = view.FrmProyecto.table.getValueAt(filaActiva, 0).toString();
			try {
				CachedRowSet datos = logic.LgProyectos.leerProyectos();
				datos.next();
				nombre = view.FrmProyecto.table.getValueAt(filaActiva, 1).toString();
				presupuesto = view.FrmProyecto.table.getValueAt(filaActiva, 2).toString();
				fechaIni = view.FrmProyecto.table.getValueAt(filaActiva, 3).toString();
				fechaFin = view.FrmProyecto.table.getValueAt(filaActiva, 4).toString();
				// creamos un objeto
				view.DiaProyectoInformar dia = new view.DiaProyectoInformar();
				dia.txtNombre.setText(nombre);
				dia.txtNombre.setEnabled(false);
				dia.txtPresupuesto.setText(presupuesto);
				dia.txtPresupuesto.setEnabled(false);
				dia.txtFechaIni.setText(fechaIni);
				dia.txtFechaIni.setEnabled(false);
				dia.txtFechaFin.setText(fechaFin);
				dia.txtFechaFin.setEnabled(false);
				dia.setModal(true);
			} catch (SQLException e) {
				System.out.println("ERROR AL EDITAR");
			}
		} else {
			JOptionPane.showMessageDialog(null, "NO TIENE SELECCIONADA NINGUNA LINEA");
		}

	}

}