/*
 * Autor: Mirai
 * Clase raiz para las OPciones de Menu
 */
package suPropiedadRaiz.uiMain;


public abstract class OpcionDeMenu {
	
	private String nombre;
	
	abstract public void ejecutar();
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

}
