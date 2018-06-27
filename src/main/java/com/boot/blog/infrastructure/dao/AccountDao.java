package com.boot.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.blog.domain.model.entity.Account;

public interface AccountDao extends JpaRepository<Account, Long>{
	
	@Query("SELECT a FROM account a LEFT JOIN FETCH a.roles b WHERE a.mail = lower(:mail)")
	public Account findByMail(@Param("mail") String mail);
	
	
	@Query("SELECT a FROM account a LEFT JOIN FETCH a.roles b WHERE a.sn = (SELECT sn FROM account_oauth_client WHERE type = :type AND id = :id)")
	public Account findByOAuthId(@Param("type") String type, @Param("id") String id);

	@Query("SELECT a FROM account a LEFT JOIN FETCH a.roles b WHERE a.mail = lower(:mail) AND a.auth = :auth")
	public Account findByLogin(@Param("mail") String mail,@Param("auth") String auth);
	
}
