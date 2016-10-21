/*
 * Autor: Mirai
 * Opcion de menu para el Funcionario. Busca Apartamento en Venta de acuerdo a ciertos criterios de busqueda.
 */
package suPropiedadRaiz.uiMain;

import java.util.Scanner;

import suPropiedadRaiz.empresa.ListaInmuebles;
import suPropiedadRaiz.inmuebles.ApartamentoVenta;

public class BuscarApartamentoVenta extends OpcionDeMenu{
	
	public BuscarApartamentoVenta(){
		super.setNombre("Buscar un apartamento para la venta");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el menor valor");
		float menor = in.nextFloat();
		System.out.println("Ingrese el mayor valor");
		float mayor = in.nextFloat();
		System.out.println("Ingrese el estrato de interes");
		short estrato = in.nextShort();
		System.out.println("Ingrese area menor");
		float areaMenor = in.nextFloat();
		System.out.println("Ingrese area mayor");
		float areaMayor = in.nextFloat();
		System.out.println("Ingrese numero minimo de baños");
		int baños = in.nextInt();
		System.out.println("Ingrese numero minimo de piezas");
		int piezas = in.nextInt();
		for(int i = 0; i < ListaInmuebles.getInmueblesRegistrados().size(); i++){
			if(ListaInmuebles.getInmueblesRegistrados().get(i) instanceof ApartamentoVenta){
				boolean compTarifa = ListaInmuebles.getInmueblesRegistrados().get(i).getTarifa() > menor && ListaInmuebles.getInmueblesRegistrados().get(i).getTarifa() < mayor;
				boolean compEstrato = ListaInmuebles.getInmueblesRegistrados().get(i).getEstrato() == estrato;
				boolean compArea = ListaInmuebles.getInmueblesRegistrados().get(i).getAreaTotal() < areaMayor && ListaInmuebles.getInmueblesRegistrados().get(i).getAreaTotal() > areaMenor;
			    boolean compBaños = ListaInmuebles.getInmueblesRegistrados().get(i).cuantosBaños() >= baños;
			    boolean compPiezas = ListaInmuebles.getInmueblesRegistrados().get(i).cuantasPiezas() >= piezas;
				if(compTarifa & compEstrato && compArea && compBaños && compPiezas){
			    	System.out.println("Codigo: " + ListaInmuebles.getInmueblesRegistrados().get(i).getCodigo() + ". Dirección: " + ListaInmuebles.getInmueblesRegistrados().get(i).getDireccion() + ". Nombre de la unidad: " + ListaInmuebles.getInmueblesRegistrados().get(i).getUnidad().getNombre() + "." + "\n");
			    }
			}
		}
		System.out.println("Se ha realizado la busqueda");
		System.out.println("Pulse cualquier tecla para continuar");
		in.next();
	}

}
