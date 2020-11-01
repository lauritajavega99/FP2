
public class Propietario extends Vecino {
	private int a�o_compra;

	public Propietario(String nombre, String dni, String numPiso, int a�o_compra) {
		super(nombre, dni, numPiso);
		this.a�o_compra = a�o_compra;
	}

	public Propietario(String nombre, String dni, String numPiso, Peticion[] peticiones, int a�o_compra) {
		super(nombre, dni, numPiso, peticiones);
		this.a�o_compra = a�o_compra;
	}

	public int getA�o_compra() {
		return a�o_compra;
	}

	public void setA�o_compra(int a�o_compra) {
		this.a�o_compra = a�o_compra;
	}

	public String toString() {
		return super.toString() + "Es propietario con a�o de compra en " + a�o_compra + ".";
	}

	public double calcularImpuesto() {
		double impuesto = 0;
		int a�o_actual = 2019;
		if ((a�o_actual - a�o_compra) > 15) {
			impuesto = BASEP + (BASEP * A);
		} else {
			impuesto = BASEP + (BASEP * B);
		}
		return impuesto;
	}

}
