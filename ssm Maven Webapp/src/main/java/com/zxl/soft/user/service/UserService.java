package com.zxl.soft.user.service;

import java.util.List;

import com.zxl.soft.user.entity.User;

public interface UserService {
	public User getUserById(String id);
	public Boolean deleteUser(String id);
	public List<User> getUserList();
	public Boolean updateUser(User u);
}
