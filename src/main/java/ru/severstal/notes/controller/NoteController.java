package ru.severstal.notes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.severstal.notes.dto.NoteDTO;
import ru.severstal.notes.service.NoteService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public String firstLaunch(Model model) {
        var notes = noteService.findAllNotes();
        if (notes.isEmpty()) {
            return "redirect:/api/notes/new";
        } else {
            model.addAttribute("notes", notes);
            return "note/notes";
        }
    }

    @GetMapping("/notes")
    public String findAllNotes(Model model) {
        model.addAttribute("notes", noteService.findAllNotes());
        return "note/notes";
    }

    @GetMapping("/notes/{id}")
    public String findNoteById(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", noteService.findNoteById(id));
        return "note/note";
    }

    @GetMapping("/notes/new")
    public String showNewNotePage(@ModelAttribute("note") NoteDTO noteDTO) {
        return "note/newNote";
    }

    @PostMapping("/notes")
    public String createNewNote(@ModelAttribute("note") @Valid NoteDTO noteDTO,
                                BindingResult bindingResult) {
        return bindingResult.hasErrors()
                ? "note/newNote"
                : "redirect:/api/notes/" + noteService.saveNote(noteDTO).getId();
    }

    @GetMapping("/notes/{id}/edit")
    public String showEditNotePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", noteService.findNoteById(id));
        return "note/editNote";
    }

    @PatchMapping("/notes/{id}")
    public String editNote(@ModelAttribute("note") @Valid NoteDTO noteDTO,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "note/editNote";
        }

        noteService.updateNote(noteDTO);
        return "redirect:/api/notes/{id}";
    }

    @DeleteMapping("/notes/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        noteService.deleteNote(id);
        return "redirect:/api/notes";
    }
}