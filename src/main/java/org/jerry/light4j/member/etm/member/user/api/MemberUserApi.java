package org.jerry.light4j.member.etm.member.user.api;

import org.jerry.light4j.member.etm.member.user.domain.MemberUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface MemberUserApi {

	@ApiOperation(value = "实体插入", notes = "", response = MemberUser.class, tags = { "member.user",})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "保存成功", response = MemberUser.class),
			@ApiResponse(code = 400, message = "输入参数非法", response = Void.class),
			@ApiResponse(code = 422, message = "保存失败", response = String.class) })
	@RequestMapping(value = "/member/user/save",method = RequestMethod.POST)
	public ResponseEntity<?> save(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser);
	
	@ApiOperation(value = "实体删除", notes = "", response = MemberUser.class, tags = { "member.user",})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "保存成功", response = MemberUser.class),
			@ApiResponse(code = 400, message = "输入参数非法", response = Void.class),
			@ApiResponse(code = 422, message = "保存失败", response = String.class) })
	@RequestMapping(value = "/member/user/delete", produces = { "application/json" },  method = RequestMethod.POST)
	public ResponseEntity<?> delete(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser);
	
	@ApiOperation(value = "实体修改", notes = "", response = MemberUser.class, tags = { "member.user",})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "保存成功", response = MemberUser.class),
			@ApiResponse(code = 400, message = "输入参数非法", response = Void.class),
			@ApiResponse(code = 422, message = "保存失败", response = String.class) })
	@RequestMapping(value = "/member/user/update", produces = { "application/json" },  method = RequestMethod.POST)
	public ResponseEntity<?> update(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser);
	

	
}
