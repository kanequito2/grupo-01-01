
/*
 * Autor: Mirai
 * Opciom para el Funcionario. Registra una nueva compraventa-
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.empresa.*;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.inmuebles.*;

public class RegistrarCompraVenta extends OpcionDeMenu{
	
	public RegistrarCompraVenta(){
		super.setNombre("Registrar una Compra-Venta");
	}
	
	public void ejecutar(){
		System.out.println("Ingrese su cédula.");
		Scanner in= new Scanner(System.in);
		long cedula = in.nextLong();
		System.out.println("Ingrese la cédula del vendedor");
		long cedulaVendedor = in.nextLong();
		System.out.println("Ingrese el codigo del inmueble que se desea vender");
		long codigoVenta = in.nextLong();
		System.out.println("Ingrese la cédula del comprador");
		long cedulaComprador = in.nextLong();
		System.out.println("Ingrese el mes actual");
		int mes = in.nextInt();
		System.out.println("Ingrese el año actual");
		int año = in.nextInt();
		System.out.println("Ingrese la tarifa de la venta");
		float tarifa = in.nextFloat();
		Inmueble inmueble = ListaInmuebles.getInmueble(codigoVenta);
		CompraVenta contrato = new CompraVenta(Contrato.codigoContratos++,tarifa, inmueble, ListaFuncionarios.getFuncionario(cedula),ListaCompradores.getComprador(cedulaComprador), ListaVendedores.getVendedor(cedulaVendedor),año, mes);
		ListaVendedores.getVendedor(cedulaVendedor).removeInmueble(inmueble);
		ListaCompradores.getComprador(cedulaComprador).removeInmueble(inmueble);
		System.out.println("Se ha registrado la CompraVenta");
		System.out.println("Presione cualquier tecla para continuar");
		in.next();
	}

}
