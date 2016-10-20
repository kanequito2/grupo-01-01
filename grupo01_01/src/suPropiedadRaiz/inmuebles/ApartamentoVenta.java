package suPropiedadRaiz.inmuebles;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.contratos.*;

public class ApartamentoVenta extends Apartamento{
	
	private CompraVenta contrato;
	
	public ApartamentoVenta(long codigo, float area, Unidad unidad, Torre torre, CompraVenta contrato){
		super(codigo, area, unidad, torre);
		this.contrato = contrato;
	}
	
	public Persona getVendedor(){
		return this.contrato.getVendedor();
	}
	
	public Persona getComprador(){
		return this.contrato.getVendedor();
	}
	
	public float getTarifa(){
		return this.contrato.getTarifa();
	}
	
	public void setVendedor(Persona vendedor){
		this.contrato.setVendedor(vendedor);
	}
	
	public void setComprador(Persona comprador){
		this.contrato.setComprador(comprador);
	}
	
	public CompraVenta getContrato(){
		return this.contrato;
	}
	
	public void setContrato(CompraVenta contrato){
		this.contrato = contrato;
	}
	
	public void setTarifa(float tarifa){
		this.contrato.setTarifa(tarifa);
	}
	
	public void setFuncionario(Persona funcionario){
		this.contrato.setFuncionario(funcionario);
	}
	
	public Persona getFuncionario(){
		return this.contrato.getFuncionario();
	}

}
