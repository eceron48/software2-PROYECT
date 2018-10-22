package modelo;

import java.sql.Date;

public class Visitantes extends Persona {
	
	public Date horaEntrada;
	public Date horaSalida;
	
	public Visitantes () {
		
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	
	

}
