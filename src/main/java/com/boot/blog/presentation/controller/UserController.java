package com.boot.blog.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.blog.application.configuration.security.auth.LoginUserDetailsService;
import com.boot.blog.infrastructure.service.AccountService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	LoginUserDetailsService loginUserDetailsService; 
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(){
		return "user/create";
	}
	
	@RequestMapping("/createProcessing")
	public String createProcessing(@Param("mail") String mail, @Param("auth") String auth){

		if (accountService.create(mail, auth)){
			return "redirect:/user/login";
		}
		else{
			return "redirect:/create?error";
		}
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){
	    	
	    	System.out.println(auth.getName() + auth.getAuthorities().toString());
	    	
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/post/list";
	}
    
	

}
