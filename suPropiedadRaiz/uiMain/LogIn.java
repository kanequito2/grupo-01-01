/*
 * Autor: Mirai
 * Opcion de Menu incial, con este se identifica quien esta accesando al sistema.
 */
package suPropiedadRaiz.uiMain;
import java.util.Scanner;
import suPropiedadRaiz.empresa.*;
import suPropiedadRaiz.usuarios.*;

public class LogIn extends OpcionDeMenu {

	public LogIn(){
		super.setNombre("Ingreso de Usuario.");
	}
	
	public String getNombre(){
		return super.getNombre();
	}
	
	public void ejecutar(){
		System.out.println("Ingrese su número de cédula.");
		Scanner input = new Scanner(System.in);
		long cedula = input.nextLong();
		Persona usuario = null;
		for (int i = 0; i < UsuariosRegistrados.getUsuariosRegistrados().size(); i++){
			if(UsuariosRegistrados.getUsuariosRegistrados().get(i).getCedula() == cedula){
				usuario = UsuariosRegistrados.getUsuariosRegistrados().get(i);
				break;
			}
		}
		
		if (UsuariosRegistrados.getUsuariosRegistrados().contains(usuario)){
			for(int i = 0; i < SuPropiedadRaiz.todoMenu.size(); i++){
				if(SuPropiedadRaiz.todoMenu.get(i).getCedula() == usuario.getCedula()){
					SuPropiedadRaiz.todoMenu.get(i).desplegarOpciones();
					break;
				}
			}
		}
		else{
			
		}
	}
	
}
