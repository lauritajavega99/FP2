
public class Propietario extends Vecino {
	private int año_compra;

	public Propietario(String nombre, String dni, String numPiso, int año_compra) {
		super(nombre, dni, numPiso);
		this.año_compra = año_compra;
	}

	public Propietario(String nombre, String dni, String numPiso, Peticion[] peticiones, int año_compra) {
		super(nombre, dni, numPiso, peticiones);
		this.año_compra = año_compra;
	}

	public int getAño_compra() {
		return año_compra;
	}

	public void setAño_compra(int año_compra) {
		this.año_compra = año_compra;
	}

	public String toString() {
		return super.toString() + "Es propietario con año de compra en " + año_compra + ".";
	}

	public double calcularImpuesto() {
		double impuesto = 0;
		int año_actual = 2019;
		if ((año_actual - año_compra) > 15) {
			impuesto = BASEP + (BASEP * A);
		} else {
			impuesto = BASEP + (BASEP * B);
		}
		return impuesto;
	}

}
