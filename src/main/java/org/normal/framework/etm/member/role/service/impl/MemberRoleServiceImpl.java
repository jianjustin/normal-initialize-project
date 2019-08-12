package org.normal.framework.etm.member.role.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.normal.framework.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.normal.framework.etm.member.role.domain.MemberRole;
import org.normal.framework.etm.member.role.repository.MemberRoleRepository;
import org.normal.framework.etm.member.role.service.MemberRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRoleServiceImpl implements MemberRoleService{
	@Autowired
	private MemberRoleRepository memberRoleRepository;
	@Autowired
	private BaseQueryRepositoryImpl<MemberRole, Serializable> baseQueryRepositoryImpl;
	
	public MemberRole save(MemberRole memberRole) {
		return memberRoleRepository.save(memberRole);
	}
	
	public MemberRole update(MemberRole memberRole) {
		return memberRoleRepository.save(memberRole);
	}

	public MemberRole delete(MemberRole memberRole) {
		memberRoleRepository.delete(memberRole);
	    return memberRole;
	}
	
	public  List<MemberRole> queryAllByJPQL(String jpql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllByJPQL(jpql, paramValueList, MemberRole.class);
	}

	public List<Map<String, Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnByJPQL(jpql, paramValueList, MemberRole.class);
	}

	public  List<MemberRole> queryAllBySQL(String sql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllBySQL(sql, paramValueList, MemberRole.class);
	}

	public List<Map<String, Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnBySQL(sql, paramValueList, MemberRole.class);
	}
	

	public MemberRoleRepository getMemberRoleRepository() {
		return memberRoleRepository;
	}
	public void setMemberRoleRepository(MemberRoleRepository memberRoleRepository) {
		this.memberRoleRepository = memberRoleRepository;
	}
	public BaseQueryRepositoryImpl<MemberRole, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(BaseQueryRepositoryImpl<MemberRole, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
}
