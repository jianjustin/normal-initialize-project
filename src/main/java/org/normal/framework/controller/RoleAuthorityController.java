package org.normal.framework.controller;

import org.normal.framework.domain.RoleAuthority;
import org.normal.framework.service.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleAuthorityController {
    @Autowired
    public RoleAuthorityService roleAuthorityService;

    @GetMapping("/roleAuthorities")
    @PreAuthorize("hasAuthority('RoleAuthority.getAllRoleAuthorities')")
    public List<RoleAuthority> getAllRoleAuthorities() {
        return roleAuthorityService.getAllRoleAuthorities();
    }

    @GetMapping("/roleAuthorities/{id}")
    @PreAuthorize("hasAuthority('RoleAuthority.getRoleAuthority')")
    public RoleAuthority getRoleAuthority(@PathVariable("id") long id) {
        return roleAuthorityService.getRoleAuthorityById(id);
    }

    @DeleteMapping("/roleAuthorities/{id}")
    @PreAuthorize("hasAuthority('RoleAuthority.deleteRoleAuthority')")
    public void deleteRoleAuthority(@PathVariable("id") long id) {
        roleAuthorityService.delete(id);
    }

    @PostMapping("/roleAuthorities")
    @PreAuthorize("hasAuthority('RoleAuthority.saveRoleAuthority')")
    public long saveRoleAuthority(@RequestBody RoleAuthority roleAuthority) {
        roleAuthorityService.saveOrUpdate(roleAuthority);
        return roleAuthority.id;
    }
}
