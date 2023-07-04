package user.pantallasVenta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.venta.Venta;
import controller.venta.VentaCredito;
import controller.venta.VentaEfectivo;
import user.pantallasProducto.FPantallaInvalida;

import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FElegirTipoDeVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Venta v;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FElegirTipoDeVenta dialog = new FElegirTipoDeVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FElegirTipoDeVenta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnCredito = new JButton("Credito");
		btnCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				credito();
			}
		});
		btnCredito.setBounds(58, 79, 89, 23);
		contentPanel.add(btnCredito);
		
		JButton btnDebito = new JButton("Debito");
		btnDebito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debito();
			}
		});
		btnDebito.setBounds(157, 79, 89, 23);
		contentPanel.add(btnDebito);
		
		JButton btnEfectivo = new JButton("Efectivo");
		btnEfectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				efectivo();
			}
		});
		btnEfectivo.setBounds(256, 79, 89, 23);
		contentPanel.add(btnEfectivo);
		
		JLabel lblNewLabel = new JLabel("Tipo de Venta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 33, 287, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	
	private void efectivo() {
		Venta venta = new VentaEfectivo(0);
		v = venta;
		this.setVisible(false);
	}
	
	private void debito() {
		Venta venta = new Venta(0);
		v = venta;
		this.setVisible(false);
	}
	
	private void credito() {
		FPantalla1Dato pantallaAux = new FPantalla1Dato("Cantidad de Cuotas:"); // Validar la cantidad de cuotas
		pantallaAux.setModal(true);
		pantallaAux.setVisible(true);
		int cuotas = pantallaAux.getDato();
		if (cuotas == -1) {
			FPantallaInvalida pantallaInvalida = new FPantallaInvalida("Se debe introducir un numero de cuotas");
			pantallaInvalida.setModal(true);
			pantallaInvalida.setVisible(true);
		}else if (cuotas != 2 && cuotas != 3 && cuotas != 6) {
			FPantallaInvalida pantallaInvalida = new FPantallaInvalida("El numero de cuotas debe ser de 2, 3 o 6");
			pantallaInvalida.setModal(true);
			pantallaInvalida.setVisible(true);
		} else {
			Venta venta = new VentaCredito(cuotas, 0);
			v = venta;
			this.setVisible(false);
		}
	}
	
	public Venta getVentaCreada() {
		return v;
	}
	
	private void cancelar() {
		this.setVisible(false);
	}
}
