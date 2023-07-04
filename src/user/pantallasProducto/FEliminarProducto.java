package user.pantallasProducto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEliminarProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtid;
	
	private int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FEliminarProducto dialog = new FEliminarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FEliminarProducto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID del Producto:");
			lblNewLabel.setBounds(36, 36, 100, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtid = new JTextField();
			txtid.setBounds(146, 33, 86, 20);
			contentPanel.add(txtid);
			txtid.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
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
				JButton cancelButton = new JButton("Cancel");
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
		id = Integer.parseInt(txtid.getText());
		this.setVisible(false);
	}
	
	public int getID() {
		return id;
	}
	
	private void cancelar() {
		id = -1;
		this.setVisible(false);
	}
}
