package Model;

public class Vehiculo {
	private String placa;
	private String tipo_vehiculo;
	private int duracion;
	private double valor;
	
	
	public Vehiculo() {
	}
	public Vehiculo(String placa) {
		this.placa = placa;
	}
	public Vehiculo(String tipo_vehiculo, String placa) {
		this.placa = placa;
		this.tipo_vehiculo = tipo_vehiculo;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}
	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public String toString2() {
		return "placa=" + placa + ", tipo de vehiculo=" + tipo_vehiculo;
	}
	@Override
	public String toString() {
		return "placa=" + placa + ", tipo de vehiculo=" + tipo_vehiculo + ", duracion=" + duracion + ", valor="
				+ valor;
	}
	public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Vehiculo other = (Vehiculo) obj;
	    return placa.equals(other.placa);
	  }
	
}
