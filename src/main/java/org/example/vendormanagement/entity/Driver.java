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

@Document(collection = "drivers")
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
    private ObjectId assignedVendorId; // vendor managing this driver
    private List<ObjectId> assignedVehicles = new ArrayList<>(); // vehicles assigned to the driver
}
