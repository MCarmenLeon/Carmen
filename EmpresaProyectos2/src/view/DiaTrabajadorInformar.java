package view;

import java.awt.Dialog;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * fecha 01/09/18
 * @author Carmen
 * informacion del trabajador que hemos seleccionado, mostramos los datos del trabajador
 */
public class DiaTrabajadorInformar extends JDialog {
	private static final long serialVersionUID = 1L;
	static Dialog cuadro;
	model.Proyecto proyect;
	public static TextField txtDni;
	public static TextField  txtNombre;
	public static TextField  txtApellidos;
	public static TextField  txtGenero;
		
	public DiaTrabajadorInformar() {
		setTitle("INFORMACIÓN DEL TRABAJADOR");
		setBounds(300, 50, 400, 400);
		setLayout(null);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		//Declaramos los labels...
		Label lblDni = new Label();
		lblDni.setText("DNI: ");
		lblDni.setBounds(10,50,90,20);
		Label lblNombre = new Label();
		lblNombre.setText("Nombre: ");
		lblNombre.setBounds(10,80,90,20);
		Label lblApellidos = new Label();
		lblApellidos.setText("Apellidos: ");
		lblApellidos.setBounds(10,120,90,20);
		Label lblGenero = new Label();
		lblGenero.setText("Género: ");
		lblGenero.setBounds(10,150,90,20);
		
		//Declaramos los TextField..
		txtDni = new TextField();
		txtDni.setBounds(150,50,150,20);
		txtNombre = new TextField();
		txtNombre.setBounds(150,80,150,20);
		txtApellidos = new TextField();
		txtApellidos.setBounds(150,120,150,20);
		txtGenero = new TextField();
		txtGenero.setBounds(150,150,150,20);
		
		//declaramos los botones...		
		JButton btnCancelar = new JButton();
		btnCancelar.setText("SALIR");
		btnCancelar.setBounds(170,300,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//añadimos los labels, textfields y botones a dialogo
		add(lblDni);
		add(lblNombre);
		add(lblApellidos);
		add(lblGenero);
		add(txtDni);
		add(txtNombre);
		add(txtApellidos);
		add(txtGenero);
		add(btnCancelar);
		setVisible(true);
	}

}
