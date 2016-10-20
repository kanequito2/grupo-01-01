package suPropiedadRaiz.usuarios;

public abstract class Persona {
	
	private long cedula;
	private String nombre;
	
	public Persona (long cedula, String nombre){
		this.cedula = cedula;
		this.nombre = nombre;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
