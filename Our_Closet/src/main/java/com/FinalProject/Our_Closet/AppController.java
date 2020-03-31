package com.FinalProject.Our_Closet;

import java.util.ArrayList;

import org.apache.catalina.startup.HomesUserDatabase;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.FinalProject.Our_Closet.dao.PostsRepo;
import com.FinalProject.Our_Closet.dao.UsersRepo;
import com.FinalProject.Our_Closet.model.Posts;
import com.FinalProject.Our_Closet.model.Users;
import com.google.gson.Gson;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import antlr.collections.List;
import ch.qos.logback.core.net.LoginAuthenticator;

@Controller
public class AppController {
	
	@Autowired
	UsersRepo usersRepo;
	@Autowired
	PostsRepo postsRepo;
	Gson gson = new Gson();
	
	@RequestMapping("/")
	public String home() {
		System.out.println("GET: home.jsp");
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		System.out.println("GET: login.jsp");
		ModelAndView mv = new ModelAndView(new RedirectView("login"));
		mv.setViewName("login.jsp");
		mv.addObject("errorMessage", "");
		return mv;
	}
	
	@RequestMapping("/register")
	public String register() {
		System.out.println("GET: register.jsp");
		return "register.jsp";
	}
	
	@RequestMapping("/closet_login")
	public ModelAndView loginUser(String uscEmail, String pass) {

		ModelAndView mv = null;
		Users user = usersRepo.findByuscEmail(uscEmail);
		if (user == null || !user.getPass().equals(pass)) {
			// should display an invalid login message
			mv = new ModelAndView(new RedirectView("login"));
			mv.setViewName("login.jsp");
			mv.addObject("errorMessage", "Please enter a valid email/ pass combo");
			return mv;
		}
		
//		String posts = gson.toJson(postsRepo.returnAllPosts());
//		System.out.println(posts);
		mv = new ModelAndView(new RedirectView("newsfeed"));
		mv.addObject("user", user);
		mv.addObject("postsRepo", postsRepo);
//		mv.addObject("posts", posts);
		
		mv.setViewName("newsfeed.jsp");
		System.out.println("working");
		
		return mv;
	}

	@RequestMapping("/closet_register")
	public ModelAndView registerNewUser(Users user) {
		ModelAndView mv = null;
		
		String userEmail = user.getUscEmail();
		if (userEmail.length() < 8 || !userEmail.substring(userEmail.length()-8, userEmail.length()).equals("@usc.edu")) {
			// should display an invalid email message
			mv.setViewName("register.jsp");
			return mv;
		}
		
		Users exists = usersRepo.findByuscEmail(user.getUscEmail());
		if (exists != null) {
			// should display a user already exists message
			mv = new ModelAndView(new RedirectView("register", true));
			mv.setViewName("register.jsp");
			return mv;
		}
		Integer id = usersRepo.findNextID() + 1;
		user.setUserID(id);
		usersRepo.save(user);
		
//		String posts = gson.toJson(postsRepo.returnAllPosts());
//		System.out.println(posts);
		mv = new ModelAndView(new RedirectView("newsfeed", true));
		mv.addObject("user", user);
		mv.addObject("postsRepo", postsRepo);
//		mv.addObject("posts", posts);
		mv.setViewName("newsfeed.jsp");
		return mv;
	}
	
	@RequestMapping("/upload")
	public String upload() {
		System.out.println("GET: upload.jsp");
		return "upload.jsp";
	}
	
	
	
}
