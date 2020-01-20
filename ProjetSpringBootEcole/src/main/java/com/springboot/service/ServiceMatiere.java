package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Matiere;
import com.springboot.dao.DaoMatiere;

@Service
public class ServiceMatiere implements IServiceMatiere {

	@Autowired
	DaoMatiere daomatiere;

	@Transactional(readOnly = true)

	@Override
	public List<Matiere> rechercheMatiere() {
		// TODO Auto-generated method stub
		return daomatiere.findAll();
	}

	@Transactional(readOnly = true)

	@Override
	public Matiere rechercheMatiereId(int id) {
		// TODO Auto-generated method stub
		return daomatiere.findById(id).get();
	}

	@Transactional

	@Override
	public void creerMatiere(Matiere pmatiere) {
		// TODO Auto-generated method stub
		daomatiere.save(pmatiere);

	}

	@Transactional

	@Override
	public void modifierMatiere(Matiere pmatiere) {
		// TODO Auto-generated method stub
		daomatiere.save(pmatiere);

	}

	@Transactional
	@Override
	public void supprimerMatiere(Matiere pmatiere) {
		// TODO Auto-generated method stub
		daomatiere.deleteById(pmatiere.getId());
	}

}
