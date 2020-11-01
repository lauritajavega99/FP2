import java.io.IOException;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		boolean salir = false;
		LecturaVecinos l = new LecturaVecinos();
		Comunidad c = new Comunidad(6, 15);
		EmpresaMantenimiento e = new EmpresaMantenimiento("LauGui", "Calle Libertad 6", 243);
		// Usuario introduce la ruta del fichero, si no lo encuentra se lo vuelve a
		// pedir de nuevo hasta que lo encuentre.
		do {
			//Captura de la excepción de si no existe el fichero
			try {
				System.out.println("Introduzca la ruta donde se encuentre el fichero.");
				String ruta = pedirRuta();
				l.leerVecinos(ruta, c);
				menu(c, e);
				salir = true;
			} catch (IOException e1) {
				System.out.println("El archivo no se encuentra, inténtelo de nuevo.");
			}
		} while (!salir);

	}

	// Metodo que nos pide el DNI del vecino que queremos
	public static String pedirVecino() {
		Scanner LECTURA = new Scanner(System.in);
		String dni_vecino = LECTURA.next();
		return dni_vecino;
	}
	//Método que pide la ruta donde se encuentra el fichero
	public static String pedirRuta() {
		Scanner sc = new Scanner(System.in);
		String ruta = sc.nextLine();
		return ruta;
	}

	// Método que nos devuelve el menú del programa con sus operaciones
	public static void menu(Comunidad c, EmpresaMantenimiento em) {
		Scanner sc = new Scanner(System.in);
		boolean seguir;
		boolean siguiente = false;
		int opcion = 1;
		Peticion[] peticiones_urgentes;
		while (opcion != 0) {
			System.out.println(
					"\n*******¡Bienvenid@ al menú principal de la comunidad de Vecinos. Por favor, elija una opción: *******");
			System.out.println("[1] Consultar la información de todos los vecinos de la comunidad.");
			System.out.println("[2] Realizar una petición de mejora.");
			System.out
					.println("[3] Consultar el número de peticiones de mejora que ha realizado un determinado vecino.");
			System.out.println(
					"[4] Consultar la información de las peticiones urgentes que ha realizado un determinado vecino.");
			System.out.println("[5] Consultar la suma de impuestos anuales de la comunidad.");
			System.out.println("[6] Mostrar los impuestos que tiene que pagar un determinado cliente.");
			System.out.println("[7] Mostrar lo que tiene que pagar anualmente por mantenimiento la comunidad.\n");
			System.out.println("[0] Salir.\n");
			do {
				//Captura de la excepción de fuera del rango de opciones del menú
				try {
					opcion = sc.nextInt();
					seguir = numeroRango(0, 7, opcion);
					if (!seguir) {
						throw new Excepciones("fuerademenu");
					} else {
						switch (opcion) {
						case 0:
							System.out.println("¡Vuelva pronto!");
							break;
						case 1:
							consultarVecinos(c);
							break;
						case 2:
							realizarPeticionMejora(c);
							break;
						case 3:
							consultarNumPeticiones(c);
							break;
						case 4:
							consultarPeticiones(c);
							break;
						case 5:
							consultarImpuestoAnual(c);
							break;
						case 6:
							consultarImpuestoCliente(c);
							break;
						case 7:
							consultarCosteMantenimiento(c, em);
							break;
						}// switch
					}
					siguiente = true;
					//Captura de la excepción no numérica
				} catch (InputMismatchException e) {
					System.out
							.println("La opción debe de tener un valor numérico." + " Introduzca la opción de nuevo.");
					sc.next();

				} catch (Excepciones e1) {
					System.out.println(e1.getMessage());
					System.out.println("Vuelva a introducir la opción");
				}
			} while (!siguiente);
		} // while
	}// menu

	/// Métodos del menú

	// Muestra la información de todos los vecinos existentes
	public static void consultarVecinos(Comunidad c) {
		int n = c.getNum_vecinos(); // Determinamos el número de vecinos del array
		for (int i = 0; i < n; i++) {// Recorremos los vecinos y mostramos información
			String a = c.mostrarInfoVecinos(i);
			System.out.println(a);
		}
	}

	// C:\\Users\\Laura\\Desktop\\Practica prog2\\Vecinos.txt
	// Realizar una peticion de mejora de un determinado vecino
	public static void realizarPeticionMejora(Comunidad c) {
		Scanner sc = new Scanner(System.in);
		boolean vecino_correcto;
		boolean urgencia_ok = false;
		int urgencia = -1;
		String dni_vecino = "";
		boolean dni_correcto;
		System.out.print("Introduzca el DNI del vecino que va a realizar una petición de mejora: ");
		dni_vecino = pedirVecino();
		dni_correcto = comprobarDNI(dni_vecino);// Comprobamos si el DNI cumple los requisitos
		while (!dni_correcto) {
			System.out.println("Introduzca de nuevo el DNI");
			dni_vecino = pedirVecino();
			dni_correcto = comprobarDNI(dni_vecino);// Comprobamos si el DNI cumple los requisitos
		}
		if (!dni_vecino.equalsIgnoreCase("") && dni_correcto) {
			vecino_correcto = c.comprobarVecino(dni_vecino);
			if (vecino_correcto) {
				Vecino v = c.buscarVecino(dni_vecino);
				if (v != null) {
					try {
						//Captura excepción de más de 10 peticiones por vecino
						if (v.getNum_peticiones() > 10) {
							throw new Excepciones("peticiones");
						} else {
							System.out.println("Vecino perteneciente a la base de datos.");
							do {
								//Captura excepción no numérica
								try {
									System.out.print("Introduce la urgencia de la petición: ");
									urgencia = sc.nextInt();
									if (urgencia != 1 && urgencia != 2 && urgencia != 0) {
										throw new InputMismatchException();
									} else {
										urgencia_ok = true;
									}
								} catch (InputMismatchException e) {
									System.out.println("La urgencia no es válida (0, 1 o 2)");
									sc.nextLine();
								}
							} while (!urgencia_ok);
							sc = new Scanner(System.in);
							System.out.print("Introduce la descripción de la petición: ");
							String descripcion = sc.nextLine();
							Peticion p = new Peticion(urgencia, descripcion);
							v.addPeticion(p);// Añadimos petición al array de peticiones del determinado vecino
							System.out.println("Petición realizada.");

						}
					} catch (Excepciones e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("El vecino no existe.");
				}
			}
		}
	}

	// Nos muestra el número de peticiones que ha realizado un determinado vecino
	public static void consultarNumPeticiones(Comunidad c) {
		boolean vecino_correcto;
		String dni_vecino = "";
		boolean dni_correcto;
		System.out.print("Introduce el DNI del vecino que quieres consultar el número de peticiones de mejora: ");
		dni_vecino = pedirVecino();
		dni_correcto = comprobarDNI(dni_vecino);
		while (!dni_correcto) {// Vuelve a pedirlo si el DNI no cumple los requisitos.
			System.out.println("Introduzca de nuevo el DNI");
			dni_vecino = pedirVecino();
			dni_correcto = comprobarDNI(dni_vecino);// Comprobamos si el DNI cumple los requisitos
		}
		if (!dni_vecino.equalsIgnoreCase("") && dni_correcto) {
			vecino_correcto = c.comprobarVecino(dni_vecino);
			if (vecino_correcto) {
				Vecino v = c.buscarVecino(dni_vecino);
				if (v != null) {
					System.out.println("El número de peticiones de mejora del vecino " + dni_vecino + " son de: "
							+ v.getNum_peticiones());
				}
			} else {
				System.out.println("El vecino no existe.");
			}
		}
	}

	// Muestra la información de las peticiones que ha realizado un determinado
	// vecino
	public static void consultarPeticiones(Comunidad c) {
		Peticion[] peticiones_urgentes;
		boolean vecino_correcto;
		String dni_vecino = "";
		boolean dni_correcto;
		System.out.print("Introduce el DNI del vecino que quieres consultar las peticiones urgentes de mejora: ");
		dni_vecino = pedirVecino();
		dni_correcto = comprobarDNI(dni_vecino);
		while (!dni_correcto) {// Vuelve a pedirlo si el DNI no cumple los requisitos.
			System.out.println("Introduzca de nuevo el DNI");
			dni_vecino = pedirVecino();
			dni_correcto = comprobarDNI(dni_vecino);// Comprobamos si el DNI cumple los requisitos
		}
		if (!dni_vecino.equalsIgnoreCase("") && dni_correcto) {
			vecino_correcto = c.comprobarVecino(dni_vecino);
			if (vecino_correcto) {
				Vecino v = c.buscarVecino(dni_vecino);
				if (v != null) {
					peticiones_urgentes = v.getPeticionesUrgentes();
					for (int i = 0; i < peticiones_urgentes.length; i++) {
						if (peticiones_urgentes[i] != null) {
							System.out.println((i + 1) + "- " + peticiones_urgentes[i].getDescripcion());
						}
					}
				}
				if (v.getNum_peticiones() == 0) {
					System.out.println("El vecino aún no ha realizado peticiones urgentes.");
				}
			} else {
				System.out.println("El vecino no existe.");
			}
		}

	}

	// Muestra el impuesto anual que tiene que pagar la comunidad
	public static void consultarImpuestoAnual(Comunidad c) {
		double total_imp = c.calcularImpuestosComunidad();
		System.out.println(
				"La suma de impuestos anuales que tiene que pagar la comunidad es de " + total_imp + " euros.");
	}

	// Muestra el impuesto por cliente
	public static void consultarImpuestoCliente(Comunidad c) {
		String dni_vecino = "";
		boolean dni_correcto;
		System.out.print("Introduce el DNI del vecino para conocer sus impuestos: ");
		dni_vecino = pedirVecino();
		dni_correcto = comprobarDNI(dni_vecino);
		while (!dni_correcto) {// Vuelve a pedirlo si el DNI no cumple los requisitos.
			System.out.println("Introduzca de nuevo el DNI");
			dni_vecino = pedirVecino();
			dni_correcto = comprobarDNI(dni_vecino);// Comprobamos si el DNI cumple los requisitos
		}
		if (!dni_vecino.equalsIgnoreCase("") && dni_correcto) {
			double impuesto = c.calcularImpuestoVecino(dni_vecino);
			if (impuesto > 0) {
				System.out.println("El impuesto a pagar por " + dni_vecino + " es: " + impuesto + " euros");
			} else {
				System.out.println("El impuesto del vecino " + dni_vecino + " no existe porque el vecino no existe.");
			}
		}
	}

	// Muestra el coste que tiene que pagar la comunidad por la empresa de
	// mantenimiento
	public static void consultarCosteMantenimiento(Comunidad c, EmpresaMantenimiento em) {
		System.out.println("El coste anual que tendrá que pagar la comunidad por la Empresa de mantenimiento será de "
				+ c.calcularPrecioMantenimiento(em) + " euros.");
	}

	// Nos comprueba que el dni cumple el formato
	public static boolean comprobarDNI(String nif) {
		if (nif.length() != 9) {
			System.out.println("Longitud incorrecta");
			return false;
		}
		for (int i = 0; i < nif.length(); i++) {
			if (i <= nif.length() - 2) {
				if (!(nif.charAt(i) >= '0' && nif.charAt(i) <= '9')) {
					System.out.println("DNI incorrecto por los primeros numeros");
					return false;
				}
			} else {
				if (!Character.isLetter(nif.charAt(8))) {
					System.out.println("DNI incorrecto por la ultima letra");
					return false;
				}
			}
		}
		return true;
	}

	public static boolean numeroRango(int lim_inf, int lim_sup, int numero) {
		if (numero < lim_inf || numero > lim_sup) {
			return false;
		}
		return true;
	}
}
