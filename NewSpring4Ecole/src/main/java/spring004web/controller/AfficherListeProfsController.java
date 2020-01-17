package spring004web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring004web.bean.Prof;
import spring004web.services.IServiceProfs;

@Controller
@RequestMapping(value = "/afficherListeProfs")
public class AfficherListeProfsController {
	@Autowired
	private IServiceProfs service;

	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Prof> lListeProfs = service.rechercherProfs();
		pModel.addAttribute("listeProfs", lListeProfs);
		return "listeProfs";
	}
}