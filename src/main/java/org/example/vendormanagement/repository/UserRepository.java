package org.example.vendormanagement.repository;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.User;
import org.example.vendormanagement.entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Vendor findByName(String name);
}