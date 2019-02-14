package org.jerry.light4j.member.etm.member.user.repository;

import java.io.Serializable;

import org.jerry.light4j.member.common.base.repository.BaseMotifyRepository;
import org.jerry.light4j.member.etm.member.user.domain.MemberUser;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author tools
 *********************************************/
@Repository
public interface MemberUserRepository extends BaseMotifyRepository<MemberUser, Serializable>{

	public MemberUser findByMemberUserCode(String memberUserCode);
}
