
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java para insertar registros en las tablas "tb_mcye_dvds" y "tb_mcye_ventas" de la 
 * Base de Datos de Música en el contexto del Proyecto de Base de Datos en Java.
 * </p>
 * 
 * <p>
 * Este proyecto gestiona la creación y conexión a una Base de Datos de Música. En esta clase,
 * se insertan registros en las tablas de DVDs y Ventas para demostrar el funcionamiento del CRUD.
 * </p>
 * 
 * <p>
 * Los DVDs y Ventas se insertan con información específica, incluyendo nombres, artistas, estilos,
 * años de lanzamiento, número de canciones, títulos de canciones, cantidad, precio, descuento e IVA.
 * 
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

public class Ejercicio4_InsertarRegistros {

	// Insertar 10 registros en la tb_mayl_dvds y 3 en tb_mayl_Ventas
	// poned vuestros estilos musicales asi cada alumno tendrá un ejercicio
	// diferente y podremos ver diferentes ejemplos en clase

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {

			String insertDvds = "INSERT INTO tb_mcye_dvds (NombreDVD, ArtistaDVD, EstiloMusicalDVD, AñoDVD, "
			        + "NumeroCancionesDVD, TitulosCancionesDVD, CantidadDVD, PrecioDVD, DescuentoDVD, IVADVD) VALUES "
			        + "('Cosas Mias', 'Antonio Flores', 'Flamenco-Pop', 1995, 13, 'Alba, Una Espina, Isla De Palma', 50, 20.99, 5.00, 0.16),"
			        + "('De Ley', 'Rosario Flores', 'Flamenco-Pop', 1992, 12, 'Mi Gato, Mía Mamá, Adivínalo', 21, 18.50, 3.00, 0.16),"
			        + "('Buleria', 'David Bisbal', 'Flamenco-Pop', 2004, 12, 'Esta Ausencia, Se Acaba, Me Derrumbo', 33, 22.50, 2.00, 0.16),"
			        + "('Corazon Congelado', 'Pastora Soler', 'Flamenco-Pop', 2001, 12, 'Ven A Mi, Quémame, Adiós', 37, 21.30, 1.00, 0.16),"
			        + "('Trece Verdades', 'India Martínez', 'Flamenco-Pop', 2011, 12, 'Vencer al Amor, 	90 Minutos, Seré', 55, 18.70, 2.50, 0.16),"
			        + "('Munay', 'Vanessa Martín', 'Flamenco-Pop', 2016, 14, 'Inmunes, Ya, Sucederá', 13, 23.00, 1.00, 0.16),"
			        + "('Estopa', 'Estopa', 'Flamenco-Pop', 1999, 12, 'Como Camarón, Tu Calorro, Tan Sólo', 17, 18.99, 1.50, 0.16),"
			        + "('Aprendiz', 'Malú', 'Flamenco-Pop', 1998, 9, 'Lucharé, Como Una Flor, Aprendiz', 22, 27.00, 2.80, 0.16),"
			        + "('Angel Malherido', 'El Barrio', 'Flamenco-Pop', 2003, 12, 'Ella, Angel Malherido, Cuentale', 30, 19.50, 2.90, 0.16),"
			        + "('El Mal Querer', 'Rosalía', 'Flamenco-Pop', 2018, 11, 'Malamente, Preso, Nana', 25, 15.99, 2.75, 0.16)";


			stmt.executeUpdate(insertDvds);

			String insertVentas = "INSERT INTO tb_mcye_ventas (ID_DVD, NombreCliente, DatosCliente, PrecioVenta) VALUES "
					+ "(1, 'MariCarmen', 'maricarmen@example.com', 25.00),"
					+ "(2, 'Estrella', 'estrella@example.com', 15.00),"
					+ "(3, 'Alberto', 'alberto@example.com', 20.00)";
			stmt.executeUpdate(insertVentas);

			System.out.println("Datos insertados correctamente en tb_mcye_dvds y tb_mcye_ventas.");

		} catch (SQLException e) {
			System.err.println("Error al intentar insertar datos en las tablas: " + e.getMessage());
		    e.printStackTrace();		    
		}
	}
}
