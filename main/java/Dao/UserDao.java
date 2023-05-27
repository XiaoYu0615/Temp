package Dao;

import entity.User;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public User checkUser(String username,String password){

        try{
            Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from student where username=? and  password=?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                User user = new User();
//                user.setSid(rs.getInt("sid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUser(){
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from student");
            ResultSet rs = stmt.executeQuery();

            //封装用户集合
            ArrayList<User> list = new ArrayList<User>();

            while(rs.next()){
                User user = new User();
                user.setSid(rs.getInt("sid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }

            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
