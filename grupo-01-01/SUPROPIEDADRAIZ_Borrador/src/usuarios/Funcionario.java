package usuarios;

import java.util.ArrayList;
import inmuebles.*;

public class Funcionario extends Persona{
	
	private ArrayList <Cliente> clientes = new ArrayList <Cliente>();
	private static ArrayList <Funcionario> funcionariosExistentes = new ArrayList <Funcionario>();
	private Object[][] citas = new Object[16][3];
	private double sueldo;
	
	public Funcionario (long cedula, String nombre){
		super(cedula,nombre);
		funcionariosExistentes.add(this);
	}
		
	public static String pedirCita(UsuarioInvitado invitado, String motivoDeLaCita, String AleatorioOAnterior){
		Funcionario funcionario;
		if ( AleatorioOAnterior == "Anterior" ){
			funcionario = buscarElFuncionarioACargoDelCliente( invitado.getCedula() );
		}
		else{
			funcionario = funcionarioAleatorio();
		}
		String r = funcionario.asignarCita(invitado, motivoDeLaCita);
		return r;
	}
	
	private static Funcionario buscarElFuncionarioACargoDelCliente(long cedula){//Este codigo solo tendra sentido si no hay clientes con la misma cedula, si no hay funcionarios a cargo del mismo cliente y si todos los clientes estan asociados a un funcionario (evitar eso de alguna manera)
		int i,j;
		Funcionario funcionario = null;
		for (i=0; i<funcionariosExistentes.size(); i++)
		{
			for (j=0; j<funcionariosExistentes.get(i).clientes.size(); j++)
			{
				if ( funcionariosExistentes.get(i).clientes.get(j).getCedula() == cedula )
				{
					funcionario = funcionariosExistentes.get(i);
				}
			}
		}
		return funcionario;
	}
	
	private static Funcionario funcionarioAleatorio(){
		int i = (int) (Math.round(Math.random()))*funcionariosExistentes.size();
		return funcionariosExistentes.get(i);
	}
	
	String asignarCita(UsuarioInvitado invitado, String motivoDeLaCita){//No hay control para evitar que un mismo usuario pida muchas citas
		String r = null;
		int h = 0;
		String ho;
		for ( int i=0; i<16; i++){
			if ( citas[i][0] == null ){
				citas[i][0] = invitado.getCedula();
				citas[i][1] = invitado.getNombre();
				citas[i][2] = motivoDeLaCita;
				r = "Nombre del funcionario: "+ this.getNombre() +", Hora de la cita: ";
				h = i;
				break;
			}
		}
		
		if (r == null){
			return "No hay citas disponibles";
		}else{
			if (h==0){ho="8:00-8:30";}else{if(h==1){ho="8:30-9:00";}else{if(h==2){ho="9:00-9:30";}else{if(h==3){ho="9:30-10:00";}else{if(h==4){ho="10:00-10:30";}else{if(h==5){ho="10:30-11:00";}else{if(h==6){ho="11:00-11:30";}else{if(h==7){ho="11:30-12:00";}else{if(h==8){ho="2:00-2:30";}else{if(h==9){ho="2:30-3:00";}else{if(h==10){ho="3:00-3:30";}else{if(h==11){ho="3:30-4:00";}else{if(h==12){ho="4:00-4:30";}else{if(h==13){ho="4:30-5:00";}else{if(h==14){ho="5:00-5:30";}else{ho="5:30-6:00";}}}}}}}}}}}}}}}
			return r+ho;
		}
	}
/*  Arreglar esta vuelta, ¿debe la clase cliente ser Abstracta o no?
	public Cliente registrarCliente(long cedula, String nombre){
		Cliente cliente = new Cliente(cedula,nombre);
		clientes.add(cliente);
		return cliente;
	}


   Crear metodo para estructura de clase en donde rol son clases y no un atirbuto
	public void asignarRolAlCliente(Cliente cliente, boolean rol){
		
	}
*/
	public void registrarCasa(Cliente propietario, long codigo, float area, Unidad unidad, short pisos){
		Casa inmueble = new Casa(codigo, area, unidad, pisos);
		propietario.addInmueble(inmueble);
	}
	
	public void registrarApartamento(Cliente propietario, long codigo, float area, Unidad unidad, Torre torre){
		Apartamento inmueble = new Apartamento(codigo, area, unidad, torre);
		propietario.addInmueble(inmueble);
	}
	
	public void registrarCompraVenta(){
		//Este metodo sera definido cuando se tengan las clases contratos
	}
	
	public void registrarArrendamiento(){
		//Este metodo sera definido cuando se tengan las clases contratos
	}
	
