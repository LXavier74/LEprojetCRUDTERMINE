package spring004web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import spring004web.bean.Classe;
import spring004web.bean.Eleve;
import spring004web.services.IServiceClasses;
import spring004web.services.IServiceEleves;

@Controller
public class CreerListeElevesController {
	@Autowired
	private IServiceClasses serviceclasse;
	@Autowired
	private IServiceEleves eleve;


	@RequestMapping(value="/afficherCreationListeEleves", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
	final List<Eleve> lListeEleves = eleve.rechercherEleves();
	pModel.addAttribute("listeEleves", lListeEleves);
	if (pModel.get("creation") == null) {
	pModel.addAttribute("creation", new CreationForm());
	}
	return "creation";
	}
	@RequestMapping(value="/creerCreationListeEleves", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation,
	final BindingResult pBindingResult, final ModelMap pModel) {
	if (!pBindingResult.hasErrors()) {
		String pattern = "dd/MM/yyyy"; 		
		SimpleDateFormat sd = new SimpleDateFormat(pattern); 		
		sd.setLenient(false); 		
		Date date = new Date(); 		
		try { 	
			date = sd.parse(pCreation.getDate_naissance()); 			
			}catch(Exception e) { 	e.getStackTrace(); } 
		Integer classInt = pCreation.getId();
	//eleve.creerEleve(pCreation.getNom(), pCreation.getPrenom(), pCreation.getClasse(), date, pCreation.getAdresse(), pCreation.getSexe());
	}
	return afficher(pModel);
	}
}




