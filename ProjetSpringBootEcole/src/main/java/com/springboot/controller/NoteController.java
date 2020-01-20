package com.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.bean.Classe;
import com.springboot.bean.Eleve;
import com.springboot.bean.Matiere;
import com.springboot.bean.Note;
import com.springboot.bean.Professeur;
import com.springboot.controller.form.NoteForm;
import com.springboot.service.IServiceMatiere;
import com.springboot.service.IServiceNotes;
import com.springboot.service.iServiceClasse;
import com.springboot.service.iServiceEleve;
import com.springboot.service.iServiceProfesseur;

@Controller
public class NoteController {
	@Autowired
	IServiceMatiere servicematiere;
	@Autowired

	iServiceProfesseur serviceprof;
	@Autowired
	iServiceEleve serviceeleve;
	@Autowired

	iServiceClasse serviceclasse;
	@Autowired

	IServiceNotes serviceNote;

	private Note convertForm(NoteForm noteform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date madate = sdf.parse(noteform.getDate_saisie());

		Note pcnote = new Note();

		Professeur idprof = serviceprof.rechercheProfId(Integer.valueOf(noteform.getIdprof()));
		Eleve ideleve = serviceeleve.rechercheEleveId(Integer.valueOf(noteform.getIdeleve()));
		Matiere idmatiere = servicematiere.rechercheMatiereId(Integer.valueOf(noteform.getIdmatiere()));
		Classe idclasse = serviceclasse.rechercheClasseId(Integer.valueOf(noteform.getIdclasse()));

		pcnote.setId(noteform.getId());
		pcnote.setDate_saisie(madate);
		pcnote.setNote(Integer.valueOf(noteform.getNote()));
		pcnote.setIdtrimestre(Integer.valueOf(noteform.getIdtrimestre()));
		pcnote.setAvancement(Float.valueOf(noteform.getAvancement()));
		pcnote.setAvis(noteform.getAvis());
		pcnote.setIdclasse(idclasse);
		pcnote.setIdprof(idprof);
		pcnote.setIdeleve(ideleve);
		pcnote.setIdmatiere(idmatiere);

		return pcnote;
	}

	@GetMapping("/afficherCreerNotes")
	public String getAffiche(Model pmodel) {

		List<Classe> lclasse = serviceclasse.rechercheClasse();
		List<Professeur> lprof = serviceprof.rechercheProf();
		List<Eleve> leleve = serviceeleve.rechercheEleve();
		List<Matiere> lmatiere = servicematiere.rechercheMatiere();
		List<Note> lnote = serviceNote.rechercheNote();

		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeprof", lprof);
		pmodel.addAttribute("listeeleve", leleve);
		pmodel.addAttribute("listematiere", lmatiere);
		pmodel.addAttribute("listenote", lnote);

		pmodel.addAttribute("action", "CreerNote");
		if (pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(0);
			pmodel.addAttribute("noteform", noteform);
		}
		return "notes";
	}

	@GetMapping("/SupprimerNote/{id}")
	public String getSupprimer(@PathVariable final Integer id, Model pmodel) {
		Note pnote = serviceNote.rechercheNoteId(id);
		if (pnote != null) {
			serviceNote.supprimerNote(pnote);
			;
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/CreerNote")
	public String ajoutNote(@Valid @ModelAttribute(name = "noteform") NoteForm noteform, BindingResult presult,
			Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Note pnote = convertForm(noteform);
				serviceNote.creerNote(pnote);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@PostMapping("/ModifierNote")
	public String modifieNote(@Valid @ModelAttribute(name = "noteform") NoteForm noteform, BindingResult presult,
			Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				Note pnote = convertForm(noteform);
				serviceNote.modifierNote(pnote);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

	@GetMapping("/afficherModifierNote/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		Note pnote = serviceNote.rechercheNoteId(id);
		List<Classe> lclasse = serviceclasse.rechercheClasse();
		List<Professeur> lprof = serviceprof.rechercheProf();
		List<Eleve> leleve = serviceeleve.rechercheEleve();
		List<Matiere> lmatiere = servicematiere.rechercheMatiere();
		List<Note> lnote = serviceNote.rechercheNote();

		pmodel.addAttribute("listeclasse", lclasse);
		pmodel.addAttribute("listeprof", lprof);
		pmodel.addAttribute("listeeleve", leleve);
		pmodel.addAttribute("listematiere", lmatiere);
		pmodel.addAttribute("listenote", lnote);
		pmodel.addAttribute("action", "ModifierNote");
		if (pmodel.containsAttribute("noteform") == false) {
			NoteForm noteform = new NoteForm();
			noteform.setId(pnote.getId());
			noteform.setDate_saisie(new SimpleDateFormat("dd/MM/yyyy").format(pnote.getDate_saisie()));
			noteform.setIdeleve(String.valueOf(pnote.getIdeleve().getId()));

			noteform.setIdclasse(String.valueOf(pnote.getIdclasse().getId()));
			noteform.setIdmatiere(String.valueOf(pnote.getIdmatiere().getId()));
			noteform.setIdprof(String.valueOf(pnote.getIdprof().getId()));

			noteform.setIdtrimestre(String.valueOf(pnote.getIdtrimestre()));
			noteform.setNote(String.valueOf(pnote.getNote()));
			noteform.setAvancement(String.valueOf(pnote.getAvancement()));
			noteform.setAvis(pnote.getAvis());

			pmodel.addAttribute("noteform", noteform);
		}
		return "notes";
	}
}
