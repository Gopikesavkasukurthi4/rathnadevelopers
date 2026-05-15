package com.realestate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.realestate.backend.dto.EnquiryDTO;
import com.realestate.backend.dto.EnquiryResponseDTO;
import com.realestate.backend.enums.EnquiryStatus;
import com.realestate.backend.service.EnquiryService;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "http://localhost:3000")
public class EnquiryController {

    @Autowired
    private EnquiryService service;

    @PostMapping
    public EnquiryResponseDTO save(@RequestBody EnquiryDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<EnquiryResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam EnquiryStatus status) {
        service.updateStatus(id, status);
    }
}