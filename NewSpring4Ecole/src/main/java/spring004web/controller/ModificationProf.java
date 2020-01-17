package spring004web.controller;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class ModificationProf {
private Integer id;
@NotEmpty
private String nom;
@NotEmpty
private String prenom;
@NotEmpty
private String date_naissance;
@NotEmpty
private String adresse;
@NotEmpty
private String sexe;
public Integer getId() {
return id;
}
public void setId(final Integer pId) {
id = pId;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getDate_naissance() {
	return date_naissance;
}
public void setDate_naissance(String date_naissance) {
	this.date_naissance = date_naissance;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}

}
