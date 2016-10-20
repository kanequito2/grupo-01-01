package suPropiedadRaiz.usuarios;

import java.util.ArrayList;
import suPropiedadRaiz.inmuebles.*;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.empresa.*;

public class Funcionario extends Persona{
	
	private ArrayList <Cliente> clientes = new ArrayList <Cliente>();
	private Object[][] citas = new Object[16][3];
	private double sueldo;
	private long codigoContrato = 0;
	
	//Constructor
	public Funcionario (long cedula, String nombre){
		super(cedula,nombre);
		ListaFuncionarios.addFuncionario(this);
	}
		
	public static String pedirCita(long cedula, String nombre, String motivoDeLaCita, String AleatorioOAnterior){
		Funcionario funcionario;
		if ( AleatorioOAnterior == "Anterior" ){
			funcionario = buscarElFuncionarioACargoDelCliente(cedula);
		}
		else{
			funcionario = funcionarioAleatorio();
		}
		String r = funcionario.asignarCita(cedula, nombre, motivoDeLaCita);
		return r;
	}
	
	private static Funcionario buscarElFuncionarioACargoDelCliente(long cedula){//Este codigo solo tendra sentido si las instancias de clientes con la misma cedula pertenecientes a un a misma persona, están asignadas a un mismo funcionario, si no hay varios funcionarios a cargo del mismo cliente y si todos los clientes estan asociados a un funcionario (Estos problemas se evitarán en la implementación del programa)
		int i,j;
		Funcionario funcionario = null;
		ArrayList<Funcionario> listaDeFuncionarios = ListaFuncionarios.getListaFuncionarios(); 
		for (i=0; i<listaDeFuncionarios.size(); i++)
		{
			for (j=0; j<listaDeFuncionarios.get(i).clientes.size(); j++)
			{
				if ( listaDeFuncionarios.get(i).clientes.get(j).getCedula() == cedula )
				{
					funcionario = listaDeFuncionarios.get(i);
				}
			}
		}
		return funcionario;
	}
	
	private static Funcionario funcionarioAleatorio(){
		ArrayList<Funcionario> funcionariosExistentes = ListaFuncionarios.getListaFuncionarios(); 
		int i = (int) (Math.round(Math.random()*funcionariosExistentes.size()));
		return funcionariosExistentes.get(i);
	}
	
