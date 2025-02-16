package org.example.vendormanagement.controllers;

import com.mongodb.DuplicateKeyException;
import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.Role;
import org.example.vendormanagement.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    // Get all roles
    @GetMapping
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    // Get role by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable ObjectId id) {
        return roleService.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update a role
    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody Role role) {
        try {
            return ResponseEntity.ok(roleService.saveRole(role));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate role name");
        }
    }

    // Delete role by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable ObjectId id) {
        return roleService.deleteRole(id)
                ? ResponseEntity.ok("Role deleted successfully.")
                : ResponseEntity.notFound().build();
    }

    // add a permission to a role
    @PutMapping("/{id}/permissions/add")
    public ResponseEntity<?> addPermission(@PathVariable ObjectId id, @RequestParam String permission, @RequestParam Boolean value) {
        return roleService.addPermission(id, permission, value)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // remove a permission from a role
    @PutMapping("/{id}/permissions/remove")
    public ResponseEntity<?> removePermission(@PathVariable ObjectId id, @RequestParam String permission) {
        return roleService.removePermission(id, permission)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
