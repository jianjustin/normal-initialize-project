package org.normal.framework.common.security;

import java.util.ArrayList;
import java.util.List;

import org.normal.framework.common.utils.BeanUtils;
import org.normal.framework.etm.member.authority.domain.MemberAuthority;
import org.normal.framework.etm.member.authority.repository.MemberAuthorityRepository;
import org.normal.framework.etm.member.resource.domain.MemberResource;
import org.normal.framework.etm.member.resource.repository.MemberResourceRepository;
import org.normal.framework.etm.member.user.domain.MemberUser;
import org.normal.framework.etm.member.user.repository.MemberUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private MemberUserRepository memberUserRepository;
	@Autowired
	private MemberAuthorityRepository memberAuthorityRepository;
    @Autowired
    private MemberResourceRepository memberResourceRepository;
	/**
	 * 加载用户信息接口
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("加载用户数据");
		//根据用户名称获取用户信息
		SpringSecurityUserDetails springSecurityUserDetails = new SpringSecurityUserDetails();
		MemberUser memberUser = memberUserRepository.findByMemberUserLoginAccount(username);
		if(null == memberUser || "".equals(memberUser.getMemberUserCode()))
			throw new UsernameNotFoundException("用户不存在");
		try {
			BeanUtils.copyPropertiesOfNotNull(memberUser, springSecurityUserDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//根据用户id获取用户权限信息
        List<CustomGrantedAuthority> customGrantedAuthorityList = new ArrayList<CustomGrantedAuthority>();
		List<MemberAuthority> memberAuthorityList = memberAuthorityRepository.findByMemberAuthorityRoleCode(memberUser.getMemberUserRoleCode());
        for (int i = 0; i < memberAuthorityList.size(); i++) {
            MemberResource memberResource = memberResourceRepository.findByMemberResourceCode(memberAuthorityList.get(i).getmemberAuthorityResourceCode());
            CustomGrantedAuthority customGrantedAuthority = new CustomGrantedAuthority();
            customGrantedAuthority.setMemberResourceCode(memberResource.getMemberResourceCode());
            customGrantedAuthority.setMemberResourceName(memberResource.getMemberResourceName());
            customGrantedAuthority.setMemberRoleCode(memberAuthorityList.get(i).getmemberAuthorityRoleCode());
            customGrantedAuthorityList.add(customGrantedAuthority);
        }
		springSecurityUserDetails.setCustomGrantedAuthorityList(customGrantedAuthorityList);
		//校验密码流程会在DaoAuthenticationProvider中处理
		return springSecurityUserDetails;
		
	}
	public MemberUserRepository getMemberUserRepository() {
		return memberUserRepository;
	}
	public void setMemberUserRepository(MemberUserRepository memberUserRepository) {
		this.memberUserRepository = memberUserRepository;
	}
	public MemberAuthorityRepository getMemberAuthorityRepository() {
		return memberAuthorityRepository;
	}
	public void setMemberAuthorityRepository(MemberAuthorityRepository memberAuthorityRepository) {
		this.memberAuthorityRepository = memberAuthorityRepository;
	}
}
