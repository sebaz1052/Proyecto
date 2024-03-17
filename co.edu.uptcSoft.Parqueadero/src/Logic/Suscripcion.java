package Logic;


import Model.Cliente;
import Model.Parqueadero;
import Model.Tiempo;
import Model.Vehiculo;

public class Suscripcion {
	
	public void suscripcion_mensual(Tiempo temp,Cliente cl,Parqueadero par) {
		reportar_fecha_suscripcion(temp);
        String vehiculo1= cl.getTipo_vehiculo();
        if("carro".equalsIgnoreCase(vehiculo1)==true) {
        double valor1 = par.getValor_cupo_mes_carro();
        cl.setValor(valor1);
        }else {
        double valor2 = par.getValor_cupo_mes_moto();
        cl.setValor(valor2);
        }
    }
	public void suscripcion_hora(Tiempo temp,Vehiculo veh,Parqueadero par) {
        String vehiculo1= veh.getTipo_vehiculo();
        if(vehiculo1.equalsIgnoreCase("carro")) {
        double valor1 = par.getValor_cupo_hora_carro();
        double resul1= valor1*veh.getDuracion();
        veh.setValor(resul1);
        }else {
        double valor2 = par.getValor_cupo_hora_moto();
        double resul1= valor2*veh.getDuracion();
        veh.setValor(resul1);
        }
    }
	public void avanzarDia(Tiempo temp) {
		int dia= temp.getDia();
		int mes= temp.getMes();
		int anho= temp.getAnho();
        dia++;
        if (dia > diasDelMes(mes, anho)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anho++;
            }
        }
        temp.setAnho(anho);
        temp.setDia(dia);
        temp.setMes(mes);
    }
    
    private static int diasDelMes(int mes, int año) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (esBisiesto(año)) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;
    }

    private static boolean esBisiesto(int año) {
        return (año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0));
    }

	public String conocer_fecha_suscripcion(Tiempo temp) {
		String msj="";
		int dia= temp.getDia();
		int mes= temp.getMes();
		int anho= temp.getAnho();
		int cont=0;
		while(cont<30) {
			cont=cont+1;
			 dia++;
        if (dia > diasDelMes(mes, anho)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anho++;
            }
            
        }
    }
		msj="fecha de salida del vehiculo: \ndia: "+dia+" mes: "+mes+" año: "+anho;
      return msj;
    }
	
	public static String reportar_fecha_suscripcion(Tiempo temp) {
		String msj="";
		int dia= temp.getDia();
		int mes= temp.getMes();
		int anho= temp.getAnho();
		int dia2=dia;
		int mes2= mes;
		int anho2=anho;
		int cont=0;
		while(cont<30) {
			cont=cont+1;
			 dia++;
        if (dia > diasDelMes(mes, anho)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anho++;
            }
            
        }
    }
		if(dia2==dia&&mes2==mes&&anho2==anho) {
			msj="Renovar suscripcion del cliente";
		}
      return msj;
    }
	
}
