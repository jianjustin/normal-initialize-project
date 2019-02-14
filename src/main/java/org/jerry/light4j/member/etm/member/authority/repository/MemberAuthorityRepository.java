package org.jerry.light4j.member.etm.member.authority.repository;

import java.io.Serializable;

import org.jerry.light4j.member.common.base.repository.BaseMotifyRepository;
import org.jerry.light4j.member.etm.member.authority.domain.MemberAuthority;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author tools
 *********************************************/
@Repository
public interface MemberAuthorityRepository extends BaseMotifyRepository<MemberAuthority, Serializable>{

	public MemberAuthority findByMemberAuthorityCode(String memberAuthorityCode);
}
