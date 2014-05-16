<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>知识库系统使用协议 -- 知识库系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon" />
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
<link rel="stylesheet" type="text/css" href="css/register.css">
<link type="text/css" rel="stylesheet" href="./css/main.css" media="screen" charset="utf-8">
</head>

<body class="user-style ms-windows">
	<!-- body -->
	<jsp:include page="pagepart/head_protocal.jsp"></jsp:include>
	<!-- nav -->
	<div id="nav">
		<div class="nav-2">
			<div class="mod-nav clearfix">
				<h1 class="page-type-notab"></h1>
			</div>
		</div>
	</div>
	<div id="content">
		<div id="content-inner">
			<h3 style="text-align:center">《知识库系统使用协议》</h3>
			<p>
				&nbsp;&nbsp;&nbsp;&nbsp;本系统来自郑州轻工业学院计算机与通信工程学院计算机科学与技术10-01班谢先斌毕业设计，导师王岩。使用请联系作者，手机：13523591108，邮箱：xianbinxie@163.com、a.b@hotmail.com。
			
			</p>
		</div>
	</div>

	<!-- bottom -->
	<jsp:include page="pagepart/bottom.jsp"></jsp:include>
</body>
</html>
