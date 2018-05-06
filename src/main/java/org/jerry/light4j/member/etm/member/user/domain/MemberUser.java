package org.jerry.light4j.member.etm.member.user.domain;
import java.sql.Timestamp;

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
    *自增列
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID",columnDefinition = "bigint")
    private Long pkId;
    /**
    *用户编号
    */
    @Column(name = "MEMBER_USER_CODE",columnDefinition = "varchar")
    private String memberUserCode;
    /**
    *用户名称
    */
    @Column(name = "MEMBER_USER_NAME",columnDefinition = "varchar")
    private String memberUserName;
    /**
    *用户账号
    */
    @Column(name = "MEMBER_USER_ACCOUNT",columnDefinition = "varchar")
    private String memberUserAccount;
    /**
    *用户手机号
    */
    @Column(name = "MEMBER_USER_PHONE",columnDefinition = "varchar")
    private String memberUserPhone;
    /**
    *用户邮箱
    */
    @Column(name = "MEMBER_USER_EMAIL",columnDefinition = "varchar")
    private String memberUserEmail;
    /**
    *用户登陆密码
    */
    @Column(name = "MEMBER_USER_PASSWORD",columnDefinition = "varchar")
    private String memberUserPassword;
    /**
    *用户tokenid
    */
    @Column(name = "MEMBER_USER_TOKENID",columnDefinition = "varchar")
    private String memberUserTokenid;
    /**
    *用户最后登陆时间
    */
    @Column(name = "MEMBER_USER_LAST_DATE",columnDefinition = "datetime")
    private Timestamp memberUserLastDate;
    /**
    *用户角色编号
    */
    @Column(name = "MEMBER_USER_ROLE_CODE",columnDefinition = "varchar")
    private String memberUserRoleCode;
    /**
    *用户排序编号
    */
    @Column(name = "MEMBER_USER_LIST_ORDER",columnDefinition = "varchar")
    private String memberUserListOrder;

	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public String getMemberUserCode() {
		return memberUserCode;
	}
	public void setMemberUserCode(String memberUserCode) {
		this.memberUserCode = memberUserCode;
	}
	public String getMemberUserName() {
		return memberUserName;
	}
	public void setMemberUserName(String memberUserName) {
		this.memberUserName = memberUserName;
	}
	public String getMemberUserAccount() {
		return memberUserAccount;
	}
	public void setMemberUserAccount(String memberUserAccount) {
		this.memberUserAccount = memberUserAccount;
	}
	public String getMemberUserPhone() {
		return memberUserPhone;
	}
	public void setMemberUserPhone(String memberUserPhone) {
		this.memberUserPhone = memberUserPhone;
	}
	public String getMemberUserEmail() {
		return memberUserEmail;
	}
	public void setMemberUserEmail(String memberUserEmail) {
		this.memberUserEmail = memberUserEmail;
	}
	public String getMemberUserPassword() {
		return memberUserPassword;
	}
	public void setMemberUserPassword(String memberUserPassword) {
		this.memberUserPassword = memberUserPassword;
	}
	public String getMemberUserTokenid() {
		return memberUserTokenid;
	}
	public void setMemberUserTokenid(String memberUserTokenid) {
		this.memberUserTokenid = memberUserTokenid;
	}
	public Timestamp getMemberUserLastDate() {
		return memberUserLastDate;
	}
	public void setMemberUserLastDate(Timestamp memberUserLastDate) {
		this.memberUserLastDate = memberUserLastDate;
	}
	public String getMemberUserRoleCode() {
		return memberUserRoleCode;
	}
	public void setMemberUserRoleCode(String memberUserRoleCode) {
		this.memberUserRoleCode = memberUserRoleCode;
	}
	public String getMemberUserListOrder() {
		return memberUserListOrder;
	}
	public void setMemberUserListOrder(String memberUserListOrder) {
		this.memberUserListOrder = memberUserListOrder;
	}
    
	
}