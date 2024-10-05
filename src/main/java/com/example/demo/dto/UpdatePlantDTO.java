package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Optional;

public record UpdatePlantDTO(
        Optional<String> name,
        Optional<String> species,
        Optional<LocalDate> plantingDate
) {
}
