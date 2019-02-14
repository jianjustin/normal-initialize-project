package org.jerry.light4j.member.etm.member.authority.service.impl;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.etm.member.authority.domain.MemberAuthority;
import org.jerry.light4j.member.etm.member.authority.repository.MemberAuthorityRepository;
import org.jerry.light4j.member.etm.member.authority.service.MemberAuthorityService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAuthorityServiceImpl implements MemberAuthorityService{
	@Autowired
	private MemberAuthorityRepository memberAuthorityRepository;
	@Autowired
	private BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl;
	
	public MemberAuthority save(MemberAuthority memberAuthority) {
		return memberAuthorityRepository.save(memberAuthority);
	}
	
	public MemberAuthority update(MemberAuthority memberAuthority) {
		return memberAuthorityRepository.save(memberAuthority);
	}

	public MemberAuthority delete(MemberAuthority memberAuthority) {
		memberAuthorityRepository.delete(memberAuthority);
	    return memberAuthority;
	}
	
	public  List<MemberAuthority> queryAllByJPQL(String jpql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllByJPQL(jpql, paramValueList, MemberAuthority.class);
	}

	public List<Map<String, Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnByJPQL(jpql, paramValueList, MemberAuthority.class);
	}

	public  List<MemberAuthority> queryAllBySQL(String sql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllBySQL(sql, paramValueList, MemberAuthority.class);
	}

	public List<Map<String, Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnBySQL(sql, paramValueList, MemberAuthority.class);
	}
	

	public MemberAuthorityRepository getMemberAuthorityRepository() {
		return memberAuthorityRepository;
	}
	public void setMemberAuthorityRepository(MemberAuthorityRepository memberAuthorityRepository) {
		this.memberAuthorityRepository = memberAuthorityRepository;
	}
	public BaseQueryRepositoryImpl<MemberAuthority, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
}
