public class Excepciones extends Exception {

	private String codigoError;
	//Constructor vacío
	public Excepciones() {	
	}
	//Constructor con el mensaje a mostrar
	public Excepciones(String codigoError) {
		super();
		this.codigoError = codigoError;
	}

	// Si tenemos diferentes errores.
	public String getMessage() {

		String mensaje = "";
		//dependiendo del código que metamos mostrará un mensaje u otro.
		switch (codigoError) {
		case "peticiones":
			mensaje = "Error,se ha excedido el número máximo de peticiones por vecino, que es de 10.";
			break;
		case "fuerademenu":
			mensaje = "Error, opción del menú incorrecta, debe encontrarse entre el 0 y 8.";
			break;
		}

		return mensaje;

	}

}