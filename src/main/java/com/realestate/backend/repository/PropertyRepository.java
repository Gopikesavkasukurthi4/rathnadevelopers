package com.realestate.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.realestate.backend.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}