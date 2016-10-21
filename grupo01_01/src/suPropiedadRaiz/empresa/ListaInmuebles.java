package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.inmuebles.*;

public abstract class ListaInmuebles {

	private static ArrayList<Inmueble> inmueblesRegistrados = new ArrayList<Inmueble>();
	
	public static ArrayList<Inmueble> getInmueblesRegistrados(){
		return inmueblesRegistrados;
	}
	
	public static Inmueble getInmueble(long codigo){
		Inmueble inmueble = null;
		for(int i = 0; i < inmueblesRegistrados.size(); i++){
			if(inmueblesRegistrados.get(i).getCodigo() == codigo){
				inmueble = inmueblesRegistrados.get(i);
			}
		}
		return inmueble;
	}
	
}
