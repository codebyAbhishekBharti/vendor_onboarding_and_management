package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

/**
 * Represents a role in the vendor management system.
 */
@Document(collection = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String name; // "SUPER_VENDOR", "REGIONAL_VENDOR", "DRIVER"
    private Map<String, Boolean> permissions; // {"manageDrivers": true, "approveVendor": false}
}
