package org.example.vendormanagement.services;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Vehicle;
import org.example.vendormanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    // Register Vehicle
    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Get All Vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Get Vehicle by ID
    public Optional<Vehicle> getVehicleById(ObjectId id) {
        return vehicleRepository.findById(id);
    }

    // Update Vehicle
    public Vehicle updateVehicle(ObjectId id, Vehicle updatedVehicle) {
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setType(updatedVehicle.getType());
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    // Delete Vehicle
    public void deleteVehicle(ObjectId id) {
        vehicleRepository.deleteById(id);
    }

    // Assign a Vendor to a Vehicle
    public Vehicle assignVendorToVehicle(ObjectId vehicleId, ObjectId vendorId) {
        return vehicleRepository.findById(vehicleId).map(vehicle -> {
            vehicle.setAssignedVendorId(vendorId);
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    // Assign a Driver to a Vehicle
    public Vehicle assignDriverToVehicle(ObjectId vehicleId, ObjectId driverId) {
        return vehicleRepository.findById(vehicleId).map(vehicle -> {
            vehicle.setAssignedDriverId(driverId);
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    // Remove Driver from Vehicle
    public Vehicle removeDriverFromVehicle(ObjectId vehicleId) {
        return vehicleRepository.findById(vehicleId).map(vehicle -> {
            vehicle.setAssignedDriverId(null);
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    // Change Vehicle Availability
    public Vehicle changeVehicleAvailability(ObjectId id, boolean status) {
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setAvailable(status);
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
}
