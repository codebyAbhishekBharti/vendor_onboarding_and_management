package org.example.vendormanagement.services;

import org.bson.types.ObjectId;
import org.example.vendormanagement.entity.User;
import org.example.vendormanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        try{
            user.setId(ObjectId.get());
        }
        catch (Exception e){
            System.out.println(e);
//            throw new RuntimeException("Error creating user");
            return null;
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public User updateUser(ObjectId id, User updatedUser) {
        if (userRepository.existsById(id)) {
            User existingUser = userRepository.findById(id).get();

            if (updatedUser.getName() == null || updatedUser.getName().isEmpty()) {
                updatedUser.setName(existingUser.getName());
            }

            if (updatedUser.getEmail() == null || updatedUser.getEmail().isEmpty()) {
                updatedUser.setEmail(existingUser.getEmail());
            }

            if (updatedUser.getPassword() == null || updatedUser.getPassword().isEmpty()) {
                updatedUser.setPassword(existingUser.getPassword());
            }

            if (updatedUser.getVendorId() == null || updatedUser.getVendorId().isEmpty()) {
                updatedUser.setVendorId(existingUser.getVendorId());
            }

            if (updatedUser.getRoleId() == null || updatedUser.getRoleId().isEmpty()) {
                updatedUser.setRoleId(existingUser.getRoleId());
            }

            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public boolean deleteUser(ObjectId id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
