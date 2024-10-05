package com.example.demo.dto;

import com.example.demo.model.ExperienceLevel;
import com.example.demo.model.GardeningStyle;

public record CreateGardenerDTO(
        String name,
        ExperienceLevel experienceLevel,
        GardeningStyle gardeningStyle
) {
}
