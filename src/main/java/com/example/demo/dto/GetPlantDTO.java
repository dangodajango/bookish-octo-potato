package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Set;

public record GetPlantDTO(
        Long plantId,
        String name,
        String species,
        LocalDate plantDate,
        Long gardenId,
        Set<Long> careTips
) {
}
