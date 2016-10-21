/*
 * Autor: Mirai
 * Imprime todas las opciones existentes. Administrador de Sistema.
 */
package suPropiedadRaiz.uiMain;
import java.util.ArrayList;
import java.util.Scanner;

public class TodasOpciones extends OpcionDeMenu{
	
	public TodasOpciones(){
		super.setNombre("Mostrar todas la opciones de menu");
	}
	
	public void ejecutar(){
		Scanner in = new Scanner(System.in);
		ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu>();
		opciones.add(new BuscarApartamentoArriendo());
		opciones.add(new BuscarApartamentoVenta());
		opciones.add(new BuscarCasaArriendo());
		opciones.add(new BuscarCasaVenta());
		opciones.add(new BusquedaViviendaDemandador());
		opciones.add(new ClientesDeMisFuncionarios());
		opciones.add(new EliminarOpcion());
		opciones.add(new GenerarClientes());
		opciones.add(new GenerarComisionArriendos());
		opciones.add(new GenerarComisionVentas());
		opciones.add(new GenerarSalario());
		opciones.add(new LogIn());
		opciones.add(new MiListaDeFuncionarios());
		opciones.add(new MostrarTodasOpciones());
		opciones.add(new PedirCitaInvitado());
		opciones.add(new RegistrarArriendo());
		opciones.add(new RegistrarClienteRol());
		opciones.add(new RegistrarCompraVenta());
		opciones.add(new RegistrarInmueble());
		opciones.add(new Salida());
		opciones.add(new ViviendasParaArrendar());
		opciones.add(new ViviendasParaVenta());
		for(int i = 0; i < opciones.size(); i++){
			System.out.println(i + ": " + opciones.get(i).getNombre());
		}
		System.out.println("Pulse cualquier tecla para continuar");
		in.next();
	}

}
