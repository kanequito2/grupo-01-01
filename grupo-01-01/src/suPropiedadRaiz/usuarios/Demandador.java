/*
 * Autor: Cristian
 * Clase para Demandador
 */
package suPropiedadRaiz.usuarios;

public abstract class Demandador extends Cliente{

	/* Si bien estos se pide que el cliente tenga estos atributos, no se especifica su uso directo en el guia
	private double presupuesto;
	private String lugarDeInteres;
	private int estratoDeInteres;
	private String rangoDeAreaDeLaCasa;  //Referencias
	private boolean debenTenerTerraza;   //Referencias
	*/
	
	Demandador(long cedula, String nombre){
		super(cedula,nombre);
	}
	
}
