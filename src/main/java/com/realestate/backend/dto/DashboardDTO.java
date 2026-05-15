package com.realestate.backend.dto;

public class DashboardDTO {

    private long totalProperties;
    private long available;
    private long onHold;
    private long enquiries;

    public long getTotalProperties() {
        return totalProperties;
    }

    public void setTotalProperties(long totalProperties) {
        this.totalProperties = totalProperties;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(long available) {
        this.available = available;
    }

    public long getOnHold() {
        return onHold;
    }

    public void setOnHold(long onHold) {
        this.onHold = onHold;
    }

    public long getEnquiries() {
        return enquiries;
    }

    public void setEnquiries(long enquiries) {
        this.enquiries = enquiries;
    }
}