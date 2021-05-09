package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import uppa.m1bigdata.devweb.pojo.D�;

public class DesDaoImpl  implements DAO<D�> {

	private EntityManager em;
	
	
	public DesDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public D� find(int id) throws DAOException {
		D� de=em.find(D�.class, id);
		return de;
	}

	@Override
	public void create(D� data) throws DAOException {
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(D� data) throws DAOException {
		em.getTransaction().begin();
		em.merge(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(D� data) throws DAOException {
		em.getTransaction().begin();
		em.remove(data);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<D�> getAll() throws DAOException {
		List<D�> d�s=em.createQuery("select d from Joueur d").getResultList();
		return d�s;
	}



}
