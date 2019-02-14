package org.jerry.light4j.member.etm.member.user.controller;

import java.io.Serializable;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.etm.member.user.domain.MemberUser;
import org.jerry.light4j.member.etm.member.user.service.MemberUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="member.user",value="用户模块")
@RequestMapping(value = "/member/user/",produces = { "application/json; charset=UTF-8" })
public class MemberUserControllor{
    @Autowired
	private MemberUserService memberUserService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl;
    
    @ApiOperation(value = "新增用户")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
    	memberUserService.save(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
	
    @ApiOperation(value = "删除用户")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
		memberUserService.delete(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
	
    @ApiOperation(value = "实体修改")
	@RequestMapping(method = RequestMethod.PUT)
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
