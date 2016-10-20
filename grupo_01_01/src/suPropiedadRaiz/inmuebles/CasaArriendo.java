package suPropiedadRaiz.inmuebles;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.contratos.*;

public class CasaArriendo extends Casa{
	
	private Arriendo contrato;
	
	public CasaArriendo(long codigo, float area, Unidad unidad, short pisos){
		super(codigo, area, unidad, pisos);
	}
	
	public Persona getArrendatario(){
		return this.contrato.getArrendatario();
	}
	
	public Persona getDueño(){
		return this.contrato.getDueño();
	}
	
	public void setDueño(Persona dueño){
		this.contrato.setDueño(dueño);
	}
	
	public void setArrendatario(Persona arrendatario){
		this.contrato.setArrendatario(arrendatario);
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
