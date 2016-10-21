/*
 * Autor: Cristian
 * Usuario invitado, mientras se registra
 */
package suPropiedadRaiz.usuarios;

import suPropiedadRaiz.empresa.*;

public class UsuarioInvitado extends Persona{
	
	public UsuarioInvitado(){
		super(0,null);
	}
		
	public String solicitarCita (long cedula, String nombre, String motivoDeLaCita){
		String funcionario;
		if ( ListaClientes.yaHaSidoCliente(cedula) ) //Ya había sido cliente//
		{
			funcionario = "Anterior";
																			
		}else  //Nunca había sido cliente//
		{ 
			funcionario = "Aleatorio";
		}
		String r = Funcionario.pedirCita(cedula,nombre,motivoDeLaCita,funcionario);
		return r;
	}
	
	public void login(long cedula)//Este metodo solo encuentra el usuario que se ha logueado. No hace nada de menu todavia
	{
		UsuariosRegistrados.getUsuario(cedula);
	}
	
}
