package suPropiedadRaiz.contratos;
import suPropiedadRaiz.inmuebles.*;
import suPropiedadRaiz.usuarios.*;

public class CompraVenta extends Contrato {
	
	private Persona comprador;
	private Persona vendedor;
	
	public CompraVenta(long codigo, float tarifa, Inmueble inmueble, Persona funcionario, Persona comprador, Persona vendedor){
		super(codigo, tarifa, inmueble, funcionario);
		this.comprador = comprador;
		this.vendedor = vendedor;
	}

	public Persona getComprador() {
		return comprador;
	}

	public void setComprador(Persona comprador) {
		this.comprador = comprador;
	}

	public Persona getVendedor() {
		return vendedor;
	}

	public void setVendedor(Persona vendedor) {
		this.vendedor = vendedor;
	}
	

}
