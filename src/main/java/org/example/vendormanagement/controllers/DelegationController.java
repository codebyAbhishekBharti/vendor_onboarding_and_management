package org.example.vendormanagement.controllers;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Delegation;
import org.example.vendormanagement.services.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delegations")
public class DelegationController {
    @Autowired
    private DelegationService delegationService;

    @PostMapping
    public Delegation createDelegation(@RequestBody Delegation delegation) {
        return delegationService.createDelegation(delegation);
    }

    @GetMapping
    public List<Delegation> getAllDelegations() {
        return delegationService.getAllDelegations();
    }

    @GetMapping("/{id}")
    public Optional<Delegation> getDelegationById(@PathVariable ObjectId id) {
        return delegationService.getDelegationById(id);
    }

    @PutMapping("/{id}")
    public Delegation updateDelegation(@PathVariable ObjectId id, @RequestBody Delegation delegation) {
        return delegationService.updateDelegation(id, delegation);
    }

    @DeleteMapping("/{id}")
    public void deleteDelegation(@PathVariable ObjectId id) {
        delegationService.deleteDelegation(id);
    }
}
