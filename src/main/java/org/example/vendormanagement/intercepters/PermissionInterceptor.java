package org.example.vendormanagement.intercepters;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.vendormanagement.services.PermissionService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

    private final PermissionService permissionService;

    public PermissionInterceptor(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Extract user email from Spring Security
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof UserDetails userDetails)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authenticated");
            return false;
        }

        String email = userDetails.getUsername();
        String method = request.getMethod();
        System.out.println(method);

        // Check if user has permission for this request
        if (!permissionService.hasPermission(email, request.getRequestURI(), method)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            return false;
        }

        return true; // Allow request to proceed
    }
}
