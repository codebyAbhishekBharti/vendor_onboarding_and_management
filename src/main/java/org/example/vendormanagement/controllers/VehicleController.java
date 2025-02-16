package org.example.vendormanagement.controllers;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Vehicle;
import org.example.vendormanagement.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Register Vehicle
    @PostMapping
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService.registerVehicle(vehicle);
        return ResponseEntity.ok(newVehicle);
    }

    // Get All Vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    // Get Vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(new ObjectId(id));
        return vehicle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Vehicle
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable String id, @RequestBody Vehicle updatedVehicle) {
        return ResponseEntity.ok(vehicleService.updateVehicle(new ObjectId(id), updatedVehicle));
    }

    // Delete Vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(new ObjectId(id));
        return ResponseEntity.noContent().build();
    }

    // Assign a Vendor to a Vehicle
    @PutMapping("/{id}/assign-vendor")
    public ResponseEntity<Vehicle> assignVendor(@PathVariable String id, @RequestParam String vendorId) {
        return ResponseEntity.ok(vehicleService.assignVendorToVehicle(new ObjectId(id), new ObjectId(vendorId)));
    }

    // Assign a Driver to a Vehicle
    @PutMapping("/{id}/assign-driver")
    public ResponseEntity<Vehicle> assignDriver(@PathVariable String id, @RequestParam String driverId) {
        return ResponseEntity.ok(vehicleService.assignDriverToVehicle(new ObjectId(id), new ObjectId(driverId)));
    }

    // Remove Driver from Vehicle
    @PutMapping("/{id}/remove-driver")
    public ResponseEntity<Vehicle> removeDriver(@PathVariable String id) {
        return ResponseEntity.ok(vehicleService.removeDriverFromVehicle(new ObjectId(id)));
    }

    // Change Vehicle Availability
    @PutMapping("/{id}/availability")
    public ResponseEntity<Vehicle> changeVehicleAvailability(@PathVariable String id, @RequestParam boolean isAvailable) {
        return ResponseEntity.ok(vehicleService.changeVehicleAvailability(new ObjectId(id), isAvailable));
    }
}
