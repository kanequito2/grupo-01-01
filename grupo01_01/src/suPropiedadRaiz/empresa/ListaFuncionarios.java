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
	
}
