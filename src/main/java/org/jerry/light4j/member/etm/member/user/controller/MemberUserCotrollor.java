package org.jerry.light4j.member.etm.member.user.controller;

import java.io.Serializable;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.etm.member.user.api.MemberUserApi;
import org.jerry.light4j.member.etm.member.user.domain.MemberUser;
import org.jerry.light4j.member.etm.member.user.service.MemberUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;



@RestController
@Scope("prototype")
public class MemberUserCotrollor implements MemberUserApi{
    @Autowired
	private MemberUserService memberUserService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl;
    
    @Override
	public ResponseEntity<?> save(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
    	memberUserService.save(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> delete(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
		memberUserService.delete(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> update(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
		memberUserService.update(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
    
	public MemberUserService getMemberUserService() {
		return memberUserService;
	}
	public void setMemberUserService(MemberUserService memberUserService) {
		this.memberUserService = memberUserService;
	}
	public BaseQueryRepositoryImpl<MemberUser, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	

    
    
}
