
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java para la creación de la base de datos "bbdd_maricarmenyestrella_Music" 
 * en el contexto del Proyecto de Base de Datos en Java.
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

//Crea una BBDD con PHPMyAdmin llamada Music, le pondremos el prefijo con vuestras iniciales al nombre:

public class Ejercicio1_CrearBD {

	// CREACION DE BASE DE DATOS DESDE JDBC
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			// Tenemos que poner nuestra BBDD
			String sql = "CREATE DATABASE bbdd_maricarmenyestrella_Music";
			stmt.executeUpdate(sql);
			System.out.println("La base de datos 'bbdd_maricarmenyestrella_Music' se ha creado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al intentar crear la base de datos: " + e.getMessage());
		    e.printStackTrace();
		}
	}
}
