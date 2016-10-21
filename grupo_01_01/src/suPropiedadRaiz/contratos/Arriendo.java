package suPropiedadRaiz.contratos;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.empresa.ListaContratos;
import suPropiedadRaiz.inmuebles.*;

public class Arriendo extends Contrato {
	
	private Arrendador arrendador;
	private Arrendatario arrendatario;
	
	public Arriendo(long codigo, float tarifa, Inmueble inmueble,Funcionario funcionario, Arrendatario arrendatario, Arrendador arrendador, int a�o, int mes){
		super(codigo, tarifa, inmueble, funcionario, arrendatario, arrendador, a�o, mes);
		this.arrendatario = arrendatario;
		this.arrendador = arrendador;
		ListaContratos.addArriendo(this);
		arrendatario.getArriendo().add(this);
		arrendador.getArriendo().add(this);
	}
	
	public Arrendatario getArrendatario(){
		return this.arrendatario;
	}

	
	public Arrendador getArrendador(){
		return this.arrendador;
	}
	


}
