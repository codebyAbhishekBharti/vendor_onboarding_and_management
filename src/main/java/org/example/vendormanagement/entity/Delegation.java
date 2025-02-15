package org.example.vendormanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "delegations")
@Data
@NoArgsConstructor
public class Delegation {
    @Id
    private ObjectId id;
    private String superVendorId;
    private String subVendorId;
    private List<String> allowedActions; //["MANAGE_DRIVERS", "MANAGE_VEHICLES"]
    private boolean isActive; //can be revoked at any time

    public Delegation(String superVendorId, String subVendorId, List<String> allowedActions, boolean isActive) {
        this.superVendorId = superVendorId;
        this.subVendorId = subVendorId;
        this.allowedActions = allowedActions;
        this.isActive = isActive;
    }
}
