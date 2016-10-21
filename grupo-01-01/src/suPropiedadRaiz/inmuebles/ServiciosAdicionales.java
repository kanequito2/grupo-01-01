/*
 * Autor: Mirai
 * En caso de tenerlos, se almacenan servicios adicionales de un inmueble.
 */
package suPropiedadRaiz.inmuebles;
import java.util.ArrayList;

public class ServiciosAdicionales implements java.io.Serializable {

	private ArrayList<String> servicios = new ArrayList<String>();
	
	public ServiciosAdicionales(String s){
		this.servicios.add(s);
	}
	
	
	
}
