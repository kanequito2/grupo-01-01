package suPropiedadRaiz.inmuebles;
import java.util.ArrayList;

public abstract class Inmueble {
	
	private final long codigo;
	private float areaTotal;
	
	private boolean parqueoComunal;
	private float areaBalcon;
	private float areaTerraza;
	
	private ArrayList<Cuarto> cuartos = new ArrayList<Cuarto>();
	private int baños = 0;
	private int piezas = 0;
	
	private final Unidad unidad;
	
	private float tarifa;
	public String estado;
	
	public Inmueble(long codigo, float area, Unidad unidad){
		this.codigo = codigo;
		this.areaTotal = area;
		this.unidad = unidad;
	}
		
	public long getCodigo(){
		return this.codigo;
	}
	
	public float getAreaTotal(){
		return this.areaTotal;
	}
	
	public void setAreaTotal(float area){
		this.areaTotal = area;
	}
	
	public boolean isParqueoComunal(){
		return this.parqueoComunal;
	}
	
	public void setParqueComunal(boolean parqueo){
		this.parqueoComunal = parqueo;
	}
	
	public boolean isBalcon(){
		return (this.areaBalcon > 0);
	}
	
	public float getAreaBalcon(){
		if (this.isBalcon()){
			return this.areaBalcon;
		}
		else{
			return -1;
		}
	}
	
	public boolean isTerraza(){
		return(this.areaTerraza>0);
	}
	
	public float getAreaTerraza(){
		if (this.isTerraza()){
			return this.areaTerraza;
		}
		else{
			return -1;
		}
	}
	
	public void setAreas(float balcon, float terraza){
		this.areaBalcon = balcon;
		this.areaTerraza = terraza;
	}
	
	public int cuantosCuartos(){
		return this.cuartos.size();
	}
	
	public void addCuarto(Cuarto cuarto){
		this.cuartos.add(cuarto);
		if(cuarto.getUso().compareTo("Baño") == 0){
			this.baños++;
		}
		else {
			this.piezas++;
		}
	}
	
	public int cuantosBaños(){
		return this.baños;
	}
	
	public int cuantasPiezas(){
		return this.piezas;
	}
	
	public String getDireccion(){
		return this.unidad.getDireccion();
	}
	
	public short getEstrato(){
		return this.unidad.getEstrato();
	}
	
	public Unidad getUnidad(){
		return this.unidad;
	}

	
	
	
	
	
	
	
	public float getTarifa(){
		return this.tarifa;
	}
	
	public void setTarifa(float tarifa){
		this.tarifa = tarifa;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	public String getEstado(){
		return estado;
		
	}
	
	public ArrayList<Cuarto> getCuartos(){
		return this.cuartos;
	}
	
	
	
	
	
	
}
