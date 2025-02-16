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
    private ObjectId assignedVendorId; // vendor managing this vehicle
    private ObjectId assignedDriverId; // assigned Driver (if any)
}
