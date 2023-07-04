package controller.venta;

import java.io.Serializable;
import java.util.ArrayList;

public class VentaEfectivo extends Venta implements Serializable{
	protected int descuento;
	
	public VentaEfectivo(int codigo) {
		super(codigo);
		descuento = 5;
		super.precioVenta = 0;
		super.listaVenta = new ArrayList<>();
	}
	
	@Override
	public float calcularPrecioDeVenta() {
		if (precioVenta > 0) {
			return (precioVenta*(descuento/100) + precioVenta);
		}else {
			return 0;
		}
	}
	
	public String toString() {
		return "ID: " + formatoCodigo(Integer.toString(codigoVenta)) + " | $" + calcularPrecioDeVenta() + " | " + listaVenta.toString() + " | Venta Efectivo";
	}
	
	public String obtenerTipoVenta() {
		return "Venta Efectivo";
	}
}
