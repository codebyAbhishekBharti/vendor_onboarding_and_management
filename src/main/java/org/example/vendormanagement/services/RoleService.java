package org.example.vendormanagement.services;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Role;
import org.example.vendormanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get a role by ID
    public Optional<Role> getRoleById(ObjectId id) {
        return roleRepository.findById(id);
    }

    // Create or update a role
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    // delete a role by ID
    public boolean deleteRole(ObjectId id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // add a specific permission to a role
    public Optional<Role> addPermission(ObjectId roleId, String permission, Boolean value) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            role.getPermissions().put(permission, value);
            return Optional.of(roleRepository.save(role));
        }
        return Optional.empty();
    }

    // remove a specific permission from a role
    public Optional<Role> removePermission(ObjectId roleId, String permission) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            role.getPermissions().remove(permission);
            return Optional.of(roleRepository.save(role));
        }
        return Optional.empty();
    }
}
