package ru.severstal.notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.severstal.notes.dto.NoteDTO;
import ru.severstal.notes.dto.NotesDTO;
import ru.severstal.notes.exception.ResourceNotFoundException;
import ru.severstal.notes.model.Note;
import ru.severstal.notes.repository.NoteRepository;
import ru.severstal.notes.service.ImageService;
import ru.severstal.notes.service.NoteService;
import ru.severstal.notes.util.ModelMapperUtil;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final ModelMapperUtil modelMapperUtil;

    private final ImageService imageService;

    @Override
    public List<NotesDTO> findAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(note -> modelMapperUtil.map(note, NotesDTO.class))
                .toList();
    }

    @Override
    public NoteDTO findNoteById(int id) {
        return noteRepository.findById(id)
                .map(note -> modelMapperUtil.map(note, NoteDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Ошибка: Заметка не найдена"));
    }

    @Transactional
    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        return Optional.of(noteDTO)
                .map(dto -> {
                    uploadImage(dto);
                    return modelMapperUtil.map(dto, Note.class);
                })
                .map(noteRepository::save)
                .map(note -> modelMapperUtil.map(note, NoteDTO.class))
                .orElseThrow();
    }

    @Transactional
    @Override
    public void updateNote(NoteDTO noteDTO) {
        Optional.of(noteDTO)
                .map(dto -> {
                    imageService.deleteImage(dto.getImagePath());
                    uploadImage(dto);
                    return modelMapperUtil.map(dto, Note.class);
                })
                .map(noteRepository::save)
                .orElseThrow();
    }

    @Transactional
    @Override
    public void deleteNote(int id) {
        var note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ошибка: Заметка не найдена"));

        imageService.deleteImage(note.getImagePath());
        noteRepository.delete(note);
    }

    private void uploadImage(NoteDTO noteDTO) {
        if (noteDTO.getImage() != null && !noteDTO.getImage().isEmpty()) {
            var imagePath = imageService.saveImage(noteDTO.getImage());
            noteDTO.setImagePath(imagePath);
        }
    }
}