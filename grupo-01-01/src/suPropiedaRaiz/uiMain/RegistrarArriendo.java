/*
 * Autor: Mirai
 * Opcion para le Funcionario Registra un  nuevo arriendo.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;
import suPropiedadRaiz.inmuebles.*;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.empresa.ListaArrendadores;
import suPropiedadRaiz.empresa.ListaArrendatarios;
import suPropiedadRaiz.empresa.ListaInmuebles;
import suPropiedadRaiz.empresa.ListaFuncionarios;

public class RegistrarArriendo extends OpcionDeMenu{
	
	public RegistrarArriendo(){
		super.setNombre("Registrar un arriendo");
	}
	
	public void ejecutar(){
		System.out.println("Ingrese su cédula");
		Scanner in = new Scanner(System.in);
		long cedula = in.nextLong();
		System.out.println("Ingrese la cédula del arrendatario"); //oferente
		long cedulaArrendatario = in.nextLong();
		System.out.println("Ingrese el inmueble a arrendar");
		long codigoArriendo = in.nextLong();
		System.out.println("Ingrese la cédula del arrendador");
		long cedulaArrendador = in.nextLong();
		System.out.println("Ingrese el mes actual");
		int mes = in.nextInt();
		System.out.println("Ingrese el año actual");
		int año = in.nextInt();
		System.out.println("Ingrese la tarifa del arriendo");
		float tarifa = in.nextFloat();
		Inmueble inmueble = ListaInmuebles.getInmueble(codigoArriendo);
		new Arriendo (Contrato.codigoContratos++, tarifa, inmueble, ListaFuncionarios.getFuncionario(cedula), ListaArrendatarios.getArrendatario(cedulaArrendatario),ListaArrendadores.getArrendador(cedulaArrendador), año, mes);
		System.out.println("Se ha completado el registro");
		System.out.println("Presione cualquier tecla para continuar");
		in.next();
	}

}
