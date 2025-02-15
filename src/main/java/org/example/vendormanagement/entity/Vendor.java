package org.example.vendormanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "vendors")
@Data
@NoArgsConstructor
public class Vendor {
    @Id
    private ObjectId id;
    private String name;
    private String type; //"SuperVendor", "RegionalVendor", "CityVendor"
    private String parentVendorId; //allows hierarchy
    private List<String> subVendorIds; //stores child vendors

    public Vendor(String name, String type, String parentVendorId, List<String> subVendorIds) {
        this.name = name;
        this.type = type;
        this.parentVendorId = parentVendorId;
        this.subVendorIds = subVendorIds;
    }
}
