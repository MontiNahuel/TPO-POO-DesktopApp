package user.pantallasProducto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.producto.Producto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FIngresarProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtID;
	private JTextField txtDescripcion;
	private JTextField txtCantStockMinimo;
	
	private Producto producto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FIngresarProducto dialog = new FIngresarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FIngresarProducto() {
		setBounds(100, 100, 448, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre de Producto:");
			lblNewLabel.setBounds(31, 35, 121, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Precio:");
			lblNewLabel_1.setBounds(31, 66, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		txtNombre = new JTextField();
		txtNombre.setBounds(150, 32, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(150, 63, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ingresar ID:");
		lblNewLabel_2.setBounds(31, 97, 77, 14);
		contentPanel.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(150, 94, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_3.setBounds(31, 130, 77, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(150, 127, 86, 74);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ingresar stock minimo:");
		lblNewLabel_4.setBounds(31, 217, 108, 14);
		contentPanel.add(lblNewLabel_4);
		
		txtCantStockMinimo = new JTextField();
		txtCantStockMinimo.setBounds(150, 214, 86, 20);
		contentPanel.add(txtCantStockMinimo);
		txtCantStockMinimo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptarAgregarProducto();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelar();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void aceptarAgregarProducto() {
		
		int codigoProducto = Integer.parseInt(txtID.getText());
		String nombre = txtNombre.getText();
		String descripcion = txtDescripcion.getText();
		int precioUnitario = Integer.parseInt(txtPrecio.getText());
		int stockMinimo = Integer.parseInt(txtCantStockMinimo.getText());
		
		producto = new Producto(codigoProducto, descripcion, nombre, precioUnitario, stockMinimo);
		this.setVisible(false);
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	private void cancelar() {
		this.producto = null;
		this.setVisible(false);
	}
}
