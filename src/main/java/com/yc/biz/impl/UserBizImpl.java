package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;
@Service
public class UserBizImpl implements UserBiz {

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	public boolean register(User user) {
		baseDao.save(user, "saveUser");
		return true;
	}

	@Override
	public boolean validate(User user) {
		user=(User) baseDao.findOne(user, "isUserExists");
		if(user!=null){
			return true;
		}
		return false;
	}

	@Override
	public User getUserById(Integer id) {
		User u=new User();
		u.setId(id);
		return (User) baseDao.findOne(u, "getUserByLogin");
	}

	@Override
	public User login(User user) {
		User u=(User) baseDao.findOne(user, "getUserByLogin");
		return u;
	}

}
