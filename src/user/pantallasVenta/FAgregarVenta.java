package user.pantallasVenta;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.lang.reflect.Array;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.producto.ParProductoCantidad;
import controller.producto.Producto;
import controller.venta.Venta;
import user.pantallasProducto.FPantallaInvalida;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FAgregarVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigoTxt;
	private static Object[] catalogoArray;
	private static Venta venta;
	private JList listProductos;
	private JList listProductosEnCompra;
	private JTextField cantidadTxt;
	private JTextField cantidadSacarTxt;
	private int total;
	private JLabel valorLabel;
	private static Object[] registro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FAgregarVenta dialog = new FAgregarVenta(catalogoArray, registro, venta);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FAgregarVenta(Object[] catalogo, Object[] registroVenta, Venta v) {
		venta = v;
		catalogoArray = catalogo;
		registro = registroVenta;
		setBounds(100, 100, 1065, 556);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JList listProductos = new JList();
		listProductos.setBounds(46, 107, 421, 217);
		contentPanel.add(listProductos);
		this.listProductos = listProductos;
		listProductos.setListData(catalogoArray);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setBounds(46, 31, 236, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Venta");
		lblNewLabel_1.setBounds(545, 31, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo:");
		lblNewLabel_2.setBounds(545, 56, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		codigoTxt = new JTextField();
		codigoTxt.setBounds(601, 53, 86, 20);
		contentPanel.add(codigoTxt);
		codigoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Lista de Productos");
		lblNewLabel_3.setBounds(545, 82, 211, 14);
		contentPanel.add(lblNewLabel_3);
		
		JList listProductosEnCompra = new JList();
		listProductosEnCompra.setBounds(545, 107, 457, 217);
		contentPanel.add(listProductosEnCompra);
		this.listProductosEnCompra = listProductosEnCompra;
		
		JButton agregarAVenta = new JButton("Agregar");
		agregarAVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarAVenta();
			}
		});
		agregarAVenta.setBounds(46, 341, 89, 23);
		contentPanel.add(agregarAVenta);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarDeVenta();
			}
		});
		btnQuitar.setBounds(913, 341, 89, 23);
		contentPanel.add(btnQuitar);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad:");
		lblNewLabel_4.setBounds(217, 345, 65, 14);
		contentPanel.add(lblNewLabel_4);
		
		cantidadTxt = new JTextField();
		cantidadTxt.setBounds(292, 342, 86, 20);
		contentPanel.add(cantidadTxt);
		cantidadTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad:");
		lblNewLabel_5.setBounds(545, 345, 86, 14);
		contentPanel.add(lblNewLabel_5);
		
		cantidadSacarTxt = new JTextField();
		cantidadSacarTxt.setBounds(628, 342, 86, 20);
		contentPanel.add(cantidadSacarTxt);
		cantidadSacarTxt.setColumns(10);
		
		JLabel totalLabel = new JLabel("Total:" + total);
		this.valorLabel = totalLabel;
		totalLabel.setBounds(880, 57, 122, 14);
		contentPanel.add(totalLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelar();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cancelar();
			}
		});
	}
	
	// Methods
	// Agregar funcionalidad al boton de cancelar
	private void agregarAVenta() {
		Producto p = (Producto) listProductos.getSelectedValue();
		if (p != null && Integer.parseInt(cantidadTxt.getText()) > 0) {
			// Cambiar para que se vea si primero hay contenido en cantidadTxt y despues sea mayor a 0
			p.agregarAVenta(venta, Integer.parseInt(cantidadTxt.getText()));
			valorLabel.setText("Valor: " + venta.getPrecioVenta());
			listProductosEnCompra.setListData(venta.getListaVenta().toArray());
			listProductos.setListData(catalogoArray);
		}
	}
	
	private void quitarDeVenta() {
		ParProductoCantidad par = (ParProductoCantidad) listProductosEnCompra.getSelectedValue();
		if (par != null) {
			for (Object o : catalogoArray) {
				Producto producto = (Producto) o;
				if (producto.getCodigo() == par.getCodigoProducto()) {
					venta.quitarProducto(producto, Integer.parseInt(cantidadSacarTxt.getText()));
				}
			}
		}
		listProductosEnCompra.setListData(venta.getListaVenta().toArray());
		listProductos.setListData(catalogoArray);
	}
	
	private void aceptar() {
		boolean existe = false;
		for (Object object : registro) {
			Venta venta = (Venta) object;
			if (venta.getCodigoVenta() == Integer.parseInt(codigoTxt.getText())) {
				existe = true;
			}
		}
		if (!existe) {
			venta.setCodigoVenta(Integer.parseInt(codigoTxt.getText())); // Cambiar para validar los ID
			setVisible(false);
		}else {
			FPantallaInvalida pantallaCodigoInvalido = new FPantallaInvalida("El ID ingresado ya existe");
			pantallaCodigoInvalido.setModal(true);
			pantallaCodigoInvalido.setVisible(true);
		}
	}
	
	private void cancelar() {
		// Tal vez copiando el catalogo, y si se cancela la venta de la carga asignar esa copia,
		// seria una buena forma de también "reasignar el stock" de los productos cargados
		while (!venta.getListaVenta().isEmpty()) {
			ParProductoCantidad par = venta.getListaVenta().get(0);
			for (Object o : catalogoArray) {
				Producto producto = (Producto) o;
				if (producto.getCodigo() == par.getCodigoProducto()) {
					venta.quitarProducto(producto, par.getCantidad());
				}
			}
			
		}
		venta = null;
		this.setVisible(false);
	}
	
	public Venta getVentaCreadaFinal() {
		return venta;
	}
	
	public int getCodigoVenta() {
		return Integer.parseInt(codigoTxt.getText());
	}
}
