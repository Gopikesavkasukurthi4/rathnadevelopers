package com.realestate.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.realestate.backend.entity.PropertyImage;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {
}