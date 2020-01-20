package com.springboot.service;

import java.util.List;

import com.springboot.bean.Note;


public interface IServiceNotes {
	public List<Note> rechercheNote();
	public Note rechercheNoteId(final int id);
	public void creerNote(final Note note);
	public void modifierNote(final Note note);
	public void supprimerNote(final Note note);
}
