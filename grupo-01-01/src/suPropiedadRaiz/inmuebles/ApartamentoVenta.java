/*
 * Autor: Mirai
 * Apartamentos para Venta
 */
package suPropiedadRaiz.inmuebles;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.contratos.*;

public class ApartamentoVenta extends Apartamento{
	
	private CompraVenta contrato;
	
	public ApartamentoVenta(long codigo, float area, Unidad unidad, Torre torre){
		super(codigo, area, unidad, torre);
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
