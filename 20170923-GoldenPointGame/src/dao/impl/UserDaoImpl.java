package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import jdbc_connect.MysqlUtil;
import pojo.User;

public class UserDaoImpl implements UserDao {
	//多个对象共享一个成员变量，用静态
		private static List<User> array=new ArrayList<User>();
		
		@Override
		public boolean isLogin(String username, String password) {
			boolean flag=false;
			
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			MysqlUtil m = new MysqlUtil();
			User res = m.getUser(user);
			if(res ==null){
				System.out.println("抱歉，用户不存在!!!");
			}else{
				if(res.getPassword().equals(password)){
					System.out.println("登录成功!");
					array.add(user);
					flag =  true;
				}else{
					System.out.println("密码输入错误！");
				}
			}
			
			return flag;
		}

		@Override
		public void regist(int status,User user) {
			
			if(status==0){
//				System.out.println("name--"+user.getUserName()+"num--"+user.getGameNumber());
			array.add(user);
			}
			else{
//				System.out.println("name--"+user.getUserName()+"num--"+user.getGameNumber());
				array.add(user);
				MysqlUtil m = new MysqlUtil();
				m.saveUser(user);
			}

		}
		public User findByName(String username){
			User user=new User();
			for(User u:array){
				if(u.getUserName().equals(username)){
					user=u;
				}
			}
			return user;
		}

		@Override
		public void finalResult() {
			int score1=0;
			int loser=0; 
			int winner=0;
			int count=0;
			//找出最高分数和最低分数
			for(User u:array){
				score1=u.getScore();
				if(count==0){
					loser=score1;
					winner=score1;
				}
				if(score1<loser){
					loser=score1;
				}
				if(score1>winner){
					winner=score1;
				}
				count++;
			}
			//赢家的名字
			System.out.println("***********");
			System.out.println("最终赢家是：");
			for(User u:array){
				if(u.getScore()==winner){
					System.out.println(u.getUserName());
				}
			}
			System.out.println("赢家分数为："+winner);
			//输家的名字
			System.out.println("***********");
			System.out.println("最终输家是：");
			for(User u:array){
				if(u.getScore()==loser){
					System.out.println(u.getUserName());
				}
			}
			System.out.println("输家分数为："+loser);
		}

		@Override
		public ArrayList<User> getArray() {
			return (ArrayList<User>) array;
		}
		
}
