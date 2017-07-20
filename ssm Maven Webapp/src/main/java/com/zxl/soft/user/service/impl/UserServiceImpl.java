package com.zxl.soft.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxl.soft.user.dao.UserMapper;
import com.zxl.soft.user.entity.User;
import com.zxl.soft.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean deleteUser(String id) {
		try {
			userMapper.deleteByPrimaryKey(id);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	@Override
	public List<User> getUserList() {
		return null;
	}

	@Override
	public Boolean updateUser(User u) {
		return null;
	}
}
