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

@Document(collection = "vendors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    @Id
    private ObjectId id;

    @NonNull
    private String name;

    private String superVendorId; // links to a SuperVendor (if applicable)

    private List<String> subVendors = new ArrayList<>(); // stores IDs of sub-vendors

    private List<ObjectId> drivers = new ArrayList<>(); // stores IDs of drivers assigned

    private List<ObjectId> vehicles = new ArrayList<>(); // stores IDs of vehicles assigned
}
