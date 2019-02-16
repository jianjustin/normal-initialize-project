package org.normal.framework.etm.member.authority.repository;

import java.io.Serializable;

import org.normal.framework.common.base.repository.BaseMotifyRepository;
import org.normal.framework.etm.member.authority.domain.MemberAuthority;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author tools
 *********************************************/
@Repository
public interface MemberAuthorityRepository extends BaseMotifyRepository<MemberAuthority, Serializable>{

	public MemberAuthority findByMemberAuthorityCode(String memberAuthorityCode);
}
