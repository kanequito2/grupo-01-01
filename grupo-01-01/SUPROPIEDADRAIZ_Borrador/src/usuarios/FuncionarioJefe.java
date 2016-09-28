package usuarios;
import java.util.ArrayList;

public class FuncionarioJefe extends Funcionario{
	
	private ArrayList <Funcionario> funcionariosAMiCargo = new ArrayList<Funcionario>();
	
	public FuncionarioJefe(long cedula, String nombre){
		super(cedula,nombre);
	}
	
	public String getFuncionariosAMiCargo(){
		String r="";
		for (int i=0; i<funcionariosAMiCargo.size(); i++){
			r = r + "Cedula: "+ funcionariosAMiCargo.get(i).getCedula() +", Nombre: "+ funcionariosAMiCargo.get(i).getNombre() + ", Sueldo: "+ funcionariosAMiCargo.get(i).generarSueldoNeto("")+"\n";
		}
		return r;
	}
	
	public String listaClientesDeMisFuncionarios(){
		String r="";
		for (int i=0; i<funcionariosAMiCargo.size(); i++){
			r = r +"Funcionario: \n"+ "Nombre: "+ funcionariosAMiCargo.get(i).getCedula() +", Cedula: "+ funcionariosAMiCargo.get(i).getNombre()+"\nClientes del funcionario\n";
			r = r + funcionariosAMiCargo.get(i).generarListaDeClientes()+"\n";
		}
		return r;
	}
	
	public Funcionario addFuncionario (long cedula, String nombre){
		Funcionario e = new Funcionario (cedula, nombre);
		funcionariosAMiCargo.add(e);
		return e;
	}
	
}
