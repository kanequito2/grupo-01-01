package suPropiedadRaiz.inmuebles;
import java.util.ArrayList;

import suPropiedadRaiz.empresa.ListaTorres;

public class Torre {

	private final long codigo;
	private ArrayList<Piso> pisos = new ArrayList<Piso>();
	private Unidad unidad;
	private boolean ascensor;
	
	public Torre(long codigo, Unidad unidad, int pisos, boolean ascensor){
		this.codigo = codigo;
		this.unidad = unidad;
		for (int i = 0; i < pisos; i++){
			this.pisos.add(new Piso());
		}
		this.ascensor = ascensor;
		this.unidad.addTorre(this);
		ListaTorres.addTorre(this);
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	
	public Unidad getUnidad(){
		return this.unidad;
	}
	
	public void addApartamento(Apartamento apartamento, int piso){
		this.pisos.get(piso).addApartamento(apartamento);
	}
	
	public int getNumeroApartamentos(int piso){
		return this.pisos.get(piso).getCantidad();		
	}
	
	public String getDireccion(){
		return this.unidad.getDireccion();
	}
	
	public short getEstrato(){
		return this.unidad.getEstrato();
	}
	
	public boolean isAscensor(){
		return this.ascensor;
	}
	
	public boolean setAscensor(boolean ascensor){
		return this.ascensor = ascensor;
	}
}
