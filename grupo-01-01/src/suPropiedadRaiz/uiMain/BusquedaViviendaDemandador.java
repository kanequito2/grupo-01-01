/*
 * Autor: Mirai
 * Opcion de menu para Demandador. Busca todas sus viviendas por las que paga arriendo.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;

import suPropiedadRaiz.empresa.ListaArrendatarios;

public class BusquedaViviendaDemandador extends OpcionDeMenu{

	public BusquedaViviendaDemandador(){
		super.setNombre("Busqueda de Vivienda");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese su cédula");
		long cedula = in.nextLong();
		System.out.println(ListaArrendatarios.getArrendatario(cedula).getInmueblesPorLosQuePagoArriendo());
		System.out.println("Pulse cualquier tecla para continuar");
		in.next();
	}
}
