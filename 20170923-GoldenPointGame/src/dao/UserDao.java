package dao;

import java.util.ArrayList;

import pojo.User;

public interface UserDao {
	/*
	 * 这是用户登录功能
	 */
	public abstract boolean isLogin(String userName,String password);
	/*
	 * 这是用户注册功能
	 */
	public abstract void regist(int status,User user);
	/*
	 * 根据用户名找到用户
	 */
	public abstract User findByName(String username);
	/*
	 * 计算最终赢家输家
	 */
	public abstract void finalResult();
	
	public abstract ArrayList<User> getArray();
}
