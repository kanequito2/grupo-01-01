package suPropiedadRaiz.empresa;
import java.util.ArrayList;
import suPropiedadRaiz.usuarios.*;

public abstract class ListaClientes extends UsuariosRegistrados {
	
	private static ArrayList<Cliente> clientesRegistrados = new ArrayList<Cliente>();
	
	public static void addCliente(Cliente cliente){
		clientesRegistrados.add(cliente);
		UsuariosRegistrados.addUsuario(cliente);
	}
	
	public static ArrayList<Cliente> getClientes(){
		return clientesRegistrados;
	}
	
	public static boolean yaHaSidoCliente(long cedula){
		for (int i=0; i < clientesRegistrados.size(); i++){
			if ( clientesRegistrados.get(i).getCedula() == cedula ){
				return true;
			}
		}
		return false;
	}
	
	public static Cliente getCliente(long cedula){
		for(int i=0; i < clientesRegistrados.size(); i++){
			if(clientesRegistrados.get(i).getCedula() == cedula){
				return clientesRegistrados.get(i);
			}
		}
		return null;
	}

}
