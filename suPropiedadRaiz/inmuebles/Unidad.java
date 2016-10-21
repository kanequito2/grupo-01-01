/*
 * Autor: Mirai
 * Unidad. Si es de casas el arreglo de Torres es vacío, si es de apartamentos el arreglo de Casa es vacio.
 */
package suPropiedadRaiz.inmuebles;
import java.util.ArrayList;

import suPropiedadRaiz.empresa.ListaUnidades;

public class Unidad implements java.io.Serializable{

	private final long codigo;
	private String direccion;
	private String nombre;
	private short estrato;
	private boolean cerrada;
	private ArrayList<Torre> torres = new ArrayList<Torre>();
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	
	
	public Unidad(long c, String n, String d, short e, boolean a){ //Constructor para la clase Unidad.
		this.codigo = c;
		this.direccion = d;
		this.estrato = e;
		this.nombre = n;
		this.cerrada = a;
		ListaUnidades.addUnidad(this);
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public short getEstrato() {
		return estrato;
	}


	public void setEstrato(short estrato) {
		this.estrato = estrato;
	}


	public boolean isCerrada() {
		return cerrada;
	}


	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}


	public long getCodigo() {
		return codigo;
	}
	
	public void addTorre(Torre torre){
		this.torres.add(torre);
	}
	
	public void addCasa(Casa casa){
		this.casas.add(casa);
	}
}
