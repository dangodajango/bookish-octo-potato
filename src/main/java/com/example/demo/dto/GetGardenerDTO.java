package com.example.demo.dto;

import com.example.demo.model.ExperienceLevel;
import com.example.demo.model.GardeningStyle;

import java.time.LocalDate;
import java.util.Set;

public record GetGardenerDTO(
        Long id,
        String name,
        ExperienceLevel experienceLevel,
        GardeningStyle gardeningStyle,
        LocalDate joinDate,
        Set<Long> gardens
) {
}
