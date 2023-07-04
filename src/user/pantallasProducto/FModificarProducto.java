package user.pantallasProducto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.producto.Producto;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FModificarProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static Producto p;
	private JTextField idtxt;
	private JTextField nombretxt;
	private JTextField preciotxt;
	private JTextField stockminimotxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FModificarProducto dialog = new FModificarProducto(p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FModificarProducto(Producto p) {
		this.p = p;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		idtxt = new JTextField();
		idtxt.setBounds(111, 28, 86, 20);
		contentPanel.add(idtxt);
		idtxt.setColumns(10);
		idtxt.setText(Integer.toString(p.getCodigo()));
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(10, 31, 46, 14);
		contentPanel.add(idlabel);
		
		JLabel nombrelabel = new JLabel("Nombre:");
		nombrelabel.setBounds(10, 62, 46, 14);
		contentPanel.add(nombrelabel);
		
		nombretxt = new JTextField();
		nombretxt.setBounds(111, 59, 86, 20);
		contentPanel.add(nombretxt);
		nombretxt.setColumns(10);
		nombretxt.setText(p.getNombre());
		
		preciotxt = new JTextField();
		preciotxt.setBounds(111, 90, 86, 20);
		contentPanel.add(preciotxt);
		preciotxt.setColumns(10);
		preciotxt.setText(Float.toString(p.getPrecioUnitario()));
		
		stockminimotxt = new JTextField();
		stockminimotxt.setBounds(111, 121, 86, 20);
		contentPanel.add(stockminimotxt);
		stockminimotxt.setColumns(10);
		stockminimotxt.setText(Integer.toString(p.getStateStock().getStockMinimo()));
		
		JLabel preciolabel = new JLabel("Precio:");
		preciolabel.setBounds(10, 93, 46, 14);
		contentPanel.add(preciolabel);
		
		JLabel lblNewLabel_3 = new JLabel("Stock Minimo:");
		lblNewLabel_3.setBounds(10, 124, 91, 14);
		contentPanel.add(lblNewLabel_3);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(111, 154, 86, 74);
		contentPanel.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
		lblNewLabel.setBounds(10, 184, 78, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
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
	}
	
	private void aceptar() {
		p.setCodigo(Integer.parseInt(idtxt.getText()));
		p.setNombre(nombretxt.getText());
		p.setPrecioUnitario(Integer.parseInt(preciotxt.getText()));
		p.getStateStock().setStockMinimo(Integer.parseInt(stockminimotxt.getText()));
		this.setVisible(false);
	}
	
	private void cancelar() {
		this.setVisible(false);
	}
}
