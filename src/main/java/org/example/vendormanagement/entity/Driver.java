package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "drivers") // Specifies MongoDB collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    @NonNull
    private String licenseNumber;
    private String phone;
    private boolean isActive;
    private ObjectId assignedVendorId; // Vendor managing this driver
    private List<ObjectId> assignedVehicles = new ArrayList<>(); // List of assigned vehicles
}
