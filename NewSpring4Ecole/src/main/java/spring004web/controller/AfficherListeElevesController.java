package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.bean.Eleve;
import spring004web.services.IServiceEleves;

@Controller
@RequestMapping(value = "/afficherListeEleves")
public class AfficherListeElevesController {
	@Autowired
	private IServiceEleves service;

	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Eleve> lListeEleves = service.rechercherEleves();
		pModel.addAttribute("listeEleves", lListeEleves);
		return "listeEleves";
	}
}
