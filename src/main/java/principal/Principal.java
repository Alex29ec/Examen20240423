package principal;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import principal.vistas.PanelEjemplo;


public class Principal extends JFrame{
	static Principal instance = null;
	public static Principal getInstance() {
		if(instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	JTabbedPane panelTabbed;
	
	public Principal() {
		
		super("Gestion de centro educativo");
		this.setBounds(0,0,800,600);
		panelTabbed = new JTabbedPane();
		PanelEjemplo paneltabla= PanelEjemplo.getInstance();
		panelTabbed.add("PanelTabla",paneltabla);
	}
	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
	}
}
