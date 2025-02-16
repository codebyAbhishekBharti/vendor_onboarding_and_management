package org.example.vendormanagement.controllers.additionalcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
@PreAuthorize("hasRole('Driver')")
public class DriverController {

    @PostMapping("/healthcheck")
    public ResponseEntity<String> approveVendor() {
        return ResponseEntity.ok("This is Driver Controller");
    }
}
