package suPropiedadRaiz.usuarios;

import suPropiedadRaiz.empresa.ListaCompradores;

public class Comprador extends Demandador {
	
	Comprador(long cedula, String nombre){
		super(cedula, nombre);
		ListaCompradores.addComprador(this);
	}
	
}
