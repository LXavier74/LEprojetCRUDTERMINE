package spring004web.controller;

import java.util.List;

import javax.validation.Valid;

public class ModificationFormProf {
@Valid
private List<ModificationProf> listeProfs;
public void setListeProfs(final List<ModificationProf> pListeProfs) {
	listeProfs = pListeProfs;
}
public List<ModificationProf> getListeProfs() {
return listeProfs;
}
}