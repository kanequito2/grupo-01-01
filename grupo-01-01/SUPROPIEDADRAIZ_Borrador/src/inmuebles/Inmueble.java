package inmuebles;
import java.util.ArrayList;

public class Inmueble {
	
	private long codigo;
	private double areaTotal;
	private String direccion;
	private int estrato;
	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}


	private boolean estaArrendado;
	private double valorArriendo;
	private String fechaInicioContrato;
	private String esCasaOEsApartamento;
	private boolean rol;
	private double precioDeVenta;
	ArrayList <Object> cuartos = new ArrayList <Object>();
	public String getNombreUnidad(){return "Unidad";}
	public int getNumeroDeCuartos(){
		return 1;
	}
	public boolean isGaraje(){
		return true;
	}
	public int getNumeroDeBanos(){
		return 1;
	}
	
	public double getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public String getEsCasaOEsApartamento() {
		return esCasaOEsApartamento;
	}
	
	public void setEsCasaOEsApartamento(String esCasaOEsApartamento) {
		this.esCasaOEsApartamento = esCasaOEsApartamento;
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public void setRol(boolean rol) {
		this.rol = rol;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public double getValorArriendo() {
		return valorArriendo;
	}


	public void setValorArriendo(double valorArriendo) {
		this.valorArriendo = valorArriendo;
	}


	public String getFechaInicioContrato() {
		return fechaInicioContrato;
	}


	public void setFechaInicioContrato(String fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}


	public boolean estaArrendado(){
		return true;
	}
	
}
