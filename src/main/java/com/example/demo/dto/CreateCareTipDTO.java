package com.example.demo.dto;

import com.example.demo.model.CareTipType;

public record CreateCareTipDTO(
        String description,
        CareTipType careTipType,
        Long plantId
) {
}
