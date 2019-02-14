package org.jerry.light4j.member.common.response;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.common.page.PageTools;

import io.swagger.annotations.ApiModelProperty;

/**
 * 响应数据实体
 * @author chenjianrui
 *
 */
public class ResponseDomain<T> {
	
	/**
	 * 数据实体
	 */
	private T domain;
	/**
	 * 数据实体集合
	 */
	private List<T> domainList;
	/**
	 * 数据返回状态码
	 */
	private String status;
	/**
	 * 数据返回消息
	 */
	private String msg;
	/**
	 * 数据映射集合
	 */
	private Map<String,Object> dataMap;
	/**
	 * 分页返回数据
	 */
	private PageTools pageTools;
	
	@ApiModelProperty(position=0, value="数据实体")
	public T getDomain() {
		return domain;
	}
	public void setDomain(T domain) {
		this.domain = domain;
	}
	@ApiModelProperty(position=1, value="数据实体集合")
	public List<T> getDomainList() {
		return domainList;
	}
	public void setDomainList(List<T> domainList) {
		this.domainList = domainList;
	}
	@ApiModelProperty(position=2, value="响应状态码")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ApiModelProperty(position=3, value="响应消息")
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@ApiModelProperty(position=4, value="对象映射集合")
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@ApiModelProperty(position=5, value="分页返回数据")
	public PageTools getPageTools() {
		return pageTools;
	}
	public void setPageTools(PageTools pageTools) {
		this.pageTools = pageTools;
	}
	
	

}
