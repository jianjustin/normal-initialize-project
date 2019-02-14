package org.jerry.light4j.member.etm.member.role.controller;

import java.io.Serializable;
import java.util.List;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.common.page.PageQueryBean;
import org.jerry.light4j.member.common.page.PageTools;
import org.jerry.light4j.member.common.page.PageUtils;
import org.jerry.light4j.member.common.response.ResponseDomain;
import org.jerry.light4j.member.common.response.ResponseManager;
import org.jerry.light4j.member.common.utils.SqlUtils;
import org.jerry.light4j.member.common.utils.StringUtils;
import org.jerry.light4j.member.etm.member.role.domain.MemberRole;
import org.jerry.light4j.member.etm.member.role.domain.MemberRoleView;
import org.jerry.light4j.member.etm.member.role.repository.MemberRoleRepository;
import org.jerry.light4j.member.etm.member.role.service.MemberRoleService;
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
@RequestMapping("/member/role")
public class MemberRoleCotrollor{
    @Autowired
	private MemberRoleService memberRoleService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberRole, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberRoleRepository memberRoleRepository;
    
    @ApiOperation(value="数据插入", notes="创建member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> save(
			@ApiParam(value = "member_role数据", required = true) @RequestBody MemberRole memberRole) {
    	memberRoleService.save(memberRole);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/delete/{memberRoleCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_role数据code", required = true) @PathVariable String memberRoleCode) {
		MemberRole oldMemberRole = memberRoleRepository.findByMemberRoleCode(memberRoleCode);
		memberRoleService.delete(oldMemberRole);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> update(
			@ApiParam(value = "member_role数据", required = true) @RequestBody MemberRole memberRole) {
		memberRoleService.update(memberRole);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/queryByCode/{memberRoleCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_role数据code", required = true) @PathVariable String memberRoleCode) {
		MemberRole memberRole = memberRoleRepository.findByMemberRoleCode(memberRoleCode);
		return ResponseManager.handerResponse(MemberRole.class,memberRole, null, HttpStatus.OK, "成功获取数据", null, null);
	}
	
	@ApiOperation(value="数据分页查询", notes="查询member_role数据",response = ResponseDomain.class, tags = { "member.role",})
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "member_role查询条件") @RequestBody MemberRoleView memberRoleView) {
    	/*1. 数据校验*/
    	if(StringUtils.isBlank(memberRoleView.getPageQueryBean()))memberRoleView.setPageQueryBean(new PageQueryBean());
    	if(StringUtils.isBlank(memberRoleView.getPageQueryBean().getPageNo()))memberRoleView.getPageQueryBean().setPageNo(1);
    	if(StringUtils.isBlank(memberRoleView.getPageQueryBean().getPageSize()))memberRoleView.getPageQueryBean().setPageSize(10);
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberRole");
    	/*3. 数据查询*/
    	List<MemberRole> list = baseQueryRepositoryImpl.queryByPageByJPQL(sql, SqlUtils.createParamValueList(), MemberRole.class, memberRoleView.getPageQueryBean().getPageNo(), memberRoleView.getPageQueryBean().getPageSize());
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberRole.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberRoleView.getPageQueryBean(), "memberRole.queryByPage",count);
		return ResponseManager.handerResponse(MemberRole.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
    @ApiOperation(value="数据查询所有", notes="查询member_role数据",response = ResponseDomain.class, tags = { "member.role",})
    @RequestMapping(value="/queryAll", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "member_role查询条件") @RequestBody MemberRoleView memberRoleView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberRole");
    	/*3. 数据查询*/
    	List<MemberRole> list = baseQueryRepositoryImpl.queryAllByJPQL(sql, SqlUtils.createParamValueList(), MemberRole.class);
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberRole.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberRoleView.getPageQueryBean(), "memberRole.queryByPage",count);
		return ResponseManager.handerResponse(MemberRole.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
	public MemberRoleService getMemberRoleService() {
		return memberRoleService;
	}
	public void setMemberRoleService(MemberRoleService memberRoleService) {
		this.memberRoleService = memberRoleService;
	}
	public BaseQueryRepositoryImpl<MemberRole, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberRole, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberRoleRepository getMemberRoleRepository() {
		return memberRoleRepository;
	}
	public void setMemberRoleRepository(MemberRoleRepository memberRoleRepository) {
		this.memberRoleRepository = memberRoleRepository;
	}   
}
