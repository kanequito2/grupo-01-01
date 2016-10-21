/*
 * Autor: Mirai
 * Clase raiz de los Apartamentos. 
 */
package suPropiedadRaiz.inmuebles;

abstract public class Apartamento extends Inmueble {
	
	private final Torre torre;
	
	public Apartamento(long codigo, float area, Unidad unidad, Torre torre){
		super(codigo, area, unidad);
		this.torre = torre;
	}
	
	public Torre getTorre(){
		return this.torre;
	}

}
