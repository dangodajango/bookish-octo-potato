package com.example.demo.dto;

import com.example.demo.model.GardenType;

import java.util.Set;

public record GetGardenDTO(
        Long gardenId,
        String location,
        int sizeInSquareMeters,
        GardenType gardenType,
        Set<Long> gardeners,
        Set<Long> plants
) {
}
