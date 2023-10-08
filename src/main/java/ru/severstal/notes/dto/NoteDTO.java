package ru.severstal.notes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class NoteDTO {

    private int id;

    @NotBlank(message = "Это поле должно быть заполнено")
    @Size(min = 1, max = 100, message = "Заголовок должен содержать от 1 до 100 символов")
    private String title;

    @Size(max = 2500, message = "Описание не должно содержать больше 2500 символов")
    private String description;

    private MultipartFile image;

    private String imagePath;
}