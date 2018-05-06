package org.jerry.light4j.member.etm.member.user.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.etm.member.user.domain.MemberUser;
import org.jerry.light4j.member.etm.member.user.repository.MemberUserRepository;
import org.jerry.light4j.member.etm.member.user.service.MemberUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberUserServiceImpl implements MemberUserService{
	@Autowired
	private MemberUserRepository memberUserRepository;
	@Autowired
	private BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl;
	
	public MemberUser save(MemberUser memberUser) {
		return memberUserRepository.save(memberUser);
	}
	
	public MemberUser update(MemberUser memberUser) {
		return memberUserRepository.save(memberUser);
	}

	public MemberUser delete(MemberUser memberUser) {
		memberUserRepository.delete(memberUser);
	    return memberUser;
	}
	
	public  List<MemberUser> queryAllByJPQL(String jpql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllByJPQL(jpql, paramValueList, MemberUser.class);
	}

	public List<Map<String, Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnByJPQL(jpql, paramValueList, MemberUser.class);
	}

	public  List<MemberUser> queryAllBySQL(String sql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllBySQL(sql, paramValueList, MemberUser.class);
	}

	public List<Map<String, Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnBySQL(sql, paramValueList, MemberUser.class);
	}
	

	public MemberUserRepository getMemberUserRepository() {
		return memberUserRepository;
	}
	public void setMemberUserRepository(MemberUserRepository MemberUserRepository) {
		this.memberUserRepository = memberUserRepository;
	}
	public BaseQueryRepositoryImpl<MemberUser, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
}
