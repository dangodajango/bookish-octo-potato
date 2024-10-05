package com.example.demo.controller;

import com.example.demo.dto.AssignGardenerToGardenDTO;
import com.example.demo.dto.CreateGardenDTO;
import com.example.demo.dto.GetGardenDTO;
import com.example.demo.dto.UpdateGardenDTO;
import com.example.demo.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gardens")
@RequiredArgsConstructor
public class GardenController {

    private final GardenService gardenService;

    @GetMapping("{id}")
    public GetGardenDTO get(@PathVariable Long id) {
        return gardenService.get(id);
    }

    @PostMapping
    public Long create(@RequestBody CreateGardenDTO createGardenDTO) {
        return gardenService.create(createGardenDTO);
    }

    @PostMapping("/{id}/gardeners")
    public void assignGardenerToGarden(@PathVariable Long id, @RequestBody AssignGardenerToGardenDTO assignGardenerToGardenDTO) {
        gardenService.assignGardenerToGarden(id, assignGardenerToGardenDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, UpdateGardenDTO updateGardenDTO) {
        gardenService.update(id, updateGardenDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gardenService.delete(id);
    }

    @DeleteMapping("/{gardenId}/gardeners/{gardenerId}")
    public void delete(@PathVariable Long gardenId, @PathVariable Long gardenerId) {
        gardenService.removeGardenerFromGarden(gardenId, gardenerId);
    }
}
