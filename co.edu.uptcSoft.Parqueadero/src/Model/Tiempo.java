package Model;

public class Tiempo {
	private int dia;
	private int mes;
	private int anho;

	public Tiempo(int dia, int mes, int anho) {
		this.dia = dia;
		this.mes = mes;
		this.anho = anho;
	}
	public Tiempo() {
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnho() {
		return anho;
	}
	public void setAnho(int anho) {
		this.anho = anho;
	}
	
	@Override
	public String toString() {
		return "" + dia + "/" + mes + "/" + anho;
	}
	

}
