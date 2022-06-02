<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        .center {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1>Please login</h1>
    <h3 style="color:red">${err }</h3>

    <form action="login" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td>
                    <input type="text" name="username" required="required" value="${cookie.username.value }"/><%-- đưa giá trị cookie vào đây khi save --%>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <input type="password" name="password" required="required" value="${cookie.password.value}"/><%-- đưa giá trị cookie vào đây khi save --%>
                </td>
            </tr>
            <tr>
                <td>Remember me</td>
                <td>
                    <input type="checkbox" name="remember" value="true">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Login"/>
                    <input type="reset" value="Clear"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>