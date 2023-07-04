package controller.venta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import controller.producto.ParProductoCantidad;
import controller.producto.Producto;

public class Venta implements Serializable{
	protected float precioVenta;
	protected int codigoVenta;
	protected List<ParProductoCantidad> listaVenta;
	
	
	// Constructor
	public Venta(int codigo) {
		precioVenta = 0;
		codigoVenta = codigo; // Corregir
		listaVenta = new ArrayList<>();
	}
	
	// Getters
	public int getCodigoVenta() { return codigoVenta; }
	public float getPrecioVenta() { return precioVenta; }
	public List<ParProductoCantidad> getListaVenta() {return listaVenta;}
	
	// Setters
	
	public void setCodigoVenta(int codigoVenta) {this.codigoVenta = codigoVenta;}
	
	// Methods
	public void agregarProducto(Producto producto, int cantidad) {
		
		boolean flag = true;
		for (ParProductoCantidad par : listaVenta) { // Primero veo si existe en la lista de la venta
			if (par.getCodigoProducto() == producto.getCodigo()) {
				par.setCantidad(par.getCantidad() + cantidad);
				precioVenta =+ producto.getPrecioUnitario()*cantidad;
				flag = false;
			}
		}
		if (flag) { // Si no existe creo el par y lo agrego
			ParProductoCantidad parProductoCantidad = new ParProductoCantidad(producto.getCodigo(), cantidad, producto.getNombre());
			listaVenta.add(parProductoCantidad);
			float precio = producto.getPrecioUnitario()*cantidad;
			precioVenta =+ precio;
		}
	}
	
	public void quitarProducto(Producto p, int cant) {
		boolean remove = false; ParProductoCantidad parSacar = null;
		for (ParProductoCantidad parProductoCantidad : listaVenta) {
			if (parProductoCantidad.getCodigoProducto() == p.getCodigo()) {
				if (parProductoCantidad.getCantidad() > cant) {
					parProductoCantidad.setCantidad(parProductoCantidad.getCantidad() - cant);
					p.agregarStock(cant);
				} else {
					parSacar = parProductoCantidad;
					remove = true;
					p.agregarStock(parProductoCantidad.getCantidad());
				}
			}
		}
		if (remove) {
			listaVenta.remove(parSacar);
		}
	}
	
	public float calcularPrecioDeVenta() {
		return precioVenta;
	}
	
	public String toString() {
		return "ID: " + formatoCodigo(Integer.toString(codigoVenta)) + " | $" + calcularPrecioDeVenta() + " | " + listaVenta.toString() + " | Venta Debito";
	}
	
	public String obtenerTipoVenta() {
		return "Venta Debito";
	}
	
	protected String formatoCodigo(String s) {
		if (s.length() < 5) {
			for (int i = s.length(); i < 5; i++) {
				s = "0" + s;
			}
		}
		return s;
	}
	
}
