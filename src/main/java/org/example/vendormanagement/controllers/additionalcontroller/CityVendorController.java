package org.example.vendormanagement.controllers.additionalcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city_vendor")
@PreAuthorize("hasRole('CITY_VENDOR')")
public class CityVendorController {

    @PostMapping("/healthcheck")
    public ResponseEntity<String> approveVendor() {
        return ResponseEntity.ok("This is City Vendor Controller");
    }
}
