package org.gs.todoList.exception;

public class NoteNotFoundException extends Exception {
    private static final String NOTE_NOT_FOUND_EXCEPTION_TEXT = "Note with id [%s] doesn't exist";

    public NoteNotFoundException(long id) {
        super(String.format(NOTE_NOT_FOUND_EXCEPTION_TEXT, id));
    }
}
