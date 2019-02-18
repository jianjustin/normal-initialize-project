package org.normal.framework.etm.member.authority.controller;

import java.io.Serializable;
import java.util.List;

import org.normal.framework.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.normal.framework.common.page.PageQueryBean;
import org.normal.framework.common.page.PageTools;
import org.normal.framework.common.page.PageUtils;
import org.normal.framework.common.response.ResponseManager;
import org.normal.framework.common.utils.SqlUtils;
import org.normal.framework.common.utils.StringUtils;
import org.normal.framework.etm.member.authority.domain.MemberAuthority;
import org.normal.framework.etm.member.authority.domain.MemberAuthorityView;
import org.normal.framework.etm.member.authority.repository.MemberAuthorityRepository;
import org.normal.framework.etm.member.authority.service.MemberAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@Api(tags="member.authority",value="用户权限模块")
@RequestMapping(value = "/member/authority/",produces = { "application/json; charset=UTF-8" })
public class MemberAuthorityCotrollor{
    @Autowired
	private MemberAuthorityService memberAuthorityService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberAuthorityRepository memberAuthorityRepository;
    
    @ApiOperation(value="新增权限")
    @RequestMapping(value="/save", method=RequestMethod.POST)
    @PreAuthorize("hasAuthority('member.authority.save')")
	public ResponseEntity<?> save(
			@ApiParam(value = "member_authority数据", required = true) @RequestBody MemberAuthority memberAuthority) {
    	memberAuthorityService.save(memberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除")
    @RequestMapping(value="/delete/{memberAuthorityCode}", method=RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('member.authority.delete')")
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_authority数据code", required = true) @PathVariable String memberAuthorityCode) {
		MemberAuthority oldMemberAuthority = memberAuthorityRepository.findByMemberAuthorityCode(memberAuthorityCode);
		memberAuthorityService.delete(oldMemberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新")
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    @PreAuthorize("hasAuthority('member.authority.update')")
	public ResponseEntity<?> update(
			@ApiParam(value = "member_authority数据", required = true) @RequestBody MemberAuthority memberAuthority) {
		memberAuthorityService.update(memberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询")
    @RequestMapping(value="/queryByCode/{memberAuthorityCode}", method=RequestMethod.GET)
    @PreAuthorize("hasAuthority('member.authority.queryByCode')")
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_authority数据code", required = true) @PathVariable String memberAuthorityCode) {
		MemberAuthority memberAuthority = memberAuthorityRepository.findByMemberAuthorityCode(memberAuthorityCode);
		return ResponseManager.handerResponse(MemberAuthority.class,memberAuthority, null, HttpStatus.OK, "成功获取数据", null, null);
	}
	
	@ApiOperation(value="数据分页查询")
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST)
    @PreAuthorize("hasAuthority('member.authority.queryByPage')")
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "member_authority查询条件") @RequestBody MemberAuthorityView memberAuthorityView) {
        /*1. 数据校验*/
        if(StringUtils.isBlank(memberAuthorityView.getPageQueryBean())){
            memberAuthorityView.setPageQueryBean(new PageQueryBean());//未传入分页条件
            memberAuthorityView.getPageQueryBean().setPageNo(1);
            memberAuthorityView.getPageQueryBean().setPageSize(10);
        }
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
    
    @ApiOperation(value="数据查询所有")
    @RequestMapping(value="/queryAll", method=RequestMethod.POST)
    @PreAuthorize("hasAuthority('member.authority.queryAll')")
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "member_authority查询条件") @RequestBody MemberAuthorityView memberAuthorityView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberAuthority");
    	/*3. 数据查询*/
    	System.out.println(sql);
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
