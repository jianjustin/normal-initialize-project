package org.normal.framework.etm.member.role.repository;

import java.io.Serializable;

import org.normal.framework.common.base.repository.BaseMotifyRepository;
import org.normal.framework.etm.member.role.domain.MemberRole;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author janine
 * @since 2017-12-12
 *********************************************/
@Repository
public interface MemberRoleRepository extends BaseMotifyRepository<MemberRole, Serializable>{

	public MemberRole findByMemberRoleCode(String memberRoleCode);
}
