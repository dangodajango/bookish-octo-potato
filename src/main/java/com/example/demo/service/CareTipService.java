package com.example.demo.service;

import com.example.demo.dto.CreateCareTipDTO;
import com.example.demo.dto.GetCareTipDTO;
import com.example.demo.dto.UpdateCareTipDTO;
import com.example.demo.model.CareTip;
import com.example.demo.repository.CareTipRepository;
import com.example.demo.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CareTipService {

    private final CareTipRepository careTipRepository;

    private final PlantRepository plantRepository;

    public GetCareTipDTO get(Long id) {
        CareTip careTip = careTipRepository.findById(id).orElseThrow();
        return new GetCareTipDTO(
                careTip.getCareTipId(),
                careTip.getDescription(),
                careTip.getType(),
                careTip.getPlant().getPlantId()
        );
    }

    @Transactional
    public Long create(CreateCareTipDTO createCareTipDTO) {
        CareTip careTip = new CareTip();
        careTip.setDescription(createCareTipDTO.description());
        careTip.setType(createCareTipDTO.careTipType());
        careTip.setPlant(plantRepository.findById(createCareTipDTO.plantId()).orElseThrow());
        careTipRepository.save(careTip);
        return careTip.getCareTipId();
    }

    @Transactional
    public void update(Long id, UpdateCareTipDTO updateCareTipDTO) {
        CareTip careTip = careTipRepository.findById(id).orElseThrow();
        updateCareTipDTO.description().ifPresent(careTip::setDescription);
        updateCareTipDTO.careTipType().ifPresent(careTip::setType);
    }

    @Transactional
    public void delete(Long id) {
        careTipRepository.deleteById(id);
    }
}
