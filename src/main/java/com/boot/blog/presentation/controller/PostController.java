package com.boot.blog.presentation.controller;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.blog.application.configuration.security.auth.LoginUserDetails;
import com.boot.blog.domain.model.entity.Post;
import com.boot.blog.domain.model.entity.UserSession;
import com.boot.blog.infrastructure.dao.PostDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostDao postDao;
	
	@RequestMapping("/list")
	public String list(Model model,@PageableDefault(sort={"id"},direction = Direction.DESC, size = 3)  Pageable pageable){
		Page<Post> postList = postDao.findAll(pageable);
		model.addAttribute("postList", postList);
		return "post/list";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String form(Post post){
		return "post/form";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(@Valid Post post, BindingResult bindingResult, UserSession user){
		if(bindingResult.hasErrors()){
			return "post/form";
		}
		
		System.out.println("write : " + user.getUserName());
		System.out.println("write : " + user.getAuthority());
		post.setRegDate(new Date(0));
		return "redirect:/post/" + postDao.save(post).getId();
	}
	
	
	@RequestMapping("/{id}")
	public String view(Model model,@PathVariable int id){
		Optional<Post> post = postDao.findById(id);
		model.addAttribute("post", post);
		
		//User user = getConnect();
		//model.addAttribute("user", user);
		return "/post/post";
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable int id){
		postDao.deleteById(id);
		return "redirect:/post/list";
	}
	
	@RequestMapping(value = "{id}/edit",method = RequestMethod.GET)
	public String editor(Model model,@PathVariable int id){
		Optional<Post> post = postDao.findById(id);
		model.addAttribute("post", post);
		return "post/form";
	}
	
	@RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
	public String edit(@Valid Post post, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/post/" + postDao.save(post).getId();
	}

}
