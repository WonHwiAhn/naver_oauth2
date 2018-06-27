package com.boot.blog.application.configuration.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter{

	@Autowired
	LoginUserDetailsService userDetailService;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
}


//package com.boot.blog.application.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
////import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.boot.blog.infrastructure.oauth.LoginUserDetailsService;
//
//@Configuration
//public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter{
//	
//	@Autowired
//	LoginUserDetailsService userDetailsService;
//	
//	@Override
//	public void init(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
//	@Bean
//	PasswordEncoder passwordEncoder()
//	{
//		// 예제입니다.
//		// 본인이 사용하는 패스워드 인코더를 쓰시면됩니다.
//		return new PasswordEncoder() {
//			@Override
//			public boolean matches(CharSequence rawPassword, String encodedPassword) {
//				return encodedPassword.equals(encode(rawPassword));
//			}
//			
//			@Override
//			public String encode(CharSequence rawPassword) {
//				return "ENC" + rawPassword.toString();
//			}
//		};
//	}
//
//}



//@Configuration
//public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
//	
//	@Autowired
//	UserDetailsService userDetailsService;
//	
//	@Bean
//	org.springframework.security.crypto.password.PasswordEncoder passwordEncoder(){
//		// 스프링에서 제공하는 기본 암호 인코더
//		// return new BCryptPasswordEncoder();
//		// 커스텀 인코더를 사용하고있다.
//		return new MyPasswordEncoder();
//		
//		// 인증에 기본 스프링 해시를 사용하겠습니다.
//		//return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	public void init(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//}
//
////암호 인코더 커스텀 설정
//public static class MyPasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder
//{
//	@Override
//	public String encode(CharSequence rawPassword)
//	{
//		// 여기서는 이렇게 처리하였지만 예를들어 sha-2 / sha-3 같은 해시를 접목시킬 수 있다.
//		// 여기서는 간단히 EN-을 붙여 확인하는 용도!
//		return "EN-" + rawPassword.toString();
//	}
//
//	@Override
//	public boolean matches(CharSequence rawPassword, String encodedPassword)
//	{
//		//System.out.println("rawPassword = " + rawPassword);
//		// rawPassword 현재 들어온 값 | encodedPassword 매칭되는 계정에 있는 값
//		return encodedPassword.equals(encode(rawPassword));
//	}
//	
//}