package org.example.vendormanagement.services;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Vendor;
import org.example.vendormanagement.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(ObjectId id) {
        return vendorRepository.findById(id);
    }

    public Vendor updateVendor(ObjectId id, Vendor updatedVendor) {
        if (vendorRepository.existsById(id)) {
            Vendor existingVendor = vendorRepository.findById(id).get();
            if (updatedVendor.getName() == null || updatedVendor.getName().isEmpty()) {
                updatedVendor.setName(existingVendor.getName());
            }
            if (updatedVendor.getType() == null || updatedVendor.getType().isEmpty()) {
                updatedVendor.setType(existingVendor.getType());
            }
            updatedVendor.setId(id);
            return vendorRepository.save(updatedVendor);
        }
        return null;
    }

    public void deleteVendor(ObjectId id) {
        vendorRepository.deleteById(id);
    }
}
