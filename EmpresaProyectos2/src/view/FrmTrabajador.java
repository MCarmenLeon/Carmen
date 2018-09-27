package view;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmTrabajador extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Dialog cuadro;
	public static JTable table;
	
	public FrmTrabajador() {	
		
		setTitle("TRABAJADOR");
		setBounds(300, 50, 400, 400);
		getContentPane().setLayout(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 82, 221, 118);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel(" LISTADO DE TRABAJADORES");
		lblNewLabel.setBounds(71, 36, 162, 23);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("NUEVO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlTrabajadores.mostrarNuevo();
			}
		});
		btnNewButton.setBounds(20, 264, 75, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmado = JOptionPane.showConfirmDialog(null,"¿Lo confirmas?","Confirmacion",
						JOptionPane.YES_NO_OPTION);

							if (JOptionPane.OK_OPTION == confirmado) {
								controller.CtrlTrabajadores.borrarTrabajador();
							}
			}
		});
		btnBorrar.setBounds(114, 264, 80, 23);
		getContentPane().add(btnBorrar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(205, 264, 75, 23);
		getContentPane().add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.editarTrabajador();
			}
		});
			
		
		JButton btnInfo = new JButton("INFO");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.editarTrabajadorInfo();
				
			}
		});
		btnInfo.setBounds(284, 264, 75, 23);
		getContentPane().add(btnInfo);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		
		setVisible(true);
	}


}
