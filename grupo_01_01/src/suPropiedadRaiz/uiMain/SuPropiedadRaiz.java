package suPropiedadRaiz.uiMain;
import java.util.ArrayList;

import suPropiedadRaiz.empresa.UsuariosRegistrados;
import suPropiedadRaiz.usuarios.*;
public class SuPropiedadRaiz {
	
	static ArrayList<MenuDeConsola> todoMenu = new ArrayList<MenuDeConsola>();
	
	public static void main(String[] args){
		
		if (UsuariosRegistrados.getUsuariosRegistrados().isEmpty()){
		/* Si es la primera vez que se corre el programa y no existe nadie se crea un Administrador de Sistema y un Funcionario Jefe
		 * Existe la necesidad de crear un objeto de las clases que administran las listas, pues para guardar el estado del programa
		 * para la siguiente ejecución es necesario tener un objeto que acceda a las listas y poder guardar esos estados(?).
		 * PENDIENTE!!!!!
		*/
			UsuariosRegistrados.addUsuario(new AdministradorDelSistema(100000, "Administrador Gonzales"));
			new FuncionarioJefe(100001, "Funcionario Jefe Ramirez");			
		}
		
		
		MenuDeConsola menuInicial = new MenuDeConsola();
		menuInicial.agregarOpcion(new LogIn());
		menuInicial.agregarOpcion(new PedirCitaInivitado());
		menuInicial.desplegarOpciones();
		
		
	}

}
