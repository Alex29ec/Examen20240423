package principal.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import principal.entidades.Contrato;
import principal.entidades.Entidad;
import principal.entidades.Usuario;


public class ControladorUsuarios {
	private static String nombreTabla = "usuario";


private static EntityManager em =  Persistence.createEntityManagerFactory("Banco").createEntityManager();

	
	public static List<Usuario> findAll() {
		return (List<Usuario>) em.createNativeQuery("SELECT * FROM " + nombreTabla, Usuario.class)
				.getResultList();
	}
	
	public static Entidad findArtById(int id) {
		try {
			Usuario entidad = (Usuario) em.find(Usuario.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void update(Usuario e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
}
