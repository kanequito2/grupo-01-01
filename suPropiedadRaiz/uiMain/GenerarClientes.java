/*
 * Autor: Mirai
 * Opcion para el Funcionario. Imprime todos los clientes que tiene.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;

import suPropiedadRaiz.empresa.ListaFuncionarios;

public class GenerarClientes extends OpcionDeMenu{
	
	public GenerarClientes(){
		super.setNombre("Generar lista de clientes.");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese su cedula");
		long cedula = in.nextLong();
		System.out.println(ListaFuncionarios.getFuncionario(cedula).generarListaDeClientes());
		System.out.println("Presione cualquier tecla para continuar");
		in.next();
	}

}
