package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;

public class FrmSelectCargo extends JDialog{
	
	
	
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public static JScrollPane scrollPane = new JScrollPane();
	
	
	public FrmSelectCargo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\eclipse-workspace\\MenuProyectoMVC\\img\\sevillafc.jpg"));
		
				
		//setModal(true);
		setTitle("VENTANA SELECCION DE CARGOS");
		setBounds(0, 0, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setResizable(false);
		
		
		JButton btnSelect = new JButton("Seleccionar");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			});
							
			
				
		btnSelect.setBounds(160, 220, 120, 40);
		getContentPane().add(btnSelect);
		
		
		table = new JTable();
		//table.setBounds(50, 30, 350, 160);
		getContentPane().add(scrollPane);
		scrollPane.setBounds(50, 30, 350, 160);
		//getContentPane().add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		setVisible(true);
				
		
		
		}
	

}
