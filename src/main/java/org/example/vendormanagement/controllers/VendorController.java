package org.example.vendormanagement.controllers;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Vendor;
import org.example.vendormanagement.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Optional<Vendor> getVendorById(@PathVariable ObjectId id) {
        return vendorService.getVendorById(id);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable ObjectId id, @RequestBody Vendor vendor) {
        return vendorService.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable ObjectId id) {
        vendorService.deleteVendor(id);
    }
}
