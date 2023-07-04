package controller.producto;

import java.io.Serializable;

public class ParProductoCantidad implements Serializable{
	private int codigoProducto;
	private int cantidadProducto;
	private String nombreProducto;
	
	public ParProductoCantidad(int codigo, int cantidad, String nombre) {
		this.codigoProducto = codigo;
		cantidadProducto = cantidad;
		nombreProducto = nombre;
	}
	
	public int getCodigoProducto() {
		return codigoProducto;
	}
	
	public int getCantidad() {
		return cantidadProducto;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setCantidad(int cantidad) {
		cantidadProducto = cantidad;
	}
	
	public String toString() {
		return nombreProducto + " " + cantidadProducto;
	}
}
