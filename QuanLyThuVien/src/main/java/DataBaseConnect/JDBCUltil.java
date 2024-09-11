
package DataBaseConnect;

import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUltil {
    public static Connection getConnection(){
        
        Connection connection = null;
        try {
            //Thông số
            String url = "jdbc:mysql://localhost:3306/qltv";
            String user = "root";
            String passwd = "1234";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Tạo kết nối
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.out.println("Connect Failed");
            e.printStackTrace();
        }   
        return connection;              
    }
    
    //Hủy kết nối
    public static void CloseConnection(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Not Exsit");
            e.printStackTrace();
        }
    }


}
