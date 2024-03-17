package UI;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import Logic.Control_parqueadero;
import Logic.Suscripcion;
import Model.Cliente;
import Model.Parqueadero;
import Model.Tiempo;
import Model.Vehiculo;

public class Main {
	static Tiempo temp =new Tiempo(29,03,2024);
	static Control_parqueadero control =new Control_parqueadero();
	static Parqueadero par =new Parqueadero();
	static Suscripcion suscrip= new Suscripcion();
	static Set<Vehiculo> vehiculos= new HashSet<Vehiculo>();
	static Set<Vehiculo> historial= new HashSet<Vehiculo>();
	static Set<Cliente> clientes= new HashSet<Cliente>();
	static Set<Cliente> cli = new HashSet<>();
	static Set<Set<Vehiculo>> vehic = new HashSet<>();
	
	
	
	public static void tiempo(){
		StringBuilder message = new StringBuilder();
		message.append("\n\t Bienvenidos Parqueadero ").append(par.getNombre());
        message.append("\n fecha: ").append(temp.toString());
        JOptionPane.showMessageDialog(null,message);
	}
	public boolean retirarVehiculo(String placa) {
		    Vehiculo vehiculo = new Vehiculo(placa, "");
		    return vehiculos.remove(vehiculo);
		  }
	public int cantidadVehiculos() {
	    return vehiculos.size();
	  }
	public static void ingresar_vehiculo(){
		Vehiculo vehi =new Vehiculo();
		String tipo ="";
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del tipo de vehiculo 1.moto ó 2.carro:"));
		while(opcion<=2) {
		if(opcion==1) {
			tipo="moto";
		}else if (opcion==2) {
			tipo="carro";
		}
		}
		String placa = JOptionPane
				.showInputDialog("Digite la placa del vehiculo:");
		vehi.setTipo_vehiculo(tipo);
		vehi.setPlaca(placa);
		if (par.getCupos_sin_suscribir() > vehiculos.size()) {
		      vehiculos.add(vehi);
		      historial.add(vehi);
		      vehic.add(historial);
		    } else {
		    	JOptionPane.showMessageDialog(null,"Parqueadero lleno!");
		    }
	}
	public static void salida_vehiculos(){
		String placa = JOptionPane.showInputDialog("Digite la placa que desea darle salida: ");
		for(Vehiculo vehiculo: vehiculos) {
			if (vehiculo.equals(new Vehiculo(placa))) {
		int duracion = Integer.parseInt(JOptionPane.showInputDialog("Digite la duracion en minutos del tiempo en parqueo:"));
		vehiculo.setDuracion(duracion);
		vehiculos.add(vehiculo);
		historial.add(vehiculo);
		suscrip.suscripcion_hora(temp,vehiculo,par);
		JOptionPane.showMessageDialog(null, "Total a pagar: "+vehiculo.getValor());
		vehiculos.remove(vehiculo);
		}
		}	
	}
	public static void subscribir_vehiculos(){
		Cliente clie= new Cliente();
		String tipo ="";
		String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente: ");
		String cedula = JOptionPane.showInputDialog("Digite la cedula: ");
		String placa = JOptionPane.showInputDialog("Digite la placa: ");
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del tipo de vehiculo 1.moto ó 2.carro:"));
		if(opcion==1) {
			tipo="moto";
		}else {
			tipo="carro";
		}
		clie.setNombre(nombre);
		clie.setCedula(cedula);
		clie.setPlaca(placa);
		clie.setTipo_vehiculo(tipo);
		clie.setVigencia(30);
		clientes.add(clie);
		suscrip.suscripcion_mensual(temp,clie,par);
		JOptionPane.showMessageDialog(null, "Total a pagar: "+clie.getValor());
		cli.add(clie);
	}
	public static void mostrar_tamanho_vehiculos(){
		StringBuilder message = new StringBuilder();
		int tamanho= par.getCupos_sin_suscribir();
		message.append("\t\t Cupo de vehiculos en el parqueadero: ").append(tamanho - vehiculos.size());
		message.append("\n\t\t Vehiculos en el sistema: ").append(vehiculos.size());
		message.append("\n\t\t Vehiculos con cambios en el sistema: ").append(vehiculos.toString());
		message.append("\n\t\t Vehiculos cargados al historial diario: ").append(historial.toString());
		message.append("\n\t\t Vehiculos suscritos cargados al historial diario: ").append(clientes.toString());
		JOptionPane.showMessageDialog(null,message);
	}
	public static void ingresar_datos_predefinidos(){
		par.setNombre("El Rincon");
		par.setDireccion("Carrera 16No26-24");
		par.setCupos_sin_suscribir(3);
		par.setCupos_suscritos(3);
		par.setValor_cupo_hora_carro(114);
		par.setValor_cupo_hora_moto(163);
		par.setValor_cupo_mes_carro(70000);
		par.setValor_cupo_mes_moto(50000);
	}
	private static void ingresar_datos_parqueadero() {
		String nombre = JOptionPane.showInputDialog("Digite el nombre del parqueadero: ");
		String direccion = JOptionPane.showInputDialog("Digite la direccion del parqueadero: ");
		int cupo1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de cupos del parqueadero sin suscribir:"));
		int cupo2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de cupos del parqueadero que estan suscritos:"));
		double valor1 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor del cupo por minuto de la moto:"));
		double valor2 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor del cupo por minuto del carro:"));
		double valor3 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor de la suscripcion mensual de la moto:"));
		double valor4 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor de la suscripcion mensual del carro:"));
		par.setNombre(nombre);
		par.setDireccion(direccion);
		par.setCupos_sin_suscribir(cupo1);
		par.setCupos_suscritos(cupo2);
		par.setValor_cupo_hora_carro(valor1);
		par.setValor_cupo_hora_moto(valor2);
		par.setValor_cupo_mes_carro(valor3);
		par.setValor_cupo_mes_moto(valor4);
	}
	public static void mostrar_modificar_datos_parqueadero(){
		String nombre = JOptionPane.showInputDialog("Digite el nombre del parqueadero: ");
		String direccion = JOptionPane.showInputDialog("Digite la direccion del parqueadero: ");
		int cupo1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de cupos del parqueadero sin suscribir:"));
		int cupo2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el total de cupos del parqueadero que estan suscritos:"));
		double valor1 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor del cupo por minuto de la moto:"));
		double valor2 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor del cupo por minuto del carro:"));
		double valor3 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor de la suscripcion mensual de la moto:"));
		double valor4 = Double.parseDouble(JOptionPane.showInputDialog("Digite el valor de la suscripcion mensual del carro:"));
		Control_parqueadero.modificar_parqueadero(par, nombre, direccion, cupo1, cupo2, valor1, valor2, valor3, valor4);
	}
	
