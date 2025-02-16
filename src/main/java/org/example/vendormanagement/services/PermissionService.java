package org.example.vendormanagement.services;

import org.example.vendormanagement.entity.Role;
import org.example.vendormanagement.entity.User;
import org.example.vendormanagement.repository.RoleRepository;
import org.example.vendormanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class PermissionService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public boolean hasPermission(String email, String requestURI, String method) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // admins have full access
        if (user.getRoles().contains("ADMIN")) return true;
        // extract permission key from request URI
        String permissionKey = getPermissionKey(requestURI,method);
        // fetch all role-based permissions
        Map<String, Boolean> rolePermissions = new HashMap<>();
        for (String roleName : user.getRoles()) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            rolePermissions.putAll(role.getPermissions());
        }
        // fetch user-specific permission overrides
        Map<String, Boolean> userOverrides = user.getPermissionOverrides();
        // fetch delegation permissions (if exists)
        Map<String, Boolean> delegatedPermissions = Collections.emptyMap();
        if (user.getDelegationId() != null) {
            User delegator = userRepository.findById(user.getDelegationId())
                    .orElseThrow(() -> new RuntimeException("Delegator not found"));
            for (String roleName : delegator.getRoles()) {
                Role delegatorRole = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Delegator's role not found: " + roleName));
                delegatedPermissions.putAll(delegatorRole.getPermissions());
            }
        }
        // first, check user specific overrides
        if (userOverrides.containsKey(permissionKey)) {
            return userOverrides.get(permissionKey);
        }
        // check role-based or delegated permissions
//        return rolePermissions.getOrDefault(permissionKey, false) ||
//                delegatedPermissions.getOrDefault(permissionKey, false);
        //Temporary allowing all URIs
        return rolePermissions.getOrDefault(permissionKey, false) ||
                delegatedPermissions.getOrDefault(permissionKey, false);
    }

    // Helper method to map request URIs to permission keys
    private String getPermissionKey(String requestURI, String method) {
        if(requestURI.matches("/users/permission/[a-fA-F0-9]+$") && method.equals("PUT")){
            return "canAssignRoles";
        }
        if (requestURI.matches("^/users/[a-fA-F0-9]+$")) {
            return switch (method) {
                case "GET" -> "canAddSubVendors";
                case "PUT" -> "canEditUser";
                case "DELETE" -> "canDeleteUser";
                default -> "";
            };
        }
        return switch (requestURI) {
            case "/users" -> "canAddSubVendors";
            default -> "";
        };
    }
}
