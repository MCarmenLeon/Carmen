package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LgProyectos {
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static CachedRowSet leerProyectos() throws SQLException {
		return dbm.DBsqlserver.consultaSQL("SELECT * FROM CLCProyectos");
	}
	
	/**
	 * insertamos en la tabla CLCProyectos cuando damos de alta a un nuevo proyecto
	 * @param nombre
	 * @param presupuesto
	 * @param fechaIni
	 * @param fechaFin
	 * @throws SQLException
	 */
	public static void guardarProyectoNuevo(String nombre, String presupuesto, String fechaIni, String fechaFin) 
											throws SQLException {
		String sql = "INSERT INTO CLCProyectos VALUES ('"+ nombre+"','"+ presupuesto+ "','"+fechaIni+ "','"+
														fechaFin +"')";
		dbm.DBsqlserver.executeDML(sql);
	}
	
	/**
	 * modificamos la tabla CLCProyectos cuando editamos el proyecto ya existente
	 * @param idPrimaryKey
	 * @param nombre
	 * @param presupuesto
	 * @param fechaIni
	 * @param fechaFin
	 * @throws SQLException
	 */
	public static void guardarProyectoExistente(String idPrimaryKey, String nombre, String presupuesto,
												String fechaIni, String fechaFin) throws SQLException {
		String sql = "UPDATE  CLCProyectos SET Nombre = '"+ nombre+ "', Presupuesto= '"+presupuesto+"',"
				+ "FechaInicio ='"+fechaIni+"',FechaFin= '"+fechaFin+"' WHERE IdProyecto = " +idPrimaryKey;
	
		dbm.DBsqlserver.executeDML(sql);
	}
	
	/**
	 * borramos la tabla CLProyecto de la fila seleccionada
	 * @param idPrimaryKey
	 * @throws SQLException
	 */
	public static void borrarProyecto(String idPrimaryKey) throws SQLException {
		String sql = "DELETE FROM CLCProyectos WHERE IDPROYECTO=" + idPrimaryKey;
		dbm.DBsqlserver.executeDML(sql);
	}

}