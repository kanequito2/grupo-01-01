/*
 * Autor: Cristian
 * Clase para el Administrador del Sistema.
 */
package suPropiedadRaiz.usuarios;

import suPropiedadRaiz.empresa.UsuariosRegistrados;

public class AdministradorDelSistema extends Persona{
	public AdministradorDelSistema(long cedula, String nombre){
		super(cedula, nombre);
		UsuariosRegistrados.addUsuario(this);
	}
	

	
}
