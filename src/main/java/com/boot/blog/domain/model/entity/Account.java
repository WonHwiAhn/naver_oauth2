package com.boot.blog.domain.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;



@Entity(name="account")
@Table(name="account")
public class Account {
	
	@Id
	@Column(name="sn", nullable=false,unique=true)
	//@SequenceGenerator(name="seq", sequenceName="seq_user_sn", allocationSize=1)
	//@GeneratedValue(strategy=javax.persistence.GenerationType.SEQUENCE, generator="seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long sn;
	
	@Column(name="mail", nullable=false, length=64, unique=true)
	String mail;
	
	
	@Column
	@NotNull
	String auth;
	
	@OneToMany(mappedBy="sn" ,fetch=FetchType.LAZY)
	List<AccountRole> roles;

	public long getSn() {
		return sn;
	}

	public void setSn(long sn) {
		this.sn = sn;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public List<AccountRole> getRoles() {
		return roles;
	}

	public void setRoles(List<AccountRole> roles) {
		this.roles = roles;
	}
	
	
}
