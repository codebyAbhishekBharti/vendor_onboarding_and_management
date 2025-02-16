package org.example.vendormanagement.services;

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

    // Register Driver
    public Driver registerDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Get All Drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Get Driver by ID
    public Optional<Driver> getDriverById(ObjectId id) {
        return driverRepository.findById(id);
    }

    // Update Driver Details
    public Driver updateDriver(ObjectId id, Driver updatedDriver) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(updatedDriver.getName());
            driver.setLicenseNumber(updatedDriver.getLicenseNumber());
            driver.setPhone(updatedDriver.getPhone());
            driver.setActive(updatedDriver.isActive());
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    // Assign a Vendor to a Driver
    public Driver assignVendorToDriver(ObjectId driverId, ObjectId vendorId) {
        return driverRepository.findById(driverId).map(driver -> {
            driver.setAssignedVendorId(vendorId);
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    // Assign a Vehicle to a Driver
    public Driver assignVehicleToDriver(ObjectId driverId, ObjectId vehicleId) {
        return driverRepository.findById(driverId).map(driver -> {
            driver.getAssignedVehicles().add(vehicleId);
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    // Remove a Vehicle from a Driver
    public Driver removeVehicleFromDriver(ObjectId driverId, ObjectId vehicleId) {
        return driverRepository.findById(driverId).map(driver -> {
            driver.getAssignedVehicles().remove(vehicleId);
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    // Delete a Driver
    public void deleteDriver(ObjectId id) {
        driverRepository.deleteById(id);
    }

    // Change Driver Status (Active/Inactive)
    public Driver changeDriverStatus(ObjectId id, boolean status) {
        return driverRepository.findById(id).map(driver -> {
            driver.setActive(status);
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }
}
