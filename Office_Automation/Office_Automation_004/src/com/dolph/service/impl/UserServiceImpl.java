package com.dolph.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.Dao.RoleDao;
import com.dolph.Dao.UserDao;
import com.dolph.model.Role;
import com.dolph.model.User;
import com.dolph.model.UserRoles;
import com.dolph.service.UserService;
import com.dolph.vo.PageVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	private RoleDao roleDao;
	private UserDao userDao;
	
	@Override
	public PageVo findPersonUsers(String sSearch) {
		try {
			sSearch = new String(sSearch.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return userDao.findPersonUsers(sSearch);
	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public void addUser(User user, int[] roleIds) {
		userDao.save(user);
		if("".equals(user.getUsername())){
			throw new RuntimeException("用户名不能为空");
		}
		if(roleIds!=null){
			for(int id:roleIds){
				UserRoles userRoles=new UserRoles();
				userRoles.setUser(user);
				userRoles.setRole(roleDao.findById(Role.class, id));
				userDao.save(userRoles);
			}
		}

	}

	@Override
	public void delUser(int id) {
		userDao.dalete(this.findUserById(id));
	}

	@Override
	public User findUserById(int id) {
		return userDao.findById(User.class,id);
	}

	@Override
	public List<Role> findRoleIdsOfUser(int userId) {
		return userDao.findRoleIdsOfUser(userId);
	}

	@Override
	public void updateUser(User user, int[] roleIds) {
		if("".equals(user.getUsername())){
			throw new RuntimeException("用户名不能为空");
		}
		userDao.update(user,roleIds);

	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);

	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List findPersonWtihUsers(String sSearch) {
		if(sSearch==null) sSearch="";
		try {
			sSearch = new String(sSearch.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return userDao.findPersonWithUsers(sSearch);
	}

	@Override
	public User login(String username, String password) {
		User user=userDao.findUserByUsername(username);
		if(user==null){
			throw new RuntimeException("用户不存在");
		}
		if(!user.getPassword().equals(password)){
			throw new RuntimeException("密码错误");
		}
		return user;
	}

}
