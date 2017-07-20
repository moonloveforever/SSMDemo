package com.zxl.soft.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxl.soft.user.entity.User;
import com.zxl.soft.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	private String login(@RequestParam("userId") String userId,
			@RequestParam("password") String password, Model model) {
		User u = userService.getUserById(userId);
		if (null != u) {
			if (password.equals(u.getPassword())) {
				model.addAttribute("flag", "true");
			} else {
				model.addAttribute("flag", "false");
			}
		}
		return null;
	}
}
