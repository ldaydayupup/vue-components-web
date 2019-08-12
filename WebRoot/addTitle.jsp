<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0050)http://127.0.0.1:8080/news/newspages/topic_add.jsp -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>添加主题--管理后台</title>
<link href="./css/admin/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");

		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
</script>
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="./img/admin/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="./img/admin/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： ${sessionScope.uname }  &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <div id="opt_list">
  <ul>
    <li><a href="news?id=addNews">添加新闻</a></li>
    <li><a href="news?id=newsManage">编辑新闻</a></li>
    <li><a href="addTitle.jsp">添加主题</a></li>
    <li><a href="news?id=titleManage">编辑主题</a></li>
  </ul>
</div>

  <div id="opt_area">
    <h1 id="opt_type"> 添加主题： </h1>
    <form action="news?id=addTitle" method="post" onsubmit="return check()">
      <p>
        <label> 主题名称 </label>
        <input name="tname" type="text" class="opt_input" id="tname" />
      </p>
      <input name="action" type="hidden" value="addtopic" />
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <div id="site_link"> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">关于我们</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">Aboue Us</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">联系我们</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">广告服务</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">供稿服务</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">法律声明</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">招聘信息</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">网站地图</a><span>|</span> <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">常见问题解答</a> &nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<br></br>
    文明办网文明上网举报电话：010-627488888  &nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<a href="http://127.0.0.1:8080/news/newspages/topic_add.jsp#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright © 1999-2009 News China gov, All Right Reserver<br></br>
    新闻中国   版权所有</p>
</div>


</div>


</body></html>