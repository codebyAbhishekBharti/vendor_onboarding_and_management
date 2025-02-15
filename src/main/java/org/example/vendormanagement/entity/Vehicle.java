package org.example.vendormanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private ObjectId id;
    private String vendorId; // Which vendor owns it
    private String registrationNumber;
    private String model;
    private int seatingCapacity;
    private String fuelType;
    private boolean isActive; // Whether it's available for use

    public Vehicle() {}

    public Vehicle(String vendorId, String registrationNumber, String model, int seatingCapacity, String fuelType, boolean isActive) {
        this.vendorId = vendorId;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
        this.isActive = isActive;
    }

    // Getters & Setters
}
