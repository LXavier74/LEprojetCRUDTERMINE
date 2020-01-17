package spring004web.dao;

import java.util.List;


import spring004web.bean.Classe;

public interface IClasseDAO  {
	List<Classe> rechercherClasses();
	public Classe rechercheClasseId(final int id);

}
