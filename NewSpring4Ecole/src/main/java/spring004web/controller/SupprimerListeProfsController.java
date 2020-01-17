package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring004web.bean.Prof;
import spring004web.services.IServiceProfs;

@Controller
public class SupprimerListeProfsController {
	@Autowired
	private IServiceProfs profs;

	@RequestMapping(value = "/afficherSuppressionListeProfs", method = RequestMethod.GET)
	public String afficher(final ModelMap pModel) {
		final List<Prof> lListeProfs = profs.rechercherProfs();
		pModel.addAttribute("listeProfs", lListeProfs);
		return "suppressionProf";
	}

	@RequestMapping(value = "/supprimerSuppressionListeProfs", method = RequestMethod.GET)
	public String supprimer(@RequestParam(value = "id") final Integer pIdProf, final ModelMap pModel) {

		profs.supprimerProf(pIdProf);
System.err.println("ERREUR");
		return afficher(pModel);
	}
}