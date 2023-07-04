package controller.catalogo;
import java.util.ArrayList;
import java.util.List;

import controller.datos.Datos;
import controller.producto.Producto;
import java.io.*;

public class CatalogoDeProductos implements Serializable{
	private List<Producto> catalogoList;
	
	
	// Constructor
	public CatalogoDeProductos() {
		catalogoList = new ArrayList<>();
	}
	
	// Getters
	public List<Producto> getCatalogoList() {
		return catalogoList;
	}
	
	// Methods
	public boolean cargarProducto(Producto p) {
		boolean existe = false;
		for (Producto producto : catalogoList) {
			if (producto.getCodigo() == p.getCodigo()) {
				existe = true;
			}
		}
		
		if (!existe) {
			catalogoList.add(p);
		}
		
		return existe;
	}
	
	// Overload Method
	public void modificarProducto(int codigo, int precio) {
		// Modifica precio
		for (Producto producto : catalogoList) {
			if (producto.getCodigo() == codigo) {
				producto.setPrecioUnitario(precio);
			}
		}
	}
	
	public void modificarProducto(int codigo, String descripcion) {
		//Modifica descripcion
		for (Producto producto : catalogoList) {
			if (producto.getCodigo() == codigo) {
				producto.setDescripcion(descripcion);
			}
		}
	}
	
	public boolean bajaDeProducto(int codigo) {
		Producto p1 = null; boolean existe = false;
		for (Producto producto : catalogoList) {
			if (producto.getCodigo() == codigo) {
				p1 = producto;
				existe = true;
			}
		}
		if (existe) {
			catalogoList.remove(p1);
		}
		return existe;
	}
	
	public String listadoDeProductos() {
		String listado = ""; String infoProducto;
		for (Producto producto : catalogoList) {
			infoProducto = producto.listarProducto();
			listado += infoProducto + "\n";
		}
		return listado;
	}
	
	public static CatalogoDeProductos recuperarse(){
		CatalogoDeProductos cat=(CatalogoDeProductos) Datos.recuperarCatProductos();
		if(cat == null)
			cat = new CatalogoDeProductos();
		return cat;
	}
	
	public boolean guardarse(){
		return Datos.guardarCatProductos(this);
	}
}
