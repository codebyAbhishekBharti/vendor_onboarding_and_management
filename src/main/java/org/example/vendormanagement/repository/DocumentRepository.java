package org.example.vendormanagement.repository;

import org.example.vendormanagement.entity.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DocumentRepository extends MongoRepository<Document, ObjectId> {
    List<Document> findByOwnerIdAndOwnerType(ObjectId ownerId, String ownerType);
}
