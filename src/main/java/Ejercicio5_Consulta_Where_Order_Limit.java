
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Clase Java que realiza consultas SELECT con cláusulas WHERE, ORDER BY y LIMIT
 * en las tablas "tb_mcye_dvds" y "tb_mcye_ventas" de la Base de Datos de Música. * 
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


public class Ejercicio5_Consulta_Where_Order_Limit {
	
	//CONSULTA CON WHERE_ORDER_LIMIT (SELECT)
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
    static final String USER = "root";
    static final String PASS = "";
    //Consulta en la tabla DvDs: primer registro con NumeroCancionesDVD = '13' ordenado por PrecioDVD
    static final String QUERYDvd = "SELECT * FROM tb_mcye_dvds WHERE NumeroCancionesDVD = '13' ORDER BY PrecioDVD ASC LIMIT 1";    
    //Consulta en la tabla Ventas: primer registro ordenado por PrecioVenta de manera descendente
    static final String QUERYVentas = "SELECT * FROM tb_mcye_ventas WHERE PrecioVenta > '15' ORDER BY PrecioVenta DESC LIMIT 1";

	public static void main(String[] args) {
		
		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
	             Statement stmt = con.createStatement();

	             //Consulta sobre la tabla DVDs con WHERE, ORDER BY y LIMIT
	             ResultSet rsDvd = stmt.executeQuery(QUERYDvd);				 

	        ) {
				System.out.println("\nCONSULTA SOBRE TABLA DVDs CON WHERE, ORDER BY 'ASC' Y LIMIT");
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

				//Consulta sobre la tabla Ventas con WHERE, ORDER BY Y LIMIT
				ResultSet rsVentas = stmt.executeQuery(QUERYVentas);

				System.out.println("\nCONSULTA SOBRE TABLA VENTAS CON WHERE, ORDER BY 'DESC' Y LIMIT");
				while (rsVentas.next()) {
					System.out.println("**ID_VENTAS: " + rsVentas.getInt("ID_Ventas"));
					System.out.println("  ID_DVD: " + rsVentas.getInt("ID_DVD"));
					System.out.println("  Precio Venta: " + rsVentas.getDouble("PrecioVenta"));
				}            

	        } catch (SQLException e) {
	        	System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
	            e.printStackTrace();
	        }
	}
}
