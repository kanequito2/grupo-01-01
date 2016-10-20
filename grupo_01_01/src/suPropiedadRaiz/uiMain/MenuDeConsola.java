package suPropiedadRaiz.uiMain;
import java.util.*;

public class MenuDeConsola {
	
	ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();
	
	private long cedulaDueño;
	
	public MenuDeConsola(){
		//Crear opciones por defecto
	}
	
	public MenuDeConsola(long cedula){
		this.cedulaDueño = cedula;
		SuPropiedadRaiz.todoMenu.add(this);
	}
	
	public long getCedula(){
		return this.cedulaDueño;
	}
	
	public void agregarOpcion(OpcionDeMenu opcion){
		this.opciones.add(opcion);
	}
	
	public void eliminarOpcion (int i){
		this.opciones.remove(i);
	}

	public void desplegarOpciones(){
		this.agregarOpcion(new Salida());
		System.out.println("Seleccione la opcion que desea ejecutar: ");
		for (int i = 0; i < opciones.size(); i++){
			System.out.println(i + ": " + opciones.get(i).getNombre());
		}
		Scanner input = new Scanner(System.in);
		int seleccion = input.nextInt();
		opciones.get(seleccion).ejecutar();
	}
}
