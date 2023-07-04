package pruebas;

import controller.catalogo.CatalogoDeProductos;
import controller.producto.Producto;

public class Pruebas {
	public static void main(String[] args) {
		CatalogoDeProductos catalogoDeProductos = new CatalogoDeProductos();
		Producto p1 = new Producto(01, "Descripcion1", "Nombre1", 200, 20);
		catalogoDeProductos.cargarProducto(p1);
		String list = catalogoDeProductos.listadoDeProductos();
		System.out.println(list);
		p1.agregarStock(20);
		list = catalogoDeProductos.listadoDeProductos();
		System.out.println(list);
		p1.agregarStock(20);
		list = catalogoDeProductos.listadoDeProductos();
		System.out.println(list);
		p1.restarStock(20);
		list = catalogoDeProductos.listadoDeProductos();
		System.out.println(list);
		p1.restarStock(20);
		list = catalogoDeProductos.listadoDeProductos();
		System.out.println(list);
	}
}
