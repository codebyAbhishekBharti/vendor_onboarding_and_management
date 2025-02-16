package org.example.vendormanagement.repository;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface DriverRepository extends MongoRepository<Driver, ObjectId> {
    Optional<Driver> findByLicenseNumber(String licenseNumber); // Find driver by license
    List<Driver> findByAssignedVendorId(ObjectId vendorId); // Get drivers under a vendor
}
