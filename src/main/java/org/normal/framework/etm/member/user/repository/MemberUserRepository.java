package org.normal.framework.etm.member.user.repository;

import java.io.Serializable;

import org.normal.framework.common.base.repository.BaseMotifyRepository;
import org.normal.framework.etm.member.user.domain.MemberUser;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author tools
 *********************************************/
@Repository
public interface MemberUserRepository extends BaseMotifyRepository<MemberUser, Serializable>{

	public MemberUser findByMemberUserCode(String memberUserCode);
	
	public MemberUser findByMemberUserLoginAccountAndMemberUserLoginPassword(String memberUserLoginAccount,String MemberUserLoginPassword);
}
