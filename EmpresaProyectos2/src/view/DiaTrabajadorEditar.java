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
 * 
 * @author Carmen
 * mostramos el dialogo cuando damos a editar a un trabajador y mostramos sus datos para modificar
 *
 */

public class DiaTrabajadorEditar extends JDialog{
	private static final long serialVersionUID = 1L;
	static Dialog cuadro;
	model.Trabajador trabajo;
	public static TextField txtDni, txtNombre, txtApellidos, txtGenero;
		
	public DiaTrabajadorEditar() {
		setTitle("EDITAR TRABAJADOR");
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
		lblGenero.setText("Genero: ");
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
		
		//Declaramos los botones....
		JButton btnGuardar = new JButton();
		btnGuardar.setText("GUARDAR");
		
		btnGuardar.setBounds(30,300,100,30);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.opcGuardarExsitente();
				dispose();				
			}
		});
		
		JButton btnCancelar = new JButton();
		btnCancelar.setText("CANCELAR");
		btnCancelar.setBounds(170,300,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		add(lblDni);
		add(lblNombre);
		add(lblApellidos);
		add(lblGenero);
		add(txtDni);
		add(txtNombre);
		add(txtApellidos);
		add(txtGenero);
		add(btnGuardar);
		add(btnCancelar);
		setVisible(true);
		
	}


}
