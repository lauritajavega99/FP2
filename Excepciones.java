public class Excepciones extends Exception {

	private String codigoError;
	//Constructor vac�o
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
		//dependiendo del c�digo que metamos mostrar� un mensaje u otro.
		switch (codigoError) {
		case "peticiones":
			mensaje = "Error,se ha excedido el n�mero m�ximo de peticiones por vecino, que es de 10.";
			break;
		case "fuerademenu":
			mensaje = "Error, opci�n del men� incorrecta, debe encontrarse entre el 0 y 8.";
			break;
		}

		return mensaje;

	}

}