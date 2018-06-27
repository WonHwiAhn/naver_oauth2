package com.boot.blog.application.configuration.security.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.boot.blog.application.configuration.RoleType;
import com.boot.blog.domain.model.entity.Account;
import com.boot.blog.domain.model.entity.AccountRole;

import lombok.Getter;

public class LoginUserDetails extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	private long sn;
	
	public LoginUserDetails(Account account) {
		super(account.getMail(), account.getAuth(), getAuthorities(account.getRoles()));
		sn = account.getSn();
	}
	
	public static List<GrantedAuthority> getAuthorities(List<AccountRole> roles){
		
		List<GrantedAuthority> list = new ArrayList<>(1);
		list.add(new SimpleGrantedAuthority(RoleType.USER.toString()));
		
		if(roles != null){
			roles.stream().forEach( (AccountRole role) -> {
				list.add(new SimpleGrantedAuthority(role.getRole()));
			});
		}
		
		list.stream().forEach((GrantedAuthority role) -> {
			System.out.println("Role : " + role.getAuthority());
		});
		
		return list;
	}
	
	public long getSn() {
		return sn;
	}

}
