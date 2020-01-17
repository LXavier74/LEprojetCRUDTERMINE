package spring004web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import spring004web.bean.Prof;


@Repository
public class ListeProfDAO implements IProfDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Prof> rechercherProfs() {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Prof> lCriteriaQuery = lCriteriaBuilder.createQuery(Prof.class);
		final Root<Prof> lRoot = lCriteriaQuery.from(Prof.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Prof> lTypedQuery = entityManager.createQuery(lCriteriaQuery);		
		return lTypedQuery.getResultList();	
		}


	public void creerProf(Prof pProf) {
		System.err.println("DAO");
		entityManager.persist(pProf);

	}


	public void modifierProf(final Prof pProf) {
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Prof> lCriteriaUpdate =
		lCriteriaBuilder.createCriteriaUpdate(Prof.class);
		final Root<Prof> lRoot = lCriteriaUpdate.from(Prof.class);
		final Path<Prof> lPath = lRoot.get("id");
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pProf.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("nom", pProf.getNom());
		lCriteriaUpdate.set("prenom", pProf.getPrenom());
		lCriteriaUpdate.set("adresse", pProf.getAdresse());
		lCriteriaUpdate.set("date_naissance", pProf.getDate_naissance());
		lCriteriaUpdate.set("sexe", pProf.getSexe());		
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
		final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
		final String lSql = lHQuery.getQueryString();
		throw new RuntimeException("Nombre d'occurences (" + lRowCount +
		") modifiés différent de 1 pour " + lSql);
		}
		}


	public void supprimerProf(Prof pProf) {
		final Prof lProf = entityManager.getReference(Prof.class, pProf.getId());
		entityManager.remove(lProf);	
		System.err.println("ERREUR DANS LE DAO");
	}
}
