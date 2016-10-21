/*Autor: Mirai
 * La clase implementa los contratos para CompraVenta.
 */
package suPropiedadRaiz.contratos;
import suPropiedadRaiz.empresa.ListaContratos;
import suPropiedadRaiz.inmuebles.*;
import suPropiedadRaiz.usuarios.*;

public class CompraVenta extends Contrato {

	
	public CompraVenta(long codigo, float tarifa, Inmueble inmueble, Funcionario funcionario, Demandador comprador, Oferente vendedor, int año, int mes){
		super(codigo, tarifa, inmueble, funcionario, comprador, vendedor, año, mes);
		ListaContratos.addCompraVenta(this);
		comprador.getCompraVenta().add(this);
		vendedor.getCompraVenta().add(this);
	}

	//Devuelve el comprador.
	public Demandador getComprador() {
		return super.getDemandador();
	}

	//Devuelve el vendedor.
	public Oferente getVendedor(){
		return super.getOferente();
	}


}
