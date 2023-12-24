package com.safeway.safeway.models.request;

import com.google.gson.annotations.SerializedName;

public class AddVehicle {
    private String image;
    private String type;
    private String brand;
    private String model;
    @SerializedName("registration_no")
    private String registrationNumber;

    public AddVehicle(String type, String brand, String model, String registrationNumber) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
