package dao;

import java.util.ArrayList;

import pojo.User;

public interface UserDao {
	/*
	 * �����û���¼����
	 */
	public abstract boolean isLogin(String userName,String password);
	/*
	 * �����û�ע�Ṧ��
	 */
	public abstract void regist(int status,User user);
	/*
	 * �����û����ҵ��û�
	 */
	public abstract User findByName(String username);
	/*
	 * ��������Ӯ�����
	 */
	public abstract void finalResult();
	
	public abstract ArrayList<User> getArray();
}
