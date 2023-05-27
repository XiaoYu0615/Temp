package servlet;

import Dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.解决中文乱码
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User user = userDao.checkUser(username, password);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("UserServlet").forward(request,response);
        }else{
            //用户不存在或者密码不对
            request.setAttribute("info","用户名或密码不正确");
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
