package com.example.demo.dto;

import com.example.demo.model.CareTipType;

public record GetCareTipDTO(
        Long id,
        String description,
        CareTipType careTipType,
        Long plantId
) {
}
