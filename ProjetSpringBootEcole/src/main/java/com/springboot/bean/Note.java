package com.springboot.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_notes")

public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnotes")
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_saisie;

	@ManyToOne
	@JoinColumn(name = "ideleve")
	private Eleve ideleve;
	@ManyToOne
	@JoinColumn(name = "idmatiere")
	private Matiere idmatiere;

	private Integer idtrimestre;
	@ManyToOne
	@JoinColumn(name = "idprof")
	private Professeur idprof;
	@ManyToOne
	@JoinColumn(name = "idclasse")
	private Classe idclasse;

	@Lob
	@Column(name = "avis", columnDefinition = "text")
	private String avis;
	private Integer note;
	private Float avancement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_saisie() {
		return date_saisie;
	}

	public void setDate_saisie(Date date_saisie) {
		this.date_saisie = date_saisie;
	}

	public Eleve getIdeleve() {
		return ideleve;
	}

	public void setIdeleve(Eleve ideleve) {
		this.ideleve = ideleve;
	}

	public Matiere getIdmatiere() {
		return idmatiere;
	}

	public void setIdmatiere(Matiere idmatiere) {
		this.idmatiere = idmatiere;
	}

	public Integer getIdtrimestre() {
		return idtrimestre;
	}

	public void setIdtrimestre(Integer idtrimestre) {
		this.idtrimestre = idtrimestre;
	}

	public Professeur getIdprof() {
		return idprof;
	}

	public void setIdprof(Professeur idprof) {
		this.idprof = idprof;
	}

	public Classe getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(Classe idclasse) {
		this.idclasse = idclasse;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Float getAvancement() {
		return avancement;
	}

	public void setAvancement(Float avancement) {
		this.avancement = avancement;
	}

}
