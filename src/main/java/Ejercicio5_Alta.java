
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p> 
 * La clase muestra la operación de alta (inserción) en las tablas 
 * "tb_mcye_dvds" y "tb_mcye_ventas" de la Base de Datos de Música.
 * </p>
 * 
 * <p>
 * Se inserta un nuevo DVD y una venta asociada en las respectivas tablas como ejemplo de operación de alta.
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

public class Ejercicio5_Alta {

	//URL, usuario y contraseña para la conexión a la base de datos
	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		//ALTA (INSERCION)

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {

			//Inserción de un nuevo DVD
			String insertDvds = "INSERT INTO tb_mcye_dvds (NombreDVD, ArtistaDVD, EstiloMusicalDVD, AñoDVD, "
                    + "NumeroCancionesDVD, TitulosCancionesDVD, CantidadDVD, PrecioDVD, DescuentoDVD, IVADVD) "
                    + "VALUES ('9 + 1', 'Los Rebujitos', 'Flamenco-Pop', 2018, 8, 'Ella, Perdi, Tanto', 20, 19.99, 0.1, 0.16)";

			stmt.executeUpdate(insertDvds);

			//Inserción de una nueva venta asociada al DVD
			String insertVentas = "INSERT INTO tb_mcye_ventas (ID_DVD, NombreCliente, DatosCliente, PrecioVenta) "
                    + "VALUES (9, 'Juan', 'juan@example.com', 29.99)";
			stmt.executeUpdate(insertVentas);

			System.out.println("Datos insertados correctamente en 'tb_mcye_dvds' y 'tb_mcye_ventas'.");

		} catch (SQLException e) {
			System.err.println("Error al insertar datos: " + e.getMessage());
		    e.printStackTrace();
		}
	}
}