	public String buscarCasas(double precioMaximo, String lugar, short estrato,/*Preferencias*/int cuartosMinimos, int banosMinimos, double areaMinima, boolean necesitaGaraje){
		String r = null;
		for ( int i=0; i<funcionariosExistentes.size(); i++){
			for ( int j=0; j<funcionariosExistentes.get(i).clientes.size(); j++ ){
				for ( int k=0; k<funcionariosExistentes.get(i).clientes.get(j).getInmuebles().size(); k++){
					/*t es Inmueble del cual estoy consultando las carateristicas*/
					Inmueble t  = funcionariosExistentes.get(i).clientes.get(j).getInmuebles().get(k);
					String esCasaOApartamento = t.getClass().getName();
					long precioVenta = 0;
					String direccion = t.getDireccion();
					short estrato2 = t.getEstrato();/*estrato2 es el estrato del inmueble, estrato es la especificacion*/
					int cantidadPiezas = t.cuantasPiezas();
					int numeroBaños = t.cuantosBaños();
					
					if ( esCasaOApartamento=="Casa" && precioVenta<=precioMaximo && direccion==lugar && estrato2==estrato && cantidadPiezas>=cuartosMinimos && numeroBaños>=banosMinimos){
						Casa casa = (Casa)t; 
						if (necesitaGaraje && casa.getGaraje()!=null){
							r = r +"Codigo: "+ casa.getCodigo() +", Direccion: "+ casa.getDireccion()+", Nombre Unidad: "+ casa.getUnidad().getNombre()+ "\n";
						}else{
							if( necesitaGaraje==false ){
								r = r +"Codigo: "+ t.getCodigo() +", Direccion: "+ t.getDireccion()+", Nombre Unidad: "+ t.getUnidad().getNombre()+ "\n";
							}
						}
					}
				}
			}
		}
		if (r==null){
			return "No hay casas que coincidan con todas las especificaciones dadas";
		}else{
			return r;
		}
	}
	
	public String buscarApartamentos(double precioMaximo, String lugar, int estrato,/*Preferencias*/int cuartosMinimos, int banosMinimos, double areaMinima, boolean necesitaGaraje){
		String r = null;
		for ( int i=0; i<funcionariosExistentes.size(); i++){
			for ( int j=0; j<funcionariosExistentes.get(i).clientes.size(); j++ ){
				for ( int k=0; k<funcionariosExistentes.get(i).clientes.get(j).getInmuebles().size(); k++){
					Inmueble t  = funcionariosExistentes.get(i).clientes.get(j).getInmuebles().get(k);
					/*t es Inmueble del cual estoy consultando las carateristicas*/
					String esCasaOApartamento = t.getClass().getName();
					long precioVenta = 0;
					String direccion = t.getDireccion();
					short estrato2 = t.getEstrato();/*estrato2 es el estrato del inmueble, estrato es la especificacion*/
					int cantidadPiezas = t.cuantasPiezas();
					int numeroBaños = t.cuantosBaños();
					if ( esCasaOApartamento=="Apartamento" && precioVenta<=precioMaximo && direccion==lugar && estrato2==estrato && cantidadPiezas>=cuartosMinimos && numeroBaños>=banosMinimos){
						r = r +"Codigo: "+ t.getCodigo() +", Direccion: "+ t.getDireccion()+", Nombre Unidad: "+ t.getUnidad().getNombre()+ "\n";
					}
				}
			}
		}
		if (r==null){
			return "No hay apartamentos que coincidan con todas las especificaciones dadas";
		}else{
			return r;
		}
	}
	
	public String getInformacionDeInmueble(long codigo){
		for ( int i=0; i<funcionariosExistentes.size(); i++){
			for ( int j=0; j<funcionariosExistentes.get(i).clientes.size(); j++ ){
				for ( int k=0; k<funcionariosExistentes.get(i).clientes.get(j).getInmuebles().size(); k++){
					Inmueble t  = funcionariosExistentes.get(i).clientes.get(j).getInmuebles().get(k);
					if (t.getCodigo()==codigo){
						/*Concatenar toda la informacion del inmueble y la unidad*/
						String esCasaOApto = t.getClass().getName();
						if ( esCasaOApto == "Apartamento" ){
							/*Concatenar la informacion de la torre del apartamento*/
						}else{
							/*Concatenar informacion de lo cuartos.*/
							/*Concatenar la informacion del garaje.*/
						}
					}
				}
			}
		}
		return null;
	}

	// Redefinir el siguiente metodo de acuerdo a la nueva dinamica de informacion de arriendos
	public double generarValorDeComisionPorConceptoDeArriendos(String mes, int year){//Definir como funciona la evolucion de la comision con respecto al tiempo
		double acumulador = 0;
		for (int i=0; i<clientes.size(); i++){
			for (int j=0; j<clientes.get(i).getInmuebles().size(); j++){
				Inmueble inmueble = clientes.get(i).getInmuebles().get(j);
				long valorArriendo = 0; //Este atributo sera asignado cuando se tengan las clases Contrato 
				if ( inmueble.estaArrendado() ){
					acumulador = acumulador + (valorArriendo*0.01);
				}
			}
		}
		return acumulador;
	}
	
	public double generarValorDeComisionPorVentaDeViviendas(){
		/*Este metodo depende de la estructura de las clases contrato para hacerse*/
		return 0;
	}
	
	public double generarSueldoNeto(String mes){
		return this.sueldo + this.generarValorDeComisionPorConceptoDeArriendos(mes, 2016) + this.generarValorDeComisionPorVentaDeViviendas();
	}
	
	public String generarListaDeClientes(){
		String r = "";
		for (int i=0; i<clientes.size(); i++){
			r = r + "Cedula: " + clientes.get(i).getCedula() + ", Nombre: "+ clientes.get(i).getNombre() +"\n";
		}
		return r;
	}
}
