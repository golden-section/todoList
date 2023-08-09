package org.gs.todoList.controller;

import lombok.RequiredArgsConstructor;
import org.gs.todoList.entity.Note;
import org.gs.todoList.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getNotesList(){
        ModelAndView result = new ModelAndView("notes");
        result.addObject("notesList", noteService.listAll());
        return result;
    }

    @PostMapping("/list")
    public RedirectView addNote(@ModelAttribute Note note) {
        noteService.add(note);
        return new RedirectView("/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView getEditForm(@RequestParam long id) {
        ModelAndView result = new ModelAndView("editor");
        result.addObject("editNote", noteService.getById(id));
        return result;
    }

    @PostMapping(value = "/edit")
    public RedirectView saveChanges(@ModelAttribute Note note) {
        noteService.update(note);
        return new RedirectView("/note/list");
    }

    @PostMapping(value = "/delete")
    public RedirectView deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }
}