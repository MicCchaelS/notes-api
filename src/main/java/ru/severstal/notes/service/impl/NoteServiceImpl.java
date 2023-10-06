package ru.severstal.notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.severstal.notes.dto.NoteDTO;
import ru.severstal.notes.dto.NotesDTO;
import ru.severstal.notes.service.NoteService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {

    @Override
    public List<NotesDTO> findAllNotes() {
        return null;
    }

    @Override
    public NoteDTO findNoteById(int id) {
        return null;
    }

    @Transactional
    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        return null;
    }

    @Transactional
    @Override
    public void updateNote(NoteDTO noteDTO) {

    }

    @Transactional
    @Override
    public void deleteNote(int id) {

    }
}