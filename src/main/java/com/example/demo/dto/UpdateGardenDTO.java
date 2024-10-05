package com.example.demo.dto;

import com.example.demo.model.GardenType;

import java.util.Optional;

public record UpdateGardenDTO(
        Optional<String> location,
        Optional<Integer> sizeInSquareMeters,
        Optional<GardenType> gardenType
) {
}
