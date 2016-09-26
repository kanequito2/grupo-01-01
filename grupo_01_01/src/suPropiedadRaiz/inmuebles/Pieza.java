package suPropiedadRaiz.inmuebles;

public class Pieza extends Cuarto{
	
	public Pieza(long codigo, float area, String uso){
		super(codigo, area);
		super.setUso(uso);
	}
	

}
