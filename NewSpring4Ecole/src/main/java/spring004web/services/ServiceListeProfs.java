package spring004web.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Prof;
import spring004web.dao.IProfDAO;

@Service
public class ServiceListeProfs implements IServiceProfs {
	@Autowired
	private IProfDAO dao;
	
	@Transactional(readOnly=true)
	public List<Prof> rechercherProfs() {
		// TODO Auto-generated method stub
		return dao.rechercherProfs();}
	
	@Transactional
	public void creerProf(String pNom, String pPrenom, Date date_naissance, String adresse, String sexe) {
		final Prof lProf = new Prof();
		lProf.setNom(pNom);
		lProf.setPrenom(pPrenom);
		lProf.setDate_naissance(date_naissance);
		lProf.setAdresse(adresse);
		lProf.setSexe(sexe);
		System.err.println(lProf);
		dao.creerProf(lProf);
	}

	@Transactional
	public void modifierProf(final List<Prof> pListeProfs) {
	for (final Prof lProf : pListeProfs) {
	dao.modifierProf(lProf);
	}
}
	@Transactional
	public void supprimerProf(Integer pIdProf) {
		final Prof lProf = new Prof();
		lProf.setId(pIdProf);
		dao.supprimerProf(lProf);	
System.err.println("ERREUR DANS LE SERVICE");
	}
}


