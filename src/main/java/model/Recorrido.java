package model;


import java.time.LocalTime;

public class Recorrido {
	
	private int idRecorrido;
	private int idTipoColectivo;
	private LocalTime hsSalida;
	private LocalTime hsLlegada;
	private int idLocOrigen;
	private int idLocDestino;
	
	public int getIdLocOrigen() {
		return idLocOrigen;
	}
	public void setIdLocOrigen(int idLocOrigen) {
		this.idLocOrigen = idLocOrigen;
	}
	public int getIdLocDestino() {
		return idLocDestino;
	}
	public void setIdLocDestino(int idLocDestino) {
		this.idLocDestino = idLocDestino;
	}
	public int getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	public int getIdTipoColectivo() {
		return idTipoColectivo;
	}
	public void setIdTipoColectivo(int idTipoColectivo) {
		this.idTipoColectivo = idTipoColectivo;
	}
	public LocalTime getHsSalida() {
		return hsSalida;
	}
	public void setHsSalida(LocalTime hsSalida) {
		this.hsSalida = hsSalida;
	}
	public LocalTime getHsLlegada() {
		return hsLlegada;
	}
	public void setHsLlegada(LocalTime hsLlegada) {
		this.hsLlegada = hsLlegada;
	}

}
