package principal.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.controladores.ControladorContratoJPA;
import principal.controladores.DatosDeTabla;
import principal.entidades.Contrato;


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
		this.dtm = getDefaultTableModelNoEditable();
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indiceFilaSel = table.getSelectedRow();		
				Object value = datosEnTabla[indiceFilaSel][0];
				Contrato estselecc = ControladorContratoJPA.getInstance().obtenerContratoPorId((Integer)value);
				PanelGestionContrato panelgc = new PanelGestionContrato(estselecc);
				JScrollPane scrollpane2 = new JScrollPane(panelgc);
				splitPane.setRightComponent(scrollpane2);
				splitPane.setResizeWeight(0.25);
			}
		});

	}
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}

}
