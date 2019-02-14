package org.jerry.light4j.member.etm.member.resource.service.impl;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.etm.member.resource.domain.MemberResource;
import org.jerry.light4j.member.etm.member.resource.repository.MemberResourceRepository;
import org.jerry.light4j.member.etm.member.resource.service.MemberResourceService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberResourceServiceImpl implements MemberResourceService{
	@Autowired
	private MemberResourceRepository memberResourceRepository;
	@Autowired
	private BaseQueryRepositoryImpl<MemberResource, Serializable> baseQueryRepositoryImpl;
	
	public MemberResource save(MemberResource memberResource) {
		return memberResourceRepository.save(memberResource);
	}
	
	public MemberResource update(MemberResource memberResource) {
		return memberResourceRepository.save(memberResource);
	}

	public MemberResource delete(MemberResource memberResource) {
		memberResourceRepository.delete(memberResource);
	    return memberResource;
	}
	
	public  List<MemberResource> queryAllByJPQL(String jpql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllByJPQL(jpql, paramValueList, MemberResource.class);
	}

	public List<Map<String, Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnByJPQL(jpql, paramValueList, MemberResource.class);
	}

	public  List<MemberResource> queryAllBySQL(String sql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllBySQL(sql, paramValueList, MemberResource.class);
	}

	public List<Map<String, Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnBySQL(sql, paramValueList, MemberResource.class);
	}
	

	public MemberResourceRepository getMemberResourceRepository() {
		return memberResourceRepository;
	}
	public void setMemberResourceRepository(MemberResourceRepository memberResourceRepository) {
		this.memberResourceRepository = memberResourceRepository;
	}
	public BaseQueryRepositoryImpl<MemberResource, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(BaseQueryRepositoryImpl<MemberResource, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
}
