package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Note;
import com.springboot.dao.DaoNote;

@Service
public class ServiceNotes implements IServiceNotes {

	@Autowired
	DaoNote daoNote;

	@Transactional(readOnly = true)
	@Override
	public List<Note> rechercheNote() {
		// TODO Auto-generated method stub
		return daoNote.findAll();
	}

	@Transactional(readOnly = true)

	@Override
	public Note rechercheNoteId(int id) {
		// TODO Auto-generated method stub
		return daoNote.findById(id).get();
	}

	@Transactional

	@Override
	public void creerNote(Note note) {
		daoNote.save(note);

	}

	@Transactional

	@Override
	public void modifierNote(Note note) {
		// TODO Auto-generated method stub
		daoNote.save(note);

	}

	@Transactional

	@Override
	public void supprimerNote(Note note) {
		// TODO Auto-generated method stub
		daoNote.deleteById(note.getId());
	}

}
