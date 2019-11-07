package org.normal.framework.security;

import org.normal.framework.domain.Authority;
import org.normal.framework.domain.RoleAuthority;
import org.normal.framework.domain.User;
import org.normal.framework.domain.UserRole;
import org.normal.framework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class UserModelDetailsService implements UserDetailsService {
    @Autowired
    public BaseRepository baseRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserRoleRepository userRoleRepository;
    @Autowired
    public RoleAuthorityRepository roleAuthorityRepository;
    @Autowired
    public AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByMemberUserName(s);
        if (null == user || user.id == null)
            throw new UsernameNotFoundException("用户账户【"+s+"】查询失败");
        List<CustomGrantedAuthority> list = getGrantedAuthorities(user.id);

        return new org.springframework.security.core.userdetails.User(user.memberUserName,user.memberPassword,list);
    }

    public List<CustomGrantedAuthority> getGrantedAuthorities(long id){
        List<UserRole> userRoles = userRoleRepository.findByMemberUserId(id);
        List<RoleAuthority> roleAuthorities = new ArrayList<RoleAuthority>();
        for (int i = 0; i < userRoles.size(); i++)
            roleAuthorities.addAll(roleAuthorityRepository.findByMemberRoleId(userRoles.get(i).memberRoleId));
        List<Optional<Authority>> authorities = new ArrayList<>();
        for (int i = 0; i < roleAuthorities.size(); i++)
            authorities.add(authorityRepository.findById(roleAuthorities.get(i).memberAuthorityId));
        return authorities.stream()
                .map(authority -> new CustomGrantedAuthority(authority.get().memberResourceRouter))
                .collect(Collectors.toList());
    }

    class CustomGrantedAuthority implements GrantedAuthority {
        private String authority;
        public CustomGrantedAuthority(){}
        public CustomGrantedAuthority(String authority){
            this.authority = authority;
        }

        @Override
        public String getAuthority() {
            return authority;
        }
    }
}
