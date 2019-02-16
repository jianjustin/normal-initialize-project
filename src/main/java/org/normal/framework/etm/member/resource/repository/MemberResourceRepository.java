package org.normal.framework.etm.member.resource.repository;

import java.io.Serializable;

import org.normal.framework.common.base.repository.BaseMotifyRepository;
import org.normal.framework.etm.member.resource.domain.MemberResource;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author tools
 *********************************************/
@Repository
public interface MemberResourceRepository extends BaseMotifyRepository<MemberResource, Serializable>{

	public MemberResource findByMemberResourceCode(String memberResourceCode);
}
