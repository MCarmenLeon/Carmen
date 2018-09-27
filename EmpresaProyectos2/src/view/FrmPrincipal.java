package view;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;

/**
 * 
 * @author Carmen
 * mostramos la ventana principal donde están los menus de proyecto, trabajador y equipos
 */
public class FrmPrincipal extends Frame{
	
	private static final long serialVersionUID = 1L;
	
	static Dialog cuadro;
	public static MenuItem opAyuda;
	
	
	public FrmPrincipal() {
		crearFrame();
		//cargarAyuda();
		setVisible(true);
	}

	private void crearFrame() {
		
		MenuItem opProyect = new MenuItem("Proyectos");
		opProyect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyectos.inicio();
			}
		});
		
		MenuItem opTrabajador = new MenuItem("Trabajadores");
		opTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.inicio();
			}
		});
		
		MenuItem opSalir = new MenuItem("Salir");
		opSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmado = JOptionPane.showConfirmDialog(null,"¿Lo confirmas?","Abandona Aplicación",
						JOptionPane.YES_NO_OPTION);

							if (JOptionPane.OK_OPTION == confirmado) {
								System.exit(0);
							}
			}
		});
		
		MenuItem opEquipos = new MenuItem("Equipos");
		opEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.Equipo();
			}
		});
		
		MenuItem opAyuda = new MenuItem("Ayuda");
		opEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarAyuda();
				} catch (MalformedURLException e1) {
					
					e1.printStackTrace();
				} catch (HelpSetException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		Menu mnuAyuda;
	    new MenuItem("Ayuda");
		Menu mnuBase = new Menu ("BASE");
		mnuBase.add(opProyect);
		mnuBase.add(opTrabajador);
		mnuBase.addSeparator();
		mnuBase.add(opSalir);
		
		Menu mnuGest = new Menu ("GESTIÓN");
		mnuGest.add(opEquipos);
		
		mnuAyuda = new Menu ("AYUDA");
		mnuAyuda.add(opAyuda);
		
		MenuBar barraMenu = new MenuBar();
		barraMenu.add(mnuBase);
		barraMenu.add(mnuGest);
		barraMenu.add(mnuAyuda);

		setTitle("GESTIÓN EMPRESA ACME");
		setBounds(300, 0, 400, 300);
		setLayout(null);
		setResizable(false);
		setMenuBar(barraMenu);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
										System.exit(0);
										
			}
		});
	
	}
	
	private void cargarAyuda() throws MalformedURLException, HelpSetException {
		
		//carga el fichero ayuda

			File fichero = new File("help/help.hs");
			URL hsURL;
		
			hsURL = fichero.toURI().toURL();
		

			// Crea el HelpSet y el HelpBroker
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();

			// Poner ayuda a item de menu al pulsarlo y a F1 en ventana
			// principal 

			hb.enableHelpOnButton(opAyuda, "aplicacion", helpset);
			//hb.enableHelpKey(, "aplicacion",helpset);
	
	}
}



