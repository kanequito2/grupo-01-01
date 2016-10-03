package usuarios;
import inmuebles.Inmueble;

public class Arrendatario extends Demandador {
	
	Arrendatario(long cedula, String nombre){
		super(cedula,nombre);
	}
	
	//En el siguiente metodo no estan definidos los valores que requieren de las clases contrato
	public String getInmueblesPorLosQuePagoArriendo(){
		String r = "";
		for (int i=0; i<super.getInmuebles().size(); i++){
			Inmueble inmueble =  super.getInmuebles().get(i);
			long codigo = inmueble.getCodigo();
			String direccion = inmueble.getDireccion();
			long valorArriendo = 0; //Este atributo se definira con base en la estructura de arriendos
			String esCasaOApto = inmueble.getClass().getName();
			String fechaInicioContrato = null; //Este atributo se definira con base en la estructura de arriendos
			r = r+"Codigo: "+codigo+", Direccion: "+direccion+", Valor de Arriendo: "+valorArriendo+", Es: "+esCasaOApto+", Fecha de inicio de contrato: "+fechaInicioContrato;
		}
		if (r == ""){
			return "No hay inmuebles por los que pagues arriendo";
		}else{
			return r;
		}
	}
	
}
