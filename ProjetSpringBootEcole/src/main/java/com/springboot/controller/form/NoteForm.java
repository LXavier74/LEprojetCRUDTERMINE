package com.springboot.controller.form;

import javax.validation.constraints.NotEmpty;

public class NoteForm {
	private Integer id;
	@NotEmpty
	private String date_saisie;
	@NotEmpty

	private String ideleve;
	@NotEmpty

	private String idmatiere;
	@NotEmpty

	private String idtrimestre;
	@NotEmpty

	private String idprof;
	@NotEmpty

	private String idclasse;
	@NotEmpty

	private String avis;
	@NotEmpty

	private String note;
	@NotEmpty

	private String avancement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate_saisie() {
		return date_saisie;
	}

	public void setDate_saisie(String date_saisie) {
		this.date_saisie = date_saisie;
	}

	public String getIdeleve() {
		return ideleve;
	}

	public void setIdeleve(String ideleve) {
		this.ideleve = ideleve;
	}

	public String getIdmatiere() {
		return idmatiere;
	}

	public void setIdmatiere(String idmatiere) {
		this.idmatiere = idmatiere;
	}

	public String getIdtrimestre() {
		return idtrimestre;
	}

	public void setIdtrimestre(String idtrimestre) {
		this.idtrimestre = idtrimestre;
	}

	public String getIdprof() {
		return idprof;
	}

	public void setIdprof(String idprof) {
		this.idprof = idprof;
	}

	public String getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(String idclasse) {
		this.idclasse = idclasse;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAvancement() {
		return avancement;
	}

	public void setAvancement(String avancement) {
		this.avancement = avancement;
	}
}
