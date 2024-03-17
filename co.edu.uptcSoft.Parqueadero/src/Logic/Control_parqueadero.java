package Logic;

import java.util.Set;

import Model.Cliente;
import Model.Parqueadero;
import Model.Tiempo;
import Model.Vehiculo;

public class Control_parqueadero {
	
	public static double valortotal_sinsuscripcion_reporte(Set<Set<Vehiculo>> vehic,Set<Vehiculo> historial,Set<Cliente> clientes,Suscripcion suscrip, Set<Cliente> cli,Parqueadero par,Tiempo temp) {
		double valor1=0;
		for(Vehiculo vehiculo: historial) {
			valor1 = vehiculo.getValor()+ valor1;
		}
		return valor1;
	}
	public static double valortotal_consuscripcion_reporte(Set<Set<Vehiculo>> vehic,Set<Vehiculo> historial,Set<Cliente> clientes,Suscripcion suscrip, Set<Cliente> cli,Parqueadero par,Tiempo temp) {
		double valor1=0;
		for(Cliente clie: clientes) {
			valor1 = clie.getValor()+ valor1;
	}
		return valor1;
	}
	public static void modificar_datos_cliente(String placa1,Set<Cliente> clientes,String nombre,String cedula,String placa,String tipo,Suscripcion suscrip,Tiempo temp,Parqueadero par,Set<Cliente> cli){
		for(Cliente clie: clientes) {
			if (clie.equals(new Cliente(placa1))) {
				clie.setNombre(nombre);
				clie.setCedula(cedula);
				clie.setPlaca(placa);
				clie.setTipo_vehiculo(tipo);
				clientes.add(clie);
				suscrip.suscripcion_mensual(temp,clie,par);
				cli.add(clie);
			}
		}
	}
	public static void modificar_parqueadero(Parqueadero par,String nombre,String direccion,int cupo1,int cupo2,double valor1,double valor2,double valor3,double valor4) {
		par.setNombre(nombre);
		par.setDireccion(direccion);
		par.setCupos_sin_suscribir(cupo1);
		par.setCupos_suscritos(cupo2);
		par.setValor_cupo_hora_carro(valor1);
		par.setValor_cupo_hora_moto(valor2);
		par.setValor_cupo_mes_carro(valor3);
		par.setValor_cupo_mes_moto(valor4);
	}
	public static void eliminar_datos_cliente(Set<Cliente> clientes,String placa){
		for(Cliente clie: clientes) {
			if (clie.equals(new Cliente(placa))) {
				clientes.remove(clie);
			}
		}
	}
	public static void eliminar_datos_parqueadero(Parqueadero par){
		par.setNombre(null);
		par.setDireccion(null);
		par.setCupos_sin_suscribir(0);
		par.setCupos_suscritos(0);
		par.setValor_cupo_hora_carro(0);
		par.setValor_cupo_hora_moto(0);
		par.setValor_cupo_mes_carro(0);
		par.setValor_cupo_mes_moto(0);
	}
}
