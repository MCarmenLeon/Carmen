package logic;

	import java.sql.SQLException;

	import javax.sql.rowset.CachedRowSet;

	public class LgTrabajador {

		public static CachedRowSet leerTrabajador() throws SQLException {
			return dbm.DBsqlserver.consultaSQL("SELECT * FROM CLCTrabajadores");
		}

		public static void guardarTrabajadorNuevo(String dni, String nombre, String apellidos, 
												  String genero) throws SQLException {
			String sql = "INSERT INTO CLCTrabajadores VALUES ('"+dni+"','"+ nombre+ "','"+apellidos+ "','"+
												  				genero +"')";
			dbm.DBsqlserver.executeDML(sql);
		}

		public static void guardarTrabajadorExistente(String idPrimaryKey, String dni, String nombre,
													  String apellidos, String genero) throws SQLException {
			String sql = "UPDATE  CLCTrabajadores SET DNI = '"+ dni+ "', Nombre= '"+nombre+"',"
					+ "Apellidos ='"+apellidos+"',Genero= '"+genero+"' WHERE IdTrabajador = " +idPrimaryKey;
			dbm.DBsqlserver.executeDML(sql);
		}

		public static void borrarTrabajador(String idPrimaryKey) throws SQLException {
			String sql = "DELETE FROM CLCTrabajadores WHERE IDTrabajador=" + idPrimaryKey;
			dbm.DBsqlserver.executeDML(sql);
		}
}
