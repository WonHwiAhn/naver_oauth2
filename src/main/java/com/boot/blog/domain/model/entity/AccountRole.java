package com.boot.blog.domain.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="account_role")
@Table(name="account_role",uniqueConstraints=@UniqueConstraint(columnNames={"sn","role"}))

public class AccountRole {
	
	@Id
	@Column(name="sn", nullable=false)
	long sn;
 
	@Column(name="role", nullable=false, length=64)
	String role;
 
	@Column(name="role_date")
	Date roleDate;

	public long getSn() {
		return sn;
	}

	public void setSn(long sn) {
		this.sn = sn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getRoleDate() {
		return roleDate;
	}

	public void setRoleDate(Date roleDate) {
		this.roleDate = roleDate;
	}
	
	
}
