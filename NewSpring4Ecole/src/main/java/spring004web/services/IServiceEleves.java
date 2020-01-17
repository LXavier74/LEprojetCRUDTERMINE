package spring004web.services;

import java.util.Date;
import java.util.List;

import spring004web.bean.Classe;
import spring004web.bean.Eleve;

public interface IServiceEleves {
	List<Eleve> rechercherEleves();
	void creerEleve(String nom, String prenom, Classe classe, Date date_naissance, String adresse, String sexe);

}
