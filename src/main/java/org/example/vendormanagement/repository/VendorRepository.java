package org.example.vendormanagement.repository;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, ObjectId> {
    Vendor findByName(String name);
}