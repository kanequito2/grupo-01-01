package suPropiedadRaiz.contratos;
import suPropiedadRaiz.usuarios.*;
import suPropiedadRaiz.inmuebles.*;

public class Arriendo extends Contrato {
	
	private Persona arrendatario;
	private Persona dueño;
	
	public Arriendo(long codigo, float tarifa, Inmueble inmueble,Persona funcionario, Persona arrendatario, Persona dueño, int año, String mes){
		super(codigo, tarifa, inmueble, funcionario,año,mes);
		this.arrendatario = arrendatario;
		this.dueño = dueño;
	}
	
	public Persona getArrendatario(){
		return this.arrendatario;
	}
	
	public void setArrendatario(Persona arrendatario){
		this.arrendatario = arrendatario;
	}
	
	public Persona getDueño(){
		return this.dueño;
	}
	
	public void setDueño(Persona dueño){
		this.dueño = dueño;
	}
	
	

}
