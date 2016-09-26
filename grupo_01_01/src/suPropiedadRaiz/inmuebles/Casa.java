package suPropiedadRaiz.inmuebles;

public class Casa extends Inmueble {
	
	private Garaje garaje;
	private short pisos;
	
	public Casa(long codigo, float area, Unidad unidad, short pisos){
		super(codigo, area, unidad);
		this.pisos = pisos;
		this.garaje = null;
		super.getUnidad().addCasa(this);
	}
	
	public Casa(long codigo, float area, Unidad unidad, short pisos, Garaje garaje){
		this(codigo, area, unidad, pisos);
		this.garaje = garaje;
	}
	
	public short getPisos(){
		return this.pisos;
	}
	
	public void setPisos(short pisos){
		this.pisos = pisos;
	}
	
	public void setGaraje(Garaje garaje){
		this.garaje = garaje;
	}
	
	public Garaje getGaraje(){
		return this.garaje;
	}
	

}
