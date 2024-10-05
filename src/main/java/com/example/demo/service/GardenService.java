package com.example.demo.service;

import com.example.demo.dto.AssignGardenerToGardenDTO;
import com.example.demo.dto.CreateGardenDTO;
import com.example.demo.dto.GetGardenDTO;
import com.example.demo.dto.UpdateGardenDTO;
import com.example.demo.model.Garden;
import com.example.demo.model.Gardener;
import com.example.demo.model.Plant;
import com.example.demo.repository.GardenRepository;
import com.example.demo.repository.GardenerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GardenService {

    private final GardenRepository gardenRepository;

    private final GardenerRepository gardenerRepository;

    public GetGardenDTO get(Long id) {
        Garden garden = gardenRepository.findById(id).orElseThrow();
        return new GetGardenDTO(
                garden.getGardenId(),
                garden.getLocation(),
                garden.getSizeInSquareMeters(),
                garden.getGardenType(),
                garden.getGardeners().stream()
                        .map(Gardener::getGardenerId)
                        .collect(Collectors.toSet()),
                garden.getPlants().stream()
                        .map(Plant::getPlantId)
                        .collect(Collectors.toSet())
        );
    }

    @Transactional
    public Long create(CreateGardenDTO createGardenDTO) {
        Garden garden = new Garden();
        garden.setLocation(createGardenDTO.location());
        garden.setSizeInSquareMeters(createGardenDTO.sizeInSquareMeters());
        garden.setGardenType(createGardenDTO.gardenType());
        gardenRepository.save(garden);
        return garden.getGardenId();
    }

    @Transactional
    public void assignGardenerToGarden(Long id, AssignGardenerToGardenDTO assignGardenerToGardenDTO) {
        Garden garden = gardenRepository.findById(id).orElseThrow();
        Gardener gardener = gardenerRepository.findById(assignGardenerToGardenDTO.gardenerId()).orElseThrow();
        garden.getGardeners().add(gardener);
        gardener.getGardens().add(garden);
    }

    @Transactional
    public void update(Long id, UpdateGardenDTO updateGardenDTO) {
        Garden garden = gardenRepository.findById(id).orElseThrow();
        updateGardenDTO.location().ifPresent(garden::setLocation);
        updateGardenDTO.sizeInSquareMeters().ifPresent(garden::setSizeInSquareMeters);
        updateGardenDTO.gardenType().ifPresent(garden::setGardenType);
    }

    @Transactional
    public void delete(Long gardenId) {
        Garden garden = gardenRepository.findById(gardenId).orElseThrow();
        gardenRepository.delete(garden);
    }

    @Transactional
    public void removeGardenerFromGarden(Long gardenId, Long gardenerId) {
        Garden garden = gardenRepository.findById(gardenId).orElseThrow();
        Gardener gardener = gardenerRepository.findById(gardenerId).orElseThrow();
        garden.getGardeners().remove(gardener);
        gardener.getGardens().remove(garden);
    }
}
