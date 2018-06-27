package com.boot.blog.infrastructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.blog.domain.model.entity.Account;
import com.boot.blog.infrastructure.dao.AccountDao;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;
	
	// 리턴을 저런식으로하면 안됩니다.
	// (무었때문에 가입 실패했는지를 적어주셔야..)
	@Transactional
	public boolean create(String mail, String auth)
	{
		if (accountDao.findByMail(mail) != null)
			return false;

		Account account = new Account();
		account.setMail(mail);
		account.setAuth(new BCryptPasswordEncoder().encode(auth));
		
		accountDao.save(account);
		
		return true;
	}
	
	public List<Account> findAll()
	{
		return accountDao.findAll();
	}
	
	public Account getAccountByMail(String mail)
	{
		return accountDao.findByMail(mail);
	}
	
	public Account getAccountByOAuthId(String type, String id)
	{
		return accountDao.findByOAuthId(type, id);
	}
	
	public Account getAccountByMail(String mail,String auth)
	{
		return accountDao.findByLogin(mail,auth);
	}
	
	
}
