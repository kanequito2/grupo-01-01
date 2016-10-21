/*
 * Autor: Mirai
 * Clase Raiz para los cuartos.
 */
package suPropiedadRaiz.inmuebles;

public abstract class Cuarto implements java.io.Serializable {
	
	private long codigo;
	private float area;
	private String uso;
	
	public Cuarto(long codigo, float area){
		this.codigo = codigo;
		this.area = area;
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	
	public float getArea(){
		return this.area;
	}
	
	public void setArea(float area){
		this.area = area;
	}
	
	public String getUso(){
		return this.uso;
	}
	
	public void setUso(String uso){
		this.uso = uso;
	}

}
