package com.boot.blog.application.aop;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.boot.blog.application.configuration.security.auth.LoginUserDetails;
import com.boot.blog.domain.model.entity.UserSession;


public class UserSessionInterceptor extends HandlerInterceptorAdapter{
	
	//private ConnectionRepository connectionRepository;
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication !=null){
			//Object principal = authentication.getPrincipal();
	
			String userName="";
			String groupRole="";
			//if(principal != null && principal instanceof LoginUserDetails){
				//userName = ((LoginUserDetails)principal).getUsername();
				userName = authentication.getName();
				
				//request.setAttribute("userName", userName);
				
				@SuppressWarnings("unchecked")
				//Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) ((LoginUserDetails)principal).getAuthorities();
				Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
				if(authorities != null){
					for (GrantedAuthority grantedAuthority : authorities) {
						System.out.println(userName + " : " + grantedAuthority.getAuthority());
					}
				}
			//}
			
			request.setAttribute("user", new UserSession(authentication.getName(), authentication.getAuthorities().toString()));
		}
		
		
		
		return true;
	}

}
