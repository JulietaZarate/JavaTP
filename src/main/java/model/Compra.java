package model;

import java.time.Instant;


public class Compra {

		private int idCompra;
		private Instant fecha_hora_compra;
		private int idRecorrido;
		private int idUsuario;
		public int getIdCompra() {
			return idCompra;
		}
		public void setIdCompra(int idCompra) {
			this.idCompra = idCompra;
		}
		public Instant getFecha_hora_compra() {
			return fecha_hora_compra;
		}
		public void setFecha_hora_compra(Instant fecha_hora_compra) {
			this.fecha_hora_compra = fecha_hora_compra;
		}
		public int getIdRecorrido() {
			return idRecorrido;
		}
		public void setIdRecorrido(int idRecorrido) {
			this.idRecorrido = idRecorrido;
		}
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		
		
}
