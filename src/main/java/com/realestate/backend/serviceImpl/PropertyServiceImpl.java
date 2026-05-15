package com.realestate.backend.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.nio.file.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.backend.dto.*;
import com.realestate.backend.entity.*;
import com.realestate.backend.repository.PropertyRepository;
import com.realestate.backend.service.PropertyService;
import com.realestate.backend.enums.*;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository repo;

    @Override
    public PropertyResponseDTO saveWithImages(
            String title, String location, double price, double area,
            PropertyType type, PropertyStatus status,
            String facing, String surveyNumber, String description,
            List<MultipartFile> files) {

        Property p = new Property();

        p.setTitle(title);
        p.setLocation(location);
        p.setPrice(price);
        p.setArea(area);
        p.setPricePerSqft(area != 0 ? price / area : 0);
        p.setType(type);
        p.setStatus(status);
        p.setFacing(facing);
        p.setSurveyNumber(surveyNumber);
        p.setDescription(description);
        p.setCreatedAt(LocalDateTime.now());

        try {
            List<PropertyImage> images = files.stream().map(file -> {
                try {
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    Path path = Paths.get("uploads/" + fileName);
                    Files.createDirectories(path.getParent());
                    Files.write(path, file.getBytes());

                    PropertyImage img = new PropertyImage();
                    img.setImageUrl("/images/" + fileName);
                    img.setProperty(p);
                    return img;

                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }).toList();

            p.setImages(images);
        } catch (Exception e) {}

        return map(repo.save(p));
    }

    @Override
    public List<PropertyResponseDTO> getAll() {
        return repo.findAll().stream().map(this::map).toList();
    }

    private PropertyResponseDTO map(Property p) {
        PropertyResponseDTO dto = new PropertyResponseDTO();
        dto.setId(p.getId());
        dto.setTitle(p.getTitle());
        dto.setLocation(p.getLocation());
        dto.setPrice(p.getPrice());
        dto.setArea(p.getArea());
        dto.setStatus(p.getStatus());
        dto.setType(p.getType());

        if (p.getImages() != null) {
            dto.setImages(p.getImages().stream()
                    .map(PropertyImage::getImageUrl)
                    .toList());
        }
        return dto;
    }
    
    @Override
    public PropertyResponseDTO update(Long id, PropertyDTO dto) {
        Property p = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        p.setTitle(dto.getTitle());
        p.setLocation(dto.getLocation());
        p.setPrice(dto.getPrice());
        p.setArea(dto.getArea());
        p.setPricePerSqft(dto.getArea() != 0 ? dto.getPrice() / dto.getArea() : 0);
        p.setType(dto.getType());
        p.setStatus(dto.getStatus());
        p.setFacing(dto.getFacing());
        p.setSurveyNumber(dto.getSurveyNumber());
        p.setDescription(dto.getDescription());
        p.setUpdatedAt(LocalDateTime.now());
        return map(repo.save(p));
    }

    @Override
    public void updateStatus(Long id, PropertyStatus status) {
        Property p = repo.findById(id).orElse(null);
        if (p != null) { p.setStatus(status); repo.save(p); }
    }

    @Override public PropertyResponseDTO save(PropertyDTO dto){return null;}
   
    @Override public void delete(Long id){repo.deleteById(id);}
   
    @Override public List<PropertyResponseDTO> filter(String l, Double a, Double b, PropertyType t, PropertyStatus s){return null;}
}