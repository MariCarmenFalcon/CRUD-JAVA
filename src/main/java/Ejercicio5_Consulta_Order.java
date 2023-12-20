
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java para realizar consultas SELECT con ORDER en las tablas "tb_mcye_dvds" y "tb_mcye_ventas"
 * de la Base de Datos de Música en el contexto del Proyecto de Base de Datos en Java.
 * 
 * <p>
 * Este proyecto gestiona la creación y conexión a una Base de Datos de Música.
 * En esta clase, se realiza una consulta SELECT en las tablas de DVDs y Ventas, ordenando los resultados.
 * </p>
 * 
 * @author mcfal y estjim
 * @version 1.0
 * @since 2023-2024
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Crear en clases distintas el sistema CRUD

public class Ejercicio5_Consulta_Order {

	//CONSULTA CON ORDER (SELECT)

	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
	static final String USER = "root";
	static final String PASS = "";
	//Ordena la tabla de DVDs por el nombre de artista
	static final String QUERYDvd = "SELECT * FROM tb_mcye_dvds ORDER BY ArtistaDVD";
	//Ordena la tabla de Ventas por el nombre de cliente
	static final String QUERYVentas = "SELECT * FROM tb_mcye_ventas ORDER BY NombreCliente";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = con.createStatement();

				//Consulta sobre la tabla DVDs
				ResultSet rsDvd = stmt.executeQuery(QUERYDvd);

		) {
			System.out.println("\nCONSULTA SOBRE TABLA DVDs: " + "Ordena la tabla por Nombre de Artista\n");
			/*
			 * while (rsDvd.next()) {
			 * 
			 * System.out.println("**ID_DVD: " + rsDvd.getInt("ID_DVD"));
			 * System.out.println("  Nombre DVD: " + rsDvd.getString("NombreDVD"));
			 * System.out.println("  Nombre Artista: " + rsDvd.getString("ArtistaDVD"));
			 * System.out.println("  Estilo: " + rsDvd.getString("EstiloMusicalDVD"));
			 * System.out.println("  Año: " + rsDvd.getInt("AñoDVD"));
			 * System.out.println("  Numero Canciones: " +
			 * rsDvd.getInt("NumeroCancionesDVD")); System.out.println("  Titulo Cancion: "
			 * + rsDvd.getString("TitulosCancionesDVD"));
			 * System.out.println("  Candidad de DVDs: " + rsDvd.getInt("CantidadDVD"));
			 * System.out.println("  Precio del DVD: " + rsDvd.getDouble("PrecioDVD"));
			 * System.out.println("  Descuento: " + rsDvd.getDouble("DescuentoDVD"));
			 * System.out.println("  IVA: " + rsDvd.getDouble("IVADVD"));
			 * 
			 * }
			 */

			//OTRA FORMA DE SACAR EL LISTADO CON FORMATO

			//Primero imprimimos los titulos de las columnas con formato
			System.out.printf("%-2s | %-17s | %-15s | %-12s | %-4s | %-4s | %-36s | %-5s | %-8s | %-8s | %-8s%n",
					"ID_DVD", "Nombre DVD", "Artista", "Estilo", "Año", "Num. Canciones", "Titulos", "Cant. DVDs",
					"Precio", "Descuento", "IVA");
			System.out.println();
			while (rsDvd.next()) {
				System.out.printf(
						"%-6d | %-17s | %-15s | %-11s | %-4d | %-14d | %-36s | %-10d | %-8.2f | %-9.2f | %-8.2f%n",
						rsDvd.getInt("ID_DVD"), rsDvd.getString("NombreDVD"), rsDvd.getString("ArtistaDVD"),
						rsDvd.getString("EstiloMusicalDVD"), rsDvd.getInt("AñoDVD"), rsDvd.getInt("NumeroCancionesDVD"),
						rsDvd.getString("TitulosCancionesDVD"), rsDvd.getInt("CantidadDVD"),
						rsDvd.getDouble("PrecioDVD"), rsDvd.getDouble("DescuentoDVD"), rsDvd.getDouble("IVADVD"));
			}

			//Consulta sobre la tabla Ventas
			ResultSet rsVentas = stmt.executeQuery(QUERYVentas);

			System.out.println("\nCONSULTA SOBRE TABLA VENTAS CON ORDER");
			while (rsVentas.next()) {

				System.out.println("**ID_VENTAS: " + rsVentas.getInt("ID_Ventas"));
				System.out.println("  ID_DVD: " + rsVentas.getInt("ID_DVD"));
				System.out.println("  Nombre Cliente: " + rsVentas.getString("NombreCliente"));
				System.out.println("  Datos Cliente: " + rsVentas.getString("DatosCliente"));
				System.out.println("  Precio Venta: " + rsVentas.getDouble("PrecioVenta"));
			}

		} catch (SQLException e) {
			System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
