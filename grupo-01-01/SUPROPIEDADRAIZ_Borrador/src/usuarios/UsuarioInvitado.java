package usuarios;

public class UsuarioInvitado extends Persona{
	
	public UsuarioInvitado(long cedula, String nombre){
		super(cedula, nombre);
	}
	
	public String solicitarCita (String motivoDeLaCita){
		String funcionario;
		if ( Cliente.yaHaSidoCliente( super.getCedula() ) ) /*Ya había sido cliente*/
		{
			funcionario = "Anterior";
																			
		}else  /*Nunca había sido cliente*/
		{ 
			funcionario = "Aleatorio";
		}
		String r = Funcionario.pedirCita(this,motivoDeLaCita,funcionario);
		return r;
	}
	
}
