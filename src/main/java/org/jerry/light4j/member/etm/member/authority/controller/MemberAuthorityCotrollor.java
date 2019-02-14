package org.jerry.light4j.member.etm.member.authority.controller;

import java.io.Serializable;
import java.util.List;

import org.jerry.light4j.member.etm.member.authority.domain.MemberAuthority;
import org.jerry.light4j.member.etm.member.authority.domain.MemberAuthorityView;
import org.jerry.light4j.member.etm.member.authority.repository.MemberAuthorityRepository;
import org.jerry.light4j.member.etm.member.authority.service.MemberAuthorityService;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/member/authority")
public class MemberAuthorityCotrollor{
    @Autowired
	private MemberAuthorityService memberAuthorityService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberAuthorityRepository memberAuthorityRepository;
    
    @ApiOperation(value="数据插入", notes="创建member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> save(
			@ApiParam(value = "member_authority数据", required = true) @RequestBody MemberAuthority memberAuthority) {
    	memberAuthorityService.save(memberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/delete/{memberAuthorityCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_authority数据code", required = true) @PathVariable String memberAuthorityCode) {
		MemberAuthority oldMemberAuthority = memberAuthorityRepository.findByMemberAuthorityCode(memberAuthorityCode);
		memberAuthorityService.delete(oldMemberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> update(
			@ApiParam(value = "member_authority数据", required = true) @RequestBody MemberAuthority memberAuthority) {
		memberAuthorityService.update(memberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/queryByCode/{memberAuthorityCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_authority数据code", required = true) @PathVariable String memberAuthorityCode) {
		MemberAuthority memberAuthority = memberAuthorityRepository.findByMemberAuthorityCode(memberAuthorityCode);
		return ResponseManager.handerResponse(MemberAuthority.class,memberAuthority, null, HttpStatus.OK, "成功获取数据", null, null);
	}
	
	@ApiOperation(value="数据分页查询", notes="查询member_authority数据",response = ResponseDomain.class, tags = { "member.authority",})
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "member_authority查询条件") @RequestBody MemberAuthorityView memberAuthorityView) {
    	/*1. 数据校验*/
    	if(StringUtils.isBlank(memberAuthorityView.getPageQueryBean()))memberAuthorityView.setPageQueryBean(new PageQueryBean());
    	if(StringUtils.isBlank(memberAuthorityView.getPageQueryBean().getPageNo()))memberAuthorityView.getPageQueryBean().setPageNo(1);
    	if(StringUtils.isBlank(memberAuthorityView.getPageQueryBean().getPageSize()))memberAuthorityView.getPageQueryBean().setPageSize(10);
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberAuthority");
    	/*3. 数据查询*/
    	List<MemberAuthority> list = baseQueryRepositoryImpl.queryByPageByJPQL(sql, SqlUtils.createParamValueList(), MemberAuthority.class, memberAuthorityView.getPageQueryBean().getPageNo(), memberAuthorityView.getPageQueryBean().getPageSize());
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberAuthority.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberAuthorityView.getPageQueryBean(), "memberAuthority.queryByPage",count);
		return ResponseManager.handerResponse(MemberAuthority.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
    @ApiOperation(value="数据查询所有", notes="查询member_authority数据",response = ResponseDomain.class, tags = { "member.authority",})
    @RequestMapping(value="/queryAll", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "member_authority查询条件") @RequestBody MemberAuthorityView memberAuthorityView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberAuthority");
    	/*3. 数据查询*/
    	List<MemberAuthority> list = baseQueryRepositoryImpl.queryAllByJPQL(sql, SqlUtils.createParamValueList(), MemberAuthority.class);
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberAuthority.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberAuthorityView.getPageQueryBean(), "memberAuthority.queryByPage",count);
		return ResponseManager.handerResponse(MemberAuthority.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
	public MemberAuthorityService getMemberAuthorityService() {
		return memberAuthorityService;
	}
	public void setMemberAuthorityService(MemberAuthorityService memberAuthorityService) {
		this.memberAuthorityService = memberAuthorityService;
	}
	public BaseQueryRepositoryImpl<MemberAuthority, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberAuthorityRepository getMemberAuthorityRepository() {
		return memberAuthorityRepository;
	}
	public void setMemberAuthorityRepository(MemberAuthorityRepository memberAuthorityRepository) {
		this.memberAuthorityRepository = memberAuthorityRepository;
	}   
}
