package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.usuarios.*;

public class ListaVendedores {

	private static ArrayList<Vendedor> vendedoresRegistrados = new ArrayList<Vendedor>();
	
	public static void addVendedor(Vendedor vendedor){
		vendedoresRegistrados.add(vendedor);
	}
	
	public static Vendedor getVendedor(long cedula){
		for(int i = 0; i < vendedoresRegistrados.size(); i++){
			if(vendedoresRegistrados.get(i).getCedula()==cedula){
				return vendedoresRegistrados.get(i);
			}
		}
		return null;
	}
	
}
