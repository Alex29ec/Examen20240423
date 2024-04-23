package principal.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import principal.entidades.Contrato;

public class ControladorContratoJPA extends SuperControladorJPA{
	String nombreTabla="contrato";
	private static EntityManager em =  Persistence.createEntityManagerFactory("Banco").createEntityManager();

	
	static ControladorContratoJPA instance = null;
	
	public static ControladorContratoJPA getInstance() {
		if (instance == null) {
			instance = new ControladorContratoJPA("contrato",Contrato.class);
		}
		return instance;
	}
	public static Contrato findArtById(int id) {
		try {
			Contrato entidad = (Contrato) em.find(Contrato.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ControladorContratoJPA(String nombreTabla, Class tipoEntidad) {
		super(nombreTabla, tipoEntidad);
		// TODO Auto-generated constructor stub
	}
	public Contrato obtenerContratoPorId(int idEstudiante) {
        return  (Contrato) getEntityManager().createNativeQuery("SELECT * FROM contrato where id = " + idEstudiante, Contrato.class).getSingleResult();
    }

	

	
}
