package org.jerry.light4j.member.etm.member.resource.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：member_resource模型
* @author tools
*/
@Entity
@Table(name="member_resource")
public class MemberResource{
	
    /**
    *主键ID
    */
	@Id
    @Column(name = "PK_ID",columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *资源编号
    */
    @Column(name = "MEMBER_RESOURCE_CODE",columnDefinition = "VARCHAR2(30)")
    private String memberResourceCode;
    /**
    *资源名称
    */
    @Column(name = "MEMBER_RESOURCE_NAME",columnDefinition = "VARCHAR2(100)")
    private String memberResourceName;
    /**
    *资源类型
    */
    @Column(name = "MEMBER_RESOURCE_TYPE",columnDefinition = "VARCHAR2(30)")
    private String memberResourceType;
    /**
    *资源路由
    */
    @Column(name = "MEMBER_RESOURCE_ROUTER",columnDefinition = "VARCHAR2(100)")
    private String memberResourceRouter;
    /**
    *资源备注
    */
    @Column(name = "MEMBER_RESOURCE_REMARK",columnDefinition = "VARCHAR2(100)")
    private String memberResourceRemark;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_RESOURCE_CREATE_DATE",columnDefinition = "DATE")
    private Date memberResourceCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_RESOURCE_ORDER_BY",columnDefinition = "VARCHAR2(30)")
    private String memberResourceOrderBy;
	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public String getMemberResourceCode() {
		return memberResourceCode;
	}
	public void setMemberResourceCode(String memberResourceCode) {
		this.memberResourceCode = memberResourceCode;
	}
	public String getMemberResourceName() {
		return memberResourceName;
	}
	public void setMemberResourceName(String memberResourceName) {
		this.memberResourceName = memberResourceName;
	}
	public String getMemberResourceType() {
		return memberResourceType;
	}
	public void setMemberResourceType(String memberResourceType) {
		this.memberResourceType = memberResourceType;
	}
	public String getMemberResourceRouter() {
		return memberResourceRouter;
	}
	public void setMemberResourceRouter(String memberResourceRouter) {
		this.memberResourceRouter = memberResourceRouter;
	}
	public String getMemberResourceRemark() {
		return memberResourceRemark;
	}
	public void setMemberResourceRemark(String memberResourceRemark) {
		this.memberResourceRemark = memberResourceRemark;
	}
	public Date getMemberResourceCreateDate() {
		return memberResourceCreateDate;
	}
	public void setMemberResourceCreateDate(Date memberResourceCreateDate) {
		this.memberResourceCreateDate = memberResourceCreateDate;
	}
	public String getMemberResourceOrderBy() {
		return memberResourceOrderBy;
	}
	public void setMemberResourceOrderBy(String memberResourceOrderBy) {
		this.memberResourceOrderBy = memberResourceOrderBy;
	}

    
}