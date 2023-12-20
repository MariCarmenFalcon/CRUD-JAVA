
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java que gestiona la creación y conexión a una Base de Datos de Música.
 * Realiza operaciones CRUD, incluyendo consultas SELECT con cláusulas WHERE y ORDER BY
 * en las tablas "tb_mcye_dvds" y "tb_mcye_ventas".
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


public class Ejercicio5_Consulta_Where_Order {
	
	//CONSULTA CON WHERE_ORDER (SELECT)
	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
    static final String USER = "root";
    static final String PASS = "";
    //Consulta que devuelve todos los registros donde el campo Numero de canciones es igual a '12' 
    //y los ordena por el campo PrecioDVD
    static final String QUERYDvd = "SELECT * FROM tb_mcye_dvds WHERE NumeroCancionesDVD = '12' ORDER BY PrecioDVD ASC";
    
    //Consulta en la tabla Ventas: todos los registros ordenados por PrecioVenta de manera descendente 
    //y cuyo precio es menor a 20
    static final String QUERYVentas = "SELECT * FROM tb_mcye_ventas WHERE PrecioVenta > '15' ORDER BY PrecioVenta DESC";

	public static void main(String[] args) {
		
		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	             Statement stmt = con.createStatement();

	             //Consulta sobre la tabla DVDs con WHERE y ORDER BY
	             ResultSet rsDvd = stmt.executeQuery(QUERYDvd);				 

	        ) {
				System.out.println("\nCONSULTA SOBRE TABLA DVDs CON WHERE Y ORDER BY 'ASC'");
				while (rsDvd.next()) {

					System.out.println("**ID_DVD: " + rsDvd.getInt("ID_DVD"));
					System.out.println("  Nombre DVD: " + rsDvd.getString("NombreDVD"));
					System.out.println("  Nombre Artista: " + rsDvd.getString("ArtistaDVD"));
					System.out.println("  Estilo: " + rsDvd.getString("EstiloMusicalDVD"));
					System.out.println("  Año: " + rsDvd.getInt("AñoDVD"));
					System.out.println("  Numero Canciones: " + rsDvd.getInt("NumeroCancionesDVD"));
					System.out.println("  Titulo Cancion: " + rsDvd.getString("TitulosCancionesDVD"));
					System.out.println("  Candidad de DVDs: " + rsDvd.getInt("CantidadDVD"));
					System.out.println("  Precio del DVD: " + rsDvd.getDouble("PrecioDVD"));
					System.out.println("  Descuento: " + rsDvd.getDouble("DescuentoDVD"));
					System.out.println("  IVA: " + rsDvd.getDouble("IVADVD"));

				}

				//Consulta sobre la tabla Ventas con WHERE Y ORDER BY
				ResultSet rsVentas = stmt.executeQuery(QUERYVentas);

				System.out.println("\nCONSULTA SOBRE TABLA VENTAS CON WHERE Y ORDER BY 'DESC'");
				while (rsVentas.next()) {
					System.out.println("**ID_VENTAS: " + rsVentas.getInt("ID_Ventas"));
					System.out.println("  ID_DVD: " + rsVentas.getInt("ID_DVD"));
					System.out.println("  Precio Venta: " + rsVentas.getDouble("PrecioVenta"));
				}            

	        } catch (SQLException e) {
	        	System.err.println("Error al ejecutar la sentencia SQL: " + e.getMessage());
	            e.printStackTrace();
	        }

	}

}
