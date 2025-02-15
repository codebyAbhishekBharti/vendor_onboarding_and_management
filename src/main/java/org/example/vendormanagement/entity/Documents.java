package org.example.vendormanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents")
@Data
@NoArgsConstructor
public class Documents {
    @Id
    private ObjectId id;
    private String entityId; //links to a driver or vehicle
    private String entityType; //"driver" or "vehicle"
    private String documentType; //"DL","RC","Insurance"
    private String documentUrl; //cloud storage link
    private String status; // "Pending","Approved","Rejected"

    public Documents(String entityId, String entityType, String documentType, String documentUrl, String status) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.documentType = documentType;
        this.documentUrl = documentUrl;
        this.status = status;
    }
}
