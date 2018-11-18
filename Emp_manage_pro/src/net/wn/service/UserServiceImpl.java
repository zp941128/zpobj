package net.wn.service;

import java.util.List;

import net.wn.entity.User;
import net.wn.util.BaseDao;
import net.wn.vo.EmployeeVo;

public class UserServiceImpl implements UserServiceI{


	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		BaseDao<User> bd=new BaseDao<>();
		String sql="SELECT * from user where account=? and password=?";
		User temp=bd.getOne(sql,User.class,user.getAccount(),user.getPassword());
		return temp;
	}

	

}
