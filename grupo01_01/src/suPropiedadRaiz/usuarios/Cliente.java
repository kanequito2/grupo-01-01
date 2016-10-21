package suPropiedadRaiz.usuarios;

import java.util.ArrayList;
import suPropiedadRaiz.inmuebles.*;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.empresa.ListaClientes;

public abstract class Cliente extends Persona{
	
	public Cliente (long cedula, String nombre){
		super(cedula,nombre);
		ListaClientes.addCliente(this);  
	}
	
	private ArrayList <Inmueble> inmueblesPoseidos = new ArrayList <Inmueble>();
	private ArrayList <CompraVenta> compraVenta = new ArrayList <CompraVenta>();
    private ArrayList <Arriendo> arriendo = new ArrayList <Arriendo>();
	
	public ArrayList<Inmueble> getInmuebles() {
		return inmueblesPoseidos;
	}
	
	public void addInmueble(Inmueble inmueble){
		inmueblesPoseidos.add(inmueble);
	}
	
	public void removeInmueble(Inmueble inmueble){
		inmueblesPoseidos.remove(inmueble);
	}
	
	public ArrayList <CompraVenta> getCompraVenta(){
		return this.compraVenta;
	}
	
	public ArrayList <Arriendo> getArriendo(){
		return this.arriendo;
	}
	
		
	private String telefono = null;
	private String direccionDeResidencia = null;
	private String celular = null;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccionDeResidencia() {
		return direccionDeResidencia;
	}

	public void setDireccionDeResidencia(String direccionDeResidencia) {
		this.direccionDeResidencia = direccionDeResidencia;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
}
