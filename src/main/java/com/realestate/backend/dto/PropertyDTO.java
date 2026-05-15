package com.realestate.backend.dto;

import java.util.List;

import com.realestate.backend.enums.*;

public class PropertyDTO {

    private String title;
    private String location;
    private double price;
    private double area;
    private PropertyType type;
    private PropertyStatus status;
    private String facing;
    private String surveyNumber;
    private String description;
    private List<String> images;

    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public PropertyType getType() { return type; }
    public void setType(PropertyType type) { this.type = type; }

    public PropertyStatus getStatus() { return status; }
    public void setStatus(PropertyStatus status) { this.status = status; }

    public String getFacing() { return facing; }
    public void setFacing(String facing) { this.facing = facing; }

    public String getSurveyNumber() { return surveyNumber; }
    public void setSurveyNumber(String surveyNumber) { this.surveyNumber = surveyNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}