package org.normal.framework.common.security;

import java.util.List;

import org.normal.framework.common.utils.BeanUtils;
import org.normal.framework.etm.member.authority.domain.MemberAuthority;
import org.normal.framework.etm.member.authority.repository.MemberAuthorityRepository;
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
		List<MemberAuthority> memberAuthorityList = memberAuthorityRepository.findByMemberAuthorityRoleCode(memberUser.getMemberUserRoleCode());
		springSecurityUserDetails.setMemberAuthorityList(memberAuthorityList);
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
