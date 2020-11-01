import java.io.*;
import java.util.*;
import java.util.Locale;

public class LecturaVecinos {
	/**
	 * Metodo para leer los clientes de un fichero
	 * 
	 * @param cadena ruta del fichero
	 * @return matriz de clientes leidos
	 * @throws IOException
	 */
	public void leerVecinos(String cadena, Comunidad c) throws IOException {
		Vecino v;
		File fichero = new File(cadena);
		Scanner LECTURA = new Scanner(fichero);
		LECTURA.useLocale(Locale.US);// Para la lectura de los puntos en el fichero
		while (LECTURA.hasNext()) {
			String tipo = LECTURA.next();
			//Dividimos los datos del fichero por variables dependiendo de si son prop. o inqu.
			if (tipo.equals("p")) {
				String nombre = LECTURA.next();
				String dni = LECTURA.next();
				String piso = LECTURA.next();
				int ano = LECTURA.nextInt();
				v = new Propietario(nombre, dni, piso, ano);
				c.addVecino(v);
			} else {
				String nombre = LECTURA.next();
				String dni = LECTURA.next();
				String piso = LECTURA.next();
				double mensualidad = LECTURA.nextDouble();
				v = new Inquilino(nombre, dni, piso, mensualidad);
				c.addVecino(v);
			}
		}
		LECTURA.close();

	}

}