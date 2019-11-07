package org.normal.framework.repository;

import org.normal.framework.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByMemberUserName(String memberUserName);
}
