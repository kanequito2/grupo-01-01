package suPropiedadRaiz.uiMain;
import java.util.Scanner;

import suPropiedadRaiz.empresa.ListaFuncionarios;

public class GenerarComisionVentas extends OpcionDeMenu {
	
	public GenerarComisionVentas(){
		super.setNombre("Generar comisiones por ventas");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		System.out.println("Escriba su cédula");
		long cedula = in.nextLong();
		System.out.println("Ingrese el año");
		int año = in.nextInt();
		System.out.println("Ingrese el mes");
		int mes = in.nextInt();
		double comision = ListaFuncionarios.getFuncionario(cedula).generarValorDeComisionPorVentaDeViviendas(mes, año);
		System.out.println("Su comisión por ventantas es de: " + comision + ".");
		System.out.println("Pulse cualquier tecla para conitinuar");
		in.next();
	}

}
