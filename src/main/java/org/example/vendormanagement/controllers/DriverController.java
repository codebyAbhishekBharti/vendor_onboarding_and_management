package org.example.vendormanagement.controllers;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Driver;
import org.example.vendormanagement.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for Driver management.
 */
@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // Create a new driver
    @PostMapping
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.addDriver(driver));
    }

    // Get all drivers
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    // Get a driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable String id) {
        Optional<Driver> driver = driverService.getDriverById(new ObjectId(id));
        return driver.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get drivers assigned to a vendor
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Driver>> getDriversByVendor(@PathVariable String vendorId) {
        return ResponseEntity.ok(driverService.getDriversByVendor(new ObjectId(vendorId)));
    }

    // Update driver
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable String id, @RequestBody Driver updatedDriver) {
        return ResponseEntity.ok(driverService.updateDriver(new ObjectId(id), updatedDriver));
    }

    // Delete driver
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable String id) {
        driverService.deleteDriver(new ObjectId(id));
        return ResponseEntity.noContent().build();
    }
}
