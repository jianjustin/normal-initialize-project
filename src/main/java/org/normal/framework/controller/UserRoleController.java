package org.normal.framework.controller;

import org.normal.framework.domain.UserRole;
import org.normal.framework.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRoleController {
    @Autowired
    public UserRoleService userRoleService;

    @GetMapping("/userRoles")
    @PreAuthorize("hasAuthority('UserRole.getAllUserRoles')")
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/userRoles/{id}")
    @PreAuthorize("hasAuthority('UserRole.getUserRole')")
    public UserRole getUserRole(@PathVariable("id") long id) {
        return userRoleService.getUserRoleById(id);
    }

    @DeleteMapping("/userRoles/{id}")
    @PreAuthorize("hasAuthority('UserRole.deleteUserRoles')")
    public void deleteUserRoles(@PathVariable("id") long id) {
        userRoleService.delete(id);
    }

    @PostMapping("/userRoles")
    @PreAuthorize("hasAuthority('UserRole.saveUserRoles')")
    public long saveUserRoles(@RequestBody UserRole userRole) {
        userRoleService.saveOrUpdate(userRole);
        return userRole.id;
    }
}
