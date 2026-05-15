package com.realestate.backend.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.backend.dto.EnquiryDTO;
import com.realestate.backend.dto.EnquiryResponseDTO;
import com.realestate.backend.entity.Enquiry;
import com.realestate.backend.entity.Property;
import com.realestate.backend.enums.EnquiryStatus;
import com.realestate.backend.repository.EnquiryRepository;
import com.realestate.backend.repository.PropertyRepository;
import com.realestate.backend.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository repo;

    @Autowired
    private PropertyRepository propertyRepo;

    @Override
    public EnquiryResponseDTO save(EnquiryDTO dto) {

        Property property = propertyRepo.findById(dto.getPropertyId()).orElse(null);

        if (property == null) {
            throw new RuntimeException("Property not found");
        }

        Enquiry e = new Enquiry();

        e.setName(dto.getName());
        e.setPhone(dto.getPhone());
        e.setEmail(dto.getEmail());
        e.setBudget(dto.getBudget());
        e.setMessage(dto.getMessage());

        e.setProperty(property);
        e.setStatus(EnquiryStatus.NEW);
        e.setCreatedAt(LocalDateTime.now());

        return map(repo.save(e));
    }

    @Override
    public List<EnquiryResponseDTO> getAll() {
        return repo.findAll().stream().map(this::map).toList();
    }

    @Override
    public void updateStatus(Long id, EnquiryStatus status) {
        Enquiry e = repo.findById(id).orElse(null);

        if (e != null) {
            e.setStatus(status);
            repo.save(e);
        }
    }

    private EnquiryResponseDTO map(Enquiry e) {

        EnquiryResponseDTO dto = new EnquiryResponseDTO();

        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setPhone(e.getPhone());
        dto.setEmail(e.getEmail());
        dto.setBudget(e.getBudget());
        dto.setMessage(e.getMessage());
        dto.setStatus(e.getStatus());
        dto.setPropertyId(e.getProperty().getId());
        dto.setCreatedAt(e.getCreatedAt());

        return dto;
    }
}