package org.jerry.light4j.member.etm.member.authority.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：member_authority模型
* @author tools
*/
@Entity
@Table(name="member_authority")
public class MemberAuthority{
	
    /**
    *主键ID
    */
    @Column(name = "PK_ID",columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *权限对照编号
    */
    @Column(name = "MEMBER_AUTHORITY_CODE",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberAuthorityCode;
    /**
    *角色编号
    */
    @Column(name = "MEMBER_AUTHORITY_ROLE_CODE",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberAuthorityRoleCode;
    /**
    *资源编号
    */
    @Column(name = "MEMBER_AUTHORITY_RESOURCE_CODE",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberAuthorityResourceCode;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_AUTHORITY_CREATE_DATE",columnDefinition = "DATE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date memberAuthorityCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_AUTHORITY_ORDER_BY",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberAuthorityOrderBy;

    public Long getpkId() {
        return this.pkId;
    }
    public void setpkId(Long pkId) {
        this.pkId = pkId;
    }
	
    public String getmemberAuthorityCode() {
        return this.memberAuthorityCode;
    }
    public void setmemberAuthorityCode(String memberAuthorityCode) {
        this.memberAuthorityCode = memberAuthorityCode;
    }
	
    public String getmemberAuthorityRoleCode() {
        return this.memberAuthorityRoleCode;
    }
    public void setmemberAuthorityRoleCode(String memberAuthorityRoleCode) {
        this.memberAuthorityRoleCode = memberAuthorityRoleCode;
    }
	
    public String getmemberAuthorityResourceCode() {
        return this.memberAuthorityResourceCode;
    }
    public void setmemberAuthorityResourceCode(String memberAuthorityResourceCode) {
        this.memberAuthorityResourceCode = memberAuthorityResourceCode;
    }
	
    public Date getmemberAuthorityCreateDate() {
        return this.memberAuthorityCreateDate;
    }
    public void setmemberAuthorityCreateDate(Date memberAuthorityCreateDate) {
        this.memberAuthorityCreateDate = memberAuthorityCreateDate;
    }
	
    public String getmemberAuthorityOrderBy() {
        return this.memberAuthorityOrderBy;
    }
    public void setmemberAuthorityOrderBy(String memberAuthorityOrderBy) {
        this.memberAuthorityOrderBy = memberAuthorityOrderBy;
    }
	
}