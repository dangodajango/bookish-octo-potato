package com.example.demo.dto;

import com.example.demo.model.CareTipType;

import java.util.Optional;

public record UpdateCareTipDTO(
        Optional<String> description,
        Optional<CareTipType> careTipType
) {
}
