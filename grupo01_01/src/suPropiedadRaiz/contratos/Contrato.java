package suPropiedadRaiz.contratos;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.inmuebles.*;

public abstract class Contrato {
	
	private long codigo;
	private float tarifa;
	private Persona funcionario;
	private Inmueble inmueble;
	private final int año;
	private final String mes;
	
	public Contrato(long codigo, float tarifa, Inmueble inmueble, Persona funcionario, int año, String mes){
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.inmueble = inmueble;
		this.funcionario = funcionario;
		this.año = año;
		this.mes = mes;
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	
	public float getTarifa(){
		return this.tarifa;
	}
	
	public void setTarifa(float tarifa){
		this.tarifa = tarifa;
	}
	
	public Persona getFuncionario(){
		return this.funcionario;
	}
	
	public void setFuncionario(Persona funcionario){
		this.funcionario = funcionario;
	}
	
	public Inmueble getInmueble(){
		return this.inmueble;
	}
	
	public void setInmueble(Inmueble inmueble){
		this.inmueble = inmueble;
	}

	
	
	
	
	public int getAño(){
		return this.año;
	}
	
	public String getMes(){
		return this.mes;
	}
	
	
	
	
}
