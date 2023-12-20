
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase para crear la tabla de Ventas en la base de datos de música.
 * Esta tabla almacena información sobre las ventas de DVDs.
 * Contiene campos como ID_Ventas, ID_DVD, NombreCliente, DatosCliente y PrecioVenta.
 * La columna ID_DVD es una clave foránea que referencia la tabla de DVDs.
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

//A su vez crearemos la siguiente tabla, con el mismo patrón del alumno en el nombre
//tb_mayl_Ventas
//ID_Ventas
//ID_DVD
//NombreCliente
//DatosCliente ( Email, telefono o contacto ) a elegir por el alumno 
//PrecioVenta

public class Ejercicio3_CrearTabla_Ventas {

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {

			// Crea la tabla tb_mcye_Ventas
			String createVentasTable = "CREATE TABLE tb_mcye_ventas (" + "ID_Ventas INT AUTO_INCREMENT PRIMARY KEY,"
					+ "ID_DVD INT," + "NombreCliente VARCHAR(100)," + "DatosCliente VARCHAR(100),"
					+ "PrecioVenta DECIMAL(10,2)," + "FOREIGN KEY (ID_DVD) REFERENCES tb_mcye_dvds(ID_DVD)" + ")";
			stmt.executeUpdate(createVentasTable);

			System.out.println("La tabla 'tb_mcye_ventas' se ha creado exitosamente.");

		} catch (SQLException e) {
			System.err.println("Error al intentar crear la tabla de Ventas: " + e.getMessage());
		    e.printStackTrace();
		}
	}
}
