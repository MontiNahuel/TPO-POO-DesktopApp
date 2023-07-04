package user.pantallasVenta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.venta.Venta;

import javax.swing.JLabel;
import javax.swing.JList;

public class FMasDetallesVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Venta venta;
	private JList listaProductos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FMasDetallesVenta dialog = new FMasDetallesVenta(venta);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FMasDetallesVenta(Venta v) {
		venta = v;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(97, 50, 101, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel(Integer.toString(venta.getCodigoVenta()));
			lblNewLabel_1.setBounds(208, 50, 93, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tipo:");
			lblNewLabel_2.setBounds(97, 75, 46, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Valor:");
			lblNewLabel_3.setBounds(97, 100, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Productos comprados:");
			lblNewLabel_4.setBounds(97, 125, 152, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel tipoLabel = new JLabel(venta.obtenerTipoVenta());
			tipoLabel.setBounds(208, 75, 93, 14);
			contentPanel.add(tipoLabel);
		}
		{
			JLabel valorLabel = new JLabel(Float.toString(venta.calcularPrecioDeVenta()));
			valorLabel.setBounds(208, 100, 93, 14);
			contentPanel.add(valorLabel);
		}
		
		JList listProductosComprados = new JList();
		this.listaProductos = listProductosComprados;
		listaProductos.setListData(venta.getListaVenta().toArray());
		listProductosComprados.setBounds(96, 149, 205, 68);
		contentPanel.add(listProductosComprados);
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
