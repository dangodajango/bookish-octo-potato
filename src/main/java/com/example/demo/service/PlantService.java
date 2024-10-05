package com.example.demo.service;

import com.example.demo.dto.CreatePlantDTO;
import com.example.demo.dto.GetPlantDTO;
import com.example.demo.dto.UpdatePlantDTO;
import com.example.demo.model.CareTip;
import com.example.demo.model.Plant;
import com.example.demo.repository.GardenRepository;
import com.example.demo.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;

    private final GardenRepository gardenRepository;

    public GetPlantDTO get(Long id) {
        Plant plant = plantRepository.findById(id).orElseThrow();
        return new GetPlantDTO(
                plant.getPlantId(),
                plant.getName(),
                plant.getSpecies(),
                plant.getPlantingDate(),
                plant.getPlantId(),
                plant.getCareTips().stream()
                        .map(CareTip::getCareTipId)
                        .collect(Collectors.toSet())
        );
    }

    @Transactional
    public Long create(CreatePlantDTO createPlantDTO) {
        Plant plant = new Plant();
        plant.setName(createPlantDTO.name());
        plant.setSpecies(createPlantDTO.species());
        plant.setPlantingDate(createPlantDTO.plantingDate());
        plant.setGarden(gardenRepository.findById(createPlantDTO.gardenId()).orElseThrow());
        plantRepository.save(plant);
        return plant.getPlantId();
    }

    @Transactional
    public void update(Long id, UpdatePlantDTO updatePlantDTO) {
        Plant plant = plantRepository.findById(id).orElseThrow();
        updatePlantDTO.name().ifPresent(plant::setName);
        updatePlantDTO.species().ifPresent(plant::setSpecies);
        updatePlantDTO.plantingDate().ifPresent(plant::setPlantingDate);
    }

    @Transactional
    public void delete(Long id) {
        plantRepository.deleteById(id);
    }
}
