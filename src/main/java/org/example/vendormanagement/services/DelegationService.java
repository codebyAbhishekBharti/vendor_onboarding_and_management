package org.example.vendormanagement.services;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Delegation;
import org.example.vendormanagement.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DelegationService {
    @Autowired
    private DelegationRepository delegationRepository;

    public Delegation createDelegation(Delegation delegation) {
        return delegationRepository.save(delegation);
    }

    public List<Delegation> getAllDelegations() {
        return delegationRepository.findAll();
    }

    public Optional<Delegation> getDelegationById(ObjectId id) {
        return delegationRepository.findById(id);
    }

    public Delegation updateDelegation(ObjectId id, Delegation updatedDelegation) {
        if (delegationRepository.existsById(id)) {
            updatedDelegation.setId(id);
            return delegationRepository.save(updatedDelegation);
        }
        return null;
    }

    public void deleteDelegation(ObjectId id) {
        delegationRepository.deleteById(id);
    }
}
