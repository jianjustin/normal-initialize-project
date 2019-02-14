package org.jerry.light4j.member.etm.member.role.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
* 描述：member_role模型
* @author tools
*/
@Entity
@Table(name="member_role")
public class MemberRole{
	
    /**
    *主键ID
    */
    @Column(name = "PK_ID",columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *角色编号
    */
    @Column(name = "MEMBER_ROLE_CODE",columnDefinition = "VARCHAR2(30)")
    private String memberRoleCode;
    /**
    *角色名称
    */
    @Column(name = "MEMBER_ROLE_NAME",columnDefinition = "VARCHAR2(100)")
    private String memberRoleName;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_ROLE_CREATE_DATE",columnDefinition = "DATE")
    private Date memberRoleCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_ROLE_ORDER_BY",columnDefinition = "VARCHAR2(30)")
    private String memberRoleOrderBy;
    
    
	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public String getMemberRoleCode() {
		return memberRoleCode;
	}
	public void setMemberRoleCode(String memberRoleCode) {
		this.memberRoleCode = memberRoleCode;
	}
	public String getMemberRoleName() {
		return memberRoleName;
	}
	public void setMemberRoleName(String memberRoleName) {
		this.memberRoleName = memberRoleName;
	}
	public Date getMemberRoleCreateDate() {
		return memberRoleCreateDate;
	}
	public void setMemberRoleCreateDate(Date memberRoleCreateDate) {
		this.memberRoleCreateDate = memberRoleCreateDate;
	}
	public String getMemberRoleOrderBy() {
		return memberRoleOrderBy;
	}
	public void setMemberRoleOrderBy(String memberRoleOrderBy) {
		this.memberRoleOrderBy = memberRoleOrderBy;
	}
    
    

}