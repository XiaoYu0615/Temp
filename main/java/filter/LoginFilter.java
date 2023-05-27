package filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //1.判断session有没有user
        //(1) 强转为HttpServletRequest
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        //（2）得到session
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        //(3) 判断  如果访问路径携带了login字符串，直接放行
        String uri = req.getRequestURI();
        if (user!=null||uri.contains("Login")||uri.contains("login")){
            //登陆过的 放行
            chain.doFilter(request, response);
        }else{
            req.setAttribute("info","非法访问, 请登录");
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
