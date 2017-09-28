package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import jdbc_connect.MysqlUtil;
import pojo.User;

public class UserDaoImpl implements UserDao {
	//���������һ����Ա�������þ�̬
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
				System.out.println("��Ǹ���û�������!!!");
			}else{
				if(res.getPassword().equals(password)){
					System.out.println("��¼�ɹ�!");
					array.add(user);
					flag =  true;
				}else{
					System.out.println("�����������");
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
			//�ҳ���߷�������ͷ���
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
			//Ӯ�ҵ�����
			System.out.println("***********");
			System.out.println("����Ӯ���ǣ�");
			for(User u:array){
				if(u.getScore()==winner){
					System.out.println(u.getUserName());
				}
			}
			System.out.println("Ӯ�ҷ���Ϊ��"+winner);
			//��ҵ�����
			System.out.println("***********");
			System.out.println("��������ǣ�");
			for(User u:array){
				if(u.getScore()==loser){
					System.out.println(u.getUserName());
				}
			}
			System.out.println("��ҷ���Ϊ��"+loser);
		}

		@Override
		public ArrayList<User> getArray() {
			return (ArrayList<User>) array;
		}
		
}
