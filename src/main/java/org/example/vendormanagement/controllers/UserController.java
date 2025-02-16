package org.example.vendormanagement.controllers;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.User;
import org.example.vendormanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for user-related operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable ObjectId id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update user details
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ObjectId id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //add permission overide from any super vendor to any sub vendor
    @PutMapping("/permission/add")
    public ResponseEntity<?> dfsPermissionOverrideAdd(@RequestParam String targetEmail, @RequestParam String permission, @RequestParam Boolean value) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        User user = userService.dfsPermissionOverride(currentEmail,targetEmail, permission, value, "add");
        return ResponseEntity.ok(user);
    }

    @PutMapping("/permission/remove")
    public ResponseEntity<?> dfsPermissionOverrideRemove(@RequestParam String targetEmail, @RequestParam String permission) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        User user = userService.dfsPermissionOverride(currentEmail,targetEmail, permission, false, "remove");
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllUsers(@RequestParam String emailToDelete) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentEmail = authentication.getName();
        return userService.dfsDeleteUser(currentEmail, emailToDelete);
    }

    //add permission override for particular user
    @PutMapping("/{id}/permissions/add")
    public ResponseEntity<?> addPermissionOverride(@PathVariable String id, @RequestParam String permission, @RequestParam Boolean value) {
        System.out.println("Hello");
        ObjectId Id = new ObjectId(id);
        User user = userService.addPermissionOverride(Id, permission, value);
        return ResponseEntity.ok(user);
    }

    //remove permission override for particular user
    @PutMapping("/{id}/permissions/remove")
    public ResponseEntity<?> removePermissionOverride(@PathVariable String id, @RequestParam String permission) {
        ObjectId Id = new ObjectId(id);
        User user = userService.removePermissionOverride(Id, permission);
        return ResponseEntity.ok(user);
    }
}
