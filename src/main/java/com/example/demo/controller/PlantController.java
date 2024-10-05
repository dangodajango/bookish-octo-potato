package com.example.demo.controller;

import com.example.demo.dto.CreatePlantDTO;
import com.example.demo.dto.GetPlantDTO;
import com.example.demo.dto.UpdatePlantDTO;
import com.example.demo.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @GetMapping("/{id}")
    public GetPlantDTO get(@PathVariable Long id) {
        return plantService.get(id);
    }

    @PostMapping
    public Long create(@RequestBody CreatePlantDTO createPlantDTO) {
        return plantService.create(createPlantDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdatePlantDTO updatePlantDTO) {
        plantService.update(id, updatePlantDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        plantService.delete(id);
    }
}
