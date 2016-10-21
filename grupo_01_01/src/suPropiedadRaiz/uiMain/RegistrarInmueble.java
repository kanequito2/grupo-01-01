package suPropiedadRaiz.uiMain;
import java.util.Scanner; import java.util.ArrayList;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.empresa.*;
import suPropiedadRaiz.inmuebles.*;

public class RegistrarInmueble extends OpcionDeMenu {
	
	public RegistrarInmueble(){
		super.setNombre("Registrar un inmueble.");
	}
	
	public void ejecutar(){
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese su cédula.");
		long cedula = input.nextLong();
		Funcionario funcionario = ListaFuncionarios.getFuncionario(cedula);
		System.out.println("Presione 'c' para casa o 'a' para apartamento");
		String tipo = input.next();
		System.out.println("Esciba la cédula del cliente a quien pertenezca este inmueble.");
		long cedulaDueño = input.nextLong();
		System.out.println("Ingrese el código de la unidad");
		long codigoUnidad = input.nextLong();
		System.out.println("Ingrese el area del balcón ('0' cero si no tiene");
		float areaB = input.nextFloat();
		System.out.println("Ingrese el area de la terraza ('0' cero si no tiene)");
		float areaT = input.nextFloat();
		
		long codigoCuartos = 0;
		float areaTotal = 0;
		System.out.println("Ingrese 'p' para una pieza, 'b' para un baño");
		String comandoCuarto = input.next();
		float areaCuartos = 0;
		
		ArrayList<Cuarto> cuartos = new ArrayList<Cuarto>();
		
		while (true){
			if (comandoCuarto == "p"){
				System.out.println("Ingrese el uso de la pieza");
				comandoCuarto = input.next();
				System.out.println("Ingrese el área");
				areaCuartos = input.nextLong();
				cuartos.add(new Pieza(++codigoCuartos, areaCuartos, comandoCuarto));
				areaTotal = areaTotal + areaCuartos;
			}
			if(comandoCuarto == "b"){
				System.out.println("Ingrese el area del baño");
				areaCuartos = input.nextFloat();
				System.out.println("Ingrese 'y' si SI e ingrese 'n' si NO");
				System.out.println("Tiene bañera?");
				comandoCuarto = input.next();
				boolean bañera = true;
				if(comandoCuarto == "n"){
					bañera = false;
				}
				System.out.println("Tiene ducha?");
				comandoCuarto = input.next();
				boolean ducha = true;
				if(comandoCuarto == "n"){
					ducha = false;
				}
				System.out.println("Tiene enchapado?");
				comandoCuarto = input.next();
				boolean enchapado = true;
				if(comandoCuarto =="n"){
					enchapado = false;
				}
				System.out.println("Tiene puerta de Ducha?");
				comandoCuarto = input.next();
				boolean puerta = true;
				if(comandoCuarto == "n"){
					puerta = false;
				}
				cuartos.add(new Baño(++codigoCuartos, areaCuartos, bañera, ducha, enchapado, puerta));
				areaTotal = areaTotal + areaCuartos;
			}
				System.out.println("Otro Cuarto? (y/n)");
				comandoCuarto = input.next();
				if (comandoCuarto == "y"){
					System.out.println("Ingrese 'p' para una pieza, 'b' para un baño");
					comandoCuarto = input.next();
				}
				else{
					break;
				}
		}
		
		System.out.println("Tiene zona de parque comunal? (y/n)");
		String comand = input.next();
		boolean parqueo = true;
		if(comand == "n"){
			parqueo = false;
		}
		System.out.println("Es para compra/venta (c) o arriendo (a)?");
		String ventaArriendo = input.next();
		
		if(tipo == "c"){
			System.out.println("Tiene garaje? (y/n)");
			comand = input.next();
			boolean garaje = true;
			if(comand == "n"){
				garaje = false;
			}
			Garaje g = null;
			if (garaje){
				System.out.println("Cual es el area del garaje?");
				float areaGaraje = input.nextFloat();
				System.out.println("CUal es la altura del garaje?");
				float alturaGaraje = input.nextFloat();
				System.out.println("Tiene puerta electrica? (y/n");
				boolean puertaGaraje = true;
				comand = input.next();
				if(comand =="n"){
					puertaGaraje = false;
				}
				g = new Garaje(Garaje.codigoGarajes++, areaGaraje, alturaGaraje, puertaGaraje);
			}
			System.out.println("Cuantos pisos tiene?");
			short pisos = input.nextShort();
			if(ventaArriendo == "c"){
				CasaVenta casaV = new CasaVenta(Inmueble.getCodigosInmuebles(), areaTotal, ListaUnidades.getUnidad(codigoUnidad), pisos, g);
				ListaClientes.getCliente(cedulaDueño).addInmueble(casaV);
			}
			else{
				CasaArriendo casaA = new CasaArriendo(Inmueble.getCodigosInmuebles(), areaTotal, ListaUnidades.getUnidad(codigoUnidad), pisos, g);
				ListaClientes.getCliente(cedulaDueño).addInmueble(casaA);
			}
		}
		else{
			System.out.println("Ingrese el codigo de la torre");
			long codigoTorre = input.nextLong();
			System.out.println("Ingrese el piso en la torre");
			short pisoTorre = input.nextShort();
			Torre torre = ListaTorres.getTorre(codigoTorre);
			if(ventaArriendo == "c"){
				ApartamentoVenta apV = new ApartamentoVenta(Inmueble.getCodigosInmuebles(),areaTotal, ListaUnidades.getUnidad(codigoUnidad), torre);
				ListaClientes.getCliente(cedulaDueño).addInmueble(apV);
				torre.addApartamento(apV, pisoTorre);
			}
			else{
				ApartamentoArriendo apA = new ApartamentoArriendo(Inmueble.getCodigosInmuebles(), areaTotal, ListaUnidades.getUnidad(codigoUnidad), torre);
				ListaClientes.getCliente(cedulaDueño).addInmueble(apA);
				torre.addApartamento(apA, pisoTorre);
			}
		}
		System.out.println("Se ha registrado un inmueble");
		System.out.println("Presione cualquier tecla para continuar");
		input.next();
	}

}
