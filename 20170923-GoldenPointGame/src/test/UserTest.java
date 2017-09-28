package test;

import java.util.Scanner;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import game.GoldenPoint;
import pojo.User;

public class UserTest {
	public static void main(String[] args) {
		while(true){
		System.out.println("----------欢迎光临---------");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.退出");
		System.out.println("请输入你的选择：");
		
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		UserDao ud=new UserDaoImpl();
		
		switch (str) {
		case "1":
			System.out.println("----------登录界面---------");
			System.out.println("请输入用户名：");
			String username=sc.nextLine();
			System.out.println("请输入密码：");
			String password=sc.nextLine();
			
			boolean flag=ud.isLogin(username, password);
			if(flag){
				String name=username;
				System.out.println("要玩游戏吗？y/n");
				int x=1;
				int peoNum=0;
				while(true){
					String resultString=sc.nextLine();
					//boolean flag1=false;
					if(resultString.equalsIgnoreCase("y")){
					if(x==1){
						System.out.println("请选择玩家人数：");
						System.out.println("1.10人");
						System.out.println("2.20人");
						System.out.println("3.50人");
						System.out.println("请输入你的选择：");
						Scanner sc1=new Scanner(System.in);
						int peoNum1=sc1.nextInt();
						peoNum=peoNum1;
						switch(peoNum){
						case 1:
							peoNum=10;
							break;
						case 2:
							peoNum=20;
							break;
						case 3:
							peoNum=50;
							break;
						default:
							System.out.println("输入错误，请输入正确序号！");
							break;
						}
					}
					
					GoldenPoint.start(peoNum,name,x);
					x++;
					System.out.println("还玩第"+x+"局吗？y/n");
				}else{
					break;
				}
				}
				ud.finalResult();
				System.out.println("谢谢使用！");
				System.exit(0);
			}
			break;
		case "2":
			System.out.println("----------注册界面---------");
			System.out.println("请输入用户名：");
			String newUsername=sc.nextLine();
			System.out.println("请输入密码：");
			String newPassword=sc.nextLine();
			
			User user=new User();
			user.setUserName(newUsername);
			user.setPassword(newPassword);
			
			ud.regist(1,user);
			System.out.println("注册成功！");
			break;
		case "3":	
		default:
			System.out.println("谢谢使用，欢迎下次再来！");
			System.exit(0);
			break;
		}
		
		}
		
	}
}
