package uppa.m1bigdata.devweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import uppa.m1bigdata.devweb.pojo.Dé;

public class DesDaoImpl  implements DAO<Dé> {

	private EntityManager em;
	
	
	public DesDaoImpl() {
		em = CulDeChouetteEntityManager.getInstance().getEntityManager();
	}

	@Override
	public Dé find(int id) throws DAOException {
		Dé de=em.find(Dé.class, id);
		return de;
	}

	@Override
	public void create(Dé data) throws DAOException {
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(Dé data) throws DAOException {
		em.getTransaction().begin();
		em.merge(data);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Dé data) throws DAOException {
		em.getTransaction().begin();
		em.remove(data);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dé> getAll() throws DAOException {
		List<Dé> dés=em.createQuery("select d from Joueur d").getResultList();
		return dés;
	}



}
