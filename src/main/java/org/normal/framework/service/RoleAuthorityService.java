package org.normal.framework.service;

import org.normal.framework.domain.RoleAuthority;
import org.normal.framework.repository.RoleAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleAuthorityService {
    @Autowired
    public RoleAuthorityRepository roleAuthorityRepository;

    public List<RoleAuthority> getAllRoleAuthorities() {
        List<RoleAuthority> roleAuthorities = new ArrayList<RoleAuthority>();
        roleAuthorityRepository.findAll().forEach(roleAuthority -> roleAuthorities.add(roleAuthority));
        return roleAuthorities;
    }
    public RoleAuthority getRoleAuthorityById(long id) {
        return roleAuthorityRepository.findById(id).get();
    }
    public void saveOrUpdate(RoleAuthority roleAuthority) {
        roleAuthorityRepository.save(roleAuthority);
    }
    public void delete(long id) {
        roleAuthorityRepository.deleteById(id);
    }
}
