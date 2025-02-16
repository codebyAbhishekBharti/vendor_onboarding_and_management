package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Represents a user in the vendor management system.
 */
@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    @Indexed(unique = true)
    @NonNull
    private String email;
    @NonNull
    private String password;
    private String vendorId;
    private Set<String> roles = new HashSet<>(); // ["SUPER_VENDOR", "REGIONAL_VENDOR"]
    private ObjectId delegationId; // delegation received by this user
    // user specific permission overrides (e.g., {"canManageBooking": false})
    private Map<String, Boolean> permissionOverrides = new HashMap<>();
    private List<String> subVendorIds = new ArrayList<>();
}
