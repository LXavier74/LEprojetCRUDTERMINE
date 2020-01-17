package spring004web.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring004web.bean.Classe;
import spring004web.bean.Eleve;
import spring004web.dao.IEleveDAO;

@Service
public class ServiceListeEleves implements IServiceEleves {
@Autowired
private IEleveDAO dao;
@Transactional(readOnly=true)
public List<Eleve> rechercherEleves() {
	// TODO Auto-generated method stub
	return dao.rechercherEleves();}

public void creerEleve(String nom, String prenom, Classe classe, Date date_naissance, String adresse, String sexe) {
	// TODO Auto-generated method stub
	final Eleve lCourse = new Eleve();
	lCourse.setNom(nom);
	lCourse.setPrenom(prenom);
	lCourse.setClasse(classe);
	lCourse.setDate_naissance(date_naissance);
	lCourse.setAdresse(adresse);
	lCourse.setSexe(sexe);
	dao.creerEleve(lCourse);	
}

	
}
	


