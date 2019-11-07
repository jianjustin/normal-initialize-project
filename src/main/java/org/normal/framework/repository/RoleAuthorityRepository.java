package org.normal.framework.repository;

import org.normal.framework.domain.RoleAuthority;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RoleAuthorityRepository extends CrudRepository<RoleAuthority,Long> {
    List<RoleAuthority> findByMemberRoleId(long memberRoleId);
}
