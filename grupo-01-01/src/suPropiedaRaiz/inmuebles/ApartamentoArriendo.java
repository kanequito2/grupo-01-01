/*
 * Autor: Mirai
 * Apartamentos para Arriendo.
 */
package suPropiedadRaiz.inmuebles;
import suPropiedadRaiz.contratos.*;
import suPropiedadRaiz.usuarios.*;

public class ApartamentoArriendo extends Apartamento{
	
	private Arriendo contrato;
	
	public ApartamentoArriendo(long codigo, float area, Unidad unidad, Torre torre){
		super(codigo, area, unidad, torre);
	}
	
	public Persona getArrendatario(){
		return this.contrato.getArrendatario();
	}
	
	public Persona getArrendador(){
		return this.contrato.getArrendador();
	}
	

	public Contrato getContrato(){
		return this.contrato;
	}
	
	public void setContrato(Arriendo contrato){
		this.contrato = contrato;
	}
	
	public float getTarifa(){
		return this.contrato.getTarifa();
	}
	
	public void setTarifa(float tarifa){
		this.contrato.setTarifa(tarifa);
	}
	
	public Persona getFuncionario(){
		return this.contrato.getFuncionario();
	}
	
	public void setFuncionario(Persona funcionario){
		
	}

}
