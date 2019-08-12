<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>新闻中国</title>
<link href="./css/main.css" rel="stylesheet" type="text/css" />

<!-- 判断request中是否5块数据（） -->
<c:if test="${requestScope.news1==null||requestScope.news2==null||requestScope.news3==null||
requestScope.news4==null||requestScope.news5==null}">
<!-- 请求IndexHttpServlet获取数据 -->
<jsp:forward page="index?id=getIndexdata" ></jsp:forward>
</c:if>

</head>

<body>
  
<div id="header">
  <div id="top_login">
  	<c:if test="${not empty sessionScope.uname}">
	<b>${sessionScope.uname }已登录</b>
	<c:choose>
	<c:when test="${not empty sessionScope.isAdmin}">
		<a href="newsManage.jsp">管理后台</a>
	</c:when>
	<c:when test="${empty sessionScope.isAdmin}">非会员</c:when>
	</c:choose>
	</c:if>
  <c:if test="${empty sessionScope.uname }">
    亲，在这里&nbsp;&nbsp;&nbsp;<a href="user?id=login">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    没有账号请点击&nbsp;&nbsp;&nbsp;<a href="user?id=reg">注册</a>
    </c:if>
  </div>
  <div id="nav">
    <div id="logo"> <img src="./img/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="./img/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">




  <div class="sidebar">
    <h1> <img src="./img/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${requestScope.news1}" var="news">
      	    <li><a href="news?id=readNew&nid=${news.nid}"><b>${news.ntitle}</b></a></li>
      	</c:forEach>	
      </ul>
    </div>
    <h1> <img src="./img/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${requestScope.news2}" var="news">
      	    <li><a href="news?id=readNew&nid=${news.nid}">${news.ntitle}</a></li>
      	</c:forEach>	
            
      </ul>
    </div>
    <h1> <img src="./img/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      	<c:forEach items="${requestScope.news3}" var="news">
      	    <li><a href="news?id=readNew&nid=${news.nid}">${news.ntitle}</a></li>
      	</c:forEach>
      </ul>
    </div>
  </div>

  <div class="main">
    <div class="class_type"> <img src="./img/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      
        <li id="class_month">
       	<c:forEach items="${requestScope.news4 }" var="topic">
       	<a href="index?id=listTitle&tid=${topic.tid}&pageno=0">${topic.tname}</a>
       	</c:forEach>
      </li>
      </ul>
      <ul class="classlist">
      
         	<c:forEach items="${requestScope.news5}" var="news">
      	    <li>
            <a href="news?id=readNew&nid=${news.nid}">${news.ntitle}</a>
            <span>${news.ncreateDate}</span>
            </li>
      	</c:forEach>
      	
     <c:choose>
     	<c:when test="${empty requestScope.tid }">
     		<p align="center"> 当前页数:[${requestScope.news6+1}/${requestScope.news7}]&nbsp;
      		<a href="index?id=getIndexdata&pageno=0&tid=${requestScope.tid }">首页</a>&nbsp;
     		 <c:if test="${(requestScope.news6+1)>1 }">
     		 <a href="index?id=getIndexdata&pageno=${requestScope.news6-1}&tid=${requestScope.tid }">上一页</a>&nbsp;
     		 </c:if>
     		 <c:if test="${(requestScope.news6+1)<requestScope.news7 }">
     		 <a href="index?id=getIndexdata&pageno=${requestScope.news6+1}&tid=${requestScope.tid }">下一页</a>&nbsp;
     		 </c:if>
     		 <a href="index?id=getIndexdata&pageno=${requestScope.news7}&tid=${requestScope.tid }">末页</a>
      
      </p>
     	</c:when>
     	<c:when test="${not empty requestScope.tid }">
     		 <p align="center"> 当前页数:[${requestScope.news6+1}/${requestScope.news7}]&nbsp;
  		   	 <a href="index?id=listTitle&pageno=0&tid=${requestScope.tid }">首页</a>&nbsp;
    		 <c:if test="${(requestScope.news6+1)>1 }">
    		 <a href="index?id=listTitle&pageno=${requestScope.news6-1}&tid=${requestScope.tid }">上一页</a>&nbsp;
    		 </c:if>
    		 <c:if test="${(requestScope.news6+1)<requestScope.news7 }">
    		 <a href="index?id=listTitle&pageno=${requestScope.news6+1}&tid=${requestScope.tid }">下一页</a>&nbsp;
    		 </c:if>
    		 <a href="index?id=listTitle&pageno=${requestScope.news7}&tid=${requestScope.tid }">末页</a>
      </p>
     	</c:when>
     </c:choose>
     
      </ul>
    </div>
    <div class="picnews">
  <ul>
    <li> <a href="index?id=listTitle&pageno=0&tid=2">
    <img src="./img/Picture1.jpg" width="249" alt="" /> 
    </a><a href="index?id=listTitle&pageno=0&tid=2">国际新闻</a> </li>
    <li> <a href="index?id=listTitle&pageno=0&tid=1">
    <img src="./img/Picture2.jpg" width="249" alt="" />
     </a><a href="index?id=listTitle&pageno=0&tid=1">国内新闻</a> </li>
    <li> <a href="index?id=listTitle&pageno=0&tid=7">
    <img src="./img/Picture3.jpg" width="249" alt="" /> 
    </a><a href="index?id=listTitle&pageno=0&tid=7">财经新闻</a> </li>
    <li> <a href="index?id=listTitle&pageno=0&tid=9">
    <img src="./img/Picture4.jpg" width="249" alt="" />
     </a><a href="index?id=listTitle&pageno=0&tid=9">健康新闻</a> </li>
  </ul>
</div>
  </div>
</div>
  <div id="friend">
  <h1 class="friend_t"> <img src="./img/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
	  <li> <a href="http://127.0.0.1:8080/news/#">百度</a> </li>
      <li> <a href="http://127.0.0.1:8080/news/#">谷歌</a> </li>
      <li> <a href="http://127.0.0.1:8080/news/#">新浪</a> </li>
      <li> <a href="http://127.0.0.1:8080/news/#">网易</a> </li>
      <li> <a href="http://127.0.0.1:8080/news/#">搜狐</a> </li>
      <li> <a href="http://127.0.0.1:8080/news/#">人人</a> </li>
      <li> <a href="http://127.0.0.1:8080/news/#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://127.0.0.1:8080/news/#">常见问题解答</a> &nbsp;&nbsp;&nbsp;&nbsp; 新闻热线：010-627488888 <br></br><a href="http://127.0.0.1:8080/news/#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright © 1999-2009 News China gov, All Right Reserver <br></br>
    新闻中国 版权所有 </p>
</div>





</body></html>