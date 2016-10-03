package usuarios;

public class UsuarioInvitado extends Persona{
	
	public UsuarioInvitado(long cedula, String nombre){
		super(cedula, nombre);
	}
	
	//Si Jaime me dijo que esta clase es para que la gente haga un log-in
	//Y el documento dice que es para los que no están registrados, y para hacer un login hay que estar registrado,
	//¿qué es exactamente lo que me quieren decir sobre esta clase en el documento?
	
	//Según lo que entiendo no tiene sentido que alguien distinto a un cliente pida una cita, si esta clase es para log-in, teoricamente cualquiera podría pedir cita
	//Entonces, ¿quiénes son los que piden la cita? 
	
	/* Recordar que el Array que usa el metodo yaHaSidoCliente atenta contra la POO.
	public String solicitarCita (String motivoDeLaCita){
		String funcionario;
		if ( Cliente.yaHaSidoCliente( super.getCedula() ) ) //Ya había sido cliente//
		{
			funcionario = "Anterior";
																			
		}else  //Nunca había sido cliente//
		{ 
			funcionario = "Aleatorio";
		}
		String r = Funcionario.pedirCita(this,motivoDeLaCita,funcionario);
		return r;
	}
	*/
	public void login(){
		
	}
	
}
