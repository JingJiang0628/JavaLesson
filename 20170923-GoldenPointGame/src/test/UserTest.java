package test;

import java.util.Scanner;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import game.GoldenPoint;
import pojo.User;

public class UserTest {
	public static void main(String[] args) {
		while(true){
		System.out.println("----------��ӭ����---------");
		System.out.println("1.��¼");
		System.out.println("2.ע��");
		System.out.println("3.�˳�");
		System.out.println("���������ѡ��");
		
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		
		UserDao ud=new UserDaoImpl();
		
		switch (str) {
		case "1":
			System.out.println("----------��¼����---------");
			System.out.println("�������û�����");
			String username=sc.nextLine();
			System.out.println("���������룺");
			String password=sc.nextLine();
			
			boolean flag=ud.isLogin(username, password);
			if(flag){
				String name=username;
				System.out.println("Ҫ����Ϸ��y/n");
				int x=1;
				int peoNum=0;
				while(true){
					String resultString=sc.nextLine();
					//boolean flag1=false;
					if(resultString.equalsIgnoreCase("y")){
					if(x==1){
						System.out.println("��ѡ�����������");
						System.out.println("1.10��");
						System.out.println("2.20��");
						System.out.println("3.50��");
						System.out.println("���������ѡ��");
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
							System.out.println("���������������ȷ��ţ�");
							break;
						}
					}
					
					GoldenPoint.start(peoNum,name,x);
					x++;
					System.out.println("�����"+x+"����y/n");
				}else{
					break;
				}
				}
				ud.finalResult();
				System.out.println("ллʹ�ã�");
				System.exit(0);
			}
			break;
		case "2":
			System.out.println("----------ע�����---------");
			System.out.println("�������û�����");
			String newUsername=sc.nextLine();
			System.out.println("���������룺");
			String newPassword=sc.nextLine();
			
			User user=new User();
			user.setUserName(newUsername);
			user.setPassword(newPassword);
			
			ud.regist(1,user);
			System.out.println("ע��ɹ���");
			break;
		case "3":	
		default:
			System.out.println("ллʹ�ã���ӭ�´�������");
			System.exit(0);
			break;
		}
		
		}
		
	}
}
