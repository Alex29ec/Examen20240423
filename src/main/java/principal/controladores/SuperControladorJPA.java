package principal.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import principal.entidades.Entidad;


public class SuperControladorJPA {
	private String nombreTabla = "¡";
	private Class tipoEntidad;
	private static EntityManager em = null; 
	
	
	public SuperControladorJPA(String nombreTabla,Class tipoEntidad) {
		this.nombreTabla=nombreTabla;
		this.tipoEntidad=tipoEntidad;
	}
	
	
	public List<? extends Entidad> findAll() {		
		return (List<Entidad>)getEntityManager().createNativeQuery
				("SELECT * FROM "+ nombreTabla+";", this.tipoEntidad).getResultList();
		
	}
	
	protected static EntityManager getEntityManager() {
		if (em == null) {
		em = Persistence.createEntityManagerFactory("Banco").createEntityManager();
		}
		return em;
		}
	
	public static void insert(Entidad e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public static void update(Entidad e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public static void delete(Entidad e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
	
	
}
