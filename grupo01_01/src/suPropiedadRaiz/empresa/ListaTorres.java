package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.inmuebles.*;

public abstract class ListaTorres {
	
	private static ArrayList<Torre> torresRegistradas = new ArrayList<Torre>();
	
	public static void addTorre(Torre torre){
		torresRegistradas.add(torre);
	}
	
	public static Torre getTorre(long codigo){
		for(int i = 0; i< torresRegistradas.size(); i++){
			if(torresRegistradas.get(i).getCodigo() == codigo){
				return torresRegistradas.get(i);
			}
		}
		return null;
	}

}
