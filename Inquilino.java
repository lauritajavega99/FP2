
public class Inquilino extends Vecino {
	private double pago_mensual;

	public Inquilino(String nombre, String dni, String numPiso, Peticion[] peticiones, double pago_mensual) {
		super(nombre, dni, numPiso, peticiones);
		this.pago_mensual = pago_mensual;
	}

	public Inquilino(String nombre, String dni, String numPiso, double pago_mensual) {
		super(nombre, dni, numPiso);
		this.pago_mensual = pago_mensual;
	}

	public double getPago_mensual() {
		return pago_mensual;
	}

	public void setPago_mensual(double pago_mensual) {
		this.pago_mensual = pago_mensual;
	}

	public String toString() {
		return super.toString() + " Es inquilino con pago mensual de " + pago_mensual + " euros.";
	}

	public double calcularImpuesto() {
		double impuesto = 0;
		if (pago_mensual > 400) {
			impuesto = BASEI + (BASEI * B);
		} else {
			impuesto = BASEI + (BASEI * C);
		}
		return impuesto;
	}

}
