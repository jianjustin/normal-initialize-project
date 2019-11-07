package org.normal.framework.controller;

import org.normal.framework.domain.Authority;
import org.normal.framework.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;
    @GetMapping("/authorities")
    @PreAuthorize("hasAuthority('Authority.getAllAuthorities')")
    public List<Authority> getAllAuthorities() {
        return authorityService.getAllAuthorities();
    }

    @GetMapping("/authorities/{id}")
    @PreAuthorize("hasAuthority('Authority.getAuthority')")
    public Authority getAuthority(@PathVariable("id") long id) {
        return authorityService.getAuthorityById(id);
    }

    @DeleteMapping("/authorities/{id}")
    @PreAuthorize("hasAuthority('Authority.deleteAuthority')")
    public void deleteAuthority(@PathVariable("id") long id) {
        authorityService.delete(id);
    }

    @PostMapping("/authorities")
    @PreAuthorize("hasAuthority('Authority.saveAuthority')")
    public long saveAuthority(@RequestBody Authority authority) {
        authorityService.saveOrUpdate(authority);
        return authority.id;
    }
}
