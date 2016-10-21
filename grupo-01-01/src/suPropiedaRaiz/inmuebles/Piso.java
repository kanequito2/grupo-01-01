/*
 * Autor: Mirai
 * Para uso en torres. Almacena apartamentos.
 */
package suPropiedadRaiz.inmuebles;
import java.util.ArrayList;

public class Piso  implements java.io.Serializable{

	private ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
	private int cantidad = 0;
	
	
	
	public void addApartamento(Apartamento apartamento){
		this.apartamentos.add(apartamento);
		this.cantidad++;
	}
	public void removeApartamento(Apartamento apartamento){
		this.apartamentos.remove(apartamento);
		this.cantidad --;
	}
	
	public int apartamentosPiso(){
		return this.apartamentos.size();
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	
	
}
