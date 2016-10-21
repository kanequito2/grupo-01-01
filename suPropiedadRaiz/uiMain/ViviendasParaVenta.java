/*
 * Autor: Mirai
 * Opcion para oferente. Imprime todas las viviendas disponibles para venta-
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;

import suPropiedadRaiz.empresa.ListaVendedores;

public class ViviendasParaVenta extends OpcionDeMenu {
	
	public ViviendasParaVenta(){
		super.setNombre("Viviendas disponibles para la venta");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese su cédulla.");
		long cedula = in.nextLong();
		System.out.println(ListaVendedores.getVendedor(cedula).getCasasParaVender());
		System.out.println("Presione cualquier tecla para continuar");
		in.next();
	}

}
