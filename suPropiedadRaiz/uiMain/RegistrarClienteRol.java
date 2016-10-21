/*
 * Autor: Mirai
 * Opcion para el Funcionario. Registra un nuevo cliente y le asigna su rol.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.empresa.*;


public class RegistrarClienteRol extends OpcionDeMenu{
	
	public RegistrarClienteRol(){
		super.setNombre("Registrar un cliente y su rol.");
	}
	
	public void ejecutar(){
		Scanner input = new Scanner (System.in);
		System.out.println("Ingrese su número de cédula");
		long cedula = input.nextLong();
		Funcionario funcionario = ListaFuncionarios.getFuncionario(cedula);
		System.out.println("Ingrese la cédula del cliente que desea registrar.");
		long cedulaR = input.nextLong();
		System.out.println("Ingrese el nombre del cliente que desea registrar.");
		String nombre = input.next();
		System.out.println("Cual es el rol del cliente?");
		String rol = input.next();
		funcionario.registrarClienteYAsignarRol(cedulaR, nombre, rol);
		System.out.println("Pulse cualquier tecla para continuar");
		input.next();
	}

}
