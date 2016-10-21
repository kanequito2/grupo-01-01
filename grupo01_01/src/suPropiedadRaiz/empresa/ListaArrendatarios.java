package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.usuarios.*;

public class ListaArrendatarios {

	private static ArrayList<Arrendatario> arrendatariosRegistrados = new ArrayList<Arrendatario>();
	
	public static void addArrendatario(Arrendatario arrendatario){
		arrendatariosRegistrados.add(arrendatario);
	}
	
	public static Arrendatario getArrendatario(long cedula){
		for(int i = 0; i < arrendatariosRegistrados.size(); i++){
			if(arrendatariosRegistrados.get(i).getCedula() == cedula){
				return arrendatariosRegistrados.get(i);
			}
		}
		return null;
	}
	
}
