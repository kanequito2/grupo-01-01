/*
 * Autor: Mirai
 * Opcion para oferente. Imprime todas las viviendas disponibles para arriendo.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;

import suPropiedadRaiz.empresa.ListaArrendadores;

public class ViviendasParaArrendar extends OpcionDeMenu {
	
	public ViviendasParaArrendar(){
		super.setNombre("Viviendas disponinles para arrendar");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese su cédula");
		long cedula = in.nextLong();
		System.out.println(ListaArrendadores.getArrendador(cedula).getInmueblesDisponiblesParaArrendar());
		System.out.println("Presione cualquier tecla para continuar");
		in.next();
	}

}
