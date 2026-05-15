package com.realestate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.backend.dto.PropertyDTO;
import com.realestate.backend.dto.PropertyResponseDTO;
import com.realestate.backend.enums.*;
import com.realestate.backend.service.PropertyService;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @PostMapping(consumes = "multipart/form-data")
    public PropertyResponseDTO save(
            @RequestParam String title,
            @RequestParam String location,
            @RequestParam double price,
            @RequestParam double area,
            @RequestParam PropertyType type,
            @RequestParam PropertyStatus status,
            @RequestParam(required = false) String facing,
            @RequestParam(required = false) String surveyNumber,
            @RequestParam(required = false) String description,
            @RequestParam("images") List<MultipartFile> images
    ) {
        return service.saveWithImages(title, location, price, area,
                type, status, facing, surveyNumber, description, images);
    }

    @GetMapping
    public List<PropertyResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PropertyResponseDTO update(@PathVariable Long id, @RequestBody PropertyDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam PropertyStatus status) {
        service.updateStatus(id, status);
    }

    @GetMapping("/filter")
    public List<PropertyResponseDTO> filter(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) PropertyType type,
            @RequestParam(required = false) PropertyStatus status) {

        return service.filter(location, minPrice, maxPrice, type, status);
    }
}