package com.example.test_task1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditPageDto {
    @NotBlank(message = "Field cant be empty")
    private String title;
    @NotBlank(message = "Field cant be empty")
    private String description;
    @NotBlank(message = "Field cant be empty")
    private String menu_label;
    @NotBlank(message = "Field cant be empty")
    private String h1;
    private int priority;
}
