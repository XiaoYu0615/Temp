<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!--jstl标签库-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<!--通过键获取域对象的值-->
<h1 style="color: aquamarine">Welcome,${user.username},您的密码是${user.password}</h1>
<a href="one.jsp">进入个人中心</a>
</body>
</html>