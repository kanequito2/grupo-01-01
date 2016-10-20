package suPropiedadRaiz.empresa;

import java.util.ArrayList;
import suPropiedadRaiz.usuarios.Persona;

public abstract class UsuariosRegistrados {
	
	private static ArrayList<Persona> usuariosRegistrados = new ArrayList<Persona>();
	
	public static void addUsuario(Persona usuario){
		usuariosRegistrados.add(usuario);
	}

	public static ArrayList<Persona> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}
	
	public static Persona getUsuario(long cedula, String nombre){
		Persona persona = null;
		for( int i=0; i < usuariosRegistrados.size(); i++ ){
			if ( usuariosRegistrados.get(i).getNombre() == nombre ){
				if ( usuariosRegistrados.get(i).getCedula() == cedula ){
					persona = usuariosRegistrados.get(i);
				}
			}
		}
		return persona;
	}
	
}
