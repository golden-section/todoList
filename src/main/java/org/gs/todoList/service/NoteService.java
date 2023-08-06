package org.gs.todoList.service;

import lombok.SneakyThrows;
import org.gs.todoList.entity.Note;
import org.gs.todoList.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    private final Map<Long, Note> noteList = new HashMap<>();

    public List<Note> listAll() {
        return noteList.values().stream().toList();
    }

    public Note add(Note note) {
        note.setId(LocalDateTime.now().hashCode());
        noteList.putIfAbsent(note.getId(), note);
        return note;
    }

    @SneakyThrows
    public Note getById(long id)  {
        if(noteList.containsKey(id)) {
            return noteList.get(id);
        } else {
            throw new NoteNotFoundException(id);
        }
    }

    @SneakyThrows
    public void update(Note note) {
        if(noteList.containsKey(note.getId())) {
            noteList.put(note.getId(), note);
        } else {
            throw new NoteNotFoundException(note.getId());
        }
    }

    @SneakyThrows
    public void deleteById(long id) {
        if(noteList.containsKey(id)) {
            noteList.remove(id);
        } else {
            throw new NoteNotFoundException(id);
        }
    }
}