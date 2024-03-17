package Model;

public class Cliente {
	private String nombre;
	private String cedula;
	private String placa;
	private String tipo_vehiculo;
	private double valor;
	private int vigencia;
	public Cliente() {
	}
	public Cliente(String nombre, String cedula, String placa, int vigencia) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.placa = placa;
		this.vigencia = vigencia;
	}
	public Cliente(String placa) {
		this.placa = placa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}
	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getVigencia() {
		return vigencia;
	}
	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", cedula=" + cedula + ", placa=" + placa + ", vigencia=" + vigencia ;
	}
	public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Cliente other = (Cliente) obj;
	    return placa.equals(other.placa); 
	  }

}
