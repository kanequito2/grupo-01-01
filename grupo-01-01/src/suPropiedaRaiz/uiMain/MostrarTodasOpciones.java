/*
 * Autor: Mirai
 * Opcion para Administrador de Sistema. Muestra todas las opciones de cierto usuario-
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;

public class MostrarTodasOpciones extends OpcionDeMenu {
	
	public MostrarTodasOpciones(){
		super.setNombre("Mostrar todas las opciones de un usuario.");
	}
	
	public void ejecutar(){
		System.out.println("Ingrese el numero de identificacion del usuario");
		Scanner input = new Scanner(System.in);
		int cedula = input.nextInt();
		MenuDeConsola menuMostrar = null;
		for (int i = 0; i < SuPropiedadRaiz.todoMenu.size(); i++){
			if(SuPropiedadRaiz.todoMenu.get(i).getCedula() == cedula){
				menuMostrar = SuPropiedadRaiz.todoMenu.get(i);
			}
		}
		menuMostrar.mostrarOpciones();
		System.out.println("Presione cualquier tecla para continuar");
		input.next();
	}

}
