package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    private ObjectId id;
    @NonNull
    private String registrationNumber;
    @NonNull
    private String model;
    private String type; // e.g., Truck, Car, Bike
    private boolean isAvailable;
    private ObjectId assignedVendorId; // Vendor managing this vehicle
    private ObjectId assignedDriverId; // Driver assigned to the vehicle
}