package suPropiedadRaiz.inmuebles;

public class Baño extends Cuarto{
	
	private boolean bañera;
	private boolean ducha;
	private boolean enchapado;
	private boolean puertaDucha;
	
	public Baño(long codigo, float area){
		super(codigo, area);
		super.setUso("Baño");
	}
	
	public Baño(long codigo, float area, boolean bañera, boolean ducha, boolean enchapado, boolean puerta){
		this(codigo, area);
		this.bañera = bañera;
		this.ducha = ducha;
		this.enchapado = enchapado;
		this.puertaDucha = puerta;
		super.setUso("Baño");
	}

	public boolean isBañera() {
		return bañera;
	}

	public void setBañera(boolean bañera) {
		this.bañera = bañera;
	}

	public boolean isDucha() {
		return ducha;
	}

	public void setDucha(boolean ducha) {
		this.ducha = ducha;
	}

	public boolean isEnchapado() {
		return enchapado;
	}

	public void setEnchapado(boolean enchapado) {
		this.enchapado = enchapado;
	}

	public boolean isPuertaDucha() {
		return puertaDucha;
	}

	public void setPuertaDucha(boolean puertaDucha) {
		this.puertaDucha = puertaDucha;
	}
	
	

}
