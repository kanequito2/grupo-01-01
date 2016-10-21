/*
 * Autor: Mirai
 * Opcion para el Administrador. Elimina una opcion de menu del menu de otro usuario.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;
import suPropiedadRaiz.usuarios.*;


public class EliminarOpcion extends OpcionDeMenu {
	
	public EliminarOpcion(){
		super.setNombre("Eliminar una opción de menú.");
	}
	
	public void ejecutar(){
		System.out.println("Ingrese el número de cédula del usuario");
		Scanner input = new Scanner(System.in);
		long cedula = input.nextLong();
		MenuDeConsola menu = null;
		for (int i = 0; i < SuPropiedadRaiz.todoMenu.size(); i++){
			if (SuPropiedadRaiz.todoMenu.get(i).getCedula() == cedula){
				menu = SuPropiedadRaiz.todoMenu.get(i);
			}
		}
		menu.mostrarOpciones();
		System.out.println("Seleccione la opción que desea eliminar.");
		int comand = input.nextInt();
		menu.eliminarOpcion(comand);
		System.out.println("Presione cualquier tecla para continuar.");
		input.next();
	}

}
