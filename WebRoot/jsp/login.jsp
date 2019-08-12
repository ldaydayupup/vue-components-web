<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>&nbsp; 
<!-- 判断是否登录 -->
<c:if test="${not empty sessionScope.user_name }">
恭喜您，已登录，请查询访问userinfo页面
<br>
<!-- 访问后台，获取用户列表信息  显示 -->
<a href="user?id=alluser">查询全部用户信息</a>
</c:if>

<c:if test="${empty sessionScope.user_name }">
<!-- form  进行登录 -->
<form name="form1" method="post" action="user?id=login">
    <h1 align="center">用户登录</h1>
    <table border="0" align="center">
      <tr> <td>用户名</td><td> <input type="text" name="name"></td></tr>
      <tr><td>密码</td><td > <input type="password" name="pwd"> </td></tr>
       <!--省略提交、取消按钮 -->
       <tr>
       <td><input type="submit" name=" " value="登录"></td>
       <td><input type="button" name=" " value="注册"></td>
       </tr>
     
    </table>
</form>
</c:if>

 <c:choose>
 <c:when test="${not empty sessionScope.user_name }">
 恭喜您，已登录，请查询访问userinfo页面
 </c:when>
 <c:when test="${empty sessionScope.user_name }">
 
 
 </c:when>
 </c:choose>
 
</body>
</html>