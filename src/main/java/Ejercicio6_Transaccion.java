
/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * La clase muestra el uso de transacciones en la Base de Datos.
 * Para hacer transacciones, es necesario desactivar el autocommit.
 * La transacción incluye inserciones y eliminaciones en la tabla "tb_mcye_ventas".
 * Si ocurre algún error durante la transacción, se revierte para mantener la consistencia.
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

public class Ejercicio6_Transaccion {

	//TRANSACCION SOBRE LA TABLA VENTAS
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/bbdd_maricarmenyestrella_Music";
    static final String USER = "root";
    static final String PASS = "";
	
	public static void main(String[] args) {
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			
            //Para poder hacer transacciones hay que desactivar el autocommit
            conn.setAutoCommit(false);

            try (Statement stmt = conn.createStatement()) {
                //Consulta 1: insertamos un nuevo registro en Ventas
                String insertVenta1 = "INSERT INTO tb_mcye_ventas (ID_DVD, NombreCliente, DatosCliente, PrecioVenta) VALUES "
                        + "(4, 'Carlos', 'carlos@example.com', 30.00)";
                stmt.executeUpdate(insertVenta1);

                //Consulta 2: Borramos un registro 
                String deleteVenta1 = "DELETE FROM tb_mcye_ventas WHERE ID_Ventas = 3";
                stmt.executeUpdate(deleteVenta1);

                //Consulta 3: Insertamos otro nuevo registro
                String insertVenta2 = "INSERT INTO tb_mcye_ventas (ID_DVD, NombreCliente, DatosCliente, PrecioVenta) VALUES "
                        + "(2, 'Laura', 'laura@example.com', 25.00)";
                stmt.executeUpdate(insertVenta2);

                //Consulta 4: Borramos otro registro
                String deleteVenta2 = "DELETE FROM tb_mcye_ventas WHERE ID_Ventas = 1";
                stmt.executeUpdate(deleteVenta2);

                //Consulta 5: Insertamos un ultimo registro en Ventas
                String insertVenta3 = "INSERT INTO tb_mcye_ventas (ID_DVD, NombreCliente, DatosCliente, PrecioVenta) VALUES "
                        + "(5, 'Elena', 'elena@example.com', 22.50)";
                stmt.executeUpdate(insertVenta3);

                //Confirmamos la transaccion
                conn.commit();
                System.out.println("Transacción realizada con éxito. Cambios confirmados.");
                
            } catch (SQLException e) {
            	
                //Si hay un error, revertimos la transaccion
                conn.rollback();
                System.err.println("Error al ejecutar la transacción: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
