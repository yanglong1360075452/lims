package com.wizinno.lims.security;

import com.wizinno.lims.common.security.SecurityUserDetails;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author LiuMei
 * 安全资源（URL）和角色映射关系处理器
 */
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserDto user = userService.findUserByName(username);
		
		if (null == user) {
			throw new UsernameNotFoundException("用户名或密码错误");
		}

		Boolean userEnabled = true;

		Collection<GrantedAuthority> authorities = new ArrayList<>();

		List<Integer> permissions = userService.getUserPermissionsCode(user.getId());

		SimpleGrantedAuthority authority;
		for (Integer permission : permissions) {
			authority = new SimpleGrantedAuthority(permission.toString());
			authorities.add(authority);
		}

		//创建UserDetails对象
		SecurityUserDetails userDetails = new SecurityUserDetails(user.getId().intValue(),
				user.getUsername(), user.getPassword(), userEnabled, authorities);
		userDetails.setPermission(permissions);
		return userDetails;
	}

}
