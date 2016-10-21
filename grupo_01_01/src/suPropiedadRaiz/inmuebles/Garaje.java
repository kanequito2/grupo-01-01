package suPropiedadRaiz.inmuebles;

public class Garaje {
	
	public static long codigoGarajes = 1;
	private final long codigo;
	private boolean puertaElectrica;
	private float altura;
	private float area;
	
	public Garaje (long codigo, float area, float altura, boolean electrica){
		this. codigo = codigo;
		this.area = area;
		this.altura = altura;
		this.puertaElectrica = electrica;
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	
	public void setPuertaElectrica(boolean electrica){
		this.puertaElectrica = electrica;
	}
	
	public boolean isPuertaElectrica() {
		return this.puertaElectrica;
	}
	
	public float getArea(){
		return this.area;
	}
	
	public float getAltura(){
		return this.altura;
	}

}
