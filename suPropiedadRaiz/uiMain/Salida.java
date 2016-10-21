/*
 * Autor: Mirai
 * Para salir
 */
package suPropiedadRaiz.uiMain;
import suPropiedadRaiz.empresa.*;

import suPropiedadRaiz.empresa.ListaInmuebles;
import suPropiedadRaiz.gestionBD.GestionBD;

public class Salida extends OpcionDeMenu {
	
	public Salida(){
		super.setNombre("Salir.");
	}
	
	public String getNombrr(){
		return super.getNombre();
	}
	
	public void ejecutar(){
		GestionBD.seriarInmueble(ListaInmuebles.getInmueblesRegistrados(), "inmueblesReg");
		GestionBD.seriarPersona(UsuariosRegistrados.getUsuariosRegistrados(), "usuariosReg");
	}

}
