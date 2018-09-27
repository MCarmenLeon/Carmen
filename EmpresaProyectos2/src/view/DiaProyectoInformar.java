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
 * fecha: 01/09/2018
 * @author Carmen
 * informacion del proyecto que hemos seleccionado, mostramos los datos del proyecto
 */

public class DiaProyectoInformar extends JDialog {
	private static final long serialVersionUID = 1L;
	static Dialog cuadro;
	model.Proyecto proyect;
	public static TextField txtNombre, txtPresupuesto, txtFechaIni, txtFechaFin;
		
	public DiaProyectoInformar() {
		setTitle("INFORMACIÓN DEL PROYECTO");
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
		Label lblNombre = new Label();
		lblNombre.setText("Nombre: ");
		lblNombre.setBounds(10,50,90,20);
		Label lblPresupuesto = new Label();
		lblPresupuesto.setText("Presupuesto: ");
		lblPresupuesto.setBounds(10,80,90,20);
		Label lblFechaIni = new Label();
		lblFechaIni.setText("Fecha Inicio: ");
		lblFechaIni.setBounds(10,120,90,20);
		Label lblFechaFin = new Label();
		lblFechaFin.setText("Fecha Final: ");
		lblFechaFin.setBounds(10,150,90,20);
		
		//Declaramos los TextField..
		txtNombre = new TextField();
		txtNombre.setBounds(150,50,150,20);
		txtPresupuesto = new TextField();
		txtPresupuesto.setBounds(150,80,150,20);
		txtFechaIni = new TextField();
		txtFechaIni.setBounds(150,120,150,20);
		txtFechaFin = new TextField();
		txtFechaFin.setBounds(150,150,150,20);
		
		//declaramos los botones...
		JButton btnCancelar = new JButton();
		btnCancelar.setText("SALIR");
		btnCancelar.setBounds(170,300,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		//añadimos los labels, txtfields y botones al cuadro de dialogo...
		add(lblNombre);
		add(lblPresupuesto);
		add(lblFechaIni);
		add(lblFechaFin);
		add(txtNombre);
		add(txtPresupuesto);
		add(txtFechaIni);
		add(txtFechaFin);
		add(btnCancelar);
		setVisible(true);
		
	}

}
