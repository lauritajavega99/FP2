
public class Peticion {
	private int tipoUrgencia;
	private String descripcion;
	
	public Peticion(int tipoUrgencia, String descripcion) {
		this.tipoUrgencia = tipoUrgencia;
		this.descripcion = descripcion;
	}

	public int getTipoUrgencia() {
		return tipoUrgencia;
	}

	public void setTipoUrgencia(int tipoUrgencia) {
		this.tipoUrgencia = tipoUrgencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return "Peticion [tipoUrgencia=" + tipoUrgencia + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
