package suPropiedadRaiz.uiMain;
import java.util.Scanner;

import suPropiedadRaiz.usuarios.Funcionario;

public class PedirCitaInivitado extends OpcionDeMenu {
	
	public PedirCitaInivitado(){
		super.setNombre("Pedir una cita.");
	}

	public String getNombre(){
		return super.getNombre();
	}
	
	public void ejecutar(){
		System.out.println("Ingrese su nombre.");
		Scanner input = new Scanner(System.in);
		String nombre = input.next();
		System.out.println("Ingrese su cedula.");
		long cedula = input.nextLong();
		System.out.println("Cual es el motivo de su cita?");
		System.out.println("1. Arriendo");
		System.out.println("2. Compra");
		System.out.println("3. Venta.");
		int comando = input.nextInt();
		String motivo;
		if(comando == 0){
			motivo = "Arriendo";
		}
		if(comando == 1){
			motivo = "Compra";
		}
		else{
			motivo = "Venta";
		}
		Funcionario.pedirCita(cedula, nombre, motivo, "Aleatorio");
		
		System.out.println("Presione cualquier tecla para salir");
		motivo = input.next();
		new Salida().ejecutar();
		
	}
}
