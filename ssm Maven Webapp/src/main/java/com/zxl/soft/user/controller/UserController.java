package com.zxl.soft.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxl.soft.user.entity.User;
import com.zxl.soft.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/success")
	private String success() {
		return "WEB-INF/jsp/main";
	}
	
	@RequestMapping(value = "/error")
	private String error() {
		return "login";
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(){
	    ModelAndView mav=new ModelAndView("main");
	    return mav;
	}
	
	/**
	 * 登录方法
	 * @param userId
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login.do", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody String  login(@RequestParam("userId") String userId,
			@RequestParam("password") String password,HttpServletRequest request) {
		String json = "{\"type\":";
		User u = userService.getUserById(userId);
		if (null != u) {
			if (password.equals(u.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("User", u);
				json = json +"\"success\"}";
			} else{
				json = json +"\"error\"}";
			}
		}
		System.out.println(json);
		return json;
	}
}
