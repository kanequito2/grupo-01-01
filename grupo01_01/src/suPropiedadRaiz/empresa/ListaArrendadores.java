package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.usuarios.*;

public class ListaArrendadores {
	
	private static ArrayList<Arrendador> arrendadoresRegistrados = new ArrayList<Arrendador>();
	
	public static void addArrendador(Arrendador arrendador){
		arrendadoresRegistrados.add(arrendador);
	}
	
	public static Arrendador getArrendador(long cedula){
		for(int i = 0; i < arrendadoresRegistrados.size(); i++){
			if(arrendadoresRegistrados.get(i).getCedula() == cedula){
				return arrendadoresRegistrados.get(i);
			}
		}
		return null;
	}

}
