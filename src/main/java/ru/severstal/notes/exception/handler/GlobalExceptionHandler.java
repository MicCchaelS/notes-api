package ru.severstal.notes.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.severstal.notes.exception.ResourceNotFoundException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleException(ResourceNotFoundException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("error", e.getMessage());
        return "error/resourceNotFound";
    }
}