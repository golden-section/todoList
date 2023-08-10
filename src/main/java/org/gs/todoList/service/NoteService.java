package org.gs.todoList.service;

import lombok.SneakyThrows;
import org.gs.todoList.data.entity.Note;
import org.gs.todoList.data.repository.NoteRepository;
import org.gs.todoList.exception.NoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @SneakyThrows
    public Note getById(long id)  {
        if(noteRepository.existsById(id)) {
            return noteRepository.getReferenceById(id);
        } else {
            throw new NoteNotFoundException(id);
        }
    }

    @SneakyThrows
    public void update(Note note) {
        if(noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new NoteNotFoundException(note.getId());
        }
    }

    @SneakyThrows
    public void deleteById(long id) {
        if(noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException(id);
        }
    }
}