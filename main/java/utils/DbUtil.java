package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {

    public static Connection getConnection() throws Exception{
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.得到连接对象
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/javaweb?serverTimezone=Asia/Shanghai",
                "root",
                "299642"
        );
        return conn;
    }

    public static void releaseResource(Connection conn, Statement stat, ResultSet  rs){
        try{
            if (rs!=null)
            {
                rs.close();
            }
            stat.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
