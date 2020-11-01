import java.util.Arrays;

public class Comunidad {
	private int num_Ascensores;
	private int num_vecinos = 0;
	private int max_vecinos = 15;
	Vecino[] vecinos = new Vecino[max_vecinos];

	public Comunidad(int num_Ascensores, int max_vecinos) {
		this.num_Ascensores = num_Ascensores;
		this.max_vecinos = max_vecinos;
		this.vecinos = new Vecino[max_vecinos];
	}

	public Comunidad(int num_Ascensores, int num_vecinos, Vecino[] vecinos) {
		this.num_Ascensores = num_Ascensores;
		this.num_vecinos = num_vecinos;
		this.vecinos = vecinos;
	}

	public int getNum_Ascensores() {
		return num_Ascensores;
	}

	public void setNum_Ascensores(int num_Ascensores) {
		this.num_Ascensores = num_Ascensores;
	}

	public Vecino[] getVecinos() {
		return vecinos;
	}

	public void setVecinos(Vecino[] vecinos) {
		this.vecinos = vecinos;
	}

	public int getNum_vecinos() {
		return num_vecinos;
	}

	public void setNum_vecinos(int num_vecinos) {
		this.num_vecinos = num_vecinos;
	}

	public String toString() {
		return "El número de ascensores es" + num_Ascensores + ", vecinos=" + Arrays.toString(vecinos) + "]";
	}

	public String mostrarInfoVecinos(int i) {
		return vecinos[i].toString();
	}

	// Metodo que añade los vecino que lee del fichero al array de vecinos
	public void addVecino(Vecino v) {
		if (num_vecinos < max_vecinos) {
			vecinos[num_vecinos] = v;
			num_vecinos++;
		}
	}

	// Comprueba si el DNI introducido corresponde con algún vecino del fichero
	public boolean comprobarVecino(String dni_vecino) {
		for (int i = 0; i < num_vecinos; i++) {
			if (vecinos[i].getDni().equals(dni_vecino)) {
				return true;
			}
		}
		return false;
	}

	// Devuelve el vecino buscado a través del dni
	public Vecino buscarVecino(String dni_vecino) {
		for (int i = 0; i < num_vecinos; i++) {
			if (vecinos[i].getDni().equals(dni_vecino)) {
				return vecinos[i];
			}
		}
		return null;

	}

	// Calcula el precio a pagar por la empresa de mantenimiento
	public double calcularPrecioMantenimiento(EmpresaMantenimiento empresa) {
		double precio = 0;
		precio = empresa.getCostemensual_asc() * num_Ascensores * 12;
		return precio;
	}

	// Calcula el impuesto total de la comunidad
	public double calcularImpuestosComunidad() {
		double total = 0;
		for (int i = 0; i < num_vecinos; i++) {
			total += vecinos[i].calcularImpuesto();
		}
		return total;
	}

	// Calcula el impuesto que tiene que pagar un determinado vecino en función de
	// si es inq o prop
	public double calcularImpuestoVecino(String dni) {
		double impuesto = -1.0;
		for (int i = 0; i < num_vecinos; i++) {
			if (vecinos[i] != null && vecinos[i].getDni().equalsIgnoreCase(dni)) {
				impuesto = vecinos[i].calcularImpuesto();
			}
		}
		return impuesto;
	}
}
