<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>登录</title>

  </head>
  
  <body>
  	<h1 style="color:yellow;font-size: 100px;" align="center">用户登录</h1>
  	<hr>
  	<!--
  		1.post:安全
  		2.大段文本用post
  		3.文件上传
  		
  		a.地址栏，超链接都是get 
  	 -->


  	 <div align="center">
    	<form id="fileServlet" name="loginForm" 
    		method="post" action="loginServlet?id=login">
	    	<table border="1">
	    		<tr>
	    			<td>用户名：</td>
	    			<td><input type="text" id="username" name="username"/></td>
	    		</tr>
	    		<tr>
	    			<td>密码：</td>
	    			<td><input type="password" id="password" name="password"/></td>
	    		</tr>
	    	</table>
	    	<input type="submit" style="height: 30px;width: 80px;" value="登录"/>
	    	还没有账号，立即&nbsp;&nbsp;<a href="user?id=reg">注册</a>&nbsp;吧
	    </form>
    </div>
    <hr>
    
    
  </body>
</html>
