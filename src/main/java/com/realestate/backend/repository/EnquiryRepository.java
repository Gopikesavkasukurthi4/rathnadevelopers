package com.realestate.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.realestate.backend.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
}