package com.realestate.backend.dto;

public class EnquiryDTO {

    private String name;
    private String phone;
    private String email;
    private String budget;
    private String message;
    private Long propertyId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBudget() { return budget; }
    public void setBudget(String budget) { this.budget = budget; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }
}