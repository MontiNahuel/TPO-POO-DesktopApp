package controller.venta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import controller.catalogo.CatalogoDeProductos;
import controller.datos.Datos;

public class RegistroDeVentas implements Serializable{
	List<Venta> registroVentas;
	
	public RegistroDeVentas() {
		// TODO Auto-generated constructor stub
		registroVentas = new ArrayList<>();
	}
	// Getters
	public List<Venta> getRegistroVentas() {
		return registroVentas;
	}
	
	// Methods
	public boolean registrarVenta(Venta v) {
		boolean existe = false;
		for (Venta venta : registroVentas) {
			if (venta.getCodigoVenta() == v.getCodigoVenta()) {
				existe = true;
			}
		}
		if (!existe) {
			registroVentas.add(v);
		}
		return !existe;
	}
	
	public String listarVentas() { // Delegar responsabilidad a la clase venta de que se liste a si misma
		String listado = "";
		for (Venta venta : registroVentas) {
			listado += "Venta nro:" + venta.getCodigoVenta() + "\n" + "Monto: $" + venta.getPrecioVenta() + "\n";
		}
		return listado;
	}
	
	public static RegistroDeVentas recuperarse(){
		RegistroDeVentas reg=(RegistroDeVentas) Datos.recuperarRegVentas();
		if(reg == null)
			reg = new RegistroDeVentas();
		return reg;
	}
	
	public boolean guardarse(){
		return Datos.guardarRegVentas(this);
	}
}
