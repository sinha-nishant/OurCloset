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
	
	// Home request
	@RequestMapping("/")
	public String home() {
		System.out.println("GET: home.jsp");
		return "home.jsp";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Login request
	@RequestMapping("/login")
	public String login() {
		System.out.println("GET: login.jsp");
		return "login.jsp";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Register request
	@RequestMapping("/register")
	public String register() {
		System.out.println("GET: register.jsp");
		return "register.jsp";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Login request
	@RequestMapping("/closet_login")
	public ModelAndView loginUser(String uscEmail, String pass) {

		ModelAndView mv = null;
		Users user = usersRepo.findByuscEmail(uscEmail);
		if (user == null || !user.getPass().equals(pass)) {
			// should display an invalid login message
			mv = new ModelAndView("login");
			mv.setViewName("redirect:login");
			return mv;
		}
		
//		String posts = gson.toJson(postsRepo.returnAllPosts());
//		System.out.println(posts);
		mv = new ModelAndView(new RedirectView("newsfeed"));
		mv.addObject("user", user);
		mv.addObject("postsRepo", postsRepo);
//		mv.addObject("posts", posts);
		mv.setViewName("newsfeed.jsp");
		return mv;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping("/closet_register")
	public ModelAndView registerNewUser(Users user) {
		System.out.println(user);
		ModelAndView mv = null;
		
		String userEmail = user.getUscEmail();
		if (userEmail.length() < 8 || !userEmail.substring(userEmail.length()-8, userEmail.length()).equals("@usc.edu")) {
			System.out.println("missing/ invalid registration fields");
			mv = new ModelAndView("register");
			mv.setViewName("redirect:register");
			return mv;
		}
		
		Users exists = usersRepo.findByuscEmail(user.getUscEmail());
		if (exists != null) {
			System.out.println("user aleady exists");
			// should display a user already exists message
			mv = new ModelAndView("register");
			mv.setViewName("redirect:register");
			return mv;
		}
		
		Integer id = usersRepo.findNextID() + 1;
		user.setUserID(id);
		usersRepo.save(user);
		
		mv = new ModelAndView(new RedirectView("newsfeed", true));
		mv.addObject("user", user);
		mv.addObject("postsRepo", postsRepo);
		mv.setViewName("newsfeed.jsp");
		return mv;
	}
	
	@RequestMapping("/upload")
	public String upload() {
		System.out.println("GET: upload.jsp");
		return "upload.jsp";
	}
	
}
