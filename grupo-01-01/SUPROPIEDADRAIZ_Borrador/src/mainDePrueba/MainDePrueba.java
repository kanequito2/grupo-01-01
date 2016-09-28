package mainDePrueba;

import usuarios.*;
import inmuebles.*;
import java.util.ArrayList;

public class MainDePrueba {
	
	static void print (String r){
		System.out.println(r);
	}
	
	public static void main (String [] Args){
		
		Casa i1 = new Casa();
		i1.setCodigo(1);
		i1.setDireccion("Cll1#2-3");
		i1.setValorArriendo(1000);
		i1.setFechaInicioContrato("Ayer");
		i1.setEsCasaOEsApartamento("Casa");
		Casa i2 = new Casa();
		i2.setCodigo(1);
		i2.setDireccion("Cll1#2-3");
		i2.setValorArriendo(1000);
		i2.setFechaInicioContrato("Ayer");
		i2.setEsCasaOEsApartamento("Casa");
		Casa i3 = new Casa();
		i3.setCodigo(1);
		i3.setDireccion("Cll1#2-3");
		i3.setValorArriendo(1000);
		i3.setFechaInicioContrato("Ayer");
		i3.setEsCasaOEsApartamento("Casa");
		Casa i4 = new Casa();
		i4.setCodigo(1);
		i4.setDireccion("Cll1#2-3");
		i4.setValorArriendo(1000);
		i4.setFechaInicioContrato("Ayer");
		i4.setEsCasaOEsApartamento("Casa");
		Casa i5 = new Casa();
		i5.setCodigo(1);
		i5.setDireccion("Cll1#2-3");
		i5.setValorArriendo(1000);
		i5.setFechaInicioContrato("Ayer");
		i5.setEsCasaOEsApartamento("Casa");
		Casa i6 = new Casa();
		i6.setCodigo(1);
		i6.setDireccion("Cll1#2-3");
		i6.setValorArriendo(1000);
		i6.setFechaInicioContrato("Ayer");
		i6.setEsCasaOEsApartamento("Casa");
		
		FuncionarioJefe fj = new FuncionarioJefe(100, "AAA");
		
		
		Funcionario f1 = fj.addFuncionario(10, "aa");
		
		Cliente c1 = f1.registrarCliente(1, "");
		c1.addPropiedad(i1);
		c1.addPropiedad(i2);
		c1.addPropiedad(i3);
		c1.addPropiedad(i4);
		c1.addPropiedad(i5);
		c1.addPropiedad(i6);
		
		f1.registrarCliente(2, "Jaime");
		f1.registrarCliente(3, "Juan");
		f1.registrarCliente(4, "Luke");
		
		Funcionario f2 = fj.addFuncionario(20, "DD");
		
		
		
		Funcionario f3 = fj.addFuncionario(30, "CC");
		f3.registrarCliente(5, "b");
		
		String r = fj.getFuncionariosAMiCargo();
		print(r);
		r = fj.listaClientesDeMisFuncionarios();
		print (r);
		
		
		
		/*		
		System.out.println(c1.getInmueblesPorLosQueMePaganArriendo());
		System.out.println(c1.getMisInmueblesDisponiblesParaArrendar());
		
		
		ArrayList <UsuarioInvitado> a = new ArrayList <UsuarioInvitado>();
		for (int i=0; i<-1; i++){
			a.add(new UsuarioInvitado(i,"a") );
			System.out.println(a.get(i).getNombre()+a.get(i).getCedula());
		}
		*/
		
	}
}
