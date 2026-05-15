package com.realestate.backend.service;

import java.util.List;

import com.realestate.backend.dto.EnquiryDTO;
import com.realestate.backend.dto.EnquiryResponseDTO;
import com.realestate.backend.enums.EnquiryStatus;

public interface EnquiryService {

    EnquiryResponseDTO save(EnquiryDTO dto);

    List<EnquiryResponseDTO> getAll();

    void updateStatus(Long id, EnquiryStatus status);
}