package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ThreeServlet", value = "/ThreeServlet")
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断cookie是否键为info是否有值
        //1.获取到所有cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            //2.遍历数组 增强for
            for(Cookie cookie:cookies){
                //1.取到每一个cookie的键值
                String name = cookie.getName();
                String value = cookie.getValue();

                if("info".equals(name)){
                    //已经有cookie-xm
                    System.out.println(name+"-"+value);
                }else{
                    //没有
                    Cookie cookie1 = new Cookie("info","xm#123");
                    cookie1.setMaxAge(120);
                    cookie1.setPath("/ThreeServlet");
                    response.addCookie(cookie1);
                }
            }
        }else{
            Cookie cookie1 = new Cookie("info","xm#123");
            cookie1.setMaxAge(120);
            cookie1.setPath("/ThreeServlet");
            response.addCookie(cookie1);

        }


        request.getRequestDispatcher("success.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
