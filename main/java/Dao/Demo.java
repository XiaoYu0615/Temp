package Dao;

import java.sql.*;


public class Demo {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.得到连接对象
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/javaweb?serverTimezone=Asia/Shanghai",
                        "root",
                        "299642"
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //3.得到预执行对象
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement("insert into student(sname,age) values ('xiaomin',3)");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //4.执行
            try {
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //5.关闭资源
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