	String asignarCita(long cedula, String nombre, String motivoDeLaCita){//No hay control para evitar que un mismo usuario pida muchas citas
		String r = null;
		int h = 0;
		String ho;
		for ( int i=0; i<16; i++){
			if ( citas[i][0] == null ){
				citas[i][0] = cedula;
				citas[i][1] = nombre;
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
    
	public Cliente registrarClienteYAsignarRol(long cedula, String nombre, String rol)//Se asume que los objetos de tipo cliente que pertenezcan a una mismam persona pueden tener la misma cedula, pero para que algunos metodos en otras clases tengan sentido, todos los objetos tipo Persona deben tener el atributo nombre diferente.
	{ 
		Cliente cliente = null;
		if (rol == "Vendedor"){
			cliente = new Vendedor(cedula, nombre);
		}else{
			if (rol == "Arrendatario"){
				cliente = new Arrendatario(cedula, nombre);
			}else{
				if (rol == "Comprador"){
					cliente = new Comprador(cedula, nombre);
				}else{
					if (rol == "Arrendador"){
						cliente = new Arrendador(cedula, nombre);
					}
				}
			}
		}
		ListaClientes.addCliente(cliente);
		return cliente;
	}
	
	//En los siguientes dos métodos No meter Clientes que no sean Oferentes. Meter contratos acordes a lo que voy a crear.
	//Preguntar a Mirai para qué incluir el contrato en el constructor de Un inmueble, me parece que no debería estar en el constructor y debería haber un Set/Get contrato
	public void registrarCasa(Oferente propietario, String ventaOArriendo, long codigo, float area, Unidad unidad, short pisos, Contrato contrato)
	{
		Inmueble casa = null;
		if ( ventaOArriendo == "Venta"){
			casa = new CasaVenta(codigo,area,unidad,pisos,(CompraVenta)contrato);
		}else{
			if ( ventaOArriendo == "Arriendo"){
				casa = new CasaArriendo(codigo, area, unidad, pisos,(Arriendo)contrato);
			}
		}
		propietario.addInmueble(casa);
	}
	
	public void registrarApartamento(Oferente propietario, String ventaOArriendo, long codigo, float area, Unidad unidad, Torre torre, Contrato contrato){
		Inmueble apartamento = null;
		if ( ventaOArriendo == "Venta"){
			apartamento = new ApartamentoVenta(codigo,area,unidad,torre,(CompraVenta)contrato);
		}else{
			if ( ventaOArriendo == "Arriendo"){
				apartamento = new ApartamentoArriendo(codigo, area, unidad, torre,(Arriendo)contrato);
			}
		}
		propietario.addInmueble(apartamento);
	}
	
	public void registrarCompraVenta(Inmueble inmueble, Oferente vendedor, Demandador comprador, int año, String mes){
		comprador.addInmueble(inmueble);
		inmueble.setEstado("Vendido");
		float tarifa = inmueble.getTarifa();
		codigoContrato++;
		CompraVenta contrato = new CompraVenta(codigoContrato,tarifa,inmueble,this,comprador,vendedor,año,mes);
		ListaContratos.addCompraVenta(contrato);
	}
	
	public void registrarArrendamiento(Inmueble inmueble, Oferente arrendador, Demandador arrendatario, int año, String mes){
		arrendatario.addInmueble(inmueble);
		inmueble.setEstado("Arrendado");
		float tarifa = inmueble.getTarifa();
		codigoContrato++;
		Arriendo contrato = new Arriendo(codigoContrato,tarifa,inmueble,this,arrendatario,arrendador,año,mes);
		ListaContratos.addArriendo(contrato);	
	}
	
	public String buscarCasas(float precioMaximo, String lugar, short estratoDeInteres,/*Preferencias*/int cuartosMinimos, int banosMinimos, double areaMinima, boolean necesitaGaraje){
		String r = null;
		
			for ( int i=0; i<ListaClientes.getClientes().size(); i++ ){
				for ( int j=0; j<ListaClientes.getClientes().get(i).getInmuebles().size(); j++){
					
					Inmueble inmueble  = ListaClientes.getClientes().get(i).getInmuebles().get(j);
					
					float precioVenta = inmueble.getTarifa();
					String direccion = inmueble.getDireccion();
					short estratoInmueble = inmueble.getEstrato();
					int cantidadPiezas = inmueble.cuantasPiezas();
					int numeroBaños = inmueble.cuantosBaños();
					
					if ( inmueble instanceof Casa && inmueble.getEstado() != "Vendido" && inmueble.getEstado() != "Arrendado" && precioVenta<=precioMaximo && direccion==lugar && estratoInmueble==estratoDeInteres && cantidadPiezas>=cuartosMinimos && numeroBaños>=banosMinimos){

						Casa casa = (Casa)inmueble; 
						long codigo = casa.getCodigo();
						String nombreUnidad = casa.getUnidad().getNombre();
						
						if (  ( necesitaGaraje && casa.getGaraje()!=null ) || necesitaGaraje==false ){
							r = r +"Codigo: "+ codigo +", Direccion: "+ direccion +", Nombre Unidad: "+ nombreUnidad + "\n";
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
	
	public String buscarApartamentos(float precioMaximo, String lugar, int estrato,/*Preferencias*/int cuartosMinimos, int banosMinimos, double areaMinima, boolean necesitaGaraje){
		String r = null;
		
		for ( int i=0; i<ListaClientes.getClientes().size(); i++ ){
			for ( int j=0; j<ListaClientes.getClientes().get(i).getInmuebles().size(); j++){
				
				Inmueble inmueble  = ListaClientes.getClientes().get(i).getInmuebles().get(j);
				
				float precioVenta = inmueble.getTarifa();
				String direccion = inmueble.getDireccion();
				short estratoInmueble = inmueble.getEstrato();
				int cantidadPiezas = inmueble.cuantasPiezas();
				int numeroBaños = inmueble.cuantosBaños();
				
				if ( inmueble instanceof Apartamento && inmueble.getEstado() != "Vendido" && inmueble.getEstado() != "Arrendado" && precioVenta<=precioMaximo && direccion==lugar && estratoInmueble==estrato && cantidadPiezas>=cuartosMinimos && numeroBaños>=banosMinimos){
					Apartamento apartamento = (Apartamento) inmueble;
					long codigo = apartamento.getCodigo();
					String nombreUnidad = apartamento.getUnidad().getNombre();
					long numeroTorre = apartamento.getTorre().getCodigo();
					r = r +"Codigo: "+codigo +", Direccion: "+direccion+", Nombre Unidad: "+nombreUnidad+", Numero de la torre: "+numeroTorre+"\n";
				}
				
			}
		}
		if (r==null){
			return "No hay apartamentos que coincidan con todas las especificaciones dadas";
		}else{
			return r;
		}
	}
	
	private String getInformacionDelInmueble(long codigo){
		String respuesta = null;
		for ( int i=0; i<ListaClientes.getClientes().size(); i++ ){
			for ( int j=0; j<ListaClientes.getClientes().get(i).getInmuebles().size(); j++){
	
				Inmueble inmueble  = ListaClientes.getClientes().get(i).getInmuebles().get(j);
				
				if ( inmueble.getCodigo() == codigo ){
					
					float areaTotal = inmueble.getAreaTotal();
					boolean isParqueoComunal = inmueble.isParqueoComunal();
					String parqueoComunal;
					if (isParqueoComunal){parqueoComunal = ", Hay parqueo comunal";}else{parqueoComunal = ", No hay parqueo comunal";}
					boolean	isBalcon = inmueble.isBalcon();
					String balcon;
					if (isBalcon){float areaBalcon = inmueble.getAreaBalcon();balcon = ", Hay balcón y su área es: "+areaBalcon;}else{balcon = ", No hay balcon ";}
					boolean isTerraza = inmueble.isTerraza();
					String terraza;
					float areaTerraza = inmueble.getAreaTerraza();
					if (isTerraza){terraza = ", Hay terraza y su área es: "+areaTerraza;}else{terraza = ", No hay terraza";}
					int cuantosCuartos = inmueble.cuantosCuartos();
					int cuantosBaños = inmueble.cuantosBaños();
					int cuantasPiezas = inmueble.cuantasPiezas();
					String direccion = inmueble.getDireccion();
					int estrato = inmueble.getEstrato();
					
					String informacionInmueble = null;
					informacionInmueble = "Area total: "+areaTotal+parqueoComunal+balcon+terraza+", Número de cuartos: "+cuantosCuartos+", Número de baños: "+cuantosBaños+", Número de piezas: "+cuantasPiezas+", Dirección: "+direccion+", Estrato: "+estrato;
					
					Unidad unidad = inmueble.getUnidad();
					String nombreUnidad = unidad.getNombre();
					long codigoUnidad = unidad.getCodigo();
					String direccionUnidad = unidad.getDireccion();
					boolean esCerrada = unidad.isCerrada();
					String cerrada;
					if (esCerrada){cerrada = ", Es cerrada";}else{cerrada = ", No es cerrada";}
					
					String informacionUnidad;
				    informacionUnidad = "Nombre: "+nombreUnidad+", Código: "+codigoUnidad+cerrada+", Direccion: "+direccionUnidad;
					
					boolean esCasa = inmueble instanceof Casa;
					boolean esApartamento = inmueble instanceof Apartamento;
					
					 respuesta = "Informacion del inmueble: "+"\n"+informacionInmueble+"\n"+ "Informaciónde la unidad: "+informacionUnidad;

					if (esApartamento){
						Apartamento apartamento = (Apartamento) inmueble;
						Torre torre = apartamento.getTorre();
						String informacionDeLaTorre;
						long codigoTorre = torre.getCodigo();
						String	ascensor;
						if (torre.isAscensor()){ascensor = ", Tiene ascensor";}else{ascensor = ", No tiene ascensor";}
						informacionDeLaTorre = "Código: "+codigoTorre+ascensor;
						
						respuesta = respuesta+"\n"+informacionDeLaTorre;
						
					}
					if(esCasa){
						Casa casa = (Casa) inmueble;
						Garaje garaje = casa.getGaraje();
						long codigoGaraje = garaje.getCodigo();
						String puertaElectrica;
						if (garaje.isPuertaElectrica()){puertaElectrica = ", Tiene puerta eléctrica";}else{puertaElectrica = ", No tiene puerta eléctrica";}
						float alturaGaraje = garaje.getAltura();
						float areaGaraje = garaje.getArea();
						String informacionGaraje = "Código: "+codigoGaraje+puertaElectrica+", Altura: "+alturaGaraje+". Área: "+areaGaraje;

						ArrayList<Cuarto> cuartos = casa.getCuartos();
						String informacionCuartos = "Cuartos: \n";
						for (int k=0; k<cuartos.size(); k++){
							Cuarto cuarto = cuartos.get(k);
							long codigoCuarto = cuarto.getCodigo();
							float areaCuarto = cuarto.getArea();
							String usoCuarto = cuarto.getUso();
							String informacionCuarto ="Código: "+codigoCuarto+", Área: "+areaCuarto+", Uso: "+usoCuarto;
							informacionCuartos = informacionCuartos+"\n"+informacionCuarto;
						}
						
						respuesta = respuesta + "\n" + "Información de garaje: " + informacionGaraje + "\n" + "Información de todos los cuartos: " + "\n" + informacionCuartos;
						
					}
				}
			}
		}
		if ( respuesta == null){return "Algo salió mal";}else{return respuesta;}
	}
	
	public String getInformacionDeCasaArriendo(long codigo){
		String casa = this.getInformacionDelInmueble(codigo);
		return casa;
	}
	
	public String getInformacionDeCasaVenta(long codigo){
		String casa = this.getInformacionDelInmueble(codigo);
		return casa;
	}
	
	public String getInformacionDeApartamentoArriendo(long codigo){
		String casa = this.getInformacionDelInmueble(codigo);
		return casa;
	}
	
	public String getInformacionDeApartamentoVenta(long codigo){
		String casa = this.getInformacionDelInmueble(codigo);
		return casa;
	}
	
	//Definir para los dos siguientes metodos como funciona la evolucion de la comision con respecto al tiempo. 
	public double generarValorDeComisionPorConceptoDeArriendos(String mes, int año){//Definir como guardar la fecha en la que se hizo un arrendamiento en los contratos/inmuebles
		double acumulador = 0;
		for (int i=0; i<clientes.size(); i++){
			if (clientes.get(i) instanceof Arrendador){
				Arrendador arrendador = (Arrendador) clientes.get(i);
				for (int j=0; j<arrendador.getInmuebles().size(); j++){
				Inmueble inmueble = arrendador.getInmuebles().get(j);
					if ( inmueble.getEstado() == "Arrendado" && inmueble.getContrato().getAño()==año && inmueble.getContrato().getMes()==mes){
						float valorArriendo = ((Inmueble)inmueble).getTarifa();
						acumulador = acumulador + (valorArriendo*0.01);
					}
				}
			}
		}
		return acumulador;
	}
	
	public double generarValorDeComisionPorVentaDeViviendas(String mes, int año){
		double acumulador = 0;
		for (int i=0; i<clientes.size(); i++){
			if (clientes.get(i) instanceof Vendedor){
				Vendedor vendedor = (Vendedor) clientes.get(i);
				for (int j=0; j<vendedor.getInmuebles().size(); j++){
					Inmueble inmueble = vendedor.getInmuebles().get(j);
					if ( inmueble.getEstado() == "Vendido" && inmueble.getContrato().getAño()==año && inmueble.getContrato().getMes()==mes){
						float valorVenta = inmueble.getTarifa();
						acumulador = acumulador + (valorVenta*0.01);
					}
				}
			}
		}
		return acumulador;
	}
	
	public double generarSueldoNeto(String mes){
		return this.sueldo + this.generarValorDeComisionPorConceptoDeArriendos(mes, 2016) + this.generarValorDeComisionPorVentaDeViviendas(mes,2016);
	}
	
	public String generarListaDeClientes(){
		String r = "";
		for (int i=0; i<clientes.size(); i++){
			r = r + "Cedula: " + clientes.get(i).getCedula() + ", Nombre: "+ clientes.get(i).getNombre() +"\n";
		}
		return r;
	}
}
