package spring004web.services;

import java.util.Date;
import java.util.List;

import spring004web.bean.Prof;

public interface IServiceProfs {
	List<Prof> rechercherProfs();
	void creerProf(final String pNom, final String pPrenom, Date date_naissance, String adresse, String sexe);
	void modifierProf(final List<Prof> pListeProfs);
	void supprimerProf(final Integer pIdProf);

}