	public static void mostrar_modificar_datos_cliente(){
		String tipo ="";
		String placa1 = JOptionPane.showInputDialog("Digite la placa del vehiculo que desea modificar los datos: ");
		String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente: ");
		String cedula = JOptionPane.showInputDialog("Digite la cedula: ");
		String placa = JOptionPane.showInputDialog("Digite la placa: ");
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero del tipo de vehiculo 1.moto ó 2.carro:"));
		while(opcion<=2) {
			if(opcion==1) {
				tipo="moto";
			}else if (opcion==2) {
				tipo="carro";
			}
			}
		Control_parqueadero.modificar_datos_cliente(placa1, clientes, nombre, cedula, placa, tipo, suscrip, temp, par, cli);
	}
	public static void mostrar_eliminar_datos_cliente(){
		String placa1 = JOptionPane.showInputDialog("Digite la placa del vehiculo que desea modificar los datos: ");
		Control_parqueadero.eliminar_datos_cliente(clientes, placa1);
	}
	
	public static void reporte() {
		StringBuilder message = new StringBuilder();
		double valor1=0;
		double valor2=0;
		message.append("Reporte diario de ventas del parqueadero "+par.getNombre()+"\n fecha: "+ temp.toString());
		message.append("\n ----------------------------------------------------------");
		valor1 = Control_parqueadero.valortotal_sinsuscripcion_reporte(vehic, historial, clientes, suscrip, cli, par, temp);
		message.append("\n ----------------------------------------------------------");
		message.append("\n Vehiculos sin suscribir");
		message.append("\n ----------------------------------------------------------");
		message.append("\n Cantidad de vehiculos ingresados en el dia: "+historial.size());
		message.append("\n Precio recolectado: "+valor1);
		valor2 = Control_parqueadero.valortotal_consuscripcion_reporte(vehic, historial, clientes, suscrip, cli, par, temp);
		message.append("\n ----------------------------------------------------------");
		message.append("\n Vehiculos inscritos al parqueadero");
		message.append("\n ----------------------------------------------------------");
		message.append("\n Cantidad de vehiculos ingresados en el dia: "+clientes.size());
		message.append("\n Precio recolectado: "+valor2);
		JOptionPane.showMessageDialog(null,message);
	}
	public static void main (String [] args) {
		boolean continuar = true;
		int opcion = 0;
		ingresar_datos_predefinidos();
		tiempo();
		while (continuar == true) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"\n\n\t\t Menu Parqueadero"
					+ "\n 1. Ingresar modo administrador. " 
					+ "\n 2. Ingresar vehiculo." 
					+ "\n 3. Salida de vehiculo."
					+ "\n 4. Suscribir vehiculo."
					+ "\n 5. Sitios de parqueo."
					+ "\n 6. Dia terminado."
					+ "\n 7. Salir.\n"));
			switch (opcion) {
			case 1:
				menu_administrador();
				break;
			case 2:
				ingresar_vehiculo();
				break;
			case 3:
				salida_vehiculos();
				break;
			case 4:
				subscribir_vehiculos();
				break;
			case 5:
				mostrar_tamanho_vehiculos();
				break;
			case 6:
				suscrip.avanzarDia(temp);
				tiempo();
				break;
			case 7:
				continuar=false;
				break;
	}
	}
}
	public static void menu_administrador () {
		boolean continuar = true;
		int opcion = 0;
		while (continuar == true) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"\n\n\t\t Menu Administrador"
					+ "\n 1. Ingresar datos del parqueadero. " 
					+ "\n 2. Modificar datos del parqueadero." 
					+ "\n 3. Eliminar datos del parqueadero."
					+ "\n 4. Modificar datos del cliente."
					+ "\n 5. Eliminar datos del cliente."
					+ "\n 6. Reportes."
					+ "\n 7. Volver al menu inicial.\n"));
			switch (opcion) {
			case 1:
				ingresar_datos_parqueadero();
				break;
			case 2:
				mostrar_modificar_datos_parqueadero();
				break;
			case 3:
				Control_parqueadero.eliminar_datos_parqueadero(par);
				break;
			case 4:
				mostrar_modificar_datos_cliente();
				break;
			case 5:
				mostrar_eliminar_datos_cliente();
				break;
			case 6:
				reporte();
				break;
			case 7:
				continuar=false;
				break;
	}
	}
}
	
}
