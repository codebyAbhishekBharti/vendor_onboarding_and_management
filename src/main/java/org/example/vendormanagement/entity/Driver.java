package org.example.vendormanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "drivers")
@Data
@NoArgsConstructor
public class Driver {
    @Id
    private ObjectId id;
    private String vendorId; // which vendor they belong to
    private String name;
    private String phoneNumber;
    private List<String> assignedVehicles; // list of vehicle IDs
    private List<ObjectId> documents; // list of document IDs
    private boolean isVerified; // whether documents are approved

    public Driver(String vendorId, String name, String phoneNumber, List<String> assignedVehicles, List<ObjectId>documents, boolean isVerified) {
        this.vendorId = vendorId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.assignedVehicles = assignedVehicles;
        this.documents = documents;
        this.isVerified = isVerified;
    }
}
