package ru.severstal.notes.service;

import ru.severstal.notes.dto.NoteDTO;
import ru.severstal.notes.dto.NotesDTO;

import java.util.List;

public interface NoteService {

    List<NotesDTO> findAllNotes();
    NoteDTO findNoteById(int id);
    NoteDTO saveNote(NoteDTO noteDTO);
    void updateNote(NoteDTO noteDTO);
    void deleteNote(int id);
}