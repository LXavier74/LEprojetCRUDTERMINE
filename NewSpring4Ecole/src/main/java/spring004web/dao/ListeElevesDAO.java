package spring004web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import spring004web.bean.Eleve;

@Repository
public class ListeElevesDAO implements IEleveDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Eleve> rechercherEleves() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Eleve> lCriteriaQuery = lCriteriaBuilder.createQuery(Eleve.class);
		final Root<Eleve> lRoot = lCriteriaQuery.from(Eleve.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Eleve> lTypedQuery = entityManager.createQuery(lCriteriaQuery);		
		return lTypedQuery.getResultList();	}




	public void creerEleve(Eleve pEleve) {
		entityManager.persist(pEleve);
		
	}

}
