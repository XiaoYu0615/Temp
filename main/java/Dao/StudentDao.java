package Dao;

import entity.User;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<User> getAllUser(){
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from student");
            ResultSet rs = stmt.executeQuery();

            //封装用户集合
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next()){
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
