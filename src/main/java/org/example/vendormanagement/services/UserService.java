package org.example.vendormanagement.services;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.User;
import org.example.vendormanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Service for managing users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create a new user
    public User createUser(User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        user.setVendorId(userName);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    // Update user details
    public User updateUser(ObjectId id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            if (updatedUser.getName() != null) {
                user.setName(updatedUser.getName());
            }
            if (updatedUser.getEmail() != null) {
                user.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getRoles() != null && !updatedUser.getRoles().isEmpty()) {
                user.setRoles(updatedUser.getRoles());
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete user by ID
    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User addPermissionOverride(ObjectId id, String permissionKey, boolean value) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Ensure map is initialized
        if (user.getPermissionOverrides() == null) {
            user.setPermissionOverrides(new HashMap<>());
        }
        // Add or update permission override
        user.getPermissionOverrides().put(permissionKey, value);
        // Save updated user
        userRepository.save(user);
        return user;
    }

    public User removePermissionOverride(ObjectId id, String permissionKey) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        //remove permission override if exists
        if (user.getPermissionOverrides() != null) {
            user.getPermissionOverrides().remove(permissionKey);
            userRepository.save(user);
        }
        return user;
    }



}
