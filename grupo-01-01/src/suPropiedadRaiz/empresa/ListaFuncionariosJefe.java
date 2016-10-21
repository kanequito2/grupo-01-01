/*
 * Autor: Cristian
 * Almacena los FuncionarioJefe creados.
 */
package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.usuarios.FuncionarioJefe;

public abstract class ListaFuncionariosJefe {
	
	private static ArrayList<FuncionarioJefe> funcionariosJefeRegistrados = new ArrayList<FuncionarioJefe>();
	
	public static void addFuncionarioJefe(FuncionarioJefe f){
		funcionariosJefeRegistrados.add(f);
	}
	
	//Devuelve un FuncionarioJefe dandole su cedula.
	public static FuncionarioJefe getFuncionarioJefe(long cedula){
		for(int i = 0; i < funcionariosJefeRegistrados.size(); i++){
			if(funcionariosJefeRegistrados.get(i).getCedula() == cedula){
				return funcionariosJefeRegistrados.get(i);
			}
		}
		return null;
	}
	
}
