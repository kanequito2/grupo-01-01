package usuarios;

import java.util.ArrayList;
import inmuebles.*;
//import contratos.*;

public abstract class Cliente extends Persona{
	
	public Cliente (long cedula, String nombre){
		super(cedula,nombre);
		// clientesRegistrados.add(this); //EseArrayList atenta contra la POO :(   
	}
//  El uso de los tres siguientes atributos no se especifica en la guia		
//	private String telefono = null;
//	private String direccionDeResidencia = null;
//	private String celular = null;
	
	private ArrayList <Inmueble> inmuebles = new ArrayList <Inmueble>();
//  private ArrayList <CompraVenta> compraVenta = new ArrayList <CompraVenta>();
//  private ArrayList <Arrendamiento> arrendamientos = new ArrayList <Arrendamientos>();
	
	/*	private static ArrayList <Cliente> clientesRegistrados = new ArrayList <Cliente>(); 
	 * Ese Array atentaba contra los principios de la POO, inventarse otra manera de consultar informacion de los clientes.
	 * Alternativa: Si sólo la clase cliente utiliza este Array en sus metodos, ¿seguiría atentando contra la POO?
	 */
	
	/* 
	 * public static boolean yaHaSidoCliente (long cedula){
		int i;
		for (i=0; i<clientesRegistrados.size(); i++){
			if ( clientesRegistrados.get(i).getCedula() == cedula ){
				return true;
			}
		}
		return false;
	}
	*/
	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}
	
	public void addInmueble(Inmueble e){
		inmuebles.add(e);
	}
	/*
	public ArrayList <CompraVenta> getCompraVenta(){
		return this.compraVenta;
	}
	
	public ArrayList <CompraVenta> getArrendamientos(){
		return this.arrendamientos;
	}
	*/
}
