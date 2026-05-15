package com.realestate.backend.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.realestate.backend.dto.*;
import com.realestate.backend.enums.*;

public interface PropertyService {

    PropertyResponseDTO saveWithImages(
            String title,
            String location,
            double price,
            double area,
            PropertyType type,
            PropertyStatus status,
            String facing,
            String surveyNumber,
            String description,
            List<MultipartFile> images
    );

    PropertyResponseDTO save(PropertyDTO dto);
    List<PropertyResponseDTO> getAll();
    PropertyResponseDTO update(Long id, PropertyDTO dto);
    void delete(Long id);
    void updateStatus(Long id, PropertyStatus status);

    List<PropertyResponseDTO> filter(
            String location,
            Double minPrice,
            Double maxPrice,
            PropertyType type,
            PropertyStatus status);
}