package org.example.vendormanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

@org.springframework.data.mongodb.core.mapping.Document(collection = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    private ObjectId id;
    private String documentName;
    private String documentType; // e.g., "License", "Registration", "Insurance"
    private String fileUrl; // Path to stored file
    private ObjectId ownerId; // Could be Driver ID or Vendor ID
    private String ownerType; // "Driver" or "Vendor"
    private Date uploadedAt;
}
