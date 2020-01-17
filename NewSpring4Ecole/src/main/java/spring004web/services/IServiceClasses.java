package spring004web.services;

import java.util.List;

import spring004web.bean.Classe;

public interface IServiceClasses {
	List<Classe> rechercherClasses();
	public Classe rechercheClasseId(final int id);

}
