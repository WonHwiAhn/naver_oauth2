package com.boot.blog.domain.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Post {
	
	@Id
	//@SequenceGenerator(name="seq_user_sn", sequenceName="seq_user_sn", allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user_sn")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@NotNull
	@Size(min=1,max=50)
	@Column(nullable=false)
	String title;
	
	@Size(max=100)
	@Column(name="sub_title")
	String subTitle;
	
	@NotNull
	@Size(min = 1, max = 100000000)
	@Column(length = 100000000, nullable = false)
	String content;
	
	@Column(name="reg_date")
	Date regDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date date) {
		this.regDate = date;
	}

}
