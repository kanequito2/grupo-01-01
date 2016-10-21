/*Autor: Mirai.
 * 
 * La clase maneja los contratos tipo arriendo.
 */

package suPropiedadRaiz.contratos;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.empresa.ListaContratos;
import suPropiedadRaiz.inmuebles.*;

public class Arriendo extends Contrato {
	
	private Arrendador arrendador;
	private Arrendatario arrendatario;
	
	public Arriendo(long codigo, float tarifa, Inmueble inmueble,Funcionario funcionario, Arrendatario arrendatario, Arrendador arrendador, int año, int mes){
		super(codigo, tarifa, inmueble, funcionario, arrendatario, arrendador, año, mes);
		this.arrendatario = arrendatario;
		this.arrendador = arrendador;
		ListaContratos.addArriendo(this);
		arrendatario.getArriendo().add(this);
		arrendador.getArriendo().add(this);
	}
	
	//Devuelve el arrendatario.
	public Arrendatario getArrendatario(){
		return this.arrendatario;
	}

	//Devuelve el Arrendador.
	public Arrendador getArrendador(){
		return this.arrendador;
	}
	


}
