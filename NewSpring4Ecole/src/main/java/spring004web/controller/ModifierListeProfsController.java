package spring004web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
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
public class ModifierListeProfsController {
	@Autowired
	private IServiceProfs profs;

	@RequestMapping(value = "/afficherModificationListeProfs", method = RequestMethod.GET)

	public String afficher(final ModelMap pModel) {
		if (pModel.get("modificationProf") == null) {
			final List<Prof> lListeProfs = profs.rechercherProfs();
			final ModificationFormProf lModificationForm = new ModificationFormProf();
			final List<ModificationProf> lListeProf = new LinkedList<ModificationProf>();
			for (final Prof lProf : lListeProfs) {
				final ModificationProf lModificationProf = new ModificationProf();
				lModificationProf.setId(lProf.getId());
				lModificationProf.setNom(lProf.getNom());
				lModificationProf.setPrenom(lProf.getPrenom());
				lModificationProf.setDate_naissance(lProf.getDate_naissance().toString());
				lModificationProf.setAdresse(lProf.getAdresse());
				lModificationProf.setSexe(lProf.getSexe());
				lListeProf.add(lModificationProf);
			}
			lModificationForm.setListeProfs(lListeProf);
			pModel.addAttribute("modificationProf", lModificationForm);
		}
		return "modificationProf";
	}

	@RequestMapping(value = "/modifierModificationListeProfs", method = RequestMethod.POST)
	public String modifier(@Valid @ModelAttribute(value = "modificationProf") final ModificationFormProf pModification,
			final BindingResult pBindingResult, final ModelMap pModel) {
		if (!pBindingResult.hasErrors()) {
			final List<Prof> lListeProfs = new LinkedList<Prof>();
			for (final ModificationProf lModificationCourse : pModification.getListeProfs()) {
				final Prof lProf = new Prof();
				lProf.setId(lModificationCourse.getId());

				lProf.setId(lModificationCourse.getId());
				lProf.setNom(lModificationCourse.getNom());
				lProf.setPrenom(lModificationCourse.getPrenom());
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat sd = new SimpleDateFormat(pattern);
				sd.setLenient(false);
				try {
					lProf.setDate_naissance(sd.parse(lModificationCourse.getDate_naissance()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				lProf.setAdresse(lModificationCourse.getAdresse());
				lProf.setSexe(lModificationCourse.getSexe());

				lListeProfs.add(lProf);
			}
			profs.modifierProf(lListeProfs);
		}
		return afficher(pModel);
	}
}