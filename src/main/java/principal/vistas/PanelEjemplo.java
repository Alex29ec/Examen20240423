package principal.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.controladores.DatosDeTabla;


public class PanelEjemplo extends JPanel {
	public Object[][] getDatosEnTabla() {
		return datosEnTabla;
	}

	public void setDatosEnTabla(Object[][] datosEnTabla) {
		this.datosEnTabla = datosEnTabla;
	}


	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();

	private static final long serialVersionUID = 1L;
	private JTable table;
	
	private static PanelEjemplo instance = null;


	public static PanelEjemplo getInstance() {
		if(instance == null ) {
			instance = new PanelEjemplo()
;		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public PanelEjemplo() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();		
				Object value = datosEnTabla[indiceFilaSel][0];
				Estudiante estselecc = ControladorEstudianteJPA.getInstance().obtenerEstudiantePorId((Integer)value);
				PanelEstudiante2 panelestudiante2 = new PanelEstudiante2(estselecc);
				JScrollPane scrollpane2 = new JScrollPane(panelestudiante2);
				splitPane.setRightComponent(scrollpane2);
				splitPane.setResizeWeight(0.25);
			}
		});

	}

}
