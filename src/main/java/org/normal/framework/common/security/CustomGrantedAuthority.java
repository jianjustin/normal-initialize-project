package org.normal.framework.common.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义权限角色类
 */
public class CustomGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -8206650038664745300L;
	private  String memberResourceCode;
    private  String memberResourceName;
    private  String memberRoleCode;


    @Override
    public String getAuthority() {
        return memberResourceName;
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

    public String getMemberRoleCode() {
        return memberRoleCode;
    }

    public void setMemberRoleCode(String memberRoleCode) {
        this.memberRoleCode = memberRoleCode;
    }
}
