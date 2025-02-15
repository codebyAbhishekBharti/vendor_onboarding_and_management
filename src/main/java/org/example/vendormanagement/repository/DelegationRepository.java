package org.example.vendormanagement.repository;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Delegation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DelegationRepository extends MongoRepository<Delegation, ObjectId> {
}