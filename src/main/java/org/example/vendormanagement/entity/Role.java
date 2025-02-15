package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "roles")
@Data
@AllArgsConstructor
public class Role {
    @Id
    private ObjectId id;
    private String name; //"SuperVendor", "VendorManager", "Driver"
    private List<String> permissions; //["CAN_ADD_DRIVERS", "CAN_MANAGE_VEHICLES"]

    public Role(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

}
