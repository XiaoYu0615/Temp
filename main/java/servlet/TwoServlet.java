package servlet;

import entity.User;
import utils.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "TwoServlet", value = "/TwoServlet")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //解决post提交中文乱码问题
       request.setCharacterEncoding("utf-8");
        //获取浏览器提交的参数
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);

        try {
            Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from student where username=? and  password=?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //同户名放到session域
                //得到session

                //同户名放到session域
                //得到session
                //HttpSession session = request.getSession();
                //session.setAttribute("username",username);

                //request.setAttribute("username",username);
                // request.setAttribute("password",password);

                User user = new User();
                user.setUsername(username);
                user.setPassword(password);

                request.setAttribute("user",user);

                request.getRequestDispatcher("student-list.jsp").forward(request,response);

            }else{
                response.sendRedirect("failure.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
