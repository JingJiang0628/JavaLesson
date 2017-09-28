package game;

import java.util.Iterator;
import java.util.Scanner;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;

public class GoldenPoint {
	private GoldenPoint(){
		
	}

	public static void start(int peoNum,String username,int x){
		UserDao ud=new UserDaoImpl();
		System.out.println("请输入数据1-100：");
		Scanner sc=new Scanner(System.in);
		int goldenPoint=sc.nextInt();
		ud.findByName(username).setGameNumber(goldenPoint);
		
		int count=0;
		if(x==1){
			while(count<(peoNum-1)){
				int number=(int) (Math.random()*100)+1;
				User computer=new User();
				computer.setGameNumber(number);
				computer.setUserName("Computer"+count);
				ud.regist(0,computer);
				count++;
			}
			
		}
		
		Iterator<User> it1=ud.getArray().iterator();
		int count1=0;
		while(it1.hasNext()){
			User u=(User) it1.next();
			if(count1!=0){
				int number=(int) (Math.random()*100)+1;
				u.setGameNumber(number);
			}
			count1++;
		}
		
		Iterator<User> it=ud.getArray().iterator();
		float sum=0;
		while(it.hasNext()){
			User u=(User) it.next();
//			System.out.println("name--"+u.getUserName()+"num--"+u.getGameNumber());
			sum+=u.getGameNumber();
		}
		float point=sum/peoNum;
		System.out.println("黄金分割点为："+point);
		
		float result=0;
		float result1=0;
		for(int xx=0;xx<ud.getArray().size();xx++){
			User u=(User) ud.getArray().get(xx);
			float d=point-u.getGameNumber();
			if(xx==0){
				result=Math.abs(point-u.getGameNumber());
				result1=Math.abs(point-u.getGameNumber());
			}	
			if(Math.abs(d)<result){
				result=Math.abs(point-u.getGameNumber());
			}
			if(Math.abs(d)>result1){
				result1=Math.abs(point-u.getGameNumber());
			}
		}
		System.out.println("本轮赢家是：");
		for(int xx=0;xx<ud.getArray().size();xx++){
			User u=(User) ud.getArray().get(xx);
			float d=point-u.getGameNumber();	
			if(Math.abs(d)==result){
				//赢家分数+1
				int score1=u.getScore()+1;
				u.setScore(score1);
				System.out.println(u.getUserName()+"---赢家猜的数字是："+u.getGameNumber());
			}
		}
		
		System.out.println("本轮输家是：");
		for(int xx=0;xx<ud.getArray().size();xx++){
			User u=(User) ud.getArray().get(xx);
			float d=point-u.getGameNumber();	
			if(Math.abs(d)==result1){
				//输家分数-1
				int score2=u.getScore()-1;
				u.setScore(score2);
				System.out.println(u.getUserName()+"---输家猜的数字是："+u.getGameNumber());
			}
		}
		
	}
}
