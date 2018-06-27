package com.boot.blog.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//name="account_oauth_client",
@Entity(name="account_oauth_client")
@Table(name="account_oauth_client",uniqueConstraints=@UniqueConstraint(columnNames={"sn", "type"}))
public class AccountOAuthClient {
	
	@Id
	@Column(name="sn", nullable=false)
	long sn;
 
	@Column(name="type", nullable=false, length=12)
	String type;
 
	@Column(name="id", nullable=false, length=64)
	String id;

	public long getSn() {
		return sn;
	}

	public void setSn(long sn) {
		this.sn = sn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
