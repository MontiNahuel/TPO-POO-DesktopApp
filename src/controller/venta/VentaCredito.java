package controller.venta;

import java.io.Serializable;
import java.util.ArrayList;

public class VentaCredito extends Venta implements Serializable{
	protected int recargo;
	protected int cuotas;
	
	public VentaCredito(int cuotas, int codigo) {
		super(codigo);
		this.cuotas = cuotas;
		if (this.cuotas == 2) {
			recargo = 6;
		} else if (this.cuotas == 3) {
			recargo = 12;
		} else {
			recargo = 20;
		}
		super.precioVenta = 0;
		super.listaVenta = new ArrayList<>();
	}
	
	@Override
	public float calcularPrecioDeVenta() {
		return (precioVenta*(recargo/100)) + precioVenta;
	}
	
	public String toString() {
		return "ID: " + formatoCodigo(Integer.toString(codigoVenta)) + " | $" + calcularPrecioDeVenta() + " | " + listaVenta.toString() + " | Venta Credito" + " | Recargo: " + recargo + " | Cuotas: " + cuotas;
	}
	
	public String obtenerTipoVenta() {
		return "Venta Credito";
	}
}
