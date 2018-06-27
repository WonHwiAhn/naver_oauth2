package com.boot.blog.infrastructure.service;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AccountSucessListener implements ApplicationListener<AuthenticationSuccessEvent>{
	
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event)
	{
		String account = ((UserDetails)(event.getAuthentication().getPrincipal())).getUsername();
		System.out.println("AccountSucessListener : 접속성공 : " + account);
		// 마지막 접속날짜라던지 여러가지.. 입력
	}
}
