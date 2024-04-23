package principal.controladores;

import java.util.List;

import principal.entidades.Contrato;


public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripcion", "Saldo", "Limite", "IdTipoContrato", "IdUsuario","Fecha Firma" };
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Contrato> personas = (List<Contrato>) ControladorContratoJPA.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Contrato persona = personas.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getDescripcion();
			datos[i][2] = persona.getSaldo();
			datos[i][3] = persona.getLimite();
			datos[i][4] = persona.getIdTipoContrato(); 	
			datos[i][5] = persona.getIdUsuario();
			datos[i][6] = persona.getFechaFirma();
		}
		
		return datos;
	}
	
	
}
