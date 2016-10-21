package suPropiedadRaiz.uiMain;
import java.util.Scanner;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.empresa.*;

public class ClientesDeMisFuncionarios extends OpcionDeMenu{
	
	public ClientesDeMisFuncionarios(){
		super.setNombre("Lista de clientes asociados a mis funcionarios");
	}
	
	public void ejecutar(){
		System.out.println("Ingrese su numero de cédula");
		Scanner input = new Scanner(System.in);
		long cedula = input.nextLong();
		FuncionarioJefe funcionarioJ = ListaFuncionariosJefe.getFuncionarioJefe(cedula);
		System.out.println("Los clientes de mis funcionarios:");
		System.out.println(funcionarioJ.listaClientesDeMisFuncionarios());
		System.out.println("Presione cualquier tecla para continuar");
		input.next();
	}

}
