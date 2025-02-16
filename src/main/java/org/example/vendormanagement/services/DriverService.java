package org.example.vendormanagement.service;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Driver;
import org.example.vendormanagement.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    // Create a new driver
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Get all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Get driver by ID
    public Optional<Driver> getDriverById(ObjectId id) {
        return driverRepository.findById(id);
    }

    // Get drivers assigned to a vendor
    public List<Driver> getDriversByVendor(ObjectId vendorId) {
        return driverRepository.findByAssignedVendorId(vendorId);
    }

    // Update driver details
    public Driver updateDriver(ObjectId id, Driver updatedDriver) {
        if (driverRepository.existsById(id)) {
            updatedDriver.setId(id);
            return driverRepository.save(updatedDriver);
        }
        throw new RuntimeException("Driver not found");
    }

    // Delete driver
    public void deleteDriver(ObjectId id) {
        driverRepository.deleteById(id);
    }
}
