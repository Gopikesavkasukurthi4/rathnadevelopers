package com.realestate.backend.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.realestate.backend.enums.*;

public class PropertyResponseDTO {

    private Long id;
    private String title;
    private String location;
    private double price;
    private double area;
    private double pricePerSqft;

    private PropertyType type;
    private PropertyStatus status;

    private String description;
    private List<String> images;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public double getPricePerSqft() { return pricePerSqft; }
    public void setPricePerSqft(double pricePerSqft) { this.pricePerSqft = pricePerSqft; }

    public PropertyType getType() { return type; }
    public void setType(PropertyType type) { this.type = type; }

    public PropertyStatus getStatus() { return status; }
    public void setStatus(PropertyStatus status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}