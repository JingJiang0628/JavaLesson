package jdbc_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import pojo.User;

public class MysqlUtil {
	//声明Connection对象
    Connection con;
   //驱动程序名
     String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
   String url = "jdbc:mysql://localhost:3306/a_software";
    //MySQL配置时的用户名
   String mysqlUser = "root";
     //MySQL配置时的密码
     String password = "123456";

     
     //保存用户
	public void saveUser(User user) {
		
         //遍历查询结果集
         try {
             //加载驱动程序
             Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
             con = DriverManager.getConnection(url,mysqlUser,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
             //Statement statement = con.createStatement();
             PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("insert into usertable (username,password) values(?,?)");//想数据库中插入第一组数据  
             //替换占位符的值
             pstmt.setString(1, user.getUserName());
             pstmt.setString(2,user.getPassword());
             //pstmt.setLong(1, 1);
             //3.ResultSet类，用来存放获取的结果集！！
             pstmt.execute();
             
             con.close();
         } catch(ClassNotFoundException e) {   
             //数据库驱动类异常处理
             System.out.println("Sorry,can`t find the Driver!");   
             e.printStackTrace();   
             } catch(SQLException e) {
             //数据库连接失败异常处理
             e.printStackTrace();  
             }catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }finally{
//             System.out.println("保存用户成功！！");
         }
     }
	
	
	  //查询用户
		public User getUser(User user) {
			User res=new User();
	         //遍历查询结果集
	         try {
	             //加载驱动程序
	             Class.forName(driver);
	            //1.getConnection()方法，连接MySQL数据库！！
	             con = DriverManager.getConnection(url,mysqlUser,password);
	            if(!con.isClosed()){
//	                System.out.println("Succeeded connecting to the Database!");
	            }
	            
	            //2.创建statement类对象，用来执行SQL语句！！
	             //Statement statement = con.createStatement();
	             PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("select * from usertable where username=?");//想数据库中插入第一组数据  
	             //替换占位符的值
	             pstmt.setString(1, user.getUserName());
	           
	             //3.ResultSet类，用来存放获取的结果集！！
	             ResultSet rs=pstmt.executeQuery();
	       
	             while(rs.next()){//遍历结果集
	            	 res.setUserName(rs.getString("username"));
	            	 res.setPassword(rs.getString("password"));
	          
	            }
	             
	             con.close();
	         } catch(ClassNotFoundException e) {   
	             //数据库驱动类异常处理
	             System.out.println("Sorry,can`t find the Driver!");   
	             e.printStackTrace();   
	             } catch(SQLException e) {
	             //数据库连接失败异常处理
	             e.printStackTrace();  
	             }catch (Exception e) {
	             // TODO: handle exception
	             e.printStackTrace();
	         }finally{
//	             System.out.println("查询成功！！");
	         }
	         return res;
	     }
	
	

}
