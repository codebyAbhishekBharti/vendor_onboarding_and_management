package org.example.vendormanagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regional_vendor")
@PreAuthorize("hasRole('REGIONAL_VENDOR')")
public class RegionalVendorController {

    @GetMapping("/healthcheck")
    public ResponseEntity<String> approveVendor() {
        return ResponseEntity.ok("This is Regional Vendor Controller");
    }
}
