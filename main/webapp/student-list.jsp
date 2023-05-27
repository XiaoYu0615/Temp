<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!--jstl标签库-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student-list</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.sid}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><a href="#">修改</a><a href="#"> </a><a href="#">删除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

<style>
    table,tr,th,td {
        border: 1px solid #666666;
        padding: 5px;
    }
    table{
        padding: 0;
        margin:10px auto;
    }
</style>
