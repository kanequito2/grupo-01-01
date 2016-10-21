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

	public Demandador getComprador() {
		return super.getDemandador();
	}

	public Oferente getVendedor(){
		return super.getOferente();
	}


}
