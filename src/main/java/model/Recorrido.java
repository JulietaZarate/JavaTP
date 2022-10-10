package model;



public class Recorrido {
	
	private int idRecorrido;
	private int idTipoColectivo;
	private String hsSalida;
	private String hsLlegada;
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
	public String getHsSalida() {
		return hsSalida;
	}
	public void setHsSalida(String hsSalida) {
		this.hsSalida = hsSalida;
	}
	public String getHsLlegada() {
		return hsLlegada;
	}
	public void setHsLlegada(String hsLlegada) {
		this.hsLlegada = hsLlegada;
	}

}
