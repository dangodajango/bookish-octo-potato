package com.example.demo.controller;

import com.example.demo.dto.CreateGardenerDTO;
import com.example.demo.dto.GetGardenerDTO;
import com.example.demo.dto.UpdateGardenerDTO;
import com.example.demo.service.GardenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gardeners")
@RequiredArgsConstructor
public class GardenerController {

    private final GardenerService gardenerService;

    @GetMapping("/{id}")
    public GetGardenerDTO get(@PathVariable Long id) {
        return gardenerService.get(id);
    }

    @PostMapping
    public Long create(@RequestBody CreateGardenerDTO createGardenerDTO) {
        return gardenerService.create(createGardenerDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateGardenerDTO updateGardenerDTO) {
        gardenerService.update(id, updateGardenerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gardenerService.delete(id);
    }
}
