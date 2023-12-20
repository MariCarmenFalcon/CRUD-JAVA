
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java para la operación de Baja (eliminación) en la Base de Datos de Música.
 * Se encarga de borrar registros de las tablas "tb_mcye_dvds" y "tb_mcye_ventas".
 * Requiere una conexión establecida a la base de datos.
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

public class Ejercicio5_Baja {

	//BAJA (BORRAR)

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {

			// Introducir numero de ID_DVD a borrar
			int dvdToDelete = 5;
			String deleteDvds = "DELETE FROM tb_mcye_dvds WHERE ID_DVD = " + dvdToDelete;
			stmt.executeUpdate(deleteDvds);

			// Introducir numero de ID_Ventas a borrar
			int ventaToDelete = 4;
			String ventaDelete = "DELETE FROM tb_mcye_ventas WHERE ID_Ventas = " + ventaToDelete;
			stmt.executeUpdate(ventaDelete);

			System.out.println("Datos borrados correctamente de tb_mcye_dvds y tb_mcye_ventas.");

		} catch (SQLException e) {			
            System.err.println("Error al intentar realizar la operación de baja: " + e.getMessage());
            e.printStackTrace();
		}
	}
}
