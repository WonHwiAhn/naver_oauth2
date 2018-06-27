package com.boot.blog.application.configuration.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.blog.domain.model.entity.Account;
import com.boot.blog.infrastructure.service.AccountService;


@Service
public class LoginUserDetailsService implements UserDetailsService{
	
	@Autowired
	AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException	{
		
		Account account = accountService.getAccountByMail(username);
		if(account == null) throw new UsernameNotFoundException("회원 정보가 없습니다.");
		
		return new LoginUserDetails(account);
	}

}
