package usuarios;

import inmuebles.Inmueble;

public class Arrendador extends Oferente{

	//Constructor
	Arrendador(long cedula, String nombre){
		super(cedula,nombre);
	}
	//En los dos siguientes metodos no estan definidos los valores que requieren de las clases contrato.
	//El metodo estaArrendado() fue definido de manera auxiliar para evitar que el codigo presente errores
	//Definir un metodo para saber si un inmueble esta arrendado
	public String getInmueblesPorLosQueMePaganArriendo(){
		String r = "";
		for (int i=0; i<super.getInmuebles().size(); i++){
			if ( super.getInmuebles().get(i).estaArrendado() ){
				Inmueble inmueble =  super.getInmuebles().get(i);
				long codigo = inmueble.getCodigo();
				String direccion = inmueble.getDireccion();
				long valorArriendo = 0; //Definir este atributo cuando los contratos esten listos
				String esCasaOApto = inmueble.getClass().getName();
				String fechaInicioContrato = null; //Definir este atributo cuando los contratos esten listos 
				r = r+"Codigo: "+codigo+", Direccion: "+direccion+", Valor de Arriendo: "+valorArriendo+", Es: "+esCasaOApto+", Fecha de inicio de contrato: "+fechaInicioContrato;
			}
		}
		if (r==""){return "No hay inmuebles Arrendados";}
		else{return r;}
	}
	
	public String getInmueblesDisponiblesParaArrendar(){
		String r = "";
		for (int i=0; i<super.getInmuebles().size(); i++){
			if ( super.getInmuebles().get(i).estaArrendado() == false ){
				Inmueble inmueble =  super.getInmuebles().get(i);
				long codigo = inmueble.getCodigo();
				String direccion = inmueble.getDireccion();
				long valorArriendo = 0; //Definir este atributo cuando los contratos esten listos
				String esCasaOApto = inmueble.getClass().getName();
				String fechaInicioContrato = null; //Definir este atributo cuando los contratos esten listos
				r = r+"Codigo: "+codigo+", Direccion: "+direccion+", Valor de Arriendo: "+valorArriendo+", Es: "+esCasaOApto+", Fecha de inicio de contrato: "+fechaInicioContrato;
			}
		} 
		if (r==""){return "No hay inmuebles disponibles para arrendar";}
		else{return r;}
	}
	
}
