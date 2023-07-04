package user.pantallasVenta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FPantalla1Dato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dato1txt;
	private static String msgString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FPantalla1Dato dialog = new FPantalla1Dato(msgString);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FPantalla1Dato(String msg) {
		msgString = msg;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel(msgString);
			lblNewLabel.setBounds(57, 84, 119, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			dato1txt = new JTextField();
			dato1txt.setBounds(186, 81, 86, 20);
			contentPanel.add(dato1txt);
			dato1txt.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void aceptar() {
		this.setVisible(false);
	}
	
	public int getDato() {
		if (dato1txt.getText().equals("")) {
			return -1;
		}else {
			return Integer.parseInt(dato1txt.getText());
		}
		
	}
}
