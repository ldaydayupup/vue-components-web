<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>用户注册</title>
<script type="text/javascript">
	function btnUser(){
		var name = document.getElementById("username");
		if(name.value==""){
			alert("用户名不能为空");
			return false;
		}
		var password = document.getElementById("password");
		if(password.value==""){
			alert("密码不能为空");
			return false;
		}
	}

</script>

  </head>
  
  <body>
  	<h1 style="color:yellow;font-size: 100px;" align="center">用户注册</h1>
  	<hr>
  	<!--
  		1.post:安全
  		2.大段文本用post
  		3.文件上传
  		
  		a.地址栏，超链接都是get 
  	 -->
    <div align="center">
    	<form id="fileServlet" name="loginForm" 
    		method="post" action="loginServlet?id=reg" onsubmit="return btnUser()">
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
	    	<input type="submit" style="height: 30px;width: 80px;" value="注册"/>
	    </form>
    </div>
    <hr>
  </body>
</html>
