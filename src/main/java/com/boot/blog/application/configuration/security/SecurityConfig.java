package com.boot.blog.application.configuration.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	ApplicationContext context;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 예를들어 이런식으로 인증할것들을 풀어주는겁니다. (주로 리소스)
		//web.ignoring().antMatchers("/css/**", "/script/**", "/")
		//			.antMatchers("/console/**");
		//web.ignoring().antMatchers("/sb-admin-2-1.0.8/**","/webjars/**","/kakao/userinfo");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()//.antMatchers("/**").permitAll()
				.antMatchers("/**/write*", "/**/edit*", "/**/delete*").authenticated()
				.antMatchers("/**").permitAll()
		
		.and()
			.formLogin()
				.loginPage("/user/login")
				.defaultSuccessUrl("/post/list")
				
		.and()
			.logout()
			.logoutUrl("/logout")
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/post/list")
			//.invalidateHttpSession(true)
		
		// 여기 나오는 sso.filter 빈은 다음장에서 작성합니다.
		// 이 장에서 실행을 확인하시려면 당연히 NPE 오류가 나니 아래 소스에 주석을 걸어주시기 바랍니다.
		.and()
			.addFilterBefore((Filter)context.getBean("sso.filter"), BasicAuthenticationFilter.class);
		
	}
	
	
}
