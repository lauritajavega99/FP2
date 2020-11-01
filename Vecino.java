import java.util.Arrays;
import java.util.Scanner;

public abstract class Vecino implements Descuentos {
	protected String nombre;
	protected String dni;
	protected String numPiso;
	protected int num_peticiones = 0;
	protected Peticion[] peticiones = new Peticion[ELEMENTOS];

	public Vecino(String nombre, String dni, String numPiso) {
		this.nombre = nombre;
		this.dni = dni;
		this.numPiso = numPiso;
	}

	public Vecino(String nombre, String dni, String numPiso, Peticion[] peticiones) {
		this.nombre = nombre;
		this.dni = dni;
		this.numPiso = numPiso;
		this.peticiones = peticiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNumPiso() {
		return numPiso;
	}

	public void setNumPiso(String numPiso) {
		this.numPiso = numPiso;
	}

	public Peticion[] getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(Peticion[] peticiones) {
		this.peticiones = peticiones;
	}

	public int getNum_peticiones() {
		return num_peticiones;
	}

	public void setNum_peticiones(int num_peticiones) {
		this.num_peticiones = num_peticiones;
	}

	public void addPeticion(Peticion p) {
		if (num_peticiones <= 9) {
			peticiones[num_peticiones] = p;
			num_peticiones++;
		}
	}

	public Peticion[] getPeticionesUrgentes() {
		Peticion[] peticiones_urgentes = new Peticion[10];
		for (int i = 0; i < peticiones.length; i++) {
			if (peticiones[i] != null && peticiones[i].getTipoUrgencia() == 1) {
				peticiones_urgentes[i] = peticiones[i];
			}
		}
		return peticiones_urgentes;
	}

	public String toString() {
		return "Vecino " + nombre + ", dni=" + dni + ", numPiso=" + numPiso + ", peticiones="
				+ Arrays.toString(peticiones) + "\n";
	}

	abstract public double calcularImpuesto();

}
