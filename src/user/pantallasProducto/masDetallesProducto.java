package user.pantallasProducto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.producto.Producto;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class masDetallesProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Producto producto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			masDetallesProducto dialog = new masDetallesProducto(producto);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public masDetallesProducto(Producto p) {
		producto = p;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(71, 41, 102, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel nombreLabel = new JLabel(producto.getNombre());
		nombreLabel.setBounds(183, 41, 170, 14);
		contentPanel.add(nombreLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(71, 66, 102, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Stock Minimo:");
		lblNewLabel_3.setBounds(71, 91, 102, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock Disponible:");
		lblNewLabel_4.setBounds(71, 116, 102, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setBounds(71, 141, 102, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel idLabel = new JLabel(Integer.toString(producto.getCodigo()));
		idLabel.setBounds(183, 66, 102, 14);
		contentPanel.add(idLabel);
		
		JLabel stockMinimoLabel = new JLabel(Integer.toString(producto.getStateStock().getStockMinimo()));
		stockMinimoLabel.setBounds(183, 91, 102, 14);
		contentPanel.add(stockMinimoLabel);
		
		JLabel stockDisponibleLabel = new JLabel(Integer.toString(producto.getStateStock().getCantidadStock()));
		stockDisponibleLabel.setBounds(183, 116, 102, 14);
		contentPanel.add(stockDisponibleLabel);
		
		JLabel descripcionLabel = new JLabel(producto.getDescripcion());
		descripcionLabel.setBounds(183, 141, 170, 14);
		contentPanel.add(descripcionLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	private void aceptar() {
		this.setVisible(false);
	}
}
