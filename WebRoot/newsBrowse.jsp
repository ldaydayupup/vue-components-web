<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>新闻阅读</title>
<link href="./css/browse/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function btnComment(){
		var ccontent = document.getElementById("ccontent");
		if(ccontent.value==""){
			alert("评论不能为空");
			return false;
		}
	}

</script>

</head>
<body>

	<div id="header">
	<h3><a href="index.jsp">返回首页</a></h3>
		<div id="nav">
			<div id="logo">
				<img src="./img/browse/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="./img/browse/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">

		<div class="sidebar">
			<h1>
				<img src="./img/browse/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${requestScope.news1}" var="news">
						<li><a href="news?id=readNew&nid=${news.nid}">${news.ntitle}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="./img/browse/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${requestScope.news2}" var="news">
						<li><a href="news?id=readNew&nid=${news.nid}">${news.ntitle}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="./img/browse/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${requestScope.news3}" var="news">
						<li><a href="news?id=readNew&nid=${news.nid}">${news.ntitle}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>


		<div class="main">
			<div class="class_type">
				<img src="./img/browse/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="classlist">
					<table width="80%" align="center">

						<tr width="100%">
							<td colspan="2" align="center"><h3>${requestScope.newsBrowse.ntitle
									}</h3>
							</td>
						</tr>
						<tr>
							<td colspan="2"><hr></hr></td>
						</tr>
						<tr>
							<td align="center">作者：吕晓宇&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td align="left">发布时间：${requestScope.newsBrowse.ncreateDate}</td>
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2">${requestScope.newsBrowse.ncontent }</td>
						</tr>
						<tr>
							<td colspan="2"><hr></hr></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<table width="80%" align="center">
						<c:forEach items="${requestScope.comments}" var="comments">
							<tr>
								<td>留言人：</td>
								<td>${comments.cauthor }</td>
								<td>内容：</td>
								<td>${comments.ccontent }</td>
								<td>留言时间：</td>
								<td>${comments.cdate }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6"><hr></hr></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<form action="newsComments?opr=addComment" method="post"
						onsubmit="return btnComment()">
						<input type="hidden" id="nid" name="nid"
							value="${requestScope.newsBrowse.nid}" />
						<!-- 需要登录才可以评论 -->
						<c:choose>
							<c:when test="${not empty sessionScope.uname}">
								<table width="80%" align="center">
									<tr>
										<td>发表评论</td>
									</tr>
									<tr>
										<td>用户名：</td>
										<td><input type="text" id="cauthor" name="cauthor"
											value="${sessionScope.uname }"
											readonly="readonly" style="border:0px;" />
										</td>
									</tr>
									<tr>
										<td colspan="2"><textarea name="ccontent" id="ccontent"
												cols="70" rows="10"></textarea></td>
									</tr>
									<tr>
										<td><input name="submit" value="发  表" type="submit"/>
										</td>
									</tr>
								</table>
							</c:when>
							<c:when test="${empty sessionScope.uname }">
								<div align="center">
									<h3>
										登录才可发表评论，快去&nbsp;&nbsp;<a href="login.jsp">登录</a>&nbsp;&nbsp;吧
									</h3>
								</div>
							</c:when>
						</c:choose>



					</form>
				</ul>
			</div>
		</div>
	</div>

	<div id="friend">
		<h1 class="friend_t">
			<img src="./img/browse/friend_ico.gif" alt="合作伙伴" />
		</h1>
		<div class="friend_list">
			<ul>
				<li><a href="http://127.0.0.1:8080/news/#">百度</a></li>
				<li><a href="http://127.0.0.1:8080/news/#">谷歌</a></li>
				<li><a href="http://127.0.0.1:8080/news/#">新浪</a></li>
				<li><a href="http://127.0.0.1:8080/news/#">网易</a></li>
				<li><a href="http://127.0.0.1:8080/news/#">搜狐</a></li>
				<li><a href="http://127.0.0.1:8080/news/#">人人</a></li>
				<li><a href="http://127.0.0.1:8080/news/#">中国政府网</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p class="">
			24小时客户服务热线：010-68988888 &nbsp;&nbsp;&nbsp;&nbsp; <a
				href="http://127.0.0.1:8080/news/#">常见问题解答</a>
			&nbsp;&nbsp;&nbsp;&nbsp; 新闻热线：010-627488888 <br></br>
			文明办网文明上网举报电话：010-627488888 &nbsp;&nbsp;&nbsp;&nbsp; 举报邮箱： <a
				href="http://127.0.0.1:8080/news/#">jubao@jb-aptech.com.cn</a>
		</p>
		<p class="copyright">
			Copyright © 1999-2009 News China gov, All Right Reserver <br></br>
			新闻中国 版权所有
		</p>
	</div>




</body>
</html>