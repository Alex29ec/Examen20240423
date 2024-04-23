package principal;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import principal.vistas.PanelEjemplo;


public class Principal extends JFrame{
	static Principal instance = null;
	PanelEjemplo panel = new PanelEjemplo();
	public static Principal getInstance() {
		if(instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	JTabbedPane panelTabbed;
	
	public Principal() {
		super("Gestion de Articulo");
		this.setBounds(0,0,800,600);
		this.getContentPane().add(panel);
		
		
	}
	
	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
	}
}
