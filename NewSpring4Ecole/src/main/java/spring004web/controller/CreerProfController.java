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

import spring004web.bean.Prof;
import spring004web.services.IServiceProfs;

@Controller
public class CreerProfController {
	@Autowired
	private IServiceProfs prof;



	@RequestMapping(value="/afficherCreationListeProfs", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
	final List<Prof> lListeProfs = prof.rechercherProfs();
	pModel.addAttribute("listeProfs", lListeProfs);
	if (pModel.get("creationProf") == null) {
	pModel.addAttribute("creationProf", new CreationFormProf());
	}
	return "creationProf";
	}
	@RequestMapping(value="/creerCreationListeProfs", method = RequestMethod.POST)
	public String creer(@Valid @ModelAttribute(value="creationProf") final CreationFormProf pCreation,
	final BindingResult pBindingResult, final ModelMap pModel) {
		System.err.println(pBindingResult);
	if (!pBindingResult.hasErrors()) {
		System.err.println("PAS d'ERREUR");
		String pattern = "dd/MM/yyyy"; 		
		SimpleDateFormat sd = new SimpleDateFormat(pattern); 		
		sd.setLenient(false); 		
		Date date = new Date(); 		
		try { 	
			date = sd.parse(pCreation.getDate_naissance()); 			
			}catch(Exception e) { 	e.getStackTrace(); } 
		prof.creerProf(pCreation.getNom(), pCreation.getPrenom(), date, pCreation.getAdresse(), pCreation.getSexe());
		System.err.println("OK");
	}
	
	return afficher(pModel);
	}
}
