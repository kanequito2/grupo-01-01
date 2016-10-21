/*
 * Autor: Cristian
 * Almacena todos los funcionarios creados.
 */
package suPropiedadRaiz.empresa;

import java.util.ArrayList;
import suPropiedadRaiz.usuarios.Funcionario;

public abstract class ListaFuncionarios extends UsuariosRegistrados{
	
	private static ArrayList<Funcionario> funcionariosRegistrados = new ArrayList<Funcionario>();
	
	public static void addFuncionario(Funcionario funcionario){
		funcionariosRegistrados.add(funcionario);
		UsuariosRegistrados.addUsuario(funcionario);
	}
	
	public static ArrayList<Funcionario> getListaFuncionarios(){
		return funcionariosRegistrados;
	}
	
	//Devuelve el Funcionario dandole su cedula.
	public static Funcionario getFuncionario(long cedula){
		Funcionario  funcionario = null;
		for (int i = 0; i < funcionariosRegistrados.size(); i++){
			if(funcionariosRegistrados.get(i).getCedula() == cedula){
				funcionario = funcionariosRegistrados.get(i);
			}
		}
		return funcionario;
	}
	
}
