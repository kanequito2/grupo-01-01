package suPropiedadRaiz.empresa;

import java.util.ArrayList;
import suPropiedadRaiz.contratos.*;

public abstract class ListaContratos {
	
	static ArrayList<CompraVenta> listaContratosCompraVenta = new ArrayList<CompraVenta>();
	static ArrayList<Arriendo> listaContratosArriendos = new ArrayList<Arriendo>();
	
	public static ArrayList<CompraVenta> getListaContratosCompraVenta() {
		return listaContratosCompraVenta;
	}
	
	public static ArrayList<Arriendo> getListaContratosArriendos() {
		return listaContratosArriendos;
	}
	
	public static void addCompraVenta(CompraVenta contrato){
		listaContratosCompraVenta.add(contrato);
	}
	
	public static void addArriendo(Arriendo contrato){
		listaContratosArriendos.add(contrato);
	}
	
}
