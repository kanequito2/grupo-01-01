/*
 * Autor: Cristian
 * Clase para Vendedor
 */
package suPropiedadRaiz.usuarios;
import suPropiedadRaiz.empresa.ListaVendedores;
import suPropiedadRaiz.inmuebles.Inmueble;
import java.util.ArrayList;

public class Vendedor extends Oferente {
	
	Vendedor(long cedula, String nombre){
		super(cedula, nombre);
		ListaVendedores.addVendedor(this);
	}	

	public String getCasasParaVender(){
		String r = "";
		ArrayList<Inmueble> vendidos = new ArrayList<Inmueble>();
		for (int i=0; i<super.getCompraVenta().size(); i++){
			vendidos.add(super.getCompraVenta().get(i).getInmueble());
		}
		for ( int i=0; i < super.getInmuebles().size(); i++){
			Inmueble inmueble = super.getInmuebles().get(i);
			long codigo = inmueble.getCodigo();
			String direccion = inmueble.getDireccion();
			String esCasaOApto = inmueble.getClass().getName();
			r = r+"Codigo: "+codigo+", Direccion: "+direccion+", Es: "+esCasaOApto;
			if( vendidos.contains(inmueble) ){
				String fechaVenta = inmueble.getContrato().getMes() + "/"+ inmueble.getContrato().getAño(); 
				double valorVenta = super.getCompraVenta().get(i).getTarifa(); 
				r = r+", fecha de venta: "+fechaVenta+", valor de venta: "+ valorVenta+"\n";
			}else{
				r = r +"\n";
			}
		}
		if ( r == "" ){
			return "No hay inmuebles consignados para vender";
		}else{
			return r;
		}
	}
	
}
