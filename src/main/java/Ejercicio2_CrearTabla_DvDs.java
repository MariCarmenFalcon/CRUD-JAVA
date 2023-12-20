
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java para crear la tabla de DVDs en la base de datos de música.
 * La tabla almacena información sobre los DVDs disponibles, como su nombre, artista,
 * estilo musical, año de lanzamiento, número de canciones, títulos de canciones, cantidad
 * en inventario, precio, descuento e IVA.</p>
 * 
 * <p>Esta clase se utiliza en el contexto del proyecto de base de datos en Java,
 * que gestiona la creación y conexión a una Base de Datos de Música, así como
 * operaciones de inserción, borrado y consulta de registros.</p>
 * 
 * <p>El nombre de la tabla en la base de datos es 'tb_mcye_dvds'. Se conecta a la base
 * de datos utilizando JDBC y realiza la creación de la tabla mediante sentencias SQL.</p>
 * 
 * @author mcfal y estjim
 * @version 1.0
 * @since 2023-2024
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2_CrearTabla_DvDs {

//Crearemos la siguiente tabla, con el mismo patron del alumno en el nombre
//tb_mayl_dvds
	// ID_DVD
	// NombreDVD
	// ArtistaDVD
	// EstiloMusicalDVD
	// AñoDVD
	// NumeroCancionesDVD
	// TitulosCancionesDVD ( Separados por comas ) inserta minimo 3 por DVD
	// CantidadDVD
	// PrecioDVD
	// DescuentoDVD
	// IVADVD

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {

			//Crear la tabla tb_mcye_dvds
			String createDvdTable = "CREATE TABLE tb_mcye_dvds (" + "ID_DVD INT AUTO_INCREMENT PRIMARY KEY,"
					+ "NombreDVD VARCHAR(100)," + "ArtistaDVD VARCHAR(100)," + "EstiloMusicalDVD VARCHAR(50),"
					+ "AñoDVD INT," + "NumeroCancionesDVD INT," + "TitulosCancionesDVD TEXT," + "CantidadDVD INT,"
					+ "PrecioDVD DECIMAL(10,2)," + "DescuentoDVD DECIMAL(5,2)," + "IVADVD DECIMAL(5,2)" + ")";
			stmt.executeUpdate(createDvdTable);

			System.out.println("La tabla 'tb_mcye_dvds' se ha creado exitosamente.");

		} catch (SQLException e) {
			System.err.println("Error al intentar crear la tabla de DVDs: " + e.getMessage());
		    e.printStackTrace();
		}
	}
}
