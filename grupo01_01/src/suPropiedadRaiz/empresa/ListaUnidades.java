package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.inmuebles.*;

public abstract class ListaUnidades {
	
	private static ArrayList<Unidad> unidadesRegistradas = new ArrayList<Unidad>();
	
	public static void addUnidad(Unidad unidad){
		unidadesRegistradas.add(unidad);
	}
	
	public static Unidad getUnidad(long codigo){
		for(int i=0; i< unidadesRegistradas.size(); i++){
			if(unidadesRegistradas.get(i).getCodigo() == codigo){
				return unidadesRegistradas.get(i);
			}
		}
		return null;
	}

}
