package org.gs.todoList;

import org.gs.todoList.entity.Note;
import org.gs.todoList.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);

		NoteService noteService = new NoteService();

		// Add new notes
		Note firstNote = new Note();
		firstNote.setTitle("First Note");
		firstNote.setContent("First note content");
		noteService.add(firstNote);

		Note secondNote = new Note();
		secondNote.setTitle("Second Note");
		secondNote.setContent("Second note content");
		noteService.add(secondNote);

		Note thirdNote = new Note();
		thirdNote.setTitle("Third Note");
		thirdNote.setContent("Third note content");
		noteService.add(thirdNote);

		// Get all notes
		System.out.println("List of all notes: " + noteService.listAll());

		// Get the note by ID
		Note noteById = noteService.getById(noteService.listAll().get(0).getId());
		System.out.println("noteById: " + noteById);

		// Update note
		noteById.setTitle("Updated title");
		noteById.setContent("Updated note content");
		noteService.update(noteById);
		System.out.println("List of all notes: " + noteService.listAll());

		// Delete the note
		long noteToDeleteId = noteService.listAll().get(2).getId();
		noteService.deleteById(noteToDeleteId);
		System.out.println("List of all notes: " + noteService.listAll());
	}
}