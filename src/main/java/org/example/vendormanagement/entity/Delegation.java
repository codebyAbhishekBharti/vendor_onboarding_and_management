package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "delegations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delegation {
    @Id
    private ObjectId id;
    @NonNull
    private String superVendorId; // who gave delegation
    @NonNull
    private String subVendorId; // who received delegation
    private Map<String, Boolean> delegatedPermissions;// {"approveVendor": true, "manageDrivers": false}
    private LocalDateTime createdAt = LocalDateTime.now();
}
