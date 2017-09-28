package jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import pojo.User;

public class MysqlUtil {
	//����Connection����
    Connection con;
   //����������
     String driver = "com.mysql.jdbc.Driver";
    //URLָ��Ҫ���ʵ����ݿ���mydata
   String url = "jdbc:mysql://localhost:3306/a_software";
    //MySQL����ʱ���û���
   String mysqlUser = "root";
     //MySQL����ʱ������
     String password = "123456";

     
     //�����û�
	public void saveUser(User user) {
		
         //������ѯ�����
         try {
             //������������
             Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
             con = DriverManager.getConnection(url,mysqlUser,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
             //Statement statement = con.createStatement();
             PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("insert into usertable (username,password) values(?,?)");//�����ݿ��в����һ������  
             //�滻ռλ����ֵ
             pstmt.setString(1, user.getUserName());
             pstmt.setString(2,user.getPassword());
             //pstmt.setLong(1, 1);
             //3.ResultSet�࣬������Ż�ȡ�Ľ��������
             pstmt.execute();
             
             con.close();
         } catch(ClassNotFoundException e) {   
             //���ݿ��������쳣����
             System.out.println("Sorry,can`t find the Driver!");   
             e.printStackTrace();   
             } catch(SQLException e) {
             //���ݿ�����ʧ���쳣����
             e.printStackTrace();  
             }catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }finally{
//             System.out.println("�����û��ɹ�����");
         }
     }
	
	
	  //��ѯ�û�
		public User getUser(User user) {
			User res=new User();
	         //������ѯ�����
	         try {
	             //������������
	             Class.forName(driver);
	            //1.getConnection()����������MySQL���ݿ⣡��
	             con = DriverManager.getConnection(url,mysqlUser,password);
	            if(!con.isClosed()){
//	                System.out.println("Succeeded connecting to the Database!");
	            }
	            
	            //2.����statement���������ִ��SQL��䣡��
	             //Statement statement = con.createStatement();
	             PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("select * from usertable where username=?");//�����ݿ��в����һ������  
	             //�滻ռλ����ֵ
	             pstmt.setString(1, user.getUserName());
	           
	             //3.ResultSet�࣬������Ż�ȡ�Ľ��������
	             ResultSet rs=pstmt.executeQuery();
	       
	             while(rs.next()){//���������
	            	 res.setUserName(rs.getString("username"));
	            	 res.setPassword(rs.getString("password"));
	          
	            }
	             
	             con.close();
	         } catch(ClassNotFoundException e) {   
	             //���ݿ��������쳣����
	             System.out.println("Sorry,can`t find the Driver!");   
	             e.printStackTrace();   
	             } catch(SQLException e) {
	             //���ݿ�����ʧ���쳣����
	             e.printStackTrace();  
	             }catch (Exception e) {
	             // TODO: handle exception
	             e.printStackTrace();
	         }finally{
//	             System.out.println("��ѯ�ɹ�����");
	         }
	         return res;
	     }
	
	

}
