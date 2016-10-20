package suPropiedadRaiz.contratos;
import suPropiedadRaiz.inmuebles.*;
import suPropiedadRaiz.usuarios.*;

public class CompraVenta extends Contrato {

	
	public CompraVenta(long codigo, float tarifa, Inmueble inmueble, Funcionario funcionario, Demandador comprador, Oferente vendedor, int año, int mes){
		super(codigo, tarifa, inmueble, funcionario, comprador, vendedor, año, mes);
	}

	public Demandador getComprador() {
		return super.getDemandador();
	}

	public Oferente getVendedor(){
		return super.getOferente();
	}


}
