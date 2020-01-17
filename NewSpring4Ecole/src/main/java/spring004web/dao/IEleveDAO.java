package spring004web.dao;

import java.util.List;

import spring004web.bean.Eleve;


public interface IEleveDAO {
	List<Eleve> rechercherEleves();
	void creerEleve(final Eleve pEleve);

}
