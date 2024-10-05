package com.example.demo.dto;

import com.example.demo.model.GardenType;

public record CreateGardenDTO(
        String location,
        int sizeInSquareMeters,
        GardenType gardenType
) {
}
