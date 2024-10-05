package com.example.demo.dto;

import java.time.LocalDate;

public record CreatePlantDTO(
        String name,
        String species,
        LocalDate plantingDate,
        Long gardenId
) {
}
