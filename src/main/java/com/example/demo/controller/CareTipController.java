package com.example.demo.controller;

import com.example.demo.dto.CreateCareTipDTO;
import com.example.demo.dto.GetCareTipDTO;
import com.example.demo.dto.UpdateCareTipDTO;
import com.example.demo.service.CareTipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/care-tip")
@RequiredArgsConstructor
public class CareTipController {

    private final CareTipService careTipService;

    @GetMapping("/{id}")
    public GetCareTipDTO get(@PathVariable Long id) {
        return careTipService.get(id);
    }

    @PostMapping
    public Long create(@RequestBody CreateCareTipDTO createCareTipDTO) {
        return careTipService.create(createCareTipDTO);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateCareTipDTO updateCareTipDTO) {
        careTipService.update(id, updateCareTipDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        careTipService.delete(id);
    }
}
