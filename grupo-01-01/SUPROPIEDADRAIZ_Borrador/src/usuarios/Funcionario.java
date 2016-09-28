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

	public Cliente registrarCliente(long cedula, String nombre){
		Cliente cliente = new Cliente(cedula,nombre);
		clientes.add(cliente);
		return cliente;
	}

	public void asignarRolAlCliente(Cliente cliente, boolean rol){
		cliente.setRol(rol);
	}

	public void registrarInmueble(Cliente propietario){
		Inmueble inmueble = new Inmueble();
		propietario.addPropiedad(inmueble);
	}

	public void asignarRolAlInmueble(Inmueble inmueble, boolean rol){
		inmueble.setRol(rol);
	}
	
	public void registrarCompraVenta(){
		//Este metodo sera definido cuando se tengan las clases contratos
	}
	
	public void registrarArrendamiento(){
		//Este metodo sera definido cuando se tengan las clases contratos
	}
	
	public String buscarCasas(double precioMaximo, String lugar, int estrato,/*Preferencias*/int cuartosMinimos, int banosMinimos, double areaMinima, boolean necesitaGaraje){
		String r = null;
		for ( int i=0; i<funcionariosExistentes.size(); i++){
			for ( int j=0; j<funcionariosExistentes.get(i).clientes.size(); j++ ){
				for ( int k=0; k<funcionariosExistentes.get(i).clientes.get(j).getInmueblesPoseidos().size(); k++){
					Inmueble t  = funcionariosExistentes.get(i).clientes.get(j).getInmueblesPoseidos().get(k);
					/*t es Inmueble del cual estoy consultando las carateristicas*/
					if ( t.getEsCasaOEsApartamento()=="Casa" && t.getPrecioDeVenta()<=precioMaximo && t.getDireccion()==lugar && t.getEstrato()==estrato && t.getNumeroDeCuartos()>=cuartosMinimos && t.getNumeroDeBanos()>=banosMinimos){
						if (necesitaGaraje && t.isGaraje()){
							r = r +"Codigo: "+ t.getCodigo() +", Direccion: "+ t.getDireccion()+", Nombre Unidad: "+ t.getNombreUnidad()+ "\n";
						}else{
							if( necesitaGaraje==false ){
								r = r +"Codigo: "+ t.getCodigo() +", Direccion: "+ t.getDireccion()+", Nombre Unidad: "+ t.getNombreUnidad()+ "\n";
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
				for ( int k=0; k<funcionariosExistentes.get(i).clientes.get(j).getInmueblesPoseidos().size(); k++){
					Inmueble t  = funcionariosExistentes.get(i).clientes.get(j).getInmueblesPoseidos().get(k);
					/*t es Inmueble del cual estoy consultando las carateristicas*/
					if ( t.getEsCasaOEsApartamento()=="Apartamento" && t.getPrecioDeVenta()<=precioMaximo && t.getDireccion()==lugar && t.getEstrato()==estrato && t.getNumeroDeCuartos()>=cuartosMinimos && t.getNumeroDeBanos()>=banosMinimos){
						if (necesitaGaraje && t.isGaraje()){
							r = r +"Codigo: "+ t.getCodigo() +", Direccion: "+ t.getDireccion()+", Nombre Unidad: "+ t.getNombreUnidad()+ "\n";
						}else{
							if( necesitaGaraje==false ){
								r = r +"Codigo: "+ t.getCodigo() +", Direccion: "+ t.getDireccion()+", Nombre Unidad: "+ t.getNombreUnidad()+ "\n";
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
	
	public String getInformacionDeInmueble(long codigo){
		for ( int i=0; i<funcionariosExistentes.size(); i++){
			for ( int j=0; j<funcionariosExistentes.get(i).clientes.size(); j++ ){
				for ( int k=0; k<funcionariosExistentes.get(i).clientes.get(j).getInmueblesPoseidos().size(); k++){
					Inmueble t  = funcionariosExistentes.get(i).clientes.get(j).getInmueblesPoseidos().get(k);
					if (t.getCodigo()==codigo){
						/*Concatenar toda la informacion del inmueble y la unidad. Definir esto en un metodo de la clase inmueble*/
						if ( t.getEsCasaOEsApartamento() == "Apartamento" ){
							/*Concatenar la informacion de la torre del apartamente. Definir esto en un metodo...*/
						}else{
							/*Concatenar informacion de lo cuartos. Definir metodo en clase cuartos...*/
							/*Concatenar la informacion del garaje. Definir metodo en la clase garaje*/
						}
					}
				}
			}
		}
		return null;
	}

	public double generarValorDeComisionPorConceptoDeArriendos(String mes, int year){/*Definir luego para que carajos me piden que ingrese estos parametros en el metodo*/ /*Definir como funciona la evolucion de la comision con respecto al tiempo*/
		double acumulador = 0;
		for (int i=0; i<clientes.size(); i++){
			for (int j=0; j<clientes.get(i).getInmueblesPoseidos().size(); j++){
				Inmueble inmueble = clientes.get(i).getInmueblesPoseidos().get(j);
				if ( inmueble.estaArrendado() ){
					acumulador = acumulador + (inmueble.getValorArriendo()*0.01);
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
