package com.dms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.User_loginDao;
import com.dms.entity.User_login;
@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired 
	User_loginDao user_loginDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("user name================>"+username);
User_login user=user_loginDao.findUserByEmail(username);
		
		List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
				
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRole_level());
			authories.add(authority);
		UserDetails userDetails = (UserDetails)new User(user.getEmail(),
				user.getPassword(), authories);
		return userDetails;
	}

}
