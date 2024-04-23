package principal.controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import principal.entidades.Entidad;
import principal.entities.Articulo;


public class SuperControladorJPA {
	private String nombreTabla = "";
	private Class tipoEntidad;
	private static EntityManager em = null; 
	
	
	public static Articulo findById(int id) {
		try {
			Articulo entidad = (Articulo) em.find(Articulo.class, id);
			return entidad;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
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
		em = Persistence.createEntityManagerFactory("").createEntityManager();
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
	
	
	public static Articulo getPrimero() {
		Query q  = em.createNativeQuery("Select min(id) from "  + nombreTabla);
		int primerId = (int) q.getSingleResult();
		Articulo c = em.find(Articulo.class, primerId);
		return c;
	}
	
	public static Articulo getUltimo() {
		Query q  = em.createNativeQuery("Select max(id) from "  + nombreTabla);
		int primerId = (int) q.getSingleResult();
		Articulo c = em.find(Articulo.class, primerId);
		return c;
	}
	
	public static Articulo getSiguiente(int id) {
	    Articulo c = null;
	    Query q = em.createNativeQuery("SELECT MIN(id) FROM " + nombreTabla + " WHERE id > ?id");
	    q.setParameter("id", id);
	    Integer siguienteId = (Integer) q.getSingleResult();
	    
	    if (siguienteId != null) {
	        c = em.find(Articulo.class, siguienteId);
	    } else {
	        c = getPrimero();
	    }
	    
	    return c;
	}


	
	public static Articulo getAnterior(int id) {
	    Articulo c = null;
	    Query q = em.createNativeQuery("SELECT MAX(id) FROM " + nombreTabla + " WHERE id < ?id");
	    q.setParameter("id", id);
	    Integer anteriorId = (Integer) q.getSingleResult();
	    
	    if (anteriorId != null) {
	        c = em.find(Articulo.class, anteriorId);
	    } else {
	        c = getUltimo();
	    }
	    
	    return c;
	}
}
