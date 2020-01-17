package spring004web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import spring004web.bean.Classe;

	


public class ListeClasseDAO  {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Classe> rechercherEleves() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Classe> lCriteriaQuery = lCriteriaBuilder.createQuery(Classe.class);
		final Root<Classe> lRoot = lCriteriaQuery.from(Classe.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Classe> lTypedQuery = entityManager.createQuery(lCriteriaQuery);		
		return lTypedQuery.getResultList();	}




	public void creerClasse(Classe pClasse) {
		entityManager.persist(pClasse);
		
	}

}
