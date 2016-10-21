/*
 * Autor: Cristian
 * Almacena todos los Compradores.
 */
package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.usuarios.*;

public class ListaCompradores {
	
	private static ArrayList<Comprador> compradoresRegistrados = new ArrayList<Comprador>();
	
	public static void addComprador(Comprador comprador){
		compradoresRegistrados.add(comprador);
	}
	
	//Devuelve un Comprador dandole su cedula.
	public static Comprador getComprador(long cedula){
		for(int i=0; i < compradoresRegistrados.size(); i++){
			if(compradoresRegistrados.get(i).getCedula() == cedula){
				return compradoresRegistrados.get(i);
			}
		}
		return null;
	}

}
