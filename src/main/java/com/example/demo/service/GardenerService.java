package com.example.demo.service;

import com.example.demo.dto.CreateGardenerDTO;
import com.example.demo.dto.GetGardenerDTO;
import com.example.demo.dto.UpdateGardenerDTO;
import com.example.demo.model.Garden;
import com.example.demo.model.Gardener;
import com.example.demo.repository.GardenerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GardenerService {

    private final GardenerRepository gardenerRepository;

    public GetGardenerDTO get(Long id) {
        Gardener gardener = gardenerRepository.findById(id).orElseThrow();
        return new GetGardenerDTO(
                gardener.getGardenerId(),
                gardener.getName(),
                gardener.getExperienceLevel(),
                gardener.getGardeningStyle(),
                gardener.getJoinDate(),
                gardener.getGardens().stream()
                        .map(Garden::getGardenId)
                        .collect(Collectors.toSet())
        );
    }

    @Transactional
    public Long create(CreateGardenerDTO createGardenerDTO) {
        Gardener gardener = new Gardener();
        gardener.setName(createGardenerDTO.name());
        gardener.setExperienceLevel(createGardenerDTO.experienceLevel());
        gardener.setGardeningStyle(createGardenerDTO.gardeningStyle());
        gardener.setJoinDate(LocalDate.now());
        gardenerRepository.save(gardener);
        return gardener.getGardenerId();
    }

    @Transactional
    public void update(Long id, UpdateGardenerDTO updateGardenerDTO) {
        Gardener gardener = gardenerRepository.findById(id).orElseThrow();
        updateGardenerDTO.name().ifPresent(gardener::setName);
        updateGardenerDTO.experienceLevel().ifPresent(gardener::setExperienceLevel);
        updateGardenerDTO.gardeningStyle().ifPresent(gardener::setGardeningStyle);
    }

    @Transactional
    public void delete(Long id) {
        Gardener gardener = gardenerRepository.findById(id).orElseThrow();
        gardener.getGardens().forEach(garden ->
                garden.getGardeners().remove(gardener));
        gardenerRepository.delete(gardener);
    }
}
