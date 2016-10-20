package suPropiedadRaiz.usuarios;
import suPropiedadRaiz.inmuebles.Inmueble;
import suPropiedadRaiz.contratos.*;

public class Arrendatario extends Demandador {
	
	Arrendatario(long cedula, String nombre){
		super(cedula,nombre);
	}
	
	//En el siguiente metodo falta el atributo fecha, no sabemos cómo operar fechas
	public String getInmueblesPorLosQuePagoArriendo(){
		String r = "";
		for (int i=0; i<super.getArriendo().size(); i++){
			
			Contrato contrato =  super.getArriendo().get(i);
			Inmueble inmueble = contrato.getInmueble();
			long codigo = inmueble.getCodigo();
			String direccion = inmueble.getDireccion();
			double valorArriendo = contrato.getTarifa();
			String esCasaOApto = inmueble.getClass().getName();
			String fechaInicioContrato = null; //Esta variable se definirá cuando decidamos cómo utilizar fecha
			
			r = r+"Codigo: "+codigo+", Direccion: "+direccion+", Valor de Arriendo: "+valorArriendo+", Es: "+esCasaOApto+", Fecha de inicio de contrato: "+fechaInicioContrato;
		}
		if (r == ""){
			return "No hay inmuebles por los que pagues arriendo";
		}else{
			return r;
		}
	}
	
}
