package usuarios;
import inmuebles.Inmueble;

public class Vendedor extends Oferente {
	
	Vendedor(long cedula, String nombre){
		super(cedula, nombre);
	}
	
	//Se agrega el metodo fueVendido() de maner auxiliar para evitar errores en el codigo 
	//Definir forma de saber si la casa fue vendida por medio de los contratos
	public String getCasasParaVender(){
		String r = "";
		for ( int i=0; i < super.getInmuebles().size(); i++){
			Inmueble inmueble = super.getInmuebles().get(i);
			if( inmueble.fueVendido() ){
				long codigo = inmueble.getCodigo();
				String direccion = inmueble.getDireccion();
				String esCasaOApto = inmueble.getClass().getName();
				r=r+"Codigo: "+codigo+", Direccion: "+direccion+", Es: "+esCasaOApto+"\n";
			}else{
				long codigo = inmueble.getCodigo();
				String direccion = inmueble.getDireccion();
				String esCasaOApto = inmueble.getClass().getName();
				String fechaVenta = null; // super.getCompraVenta.....
				String valorVenta = null; // super.getCompraVenta.....
				r=r+"Codig: "+codigo+", Direccion: "+direccion+", Es: "+esCasaOApto+", fecha de venta: "+fechaVenta+", valor de venta: "+ valorVenta;
			}
		}
		if ( r == "" ){
			return "No hay inmuebles consignados para vender";
		}else{
			return r;
		}
	}
	
}
