
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * La clase muestra cómo insertar datos en la tabla "tb_mcye_dvds"
 * utilizando parámetros en la consulta preparada.
 * </p>
 * 
 * @author mcfal y estjim
 * @version 1.0
 * @since 2023-2024
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio7_Insercion_Con_Parametros {

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		insertarDatosDVD("Campamento Labandon", "El Arrebato", "Flamenco-Pop", 15.99);
	}

	public static void insertarDatosDVD(String nombre, String artista, String categoria, double precio) {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			String query = "INSERT INTO tb_mcye_dvds (NombreDVD, ArtistaDVD, EstiloMusicalDVD, PrecioDVD) VALUES (?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(query)) {
				pstmt.setString(1, nombre);
				pstmt.setString(2, artista);
				pstmt.setString(3, categoria);
				pstmt.setDouble(4, precio);
				pstmt.executeUpdate();
				System.out.println("Inserción de datos en tb_mcye_dvds realizada con éxito.");
			} catch (SQLException e) {
				System.out.println("Error al insertar datos en tb_mcye_dvds.");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.err.println("Error al ejecutar la transacción SQL: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

