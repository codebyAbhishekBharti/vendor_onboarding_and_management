package org.example.vendormanagement.repository;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, ObjectId> {
    Vehicle findByAssignedVendorId(ObjectId vendorId);
}
