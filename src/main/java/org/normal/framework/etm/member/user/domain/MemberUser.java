package org.normal.framework.etm.member.user.domain;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：member_user模型
* @author tools
*/
@Entity
@Table(name="member_user")
public class MemberUser{
	
    /**
    *主键ID
    */
	@Id
    @Column(name = "PK_ID",columnDefinition = "INT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *用户编号
    */
    @Column(name = "MEMBER_USER_CODE",columnDefinition = "VARCHAR2")
    private String memberUserCode;
    /**
    *用户名称
    */
    @Column(name = "MEMBER_USER_NAME",columnDefinition = "VARCHAR2")
    private String memberUserName;
    /**
    *用户登录账号
    */
    @Column(name = "MEMBER_USER_LOGIN_ACCOUNT",columnDefinition = "VARCHAR2")
    private String memberUserLoginAccount;
    /**
    *用户登录密码
    */
    @Column(name = "MEMBER_USER_LOGIN_PASSWORD",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberUserLoginPassword;
    /**
    *用户TOKENID
    */
    @Column(name = "MEMBER_USER_TOKEN_ID",columnDefinition = "VARCHAR2")
    private String memberUserTokenId;
    /**
    *用户角色编号
    */
    @Column(name = "MEMBER_USER_ROLE_CODE",columnDefinition = "VARCHAR2")
    private String memberUserRoleCode;
    /**
    *用户手机号码
    */
    @Column(name = "MEMBER_USER_PHONE_NUMBER",columnDefinition = "VARCHAR2")
    private String memberUserPhoneNumber;
    /**
    *用户电子邮箱
    */
    @Column(name = "MEMBER_USER_EMAIL",columnDefinition = "VARCHAR2")
    private String memberUserEmail;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_USER_CREATE_DATE",columnDefinition = "DATE")
    private Date memberUserCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_USER_ORDER_BY",columnDefinition = "VARCHAR2")
    private String memberUserOrderBy;

    public Long getpkId() {
        return this.pkId;
    }
    public void setpkId(Long pkId) {
        this.pkId = pkId;
    }
	
    public String getmemberUserCode() {
        return this.memberUserCode;
    }
    public void setmemberUserCode(String memberUserCode) {
        this.memberUserCode = memberUserCode;
    }
	
    public String getmemberUserName() {
        return this.memberUserName;
    }
    public void setmemberUserName(String memberUserName) {
        this.memberUserName = memberUserName;
    }
	
    public String getmemberUserLoginAccount() {
        return this.memberUserLoginAccount;
    }
    public void setmemberUserLoginAccount(String memberUserLoginAccount) {
        this.memberUserLoginAccount = memberUserLoginAccount;
    }
	
    public String getmemberUserLoginPassword() {
        return this.memberUserLoginPassword;
    }
    public void setmemberUserLoginPassword(String memberUserLoginPassword) {
        this.memberUserLoginPassword = memberUserLoginPassword;
    }
	
    public String getmemberUserTokenId() {
        return this.memberUserTokenId;
    }
    public void setmemberUserTokenId(String memberUserTokenId) {
        this.memberUserTokenId = memberUserTokenId;
    }
	
    public String getmemberUserRoleCode() {
        return this.memberUserRoleCode;
    }
    public void setmemberUserRoleCode(String memberUserRoleCode) {
        this.memberUserRoleCode = memberUserRoleCode;
    }
	
    public String getmemberUserPhoneNumber() {
        return this.memberUserPhoneNumber;
    }
    public void setmemberUserPhoneNumber(String memberUserPhoneNumber) {
        this.memberUserPhoneNumber = memberUserPhoneNumber;
    }
	
    public String getmemberUserEmail() {
        return this.memberUserEmail;
    }
    public void setmemberUserEmail(String memberUserEmail) {
        this.memberUserEmail = memberUserEmail;
    }
	
    public Date getmemberUserCreateDate() {
        return this.memberUserCreateDate;
    }
    public void setmemberUserCreateDate(Date memberUserCreateDate) {
        this.memberUserCreateDate = memberUserCreateDate;
    }
	
    public String getmemberUserOrderBy() {
        return this.memberUserOrderBy;
    }
    public void setmemberUserOrderBy(String memberUserOrderBy) {
        this.memberUserOrderBy = memberUserOrderBy;
    }
	
}