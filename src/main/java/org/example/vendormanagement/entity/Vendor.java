package org.example.vendormanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "vendors")
@Data
@NoArgsConstructor
public class Vendor {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String name;
    @NonNull
    private String type; //"SuperVendor", "RegionalVendor", "CityVendor"
    private String parentVendorId=null; //allows hierarchy
    private List<String> subVendorIds = new ArrayList<>(); //stores child vendors

    public Vendor(String name, String type, String parentVendorId, List<String> subVendorIds) {
        this.name = name;
        this.type = type;
        this.parentVendorId = parentVendorId;
        this.subVendorIds = subVendorIds;
    }
}
