package org.jerry.light4j.member.common.page;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询参数实体
 * @author jian
 *
 */
public class PageQueryBean {

	/**
	 * 分页起始位置
	 */
	private int offset;
	/**
	 * 分页数据条数
	 */
	private int pageSize;
	/**
	 * 分页页码
	 */
	private int pageNo;
	
	@ApiModelProperty(position=0, value="起始记录序号", example="0")
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	@ApiModelProperty(position=2, value="分页数据大小", example="10")
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@ApiModelProperty(position=3, value="分页页码", example="1")
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
