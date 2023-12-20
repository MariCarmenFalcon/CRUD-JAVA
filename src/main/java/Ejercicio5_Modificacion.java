
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java que realiza operaciones de modificación (UPDATE) en las tablas "tb_mcye_dvds"
 * y "tb_mcye_ventas" de la Base de Datos de Música en el contexto del Proyecto de Base de Datos en Java.
 * </p>
 * 
 * @author mcfal y estjim
 * @version 1.0
 * @since 2023-2024
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Crear en clases distintas el sistema CRUD

public class Ejercicio5_Modificacion {

	// MODIFICACION (UPDATE)

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {

			// Modifica un DVD por su ID (por ejemplo, ID = 1)
			int dvdToUpdate = 1;
			String updateDvd = "UPDATE tb_mcye_dvds SET NombreDVD = 'Antonio F.', PrecioDVD = 19.99 WHERE ID_DVD = "
					+ dvdToUpdate;
			stmt.executeUpdate(updateDvd);

			// Modifica una venta por su ID (por ejemplo, ID = 1)
			int ventaToDelete = 1;
			String updateVenta = "UPDATE tb_mcye_ventas SET NombreCliente = 'Maria', PrecioVenta = 29.99 WHERE ID_Ventas = "
					+ ventaToDelete;
			stmt.executeUpdate(updateVenta);

			System.out.println("Datos modificados correctamente de tb_mcye_dvds y tb_mcye_ventas.");

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la operación de modificación: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
