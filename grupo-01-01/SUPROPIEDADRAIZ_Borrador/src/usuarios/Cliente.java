package usuarios;

import java.util.ArrayList;
import inmuebles.*;

public class Cliente extends Persona{
	
	public Cliente (long cedula, String nombre){
		super(cedula,nombre);
		clientesRegistrados.add(this);
	}
	
	private static ArrayList <Cliente> clientesRegistrados = new ArrayList <Cliente>();
	
	private String telefono = null;
	private String direccionDeResidencia = null;
	private String celular = null;
	private ArrayList <Inmueble> inmueblesPoseidos = new ArrayList <Inmueble>();
	
	boolean rol;
	double presupuesto;
	private String lugarDeInteres;
	private int estratoDeInteres;
	/*Referencias*/ private String rangoDeAreaDeLaCasa;
	/*Referencias*/ private boolean debenTenerTerraza;
	
	public static boolean yaHaSidoCliente (long cedula){
		int i;
		for (i=0; i<clientesRegistrados.size(); i++){
			if ( clientesRegistrados.get(i).getCedula() == cedula ){
				return true;
			}
		}
		return false;
	}
	
	public String getInmueblesPorLosQueMePaganArriendo(){
		String r = null;
		for (int i=0; i<inmueblesPoseidos.size(); i++){
			if (inmueblesPoseidos.get(i).estaArrendado()){
				r = r +"Codigo: "+inmueblesPoseidos.get(i).getCodigo()+", Direccion: "+inmueblesPoseidos.get(i).getDireccion()+", Valor de arriendo: "+inmueblesPoseidos.get(i).getValorArriendo()+", Es: "+inmueblesPoseidos.get(i).getEsCasaOEsApartamento()+", Fecha de Incio de Contrato: "+inmueblesPoseidos.get(i).getFechaInicioContrato();
			}
		}
		if (r==null){return "No hay inmuebles Arrendados";}else{return r;}
	}
	
	public String getMisInmueblesDisponiblesParaArrendar(){
		String r = null;
		for (int i=0; i<inmueblesPoseidos.size(); i++){
			if ( inmueblesPoseidos.get(i).estaArrendado() == false ){
				r = r +"Codigo: "+inmueblesPoseidos.get(i).getCodigo()+", Direccion: "+inmueblesPoseidos.get(i).getDireccion()+", Es: "+inmueblesPoseidos.get(i).getEsCasaOEsApartamento()+", Valor de arriendo: "+inmueblesPoseidos.get(i).getValorArriendo()+", Fecha de Incio de COntrato: "+inmueblesPoseidos.get(i).getFechaInicioContrato();
			}
		} 
		if (r==null){return "No hay inmuebles disponibles para arrendar";}else{return r;}
	}
	
	public void addPropiedad(Inmueble e){
		inmueblesPoseidos.add(e);
	}
	
	public void setRol(boolean rol){
		this.rol = rol;
	}

	public ArrayList<Inmueble> getInmueblesPoseidos() {
		return inmueblesPoseidos;
	}
	
}
