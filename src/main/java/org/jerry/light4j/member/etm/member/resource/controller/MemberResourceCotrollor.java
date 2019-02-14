package org.jerry.light4j.member.etm.member.resource.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.jerry.light4j.member.etm.member.resource.domain.MemberResource;
import org.jerry.light4j.member.etm.member.resource.domain.MemberResourceView;
import org.jerry.light4j.member.etm.member.resource.repository.MemberResourceRepository;
import org.jerry.light4j.member.etm.member.resource.service.MemberResourceService;
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
@Api(tags="member.resource",value="member.resource模块")
@RequestMapping(value = "/member/resource",produces = { "application/json; charset=UTF-8" },consumes = {"text/plain", "application/json"})
public class MemberResourceCotrollor{
    @Autowired
	private MemberResourceService memberResourceService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberResource, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberResourceRepository memberResourceRepository;
    
    @ApiOperation(value="数据插入")
    @RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<?> save(
			@ApiParam(value = "member_resource数据", required = true) @RequestBody MemberResource memberResource) {
    	memberResourceService.save(memberResource);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除")
    @RequestMapping(value="/delete/{memberResourceCode}", method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_resource数据code", required = true) @PathVariable String memberResourceCode) {
		MemberResource oldMemberResource = memberResourceRepository.findByMemberResourceCode(memberResourceCode);
		memberResourceService.delete(oldMemberResource);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新")
    @RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<?> update(
			@ApiParam(value = "member_resource数据", required = true) @RequestBody MemberResource memberResource) {
		memberResourceService.update(memberResource);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询")
    @RequestMapping(value="/queryByCode/{memberResourceCode}", method=RequestMethod.GET)
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_resource数据code", required = true) @PathVariable String memberResourceCode) {
		MemberResource memberResource = memberResourceRepository.findByMemberResourceCode(memberResourceCode);
		return ResponseManager.handerResponse(MemberResource.class,memberResource, null, HttpStatus.OK, "成功获取数据", null, null);
	}
	
	@ApiOperation(value="数据分页查询")
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST)
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "member_resource查询条件") @RequestBody MemberResourceView memberResourceView) {
    	/*1. 数据校验*/
    	if(StringUtils.isBlank(memberResourceView.getPageQueryBean()))memberResourceView.setPageQueryBean(new PageQueryBean());
    	if(StringUtils.isBlank(memberResourceView.getPageQueryBean().getPageNo()))memberResourceView.getPageQueryBean().setPageNo(1);
    	if(StringUtils.isBlank(memberResourceView.getPageQueryBean().getPageSize()))memberResourceView.getPageQueryBean().setPageSize(10);
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberResource");
    	/*3. 数据查询*/
    	List<MemberResource> list = baseQueryRepositoryImpl.queryByPageByJPQL(sql, SqlUtils.createParamValueList(), MemberResource.class, memberResourceView.getPageQueryBean().getPageNo(), memberResourceView.getPageQueryBean().getPageSize());
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberResource.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberResourceView.getPageQueryBean(), "memberResource.queryByPage",count);
		return ResponseManager.handerResponse(MemberResource.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
    @ApiOperation(value="数据查询所有")
    @RequestMapping(value="/queryAll", method=RequestMethod.POST)
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "member_resource查询条件") @RequestBody MemberResourceView memberResourceView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberResource");
    	/*3. 数据查询*/
    	List<MemberResource> list = baseQueryRepositoryImpl.queryAllByJPQL(sql, SqlUtils.createParamValueList(), MemberResource.class);
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberResource.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberResourceView.getPageQueryBean(), "memberResource.queryByPage",count);
		return ResponseManager.handerResponse(MemberResource.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
	public MemberResourceService getMemberResourceService() {
		return memberResourceService;
	}
	public void setMemberResourceService(MemberResourceService memberResourceService) {
		this.memberResourceService = memberResourceService;
	}
	public BaseQueryRepositoryImpl<MemberResource, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberResource, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberResourceRepository getMemberResourceRepository() {
		return memberResourceRepository;
	}
	public void setMemberResourceRepository(MemberResourceRepository memberResourceRepository) {
		this.memberResourceRepository = memberResourceRepository;
	}   
}
