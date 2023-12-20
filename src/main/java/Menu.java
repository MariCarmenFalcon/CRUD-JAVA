/**
 * <h1>PROYECTO BD JAVA</h1>
 * <p>
 * Esta clase implementa un menú interactivo para gestionar una Base de Datos de Música en Java.
 * Proporciona opciones para la creación de la base de datos, tablas, inserción y modificación de registros,
 * así como la realización de consultas y transacciones. Cada opción del menú está vinculada a una clase específica
 * que contiene la lógica de ejecución correspondiente. Este menú facilita la administración y manipulación de datos
 * en el proyecto de Base de Datos de Música.
 * </p>
 * 
 * @author mcfal y estjim
 * @version 1.0
 * @since 2023-2024
 */
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		boolean exit = false;
		
		while (!exit) {			
			
			System.out.println();
			System.out.println("****************************************************");
	        System.out.println("*                   MENÚ PRINCIPAL                 *");
	        System.out.println("****************************************************");
	        System.out.println("1.  Crear la Base de Datos");
	        System.out.println("2.  Crear la tabla de DVDs");
	        System.out.println("3.  Crea la tabla Ventas");
			System.out.println("4.  Inserta registros en ambas tablas");
			System.out.println("5.  Realiza una - Alta");
			System.out.println("6.  Realiza una - Baja");
			System.out.println("7.  Realiza una - Modificación");
			System.out.println("8.  Ejecuta una - Consulta");
			System.out.println("9.  Ejecuta una - Consulta con WHERE");
			System.out.println("10. Ejecuta una - Consulta con WHERE Y ORDER");
			System.out.println("11. Ejecuta una - Consulta con WHERE, ORDER  y LIMIT");
			System.out.println("12. Realiza una - Transacción");
			System.out.println("13. Realiza una - Inserción de datos con parámetros");
	        System.out.println("0.  Salir");
	        System.out.println("****************************************************");
	        System.out.print("Seleccione la opción que quiere ejecutar: ");
			
	        int opcion;
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                sc.nextLine(); 
                continue;
            }
			
			switch (opcion) {
			case 1:
				Ejercicio1_CrearBD.main(new String[]{});
				break;
			case 2:
				Ejercicio2_CrearTabla_DvDs.main(new String[]{});
				break;
			case 3:
				Ejercicio3_CrearTabla_Ventas.main(new String[]{});
				break;
			case 4:
				Ejercicio4_InsertarRegistros.main(new String[]{});
				break;
			case 5:
				Ejercicio5_Alta.main(new String[]{});
				break;
			case 6:
				Ejercicio5_Baja.main(new String[]{});
				break;
			case 7:
				Ejercicio5_Modificacion.main(new String[]{});
				break;
			case 8:
				Ejercicio5_Consulta.main(new String[]{});
				break;
			case 9:
				Ejercicio5_Consulta_Where.main(new String[]{});
				break;
			case 10:
				Ejercicio5_Consulta_Where_Order.main(new String[]{});
				break;
			case 11:
				Ejercicio5_Consulta_Where_Order_Limit.main(new String[]{});
				break;
			case 12:
				Ejercicio6_Transaccion.main(new String[]{});
				break;
			case 13:
				Ejercicio7_Insercion_Con_Parametros.main(new String[]{});
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("Opción no válida. Por favor, selecciona una opción válida [1 al 13].");
				break;
			}
		}
		sc.close();
		System.out.println("¡Gracias por usar el menú! Hasta luego.");
	}
}
