package Model;

public class Parqueadero {
	private String nombre;
	private String direccion;
	private int cupos_suscritos;
	private int cupos_sin_suscribir;
	private double valor_cupo_hora_moto;
	private double valor_cupo_hora_carro;
	private double valor_cupo_mes_moto;
	private double valor_cupo_mes_carro;
	private double gasto_diario;
	private int cantidad_vehiculos_dia;
	
	public Parqueadero(String nombre, String direccion,int cupos_suscritos,int cupos_sin_suscribir, double valor_cupo_hora_moto,
			double valor_cupo_hora_carro, double valor_cupo_mes_moto, double valor_cupo_mes_carro) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cupos_suscritos = cupos_suscritos;
		this.cupos_sin_suscribir = cupos_sin_suscribir;
		this.valor_cupo_hora_moto = valor_cupo_hora_moto;
		this.valor_cupo_hora_carro = valor_cupo_hora_carro;
		this.valor_cupo_mes_moto = valor_cupo_mes_moto;
		this.valor_cupo_mes_carro = valor_cupo_mes_carro;
	}
	
	public int getCupos_suscritos() {
		return cupos_suscritos;
	}

	public void setCupos_suscritos(int cupos_suscritos) {
		this.cupos_suscritos = cupos_suscritos;
	}

	public int getCupos_sin_suscribir() {
		return cupos_sin_suscribir;
	}

	public void setCupos_sin_suscribir(int cupos_sin_suscribir) {
		this.cupos_sin_suscribir = cupos_sin_suscribir;
	}

	public Parqueadero() {
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
	public double getValor_cupo_hora_moto() {
		return valor_cupo_hora_moto;
	}
	public void setValor_cupo_hora_moto(double valor_cupo_hora_moto) {
		this.valor_cupo_hora_moto = valor_cupo_hora_moto;
	}
	public double getValor_cupo_hora_carro() {
		return valor_cupo_hora_carro;
	}
	public void setValor_cupo_hora_carro(double valor_cupo_hora_carro) {
		this.valor_cupo_hora_carro = valor_cupo_hora_carro;
	}
	public double getValor_cupo_mes_moto() {
		return valor_cupo_mes_moto;
	}
	public void setValor_cupo_mes_moto(double valor_cupo_mes_moto) {
		this.valor_cupo_mes_moto = valor_cupo_mes_moto;
	}
	public double getValor_cupo_mes_carro() {
		return valor_cupo_mes_carro;
	}
	public void setValor_cupo_mes_carro(double valor_cupo_mes_carro) {
		this.valor_cupo_mes_carro = valor_cupo_mes_carro;
	}

	public double getGasto_diario() {
		return gasto_diario;
	}

	public void setGasto_diario(double gasto_diario) {
		this.gasto_diario = gasto_diario;
	}

	public int getCantidad_vehiculos_dia() {
		return cantidad_vehiculos_dia;
	}

	public void setCantidad_vehiculos_dia(int cantidad_vehiculos_dia) {
		this.cantidad_vehiculos_dia = cantidad_vehiculos_dia;
	}

	@Override
	public String toString() {
		return "Parqueadero [nombre=" + nombre + ", direccion=" + direccion + ", cupos_suscritos=" + cupos_suscritos
				+ ", cupos_sin_suscribir=" + cupos_sin_suscribir + ", valor_cupo_hora_moto=" + valor_cupo_hora_moto
				+ ", valor_cupo_hora_carro=" + valor_cupo_hora_carro + ", valor_cupo_mes_moto=" + valor_cupo_mes_moto
				+ ", valor_cupo_mes_carro=" + valor_cupo_mes_carro + ", gasto_diario=" + gasto_diario
				+ ", cantidad_vehiculos_dia=" + cantidad_vehiculos_dia + "]";
	}
	
	
}
