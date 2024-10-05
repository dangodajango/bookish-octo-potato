package com.example.demo.dto;

import com.example.demo.model.ExperienceLevel;
import com.example.demo.model.GardeningStyle;

import java.util.Optional;

public record UpdateGardenerDTO(
        Optional<String> name,
        Optional<ExperienceLevel> experienceLevel,
        Optional<GardeningStyle> gardeningStyle
) {
}
