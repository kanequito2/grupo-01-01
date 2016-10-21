package suPropiedadRaiz.inmuebles;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.usuarios.*;

public class CasaVenta extends Casa{
	
	private CompraVenta contrato;
	
	public CasaVenta(long codigo, float area, Unidad unidad, short pisos){
		super(codigo, area, unidad, pisos);
	}
	
	public CasaVenta(long codigo, float area, Unidad unidad, short pisos, Garaje garaje){
		super(codigo, area, unidad, pisos, garaje);
	}
	public Persona getVendedor(){
		return this.contrato.getVendedor();
	}
	
	public Persona getComprador(){
		return this.contrato.getComprador();
	}
	
	public float getTarifa(){
		return this.contrato.getTarifa();
	}
	
	public Contrato getContrato(){
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
