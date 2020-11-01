
public class EmpresaMantenimiento {
	private String nombre;
	private String direccion;
	private double costemensual_asc;
	
	public EmpresaMantenimiento(String nombre, String direccion, double costemensual_asc) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.costemensual_asc = costemensual_asc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getCostemensual_asc() {
		return costemensual_asc;
	}
	public void setCostemensual_asc(double costemensual_asc) {
		this.costemensual_asc = costemensual_asc;
	}
	
	public String toString() {
		return "EmpresaMantenimiento [nombre=" + nombre + ", direccion=" + direccion + ", costemensual_asc="
				+ costemensual_asc + "]";
	}
	
	

}
