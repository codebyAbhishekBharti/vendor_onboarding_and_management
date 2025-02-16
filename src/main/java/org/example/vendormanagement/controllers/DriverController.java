package org.example.vendormanagement.controllers;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Driver;
import org.example.vendormanagement.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Register Driver
    @PostMapping
    public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver) {
        Driver newDriver = driverService.registerDriver(driver);
        return ResponseEntity.ok(newDriver);
    }

    // Get All Drivers
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    // Get Driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable String id) {
        Optional<Driver> driver = driverService.getDriverById(new ObjectId(id));
        return driver.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Driver
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable String id, @RequestBody Driver updatedDriver) {
        return ResponseEntity.ok(driverService.updateDriver(new ObjectId(id), updatedDriver));
    }

    // Delete Driver
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable String id) {
        driverService.deleteDriver(new ObjectId(id));
        return ResponseEntity.noContent().build();
    }

    // Change Driver Status (Active/Inactive)
    @PutMapping("/{id}/status")
    public ResponseEntity<Driver> changeDriverStatus(@PathVariable String id, @RequestParam boolean isActive) {
        return ResponseEntity.ok(driverService.changeDriverStatus(new ObjectId(id), isActive));
    }

    // Assign a Vendor to a Driver
    @PutMapping("/{id}/assign-vendor")
    public ResponseEntity<Driver> assignVendor(@PathVariable String id, @RequestParam String vendorId) {
        return ResponseEntity.ok(driverService.assignVendorToDriver(new ObjectId(id), new ObjectId(vendorId)));
    }

    // Assign a Vehicle to a Driver
    @PutMapping("/{id}/assign-vehicle")
    public ResponseEntity<Driver> assignVehicle(@PathVariable String id, @RequestParam String vehicleId) {
        return ResponseEntity.ok(driverService.assignVehicleToDriver(new ObjectId(id), new ObjectId(vehicleId)));
    }

    // Remove a Vehicle from a Driver
    @PutMapping("/{id}/remove-vehicle")
    public ResponseEntity<Driver> removeVehicle(@PathVariable String id, @RequestParam String vehicleId) {
        return ResponseEntity.ok(driverService.removeVehicleFromDriver(new ObjectId(id), new ObjectId(vehicleId)));
    }
}
