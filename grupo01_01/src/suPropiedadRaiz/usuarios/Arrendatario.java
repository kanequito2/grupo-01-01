package suPropiedadRaiz.usuarios;
import suPropiedadRaiz.inmuebles.Inmueble;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.empresa.ListaArrendatarios;

public class Arrendatario extends Demandador {
	
	Arrendatario(long cedula, String nombre){
		super(cedula,nombre);
		ListaArrendatarios.addArrendatario(this);
	}
	
	
	public String getInmueblesPorLosQuePagoArriendo(){
		String r = "";
		for (int i=0; i<super.getArriendo().size(); i++){
			
			Contrato contrato =  super.getArriendo().get(i);
			Inmueble inmueble = contrato.getInmueble();
			long codigo = inmueble.getCodigo();
			String direccion = inmueble.getDireccion();
			double valorArriendo = contrato.getTarifa();
			String esCasaOApto = inmueble.getClass().getName();
			String fechaInicioContrato = contrato.getMes() + "/" + contrato.getAño();
			
			r = r+"Codigo: "+codigo+", Direccion: "+direccion+", Valor de Arriendo: "+valorArriendo+", Es: "+esCasaOApto+", Fecha de inicio de contrato: "+fechaInicioContrato;
		}
		if (r == ""){
			return "No hay inmuebles por los que pagues arriendo";
		}else{
			return r;
		}
	}
	
}
