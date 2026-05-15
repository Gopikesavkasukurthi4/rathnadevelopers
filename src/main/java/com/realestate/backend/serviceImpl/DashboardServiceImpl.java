package com.realestate.backend.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.backend.entity.Property;
import com.realestate.backend.enums.PropertyStatus;
import com.realestate.backend.repository.EnquiryRepository;
import com.realestate.backend.repository.PropertyRepository;
import com.realestate.backend.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private EnquiryRepository enquiryRepo;

    @Override
    public Map<String, Object> getStats() {

        Map<String, Object> map = new HashMap<>();

        List<Property> list = propertyRepo.findAll();

        long total = list.size();

        long available = list.stream()
                .filter(p -> p.getStatus() == PropertyStatus.AVAILABLE)
                .count();

        long onHold = list.stream()
                .filter(p -> p.getStatus() == PropertyStatus.ON_HOLD)
                .count();

        long enquiries = enquiryRepo.count();

        map.put("totalProperties", total);
        map.put("available", available);
        map.put("onHold", onHold);
        map.put("enquiries", enquiries);

        return map;
    }
}