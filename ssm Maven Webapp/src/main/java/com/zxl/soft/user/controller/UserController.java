package com.zxl.soft.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxl.soft.user.entity.User;
import com.zxl.soft.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	private String login(@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		String page = "";
		User u = userService.getUserById(userId);
		if (null != u) {
			if (password.equals(u.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("User", u);
				System.out.println(u.getId());
				page = "jsp/main";
			} else {
				page = "login";
			}
		}
		System.out.println(page);
		return page;
	}
	
	@RequestMapping(value="jsp/main")
	private String test(){
		System.out.println("1111111111111");
		return null;
	}
}
