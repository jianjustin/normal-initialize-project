package org.jerry.light4j.member.etm.member.user.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.etm.member.user.domain.MemberUser;
import org.jerry.light4j.member.etm.member.user.domain.MemberUserView;
import org.jerry.light4j.member.etm.member.user.repository.MemberUserRepository;
import org.jerry.light4j.member.etm.member.user.service.MemberUserService;
import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.common.page.PageQueryBean;
import org.jerry.light4j.member.common.page.PageTools;
import org.jerry.light4j.member.common.page.PageUtils;
import org.jerry.light4j.member.common.response.ResponseDomain;
import org.jerry.light4j.member.common.response.ResponseManager;
import org.jerry.light4j.member.common.utils.SqlUtils;
import org.jerry.light4j.member.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@Api(tags="member.user",value="member.user模块")
@RequestMapping(value = "/member/user",produces = { "application/json; charset=UTF-8" },consumes = {"text/plain", "application/json"})
public class MemberUserCotrollor{
    @Autowired
	private MemberUserService memberUserService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberUserRepository memberUserRepository;
    
    @ApiOperation(value="数据插入")
    @RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<?> save(
			@ApiParam(value = "member_user数据", required = true) @RequestBody MemberUser memberUser) {
    	memberUserService.save(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除")
    @RequestMapping(value="/delete/{memberUserCode}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_user数据code", required = true) @PathVariable String memberUserCode) {
		MemberUser oldMemberUser = memberUserRepository.findByMemberUserCode(memberUserCode);
		memberUserService.delete(oldMemberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新")
    @RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<?> update(
			@ApiParam(value = "member_user数据", required = true) @RequestBody MemberUser memberUser) {
		memberUserService.update(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询")
    @RequestMapping(value="/queryByCode/{memberUserCode}", method=RequestMethod.GET)
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_user数据code", required = true) @PathVariable String memberUserCode) {
		MemberUser memberUser = memberUserRepository.findByMemberUserCode(memberUserCode);
		return ResponseManager.handerResponse(MemberUser.class,memberUser, null, HttpStatus.OK, "成功获取数据", null, null);
	}
	
	@ApiOperation(value="数据分页查询")
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST)
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "member_user查询条件") @RequestBody MemberUserView memberUserView) {
    	/*1. 数据校验*/
    	if(StringUtils.isBlank(memberUserView.getPageQueryBean()))memberUserView.setPageQueryBean(new PageQueryBean());
    	if(StringUtils.isBlank(memberUserView.getPageQueryBean().getPageNo()))memberUserView.getPageQueryBean().setPageNo(1);
    	if(StringUtils.isBlank(memberUserView.getPageQueryBean().getPageSize()))memberUserView.getPageQueryBean().setPageSize(10);
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberUser");
    	/*3. 数据查询*/
    	List<MemberUser> list = baseQueryRepositoryImpl.queryByPageByJPQL(sql, SqlUtils.createParamValueList(), MemberUser.class, memberUserView.getPageQueryBean().getPageNo(), memberUserView.getPageQueryBean().getPageSize());
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberUser.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberUserView.getPageQueryBean(), "memberUser.queryByPage",count);
		return ResponseManager.handerResponse(MemberUser.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
    @ApiOperation(value="数据查询所有")
    @RequestMapping(value="/queryAll", method=RequestMethod.POST)
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "member_user查询条件") @RequestBody MemberUserView memberUserView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberUser");
    	/*3. 数据查询*/
    	List<MemberUser> list = baseQueryRepositoryImpl.queryAllByJPQL(sql, SqlUtils.createParamValueList(), MemberUser.class);
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberUser.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberUserView.getPageQueryBean(), "memberUser.queryByPage",count);
		return ResponseManager.handerResponse(MemberUser.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
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
	public MemberUserRepository getMemberUserRepository() {
		return memberUserRepository;
	}
	public void setMemberUserRepository(MemberUserRepository memberUserRepository) {
		this.memberUserRepository = memberUserRepository;
	}   
}
